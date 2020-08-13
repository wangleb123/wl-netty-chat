package com.lexiang.chat.websocket.server;

import com.lexiang.chat.websocket.initial.NettyWebSocketHandlerInitializer;
import com.lexiang.wlutils.netty.dilution.BootstrapDo;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;


@Component
public class WebSocketServer implements Runnable {


    private final ServerBootstrap serverBootstrap = new ServerBootstrap();
    private final EventLoopGroup bossGroup = BootstrapDo.getBossGroup();
    private final EventLoopGroup workerGroup = BootstrapDo.getWorkerGroup();
    private static final Integer port = 1235;
    private static final int RECVBYTE_ALLOCATOR_SIZE = 592048;


    @Autowired
    private NettyWebSocketHandlerInitializer initializer;





    private void startChat(){
        serverBootstrap
                .group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .option(ChannelOption.TCP_NODELAY,true)
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                .childOption(ChannelOption.RCVBUF_ALLOCATOR,new FixedRecvByteBufAllocator(RECVBYTE_ALLOCATOR_SIZE))
                .childHandler(initializer);

        BootstrapDo.catchDeal(BootstrapDo.SERVER,serverBootstrap,new InetSocketAddress(port),bossGroup,workerGroup);
    }


    @Override
    public void run() {
        startChat();
    }
}
