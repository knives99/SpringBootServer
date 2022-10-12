package com.company.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Spring Boot的入口
//@SpringBootConfiguration : 組合了@Configuration 註釋，實現配置檔案的功能。
@SpringBootApplication
//@SpringBootApplication 主要包含了以下三個註釋，
//@SpringBootConfiguration : 組合了@Configuration 註釋，實現配置檔案的功能。
//@EnableAutoConfiguration : 開啟自動配置的功能，也可以關閉某個自動配置的選項，如想要關閉資料來源自動配置功能，@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})。
//@ComponentScan : 用來掃描元件並裝配一些Bean，會根據定義的掃描路徑把符合掃描規則的類別裝配到Spring 容器中。
public class SpringBootFramework5Application {

	public static void main(String[] args) {
		//run運行springBoot的引導類
		SpringApplication.run(SpringBootFramework5Application.class, args);
	}

}
