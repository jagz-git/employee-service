package com.seleniumexpress.employee.request;

import com.seleniumexpress.employee.dto.AddressDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private AddressDetails addressDetails;
}

