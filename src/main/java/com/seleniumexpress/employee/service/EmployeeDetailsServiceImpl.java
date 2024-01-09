package com.seleniumexpress.employee.service;

import com.seleniumexpress.employee.dto.AddressDetails;
import com.seleniumexpress.employee.feignClientPackage.AddressFeignClient;
import com.seleniumexpress.employee.model.Employee;
import com.seleniumexpress.employee.repository.EmployeeRepository;
import com.seleniumexpress.employee.request.EmployeeRequest;
import com.seleniumexpress.employee.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AddressFeignClient addressFeignClient;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<EmployeeResponse> fetchAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        ResponseEntity<List<AddressDetails>> listResponseEntity = addressFeignClient.fetchAllAddresses();
        List<AddressDetails> allAddresses = listResponseEntity.getBody();
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for(Employee employee : allEmployees){
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setEmployeeId(employee.getEmployeeId());
            employeeResponse.setFirstName(employee.getFirstName());
            employeeResponse.setLastName(employee.getLastName());
            allAddresses.stream().filter(eachAddressDetails -> Objects.equals(employee.getEmployeeId(), eachAddressDetails.getEmployeeId())).forEach(employeeResponse::setAddressDetails);
            employeeResponses.add(employeeResponse);
        }
        return employeeResponses;
    }

    @Override
    public EmployeeResponse fetchEmployeeById(Long employeeId) {
        Optional<Employee> employeeDetailsOptional = employeeRepository.findById(employeeId);
        Employee employee = employeeDetailsOptional.get();
        ResponseEntity<AddressDetails> addressDetailsResponseEntity = addressFeignClient.fetchAddressById(employeeId);
        AddressDetails addressDetails = addressDetailsResponseEntity.getBody();
        return new EmployeeResponse(employee.getEmployeeId(),
                employee.getFirstName(), employee.getLastName(), addressDetails);
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        /*Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setFirstName("Aa");
        employee.setLastName("Bb");
        Employee savedEmployee = employeeRepository.save(employee);
        AddressDetails addressDetails = new AddressDetails();
        addressDetails.setEmployeeId(1L);
        addressDetails.setId(100L);
        addressDetails.setStreet("18");
        addressDetails.setLocality("Happy Street");
        addressDetails.setCity("Happy");
        addressDetails.setZip("H1");
        ResponseEntity<AddressDetails> addressDetailsResponseEntity = addressFeignClient.saveAddress(addressDetails);
        AddressDetails savedAddressdetails = addressDetailsResponseEntity.getBody();
        return new EmployeeResponse(savedEmployee.getEmployeeId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), savedAddressdetails);*/
        return null;
    }

    @Override
    public void deleteEmployee(Long employeeId) {

    }
}
