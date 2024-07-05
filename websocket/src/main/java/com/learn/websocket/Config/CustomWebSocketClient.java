package com.learn.websocket.Config;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;

public class CustomWebSocketClient extends WebSocketClient {

    public CustomWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connected to server");
        send("Hello, it's the client.");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}