package com.taotao.service;

import com.taotao.bean.ItemParamItem;
import com.taotao.bean.ItemParamItemExample;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.mapper.ItemParamItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

    @Autowired
    private ItemParamItemMapper mapper;

    @Override
    public TaotaoResult getItemParamItemByItemId(Long itemId) {
        ItemParamItemExample example = new ItemParamItemExample();
        ItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<ItemParamItem> list = mapper.selectByExample(example);
        if(list != null && list.size()>0){
            return TaotaoResult.ok(list.get(0));
        }
        return TaotaoResult.ok();
    }
}
