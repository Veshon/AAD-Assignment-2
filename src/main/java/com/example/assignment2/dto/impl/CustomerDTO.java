package com.example.assignment2.dto.impl;

import com.example.assignment2.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerDTO implements CustomerStatus {

    private String cusId;
    private String cusName;
    private String cusAddress;
    private int cusTeleNo;

}
