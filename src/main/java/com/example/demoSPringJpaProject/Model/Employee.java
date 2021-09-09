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
@Entity // JPA Will create table related to this Class in DB
public class Employee {
    @Id  //act as primary key: JPA features
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment in DB
    private Integer id;

    private String name;
    private String city;


    @ManyToOne //Defining relation of employee to Department
    @JoinColumn(name = "dept_id")
    private Department department;


}
