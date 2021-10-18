package com.vibhor.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CourseappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseappApplication.class, args);
	}

}
