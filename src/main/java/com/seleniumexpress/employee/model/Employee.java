package com.seleniumexpress.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    private Long employeeId;
    private String firstName;
    private String lastName;

}
