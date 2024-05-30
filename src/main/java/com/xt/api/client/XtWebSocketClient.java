package com.xt.api.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.extensions.permessage_deflate.PerMessageDeflateExtension;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

/**
 * @author zhouzhuang
 * @create 2023/12/12 17:06
 */
public class XtWebSocketClient extends WebSocketClient {

    public XtWebSocketClient(String uri) throws URISyntaxException {
        super(new URI(uri),new Draft_6455(Collections.singletonList(new PerMessageDeflateExtension())));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("websocket connect server success");
    }
    @Override
    public void onMessage(String message) {
        System.out.println("websocket recive msg ="+ message);
    }
    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("websocket client quit");
    }
    @Override
    public void onError(Exception ex) {
        System.out.println("websocket connect error ="+ex.getMessage());
    }
}
