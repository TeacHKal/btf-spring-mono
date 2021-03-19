package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.model.Item;
import com.teachkal.btf.spring.mono.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping(path = "")
    public @ResponseBody Item save(@RequestBody Item item){
        return itemRepository.save(item);
    }

    @GetMapping(path = "")
    public @ResponseBody List<Item> findAll(){
        return (List<Item>)itemRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Item> findById(@PathVariable long id){
        return itemRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody boolean deleteById(@PathVariable long id){
        itemRepository.deleteById(id);
        return true;
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody Item edit(@RequestBody Item item, @PathVariable long id){
        //Item item = itemRepository.findById(id).orElseThrow(RuntimeException::new);
        item.setId(id);
        return itemRepository.save(item);
    }

}
