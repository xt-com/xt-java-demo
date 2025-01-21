package com.xt.demo;

import com.xt.api.client.spot.XtSpotApiClientImpl;
import com.xt.api.client.user.XtUserCenterApiClientImpl;
import com.xt.api.dto.CommonResponse;
import com.xt.api.dto.nft.NftDepositRequest;
import com.xt.api.dto.nft.NftWithdrawRequest;
import com.xt.api.dto.spot.NetworthUpdateRequest;
import com.xt.api.dto.spot.SpotPostOrderRequest;
import com.xt.api.dto.spot.SpotUpdateOrderRequest;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * SPOT Business
 * @author zhouzhuang
 * @create 2023/9/20 16:15
 */
public class UserCenterApiClientTest {

    XtUserCenterApiClientImpl xtUserCenterApiClient = new XtUserCenterApiClientImpl(null);

    @Test
    public void getUserStatistics() {
        CommonResponse commonResponse = xtUserCenterApiClient.getUserStatistics("2795815175054","2023-05-01","2023-05-02");
        System.out.println("result:"+commonResponse);
    }
}
