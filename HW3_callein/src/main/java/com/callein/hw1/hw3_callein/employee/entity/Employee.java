package com.callein.hw1.hw3_callein.employee.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.EnumType.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "salary")
    private Integer salary;
    @Enumerated(STRING)
    @Column(name = "position")
    private Position position;
}
