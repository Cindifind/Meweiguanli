package com.example.demo.service;

import com.example.demo.dao.DataRepository;
import com.example.demo.model.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    public List<DataEntity> findActiveData() {
        return dataRepository.findByDelNot(1);
    }
}
