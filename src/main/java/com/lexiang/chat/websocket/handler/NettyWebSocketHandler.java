package com.lexiang.chat.websocket.handler;

import com.lexiang.wlutils.netty.websocket.tranfer.NettyWebSocket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;

public class NettyWebSocketHandler implements NettyWebSocket {
    @Override
    public void handsShaker(ChannelHandlerContext ctx, FullHttpRequest request) {
        //构造握手响应返回
        WebSocketServerHandshakerFactory webSocketServerHandshakerFactory=new WebSocketServerHandshakerFactory("ws://localhost:1235/web",null,false);
        WebSocketServerHandshaker handshaker = webSocketServerHandshakerFactory.newHandshaker(request);
        handshaker.handshake(ctx.channel(),request);
    }
}
