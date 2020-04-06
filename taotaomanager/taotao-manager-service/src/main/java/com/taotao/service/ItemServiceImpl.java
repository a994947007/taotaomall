package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.bean.ItemDesc;
import com.taotao.bean.ItemParamItem;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.bean.Item;
import com.taotao.bean.ItemExample;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.mapper.ItemDescMapper;
import com.taotao.mapper.ItemMapper;
import com.taotao.mapper.ItemParamItemMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemMapper mapper;

    @Autowired
    private ItemDescMapper descMapper;

    @Autowired
    private ItemParamItemMapper itemParamItemMapper;

    @Override
    public Item getItemById(long itemId) {
        ItemExample example = new ItemExample();
        ItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<Item> items = mapper.selectByExample(example);
        if(items != null && items.size() > 0){
            Item item = items.get(0);
            return item;
        }
        return null;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        ItemExample example = new ItemExample();
        PageHelper.startPage(page,rows);
        List<Item> list = mapper.selectByExample(example);
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        easyUIDataGridResult.setRows(list);
        return easyUIDataGridResult;
    }

    //不能try_catch，否则spring无法捕捉到异常，不会进行自动回滚
    @Override
    public TaotaoResult addItem(Item item, ItemDesc itemDesc , ItemParamItem itemParamItem){
        try{
            long itemId = System.currentTimeMillis();
            item.setId(itemId);
            item.setStatus((byte)1);
            Date date = new Date();
            item.setCreated(date);
            item.setUpdated(date);
            mapper.insert(item);

            itemDesc.setItemId(itemId);
            itemDesc.setCreated(date);
            itemDesc.setUpdated(date);
            descMapper.insert(itemDesc);

            itemParamItem.setItemId(itemId);
            itemParamItem.setCreated(date);
            itemParamItem.setUpdated(date);
            itemParamItemMapper.insert(itemParamItem);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
            return TaotaoResult.build(500,"添加异常");
        }

        return TaotaoResult.ok();
    }
}
