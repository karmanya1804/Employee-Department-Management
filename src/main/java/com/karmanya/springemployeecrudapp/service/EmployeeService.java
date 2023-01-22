package com.karmanya.springemployeecrudapp.service;

import com.karmanya.springemployeecrudapp.entity.Department;
import com.karmanya.springemployeecrudapp.entity.Employee;
import com.karmanya.springemployeecrudapp.repository.DepartmentRepository;
import com.karmanya.springemployeecrudapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository=employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeesById(Long empId) {
        return  employeeRepository.findById(empId);
    }

    public void addNewEmployee(Employee employee, Long dept_id) {
        Optional<Employee> employeeOptional= employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        Department department=departmentRepository.findById(dept_id).orElseThrow(()-> new IllegalStateException(
                "Department with id "+ dept_id+ " does not exist"));

        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long empId) {
        boolean exists= employeeRepository.existsById(empId);
        if(!exists) {
            throw new IllegalStateException("Employee with id "+ empId+ "does not exist");
        }
        employeeRepository.deleteById(empId);
    }

    @Transactional
    public void updateEmployee(Long empId, String name, String email, Long deptId, Integer age) {
        Employee employee= employeeRepository.findById(empId)
                .orElseThrow(()-> new IllegalStateException(
                        "Employee with id "+ empId+ " does not exist"));
        Department department= departmentRepository.findById(deptId)
                .orElseThrow(()-> new IllegalStateException(
                        "Department with id "+ deptId+ " does not exist"));

        if(name!= null && name.length()>0
                && !Objects.equals(employee.getName(), name)) {
            employee.setName(name);
        }

        if(email!= null && email.length()>0
                && !Objects.equals(employee.getEmail(), email)) {
            employee.setEmail(email);
        }

        if(department!= null && !Objects.equals(employee.getDepartment(), department)) {
            employee.setDepartment(department);
        }

        if(age!= null && age>0
                && !Objects.equals(employee.getAge(), age)) {
            employee.setAge(age);
        }

    }

    public List<Employee> getEmployeesByDepartment(Long dept_id) {
        Department department=departmentRepository.findById(dept_id).orElseThrow(()-> new IllegalStateException(
                "Department with id "+ dept_id+ " does not exist"));

        return employeeRepository.findEmployeeByDepartment(department);

    }
}
