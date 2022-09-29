package com.example.demo.repository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.CustomProperties;
import com.example.demo.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeProxy {
	
	@Autowired
    private CustomProperties props;
	private Logger log;

	/**
    * Get all employees
    * @return An iterable of all employees
    */

    public Iterable<Employee> getEmployees() {
        String baseApiUrl = props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(
                getEmployeesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Employee>>() {}
                );
        
        log.debug("Get Employees call " + response.getStatusCode().toString());
        
        return response.getBody();
    }
    
    public Employee createEmployee(Employee e) {
        String baseApiUrl = props.getApiUrl();
        String createEmployeeUrl = baseApiUrl + "/employee";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(e);
        ResponseEntity<Employee> response = restTemplate.exchange(
            createEmployeeUrl,
            HttpMethod.POST,
            request,
            Employee.class);

        log.debug("Create Employee call " + response.getStatusCode().toString());

        return response.getBody();
    }

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
}
