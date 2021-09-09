package com.example.demoSPringJpaProject.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
/*

many to many Relationship example
Customer <----> Product


one to one
customer <----> customer logindeatails
 */
@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerName;
    private String address;

    /*
    This is working but not recommonded to have primary key same for the customer login table .
    With this logic i used the primary key of customer table as primary key of customer login detail table.
    which creates ambiguity

     */
    @OneToOne (mappedBy = "customer" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private CustomerLoginDetails loginDetails;
/*
 //This working when primary key and forein key are diffrent in customerLogingDetail entitiy

 @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonManagedReference
  //  @JoinColumn(name = "login_id",referencedColumnName = "id")
    private CustomerLoginDetails loginDetails;
*/
    @ManyToMany
    @JoinTable(name = "customer_product",
                joinColumns = @JoinColumn(name = "cust_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "prod_id",referencedColumnName = "id"))
    private Set<Product> productSet; //why we used SET: to get unique records and avoid record repeatation

}

