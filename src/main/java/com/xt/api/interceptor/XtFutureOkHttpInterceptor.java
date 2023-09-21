package com.xt.api.interceptor;


import org.apache.commons.codec.digest.HmacUtils;
/**
 * future filter
 * @author zhouzhuang
 * @create 2023/9/21 10:43
 */
public class XtFutureOkHttpInterceptor extends XtAbstractOkHttpInterceptor {

    //sign=XY,X=”validate-appkey=3976eb88-76d0-4f6e-a6b2-a57980770085&validate-timestamp=1641446237201”,Y=#path#query#body。
    @Override
    protected String generateSign(String timestamp, String window, String method, String uri, String query, String jsonBody) {
        String x = String.format(HEADER_APPKEY+"=%s&"+HEADER_TIME+"=%s",appKey,timestamp);
        String y = String.format("#%s", uri);
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
