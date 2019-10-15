package fr.youness.mescoursesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MesCoursesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MesCoursesApiApplication.class, args);
	}

}
