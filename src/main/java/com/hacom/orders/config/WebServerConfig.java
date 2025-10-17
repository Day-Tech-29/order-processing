
package com.hacom.orders.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServerConfig implements WebServerFactoryCustomizer<ReactiveWebServerFactory> {

    @Value("${apiPort}")
    private int port;

    @Override
    public void customize(ReactiveWebServerFactory factory) {
        if (factory instanceof NettyReactiveWebServerFactory nettyFactory) {
            nettyFactory.setPort(port);
        }
    }
}
