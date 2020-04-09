package com.taotao.portal.service;

import com.taotao.bean.Content;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.portal.bean.IndexAd;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    private static final Integer HEIGHT = 240;
    private static final Integer WIDTH = 670;
    private static final Integer WIDTH_B = 55;

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_INDEX_AD_URL}")
    private String REST_INDEX_AD_URL;

    @Override
    public List<IndexAd> getContentList() {
        List<IndexAd> indexAdList = new ArrayList<>();
        try{
            String restJson = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL,null);
            TaotaoResult taotaoResult = TaotaoResult.formatToList(restJson, Content.class);
            List<Content> list = (List<Content>)taotaoResult.getData();
            for(Content content:list){
                IndexAd indexAd = new IndexAd();
                indexAd.setSrc(content.getPic());
                indexAd.setHeight(HEIGHT);
                indexAd.setWidth(WIDTH);
                indexAd.setSrcB(content.getPic2());
                indexAd.setWidthB(WIDTH_B);
                indexAd.setHeightB(HEIGHT);
                indexAd.setHref(content.getUrl());
                indexAd.setAlt(content.getSubTitle());
                indexAdList.add(indexAd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return indexAdList;
    }
}
