package com.xt.demo;

import com.google.gson.Gson;
import com.xt.api.client.HttpProxyProperties;
import com.xt.api.client.XtWebSocketClient;
import com.xt.api.dto.websocket.Method;
import com.xt.api.dto.websocket.RequestMessage;
import org.java_websocket.client.WebSocketClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzhuang
 * @create 2023/12/12 16:36
 */
public class RyzenUserWebSocketTest {
    Gson gson = new Gson();
    WebSocketClient webSocketClient = null;
    @Before
    public void init(){
        try {
            HttpProxyProperties properties = new HttpProxyProperties();
//            properties.setHost("127.0.0.1");
//            properties.setEnabled(true);
//            properties.setPort(7890);
            webSocketClient = new XtWebSocketClient("wss://stream.xt.com/public");
//            webSocketClient.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(properties.getHost(), properties.getPort())));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        assert webSocketClient != null;
        webSocketClient.connect();
        while (!webSocketClient.isOpen()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @After
    public void after(){

    }

    @Test
    public void subscribeAll(){
        String listenKey="EB346241DFFEA0D7634EEE01520B25291702365643909";
        List<String> params = new ArrayList<>();
        params.add("kline@btc_usdt,1m");

        RequestMessage requestMessage = RequestMessage.builder().id("001").method(Method.SUBSCRIBE.name()).params(params).build();
        webSocketClient.send(gson.toJson(requestMessage));
    }

    @Test
    public void subscribe(){
        List<String> params = new ArrayList<>();
        params.add("depth@btc_usdt,20");

        RequestMessage requestMessage = RequestMessage.builder().id("005").method(Method.SUBSCRIBE.name()).params(params).build();
        webSocketClient.send(gson.toJson(requestMessage));

        while (true){
            try {
                Thread.sleep(30000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("send msg ping");
            webSocketClient.send("ping");
        }
    }


}
