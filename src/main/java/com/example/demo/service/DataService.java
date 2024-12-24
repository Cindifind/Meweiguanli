package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    @Transactional(readOnly = true)
    public List<User> findUsers() {
        return dataRepository.findByIdNot(1);
    }
}



