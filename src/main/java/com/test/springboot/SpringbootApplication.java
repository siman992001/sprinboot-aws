package com.test.springboot;

import com.test.springboot.model.Employee;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner, ApplicationRunner {



	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String[] args){
		System.out.println("Command Line Runner");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Application Runner");
	}
}
