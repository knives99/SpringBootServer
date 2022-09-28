package com.company.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Spring Boot的入口
//@SpringBootConfiguration : 組合了@Configuration 註釋，實現配置檔案的功能。
@SpringBootApplication
public class SpringBootFramework5Application {

	public static void main(String[] args) {
		//run運行springBoot的引導類
		SpringApplication.run(SpringBootFramework5Application.class, args);
	}

}
