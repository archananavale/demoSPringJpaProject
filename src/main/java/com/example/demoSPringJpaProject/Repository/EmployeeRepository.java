package com.example.demoSPringJpaProject.Repository;

import com.example.demoSPringJpaProject.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee ,Integer> /*JpaRepository <T, ID>*/{

}
