package com.example.baurzhankyzy_aruzhan.AruzhanModel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaurzhankyzyAruzhanGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private BaurzhankyzyAruzhanStudent student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private BaurzhankyzyAruzhanCourse course;
}
