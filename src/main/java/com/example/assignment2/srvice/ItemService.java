package com.example.assignment2.srvice;

import com.example.assignment2.dto.ItemStatus;
import com.example.assignment2.dto.impl.CustomerDTO;
import com.example.assignment2.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    List<ItemDTO> getAllItems();
    ItemStatus getItem(String itemCode);
    void deleteItem(String itemCode);
    void updateItem(String itemCode, ItemDTO itemDTO);
}
