package com.taotao.rest.service;

import com.taotao.bean.ItemCat;
import com.taotao.bean.ItemCatExample;
import com.taotao.mapper.ItemCatMapper;
import com.taotao.rest.bean.CatNode;
import com.taotao.rest.bean.CatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService{

    @Autowired
    private ItemCatMapper mapper;

    @Override
    public CatResult getItemCatList() {
        CatResult catResult = new CatResult();
        List<?> list = getListByParantId(0);
        catResult.setData(list);
        return catResult;
    }

    public List<?> getListByParantId(long parentId){
        List list = new ArrayList<>();
        ItemCatExample example = new ItemCatExample();
        ItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<ItemCat> itemCats = mapper.selectByExample(example);
        for (ItemCat itemCat:itemCats) {
            if(itemCat.getIsParent()){
                String url = "/products/"+itemCat.getId()+".html";
                String name;
                if(itemCat.getParentId() == 0){
                    name = "<a href='/products/"+itemCat.getId()+".html'>"+itemCat.getName()+"</a>";
                }else{
                    name = itemCat.getName();
                }
                List<?> items = getListByParantId(itemCat.getId());
                list.add(new CatNode(name,url,items));
            }else{
                list.add("/products/" + itemCat.getId() + ".html|" + itemCat.getName());
            }
        }
        return list;
    }
}
