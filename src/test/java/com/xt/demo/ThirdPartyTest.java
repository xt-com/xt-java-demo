package com.xt.demo;

import com.alibaba.fastjson.JSON;
import com.xt.api.util.XtHttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Third Business
 *
 * @author zhouzhuang
 * @create 2023/9/20 16:15
 */
public class ThirdPartyTest {

    @Test
    public void getToken() {
        String uri = "/public/uaa/oauth2/token";
        Map<String, Object> param = new HashMap<>();
        param.put("client_id", "DDJ7BLK49YUCL97S");
        param.put("client_secret", "79bb9a1fece8a8dd6cb7c89aa85ccc2d8ca116f0");
        param.put("grant_type", "authorization_code");
        param.put("code", "55e3297c-4f3a-4b0f-908a-bfe3de7891c5");
        System.out.println("json====" + JSON.toJSONString(param));
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void refreshToken() {
        String uri = "/public/uaa/oauth2/token";
        Map<String, Object> param = new HashMap<>();
        param.put("client_id", "DDJ7BLK49YUCL97S");
        param.put("client_secret", "79bb9a1fece8a8dd6cb7c89aa85ccc2d8ca116f0");
        param.put("grant_type", "refresh_token");
        param.put("refresh_token", "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI1MjMzMDI1NzQ1NTMxIiwiYWNjb3VudC1pZCI6NTIzMzAyNTc0NTUzMSwidXNlci1pZCI6NTIzMzAyNTc0NTUzMSwic2NvcGUiOiJzcG90QXNzZXRzIiwic2lnbi10eXBlIjoiVVAiLCJhY2NvdW50LWxldmVsIjoxLCJleHAiOjE3MjUyNjU5MDgsImNsaWVudF9pZCI6IkRESjdCTEs0OVlVQ0w5N1MiLCJ0ZW5hbnQtaWQiOjF9.nZojT7pAR14P8UhM02SZvNb338VPX-Gmi261yURHccNiXH_dKv1q6b4EhFtrPVOofnpM_qKgSdQKGMwjWFs39Un-d6wJAMg_Ca0mMCNKUrEEgAI49SScRsTjEfdii3_mk9hytXu5Wo39IJaZzCR9EWX04DZUGEnNQDP5_td-qR0");
        System.out.println("json====" + JSON.toJSONString(param));
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void getOrder() {
        String uri = "/spot/v4/order/156201996458139136";
        System.out.println("result====" + XtHttpUtil.get(uri, null));
    }

    @Test
    public void queryOrder() {
        String uri = "/spot/v4/order";
        Map<String, Object> param = new HashMap<>();
        param.put("orderId", 335861468006563328L);
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void postOrder() {
        String uri = "/spot/v4/order";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "btc_usdt");
        param.put("side", "BUY");
        param.put("type", "LIMIT");
        param.put("timeInForce", "GTC");
        param.put("bizType", "SPOT");
        param.put("price", "3");
        param.put("quantity", "2");
        System.out.println("json====" + JSON.toJSONString(param));
        System.out.println("result====" + XtHttpUtil.post(uri, JSON.toJSONString(param)));
    }

    @Test
    public void delOrder() {
        String uri = "/spot/v4/order/156201996458139136";
        System.out.println("result====" + XtHttpUtil.delete(uri, null));
    }

    @Test
    public void batchOrderGet() {
        String uri = "/spot/v4/batch-order";
        Map<String, Object> param = new HashMap<>();
        param.put("orderIds", "156201996458139136,12312313212");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void batchOrderDel() {
        String uri = "/spot/v4/batch-order";
        Map<String, Object> param = new HashMap<>();
        param.put("clientBatchId", "123123111");
        param.put("orderIds", List.of(156201996458139136L, 12312313212L));
        System.out.println("result====" + XtHttpUtil.deleteWithBody(uri, JSON.toJSONString(param)));
    }

    @Test
    public void getOpenOrder() {
        String uri = "/spot/v4/open-order";
        Map<String, Object> param = new HashMap<>();
        param.put("symbol", "cmcx_usdt");
        param.put("bizType", "SPOT");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void delOpenOrder() {
        String uri = "/spot/v4/open-order";
        Map<String, Object> param = new HashMap<>();
        param.put("bizType", "SPOT");
        System.out.println("result====" + XtHttpUtil.deleteWithBody(uri, JSON.toJSONString(param)));
    }

    @Test
    public void getHistoryOrder() {
        String uri = "/spot/v4/history-order";
        Map<String, Object> param = new HashMap<>();
        param.put("bizType", "SPOT");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void getTrade() {
        String uri = "/spot/v4/trade";
        Map<String, Object> param = new HashMap<>();
        param.put("bizType", "SPOT");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void getSpotBalance() {
        String uri = "/spot/v4/balance";
        Map<String, Object> param = new HashMap<>();
        param.put("currency", "usdt");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }

    @Test
    public void getSpotBalances() {
        String uri = "/spot/v4/balances";
        Map<String, Object> param = new HashMap<>();
        param.put("currencies", "usdt,btc");
        System.out.println("result====" + XtHttpUtil.get(uri, param));
    }
}
