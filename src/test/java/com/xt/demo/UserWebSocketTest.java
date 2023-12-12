package com.xt.demo;

import com.google.gson.Gson;
import com.xt.api.client.XtWebSocketClient;
import com.xt.api.dto.websocket.Method;
import com.xt.api.dto.websocket.RequestMessage;
import com.xt.api.dto.websocket.Topic;
import org.java_websocket.client.WebSocketClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzhuang
 * @create 2023/12/12 16:36
 */
public class UserWebSocketTest {
    Gson gson = new Gson();
    WebSocketClient webSocketClient = null;
    @Before
    public void init(){
        try {
            webSocketClient = new XtWebSocketClient("wss://fstream.xt.com/ws/user");
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
        while (true){
            try {
                Thread.sleep(3000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("send msg ping");
            webSocketClient.send("ping");
        }
    }

    @Test
    public void subscribeAll(){
        String listenKey="EB346241DFFEA0D7634EEE01520B25291702365643909";
        List<String> params = new ArrayList<>();
        params.add(Topic.order.name()+"@"+listenKey);
        params.add(Topic.trade.name()+"@"+listenKey);
        params.add(Topic.position.name()+"@"+listenKey);
        params.add(Topic.balance.name()+"@"+listenKey);
        params.add(Topic.notify.name()+"@"+listenKey);
        RequestMessage requestMessage = RequestMessage.builder().id("001").method(Method.SUBSCRIBE.name()).params(params).build();
        webSocketClient.send(gson.toJson(requestMessage));
    }


}
