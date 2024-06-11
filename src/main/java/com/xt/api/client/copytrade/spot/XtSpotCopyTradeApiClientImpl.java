package com.xt.api.client.copytrade.spot;

import com.xt.api.client.HttpProxyProperties;
import com.xt.api.client.XtOkHttpClientBuilder;
import com.xt.api.dto.CommonResponse;
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
    public CommonResponse getCurLeaderOrder(@QueryMap Map<String, String> params) {
        return executeSync(service.getCurLeaderOrder(params));
    }

    @Override
    public CommonResponse getCurFollowerOrder(@QueryMap Map<String, String> params){
        return executeSync(service.getCurFollowerOrder(params));
    }

    @Override
    public CommonResponse getHisFollowerOrder(@QueryMap Map<String, String> params){
        return executeSync(service.getHisFollowerOrder(params));
    }

    @Override
    public CommonResponse getHisLeaderOrder(@QueryMap Map<String, String> params){
        return executeSync(service.getHisLeaderOrder(params));
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
