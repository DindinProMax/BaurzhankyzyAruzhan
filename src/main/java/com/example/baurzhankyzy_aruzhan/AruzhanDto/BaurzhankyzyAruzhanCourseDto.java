package com.example.baurzhankyzy_aruzhan.AruzhanDto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaurzhankyzyAruzhanCourseDto {
    private String code;
    private String title;
    private String instructorName; // Имя преподавателя для вывода клиенту
}