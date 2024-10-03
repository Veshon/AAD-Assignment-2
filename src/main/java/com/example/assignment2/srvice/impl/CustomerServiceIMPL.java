package com.example.assignment2.srvice.impl;

import com.example.assignment2.dao.CustomerDAO;
import com.example.assignment2.dto.impl.CustomerDTO;
import com.example.assignment2.entity.impl.CustomerEntity;
import com.example.assignment2.exception.DataPersistException;
import com.example.assignment2.srvice.CustomerService;
import com.example.assignment2.util.AppUtil;
import com.example.assignment2.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    public CustomerDAO customerDAO;

    @Autowired
    public Mapping customerMapping;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCusId(AppUtil.generateNoteId());
        CustomerEntity saveCustomer =
                customerDAO.save(customerMapping.toCustomerEntity(customerDTO));
        if(saveCustomer == null){
            throw new DataPersistException("Customer not saved");
        }
    }
}
