package com.example.crud.dto;


import lombok.*;

import java.time.LocalDate;

@Data
public class StudentDTO {
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
}
