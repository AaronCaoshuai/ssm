package com.aaron.controller;

import com.aaron.domain.Item;
import com.aaron.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/queryItemList")
    @ResponseBody
    public List<Item> queryItemList(){
        return itemService.queryItemList();
    }
}
