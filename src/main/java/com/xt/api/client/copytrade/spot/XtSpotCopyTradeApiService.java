package com.xt.api.client.copytrade.spot;

import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.copytrade.spot.CopyTradeProfitUpdateReqDTO;
import com.xt.api.dto.copytrade.spot.FollowLeaderDTO;
import com.xt.api.dto.copytrade.spot.LeaderSettingsDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * @author zhouzhuang
 * @create 2023/9/20 14:28
 */
public interface XtSpotCopyTradeApiService {

    @GET("/v1/copy-trade-order/copy-trade/order/cur-leader-order")
    Call<CommonResponse> getCurLeaderOrder(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-order/copy-trade/order/cur-follower-order")
    Call<CommonResponse> getCurFollowerOrder(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-order/copy-trade/order/his-follower-order")
    Call<CommonResponse> getHisFollowerOrder(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-order/copy-trade/order/his-leader-order")
    Call<CommonResponse> getHisLeaderOrder(@QueryMap Map<String, String> params);

    @POST("/v1/copy-trade-order/copy-trade/order/stop-profit-loss")
    Call<CommonResponse> stopProfitLoss(@Body CopyTradeProfitUpdateReqDTO request);

    @POST("/v1/copy-trade-order/copy-trade/order/sell")
    Call<CommonResponse> sell(@QueryMap Map<String, String> params);

    @POST("/v1/copy-trade-order/copy-trade/order/sell-all")
    Call<CommonResponse> sellAll(@QueryMap Map<String, String> params);

    @POST("/v1/copy-trade-order/copy-trade/order/close")
    Call<CommonResponse> close(@QueryMap Map<String, String> params);

    @POST("/v1/copy-trade-order/copy-trade/order/close-all")
    Call<CommonResponse> closeAll(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-market/public/copy-trade/symbol")
    Call<CommonResponse> getCopyTradeSymbol(@QueryMap Map<String,String> params);

    @GET("/v1/copy-trade-account/copy-trade/user-status")
    Call<CommonResponse> getUserStatus(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-account/copy-trade/leader-settings")
    Call<CommonResponse> getLeaderSettings(@QueryMap Map<String,String> params);

    @POST("/v1/copy-trade-account/copy-trade/leader-settings")
    Call<CommonResponse> updateLeaderSetting(@Body LeaderSettingsDTO request);

    @GET("/v1/copy-trade-balance/copy-trade/share-profit/his")
    Call<CommonResponse> getShareProfitHis(@QueryMap Map<String,String> params);

    @GET("/v1/copy-trade-balance/copy-trade/share-profit/his-detail")
    Call<CommonResponse> getShareProfitHisDetail(@QueryMap Map<String,String> params);

    @GET("/v1/copy-trade-balance/copy-trade/share-profit/expected-detail")
    Call<CommonResponse> getShareProfitExpectedDetail(@QueryMap Map<String,String> params);

    @GET("/v1/copy-trade-balance/copy-trade/share-profit/expected")
    Call<CommonResponse> getShareProfitExpected(@QueryMap Map<String,String> params);

    @POST("/v1/copy-trade-account/copy-trade/apply")
    Call<CommonResponse> copyTradeApply();

    @POST("/v1/copy-trade-account/copy-trade/cancel-leader")
    Call<CommonResponse> cancelLeader();

    @GET("/v1/copy-trade-account/public/copy-trade/leader-detail")
    Call<CommonResponse> getLeaderDetail(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-account/copy-trade/my-leaders")
    Call<CommonResponse> getMyLeaders(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-account/copy-trade/follow-leader-config")
    Call<CommonResponse> getFollowLeaderConfig(@QueryMap Map<String, String> params);

    @POST("/v1/copy-trade-account/copy-trade/follow")
    Call<CommonResponse> follow(@Body FollowLeaderDTO request);

    @POST("/v1/copy-trade-account/copy-trade/cancel-follow")
    Call<CommonResponse> cancelFollow(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-balance/public/copy-trade/leader-stats")
    Call<CommonResponse> getLeaderStats(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-balance/public/copy-trade/leader-income-rate")
    Call<CommonResponse> getLeaderIncomeRate(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-balance/public/copy-trade/leader-trading-prefer")
    Call<CommonResponse> getLeaderTradingPrefer(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-order/public/copy-trade/order/leader-order-page")
    Call<CommonResponse> getLeaderOrderPage(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-order/public/copy-trade/order/leader-order-history")
    Call<CommonResponse> getLeaderOrderHistory(@QueryMap Map<String, String> params);

    @GET("/v1/copy-trade-account/copy-trade/leader-followers")
    Call<CommonResponse> getLeaderFollowers(@QueryMap Map<String, String> params);
}
