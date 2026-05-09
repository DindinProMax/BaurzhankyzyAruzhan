package com.example.baurzhankyzy_aruzhan.AruzhanRepository;

import com.example.baurzhankyzy_aruzhan.AruzhanModel.BaurzhankyzyAruzhanCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaurzhankyzyAruzhanCourseRepository extends JpaRepository<BaurzhankyzyAruzhanCourse, Long> {
}
