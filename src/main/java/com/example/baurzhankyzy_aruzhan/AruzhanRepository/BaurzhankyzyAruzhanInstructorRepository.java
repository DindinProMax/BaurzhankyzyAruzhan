package com.example.baurzhankyzy_aruzhan.AruzhanRepository;

import com.example.baurzhankyzy_aruzhan.AruzhanModel.BaurzhankyzyAruzhanInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaurzhankyzyAruzhanInstructorRepository extends JpaRepository<BaurzhankyzyAruzhanInstructor, Long> {
}