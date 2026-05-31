//HomeController handles user requests and returns response necessary from its @'s

package com.tommy.lostandfoundtommy.controller;

//Import a bunch of Spring Framework stuff
import com.tommy.lostandfoundtommy.model.Item;
import com.tommy.lostandfoundtommy.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    //Controller is set to be referring to commands in the service class
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
        return "createItem";
    }

    //Save item
    @PostMapping("/items")
    public String saveItem(@ModelAttribute Item item) {
        item.setStatus("Not Retrieved");
        itemService.saveItem(item);
        return "redirect:/";
    }

    //Delete item from portal chart
    @GetMapping("/items/delete/{id}")
    public String deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/";
    }

    //Switch the retrieval status between 2 cases: retrieved or no
    @GetMapping("/items/toggle/{id}")
    public String toggleItemStatus(@PathVariable Long id) {
        itemService.toggleStatus(id);
        return "redirect:/";
    }

    //Modify item (directly from a button on the portal table)
    @GetMapping("/items/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        Item item = itemService.getItemById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item ID"));
        model.addAttribute("item", item);
        return "editItem";
    }

    //Update item after visiting other templates/html pages by buttons
    @PostMapping("/items/update")
    public String updateItem(@ModelAttribute Item item) {
        itemService.updateItem(item);
        return "redirect:/";
    }
}