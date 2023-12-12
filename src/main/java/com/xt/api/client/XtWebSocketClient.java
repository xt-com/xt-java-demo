package com.xt.api.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author zhouzhuang
 * @create 2023/12/12 17:06
 */
public class XtWebSocketClient extends WebSocketClient {

    public XtWebSocketClient(String uri) throws URISyntaxException {
        super(new URI(uri));
    }

    //连接服务端时触发
    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("websocket客户端和服务器连接成功");
    }
    //收到服务端消息时触发
    @Override
    public void onMessage(String message) {
        System.out.println("websocket客户端收到消息="+ message);
    }
    //和服务端断开连接时触发
    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("websocket客户端退出连接");
    }
    //连接异常时触发
    @Override
    public void onError(Exception ex) {
        System.out.println("websocket客户端和服务器连接发生错误="+ex.getMessage());
    }
}
