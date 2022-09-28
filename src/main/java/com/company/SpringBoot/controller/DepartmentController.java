package com.company.SpringBoot.controller;

import com.company.SpringBoot.entity.Department;
import com.company.SpringBoot.error.DepartmentNotFoundException;
import com.company.SpringBoot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


//表現層：主要負責接收用戶請求、轉發請求、產生數據並返回結果。
//@Controller : 宣告這是SpringMVC Controller 物件，用於標記控制器層。
// @RestController = @Controller + @RequestBody
@RestController
public class DepartmentController {


    @Autowired
    private  DepartmentService departmentService;
    private  final Logger LOGGER =  LoggerFactory.getLogger(DepartmentController.class);

    //CRUD-Read
    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return  departmentService.fetchDepartmentList();
    }


    @GetMapping("/departments/{id}")
    public Department fetchDepartmentsById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        //                                 從Path獲取變數
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return  departmentService.fetchDepartmentsById(departmentId);
    }



    //CRUD-Create
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        //                           @RequestBody  自動把Json的request套入實例(省去decode)
        //                           @Valid 為validation dependcy 的防呆機制 可看Department Class -deaprtmentName

        return departmentService.saveDepartment(department);
    }



    //CRUD-Update
    @PutMapping("/departments/{id}")
    public  Department updateDepartment(@PathVariable("id") Long departmentID,@RequestBody Department department){
        //  @RequestBody : 常用來處理application/json、application/xml 等Content-Type 類型的資料將其轉化為指定類型參數。
        return departmentService.updateDepartment(departmentID,department);
    }

    //CRUD-Delete
    @DeleteMapping("/departments/{id}")
    public  String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepatmentsById(departmentId);
        return  "Department deleated Successfully";
    }

    @GetMapping("/departments/name/{name}")
    public  Department fetchDepartmentByName(@PathVariable("name") String depatrmentName){
        return  departmentService.fetchDepartmentsByName(depatrmentName);
    }
}
