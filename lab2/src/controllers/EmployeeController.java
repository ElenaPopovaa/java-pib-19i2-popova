package com.example.lab2.controllers;

import com.example.lab2.entities.EmployeeEntity;
import com.example.lab2.models.Employee;
import com.example.lab2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private ArrayList<EmployeeEntity> emps = new ArrayList<EmployeeEntity>

    @PostMapping("/add")
    public ResponseEntity addEmploee(@RequestBody EmployeeEntity employee) {
        try {
            emps.add(employee);
            return ResponseEntity.ok("Сотрудник сохранен");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e);
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeById(@PathVariable("id") int id) {
        try {
            for (var emp : emps) {
                if (emp.getId == id)
                    emp == null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(emps);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") int id) {
        try {
            for (var emp : emps) {
                if (emp.getId == id)
                    return ResponseEntity.ok(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
