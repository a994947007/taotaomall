package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.bean.ItemParam;
import com.taotao.bean.ItemParamExample;
import com.taotao.bean.ItemParamWithCatName;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.mapper.ItemParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private ItemParamMapper mapper;

    @Override
    public EasyUIDataGridResult getItemParamList(int page, int rows)  {
        PageHelper.startPage(page,rows);
        List<ItemParamWithCatName> list = mapper.selectItemParamWithNameByPrimaryKey(null);
        PageInfo<ItemParamWithCatName> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        easyUIDataGridResult.setRows(list);
        return easyUIDataGridResult;
    }

    @Override
    public TaotaoResult getItemParamByCid(long itemcatid) {
        ItemParamExample example = new ItemParamExample();
        ItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(itemcatid);
        List<ItemParam> itemParams = mapper.selectByExampleWithBLOBs(example);
        if(itemParams != null && itemParams.size() > 0){
            return TaotaoResult.ok(itemParams.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(ItemParam itemParam) {
        Date date = new Date();
        itemParam.setCreated(date);
        itemParam.setUpdated(date);
        mapper.insert(itemParam);
        return TaotaoResult.ok();
    }
}
