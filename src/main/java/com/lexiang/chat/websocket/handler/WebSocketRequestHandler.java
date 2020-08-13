package com.lexiang.chat.websocket.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lexiang.chat.websocket.ChannelManager;
import com.lexiang.chat.websocket.ChatRequestContent;
import com.lexiang.chat.websocket.ChatType;
import com.lexiang.wlutils.netty.websocket.tranfer.AbstractNettyWebSocket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import org.springframework.stereotype.Component;

@Component
@ChannelHandler.Sharable
public class WebSocketRequestHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame webSocketFrame) throws Exception {
        socketDo(ctx,webSocketFrame);
    }

    private void socketDo(ChannelHandlerContext ctx, WebSocketFrame frame){

        AbstractNettyWebSocket nettyWebSocket = new AbstractNettyWebSocket();

        nettyWebSocket.handsShakerCloseFuture(ChannelManager.webSocketHandShakerMap.get(ctx.channel().id().asLongText()),ctx.channel(),frame);
        //文本协议
        if(frame instanceof TextWebSocketFrame){
            ChatRequestContent requestContent = JSON.parseObject(((TextWebSocketFrame) frame).text(), ChatRequestContent.class);
            if( null == requestContent){
                nettyWebSocket.sendMessage(ctx.channel(),"参数为null");
                return;
            }
            ChatType chatType = ChatType.getByType(requestContent.getType());
            if(null == chatType){
                nettyWebSocket.sendMessage(ctx.channel(),"非法的socket类型");
                return;
            }
            switch (chatType){
                case REGISTER:
                    int a = 1;
                    break;
                case SINGLE_SENDING:
                    int b = 2;
                    break;
            }

        }
        //二进制文件协议
        if(frame instanceof BinaryWebSocketFrame){
            nettyWebSocket.sendMessage(ctx.channel(),"暂时不支持二进制数据传输");
        }
    }

    public static void main(String[] args) {
        ChatRequestContent requestContent = JSON.parseObject(null, ChatRequestContent.class);
        System.out.println(requestContent);

    }
}
