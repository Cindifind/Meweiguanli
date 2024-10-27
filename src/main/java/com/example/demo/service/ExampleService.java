package com.example.demo.service;

import com.example.demo.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    private ExampleRepository exampleRepository;

    public void updateDelValue(Integer id) {
        exampleRepository.updateDelValueById(id);
    }

    public void updateGaValue(Integer id, Integer value) {
        exampleRepository.updateGaValueById(id, value);
    }

    public void updateOaaaValue(Integer id, Integer value) {
        exampleRepository.updateOaaaValueById(id, value);
    }
}
