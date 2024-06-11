package com.xt.api.client.copytrade.spot;

import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.copytrade.spot.CurCopyTradeOrderReqDTO;
import com.xt.api.dto.spot.NetworthUpdateRequest;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import retrofit2.Call;
import retrofit2.http.Body;


/**
 * @author zhouzhuang
 * @create 2023/9/20 11:48
 */
public interface XtSpotCopyTradeApiClient {

    CommonResponse getCurLeaderOrder(@Body CurCopyTradeOrderReqDTO request);
}
