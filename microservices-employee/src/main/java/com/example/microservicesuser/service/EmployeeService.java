package com.example.microservicesuser.service;

import com.example.microservicesuser.VO.Department;
import com.example.microservicesuser.VO.ResponseTemplateVO;
import com.example.microservicesuser.entity.Employee;
import com.example.microservicesuser.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private RestTemplate restTemplate;

  public Employee saveEmployee(Employee employee) {
    log.info("Inside saveEmployee of EmployeeService");
    return employeeRepository.save(employee);
  }

  public ResponseTemplateVO getEmployeeWithDepartment(Long employeeId) {
    log.info("Inside getEmployeeWithDepartment of EmployeeService");
    ResponseTemplateVO vo = new ResponseTemplateVO();
    Employee employee = employeeRepository.findByEmployeeId(employeeId);

    Department department =
        restTemplate.getForObject("http://localhost:9001/departments/" + employee.getDepartmentId()
            ,Department.class);

    vo.setEmployee(employee);
    vo.setDepartment(department);

    return  vo;
  }
}
