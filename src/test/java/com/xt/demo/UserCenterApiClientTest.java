package com.xt.demo;

import com.xt.api.client.user.XtUserCenterApiClientImpl;
import com.xt.api.dto.CommonResponse;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void getUserInfo() {
        CommonResponse commonResponse = xtUserCenterApiClient.getUserInfo(6975805522411L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void getBatchUserInfo(){
        CommonResponse commonResponse = xtUserCenterApiClient.getBatchUserInfo(List.of(6975805522411L),1,5);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void getUserDetail(){
        CommonResponse commonResponse = xtUserCenterApiClient.getUserDetail(1735574400000L,1735574400000L,"123",1,5,1);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void getUserState() {
        CommonResponse commonResponse = xtUserCenterApiClient.getUserState(6975805522411L);
        System.out.println("result:"+commonResponse);
    }
}
