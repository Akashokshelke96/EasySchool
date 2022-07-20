package com.example.easySchool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableJpaRepositories("com.example.easySchool.repository")
@EntityScan("com.example.easySchool.model")
public class EasySchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasySchoolApplication.class, args);


	}

}
