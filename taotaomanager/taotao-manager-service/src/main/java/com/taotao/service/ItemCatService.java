package com.taotao.service;

import com.taotao.common.bean.EasyUITreeNode;

import java.util.List;

public interface ItemCatService {
    List<EasyUITreeNode> getCatList(long parentId);
}
