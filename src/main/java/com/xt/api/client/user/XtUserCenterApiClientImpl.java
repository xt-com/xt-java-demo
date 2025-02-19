package com.xt.api.client.user;

import com.xt.api.client.HttpProxyProperties;
import com.xt.api.client.XtOkHttpClientBuilder;
import com.xt.api.dto.CommonResponse;
import com.xt.api.interceptor.XtUserCenterOkHttpInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;


/**
 * @author zhouzhuang
 * @create 2023/9/20 12:18
 */
public class XtUserCenterApiClientImpl implements XtUserCenterApiClient {

    private final static String API_URL = "https://api.xt.com";

    private final XtUserCenterApiService service;

    public XtUserCenterApiClientImpl(HttpProxyProperties proxyProperties){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(XtOkHttpClientBuilder.build(proxyProperties,new XtUserCenterOkHttpInterceptor()))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(XtUserCenterApiService.class);
    }

    @Override
    public CommonResponse getUserStatistics(String uid, String startTime, String endTime) {
        return executeSync(service.getUserStatistics(uid,startTime,endTime));
    }

    @Override
    public CommonResponse getUserInfo(Long uid) {
        return executeSync(service.getUserInfo(uid));
    }

    @Override
    public CommonResponse getBatchUserInfo(List<Long> uidList, Long fromId, String direction, Integer limit) {
        return executeSync(service.getBatchUserInfo(uidList, fromId, direction, limit));
    }

    @Override
    public CommonResponse getUserDetail(Long startTime, Long endTime, String inviteCode, Integer type, Long fromId, String direction, Integer limit) {
        return executeSync(service.getUserDetail(startTime, endTime, inviteCode, type, fromId, direction, limit));
    }

    @Override
    public CommonResponse getUserState(Long uid) {
        return executeSync(service.getUserState(uid));
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
