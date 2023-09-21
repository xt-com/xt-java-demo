package com.xt.api.client.future;

import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.future.FutureBatchOrderRequest;
import com.xt.api.dto.future.FutureOrderCancelAllRequest;
import com.xt.api.dto.future.FutureOrderCancelRequest;
import com.xt.api.dto.future.FuturePostOrderRequest;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhouzhuang
 * @create 2023/9/20 14:28
 */
public interface XtFutureApiService {

    @POST("/future/trade/v1/order/create")
    Call<FutureCommonResponse> makeOrder(@QueryMap Map<String, String> params);

    @POST("/future/trade/v1/order/create")
    Call<FutureCommonResponse> postOrder(@Body FuturePostOrderRequest futurePostOrderRequest);

    @POST("/future/trade/v1/order/create-batch")
    Call<FutureCommonResponse> batchOrder(@Body FutureBatchOrderRequest request);

    @GET("/future/trade/v1/order/list-history")
    Call<FutureCommonResponse> orderListHistory(@QueryMap Map<String, String> params);

    @GET("/future/trade/v1/order/trade-list")
    Call<FutureCommonResponse> orderTradeList(@QueryMap Map<String, String> params);

    @GET("/future/trade/v1/order/detail")
    Call<FutureCommonResponse> orderDetail(@Query("orderId") Long orderId);

    @GET("/future/trade/v1/order/list")
    Call<FutureCommonResponse> orderList(@QueryMap Map<String, String> params);

    @POST("/future/trade/v1/order/cancel")
    Call<FutureCommonResponse> orderCancel(@Body FutureOrderCancelRequest request);

    @POST("/future/trade/v1/order/cancel-all")
    Call<FutureCommonResponse> allCancel(@Body FutureOrderCancelAllRequest request);
}
