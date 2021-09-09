package com.example.demoSPringJpaProject.Controller;

import com.example.demoSPringJpaProject.Model.Product;
import com.example.demoSPringJpaProject.Repository.ProductRepository;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getProductByID/{id}")
    public  Optional<Product> getProductById(@PathVariable Integer id){
        return productRepository.findById(id);
    }

    @GetMapping("/findAllNotSoldProduct")
    public List<Map<String,Object>> findAllNotSoldProduct(){
        return productRepository.findAllNotSoldProduct();
    }
}
