package com.tommy.lostandfoundtommy.controller;

import com.tommy.lostandfoundtommy.model.Item;
import com.tommy.lostandfoundtommy.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Read all items in the portal
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "index";
    }

    // Create a new item in the portal
    @GetMapping("/newItem")
    public String newItem(Model model) {
        model.addAttribute("item", new Item());
        return "createItem";
    }

    // Save item
    @PostMapping("/items")
    public String saveItem(@ModelAttribute Item item) {
        item.setStatus("Not Retrieved");
        itemService.saveItem(item);   // FIXED (was wrong before)
        return "redirect:/";
    }

    // Delete item
    @GetMapping("/items/delete/{id}")
    public String deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/";
    }

    // Toggle retrieval status
    @GetMapping("/items/toggle/{id}")
    public String toggleItemStatus(@PathVariable Long id) {
        itemService.toggleStatus(id);
        return "redirect:/";
    }

    // Modify item
    @GetMapping("/items/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {

        Item item = itemService.getItemById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item ID"));

        model.addAttribute("item", item);
        return "editItem";
    }

    // Update item
    @PostMapping("/items/update")
    public String updateItem(@ModelAttribute Item item) {
        itemService.updateItem(item);
        return "redirect:/";
    }
}