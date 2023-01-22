package com.karmanya.springemployeecrudapp.controller;


import com.karmanya.springemployeecrudapp.entity.Employee;
import com.karmanya.springemployeecrudapp.service.DepartmentService;
import com.karmanya.springemployeecrudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable("employeeId") Long empId) {
        return employeeService.getEmployeesById(empId);
    }

    @GetMapping(path="department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable("departmentId") Long dept_id) {
        return employeeService.getEmployeesByDepartment(dept_id);
    }

    @PostMapping(path = "{departmentId}")
    public void registerNewEmployee(@RequestBody Employee employee, @PathVariable("departmentId") Long dept_id) {
        employeeService.addNewEmployee(employee, dept_id);
    }

    @DeleteMapping (path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long empId) {
        employeeService.deleteEmployee(empId);
    }

    @PutMapping(path="{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") Long empId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) Long deptId,
                               @RequestParam(required = false) Integer age) {
        employeeService.updateEmployee(empId, name, email, deptId, age);
    }


}
