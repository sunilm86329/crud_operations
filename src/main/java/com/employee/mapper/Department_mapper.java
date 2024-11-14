package com.employee.mapper;

import com.employee.dto.Department_Dto;
import com.employee.entity.Department;

public class Department_mapper {

    // convert department jpa entity to department dto
    public static Department_Dto mapToDepartmentDto(Department department){
        return new Department_Dto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentdesc()
        );
    }

    // convert department dto into department jpa entity

    public static Department mapToDepartment(Department_Dto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentdesc()
        );
    }
}
