package com.xt.api.client.future;

import com.xt.api.dto.FutureCommonResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * @author zhouzhuang
 * @create 2023/9/20 14:28
 */
public interface XtFutureApiService {

    @POST("/future/trade/v1/order/create")
    Call<FutureCommonResponse> makeOrder(@QueryMap Map<String, String> params);

    @GET("/future/trade/v1/order/list-history")
    Call<FutureCommonResponse> orderListHistory(@QueryMap Map<String, String> params);

    @GET("/future/trade/v1/order/trade-list")
    Call<FutureCommonResponse> orderTradeList(@QueryMap Map<String, String> params);

    @GET("/future/trade/v1/order/detail")
    Call<FutureCommonResponse> orderDetail(@Query("orderId") Long orderId);
}
