package com.taotao.service;

import com.taotao.bean.ItemCat;
import com.taotao.bean.ItemCatExample;
import com.taotao.common.bean.EasyUITreeNode;
import com.taotao.mapper.ItemCatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper mapper;

    @Override
    public List<EasyUITreeNode> getCatList(long parentId) {
        ItemCatExample example = new ItemCatExample();
        ItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<ItemCat> itemCats = mapper.selectByExample(example);
        List<EasyUITreeNode> list = new ArrayList<>();
        for(ItemCat itemCat:itemCats){
            EasyUITreeNode node = new EasyUITreeNode(itemCat.getId(),itemCat.getName(),itemCat.getIsParent()?"closed":"open");
            list.add(node);
        }
        return list;
    }
}
