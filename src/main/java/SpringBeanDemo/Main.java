package SpringBeanDemo;

import SpringBeanDemo.entity.Doctor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        //一般配置寫法
        ApplicationContext context = new ClassPathXmlApplicationContext("src/main/spring.xml");

        //使用class配置的寫法
        // 用法是寫一個BeanConfig.Class 去操控bean的生成
        //名稱不用是BeanConfig
//      ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        //getbean(name) 對應到 <bean id>
        Doctor doctor = context.getBean("doctor",Doctor.class);
        doctor.assist();
        System.out.println(doctor);
    }
}
