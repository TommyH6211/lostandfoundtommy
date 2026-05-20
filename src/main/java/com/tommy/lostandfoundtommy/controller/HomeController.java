package com.tommy.lostandfoundtommy.controller;

import com.tommy.lostandfoundtommy.model.Item;
import com.tommy.lostandfoundtommy.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    //Read all items in the portal
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "index";
    }

    //Create a new item in the portal
    @GetMapping("/newItem")
    public String newItem(Model model) {
        model.addAttribute("item", new Item());
        return "newItem";
    }

    //Save item
    @PostMapping("/items")
    public String saveItem(@ModelAttribute Item item) {
        item.setStatus("Not Retrieved");
        itemService.saveItem(item);
        return "redirect:/items";
    }

    //Delete item by its id
    @GetMapping("/items/delete/{id}")
    public String deleteItemById(@PathVariable("id") Long id) {
        itemService.deleteItemById(id);
        return "redirect:/";
    }

    //Mark retrieval status of item
    @GetMapping("/items/toggle/{id}")
    public String toggleItemStatus(@PathVariable("id") Long id) {
        itemService.toggleStatus(id);
        return "redirect:/";
    }
}