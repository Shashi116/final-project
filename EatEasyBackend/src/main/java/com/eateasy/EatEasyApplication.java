package com.eateasy;

import com.eateasy.model.Providers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class EatEasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatEasyApplication.class, args);

	}

}
