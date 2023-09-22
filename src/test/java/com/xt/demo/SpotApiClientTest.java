package com.xt.demo;

import com.xt.api.client.spot.XtSpotApiClientImpl;
import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import org.junit.Test;

/**
 * SPOT Business
 * @author zhouzhuang
 * @create 2023/9/20 16:15
 */
public class SpotApiClientTest {

    XtSpotApiClientImpl xtSpotApiClient = new XtSpotApiClientImpl(null);

    @Test
    public void testpostOrder() {
        SpotPostOrderRequest request = SpotPostOrderRequest.builder().symbol("btc_usdt")
                .side("BUY")
                .type("LIMIT")
                .timeInForce("GTC")
                .bizType("SPOT")
                .price("3")
                .quantity("2")
                .build();
        CommonResponse commonResponse = xtSpotApiClient.postOrder(request);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void getOrder() {
        CommonResponse commonResponse = xtSpotApiClient.getOrder(274722413139647104L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void queryOrder() {
        CommonResponse commonResponse = xtSpotApiClient.queryOrder(274722413139647104L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void delOrder() {
        CommonResponse commonResponse = xtSpotApiClient.delOrder(274722413139647104L);
        System.out.println("result:"+commonResponse);
    }
}
