package com.taotao.rest.service;

import com.taotao.common.bean.TaotaoResult;

public interface RedisService {
    TaotaoResult syncContent(long categoryId);
}
