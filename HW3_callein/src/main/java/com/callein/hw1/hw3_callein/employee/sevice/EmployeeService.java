package com.callein.hw1.hw3_callein.employee.sevice;

import com.callein.hw1.hw3_callein.employee.dto.EmployeeDto;
import com.callein.hw1.hw3_callein.employee.entity.Employee;
import com.callein.hw1.hw3_callein.employee.entity.Position;
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

    public void saveAll(List<EmployeeDto> employeeDtos){
        List<Employee> employees = employeeDtos.stream().map(employeeDto ->
                Employee.builder()
                        .name(employeeDto.getName())
                        .salary(employeeDto.getSalary())
                        .position(employeeDto.getPosition())
                        .build()
        ).toList();
        employeeRepository.saveAll(employees);
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
        return employees.stream().map(employee ->
                EmployeeDto.builder()
                .name(employee.getName())
                .salary(employee.getSalary())
                .position(employee.getPosition())
                .build()
                ).toList();
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
    public List<EmployeeDto> findByPosition(Position position) {
        List<Employee> employees = employeeRepository.findByPosition(position);
        return employees.stream().map(employee ->
                EmployeeDto.builder()
                        .name(employee.getName())
                        .salary(employee.getSalary())
                        .position(employee.getPosition())
                        .build()
        ).toList();
    }

    public List<EmployeeDto> findBySalaryGreaterThan(Integer salary) {
        List<Employee> employees = employeeRepository.findBySalaryGreaterThan(salary);
        return employees.stream().map(employee ->
                EmployeeDto.builder()
                        .name(employee.getName())
                        .salary(employee.getSalary())
                        .position(employee.getPosition())
                        .build()
        ).toList();
    }

    public List<EmployeeDto> findBySalaryLessThan(Integer salary) {
        List<Employee> employees = employeeRepository.findBySalaryLessThan(salary);
        return employees.stream().map(employee ->
                EmployeeDto.builder()
                        .name(employee.getName())
                        .salary(employee.getSalary())
                        .position(employee.getPosition())
                        .build()
        ).toList();
    }
}
