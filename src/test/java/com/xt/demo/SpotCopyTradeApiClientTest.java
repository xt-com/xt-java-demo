package com.xt.demo;

import com.xt.api.client.copytrade.spot.XtSpotCopyTradeApiClientImpl;
import com.xt.api.dto.CommonResponse;
import org.junit.Test;

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
}
