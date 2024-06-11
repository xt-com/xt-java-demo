package com.xt.api.client.copytrade.spot;

import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.copytrade.spot.CopyTradeProfitUpdateReqDTO;
import retrofit2.http.Body;
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

    CommonResponse stopProfitLoss(@Body CopyTradeProfitUpdateReqDTO request);

    CommonResponse sell(Map<String, String> params);

    CommonResponse sellAll(Map<String, String> params);
}
