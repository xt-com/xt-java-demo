package com.xt.api.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpRequest;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhouzhuang
 * @create 2022/10/28 10:48
 */
public class XtHttpUtil {
    private static final String appKey = "";
    private static final String secretKey = "";
    private static final String encry = "HmacSHA256";
    private static final String contentType = "application/json";
    private static final String baseUrl = "http://sapi.xt.com";
    private static final String window = "6000";

    public static String get(String uri, Map<String, Object> queryMap) {
        return getOrDel(uri, queryMap, "GET");
    }

    public static String delete(String uri, Map<String, Object> queryMap) {
        return getOrDel(uri, queryMap, "DELETE");
    }

    public static String deleteWithBody(String uri, String jsonBody) {
        Long time = System.currentTimeMillis();
        String url = baseUrl + uri;
        String signature = generateSign(time + "", window, "DELETE", uri, null, jsonBody);
        HttpRequest httpRequest = HttpRequest.delete(url);
        config(httpRequest, time + "", signature);
        httpRequest.body(jsonBody);
        return httpRequest.execute().body();
    }

    public static String post(String uri, String jsonBody) {
        Long time = System.currentTimeMillis();
        String url = baseUrl + uri;
        String signature = generateSign(time + "", window, "POST", uri, null, jsonBody);
        HttpRequest httpRequest = HttpRequest.post(url);
        config(httpRequest, time + "", signature);
        httpRequest.body(jsonBody);
        return httpRequest.execute().body();
    }

    private static String getOrDel(String uri, Map<String, Object> queryMap, String method) {
        Long time = System.currentTimeMillis();
        String url = baseUrl + uri;
        StringBuilder querySb = new StringBuilder();
        String query = null;
        if (!CollectionUtil.isEmpty(queryMap)) {
            TreeMap<String, Object> treeMap = new TreeMap(queryMap);
            for (String key : treeMap.keySet()) {
                querySb.append(key).append("=").append(queryMap.get(key)).append("&");
            }
            String substring = querySb.substring(0, querySb.lastIndexOf("&"));
            url += "?" + substring;
            query = substring;
        }
        String signature = generateSign(time + "", window, method, uri, query, null);
        HttpRequest httpRequest = null;
        if ("GET".equalsIgnoreCase(method)) {
            httpRequest = HttpRequest.get(url);
        } else if ("DELETE".equalsIgnoreCase(method)) {
            httpRequest = HttpRequest.delete(url);
        }
        config(httpRequest, time + "", signature);
        return httpRequest.execute().body();
    }

    private static void config(HttpRequest httpRequest, String time, String sign) {
        httpRequest
                .contentType(contentType)
                .timeout(3000)
                .header("xt-validate-algorithms", encry)
                .header("xt-validate-appkey", appKey)
                .header("xt-validate-recvwindow", window)
                .header("xt-validate-timestamp", time)
                .header("xt-validate-signature", sign);
//                .setHttpProxy("127.0.0.1",7890);
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
