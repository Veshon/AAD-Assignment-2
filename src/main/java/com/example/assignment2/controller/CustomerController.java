package com.example.assignment2.controller;

import com.example.assignment2.customStatusCode.SelectedUserAndNoteErrorStatus;
import com.example.assignment2.dto.CustomerStatus;
import com.example.assignment2.dto.impl.CustomerDTO;
import com.example.assignment2.exception.DataPersistException;
import com.example.assignment2.srvice.CustomerService;
import com.example.assignment2.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/customers")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveNote(@RequestBody CustomerDTO noteDTO) {
        try {
            customerService.saveCustomer(noteDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{cusId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatus getSelectedCustomer(@PathVariable ("cusId") String cusId){
        String regexForUserID = "^CUSTOMER-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(cusId);
        if (!regexMatcher.matches()) {
            return new SelectedUserAndNoteErrorStatus(1,"Customer ID is not valid");
        }
        return customerService.getCustomer(cusId);
    }
}
