package com.company.SpringBoot.controller;

import com.company.SpringBoot.entity.Department;
import com.company.SpringBoot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {


    @Autowired
    private  DepartmentService departmentService;

    //CRUD-Read
    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        return  departmentService.fetchDepartments();
    }


    @GetMapping("/departments/{id}")
    public Department fetchDepartmentsById(@PathVariable("id") Long departmentId){
        //                                 從Path獲取變數
        return  departmentService.fetchDepartmentsById(departmentId);
    }



    //CRUD-Create
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        //                           @RequestBody  自動把Json的request套入實例(省去decode)

        return departmentService.saveDepartment(department);
    }



    //CRUD-Update
    @PutMapping("/departments/{id}")
    public  Department updateDepartment(@PathVariable("id") Long departmentID,@RequestBody Department department){

        return departmentService.updateDepartment(departmentID,department);
    }

    //CRUD-Delete
    @DeleteMapping("/departments/{id}")
    public  String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepatmentsById(departmentId);
        return  "Department deleated Successfully";
    }




}
