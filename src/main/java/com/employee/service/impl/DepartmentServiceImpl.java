package com.employee.service.impl;

import com.employee.dto.Department_Dto;
import com.employee.entity.Department;
import com.employee.exception.ResourcenotfoundException;
import com.employee.mapper.Department_mapper;
import com.employee.repository.Department_repo;
import com.employee.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private Department_repo departmentRepo;
    @Override
    public Department_Dto createDepartment(Department_Dto departmentDto) {
        Department department = Department_mapper.mapToDepartment(departmentDto);
       Department savedDeparatment= departmentRepo.save(department);
        return Department_mapper.mapToDepartmentDto(savedDeparatment);

    }

    @Override
    public Department_Dto getDepartmentByid(Long departmentid) {

        Department department =departmentRepo.findById(departmentid).orElseThrow(
                ()-> new ResourcenotfoundException("Department is not exist given id" +departmentid));
        return Department_mapper.mapToDepartmentDto(department);
    }

    @Override
    public List<Department_Dto> getalldepartments() {
        List<Department> departments= departmentRepo.findAll();
        return departments.stream().map(department -> Department_mapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }
}
