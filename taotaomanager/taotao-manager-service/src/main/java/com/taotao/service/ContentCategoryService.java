package com.taotao.service;

import com.taotao.common.bean.EasyUITreeNode;
import com.taotao.common.bean.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {
    List<EasyUITreeNode> getCategoryList(long parentId);
    TaotaoResult addCategory(long parentId,String name);
    TaotaoResult deleteCategory(long id);
    TaotaoResult updateCategory(Long id, String name);
}
