package com.karmanya.springemployeecrudapp.repository;

import com.karmanya.springemployeecrudapp.entity.Department;
import com.karmanya.springemployeecrudapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    @Query("SELECT e from Employee e where email = ?1")
    Optional<Employee> findEmployeeByEmail(String email);

    @Query("SELECT e from Employee e where department=?1")
    List<Employee> findEmployeeByDepartment(Department department);
}
