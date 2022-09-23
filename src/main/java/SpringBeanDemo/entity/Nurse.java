package SpringBeanDemo.entity;

import SpringBeanDemo.service.Staff;

public class Nurse implements Staff {
    public  void  assist(){
        System.out.println("I can help");
    }
}
