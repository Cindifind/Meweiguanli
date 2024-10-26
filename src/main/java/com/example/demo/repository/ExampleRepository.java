package com.example.demo.repository;


import com.example.demo.model.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE ExampleEntity e SET e.del = 1 WHERE e.id = :id")
    void updateDelValueById(@Param("id") Integer id);
}
