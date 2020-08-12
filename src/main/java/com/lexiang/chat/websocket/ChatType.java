package com.lexiang.chat.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  ChatType {

    REGISTER(1,"注册"),
    SINGLE_SENDING(2,"给单个人发送消息"),
    GROUP_SENDING(3,"群发"),
    FILE_MSG_SINGLE_SENDING(4,"给单个人发送文件"),
    FILE_MSG_GROUP_SENDING(5,"群发文件");

    private Integer type;

    private String des;



    public static ChatType getByType(Integer code) {
        ChatType[] fundTypes = ChatType.values();
        for (int i = 0; i < fundTypes.length; i++) {
            if (fundTypes[i].getType().intValue() == (code).intValue()) {
                return fundTypes[i];
            }
        }
        return null;
    }

}
