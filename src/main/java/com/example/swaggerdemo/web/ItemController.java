package com.example.swaggerdemo.web;

import com.example.swaggerdemo.domain.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("Item Management")
public class ItemController {

    @GetMapping("/items/{id}")
    @ApiOperation(value = "find one item by id", notes = "find one item by id")
    @ApiImplicitParam(name = "id", value = "Item ID", paramType = "path", required = true, dataType = "Integer")
    public Item getOneItem(@PathVariable int id) {
        //TODO
        return new Item(id, "JIM");
    }

    @PostMapping("/items")
    @ApiOperation(value = "create one item", notes = "create one item")
    @ApiImplicitParam(name = "Item", value = "Item ID", paramType = "body", required = true, dataType = "Item")
    public Item postOneItem(@RequestBody Item item) {
        //TODO
        return item;
    }
}
