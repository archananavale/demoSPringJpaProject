package com.example.demoSPringJpaProject.Controller;
import com.example.demoSPringJpaProject.Model.Department;
import com.example.demoSPringJpaProject.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/saveDepartment")
    public String saveDepartment(@RequestBody Department department){
        departmentRepository.save(department);
        return "Saved department";
    }



}
