package com.learn.websocket.Config;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class WebSocketController {

    @GetMapping("/api/start-websocket")
    public String startWebSocket() {
        try {
            URI uri = new URI("ws://localhost:8080/ws");
            CustomWebSocketClient client = new CustomWebSocketClient(uri);
            client.connectBlocking(); // Wait for the connection to be established
            return "WebSocket connection initiated.";
        } catch (URISyntaxException | InterruptedException e) {
            e.printStackTrace();
            return "Failed to initiate WebSocket connection.";
        }
    }
}

