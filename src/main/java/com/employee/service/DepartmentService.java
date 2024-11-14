package com.employee.service;
import java.util.List;
import com.employee.dto.Department_Dto;
import com.employee.entity.Department;

public interface DepartmentService {
    Department_Dto createDepartment(Department_Dto departmentDto);
    Department_Dto getDepartmentByid(Long departmentid);
    List<Department_Dto> getalldepartments();


}
