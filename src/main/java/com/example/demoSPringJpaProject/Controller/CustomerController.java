package com.example.demoSPringJpaProject.Controller;

import com.example.demoSPringJpaProject.Model.Customer;
import com.example.demoSPringJpaProject.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return "Data Saved";
    }

    @GetMapping("/getCustomerByProduct/{prodId}")
    public List<Map<String,Object>> getCustomerByProduct(@PathVariable Integer prodId){
        return customerRepository.getCustomerByProduct(prodId);
    }

    @GetMapping("/getAllProductPurchasedByCustomer/{custId}")
    public List<Map<String,Object>> getAllProductPurchasedByCustomer(@PathVariable Integer custId){
        return customerRepository.getAllProductByCustomerId(custId);
    }


    @GetMapping("/getCustomerDetails/{custId}")
    public List<Map<String ,Object>> getCustomerDetails(@PathVariable Integer custId){
        return customerRepository.getCustomerDetails(custId);
}

}
