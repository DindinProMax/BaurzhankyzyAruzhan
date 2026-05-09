package com.example.baurzhankyzy_aruzhan.AruzhanModel;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaurzhankyzyAruzhanInstructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String academicRank;

    @OneToMany(mappedBy = "instructor")
    private List<BaurzhankyzyAruzhanCourse> courses;
}
