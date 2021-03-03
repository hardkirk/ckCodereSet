package com.example.service.until.code2;

/**
 * @Author chuke
 * @create 2020/8/8 14:02
 */
public class Env {
    //1. 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    public static final String ACCESSKEY_ID = "LTAI4G4WG9nPHrwFHg2EBi6g";
    public static final String ACCESSKEY_SECRET = "hH3PXj1h3JZb78TXCsVlksjcjFaDAI";


    //2.产品名称:云通信短信API产品,开发者无需替换
    public static final String PRODUCT = "Dysmsapi";
    //产品域名,开发者无需替换
    public static final String DOMAIN = "dysmsapi.aliyuncs.com";


    //3.短信签名和模板,替换成自己的
    public static final String SIGN_NAME  = "楚大人";
    public static final String TEMPLATE_CODE  = "SMS_198927216";

}
