package com.xt.api.client.copytrade.futures;

import com.xt.api.client.HttpProxyProperties;
import com.xt.api.client.XtOkHttpClientBuilder;
import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.copytrade.futures.CopyTradeProfitUpdateReqDTO;
import com.xt.api.dto.copytrade.futures.FollowLeaderDTO;
import com.xt.api.interceptor.XtSpotOkHttpInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Map;

/**
 * @author fonda
 */
public class XtFuturesCopyTradeApiClientImpl implements XtFuturesCopyTradeApiClient {

    private final static String API_URL = "http://sapi.xt-qa.com";

    private final XtFuturesCopyTradeApiService service;

    public XtFuturesCopyTradeApiClientImpl(HttpProxyProperties proxyProperties){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(XtOkHttpClientBuilder.build(proxyProperties,new XtSpotOkHttpInterceptor()))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(XtFuturesCopyTradeApiService.class);
    }

    @Override
    public FutureCommonResponse applyLeader(Map<String, String> params) {
        return executeSync(service.applyLeader(params));
    }

    @Override
    public FutureCommonResponse cancelLeader(Map<String, String> params) {
        return executeSync(service.cancelLeader(params));
    }

    @Override
    public FutureCommonResponse chooseLeader(FollowLeaderDTO request) {
        return executeSync(service.chooseLeader(request));
    }

    @Override
    public FutureCommonResponse cancelChooseLeader(Map<String, String> params) {
        return executeSync(service.cancelChooseLeader(params));
    }

    @Override
    public FutureCommonResponse closeAllOrders(Map<String, String> params) {
        return executeSync(service.closeAllOrders(params));
    }

    @Override
    public FutureCommonResponse closeOrder(Map<String, Object> params) {
        return executeSync(service.closeOrder(params));
    }

    @Override
    public FutureCommonResponse stopProfitLoss(CopyTradeProfitUpdateReqDTO dto){
        return executeSync(service.stopProfitLoss(dto));
    }

    @Override
    public FutureCommonResponse getAvailableSymbols(Map<String, String> params) {
        return executeSync(service.getAvailableSymbols(params));
    }

    @Override
    public FutureCommonResponse getFollowInfo(Map<String, String> params) {
        return executeSync(service.getFollowInfo(params));
    }

    @Override
    public FutureCommonResponse getLeaderInfo(Map<String, String> params) {
        return executeSync(service.getLeaderInfo(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderInfo(Map<String, String> params) {
        return executeSync(service.getPublicLeaderInfo(params));
    }

    @Override
    public FutureCommonResponse getCurrFollowerOrderPage(Map<String, String> params) {
        return executeSync(service.getCurrFollowerOrderPage(params));
    }

    @Override
    public FutureCommonResponse getHisFollowerOrderPage(Map<String, String> params) {
        return executeSync(service.getHisFollowerOrderPage(params));
    }

    @Override
    public FutureCommonResponse getCurrLeaderOrderPage(Map<String, String> params) {
        return executeSync(service.getCurrLeaderOrderPage(params));
    }

    @Override
    public FutureCommonResponse getHisLeaderOrderPage(Map<String, String> params) {
        return executeSync(service.getHisLeaderOrderPage(params));
    }

    @Override
    public FutureCommonResponse getLeaderFutureProfitDetail(Map<String, String> params) {
        return executeSync(service.getLeaderFutureProfitDetail(params));
    }

    @Override
    public FutureCommonResponse getLeaderFutureProfitTotal(Map<String, String> params) {
        return executeSync(service.getLeaderFutureProfitTotal(params));
    }

    @Override
    public FutureCommonResponse getLeaderHistoryProfitDetail(Map<String, String> params) {
        return executeSync(service.getLeaderHistoryProfitDetail(params));
    }

    @Override
    public FutureCommonResponse getLeaderHistoryProfitTotal(Map<String, String> params) {
        return executeSync(service.getLeaderHistoryProfitTotal(params));
    }

    @Override
    public FutureCommonResponse getPublicCurrLeaderOrderPage(Map<String, String> params) {
        return executeSync(service.getPublicCurrLeaderOrderPage(params));
    }

    @Override
    public FutureCommonResponse getPublicHisLeaderOrderPage(Map<String, String> params) {
        return executeSync(service.getPublicHisLeaderOrderPage(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderDayIncome(Map<String, String> params) {
        return executeSync(service.getPublicLeaderDayIncome(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderDayIncomeRate(Map<String, String> params) {
        return executeSync(service.getPublicLeaderDayIncomeRate(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderFollowers(Map<String, String> params) {
        return executeSync(service.getPublicLeaderFollowers(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderStats(Map<String, String> params) {
        return executeSync(service.getPublicLeaderStats(params));
    }

    @Override
    public FutureCommonResponse getPublicLeaderSymbolPrefer(Map<String, String> params) {
        return executeSync(service.getPublicLeaderSymbolPrefer(params));
    }

    @Override
    public FutureCommonResponse getMyFollowLeaderHistory(Map<String, String> params) {
        return executeSync(service.getMyFollowLeaderHistory(params));
    }

    @Override
    public FutureCommonResponse getMyFollowLeaderList(Map<String, String> params) {
        return executeSync(service.getMyFollowLeaderList(params));
    }

    @Override
    public FutureCommonResponse getUserSettings(Map<String, String> params) {
        return executeSync(service.getUserSettings(params));
    }
    
    public FutureCommonResponse executeSync(Call<FutureCommonResponse> call) {
        try {
            Response<FutureCommonResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }else {
                System.err.println(String.format("failed to call interface:%s, %s", response.code(), response.toString()));
                return FutureCommonResponse.failure(response.toString());
            }
        }catch (Exception e){
            System.err.println("call interface exception:" + e);
            throw new RuntimeException(e);
        }
    }
}
