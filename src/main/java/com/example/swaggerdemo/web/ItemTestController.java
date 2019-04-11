package com.example.swaggerdemo.web;

import com.example.swaggerdemo.domain.Item;
import com.example.swaggerdemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;

@RestController
@ResponseBody
@Validated
public class ItemTestController {

    @Autowired
    private ItemService service;

    @PostMapping("/v1/items/test")
    @ResponseBody
    public Item postOneItem(@RequestBody Item item) {
        //TODO
        return service.postOneItem(item);
    }

    @GetMapping("/v1/items/test/{id}/{node}/{cid_cell}")
    @ResponseBody
    public Item getOneItem(@PathVariable int id,
                           @PathVariable String node,
                           @Pattern(regexp = "^([0-9]+)-([0-9]+)-([0-9]+)$") @PathVariable String cid_cell) {
        //TODO
        return service.getOneItem(id);
    }
}
