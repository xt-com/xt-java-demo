package com.xt.demo;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouzhuang
 * @create 2022/11/11 10:24
 */
public class OkhttpTest {
    private static final String appKey = "902783e5-bd24-4348-8307-8daa64d711db";
    private static final String secretKey = "fcdba0348f185e373a5e27499be4a0a8a1ca787e";
    private static final String encry = "HmacSHA256";
    private static final String contentType = "application/json";
    private static final String baseUrl = "http://sapi.xt-qa.com";
    private static final String window = "6000";

    @Test
    public void test1() {
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "cat_usdt");
        param.put("side", "BUY");
        param.put("type", "LIMIT");
        param.put("timeInForce", "GTC");
        param.put("bizType", "SPOT");
        param.put("price", "3");
        param.put("quantity", "2");
        MediaType mediaType=MediaType.Companion.parse("application/json;charset=utf-8");
        String jsonBody = JSON.toJSONString(param);
        RequestBody requestBody = RequestBody.Companion.create(jsonBody,mediaType);

        String url = "http://sapi.xt-qa.com/v4/order";
        OkHttpClient client = new OkHttpClient();

        String sign = "";
        String time = System.currentTimeMillis()+"";
        sign = generateSign(time,window,"POST","/v4/order",null,jsonBody);

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type","application/json")
                .addHeader("xt-validate-algorithms", encry)
                .addHeader("xt-validate-appkey", appKey)
                .addHeader("xt-validate-recvwindow", window)
                .addHeader("xt-validate-timestamp", time)
                .addHeader("xt-validate-signature", sign)
                .post(requestBody)
                .build();
        Call call=client.newCall(request);
        try {
            Response response =call.execute();
            System.out.println("get返回状态：" + response.code());
            System.out.println("get返回结果：" + response.body().string());
            response.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateSign(String timestamp, String window, String method, String uri, String query, String jsonBody) {
        String x = String.format("xt-validate-algorithms=%s&xt-validate-appkey=%s&xt-validate-recvwindow=%s&xt-validate-timestamp=%s", encry, appKey, window, timestamp);
        String y = String.format("#%s#%s", method, uri);
        if (query != null && query.length() > 0) {
            y += "#" + query;
        }
        if (jsonBody != null && jsonBody.length() > 0) {
            y += "#" + jsonBody;
        }
        String origin = x + y;
        System.out.println("origion===" + origin);
        return HmacUtils.hmacSha256Hex(secretKey, origin);
    }
}
