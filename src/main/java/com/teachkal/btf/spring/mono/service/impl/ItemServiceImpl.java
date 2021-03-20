package com.teachkal.btf.spring.mono.service.impl;

import com.teachkal.btf.spring.mono.model.Item;
import com.teachkal.btf.spring.mono.repository.ItemRepository;
import com.teachkal.btf.spring.mono.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return (List<Item>)itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        itemRepository.deleteById(id);
        return true;
    }

    @Override
    public Item update(Item item, Long id) {
        item.setId(id);
        return itemRepository.save(item);
    }
}
