/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pvargas
 */
@RestController
@RequestMapping("/items")
public class ItemController {
    
    @Autowired
    private ItemRepository itemRepository;
    
    @RequestMapping(
        method = RequestMethod.GET
    )
    public List findItems(){
        return itemRepository.findAll();
    }
    
    @RequestMapping(
            method = RequestMethod.POST
    )
    public Item addItem(@RequestBody Item item){
        item.setId(null);
        return itemRepository.saveAndFlush(item);
    }
    
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT
    )
    public Item updateItem(@RequestBody Item updatedItem, @PathVariable Integer id){
        updatedItem.setId(id);
        return itemRepository.saveAndFlush(updatedItem);
    }
    
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public void deleteItem(@PathVariable Integer id){
        itemRepository.delete(id);
    }
    
}
