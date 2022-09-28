package com.company.SpringBoot.service;

import com.company.SpringBoot.entity.Department;
import com.company.SpringBoot.error.DepartmentNotFoundException;
import com.company.SpringBoot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


//業務邏輯層:針對具體問題的操作，主要是從資料庫中取得數據並對數據進行邏輯處理。
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    //@Override : 表示此方法覆寫了父類別的方法。
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentsById(Long department) throws DepartmentNotFoundException {
       Optional<Department> department1  = departmentRepository.findById(department);

       if(! department1.isPresent()){
           throw new DepartmentNotFoundException("Detpartmewnt is Not Available");
       }
     return  department1.get();
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

    @Override
    public Department fetchDepartmentsByName(String depatrmentName) {
        return departmentRepository.findByDepartmentName(depatrmentName);
        //                          //QueryCreation 可藉由一些特殊關鍵字來產生對應的查詢語句

    }
}
