package com.ajrdevops.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajrdevops.crudspring.model.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
