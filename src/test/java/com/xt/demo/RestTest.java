package com.xt.demo;

import com.alibaba.fastjson.JSON;
import com.xt.api.util.XtHttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouzhuang
 * @create 2022/10/28 15:04
 */
public class RestTest {

    @Test
    public void testpostOrder() {
        String uri = "/v4/order";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("side", "BUY");
        param.put("type", "LIMIT");
        param.put("timeInForce", "GTC");
        param.put("bizType", "SPOT");
        param.put("price", "3");
        param.put("quantity", "2");
        System.out.println("json===="+ JSON.toJSONString(param));
        System.out.println("result====" + XtHttpUtil.post(uri,JSON.toJSONString(param)));
    }

    @Test
    public void getOrder() {
        String uri = "/v4/order/156201996458139136";
        System.out.println("result====" + XtHttpUtil.get(uri, null));
    }

    @Test
    public void queryOrder() {
        String uri = "/v4/order";
        Map<String, Object> param = new HashMap<>();
        param.put("orderId", 156201996458139136L);
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void delOrder() {
        String uri = "/v4/order/156201996458139136";
        System.out.println("result====" + XtHttpUtil.delete(uri, null));
    }

    @Test
    public void batchOrderGet() {
        String uri = "/v4/batch-order";
        Map<String, Object> param = new HashMap<>();
        param.put("orderIds", "156201996458139136,12312313212");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void batchOrderDel() {
        String uri = "/v4/batch-order";
        Map<String, Object> param = new HashMap<>();
        param.put("clientBatchId", "123123111");
        param.put("orderIds", List.of(156201996458139136L, 12312313212L));
        System.out.println("result====" + XtHttpUtil.deleteWithBody(uri, JSON.toJSONString(param)));
    }

    @Test
    public void getOpenOrder() {
        for(int x=0;x<100;x++){
            String uri = "/v4/open-order";
            Map<String, Object> param = new HashMap<>();
            //symbol=cmcx_usdt&bizType=SPOT
            param.put("symbol","cmcx_usdt");
            param.put("bizType","SPOT");
            System.out.println("result====" + XtHttpUtil.get(uri, param));
        }

    }

    @Test
    public void delOpenOrder() {
        String uri = "/v4/open-order";
        Map<String, Object> param = new HashMap<>();
        param.put("bizType", "SPOT");
        System.out.println("result====" + XtHttpUtil.deleteWithBody(uri, JSON.toJSONString(param)));
    }

    @Test
    public void getHistoryOrder() {
        String uri = "/v4/history-order";
        Map<String, Object> param = new HashMap<>();
        param.put("bizType", "SPOT");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }


    @Test
    public void getTrade() {
        String uri = "/v4/trade";
        Map<String, Object> param = new HashMap<>();
        param.put("bizType", "SPOT");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }


    @Test
    public void getBalance() {
        String uri = "/v4/balance";
        Map<String, Object> param = new HashMap<>();
        param.put("currency", "usdt");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void getBalances() {
        String uri = "/v4/balances";
        Map<String, Object> param = new HashMap<>();
        param.put("currencies", "usdt,btc");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }
    
    @Test
    public void getToken() {
        String uri = "/v4/ws-token";
        String token = XtHttpUtil.post(uri, null);
        System.out.println("result====" + token);
    }

    @Test
    public void getToken() {
        String uri = "/v4/ws-token";
//        Map<String, Object> param = new HashMap<>();
        System.out.println("result====" + XtHttpUtil.post(uri, null));
    }

    @Test
    public void deposit() {
        String uri = "/v4/deposit/address";
        Map<String, Object> param = new HashMap<>();
        param.put("chain", "11111");
        param.put("currency", "btc");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void withdraw() {
        String uri = "/v4/withdraw";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("side", "BUY");
        param.put("type", "LIMIT");
        param.put("timeInForce", "GTC");
        param.put("bizType", "SPOT");
        param.put("price", "3");
        param.put("quantity", "2");
        System.out.println("json===="+ JSON.toJSONString(param));
        System.out.println("result====" + XtHttpUtil.post(uri,JSON.toJSONString(param)));
    }

    @Test
    public void transfer() {
        String uri = "/v4/balance/transfer";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("side", "BUY");
        param.put("type", "LIMIT");
        param.put("timeInForce", "GTC");
        param.put("bizType", "SPOT");
        param.put("price", "3");
        param.put("quantity", "2");
        System.out.println("json===="+ JSON.toJSONString(param));
        System.out.println("result====" + XtHttpUtil.post(uri,JSON.toJSONString(param)));
    }

    @Test
    public void accTransfer() {
        String uri = "/v4/balance/account/transfer";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("side", "BUY");
        param.put("type", "LIMIT");
        param.put("timeInForce", "GTC");
        param.put("bizType", "SPOT");
        param.put("price", "3");
        param.put("quantity", "2");
        System.out.println("json===="+ JSON.toJSONString(param));
        System.out.println("result====" + XtHttpUtil.post(uri,JSON.toJSONString(param)));
    }



}
