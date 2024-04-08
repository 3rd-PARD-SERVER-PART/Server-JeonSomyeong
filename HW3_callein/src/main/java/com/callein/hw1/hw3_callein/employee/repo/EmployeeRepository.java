package com.callein.hw1.hw3_callein.employee.repo;


import com.callein.hw1.hw3_callein.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
