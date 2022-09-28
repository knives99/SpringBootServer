package com.company.SpringBoot.controller;

import com.company.SpringBoot.entity.Department;
import com.company.SpringBoot.error.DepartmentNotFoundException;
import com.company.SpringBoot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department ;

    @BeforeEach
    void setUp(){
        department = Department.builder()
                .departmentAddress("Ahmdabad")
                .departmentName("IT")
                .departmentCode("IT-06")
                .departmenId(1L)
                .build();
    }



//    @Test
//    void fetchDepartmentsById() throws Exception {
//        //Mock一個傳出去的假資料
//        Mockito.when(departmentService.fetchDepartmentsById(1L)).thenReturn(department);
//        mockMvc.perform(MockMvcRequestBuilders.get("/departments/IT")
//                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$.departmentName").value(department.getDepartmentName()));
//    }

//    @Test
//    void saveDepartment() throws Exception {
//        Department inputDepartment = Department.builder()
//                .departmentAddress("Ahmdabad")
//                .departmentCode("IT")
//                .departmentName("IT-06")
//                .build();
//        Mockito.when(departmentService.saveDepartment(inputDepartment))
//                .thenReturn(department);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(
//                        "{\n" +
//                                "    \"departmenId\": 1,\n" +
//                                "    \"departmentName\": \"dd\",\n" +
//                                "    \"departmentAddress\": \"love\",\n" +
//                                "    \"departmentCode\": \"122\"\n" +
//                                "}"
//                )).andExpect(status().isOk());
//    }
}