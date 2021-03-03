package com.example.service.until.code3;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
/**
 * @Author chuke
 * @create 2020/8/5 19:33
 */
public class shortCode {
    /**
     * Signature							请求签名，即最终生成的签名结果值。
     AccessKeyId							访问密钥 ID。AccessKey 用于调用 API。
     Action								API 的名称。
     Format								返回参数的语言类型。取值范围：json | xml。默认值：json。
     RegionId							API支持的RegionID，如短信API的值为：cn-hangzhou。
     SignatureMethod						签名方式。取值范围：HMAC-SHA1。
     SignatureNonce						签名唯一随机数。用于防止网络重放攻击，建议您每一次请求都使用不同的随机数。
                                        JAVA语言建议用：java.util.UUID.randomUUID()生成。

     SignatureVersion					签名算法版本。取值范围：1.0。
     Timestamp							请求的时间戳。按照ISO8601 标准表示，并需要使用UTC时间，格式为yyyy-MM-ddTHH:mm:ssZ。
     Version								API 的版本号，格式为 YYYY-MM-DD。取值范围：2017-05-25。
     */
    public static void main(String[] args) {
        //API支持的RegionID ,accessKeyId,secret
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //访问方式
        request.setSysMethod(MethodType.POST);
        //短信服务的服务接入地址
        request.setSysDomain("dysmsapi.aliyuncs.com");
        //API 的版本号
        request.setSysVersion("2017-05-25");
        //短信发送接口，支持在一次请求中向多个不同的手机号码发送同样内容的短信
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "18906901092");
        //签名
        request.putQueryParameter("SignName", "楚大人");
        //模板id
        request.putQueryParameter("TemplateCode", "SMS_198927216");
        request.putQueryParameter("TemplateParam", "{\"code\":\"2354\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
