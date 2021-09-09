package com.example.demoSPringJpaProject.Repository;

import com.example.demoSPringJpaProject.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends JpaRepository<Product,Integer> {

   /*
   get all product which are not sold
    */
   //this is time consuming Queery
//  @Query(value = "select p.* from product p where p.id NOT IN (select prod_id from customer_product)",nativeQuery = true) //this is sub query

   @Query(value = "select p.* from product p Left join customer_product cp On p.id=cp.prod_id where cp.prod_id is Null",nativeQuery = true)
   List<Map<String,Object>> findAllNotSoldProduct();



}
