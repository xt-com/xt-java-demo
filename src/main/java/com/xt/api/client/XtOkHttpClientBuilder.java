package com.xt.api.client;

import okhttp3.*;
import okio.Buffer;
import org.apache.commons.codec.digest.HmacUtils;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouzhuang
 * @create 2023/9/20 15:47
 */
public class XtOkHttpClientBuilder {

    private static final String appKey = "ded60ef1-ac8b-435f-912e-72c57618a8e8";
    private static final String secretKey = "1ef01a3e3ea04867d725f3e9583a911ec5575840";
    private static final String encry = "HmacSHA256";
    private static final String contentType = "application/json";
    private static final String window = "60000";

    private static final String HEADER_ALG = "validate-algorithms";
    private static final String HEADER_APPKEY = "validate-appkey";
    private static final String HEADER_WIND = "validate-recvwindow";
    private static final String HEADER_TIME = "validate-timestamp";
    private static final String HEADER_SIGN = "validate-signature";

    public static OkHttpClient build(HttpProxyProperties proxyProperties) {
        ConnectionPool pool = new ConnectionPool(200, 50, TimeUnit.MINUTES);
        int connTimeout = 30;
        int readTimeout = 30;
        int writeTimeOut = 30;
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(connTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeOut, TimeUnit.SECONDS)
                .addInterceptor(commonHeaderInterceptor())
//                .addInterceptor(httpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectionPool(pool);

        if (proxyProperties != null && proxyProperties.isEnabled()) {
            builder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyProperties.getHost(), proxyProperties.getPort())));
        }
        return builder.build();
    }

    private static Interceptor commonHeaderInterceptor() {
        return chain -> {
            Request oldRequest = chain.request(); // 获取旧连接
            Request.Builder requestBuilder = oldRequest.newBuilder(); // 建立新的构建者
            // 将旧请求的请求方法和请求体设置到新请求中
            requestBuilder.method(oldRequest.method(), oldRequest.body());
            // 获取旧请求的头
            Headers headers = oldRequest.headers();
            if (headers != null) {
                Set<String> names = headers.names();
                for (String name : names) {
                    String value = headers.get(name);
                    // 将旧请求的头设置到新请求中
                    requestBuilder.header(name, value);
                }
            }
            Long time = System.currentTimeMillis()-5*1000;
            String path = chain.request().url().uri().getPath();
            String jsonBody = null;
            if(oldRequest.body()!=null && oldRequest.body().contentLength()>0){
                Buffer buffer=new Buffer();
                oldRequest.body().writeTo(buffer);
                jsonBody = buffer.readUtf8();
            }
            String signature = generateSign(String.valueOf(time), window, oldRequest.method().toUpperCase(), path, oldRequest.url().query(), jsonBody);
            config(requestBuilder, String.valueOf(time), signature);
            // 建立新请求连接
            Request newRequest = requestBuilder.build();
            return chain.proceed(newRequest);
        };
    }


    private static void config(Request.Builder requestBuilder, String time, String sign) {
        requestBuilder.header("Content-Type", contentType)
                .header(HEADER_ALG, encry)
                .header(HEADER_APPKEY, appKey)
                .header(HEADER_WIND, window)
                .header(HEADER_TIME, time)
                .header(HEADER_SIGN, sign);
    }


    private static String generateSign(String timestamp, String window, String method, String uri, String query, String jsonBody) {
        String x = String.format(HEADER_ALG+"=%s&"+HEADER_APPKEY+"=%s&"+HEADER_WIND+"=%s&"+HEADER_TIME+"=%s", encry, appKey, window, timestamp);
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
