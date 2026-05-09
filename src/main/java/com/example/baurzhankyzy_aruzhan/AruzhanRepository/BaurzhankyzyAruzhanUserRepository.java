package com.example.baurzhankyzy_aruzhan.AruzhanRepository;

import com.example.baurzhankyzy_aruzhan.AruzhanModel.BaurzhankyzyAruzhanUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BaurzhankyzyAruzhanUserRepository extends JpaRepository<BaurzhankyzyAruzhanUser, Long> {
    Optional<BaurzhankyzyAruzhanUser> findByUsername(String username);
}
