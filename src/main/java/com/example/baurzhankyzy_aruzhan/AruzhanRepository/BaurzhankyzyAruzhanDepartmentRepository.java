package com.example.baurzhankyzy_aruzhan.AruzhanRepository;

import com.example.baurzhankyzy_aruzhan.AruzhanModel.BaurzhankyzyAruzhanDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaurzhankyzyAruzhanDepartmentRepository extends JpaRepository<BaurzhankyzyAruzhanDepartment, Long> {
}
