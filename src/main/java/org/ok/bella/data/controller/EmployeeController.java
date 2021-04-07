package org.ok.bella.data.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.ok.bella.data.service.EmployeeService;
import org.ok.bella.model.Employee;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping
    public ResponseEntity<Iterable<Employee>> findAll() {
        Iterable<Employee> allItems = employeeService.findAll();
        return ResponseEntity.ok(allItems);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") String id) {
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
