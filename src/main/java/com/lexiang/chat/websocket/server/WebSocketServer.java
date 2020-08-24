package com.lexiang.chat.websocket.server;

import com.lexiang.chat.websocket.handler.HttpRequestHandler;
import com.lexiang.chat.websocket.handler.WebSocketRequestHandler;
import com.lexiang.chat.websocket.initial.NettyWebSocketHandlerInitializer;
import com.lexiang.wlutils.netty.dilution.BootstrapDo;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;


@Component
public class WebSocketServer implements Runnable {

    @Autowired
    private NettyWebSocketHandlerInitializer nettyWebSocketHandlerInitializer;

    public void starts(int port) throws Exception {
        //用于监听连接的线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //用于发送接收消息的线程组
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            //启动类引导程序
            ServerBootstrap b = new ServerBootstrap();
            //绑定两个线程组
            b.group(bossGroup, workGroup);
            //设置非阻塞,用它来建立新accept的连接,用于构造serverSocketChannel的工厂类
            b.channel(NioServerSocketChannel.class).childHandler(nettyWebSocketHandlerInitializer);
            Channel channel = b.bind(port).sync().channel();
            System.out.println("服务器启动端口:" + port);
            channel.closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }


    @SneakyThrows
    @Override
    public void run() {
        starts(1235);
    }
}
