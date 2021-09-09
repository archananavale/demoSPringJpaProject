package com.example.demoSPringJpaProject.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
/*
Many to Many Relationship example
        Customer <----> Product
*/
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String productName;

    @ManyToMany(mappedBy = "productSet")
    private Set<Customer> customerSet;

}
