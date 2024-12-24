package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    // 添加部门
    @PostMapping("/add")
    public Result addDepartment(@RequestBody department request) {
        department department = new department(request.getDepartment_name(), request.getLevel());
        departmentService.addDepartment(department);
        return Result.SUCCESS;
    }
    // 获取部门列表
    @GetMapping("/listAll")
    public List<department> listDepartment() {
        return departmentService.listDepartment();
    }
    @GetMapping("/list")
    public List<department> listDepartmentLevel() {
        return departmentService.listDepartmentLevel(1);
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteDepartmentById(@PathVariable("id") Integer id) {
        departmentService.deleteDepartmentById(id);
        return Result.SUCCESS;
    }
}
