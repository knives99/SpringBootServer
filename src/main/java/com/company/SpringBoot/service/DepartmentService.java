package com.company.SpringBoot.service;

import com.company.SpringBoot.entity.Department;
import com.company.SpringBoot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> fetchDepartmentList();
    Department fetchDepartmentsById(Long department) throws DepartmentNotFoundException;

    String deleteDepatmentsById(Long departmentId);

    Department updateDepartment(Long departmentID, Department department);

    Department fetchDepartmentsByName(String depatrmentName);
}
