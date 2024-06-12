package com.xt.api.client.copytrade.spot;

import com.xt.api.client.HttpProxyProperties;
import com.xt.api.client.XtOkHttpClientBuilder;
import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.copytrade.spot.CopyTradeProfitUpdateReqDTO;
import com.xt.api.dto.copytrade.spot.FollowLeaderDTO;
import com.xt.api.dto.copytrade.spot.LeaderSettingsDTO;
import com.xt.api.interceptor.XtSpotOkHttpInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.QueryMap;

import java.util.Map;


/**
 * @author zhouzhuang
 * @create 2023/9/20 12:18
 */
public class XtSpotCopyTradeApiClientImpl implements XtSpotCopyTradeApiClient {

    private final static String API_URL = "https://sapi.xt.com";

    private final XtSpotCopyTradeApiService service;

    public XtSpotCopyTradeApiClientImpl(HttpProxyProperties proxyProperties){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(XtOkHttpClientBuilder.build(proxyProperties,new XtSpotOkHttpInterceptor()))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(XtSpotCopyTradeApiService.class);
    }

    @Override
    public CommonResponse getCurLeaderOrder(Map<String, String> params) {
        return executeSync(service.getCurLeaderOrder(params));
    }

    @Override
    public CommonResponse getCurFollowerOrder(Map<String, String> params){
        return executeSync(service.getCurFollowerOrder(params));
    }

    @Override
    public CommonResponse getHisFollowerOrder(Map<String, String> params){
        return executeSync(service.getHisFollowerOrder(params));
    }

    @Override
    public CommonResponse getHisLeaderOrder(Map<String, String> params){
        return executeSync(service.getHisLeaderOrder(params));
    }

    @Override
    public CommonResponse stopProfitLoss(CopyTradeProfitUpdateReqDTO request){
        return executeSync(service.stopProfitLoss(request));
    }

    @Override
    public CommonResponse sell(Map<String, String> params){
        return executeSync(service.sell(params));
    }

    @Override
    public CommonResponse sellAll(Map<String, String> params){
        return executeSync(service.sellAll(params));
    }

    @Override
    public CommonResponse close(Map<String, String> params){
        return executeSync(service.close(params));
    }

    @Override
    public CommonResponse closeAll(@QueryMap Map<String, String> params){
        return executeSync(service.closeAll(params));
    }

    @Override
    public CommonResponse getCopyTradeSymbol(Map<String,String> params){
        return executeSync(service.getCopyTradeSymbol(params));
    }

    @Override
    public CommonResponse getUserStatus(Map<String, String> params){
        return executeSync(service.getUserStatus(params));
    }

    @Override
    public CommonResponse getLeaderSettings(Map<String, String> params){
        return executeSync(service.getLeaderSettings(params));
    }

    @Override
    public CommonResponse updateLeaderSetting(LeaderSettingsDTO request){
        return executeSync(service.updateLeaderSetting(request));
    }

    @Override
    public CommonResponse getShareProfitHis(Map<String,String> params){
        return executeSync(service.getShareProfitHis(params));
    }

    @Override
    public CommonResponse getShareProfitHisDetail(@QueryMap Map<String,String> params){
        return executeSync(service.getShareProfitHisDetail(params));
    }

    @Override
    public CommonResponse getShareProfitExpectedDetail(@QueryMap Map<String,String> params){
        return executeSync(service.getShareProfitExpectedDetail(params));
    }

    @Override
    public CommonResponse getShareProfitExpected(@QueryMap Map<String,String> params){
        return executeSync(service.getShareProfitExpected(params));
    }

    @Override
    public CommonResponse copyTradeApply(){
        return executeSync(service.copyTradeApply());
    }

    @Override
    public CommonResponse cancelLeader(){
        return executeSync(service.cancelLeader());
    }

    @Override
    public CommonResponse getLeaderDetail(@QueryMap Map<String, String> params){
        return executeSync(service.getLeaderDetail(params));
    }

    @Override
    public CommonResponse getMyLeaders(@QueryMap Map<String, String> params){
        return executeSync(service.getMyLeaders(params));
    }

    @Override
    public CommonResponse getFollowLeaderConfig(Map<String, String> params){
        return executeSync(service.getFollowLeaderConfig(params));
    }

    @Override
    public CommonResponse follow(FollowLeaderDTO request){
        return executeSync(service.follow(request));
    }

    @Override
    public CommonResponse cancelFollow(Map<String, String> params){
        return executeSync(service.cancelFollow(params));
    }

    @Override
    public CommonResponse getLeaderStats(@QueryMap Map<String, String> params){
        return executeSync(service.getLeaderStats(params));
    }

    @Override
    public CommonResponse getLeaderIncomeRate(Map<String, String> params){
        return executeSync(service.getLeaderIncomeRate(params));
    }

    @Override
    public CommonResponse getLeaderTradingPrefer(Map<String, String> params){
        return executeSync(service.getLeaderTradingPrefer(params));
    }

    @Override
    public CommonResponse getLeaderOrderPage(@QueryMap Map<String, String> params){
        return executeSync(service.getLeaderOrderPage(params));
    }

    @Override
    public CommonResponse getLeaderOrderHistory(Map<String, String> params){
        return executeSync(service.getLeaderOrderHistory(params));
    }

    @Override
    public CommonResponse getLeaderFollowers(Map<String, String> params){
        return executeSync(service.getLeaderFollowers(params));
    }

    public CommonResponse executeSync(Call<CommonResponse> call) {
        try {
            Response<CommonResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }else {
                System.err.println(String.format("failed to call interface:%s,%s",response.code(),response.toString()));
                return CommonResponse.failure(response.toString());
            }
        }catch (Exception e){
            System.err.println("call interface exception:"+e);
            throw new RuntimeException(e);
        }
    }
}
