package com.example.assignment2.srvice;

import com.example.assignment2.dto.CustomerStatus;
import com.example.assignment2.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerStatus getCustomer(String cusId);
    void deleteCustomer(String cusId);
    void updateCustomer(String cusId, CustomerDTO customerDTO);
}
