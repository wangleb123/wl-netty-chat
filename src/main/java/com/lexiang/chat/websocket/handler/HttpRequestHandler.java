package com.lexiang.chat.websocket.handler;

import com.lexiang.wlutils.netty.websocket.WebSocket;
import com.lexiang.wlutils.netty.websocket.tranfer.AbstractNettyWebSocket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * 处理http升级为websocket协议
 * @author wangle
 * date : 2020-8-15
 */

@Component
@ChannelHandler.Sharable
public class HttpRequestHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext context, Object o) throws Exception {
        //首次请求如果是http请求，就进行协议升级
        WebSocket.argumentSub(context,o,new AbstractNettyWebSocket());
    }

    /**
     * 异常处理
     * @param ctx 处理上下文
     * @param cause 抛出异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
