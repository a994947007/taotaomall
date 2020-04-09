package com.taotao.service;

import com.github.pagehelper.PageInfo;
import com.taotao.bean.Content;
import com.taotao.bean.ContentExample;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.mapper.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements  ContentService{

    @Autowired
    private ContentMapper mapper;

    @Override
    public EasyUIDataGridResult getContentList(Long categoryId) {
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<Content> contents = mapper.selectByExample(example);
        PageInfo<Content> pageInfo = new PageInfo<>(contents);
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        easyUIDataGridResult.setRows(contents);
        return easyUIDataGridResult;
    }

    @Override
    public TaotaoResult insertContent(Content content) {
        Date date = new Date();
        content.setCreated(date);
        content.setUpdated(date);
        mapper.insert(content);
        return TaotaoResult.ok();
    }
}
