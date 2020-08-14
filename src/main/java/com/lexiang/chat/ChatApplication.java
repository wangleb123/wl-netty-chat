package com.lexiang.chat;

import com.lexiang.wlutils.netty.dilution.HandlerDo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lexiang.chat.*"})
public class ChatApplication {


    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }

}
