package com.example.baurzhankyzy_aruzhan.AruzhanModel;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaurzhankyzyAruzhanCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String title;

    // Обратная связь Many-to-Many (указываем поле 'courses' из класса Student)
    @ManyToMany(mappedBy = "courses")
    private List<BaurzhankyzyAruzhanStudent> students;

    // Связь Many-to-One с инструктором
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private BaurzhankyzyAruzhanInstructor instructor;
}