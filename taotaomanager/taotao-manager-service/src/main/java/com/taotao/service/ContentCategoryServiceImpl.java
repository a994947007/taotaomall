package com.taotao.service;

import com.taotao.bean.Content;
import com.taotao.bean.ContentCategory;
import com.taotao.bean.ContentCategoryExample;
import com.taotao.common.bean.EasyUITreeNode;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.mapper.ContentCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService{

    @Autowired
    private ContentCategoryMapper mapper;

    @Override
    public List<EasyUITreeNode> getCategoryList(long parentId) {
        ContentCategoryExample example = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<ContentCategory> contentCategories = mapper.selectByExample(example);
        List<EasyUITreeNode> list = new ArrayList<>();
        for(ContentCategory contentCategory:contentCategories){
            list.add(new EasyUITreeNode(contentCategory.getId(),contentCategory.getName(),
                    contentCategory.getIsParent()?"closed":"open"));
        }
        return list;
    }

    @Override
    public TaotaoResult addCategory(long parentId, String name) {
        ContentCategory contentCategory = new ContentCategory();
        contentCategory.setName(name);
        contentCategory.setParentId(parentId);
        contentCategory.setIsParent(false);
        contentCategory.setSortOrder(1);    //1表示正常，2表示逻辑删除
        Date date = new Date();
        contentCategory.setCreated(date);
        mapper.insert(contentCategory);

        ContentCategory parentCategory = new ContentCategory();
        parentCategory.setIsParent(true);
        parentCategory.setId(parentId);
        mapper.updateByPrimaryKeySelective(parentCategory);
        return TaotaoResult.ok(contentCategory);
    }

    @Override
    public TaotaoResult deleteCategory(long id) {
        ContentCategory deleteCategory = mapper.selectByPrimaryKey(id);
        ContentCategoryExample example = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        mapper.deleteByExample(example);
        ContentCategoryExample parentExample = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria1 = parentExample.createCriteria();
        criteria1.andParentIdEqualTo(deleteCategory.getParentId());
        List<ContentCategory> list = mapper.selectByExample(parentExample);
        if(list == null || list.size() == 0){
            ContentCategory parentCategory = new ContentCategory();
            parentCategory.setIsParent(false);
            parentCategory.setId(deleteCategory.getParentId());
            mapper.updateByPrimaryKeySelective(parentCategory);
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateCategory(Long id, String name) {
        ContentCategory contentCategory = mapper.selectByPrimaryKey(id);
        if(contentCategory != null){
            contentCategory.setName(name);
            mapper.updateByPrimaryKeySelective(contentCategory);
        }
        return TaotaoResult.ok();
    }
}
