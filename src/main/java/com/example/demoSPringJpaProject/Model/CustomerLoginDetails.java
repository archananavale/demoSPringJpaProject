package com.example.demoSPringJpaProject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
ONE  to one Relationship
with customer table
 */
@Entity
@Getter
@Setter
public class CustomerLoginDetails {
 //use Primary and foreing key are same : here customer ID used as primary key to the customer login details
    @Id
    private Integer id;
    private String loginName;
    private String password;//encoding ?
    private Integer phoneNumber;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    @JsonBackReference
    private Customer customer;

// OR
//Below code is working //
  /* use primary key and forein key separate
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String loginName;
    private String password;//encoding ?
    private Integer phoneNumber;

    @OneToOne//(mappedBy = "loginDetails",cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name = "cust_id",referencedColumnName = "id")
    private Customer customer;


*/

}
