package com.tommy.lostandfoundtommy.repository;

import com.tommy.lostandfoundtommy.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}