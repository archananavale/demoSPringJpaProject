package com.example.demoSPringJpaProject.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
/*
Many to One Relationship example
        Employee <----> Department
*/
@Getter
@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    /* not real time senatios*/
//    @OneToMany(mappedBy = "department")
//    private List<Employee> employeeList;
}
