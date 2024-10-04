package com.example.assignment2.srvice.impl;

import com.example.assignment2.customStatusCode.SelectedUserAndNoteErrorStatus;
import com.example.assignment2.dao.CustomerDAO;
import com.example.assignment2.dto.CustomerStatus;
import com.example.assignment2.dto.impl.CustomerDTO;
import com.example.assignment2.entity.impl.CustomerEntity;
import com.example.assignment2.exception.CustomerNotFoundException;
import com.example.assignment2.exception.DataPersistException;
import com.example.assignment2.srvice.CustomerService;
import com.example.assignment2.util.AppUtil;
import com.example.assignment2.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerMapping.asCustomerDTOList(customerDAO.findAll());
    }

    @Override
    public CustomerStatus getCustomer(String cusId) {
        if(customerDAO.existsById(cusId)){
            var selectedUser = customerDAO.getReferenceById(cusId);
            return customerMapping.toCustomerDTO(selectedUser);
        }else {
            return new SelectedUserAndNoteErrorStatus(2, "Selected customer not found");
        }
    }

    @Override
    public void deleteCustomer(String cusId) {
        Optional<CustomerEntity> foundCustomer = customerDAO.findById(cusId);
        if (!foundCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            customerDAO.deleteById(cusId);
        }
    }

    @Override
    public void updateCustomer(String cusId, CustomerDTO customerDTO) {
        Optional<CustomerEntity> findCustomer = customerDAO.findById(cusId);
        if (!findCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            findCustomer.get().setCusName(customerDTO.getCusName());
            findCustomer.get().setCusAddress(customerDTO.getCusAddress());
            findCustomer.get().setCusTeleNo(customerDTO.getCusTeleNo());
        }
    }
}
