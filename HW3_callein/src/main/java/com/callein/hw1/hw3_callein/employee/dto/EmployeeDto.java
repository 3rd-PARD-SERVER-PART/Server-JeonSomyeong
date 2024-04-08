package com.callein.hw1.hw3_callein.employee.dto;

import com.callein.hw1.hw3_callein.employee.entity.Position;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private String name;
    private Integer salary;
    private Position position;
}
