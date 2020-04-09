package com.taotao.common.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

    public static String doGet(String url, Map<String,String> params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder builder = null;
        CloseableHttpResponse response = null;
        try {
            builder = new URIBuilder(url);
            //获取接收参数
            if(params != null && params.size() >0 ){
                for(Map.Entry<String,String> entry : params.entrySet()){
                    builder.addParameter(entry.getKey(),entry.getValue());
                }
            }
            URI uri = builder.build();
            //创建httpGet
            HttpGet httpGet = new HttpGet(uri);
            //接收报文类型
            httpGet.setHeader("Accept","application/json");
            response = httpClient.execute(httpGet);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity,"UTF-8");
                return jsonString;
            }
            else{
                System.out.println(state);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(httpClient != null){
                    httpClient.close();
                }
                if(response != null){
                    response.close();
                }
            }catch (Exception e){
                e.printStackTrace();;
            }
        }
        return null;
    }

    /**
     * post请求（用于请求json格式的参数）
     * @param url 接口地址
     * @param params 接口参数 json数据结
     * @return
     */
    public static String doPost(String url, String params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httpPost
        HttpPost httpPost = new HttpPost(url);
        //接收报文类型
        httpPost.setHeader("Accept", "application/json");
        //发送报文类型
        httpPost.setHeader("Content-Type", "application/json");
        if(params != null && !"".equals(params)){
            StringEntity entity = new StringEntity(params, "UTF-8");
            httpPost.setEntity(entity);
        }
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity,"UTF-8");
                return jsonString;
            }
            else{
                System.out.println(state);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(response != null){
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

