package com.karmanya.springemployeecrudapp.repository;

import com.karmanya.springemployeecrudapp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT d from Department d where name = ?1")
    Optional<Department> findDepartmentByName(String name);
}
