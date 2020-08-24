package com.lexiang.chat.websocket.initial;

import com.lexiang.chat.websocket.handler.HttpRequestHandler;
import com.lexiang.chat.websocket.handler.WebSocketRequestHandler;
import com.lexiang.wlutils.netty.dilution.HandlerDo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
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
                .webSocket()
                .business(httpRequestHandler,webSocketRequestHandler);

//        ChannelPipeline channelPipeline = socketChannel.pipeline();
//        // HttpServerCodec：将请求和应答消息解码为HTTP消息
//        channelPipeline.addLast(new HttpServerCodec());
//        // HttpObjectAggregator：将HTTP消息的多个部分合成一条完整的HTTP消息
//        channelPipeline.addLast(new HttpObjectAggregator(65536));
//        // ChunkedWriteHandler：向客户端发送HTML5文件
//        channelPipeline.addLast(new ChunkedWriteHandler());
//        //在管道中添加自己实现的Handler处理类
//        channelPipeline.addLast(new HttpRequestHandler());
//        channelPipeline.addLast(new WebSocketRequestHandler());
    }
}
