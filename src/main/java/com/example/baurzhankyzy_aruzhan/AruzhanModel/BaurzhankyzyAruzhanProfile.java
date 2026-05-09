package com.example.baurzhankyzy_aruzhan.AruzhanModel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profiles")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaurzhankyzyAruzhanProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    private String address;

    // Обратная связь: указываем поле 'profile' в классе Student
    @OneToOne(mappedBy = "profile")
    private BaurzhankyzyAruzhanStudent student;
}
