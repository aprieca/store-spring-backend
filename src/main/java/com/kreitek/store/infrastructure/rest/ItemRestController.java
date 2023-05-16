package com.kreitek.store.infrastructure.rest;

import com.kreitek.store.application.dto.ItemDTO;
import com.kreitek.store.application.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemRestController {
    private final ItemService itemService;

    @Autowired
    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping(value = "/items",produces = "application/json")
    ResponseEntity<List<ItemDTO>> GetAllItems(){
        List<ItemDTO> items = this.itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/categories/{categoryId}/items",produces = "application/json")
    ResponseEntity<List<ItemDTO>> GetAllItemsByCategory(@PathVariable Long categoryId){
        List<ItemDTO> items = this.itemService.getAllItemsByCategory(categoryId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "items",produces = "application/json",consumes = "application/json")
    ResponseEntity<ItemDTO> insertItem(@RequestBody ItemDTO itemDTO){
        ItemDTO item = this.itemService.insertItem(itemDTO);
        return new ResponseEntity<>(item,HttpStatus.CREATED);
    }

}
