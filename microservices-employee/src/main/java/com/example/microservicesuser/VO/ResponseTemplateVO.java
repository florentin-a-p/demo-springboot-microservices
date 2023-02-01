package com.example.microservicesuser.VO;

import com.example.microservicesuser.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
  private Employee employee;
  private Department department;
}
