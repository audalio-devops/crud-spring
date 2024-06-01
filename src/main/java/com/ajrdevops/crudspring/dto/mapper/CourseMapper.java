package com.ajrdevops.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.ajrdevops.crudspring.dto.CourseDTO;
import com.ajrdevops.crudspring.enums.Category;
import com.ajrdevops.crudspring.model.Course;


@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course) {
        if (course == null){
            return null;
        }

        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), 
                             course.getLessons());
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
