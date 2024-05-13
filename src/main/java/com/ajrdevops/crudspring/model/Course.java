package com.ajrdevops.crudspring.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@Entity
//@Table(name = "cursos")
@SQLDelete(sql = "update Course set status='inativo' where id = ?")
@SQLRestriction("status <> 'inativo'")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 3, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Length(max = 20)
    @Pattern(regexp = "back-end|front-end|full-stack")
    @Column(length = 20, nullable = false)
    private String category;
    
    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "ativo|inativo")
    @Column(length = 10, nullable = false)
    private String status = "ativo";
}
