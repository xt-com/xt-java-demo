package com.xt.api.client.copytrade.spot;

import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.copytrade.spot.CopyTradeProfitUpdateReqDTO;
import com.xt.api.dto.copytrade.spot.FollowLeaderDTO;
import com.xt.api.dto.copytrade.spot.LeaderSettingsDTO;
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
    
    CommonResponse close(Map<String, String> params);

    CommonResponse closeAll(@QueryMap Map<String, String> params);

    CommonResponse getCopyTradeSymbol(Map<String,String> params);

    CommonResponse getUserStatus(Map<String, String> params);

    CommonResponse getLeaderSettings(Map<String, String> params);

    CommonResponse updateLeaderSetting(LeaderSettingsDTO request);

    CommonResponse getShareProfitHis(Map<String,String> params);

    CommonResponse getShareProfitHisDetail(@QueryMap Map<String,String> params);

    CommonResponse getShareProfitExpectedDetail(@QueryMap Map<String,String> params);

    CommonResponse getShareProfitExpected(@QueryMap Map<String,String> params);

    CommonResponse copyTradeApply();

    CommonResponse cancelLeader();

    CommonResponse getLeaderDetail(Map<String, String> params);

    CommonResponse getMyLeaders(Map<String, String> params);

    CommonResponse getFollowLeaderConfig(Map<String, String> params);

    CommonResponse follow(FollowLeaderDTO request);

    CommonResponse cancelFollow(Map<String, String> params);

    CommonResponse getLeaderStats(Map<String, String> params);

    CommonResponse getLeaderIncomeRate(Map<String, String> params);

    CommonResponse getLeaderTradingPrefer(Map<String, String> params);

    CommonResponse getLeaderOrderPage(Map<String, String> params);

    CommonResponse getLeaderOrderHistory(Map<String, String> params);

    CommonResponse getLeaderFollowers(Map<String, String> params);
}
