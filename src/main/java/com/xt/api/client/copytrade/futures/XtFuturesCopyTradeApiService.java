package com.xt.api.client.copytrade.futures;

import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.copytrade.futures.CopyTradeProfitUpdateReqDTO;
import com.xt.api.dto.copytrade.futures.FollowLeaderDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.Map;


/**
 * @author fonda
 */
public interface XtFuturesCopyTradeApiService {
    @POST("/copytrade/user/v1/copy-trade/apply-leader")
    Call<FutureCommonResponse> applyLeader(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/copy-trade/cancel-leader")
    Call<FutureCommonResponse> cancelLeader(@QueryMap Map<String, String> params);

    @POST("/copytrade/user/v1/copy-trade/choose-leader")
    Call<FutureCommonResponse> chooseLeader(@Body FollowLeaderDTO request);
    @POST("/copytrade/user/v1/copy-trade/cancel-choose-leader")
    Call<FutureCommonResponse> cancelChooseLeader(@QueryMap Map<String, String> params);

    @POST("/copytrade/order/v1/copy-trade/close-all")
    Call<FutureCommonResponse> closeAllOrders(@QueryMap Map<String, String> params);
    @POST("/copytrade/order/v1/copy-trade/close")
    Call<FutureCommonResponse> closeOrder(@QueryMap Map<String, Object> params);

    @POST("/copytrade/order/v1/copy-trade/update-profit-stop")
    Call<FutureCommonResponse> stopProfitLoss(@Body CopyTradeProfitUpdateReqDTO dto);

    @GET("/copytrade/user/v1/public/copy-trade/symbol-list")
    Call<FutureCommonResponse> getAvailableSymbols(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/copy-trade/leader-relation")
    Call<FutureCommonResponse> getFollowInfo(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/copy-trade/leader-detail")
    Call<FutureCommonResponse> getLeaderInfo(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/public/copy-trade/leader-detail-v2")
    Call<FutureCommonResponse> getPublicLeaderInfo(@QueryMap Map<String, String> params);

    @GET("/copytrade/order/v1/copy-trade/follower-order-page")
    Call<FutureCommonResponse> getCurrFollowerOrderPage(@QueryMap Map<String, String> params);
    @GET("/copytrade/order/v1/copy-trade/follower-order-history")
    Call<FutureCommonResponse> getHisFollowerOrderPage(@QueryMap Map<String, String> params);

    @GET("/copytrade/order/v1/copy-trade/leader-order-page")
    Call<FutureCommonResponse> getCurrLeaderOrderPage(@QueryMap Map<String, String> params);
    @GET("/copytrade/order/v1/copy-trade/leader-order-history")
    Call<FutureCommonResponse> getHisLeaderOrderPage(@QueryMap Map<String, String> params);

    @GET("/copytrade/user/v1/copy-trade/my-profit-future")
    Call<FutureCommonResponse> getLeaderFutureProfitDetail(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/copy-trade/my-profit-future-total")
    Call<FutureCommonResponse> getLeaderFutureProfitTotal(@QueryMap Map<String, String> params);

    @GET("/copytrade/user/v1/copy-trade/my-profit-history-detail")
    Call<FutureCommonResponse> getLeaderHistoryProfitDetail(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/copy-trade/my-profit-history")
    Call<FutureCommonResponse> getLeaderHistoryProfitTotal(@QueryMap Map<String, String> params);


    @GET("/copytrade/order/v1/public/copy-trade/leader-order-page")
    Call<FutureCommonResponse> getPublicCurrLeaderOrderPage(@QueryMap Map<String, String> params);
    @GET("/copytrade/order/v1/public/copy-trade/leader-order-history")
    Call<FutureCommonResponse> getPublicHisLeaderOrderPage(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/public/copy-trade/leader-day-income")
    Call<FutureCommonResponse> getPublicLeaderDayIncome(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/public/copy-trade/leader-day-income-rate")
    Call<FutureCommonResponse> getPublicLeaderDayIncomeRate(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/public/copy-trade/leader-follower-page")
    Call<FutureCommonResponse> getPublicLeaderFollowers(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/public/copy-trade/leader-stats")
    Call<FutureCommonResponse> getPublicLeaderStats(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/public/copy-trade/leader-symbol-prefer")
    Call<FutureCommonResponse> getPublicLeaderSymbolPrefer(@QueryMap Map<String, String> params);

    @GET("/copytrade/user/v1/copy-trade/follower-leaders-page")
    Call<FutureCommonResponse> getMyFollowLeaderHistory(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/copy-trade/my-follow-list")
    Call<FutureCommonResponse> getMyFollowLeaderList(@QueryMap Map<String, String> params);
    @GET("/copytrade/user/v1/copy-trade/user-settings")
    Call<FutureCommonResponse> getUserSettings(@QueryMap Map<String, String> params);

}
