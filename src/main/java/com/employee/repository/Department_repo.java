package com.employee.repository;

import com.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Department_repo extends JpaRepository<Department, Long> {

}
