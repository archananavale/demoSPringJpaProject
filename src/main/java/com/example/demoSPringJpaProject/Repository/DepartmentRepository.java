package com.example.demoSPringJpaProject.Repository;

import com.example.demoSPringJpaProject.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
