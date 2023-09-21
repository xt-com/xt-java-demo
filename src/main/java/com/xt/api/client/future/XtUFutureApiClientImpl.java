package com.xt.api.client.future;

import com.xt.api.client.HttpProxyProperties;
import com.xt.api.client.XtOkHttpClientBuilder;
import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import com.xt.api.interceptor.XtFutureOkHttpInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Map;


/**
 * 合约U本位
 * @author zhouzhuang
 * @create 2023/9/20 12:18
 */
public class XtUFutureApiClientImpl extends AbstractXtFutureApiClient{

    private final static String API_URL = "http://fapi.xt-qa.com";

    private final XtFutureApiService service;

    public XtUFutureApiClientImpl(HttpProxyProperties proxyProperties){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(XtOkHttpClientBuilder.build(proxyProperties,new XtFutureOkHttpInterceptor()))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(XtFutureApiService.class);
    }

    @Override
    XtFutureApiService getService() {
        return service;
    }


}
