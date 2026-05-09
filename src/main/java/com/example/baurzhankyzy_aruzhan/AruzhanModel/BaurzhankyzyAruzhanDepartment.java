package com.example.baurzhankyzy_aruzhan.AruzhanModel;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaurzhankyzyAruzhanDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<BaurzhankyzyAruzhanStudent> students;
}