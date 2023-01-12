package com.revature.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
/*
EnableWebSocketMessageBroker used to enable the websocket server
WebSocketMessageBrokerConfigurer used to configure the websocket connection
SockJS is used to enable fallback options for browsers that don’t support websocket.
STOMP stands for Simple Text Oriented Messaging Protocol.
 */

@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chatroom").withSockJS();
    }

}