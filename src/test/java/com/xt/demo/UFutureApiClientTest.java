package com.xt.demo;

import com.xt.api.client.future.XtFutureApiClient;
import com.xt.api.client.future.XtUFutureApiClientImpl;
import com.xt.api.client.spot.XtSpotApiClientImpl;
import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.future.FuturePostOrderRequest;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouzhuang
 * @create 2023/9/20 16:15
 */
public class UFutureApiClientTest {

    XtFutureApiClient client = new XtUFutureApiClientImpl(null);

    @Test
    public void testpostOrder() {
        FuturePostOrderRequest request = FuturePostOrderRequest.builder().symbol("btc_usdt")
                .origQty("4")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("26972.9")
                .orderSide("BUY")
                .positionSide("LONG")
                .build();
        Map<String,String> param = new HashMap<>();
        param.put("symbol","btc_usdt");
        param.put("origQty","4");
        param.put("orderType","LIMIT");
        param.put("timeInForce","GTC");
        param.put("price","btc_usdt");
        param.put("orderSide","BUY");
        param.put("positionSide","LONG");
        FutureCommonResponse commonResponse = client.postOrder(param);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void orderListHistory() {
        Map<String, String> params = new HashMap<>();
        FutureCommonResponse commonResponse = client.orderListHistory(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void queryOrder() {
//        CommonResponse commonResponse = xtSpotApiClient.queryOrder(274722413139647104L);
//        System.out.println("result:"+commonResponse);
    }

    @Test
    public void delOrder() {
//        CommonResponse commonResponse = xtSpotApiClient.delOrder(274722413139647104L);
//        System.out.println("result:"+commonResponse);
    }
}
