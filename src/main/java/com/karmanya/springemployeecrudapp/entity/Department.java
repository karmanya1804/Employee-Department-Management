package com.karmanya.springemployeecrudapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Department implements Serializable {

    private static final long serialVersionUID = -4439114469417994311L;
    @Id
    @SequenceGenerator(
            name="department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    private Long deptId;
    private String name;

    public Department() {
    }

    public Department(Long deptId, String name) {
        this.deptId = deptId;
        this.name = name;
    }

    public Long getId() {
        return deptId;
    }

    public void setId(Long deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + deptId +
                ", name='" + name + '\'' +
                '}';
    }
}
