package com.example.baurzhankyzy_aruzhan.AruzhanModel;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "students")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaurzhankyzyAruzhanStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    // Связь One-to-One с профилем
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private BaurzhankyzyAruzhanProfile profile;

    // Связь Many-to-One с кафедрой
    @ManyToOne
    @JoinColumn(name = "department_id")
    private BaurzhankyzyAruzhanDepartment department;

    // Связь Many-to-Many с курсами
    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<BaurzhankyzyAruzhanCourse> courses;

    // Связь One-to-Many с оценками
    @OneToMany(mappedBy = "student")
    private List<BaurzhankyzyAruzhanGrade> grades;
}
