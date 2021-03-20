package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.model.Item;
import com.teachkal.btf.spring.mono.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(path = "")
    public @ResponseBody Item save(@RequestBody Item item){
        return itemService.save(item);
    }

    @GetMapping(path = "")
    public @ResponseBody List<Item> findAll(){
        return itemService.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Item> findById(@PathVariable long id){
        return itemService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody boolean deleteById(@PathVariable long id){
        itemService.deleteById(id);
        return true;
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody Item edit(@RequestBody Item item, @PathVariable long id){
        item.setId(id);
        return itemService.save(item);
    }

}
