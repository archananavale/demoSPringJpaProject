package com.example.demoSPringJpaProject.Repository;

import com.example.demoSPringJpaProject.Model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {
}
