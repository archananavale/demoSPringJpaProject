package com.example.demoSPringJpaProject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
Many to One Relationship example
        PurchaseOrderItem <----> purchaseOrder
*/
@Getter
@Setter
@Entity
public class PurchaseOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String itemName;
    private double itemPrice;

    @JsonBackReference  //  back reference id of Purchase_order
    @ManyToOne
    @JoinColumn(name = "po_id")
    private  PurchaseOrder purchaseOrder;
}
