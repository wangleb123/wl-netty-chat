package com.lexiang.chat.websocket;


import lombok.Data;

@Data
public class ChatRequestContent {

    private Integer type;

    private String token;

    private Object content;




}
