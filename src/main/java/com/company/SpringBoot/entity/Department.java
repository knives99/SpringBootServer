package com.company.SpringBoot.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

//創造Orm實例
@Entity
//lombok 的 @Getter 注解就可以幫我們自動生成所有變量的 getter
@Data   // =  @Getter + @Setter
@NoArgsConstructor //自動生成無參架構器
@AllArgsConstructor //自動生成有參架構器
@Builder //建造者模式
public class Department {

    //@Id 指定某個欄位為 Primary Key
    //@GeneratedValue 指定 ID 的生成方式
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long departmenId;

    //dependency-validation的防呆
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
    private  String departmentName;
    private String departmentAddress;

    private String departmentCode;

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
