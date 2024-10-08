package com.example.assignment2.controller;

import com.example.assignment2.customStatusCode.SelectedUserAndNoteErrorStatus;
import com.example.assignment2.dto.CustomerStatus;
import com.example.assignment2.dto.ItemStatus;
import com.example.assignment2.dto.impl.CustomerDTO;
import com.example.assignment2.dto.impl.ItemDTO;
import com.example.assignment2.exception.CustomerNotFoundException;
import com.example.assignment2.exception.DataPersistException;
import com.example.assignment2.exception.ItemNotFoundException;
import com.example.assignment2.srvice.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/items")

public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveNote(@RequestBody ItemDTO itemDTO) {
        try {
            itemService.saveItem(itemDTO);
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
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(value = "/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemStatus getSelectedItem(@PathVariable("itemCode") String itemCode) {
        String regexForUserID = "^ITEM-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(itemCode);
        if (!regexMatcher.matches()) {
            return new SelectedUserAndNoteErrorStatus(1, "Item Code is not valid");
        }
        return itemService.getItem(itemCode);
    }

    @DeleteMapping(value = "/{itemCode}")
    public ResponseEntity<Void> deleteNote(@PathVariable ("itemCode") String itemCode){
        String regexForUserID = "^ITEM-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(itemCode);
        try {
            if (!regexMatcher.matches()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.deleteItem(itemCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{itemCode}")
    public ResponseEntity<Void> updateNote(@PathVariable ("itemCode") String itemCode,
                                           @RequestBody ItemDTO updatedItemDTO){
        String regexForUserID = "^ITEM-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(itemCode);
        try {
            if(!regexMatcher.matches() || updatedItemDTO == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(itemCode,updatedItemDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
