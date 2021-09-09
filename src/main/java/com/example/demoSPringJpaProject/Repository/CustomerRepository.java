package com.example.demoSPringJpaProject.Repository;

import com.example.demoSPringJpaProject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select c.id,c.customer_name,c.address from customer c ,product p ,customer_product cp where p.id=cp.prod_id and p.id=?",
            nativeQuery = true)
    List<Map<String,Object>> getCustomerByProduct(Integer prodId);
            //for custome queery we took MAP <string  and object >


/*
Get all product purchased by perticular customer
 */
    @Query(value ="select p.* from product p , customer_product cp where cp.prod_id= p.id AND cp.cust_id=?",nativeQuery = true)
    List<Map<String,Object>>getAllProductByCustomerId(Integer custID);

    /*
    get complete details of customer includimg login detials
     */
    @Query(value = "select c.customer_name,c.address,cl.* from customer_login_details cl, customer c where c.id=cl.id AND cl.id=?",nativeQuery = true)
    List<Map<String,Object>> getCustomerDetails (Integer custId);
}
