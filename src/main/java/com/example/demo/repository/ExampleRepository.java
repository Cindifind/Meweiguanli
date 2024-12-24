package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ExampleRepository extends JpaRepository<User, Integer> {



    @Modifying
    @Transactional
    @Query("UPDATE User ua SET ua.enabled = :value WHERE ua.id = :id")
    void updateEnabledValueById(Integer id, Integer value);

    @Modifying
    @Transactional
    @Query("DELETE FROM User ua WHERE ua.id = :id")
    void deleteUserById(Integer id);
}
   