package com.ajrdevops.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ajrdevops.crudspring.enums.Category;
import com.ajrdevops.crudspring.model.Course;
import com.ajrdevops.crudspring.model.Lesson;
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
			c.setCategory(Category.FRONTEND);

			Lesson lesson = new Lesson();
			lesson.setName("Angular 1");
			lesson.setYoutubeURL("youtube.com");
			lesson.setCourse(c);
			c.getLessons().add(lesson);

			Lesson lesson2 = new Lesson();
			lesson2.setName("Angular 2");
			lesson2.setYoutubeURL("youtube2.com");
			lesson2.setCourse(c);
			c.getLessons().add(lesson2);
			
			courseRepository.save(c);

			c = new Course();
			c.setName("Java");
			c.setCategory(Category.BACKEND);

			Lesson lesson3 = new Lesson();
			lesson3.setName("Java 1");
			lesson3.setYoutubeURL("youtubeJ1.com");
			lesson3.setCourse(c);
			c.getLessons().add(lesson3);
			courseRepository.save(c);


		};
	}

}
