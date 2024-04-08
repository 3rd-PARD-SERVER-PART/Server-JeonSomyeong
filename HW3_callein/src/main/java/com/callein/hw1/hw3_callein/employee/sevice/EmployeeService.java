package com.callein.hw1.hw3_callein.employee.sevice;

import com.callein.hw1.hw3_callein.employee.dto.EmployeeDto;
import com.callein.hw1.hw3_callein.employee.entity.Employee;
import com.callein.hw1.hw3_callein.employee.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ObjectOutputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public void save(EmployeeDto employeeDto){
        Employee employee = Employee.builder()
                .name(employeeDto.getName())
                .salary(employeeDto.getSalary())
                .position(employeeDto.getPosition())
                .build();
        employeeRepository.save(employee);
    }

    public EmployeeDto read(Long id){
        Employee employee = employeeRepository.findById(id).get();
        return EmployeeDto.builder()
                .name(employee.getName())
                .salary(employee.getSalary())
                .position(employee.getPosition())
                .build();
    }

    public List<EmployeeDto> readAll(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream().map(employee ->
                EmployeeDto.builder()
                .name(employee.getName())
                .salary(employee.getSalary())
                .position(employee.getPosition())
                .build()
                ).toList();
        return employeeDtos;
    }

    public void update(Long id, EmployeeDto employeeDto){
        Employee employee = employeeRepository.findById(id).get();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employee.setPosition(employeeDto.getPosition());
        employeeRepository.save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }

    // JPA
}
