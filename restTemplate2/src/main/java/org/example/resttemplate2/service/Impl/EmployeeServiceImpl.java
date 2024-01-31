package org.example.resttemplate2.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.resttemplate2.model.Employee;
import org.example.resttemplate2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final RestTemplate restTemplate;

    @Value("${common.url}")
    private String url;


    public String allEmployee() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
//        System.out.println(url + "/search");

        ResponseEntity<String> response = restTemplate.exchange(url + "/search", HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    @Override
    public ResponseEntity<Employee> create(Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,httpHeaders);

        return restTemplate.exchange(url+"/add",HttpMethod.POST,entity,Employee.class);
    }

    @Override
    public ResponseEntity<Employee> searchId(Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Employee> entity = new HttpEntity<Employee>(httpHeaders);

        return restTemplate.exchange(url+"/search/"+id,HttpMethod.GET,entity,Employee.class);
    }

    @Override
    public ResponseEntity<Employee> delete(Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Employee> entity = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange(url+"/delete/"+id, HttpMethod.DELETE, entity, Employee.class);
    }

    @Override
    public ResponseEntity<Employee> update(Long id, Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,httpHeaders);

        return restTemplate.exchange(url+"/update/"+id, HttpMethod.PUT,entity,Employee.class);
    }
}
