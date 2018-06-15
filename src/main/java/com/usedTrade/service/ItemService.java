package com.usedTrade.service;

import com.usedTrade.domain.Item;
import com.usedTrade.domain.Post;
import com.usedTrade.repository.ItemRepository;
import com.usedTrade.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("itemService")
public class ItemService {
    @Autowired
    @Qualifier("itemRepository")
    private ItemRepository itemRepository;

    @Autowired
    @Qualifier("postRepository")
    private PostRepository postRepository;

    //TODO: test this
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.get();
    }

    public List<Item> getItemsByPostId(long id) {
        Optional<Post> post = postRepository.findById(id);
        List<Item> items = itemRepository.findByPost(post.get());
        return items;
    }

//    public List<Item> getItemsByName(String name) {
//        List<Item> items = itemRepository.findByName(name);
//        return items;
//    }
}
