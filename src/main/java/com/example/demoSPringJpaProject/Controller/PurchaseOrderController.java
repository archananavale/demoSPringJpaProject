package com.example.demoSPringJpaProject.Controller;

import com.example.demoSPringJpaProject.Model.PurchaseOrder;
import com.example.demoSPringJpaProject.Repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @PostMapping("/savePurchaseOrder")
    public String savePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
        purchaseOrderRepository.save(purchaseOrder);
        return "Data Saved";
    }

   @GetMapping("/getPurchasedOrder/{po_id}")
    public List<PurchaseOrder> getPurchaseOrder(@PathVariable Integer po_id){
        return purchaseOrderRepository.findAll();

   }
}
