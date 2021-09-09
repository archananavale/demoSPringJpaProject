package com.example.demoSPringJpaProject.Repository;

import com.example.demoSPringJpaProject.Model.PurchaseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem,Integer> {
}
