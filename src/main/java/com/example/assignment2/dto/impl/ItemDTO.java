package com.example.assignment2.dto.impl;

import com.example.assignment2.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemDTO implements ItemStatus {

    private String itemCode;
    private String itemDesc;
    private String itemQty;
    private String price;

}
