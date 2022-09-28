package com.company.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@Value會擷取application properties 對應的資料
    @Value("${welcome.message}")
    private  String welcomeMessage ;

    //兩種Mapping方法 Get寫法比較簡潔
//    @GetMapping("/")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String helloWorld(){
        return  welcomeMessage;
    }


}
