package com.example.entity;

/**
 * @Author chuke
 * @create 2020/8/21 16:26
 */
public enum BankTemplateIdEnum {
    ICBCDel("ICBCDel","4596762312770879502"),
    OVERSIZE("oversize","文件过大"),
    UPLOADING("0","上传中"),
    MERGE("1","分片上传结束"),
    COMPRESS("2","服务器处理中"),
    FINISH("3","处理结束"),
            ;
    BankTemplateIdEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }

}
