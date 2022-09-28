package com.company.SpringBoot.repository;

import com.company.SpringBoot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


//为了测试 Spring Data JPA 存储库或任何其他与 JPA 相关的组件，Spring Boot 提供了 @DataJpaTest 注解。我们可以将它添加到单元测试中，它将设置一个 Spring 应用程序上下文：
@DataJpaTest
class DepartmentRepositoryTest {


    @Autowired
    private  DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department2 = Department.builder()
                .departmentName("Mech engineer")
                .departmentCode("ME-001")
                .departmentAddress("Taipei")
                .build();
        entityManager.persist(department2);
    }


    public  void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Mech engineer");
    }


}