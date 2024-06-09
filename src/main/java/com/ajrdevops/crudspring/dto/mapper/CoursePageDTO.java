package com.ajrdevops.crudspring.dto.mapper;

import java.util.List;

import com.ajrdevops.crudspring.dto.CourseDTO;

public record CoursePageDTO(List<CourseDTO> courses, long totalElements, int totalPages) {


}
