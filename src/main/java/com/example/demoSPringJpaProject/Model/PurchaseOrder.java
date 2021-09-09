package com.example.demoSPringJpaProject.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*
One to Many Relationship example
        PurchaseOrder <----> PurchaseOrderItem
*/
@Getter
@Setter
@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   // @Column(name="cust_name") // column name in database
    private String customerName;
    private String  city;
    private String address;

    @JsonManagedReference  //@Databinding to PurchaseOrderItem _
    @OneToMany(mappedBy = "purchaseOrder",cascade = CascadeType.ALL) //cascade deals with parents child relations
    private List<PurchaseOrderItem> purchaseOrderItemList;
}
