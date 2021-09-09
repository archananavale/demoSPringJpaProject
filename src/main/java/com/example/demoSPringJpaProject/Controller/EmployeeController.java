package com.example.demoSPringJpaProject.Controller;

import com.example.demoSPringJpaProject.Model.Employee;
import com.example.demoSPringJpaProject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return "Employee Saved";
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/getEmployeeByID/{empID}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer empID){
        return employeeRepository.findById(empID);

    }
    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        Optional<Employee> employee1=employeeRepository.findById(employee.getId());
        if(employee1.isPresent()){
            employee1.get().setName(employee.getName());
            employee1.get().setCity(employee.getCity());
            employeeRepository.save(employee1.get());
            return "Employee updated";
        }
        return "Employee Not found";

    }
@DeleteMapping("/deleteEmployeeRecord/{empId}")
    public String deleteEmployeeRecord(@PathVariable int empId){
        Optional<Employee> employee1=employeeRepository.findById(empId);
        if(employee1.isPresent()){
            employeeRepository.delete(employee1.get());
            return "Employee record Deleted";
        }
        return "Employee record Not found";
    }
}
