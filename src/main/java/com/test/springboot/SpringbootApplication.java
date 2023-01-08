package com.test.springboot;

import com.test.springboot.model.Employee;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableScheduling
public class SpringbootApplication implements CommandLineRunner, ApplicationRunner {



    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        //System.out.println("Shutting down application");
        //System.exit(0);
    }

    @Override
    public void run(String[] args) {
        System.out.println("Command Line Runner");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Application Runner");
    }
}
