package com.xt.demo;

import com.xt.api.client.copytrade.spot.XtSpotCopyTradeApiClientImpl;
import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.copytrade.spot.CopyTradeProfitUpdateReqDTO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xielina
 * @version 1.0
 * @create 2024/6/11 13:52
 */
public class SpotCopyTradeApiClientTest {
    XtSpotCopyTradeApiClientImpl xtSpotApiClient = new XtSpotCopyTradeApiClientImpl(null);

    @Test
    public void testGetCurLeaderOrder() {
        Map<String, String> params = new HashMap<>();
        params.put("type","1");
        CommonResponse commonResponse = xtSpotApiClient.getCurLeaderOrder(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void testGetCurFollowerOrder() {
        Map<String, String> params = new HashMap<>();
        params.put("type","1");
        CommonResponse commonResponse = xtSpotApiClient.getCurFollowerOrder(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void testGetHisFollowerOrder() {
        Map<String, String> params = new HashMap<>();
        params.put("symbol","ont_usdt");
        params.put("direction","NEXT");
        params.put("limit","10");
        CommonResponse commonResponse = xtSpotApiClient.getHisFollowerOrder(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void testGetHisLeaderOrder() {
        Map<String, String> params = new HashMap<>();
        params.put("symbol","ont_usdt");
        params.put("direction","NEXT");
        params.put("limit","10");
        CommonResponse commonResponse = xtSpotApiClient.getHisLeaderOrder(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void testStopProfitLoss() {
        CopyTradeProfitUpdateReqDTO request = CopyTradeProfitUpdateReqDTO.builder()
                .symbol("ont_usdt")
                .leaderOrderId(370761691765619904L)
                .triggerProfitPrice(new BigDecimal("15.0"))
                .triggerStopPrice(new BigDecimal("0.1"))
                .build();
        int scale = request.getTriggerProfitPrice().scale();
        CommonResponse commonResponse = xtSpotApiClient.stopProfitLoss(request);
        System.out.println("result:"+commonResponse);
    }
}
