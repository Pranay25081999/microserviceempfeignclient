package com.example.employee.feignClient;

import com.example.employee.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//http://localhost:8081/address-app/api/address/1
@FeignClient(name="abc",url="http://localhost:8081")
public interface AddressClient {
    @GetMapping("/address/{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);
}
