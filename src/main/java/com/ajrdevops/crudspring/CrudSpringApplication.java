package com.ajrdevops.crudspring;

import javax.swing.plaf.ColorUIResource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ajrdevops.crudspring.model.Course;
import com.ajrdevops.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	// apenas para inserir dados no DB
	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {

		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular");
			c.setCategory("front-end");
			courseRepository.save(c);

			c = new Course();
			c.setName("Java");
			c.setCategory("back-end");
			courseRepository.save(c);

		};
	}

}
