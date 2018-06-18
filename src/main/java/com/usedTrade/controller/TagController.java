package com.usedTrade.controller;

import com.usedTrade.domain.Tag;
import com.usedTrade.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    @Qualifier("tagService")
    private TagService tagService;

    @GetMapping("/")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{tagId}")
    public Tag getTagById(@PathVariable("tagId") Long tagId) {
        return tagService.getTagById(tagId);
    }

    @GetMapping("")
    public Tag getTagByName(@RequestParam("name") String name) {
        return tagService.getTagByName(name);
    }

    @PostMapping("/")
    public ResponseEntity<Tag> createTag(@Valid @RequestBody Tag tag) {
        Tag newTag = tagService.createTag(tag);
        return ResponseEntity.ok(newTag);
    }

    @PutMapping("/")
    public ResponseEntity<Tag> updateTag(@Valid @RequestBody Tag tag) {
        Tag updatedTag = tagService.createTag(tag);
        return ResponseEntity.ok(updatedTag);
    }

    @DeleteMapping("/{tagId}")
    public void deleteTag(@PathVariable("tagId") Long tagId) {
        tagService.deleteTag(tagId);
    }
}
