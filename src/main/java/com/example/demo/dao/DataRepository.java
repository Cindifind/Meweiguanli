package com.example.demo.dao;

import com.example.demo.model.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<DataEntity, Long> {
    List<DataEntity> findByDelAndCollege(Integer del , String college);
    List<DataEntity> findByOAAAAndDel(Integer OAAA, Integer del);

}
