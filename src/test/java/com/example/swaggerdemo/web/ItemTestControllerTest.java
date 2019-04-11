/*
 *         File : ItemTestControllerTest.java
 *    Classname : ItemTestControllerTest
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
package com.example.swaggerdemo.web;

import com.example.swaggerdemo.SwaggerDemoApplication;
import com.example.swaggerdemo.dao.ItemDao;
import com.example.swaggerdemo.domain.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ContextConfiguration(classes = { SwaggerDemoApplication.class })
@WebMvcTest
@RunWith(SpringRunner.class)
public class ItemTestControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @MockBean
    private ItemDao dao;


    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void postOneItem() throws Exception {
        Item item = new Item(11, "Xiaoming");

        ObjectMapper mapper = new ObjectMapper();

        when(dao.postOneItem(any())).thenReturn(item);
        when(dao.postOneItem(new Item(11, "Xiaoming"))).thenThrow(new RuntimeException());

        String jsonString = mapper.writeValueAsString(item);

        mvc.perform(post("/v1/items/test")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", Matchers.is(11)))
                .andExpect(jsonPath("$.name", Matchers.is("Xiaoming")));
    }

    @Test
    public void getOneItem() throws Exception {
        when(dao.getOneItem(11)).thenReturn(new Item(11, "Xiaoming"));
        when(dao.getOneItem(12)).thenThrow(new RuntimeException());
        mvc.perform(get("/v1/items/test/11")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", Matchers.is(11)))
                .andExpect(jsonPath("$.name", Matchers.is("Xiaoming")));
    }
}