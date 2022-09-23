package SpringBeanDemo.entity;

import SpringBeanDemo.service.Staff;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//設定變數Scope範圍 預設為singleton
@Scope(scopeName = "singleton")
//                  singleton / prototype

//
@Component
//設定給Bean查的組件
public class Doctor implements Staff, BeanNameAware {
    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                ", nurse=" + nurse +
                '}';
    }

    private  String qualification ;
    private Nurse nurse;

    public void assist(){
        System.out.println("HELLO WORLD");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    //生命週期：
    //init:
    //interface:BeanNameAware
    @Override
    public void setBeanName(String name) {
        System.out.println("Set Bean name method is called");
    }
    //post init 後置init 處理一些interface or for loop
    @PostConstruct
    public void postConstruct(){
        System.out.println("Post Construct Method is called");
    }



}
