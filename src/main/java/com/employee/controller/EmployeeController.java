package com.employee.controller;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private EmployeeService employeeservice;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee= employeeservice.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

@GetMapping("{id}")
    public  ResponseEntity<EmployeeDto> getemployeeById(@PathVariable("id") Long employeeid){
        EmployeeDto employee = employeeservice.getemployeebyid(employeeid);
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/all")

    public ResponseEntity<List<EmployeeDto>> getallemployees(){
        List<EmployeeDto> employees = employeeservice.getallemployees();
        return ResponseEntity.ok(employees);


    }
    @PutMapping("{id}")

    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeid,@RequestBody EmployeeDto updatedemployee){
        EmployeeDto employeeDto= employeeservice.updateEmployee(employeeid,updatedemployee);
        return  ResponseEntity.ok(employeeDto);
    }
    @DeleteMapping("{id}")

    public ResponseEntity<String> deleteemployee(@PathVariable("id") Long employeeid){
        employeeservice.deleteemployee(employeeid);
        return ResponseEntity.ok("employee deleted successfully");

    }
}
