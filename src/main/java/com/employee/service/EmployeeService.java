package com.employee.service;

import com.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getemployeebyid(Long employeeid);

    List<EmployeeDto> getallemployees();
    EmployeeDto updateEmployee(Long employeeid, EmployeeDto updatedemployee);
    void deleteemployee(Long employeeid);

}
