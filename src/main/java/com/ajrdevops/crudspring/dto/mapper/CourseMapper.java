package com.ajrdevops.crudspring.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ajrdevops.crudspring.dto.CourseDTO;
import com.ajrdevops.crudspring.dto.LessonDTO;
import com.ajrdevops.crudspring.enums.Category;
import com.ajrdevops.crudspring.model.Course;
import com.ajrdevops.crudspring.model.Lesson;


@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course) {
        if (course == null){
            return null;
        }

        List<LessonDTO> lessons = course.getLessons()
                .stream()
                .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(), lesson.getYoutubeURL()))
                .collect(Collectors.toList());

        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), lessons);
    }

    public Course toEntity(CourseDTO courseDTO) {
        if (courseDTO == null){
            return null;
        }

        Course course = new Course();
        if (courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategory(convertCategoryValue(courseDTO.category()));

        List<Lesson> lessons =courseDTO.lessons().stream().map(lessonDTO -> {
            var lesson = new Lesson();
            lesson.setId(lessonDTO.id());
            lesson.setName(lessonDTO.name());
            lesson.setYoutubeURL(lessonDTO.youtubeURL());
            lesson.setCourse(course);
            return lesson;
        }).collect(Collectors.toList());
        course.setLessons(lessons);

        return course;
    }

    public Category convertCategoryValue(String value) {
        if (value == null) {   
            return null;
        }

        return switch (value) {
            case "front-end" -> Category.FRONTEND;
            case "back-end" ->  Category.BACKEND;
            case "full-stack" ->  Category.FULLSTACK;
            default -> throw new IllegalArgumentException("Invalid category: " + value);
        };
    }
}
