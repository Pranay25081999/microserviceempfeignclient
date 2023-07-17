package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.feignClient.AddressClient;
import com.example.employee.repository.EmployeeRepo;
import com.example.employee.response.AddressResponse;
import com.example.employee.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int id){



        Employee employee=employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse=modelMapper.map(employee,EmployeeResponse.class);
        AddressResponse addressResponse=  addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
}
