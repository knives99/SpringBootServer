package com.company.SpringBoot.entity;

import net.bytebuddy.build.Plugin;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

//創造Orm實例
@Entity
public class Department {

    //@Id 指定某個欄位為 Primary Key
    //@GeneratedValue 指定 ID 的生成方式
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long departmenId;
    @NotBlank(message = "Please Add Deapartment Name")
    @Length(max = 5,min = 1)
    @Size(max = 10,min = 0)
    @Email
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    // Future-被註釋的屬性必須為一個未來的日期
    @Future
    @FutureOrPresent
    //dependency-validation的防呆
    private  String departmentName;
    private String departmentAddress;

    private String departmentCode;

    public Department(Long departmenId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmenId = departmenId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmenId=" + departmenId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }

    public Long getDepartmenId() {
        return departmenId;
    }

    public void setDepartmenId(Long departmenId) {
        this.departmenId = departmenId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

}
