package com.xt.demo;

import com.google.gson.Gson;
import com.xt.api.client.future.XtBFutureApiClientImpl;
import com.xt.api.client.future.XtFutureApiClient;
import com.xt.api.client.future.XtUFutureApiClientImpl;
import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.future.FuturePostOrderRequest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BTC BASE Future
 * @author zhouzhuang
 * @create 2023/9/20 16:15
 */
public class BFutureApiClientTest {
    Gson gson = new Gson();
    XtFutureApiClient client = new XtBFutureApiClientImpl(null);

    @Test
    public void postOrder(){
        FuturePostOrderRequest request = FuturePostOrderRequest.builder().symbol("btc_usdt")
                .origQty("4")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("26972.9")
                .orderSide("BUY")
                .positionSide("LONG")
                .build();
        FutureCommonResponse commonResponse = client.postOrder(request);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void batchOrder(){
        FuturePostOrderRequest request = FuturePostOrderRequest.builder().symbol("btc_usdt")
                .origQty("4")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("26972.9")
                .orderSide("BUY")
                .positionSide("LONG")
                .build();
        FuturePostOrderRequest request2 = FuturePostOrderRequest.builder().symbol("btc_usdt")
                .origQty("4")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("26972.9")
                .orderSide("BUY")
                .positionSide("LONG")
                .build();
        List<FuturePostOrderRequest> requestList = new ArrayList<>();
        requestList.add(request);
        requestList.add(request2);
        FutureCommonResponse commonResponse = client.batchOrder(requestList);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void orderListHistory() {
        Map<String, String> params = new HashMap<>();
        FutureCommonResponse commonResponse = client.orderListHistory(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void orderTradeList() {
        Map<String, String> params = new HashMap<>();
        FutureCommonResponse commonResponse = client.orderTradeList(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void orderDetail() {
        FutureCommonResponse commonResponse = client.orderDetail(275110136488455424L);
        System.out.println("result:"+commonResponse);
    }
    @Test
    public void orderList() {
        Map<String, String> params = new HashMap<>();
        FutureCommonResponse commonResponse = client.orderList(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void orderCancel() {
        FutureCommonResponse commonResponse = client.orderCancel(275110136488455424L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void allCancel() {
        FutureCommonResponse commonResponse = client.allCancel(null);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void entrustCreatePlan() {
        Map<String, String> params = new HashMap<>();
        params.put("symbol","btc_usdt");
        params.put("orderSide","BUY");
        params.put("entrustType","TAKE_PROFIT");
        params.put("origQty","1");
        params.put("timeInForce","GTC");
        params.put("triggerPriceType","INDEX_PRICE");
        params.put("positionSide","LONG");
        params.put("stopPrice","55");
        FutureCommonResponse commonResponse = client.entrustCreatePlan(params);
        System.out.println("result:"+commonResponse);
    }
    @Test
    public void entrustCancelPlan() {
        FutureCommonResponse commonResponse = client.entrustCancelPlan(275110136488455424L);
        System.out.println("result:"+commonResponse);
    }
    @Test
    public void entrustCancelAllPlan() {
        FutureCommonResponse commonResponse = client.entrustCancelAllPlan("btc_usdt");
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void accountInfo() {
        FutureCommonResponse commonResponse = client.accountInfo();
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void balanceDetail() {
        FutureCommonResponse commonResponse = client.balanceDetail("usdt");
        System.out.println("result:"+commonResponse);
    }


}
