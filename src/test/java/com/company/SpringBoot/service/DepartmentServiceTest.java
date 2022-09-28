package com.company.SpringBoot.service;

import com.company.SpringBoot.entity.Department;
import com.company.SpringBoot.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private  DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
//    @BeforeAll
//    @AfterEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("east")
                .departmentCode("3306")
                .departmenId(1L)
                .build();
        //用來生成測試資料
        Mockito.when(departmentRepository.findDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

//    @Test
//    @DisplayName("可以為這個測試下一個註釋名稱 好在測試裡辨別")
//    @Disabled //把測試設為disable會skip this test
//    public void whenValidDepartmentName_thenDepartmentShouldFound(){
//        String departmentName = "IT";
//        Department department  = departmentService.fetchDepartmentsByName(departmentName);
//        assertEquals(departmentName,department.getDepartmentName());
//    }
}