package com.lexiang.chat.websocket.initial;

import com.lexiang.chat.websocket.handler.HttpRequestHandler;
import com.lexiang.chat.websocket.handler.WebSocketRequestHandler;
import com.lexiang.wlutils.netty.dilution.HandlerDo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

@Component
public class NettyWebSocketHandlerInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private HttpRequestHandler httpRequestHandler;

    @Autowired
    private WebSocketRequestHandler webSocketRequestHandler;

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        HandlerDo
                .init(socketChannel)
                .HttpCodec()
                .httpAggregator()
                .webSocket()
                .business(httpRequestHandler,webSocketRequestHandler);
    }
}
