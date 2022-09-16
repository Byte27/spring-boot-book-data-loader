package com.byte27.dataloader;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;

@SpringBootApplication
public class SpringBootBookDataLoaderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookDataLoaderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
