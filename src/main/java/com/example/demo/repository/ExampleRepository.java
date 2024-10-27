package com.example.demo.repository;

import com.example.demo.model.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE ExampleEntity e SET e.del = 1 WHERE e.id = :id")
    void updateDelValueById(@PathVariable("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE ExampleEntity e SET e.ga = :value WHERE e.id = :id")
    void updateGaValueById(@PathVariable("id") Integer id, @PathVariable("value") Integer value);

    @Modifying
    @Transactional
    @Query("UPDATE ExampleEntity e SET e.oaaa = :value WHERE e.id = :id")
    void updateOaaaValueById(@PathVariable("id") Integer id, @PathVariable("value") Integer value);
}
