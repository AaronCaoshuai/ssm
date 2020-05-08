package com.aaron.service;

import com.aaron.domain.Item;

import java.util.List;

public interface ItemService {
    /**
     * 查询订单列表
     *
     * @return
     */
    List<Item> queryItemList();

}
