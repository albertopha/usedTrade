package com.usedTrade.controller;

import com.usedTrade.domain.Item;
import com.usedTrade.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/items")
public class ItemController {

    @Autowired
    @Qualifier("itemService")
    private ItemService itemService;

    @GetMapping("/")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable("id") long id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/post")
    public List<Item> getItemsByPostId(@RequestParam("postId") long postId) {
        return itemService.getItemsByPostId(postId);
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item,
                                           @PathVariable("postId") Long postId) {
        Item newItem = itemService.createItem(item, postId);
        return ResponseEntity.ok(newItem);
    }

    @PutMapping("/")
    public ResponseEntity<Item> updateItem(@Valid @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
    }
}
