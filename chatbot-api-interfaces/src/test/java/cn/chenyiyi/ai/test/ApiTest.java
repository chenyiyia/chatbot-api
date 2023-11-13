package cn.chenyiyi.ai.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 *
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        //1.创建客户端
        CloseableHttpClient closeableHttpClient=HttpClientBuilder.create().build();
        //2.获得并初始化请求
        HttpGet httpGet=new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        httpGet.addHeader("cookie","zsxq_access_token=4A73E7DE-DAAA-ABC8-DAC3-4A304EE0BA51_A9957C80DE974A03; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415882281214488%22%2C%22first_id%22%3A%2218bb8c0b0fc8bf-08786133e6ff3a-4c657b58-1327104-18bb8c0b0fd11f9%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiYjhjMGIwZmM4YmYtMDg3ODYxMzNlNmZmM2EtNGM2NTdiNTgtMTMyNzEwNC0xOGJiOGMwYjBmZDExZjkiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU4ODIyODEyMTQ0ODgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415882281214488%22%7D%2C%22%24device_id%22%3A%2218bb8c0b0fc8bf-08786133e6ff3a-4c657b58-1327104-18bb8c0b0fd11f9%22%7D; zsxqsessionid=8f004b7430312ebe163305786533704c");
        httpGet.addHeader("Content-Type","application/json, text/plain, */*");
        //3.客户端执行请求并处理数据
        CloseableHttpResponse closeableHttpResponse=closeableHttpClient.execute(httpGet);
        if(closeableHttpResponse.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String result=EntityUtils.toString(closeableHttpResponse.getEntity());
            System.out.println(result);
        }else{
            System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        //1.创建客户端
        CloseableHttpClient closeableHttpClient=HttpClientBuilder.create().build();
        //2.获得并初始化请求
        HttpPost httpPost=new HttpPost("https://api.zsxq.com/v2/topics/188414421845412/comments");
        httpPost.addHeader("cookie","zsxq_access_token=4A73E7DE-DAAA-ABC8-DAC3-4A304EE0BA51_A9957C80DE974A03; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415882281214488%22%2C%22first_id%22%3A%2218bb8c0b0fc8bf-08786133e6ff3a-4c657b58-1327104-18bb8c0b0fd11f9%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiYjhjMGIwZmM4YmYtMDg3ODYxMzNlNmZmM2EtNGM2NTdiNTgtMTMyNzEwNC0xOGJiOGMwYjBmZDExZjkiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU4ODIyODEyMTQ0ODgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415882281214488%22%7D%2C%22%24device_id%22%3A%2218bb8c0b0fc8bf-08786133e6ff3a-4c657b58-1327104-18bb8c0b0fd11f9%22%7D; zsxqsessionid=8f004b7430312ebe163305786533704c; abtest_env=product");
        httpPost.addHeader("Content-Type", "application/json, text/plain, */*");
        String paramJson="{\n"+
                "\"req_data\": {\n"+
            "\"text\": \"你真的好啊\\n\",\n"+
                    "\"image_ids\": [],\n"+
            "\"mentioned_user_ids\": []\n"+
                "}\n"+
        "}";
        StringEntity stringEntity=new StringEntity(paramJson, ContentType.create("text/json","utf-8"));
        httpPost.setEntity(stringEntity);
        //3.客户端执行请求并处理数据
        CloseableHttpResponse closeableHttpResponse=closeableHttpClient.execute(httpPost);
        if(closeableHttpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
            String result=EntityUtils.toString(closeableHttpResponse.getEntity());
            System.out.println(result);
        }else{
            System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());
        }
    }
}
