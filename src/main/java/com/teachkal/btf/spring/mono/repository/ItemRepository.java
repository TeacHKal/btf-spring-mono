package com.teachkal.btf.spring.mono.repository;

import com.teachkal.btf.spring.mono.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ItemRepository extends CrudRepository<Item, Long> {

}
