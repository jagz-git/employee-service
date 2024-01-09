package com.seleniumexpress.employee.feignClientPackage;

import com.seleniumexpress.employee.dto.AddressDetails;
import jakarta.ws.rs.PathParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "address-service"/*, url = "http://localhost:8080/" //Use the url if not running discovery service */)
public interface AddressFeignClient {

    @GetMapping("/address/addresses")
    public ResponseEntity<List<AddressDetails>> fetchAllAddresses();

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDetails> fetchAddressById(@PathParam(value = "id") Long id);
    @GetMapping("/emp/{employeeId}")
    public ResponseEntity<AddressDetails> fetchAddressByEmployeeId(@PathVariable(value = "employeeId") Long employeeId);
    @PostMapping("/address/save")
    public ResponseEntity<AddressDetails> saveAddress(@RequestBody AddressDetails address);

}
