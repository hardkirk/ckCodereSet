package com.example.service.until.code3;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @Author chuke
 * @create 2020/8/5 14:46
 */
public class CodeCheck {
    public void codeCheck(String phone){
        final String regionId = "cn-hangzhou";
        final String accessKeyId = "LTAI4G4WG9nPHrwFHg2EBi6g";
        final String sectrt = "hH3PXj1h3JZb78TXCsVlksjcjFaDAI";
        final String domain = "dysmsapi.aliyuncs.com";
        final String sysVersion = "2017-05-25";

        //设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient需要的几个参数
        DefaultProfile profile = DefaultProfile.getProfile(regionId,accessKeyId,sectrt);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        //访问方式
        request.setSysMethod(MethodType.POST);
        //短信服务的服务接入地址
        request.setSysDomain(domain);
        //API 的版本号
        request.setSysVersion(sysVersion);
        //短信发送接口，支持在一次请求中向多个不同的手机号码发送同样内容的短信
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", phone);
        //签名
        request.putQueryParameter("SignName", "楚大人");
        //模板id
        request.putQueryParameter("TemplateCode", "SMS_198927216");
        //验证码
        request.putQueryParameter("TemplateParam", "{\"code\":\"2354\"}");
    }



}
