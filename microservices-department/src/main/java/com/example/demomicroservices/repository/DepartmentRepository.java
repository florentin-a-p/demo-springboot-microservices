package com.example.demomicroservices.repository;

import com.example.demomicroservices.entity.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
  Department findByDepartmentId(Long departmentId);
}
