package com.example.demo.service;

import com.example.demo.dao.DepartmentDAOImpl;
import com.example.demo.model.department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentDAOImpl departmentDAOImpl;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentDAOImpl departmentDAOImpl) {
        this.departmentDAOImpl = departmentDAOImpl;
    }

    public void addDepartment(department department) {
        departmentDAOImpl.insertDepartment(department);
    }
    public List<department> listDepartment() {
        return departmentRepository.findAll();
    }
    public List<department> listDepartmentLevel(int level) {
        return departmentRepository.findByLevel(level);
    }
    public void deleteDepartmentById(Integer id) {
        departmentRepository.deletedDepartmentById(id);
    }
}
