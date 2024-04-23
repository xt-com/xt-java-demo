package com.xt.api.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.GlobalHeaders;
import cn.hutool.http.HttpRequest;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhouzhuang
 * @create 2022/10/28 10:48
 */
public class XtHttpUtil {
    private static final String appKey = "DDJ7BLK49YUCL97S";
    private static final String secretKey = "79bb9a1fece8a8dd6cb7c89aa85ccc2d8ca116f0";
    private static final String encry = "HmacSHA256";
    private static final String contentType = "application/json";
    private static final String baseUrl = "https://oapi.xt.com";
    private static final String window = "6000";
    private static final String accessToken = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI1MzU2OTIwMTExOTg0IiwiYWNjb3VudC1pZCI6NTM1NjkyMDExMTk4NCwidXNlci1pZCI6NTM1NjkyMDExMTk4NCwic2NvcGUiOiJ1c2VyaW5mbyIsInNpZ24tdHlwZSI6IlVQIiwiYWNjb3VudC1sZXZlbCI6MSwiZXhwIjoxNzExNjA5MzUzLCJjbGllbnRfaWQiOiJEREo3QkxLNDlZVUNMOTdTIiwidGVuYW50LWlkIjoxfQ.QPkkyI8MOKya9zrEiZGOkE8Qaq1gNFMwd6Fro1Iob93Rm_MRk5nfo-NM_cQZ8CId4TfYM2OtnwhDe4OfkAsrY8j43aXruniKkc5Z_4hGx14EjkzX_SbLnXDHL-ztuBWuAT9nMfl84pBbKBGRdEmlBLPHiS5qi1FHb6EXdPJeYpI";
    static {
        GlobalHeaders.INSTANCE.clearHeaders();
    }

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
        System.out.println("request===="+httpRequest.getMethod()+" "+httpRequest);
        return httpRequest.execute().body();
    }

    public static String post(String uri, String jsonBody) {
        Long time = System.currentTimeMillis();
        String url = baseUrl + uri;
        String signature = generateSign(time + "", window, "POST", uri, null, jsonBody);
        HttpRequest httpRequest = HttpRequest.post(url);
        config(httpRequest, time + "", signature);
        httpRequest.body(jsonBody);
        System.out.println("request===="+httpRequest.getMethod()+" "+httpRequest);
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
        System.out.println("request===="+httpRequest.getMethod()+" "+httpRequest);
        return httpRequest.execute().body();
    }

    private static void config(HttpRequest httpRequest, String time, String sign) {
        httpRequest
                .contentType(contentType)
                .timeout(3000)
                .header("validate-algorithms", encry)
                .header("validate-appkey", appKey)
                .header("validate-recvwindow", window)
                .header("validate-timestamp", time)
                .header("validate-signature", sign)
                .header("access-token", accessToken);
//                .setHttpProxy("127.0.0.1",7890);
    }


    private static String generateSign(String timestamp, String window, String method, String uri, String query, String jsonBody) {
        String x = String.format("validate-algorithms=%s&validate-appkey=%s&validate-recvwindow=%s&validate-timestamp=%s", encry, appKey, window, timestamp);
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
