package com.xt.api.client.copytrade.futures;

import com.xt.api.dto.FutureCommonResponse;
import retrofit2.http.QueryMap;

import java.util.Map;



/**
 * @author fonda
 */
public interface XtFuturesCopyTradeApiClient {

    FutureCommonResponse applyLeader(@QueryMap Map<String, String> params);
    FutureCommonResponse cancelLeader(@QueryMap Map<String, String> params);

    FutureCommonResponse chooseLeader(@QueryMap Map<String, String> params);
    FutureCommonResponse cancelChooseLeader(@QueryMap Map<String, String> params);

    FutureCommonResponse closeAllOrders(@QueryMap Map<String, String> params);
    FutureCommonResponse closeOrder(@QueryMap Map<String, String> params);

    FutureCommonResponse stopProfitLoss(@QueryMap Map<String, String> params);

    FutureCommonResponse getAvailableSymbols(@QueryMap Map<String, String> params);
    FutureCommonResponse getFollowInfo(@QueryMap Map<String, String> params);
    FutureCommonResponse getLeaderInfo(@QueryMap Map<String, String> params);
    FutureCommonResponse getPublicLeaderInfo(@QueryMap Map<String, String> params);

    FutureCommonResponse getCurrFollowerOrderPage(@QueryMap Map<String, String> params);
    FutureCommonResponse getHisFollowerOrderPage(@QueryMap Map<String, String> params);

    FutureCommonResponse getCurrLeaderOrderPage(@QueryMap Map<String, String> params);
    FutureCommonResponse getHisLeaderOrderPage(@QueryMap Map<String, String> params);

    FutureCommonResponse getLeaderFutureProfitDetail(@QueryMap Map<String, String> params);
    FutureCommonResponse getLeaderFutureProfitTotal(@QueryMap Map<String, String> params);

    FutureCommonResponse getLeaderHistoryProfitDetail(@QueryMap Map<String, String> params);
    FutureCommonResponse getLeaderHistoryProfitTotal(@QueryMap Map<String, String> params);


    FutureCommonResponse getPublicCurrLeaderOrderPage(@QueryMap Map<String, String> params);
    FutureCommonResponse getPublicHisLeaderOrderPage(@QueryMap Map<String, String> params);
    FutureCommonResponse getPublicLeaderDayIncome(@QueryMap Map<String, String> params);
    FutureCommonResponse getPublicLeaderDayIncomeRate(@QueryMap Map<String, String> params);
    FutureCommonResponse getPublicLeaderFollowers(@QueryMap Map<String, String> params);
    FutureCommonResponse getPublicLeaderStats(@QueryMap Map<String, String> params);
    FutureCommonResponse getPublicLeaderSymbolPrefer(@QueryMap Map<String, String> params);

    FutureCommonResponse getMyFollowLeaderHistroy(@QueryMap Map<String, String> params);
    FutureCommonResponse getMyFollowLeaderList(@QueryMap Map<String, String> params);
    FutureCommonResponse getUserSettings(@QueryMap Map<String, String> params);

}
