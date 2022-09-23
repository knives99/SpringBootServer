package com.company.SpringBoot.service;

import com.company.SpringBoot.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> fetchDepartments();
    Department fetchDepartmentsById(Long department);

    String deleteDepatmentsById(Long departmentId);

    Department updateDepartment(Long departmentID, Department department);
}
