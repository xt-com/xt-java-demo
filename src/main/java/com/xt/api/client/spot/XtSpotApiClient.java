package com.xt.api.client.spot;

import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.spot.SpotPostOrderRequest;


/**
 * @author zhouzhuang
 * @create 2023/9/20 11:48
 */
public interface XtSpotApiClient {


    CommonResponse postOrder(SpotPostOrderRequest request);

    CommonResponse getOrder(Long id);

    CommonResponse queryOrder(Long orderId);

    CommonResponse delOrder(Long id);
}
