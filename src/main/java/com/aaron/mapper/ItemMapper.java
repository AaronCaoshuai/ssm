package com.aaron.mapper;

import com.aaron.domain.Item;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemMapper {
//    int countByExample(ItemExample example);

//    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

//    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Integer id);

    /*int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);*/

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> queryItemList();
}