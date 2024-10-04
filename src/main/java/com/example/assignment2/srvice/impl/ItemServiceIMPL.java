package com.example.assignment2.srvice.impl;

import com.example.assignment2.customStatusCode.SelectedUserAndNoteErrorStatus;
import com.example.assignment2.dao.ItemDAO;
import com.example.assignment2.dto.ItemStatus;
import com.example.assignment2.dto.impl.ItemDTO;
import com.example.assignment2.entity.impl.CustomerEntity;
import com.example.assignment2.entity.impl.ItemEntity;
import com.example.assignment2.exception.DataPersistException;
import com.example.assignment2.srvice.ItemService;
import com.example.assignment2.util.AppUtil;
import com.example.assignment2.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class ItemServiceIMPL implements ItemService {

    @Autowired
    public ItemDAO itemDAO;

    @Autowired
    public Mapping itemMapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setItemCode(AppUtil.generateItemId());
        ItemEntity saveItem =
                itemDAO.save(itemMapping.toItemEntity(itemDTO));
        if(saveItem == null){
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return itemMapping.asItemDTOList(itemDAO.findAll());
    }

    @Override
    public ItemStatus getItem(String itemCode) {
        if(itemDAO.existsById(itemCode)){
            var selectedItem = itemDAO.getReferenceById(itemCode);
            return itemMapping.toItemDTO(selectedItem);
        }else {
            return new SelectedUserAndNoteErrorStatus(2, "Selected item not found");
        }
    }

    @Override
    public void deleteItem(String itemCode) {

    }

    @Override
    public void updateItem(String itemCode, ItemDTO itemDTO) {

    }
}
