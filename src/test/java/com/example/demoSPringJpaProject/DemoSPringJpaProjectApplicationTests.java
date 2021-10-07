package com.example.demoSPringJpaProject;

import com.example.demoSPringJpaProject.Model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class) //Junit annotation
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoSPringJpaProjectApplicationTests {
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testGetAllEmployees(){
		//calling endpoint getEmployees
		ResponseEntity<Employee[]> entity=testRestTemplate.getForEntity("/getEmployees",Employee[].class);

		//System.out.println("--- Test :"+entity.getBody().length);
		assertEquals(3,entity.getBody().length);
	}

	@Test
	public  void testGetEmployeeById(){////getEmployeeByID/{empID}
		ResponseEntity<Employee> entity=testRestTemplate.getForEntity("/getEmployeeByID/1",Employee.class);
		assertEquals(1,entity.getBody().getId());
	}




}
