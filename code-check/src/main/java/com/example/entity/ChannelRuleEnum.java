package com.example.entity;

import com.example.SomeingNew.rule.GeneralChannelRule;
import com.example.SomeingNew.rule.TencentChannelRule;
import com.example.SomeingNew.rule.TouTiaoChannelRule;

/**
 * @Author chuke
 * @create 2020/8/20 17:23
 */

public enum ChannelRuleEnum {
    /**
     * 头条
     */
    TOUTIAO("TOUTIAO",new TouTiaoChannelRule()),
    /**
     * 腾讯
     */
    TENCENT("TENCENT",new TencentChannelRule()),
    ;

    public String name;

    public GeneralChannelRule channel;

    ChannelRuleEnum(String name, GeneralChannelRule channel) {
        this.name = name;
        this.channel = channel;
    }

    //匹配
    public static ChannelRuleEnum match(String name){
        ChannelRuleEnum[] values = ChannelRuleEnum.values();
        for (ChannelRuleEnum value : values) {
            if(value.name.equals(name)){
                return value;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public GeneralChannelRule getChannel() {
        return channel;
    }
}
