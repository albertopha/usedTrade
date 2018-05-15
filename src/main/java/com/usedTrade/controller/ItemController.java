package com.usedTrade.controller;

import com.usedTrade.domain.Item;
import com.usedTrade.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Item getItemById(@PathVariable("id") long id) {
        return itemService.getItemById(id);
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<Item> getItemsByPostId(@RequestParam("postId") long postId) {
        return itemService.getItemsByPostId(postId);
    }

    //TODO: test this (@query approach)
    @RequestMapping(value="/name", method=RequestMethod.GET)
    public List<Item> getItemsByName(@RequestParam("name") String name) {
        return itemService.getItemsByName(name);
    }
}
