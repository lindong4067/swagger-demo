/*
 *         File : ItemDao.java
 *    Classname : ItemDao
 *    Author(s) : eznlzhi
 *      Created : 2019-01-31
 *
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s)
 * have been supplied.
 *
 */

package com.example.swaggerdemo.dao;

import com.example.swaggerdemo.domain.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {

//    List<Integer> dbKeys = new ArrayList<>();
//    Map<Integer, Item> dbValues = new HashMap<>();

    public Item postOneItem(Item item) {
//        int itemId = item.getId();
//        if (!dbKeys.contains(itemId)){
//            dbValues.put(itemId, item);
//            dbKeys.add(itemId);
//        }
        return item;
    }

    public Item getOneItem(int id) {
//        if (dbKeys.contains(id)) {
//            return dbValues.get(id);
//        }
        return null;
    }
}
