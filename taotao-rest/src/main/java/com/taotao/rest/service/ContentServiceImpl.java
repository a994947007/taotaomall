package com.taotao.rest.service;

import com.taotao.bean.Content;
import com.taotao.bean.ContentExample;
import com.taotao.mapper.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private ContentMapper mapper;

    @Override
    public List<Content> getContentList(long categoryId) {
        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        List<Content> contents = mapper.selectByExample(example);
        return contents;
    }
}
