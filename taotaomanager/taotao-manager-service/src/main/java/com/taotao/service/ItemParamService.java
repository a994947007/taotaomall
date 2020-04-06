package com.taotao.service;

import com.taotao.bean.ItemParam;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.common.bean.TaotaoResult;

public interface ItemParamService {
    EasyUIDataGridResult getItemParamList(int page,int rows);

    TaotaoResult getItemParamByCid(long itemcatid);

    TaotaoResult insertItemParam(ItemParam itemParam);
}
