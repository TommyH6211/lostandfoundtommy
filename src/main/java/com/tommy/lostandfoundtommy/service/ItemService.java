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

    // Read all items in the portal
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Save item (CREATE ONLY)
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // Find item by id
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // Delete item
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    // Update item (FIXED SAFELY, same structure you had)
    public void updateItem(Item updatedItem) {

        Item existing = itemRepository.findById(updatedItem.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid item ID"));

        existing.setTitle(updatedItem.getTitle());
        existing.setDescription(updatedItem.getDescription());
        existing.setLastFound(updatedItem.getLastFound());

        // keep status safe
        if (updatedItem.getStatus() != null) {
            existing.setStatus(updatedItem.getStatus());
        }

        itemRepository.save(existing);
    }

    // Toggle retrieval status (safe)
    public void toggleStatus(Long id) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item ID"));

        if ("Not Retrieved".equals(item.getStatus())) {
            item.setStatus("Retrieved");
        } else {
            item.setStatus("Not Retrieved");
        }

        itemRepository.save(item);
    }
}