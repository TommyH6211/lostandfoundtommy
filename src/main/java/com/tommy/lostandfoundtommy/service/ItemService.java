package com.tommy.lostandfoundtommy.service;

import com.tommy.lostandfoundtommy.model.Item;
import com.tommy.lostandfoundtommy.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //Read all items in the portal
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    //Save item
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    //Find a single item by its id
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    //Delete item by its id
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    //Mark retrieval status of item
    public void toggleStatus(Long id) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item ID"));
        if (item.getStatus().equals("Not Retrieved")) {
            item.setStatus("Retrieved");
        }
        else {
            item.setStatus("Not Retrieved");
        }
        itemRepository.save(item);
    }
}

