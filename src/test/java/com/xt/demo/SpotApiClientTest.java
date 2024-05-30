package com.xt.demo;

import com.xt.api.client.spot.XtSpotApiClientImpl;
import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.spot.NetworthUpdateRequest;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import org.junit.Test;

import java.math.BigDecimal;

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
                .price("64814.16")
                .quantity("0.001")
                .media("btok")
                .mediaChannel("btok123")
                .build();
        CommonResponse commonResponse = xtSpotApiClient.postOrder(request);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void getOrder() {
        CommonResponse commonResponse = xtSpotApiClient.getOrder(351569051824340480L);
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

    @Test
    public void netWorth() {
        NetworthUpdateRequest request = NetworthUpdateRequest.builder().symbol("btc3l_usdt").netWorth(BigDecimal.valueOf(1.2)).build();
        CommonResponse commonResponse = xtSpotApiClient.netWorth(request);
        System.out.println("result:"+commonResponse);
    }
}
