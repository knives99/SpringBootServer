package com.company.SpringBoot.service;

import com.company.SpringBoot.entity.Department;
import com.company.SpringBoot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentsById(Long department) {
        Department  department1  = departmentRepository.findById(department).get();
       return  department1;

    }

    @Override
    public String deleteDepatmentsById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return null;
    }

    @Override
    public Department updateDepartment(Long departmentID, Department department) {

        Department depDB  = departmentRepository.getReferenceById(departmentID);
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentName(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentName(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }
}
