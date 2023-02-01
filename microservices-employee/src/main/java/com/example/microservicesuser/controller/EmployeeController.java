package com.example.microservicesuser.controller;

import com.example.microservicesuser.VO.ResponseTemplateVO;
import com.example.microservicesuser.entity.Employee;
import com.example.microservicesuser.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @PostMapping("/")
  public Employee saveUser(@RequestBody Employee employee) {
    log.info("Inside saveUser of EmployeeController");
    return employeeService.saveEmployee(employee);
  }

  @GetMapping("/{id}")
  public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long employeeId) {
    log.info("Inside getEmployeeWithDepartment of EmployeeController");
    return employeeService.getEmployeeWithDepartment(employeeId);
  }
}
