package com.tommy.lostandfoundtommy.repository;

import com.tommy.lostandfoundtommy.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

//Important replacement of writing SQL
public interface ItemRepository extends JpaRepository<Item, Long> {
}