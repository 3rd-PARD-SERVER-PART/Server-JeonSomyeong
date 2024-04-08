package com.callein.hw1.hw3_callein.controller;

import com.callein.hw1.hw3_callein.employee.dto.EmployeeDto;
import com.callein.hw1.hw3_callein.employee.entity.Employee;
import com.callein.hw1.hw3_callein.employee.entity.Position;
import com.callein.hw1.hw3_callein.employee.sevice.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("")
    public void save(@RequestBody EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
    }

    @PostMapping("/save/all")
    public void saveAll(@RequestBody List<EmployeeDto> employeeDtos){
        employeeService.saveAll(employeeDtos);
    }

    @GetMapping("/{id}")
    public EmployeeDto readById(@PathVariable Long id){
        return employeeService.read(id);
    }

    @GetMapping("")
    public List<EmployeeDto> readAll(){
        return employeeService.readAll();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                       @RequestBody EmployeeDto employeeDto){
        employeeService.update(id, employeeDto);
        return ResponseEntity.ok().body("{\n\"success\": true\n\"message\": \"업데이트 성공\"\n}");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Employee employee = employeeService.delete(id);
        return ResponseEntity.ok().body("{\n\"success\": true\n\"message\": \"삭제 성공\"\n\"data\": " +
                "{\"name\":\""
                + employee.getName()
                + "\",\"salary\":" + employee.getSalary()
                + ",\"position\":\"" + employee.getPosition() + "\"}}");
    }

//    JPA 적용
//    직급으로 직원 리스팅하기.
    @GetMapping("/position/{position}")
    public List<EmployeeDto> readByPosition(@PathVariable Position position){
        return employeeService.findByPosition(position);
    }
//    급여로 직원 리스팅하기.
    @GetMapping("/find/salary/less/{salary}")
    public List<EmployeeDto> readBySalaryLessThan(@PathVariable Integer salary){
        return employeeService.findBySalaryLessThan(salary);
    }
    @GetMapping("/find/salary/greater/{salary}")
    public List<EmployeeDto> readBySalaryGreaterThan(@PathVariable Integer salary){
        return employeeService.findBySalaryGreaterThan(salary);
    }
//    이름으로 직원 리스팅하기.
    @GetMapping("/find/name/{name}")
    public List<EmployeeDto> findByName(@PathVariable String name){
        return employeeService.findByName(name);
    }
}
