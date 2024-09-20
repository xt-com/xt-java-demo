package com.xt.api.client.spot;

import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.spot.NetworthUpdateRequest;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import com.xt.api.dto.spot.SpotUpdateOrderRequest;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * @author zhouzhuang
 * @create 2023/9/20 14:28
 */
public interface XtSpotApiService {

    @POST("/v4/order")
    Call<CommonResponse> postOrder(@Body SpotPostOrderRequest request);

    @GET("/v4/order/{id}")
    Call<CommonResponse> getOrder(@Path("id")Long id);

    @GET("/v4/order")
    Call<CommonResponse> queryOrder(@Query("orderId") Long orderId);

    @DELETE("/v4/order/{id}")
    Call<CommonResponse> delOrder(@Path("id")Long id);

    @PUT("/v4/order/{id}")
    Call<CommonResponse> updateOrder(@Path("id")Long id, @Body SpotUpdateOrderRequest request);

    @PUT("/v4/etf/net-worth")
    Call<CommonResponse> netWorth(@Body NetworthUpdateRequest request);
}
