package com.seleniumexpress.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDetails {

    private Long id;
    private String street;
    private String locality;
    private String city;
    private String zip;
    private Long employeeId;

}
