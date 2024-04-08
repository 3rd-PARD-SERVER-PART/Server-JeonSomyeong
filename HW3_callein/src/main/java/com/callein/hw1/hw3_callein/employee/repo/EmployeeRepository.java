package com.callein.hw1.hw3_callein.employee.repo;


import com.callein.hw1.hw3_callein.employee.entity.Employee;
import com.callein.hw1.hw3_callein.employee.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByPosition(Position position);
    List<Employee> findBySalaryGreaterThan(Integer salary);
    List<Employee> findBySalaryLessThan(Integer salary);
    List<Employee> findByName(String name);
}
