package com.example.demo.repository;

import com.example.demo.model.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VisitorDataRepository extends JpaRepository<DataEntity, Long> {
    List<DataEntity> findByDepartmentNameAndDel(String departmentName, String del);
    List<DataEntity> findByApproveAndDel(int approve, String del);
    List<DataEntity> findByOpenidAndDel(String openid, String del);
    @Modifying
    @Transactional
    @Query("UPDATE DataEntity ua SET ua.approve = :value WHERE ua.id = :id")
    void updateApproveValueById(Integer id, Integer value);
    @Modifying
    @Transactional
    @Query("UPDATE DataEntity ua SET ua.del = :value WHERE ua.id = :id")
    void updateDelValueById(Integer id, String value);
}
