package com.aaron.service.impl;

import com.aaron.domain.Item;
import com.aaron.mapper.ItemMapper;
import com.aaron.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> queryItemList() {
        return itemMapper.queryItemList();
    }
}
