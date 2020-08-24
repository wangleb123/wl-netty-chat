package com.lexiang.chat.websocket;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lexiang.chat.websocket.server.WebSocketServer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.*;

@Component
@Slf4j
public class ApplicationContext {


    @Autowired
    private WebSocketServer webSocketServer;

    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-netty_chat-runner-%d").build();
    ExecutorService executor = new ThreadPoolExecutor(Constant.THEAD_SIZE,Constant.THEAD_SIZE,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),namedThreadFactory);


    @PostConstruct
    public void init() {
        executor.submit(webSocketServer);
        log.info("netty线程已经开启");
    }


    /**
     * 描述：Tomcat服务器关闭前需要手动关闭Netty Websocket相关资源，否则会造成内存泄漏。
     *      1. 释放Netty Websocket相关连接；
     *      2. 关闭Netty Websocket服务器线程。（强行关闭，是否有必要？）
     */


    @PreDestroy
    public void close() {
        log.info("正在释放Netty Websocket相关连接...");
        executor.shutdown();
    }
}
