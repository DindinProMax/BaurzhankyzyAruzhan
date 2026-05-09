package com.example.baurzhankyzy_aruzhan.AruzhanRepository;

import com.example.baurzhankyzy_aruzhan.AruzhanModel.BaurzhankyzyAruzhanStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface BaurzhankyzyAruzhanStudentRepository extends JpaRepository<BaurzhankyzyAruzhanStudent, Long>, JpaSpecificationExecutor<BaurzhankyzyAruzhanStudent> {

}