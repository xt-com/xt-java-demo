package com.xt.api.client.copytrade.spot;

import com.xt.api.dto.CommonResponse;
import retrofit2.http.QueryMap;

import java.util.Map;


/**
 * @author zhouzhuang
 * @create 2023/9/20 11:48
 */
public interface XtSpotCopyTradeApiClient {

    CommonResponse getCurLeaderOrder(@QueryMap Map<String, String> params);

    CommonResponse getCurFollowerOrder(@QueryMap Map<String, String> params);

    CommonResponse getHisFollowerOrder(@QueryMap Map<String, String> params);

    CommonResponse getHisLeaderOrder(@QueryMap Map<String, String> params);
}
