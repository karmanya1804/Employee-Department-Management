package com.karmanya.springemployeecrudapp.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Employee implements Serializable {

    private static final long serialVersionUID = -4439114469417994311L;
    @Id
    @SequenceGenerator(
            name="employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long empId;
    private String name;
    private String email;
    private Integer age;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "deptId"
    )
    private Department department;

    public Employee() {
    }

    public Employee(Long empId, String name, String email, Integer age, Department department) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.department = department;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
