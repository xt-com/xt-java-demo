package com.xt.api.client.future;

import com.xt.api.client.HttpProxyProperties;
import com.xt.api.client.XtOkHttpClientBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * 合约币本位
 * @author zhouzhuang
 * @create 2023/9/20 12:18
 */
public class XtCFutureApiClientImpl extends AbstractXtFutureApiClient{

    private final static String API_URL = "http://dapi.xt-qa.com";

    private final XtFutureApiService service;

    public XtCFutureApiClientImpl(HttpProxyProperties proxyProperties){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(XtOkHttpClientBuilder.build(proxyProperties))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
        service = retrofit.create(XtFutureApiService.class);
    }

    @Override
    XtFutureApiService getService() {
        return service;
    }
}
