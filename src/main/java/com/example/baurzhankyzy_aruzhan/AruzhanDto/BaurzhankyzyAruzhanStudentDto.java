package com.example.baurzhankyzy_aruzhan.AruzhanDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaurzhankyzyAruzhanStudentDto {
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    private String departmentName;
    private String bio;
}