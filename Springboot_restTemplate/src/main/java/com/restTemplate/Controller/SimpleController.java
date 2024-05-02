package com.restTemplate.Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.restTemplate.Entity.Employee;



@RestController
public class SimpleController {

	
	@GetMapping(value = "/getById/{id}")
	public ResponseEntity<Employee> getCustomerInfo(@PathVariable Integer id){
		String  url = "http://localhost:8080/employees/getById/"+id;
		
		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate.getForEntity(url, Employee.class);
	}
	
	@PostMapping(value = "/postEmployee")
	public ResponseEntity<Employee> postCustomerInfo(@RequestBody Employee employee){
		String  url = "http://localhost:8080/employees/post";
		
		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate.postForEntity(url,employee, Employee.class);
	}
	
	@DeleteMapping(value = "/deleteByEmail/{id}")
	public ResponseEntity<Employee> deleteCustomerInfo(@PathVariable String id){
		String  url = "http://localhost:8080/employees/deleteByEmail/"+id;
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		return restTemplate.exchange(url, HttpMethod.DELETE,null,Employee.class);
	}
	
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<Employee> deleteCustomerInfoByID(@PathVariable Integer id){
		String  url = "http://localhost:8080/employees/deleteById/"+id;
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		return restTemplate.exchange(url, HttpMethod.DELETE,null,Employee.class);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<Employee> UpdateCustomerInfo(@RequestBody Employee employee){
		String  url = "http://localhost:8080/employees/update";
		
		RestTemplate restTemplate = new RestTemplate();
		 HttpEntity<Employee> requestEntity = new HttpEntity<>(employee);
		return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Employee.class);
	}
	
}
