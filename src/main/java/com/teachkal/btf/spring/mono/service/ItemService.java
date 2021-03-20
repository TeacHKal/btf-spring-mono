package com.teachkal.btf.spring.mono.service;

import com.teachkal.btf.spring.mono.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);
    List<Item> findAll();
    Optional<Item> findById(Long id);
    boolean deleteById(Long id);
    Item update(Item item, Long id);

}
