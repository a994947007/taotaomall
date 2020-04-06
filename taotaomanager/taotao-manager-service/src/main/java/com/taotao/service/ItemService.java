package com.taotao.service;

import com.taotao.bean.ItemDesc;
import com.taotao.bean.ItemParamItem;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.bean.Item;
import com.taotao.common.bean.TaotaoResult;

public interface ItemService {
    Item getItemById(long itemId);
    EasyUIDataGridResult getItemList(int page,int rows);
    TaotaoResult addItem(Item item, ItemDesc itemDesc, ItemParamItem itemParamItem);
}
