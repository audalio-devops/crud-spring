package com.ajrdevops.crudspring.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.ajrdevops.crudspring.enums.Category;
import com.ajrdevops.crudspring.enums.validation.ValueOfEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(
    @JsonProperty("_id") Long id,
    @NotBlank @NotNull @Length(min = 3, max = 100) String name,
    @NotBlank @NotNull @Length(max = 20)  @ValueOfEnum(enumClass = Category.class) String category,
    @NotNull  @NotEmpty @Valid List<LessonDTO> lessons) {
    
}
