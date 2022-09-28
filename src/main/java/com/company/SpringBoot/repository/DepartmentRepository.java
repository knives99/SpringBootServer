package com.company.SpringBoot.repository;


import com.company.SpringBoot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//資料存取層，主要負責對資料庫的操作，針對數據的新增、刪除、修改、查詢。
//@Repository :宣告這是資料庫存取類別(實現非介面類別)，用於標記資料存取層。
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public  Department findByDepartmentName(String departmentName);

    @Query(value = "SELECT xxxx FROM xxxxx",nativeQuery = true)
    public  Department findDepartmentNameIgnoreCase(String departName);
}
