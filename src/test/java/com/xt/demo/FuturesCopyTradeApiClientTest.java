package com.xt.demo;

import com.xt.api.client.copytrade.futures.XtFuturesCopyTradeApiClientImpl;
import com.xt.api.dto.FutureCommonResponse;
import com.xt.api.dto.copytrade.futures.CopyTradeProfitUpdateReqDTO;
import com.xt.api.dto.copytrade.futures.FollowLeaderDTO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fonda
 */
public class FuturesCopyTradeApiClientTest {

    XtFuturesCopyTradeApiClientImpl xtFuturesApiClient = new XtFuturesCopyTradeApiClientImpl(null);

    @Test
    public void testStopProfitLoss() {
        CopyTradeProfitUpdateReqDTO request = CopyTradeProfitUpdateReqDTO.builder()
                .trackNo(370761691765619904L)
                .triggerProfitPrice(new BigDecimal("15.0"))
                .triggerStopPrice(new BigDecimal("0.1"))
                .triggerPriceType("MARK_PRICE")
                .build();
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.stopProfitLoss(request);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testCloseAllOrders() {
        Map<String, String> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        params.put("closeLongShortType", "LONG");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.closeAllOrders(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testCloseOrder() {
        Map<String, Object> params = new HashMap<>();
        params.put("trackNo", 370800430378335424L);
        params.put("leaderOrder", Boolean.TRUE);
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.closeOrder(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetCurrLeaderOrderPage() {
        Map<String, String> params = new HashMap<>();
        params.put("type", "1");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getCurrLeaderOrderPage(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetHisLeaderOrderPage() {
        Map<String, String> params = new HashMap<>();
        params.put("type", "1");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getHisLeaderOrderPage(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetCurrFollowerOrderPage() {
        Map<String, String> params = new HashMap<>();
        params.put("type", "1");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getCurrFollowerOrderPage(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetHisFollowerOrderPage() {
        Map<String, String> params = new HashMap<>();
        params.put("type", "1");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getHisFollowerOrderPage(params);
        System.out.println("result: " + futureCommonResponse);
    }


    @Test
    public void testGetCopyTradeSymbol(){
        Map<String, String> params = new HashMap<>();
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getAvailableSymbols(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetLeaderInfo(){
        Map<String, String> params = new HashMap<>();
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getLeaderInfo(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetPublicLeaderInfo(){
        Map<String, String> params = new HashMap<>();
        params.put("accountId", "370800430378335424");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getPublicLeaderInfo(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetFollowerInfo(){
        Map<String, String> params = new HashMap<>();
        params.put("accountId", "leaderAccountId");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getFollowInfo(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetUserSettings(){
        Map<String, String> params = new HashMap<>();
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getUserSettings(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testApplyLeader(){
        Map<String, String> params = new HashMap<>();
        params.put("nickName", "123abc");
        params.put("images", "http://123.png,http://345.png");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.applyLeader(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testCancelLeader(){
        Map<String, String> params = new HashMap<>();
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.cancelLeader(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testChooseLeader(){
        FollowLeaderDTO request = FollowLeaderDTO.builder()
                .leaderAccountId(5589391507863L)
                .followType("RATE")
                .followVal(new BigDecimal("1"))
                .autoFollowSymbol(true)
                .followLoss(null)
                .followLossOperate("LEADER_CLOSE")
                .symbols("xt_usdt,ont_usdt,btc3l_usdt,btc_usdt,eth_usdt,etc_usdt,elf_usdt,sc_usdt,dcr_usdt,xrp_usdt,xlm2_usdt,doge_usdt,fil6_usdt,sol_usdt,bsv_usdt,btx_usdt,xtt_usdt")
                .triggerStopRate(null)
                .triggerProfitRate(null)
                .build();
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.chooseLeader(request);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testCancelChooseLeader(){
        Map<String, String> params = new HashMap<>();
        params.put("leaderAccountId", "5589391507863");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.cancelChooseLeader(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetMyFollowLeaderList(){
        Map<String, String> params = new HashMap<>();
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getMyFollowLeaderList(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetMyFollowLeaderHistory(){
        Map<String, String> params = new HashMap<>();
        params.put("type", "2");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getMyFollowLeaderHistory(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetPublicLeaderStats(){
        Map<String, String> params = new HashMap<>();
        params.put("accountId", "5589391507863");
        params.put("days", "7");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getPublicLeaderStats(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetPublicLeaderDayIncome(){
        Map<String, String> params = new HashMap<>();
        params.put("accountId", "5589391507863");
        params.put("days", "7");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getPublicLeaderDayIncome(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetPublicLeaderDayIncomeRate(){
        Map<String, String> params = new HashMap<>();
        params.put("accountId", "5589391507863");
        params.put("days", "7");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getPublicLeaderDayIncomeRate(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetLeaderTradingPrefer(){
        Map<String, String> params = new HashMap<>();
        params.put("accountId", "5589391507863");
        params.put("recentDays", "7");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getPublicLeaderSymbolPrefer(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetPublicCurrLeaderOrderPage(){
        Map<String, String> params = new HashMap<>();
        params.put("leaderAccountId", "5589391507863");
        params.put("symbol", "ont_usdt");
        params.put("type", "1");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getPublicCurrLeaderOrderPage(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetPublicHisLeaderOrderPage(){
        Map<String, String> params = new HashMap<>();
        params.put("leaderAccountId", "5589391507863");
        params.put("symbol", "ont_usdt");
        params.put("type", "1");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getPublicHisLeaderOrderPage(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetPublicLeaderFollowers(){
        Map<String, String> params = new HashMap<>();
        params.put("leaderAccountId","5589391507863");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getPublicLeaderFollowers(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetLeaderFutureProfitDetail(){
        Map<String, String> params = new HashMap<>();
        params.put("direction", "NEXT");
        params.put("limit", "2");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getLeaderFutureProfitDetail(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetLeaderFutureProfitTotal(){
        Map<String, String> params = new HashMap<>();
        params.put("direction", "NEXT");
        params.put("limit", "2");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getLeaderFutureProfitTotal(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetLeaderHistoryProfitDetail(){
        Map<String, String> params = new HashMap<>();
        params.put("direction", "NEXT");
        params.put("limit", "2");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getLeaderHistoryProfitDetail(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetLeaderHistoryProfitTotal(){
        Map<String, String> params = new HashMap<>();
        params.put("direction", "NEXT");
        params.put("limit", "2");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getLeaderHistoryProfitTotal(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testGetLeverageList(){
        Map<String, String> params = new HashMap<>();
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.getLeverageList(params);
        System.out.println("result: " + futureCommonResponse);
    }

    @Test
    public void testAdjustLeverage(){
        Map<String, String> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        params.put("leverage", "20");
        FutureCommonResponse futureCommonResponse = xtFuturesApiClient.adjustLeverage(params);
        System.out.println("result: " + futureCommonResponse);
    }

}
