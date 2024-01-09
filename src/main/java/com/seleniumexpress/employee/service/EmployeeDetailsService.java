package com.seleniumexpress.employee.service;

import com.seleniumexpress.employee.request.EmployeeRequest;
import com.seleniumexpress.employee.response.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeDetailsService {

    List<EmployeeResponse> fetchAllEmployees();
    EmployeeResponse fetchEmployeeById(Long employeeId);
    EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);
    void deleteEmployee(Long employeeId);

}
