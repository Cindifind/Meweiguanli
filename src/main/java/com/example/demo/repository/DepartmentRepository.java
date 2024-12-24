package com.example.demo.repository;

import com.example.demo.model.department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<department, Integer> {
    List<department> findByLevel(int level);

    @Modifying
    @Transactional
    @Query("DELETE FROM department ua WHERE ua.id = :id")
    void deletedDepartmentById(Integer id);
}
