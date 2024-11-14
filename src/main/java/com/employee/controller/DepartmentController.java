package com.employee.controller;

import com.employee.dto.Department_Dto;
import com.employee.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<Department_Dto> createDepartment(@RequestBody  Department_Dto departmentDto){
        Department_Dto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    @GetMapping("{id}")

    public ResponseEntity<Department_Dto> getdepartmentbyid(@PathVariable("id") Long departmentid){
        Department_Dto departmentDto =departmentService.getDepartmentByid(departmentid);
        return ResponseEntity.ok(departmentDto);
    }
    @GetMapping("/all")

    public ResponseEntity<List<Department_Dto>> getallDepartments(){
        List<Department_Dto> departments =  departmentService.getalldepartments();
        return ResponseEntity.ok(departments);
    }

}
