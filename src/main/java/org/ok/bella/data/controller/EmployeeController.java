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
public class EmployeeController extends AbstractController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Find all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employees found", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Employee.class)))}),
            @ApiResponse(responseCode = "400", description = "Failed to find employees", content = @Content) }
            )
    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> allItems = employeeService.findAll();
        return ResponseEntity.ok(allItems);
    }

    @Operation(summary = "Find an employee by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found by id", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class))}),
            @ApiResponse(responseCode = "400", description = "Failed to find employee by id", content = @Content) })
    @GetMapping(value = "{id}")
    public ResponseEntity<Employee> findById(@Parameter(description = "The id of the employee to be found") @PathVariable("id") String id) {
        Optional<Employee> employee = employeeService.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody @Valid Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        URI location = linkTo(EmployeeController.class).slash(employee.getId()).toUri();
        httpHeaders.setLocation(location);
        Employee saved;
        try {
            saved = employeeService.save(employee);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(saved, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        try {
            employeeService.deleteById(id);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") String id, @RequestBody Employee employee) {
        boolean isPresent = employeeService.existsById(id);
        if (!isPresent) {
            return ResponseEntity.notFound().build();
        }
        Employee updated = employeeService.save(employee);
        return ResponseEntity.ok(updated);
    }

    @GetMapping(path = COUNT_PATH)
    public ResponseEntity<Long> count() {
        long count = employeeService.count();
        return ResponseEntity.ok(count);
    }
}
