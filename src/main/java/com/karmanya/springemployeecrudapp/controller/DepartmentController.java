package com.karmanya.springemployeecrudapp.controller;

import com.karmanya.springemployeecrudapp.entity.Department;
import com.karmanya.springemployeecrudapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService=departmentService;
    }

    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping(path = "{deptId}")
    public Optional<Department> getDepartmentById(@PathVariable("deptId") Long deptId) {
        return departmentService.getDepartmentById(deptId);
    }

    @PostMapping
    public void registerNewDepartment(@RequestBody Department department) {
        departmentService.addNewDepartment(department);
    }

    @DeleteMapping(path = "{departmentId}")
    public void deleteDepartment(@PathVariable("departmentId") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
    }

    @PutMapping(path = {"departmentId"})
    public void updateDepartment(@PathVariable("departmentId") Long departmentId,
                                 @RequestParam String name){
        departmentService.updateDepartment(departmentId, name);
    }
}
