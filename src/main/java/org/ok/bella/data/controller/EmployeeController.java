package org.ok.bella.data.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.ok.bella.data.service.EmployeeService;
import org.ok.bella.model.Employee;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.ok.bella.data.controller.Paths.COUNT_PATH;
import static org.ok.bella.data.controller.Paths.EMPLOYEE_PATH;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(path = EMPLOYEE_PATH)
@Tag(name = "employee", description = "the employee API")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Find all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employees successfully found", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Employee.class)))}),
            @ApiResponse(responseCode = "400", description = "Failed to find employees", content = @Content) }
            )
    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> allItems = employeeService.findAll();
        return ResponseEntity.ok(allItems);
    }

    @Operation(summary = "Find an employee by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee successfully found by id", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class))}),
            @ApiResponse(responseCode = "404", description = "Employee with specified id was not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Failed to find employee by id", content = @Content) })
    @GetMapping(value = "{id}")
    public ResponseEntity<Employee> findById(@Parameter(description = "The id of the employee to be found") @PathVariable("id") String id) {
        Optional<Employee> employee = employeeService.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create an employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class))}),
            @ApiResponse(responseCode = "400", description = "Failed to create an employee", content = @Content) })
    @PostMapping
    public ResponseEntity<Employee> save(@Parameter(description = "Employee to be saved") @RequestBody @Valid Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        URI location = linkTo(EmployeeController.class).slash(employee.getId()).toUri();
        httpHeaders.setLocation(location);
        Employee saved = employeeService.save(employee);
        return new ResponseEntity<>(saved, httpHeaders, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete an employee by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Employee successfully deleted by id"),
            @ApiResponse(responseCode = "400", description = "Failed to delete employee by id", content = @Content) })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@Parameter(description = "The id of the employee to be deleted") @PathVariable("id") String id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update an employee by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class))}),
            @ApiResponse(responseCode = "404", description = "Employee with specified id was not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Failed to update an employee with specified id", content = @Content) })
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@Parameter(description = "The id of the employee to be updated") @PathVariable("id") String id, @Parameter(description = "Employee to be updated") @RequestBody Employee employee) {
        boolean isPresent = employeeService.existsById(id);
        if (!isPresent) {
            return ResponseEntity.notFound().build();
        }
        Employee updated = employeeService.save(employee);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Return the number of existing employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee counted successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))}),
            @ApiResponse(responseCode = "400", description = "Failed to count employees", content = @Content) })
    @GetMapping(path = COUNT_PATH)
    public ResponseEntity<Long> count() {
        long count = employeeService.count();
        return ResponseEntity.ok(count);
    }
}
