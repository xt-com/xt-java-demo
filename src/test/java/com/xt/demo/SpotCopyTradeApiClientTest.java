package com.xt.demo;

import com.xt.api.client.copytrade.spot.XtSpotCopyTradeApiClientImpl;
import com.xt.api.client.spot.XtSpotApiClientImpl;
import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.copytrade.spot.CurCopyTradeOrderReqDTO;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import org.junit.Test;

/**
 * @author xielina
 * @version 1.0
 * @create 2024/6/11 13:52
 */
public class SpotCopyTradeApiClientTest {
    XtSpotCopyTradeApiClientImpl xtSpotApiClient = new XtSpotCopyTradeApiClientImpl(null);

    @Test
    public void testGetCurLeaderOrder() {
        CurCopyTradeOrderReqDTO request = CurCopyTradeOrderReqDTO.builder()
                .type(1)
                .build();
        CommonResponse commonResponse = xtSpotApiClient.getCurLeaderOrder(request);
        System.out.println("result:"+commonResponse);
    }
}
