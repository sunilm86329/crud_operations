package com.employee.service.impl;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.exception.ResourcenotfoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepo;
import com.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getemployeebyid(Long employeeid) {
        Employee employee= employeeRepo.findById(employeeid).orElseThrow(()-> new ResourcenotfoundException("employee not found givenm id"+ employeeid));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getallemployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(((employee) -> EmployeeMapper.mapToEmployeeDto(employee))).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeid, EmployeeDto updatedemployee) {
       Employee employee= employeeRepo.findById(employeeid).orElseThrow(() -> new ResourcenotfoundException("employee not found"+employeeid));
       employee.setFirstname(updatedemployee.getFirstname());
       employee.setLastname(updatedemployee.getLastname());
       employee.setEmail(updatedemployee.getEmail());
       Employee updatedemployeeobj = employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedemployeeobj) ;
    }

    @Override
    public void deleteemployee(Long employeeid) {
        Employee employee= employeeRepo.findById(employeeid).orElseThrow(() -> new ResourcenotfoundException("employee not found"+employeeid));
        employeeRepo.deleteById(employeeid);

    }


}
