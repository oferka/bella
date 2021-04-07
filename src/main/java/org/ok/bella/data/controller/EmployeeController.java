package org.ok.bella.data.controller;

import org.ok.bella.data.service.EmployeeService;
import org.ok.bella.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

import static org.ok.bella.data.controller.Paths.COUNT_PATH;
import static org.ok.bella.data.controller.Paths.EMPLOYEE_PATH;

@RestController
@RequestMapping(path = EMPLOYEE_PATH)
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

    @GetMapping(path = COUNT_PATH)
    public ResponseEntity<Long> count() {
        long count = employeeService.count();
        return ResponseEntity.ok(count);
    }
}
