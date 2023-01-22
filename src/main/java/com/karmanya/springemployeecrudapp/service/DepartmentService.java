package com.karmanya.springemployeecrudapp.service;

import com.karmanya.springemployeecrudapp.entity.Department;
import com.karmanya.springemployeecrudapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {


    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Cacheable(value="Department")
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Cacheable(value="Department", key="#deptId")
    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    @CachePut(value="Department", key="#deptId")
    public void addNewDepartment(Department department) {
        Optional<Department> departmentOptional= departmentRepository.findDepartmentByName(department.getName());
        if(departmentOptional.isPresent()) {
            throw new IllegalStateException("department already exists");
        }
        departmentRepository.save(department);
    }

    @CacheEvict(value="Department", key="#deptId")
    public void deleteDepartment(Long departmentId) {
        boolean exists= departmentRepository.existsById(departmentId);
        if(!exists) {
            throw new IllegalStateException("Department with id "+ departmentId+ "does not exist");
        }
        departmentRepository.deleteById(departmentId);
    }

    @Transactional
    @CachePut(value="Department", key="#deptId")
    public void updateDepartment(Long departmentId, String name) {
        Department department= departmentRepository.findById(departmentId)
                .orElseThrow(()-> new IllegalStateException(
                        "Department with id "+ departmentId+ " does not exist"));

        if(name!= null && name.length()>0
                && !Objects.equals(department.getName(), name)) {
            department.setName(name);
        }
    }
}
