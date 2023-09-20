package com.xt.api.client.future;

import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.future.FuturePostOrderRequest;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Map;

/**
 * @author zhouzhuang
 * @create 2023/9/20 18:23
 */
public abstract class AbstractXtFutureApiClient implements XtFutureApiClient{

    @Override
    public FutureCommonResponse postOrder(Map<String, String> params) {
        return executeSync(getService().makeOrder(params));
    }
    @Override
    public FutureCommonResponse orderListHistory(Map<String, String> params) {
        return executeSync(getService().orderListHistory(params));
    }

    @Override
    public FutureCommonResponse orderTradeList(Map<String, String> params) {
        return executeSync(getService().orderTradeList(params));
    }

    @Override
    public FutureCommonResponse orderDetail(Long orderId) {
        return executeSync(getService().orderDetail(orderId));
    }



    public FutureCommonResponse executeSync(Call<FutureCommonResponse> call) {
        try {
            Response<FutureCommonResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }else {
                System.err.println(String.format("接口调用失败:%s,%s",response.code(),response.toString()));
                return FutureCommonResponse.failure(response.toString());
            }
        }catch (Exception e){
            System.err.println("接口调用异常:"+e);
            throw new RuntimeException(e);
        }
    }

    abstract XtFutureApiService getService();
}
