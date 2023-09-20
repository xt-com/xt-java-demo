package com.xt.api.client.future;

import com.xt.api.dto.FutureCommonResponse;


import java.util.Map;


/**
 * @author zhouzhuang
 * @create 2023/9/20 11:48
 */
public interface XtFutureApiClient {


    FutureCommonResponse postOrder(Map<String, String> params);

    FutureCommonResponse orderListHistory(Map<String, String> params);

    FutureCommonResponse orderTradeList(Map<String, String> params);

    FutureCommonResponse orderDetail(Long orderId);
}
