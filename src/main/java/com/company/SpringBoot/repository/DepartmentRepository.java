package com.company.SpringBoot.repository;


import com.company.SpringBoot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository :數據庫操作
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public  Department findByDepartmentName(String departmentName);

    @Query(value = "SELECT xxxx FROM xxxxx",nativeQuery = true)
    public  Department findDepartmentNameIgnoreCase(String departName);
}
