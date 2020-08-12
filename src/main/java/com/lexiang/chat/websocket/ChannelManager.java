package com.lexiang.chat.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelManager {

    public static final String USER_TOKEN = "userId";

    public static final Integer THEAD_SIZE = 10;

    public static Map<String, WebSocketServerHandshaker> webSocketHandShakerMap =
            new ConcurrentHashMap<String, WebSocketServerHandshaker>();

    public static Map<String, ChannelHandlerContext> onlineUserMap =
            new ConcurrentHashMap<>();


}
