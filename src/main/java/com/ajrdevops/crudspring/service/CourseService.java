package com.ajrdevops.crudspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.ajrdevops.crudspring.dto.CourseDTO;
import com.ajrdevops.crudspring.dto.mapper.CourseMapper;
import com.ajrdevops.crudspring.exception.RecordNotFoundException;
import com.ajrdevops.crudspring.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository,  CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }
    
    public List <CourseDTO> list() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO findById(@PathVariable @NotNull @Positive Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }    

    public CourseDTO create(@Valid @NotNull CourseDTO course) { 
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course))) ;
    }

    public CourseDTO  update(@NotNull @Positive Long id, @Valid  @NotNull CourseDTO courseDTO) {
        
        return courseRepository.findById(id)
        .map(recordFound -> {
                recordFound.setName(courseDTO.name());
                recordFound.setCategory(courseDTO.category());
                return courseMapper.toDTO(courseRepository.save(recordFound));                
            })
        .orElseThrow(() -> new RecordNotFoundException(id));
    }    
    
    public void delete(@NotNull @Positive Long id) {

        courseRepository.delete(
            courseRepository.findById(id)
                            .orElseThrow(() -> new RecordNotFoundException(id))
        );
    }


}
