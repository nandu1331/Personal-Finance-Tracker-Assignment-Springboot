package com.java_backend.Finance_Tracker_Java_Springboot;


import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FinanceTrackerJavaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceTrackerJavaSpringbootApplication.class, args);
	}

}
