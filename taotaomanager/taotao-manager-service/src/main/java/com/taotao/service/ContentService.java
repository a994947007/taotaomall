package com.taotao.service;

import com.taotao.bean.Content;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.common.bean.TaotaoResult;

public interface ContentService {
    EasyUIDataGridResult getContentList(Long categoryId);
    TaotaoResult insertContent(Content content);
}
