package com.company.SpringBoot.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//如何使用注解的方式自定义Endpoint。可用于满足一些服务状态监控，或者优雅停机
//Spring Actuator中所有端口都是透過@Endpoint進行標注個類別為一個監測終端點的Bean，並透過@ReadOperation進行註記監測方法位置，
@Component
@Endpoint(id = "features")
public class FeatureEndpoint {
    private  final Map<String,Feature> featureMap = new ConcurrentHashMap<>();

    public  FeatureEndpoint(){
        featureMap.put("Department",new Feature(true));
        featureMap.put("User",new Feature(false));
        featureMap.put("Authentication",new Feature(false));
    }

    @ReadOperation
    //                     @Selector select particular value and pass over
    public Feature feature(@Selector  String featureName){
        return  featureMap.get(featureName);

    }

    @ReadOperation
    public  Map<String,Feature>  features(){
        return  featureMap;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class  Feature{
        private  boolean isEnabled;
    }
}
