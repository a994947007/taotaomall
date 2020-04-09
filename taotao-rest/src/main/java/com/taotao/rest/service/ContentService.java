package com.taotao.rest.service;

import com.taotao.bean.Content;

import java.util.List;

public interface ContentService {
    List<Content> getContentList(long categoryId);
}
