package com.example;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class CodeCheckApplicationTests {

        @Test
        void contextLoads() {
            DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "填写你的AccessKey ID", "填写你的AccessKey Secret");
            IAcsClient client = new DefaultAcsClient(profile);

            CommonRequest request = new CommonRequest();
            request.setSysMethod(MethodType.POST);
            request.setSysDomain("dysmsapi.aliyuncs.com");  //不要改
            request.setSysVersion("2017-05-25");    //不要改
            request.setSysAction("SendSms");    //我选择sendSms
            //自定义的参数(手机号,验证码,签名,模板)
            request.putQueryParameter("PhoneNumbers", "发送到的手机号码");
            request.putQueryParameter("SignName", "你的签名名称");
            request.putQueryParameter("TemplateCode", "你的模版CODE");
            //构建一个短信验证码(一般都是传进来的随机数,我这里测试直接写死)
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",5588);
            request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
            try {
                CommonResponse response = client.getCommonResponse(request);
                //输出响应是否成功
                System.out.println(response.getData());
            } catch (ServerException e) {
                e.printStackTrace();
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }


}
