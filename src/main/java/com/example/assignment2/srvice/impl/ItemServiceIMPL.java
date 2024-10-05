package com.example.assignment2.srvice.impl;

import com.example.assignment2.customStatusCode.SelectedUserAndNoteErrorStatus;
import com.example.assignment2.dao.ItemDAO;
import com.example.assignment2.dto.ItemStatus;
import com.example.assignment2.dto.impl.ItemDTO;
import com.example.assignment2.entity.impl.CustomerEntity;
import com.example.assignment2.entity.impl.ItemEntity;
import com.example.assignment2.exception.CustomerNotFoundException;
import com.example.assignment2.exception.DataPersistException;
import com.example.assignment2.exception.ItemNotFoundException;
import com.example.assignment2.srvice.ItemService;
import com.example.assignment2.util.AppUtil;
import com.example.assignment2.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<ItemEntity> foundItem = itemDAO.findById(itemCode);
        if (!foundItem.isPresent()) {
            throw new ItemNotFoundException("Item not found");
        }else {
            itemDAO.deleteById(itemCode);
        }
    }

    @Override
    public void updateItem(String itemCode, ItemDTO itemDTO) {
        Optional<ItemEntity> findItem = itemDAO.findById(itemCode);
        if (!findItem.isPresent()) {
            throw new ItemNotFoundException("Item not found");
        }else {
            findItem.get().setItemDesc(itemDTO.getItemDesc());
            findItem.get().setItemQty(itemDTO.getItemQty());
            findItem.get().setPrice(itemDTO.getPrice());
        }
    }
}
