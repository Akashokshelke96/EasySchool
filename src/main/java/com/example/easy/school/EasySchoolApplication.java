package com.example.easy.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;

@SpringBootApplication
@EnableJpaRepositories("com.example.easy.school.repository")
@EntityScan("com.example.easy.school.*")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class EasySchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasySchoolApplication.class, args);


	}


}
