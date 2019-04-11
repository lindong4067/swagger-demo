package com.example.swaggerdemo.service;

import com.example.swaggerdemo.dao.ItemDao;
import com.example.swaggerdemo.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemDao dao;

    public Item postOneItem(Item item) {

        return dao.postOneItem(item);
    }

    public Item getOneItem(int id) {

        return dao.getOneItem(id);
    }
}
