/*
package com.example.service.until;

import javax.xml.ws.Holder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

*/
/**
 * @Author chuke
 * @create 2020/8/5 20:36
 *//*

public class UUID {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    public static void main(String[] args) {
        // 利用伪随机数生成版本为4,变体为9的UUID
        System.out.println(UUID.randomUUID());

        // 对于相同的命名空间总是生成相同的UUID,版本为3,变体为9
        // 命名空间为"mwq"时生成的UUID总是为06523e4a-9a66-3687-9334-e41dab27cef4
        System.out.println(UUID.nameUUIDFromBytes("mwq".getBytes()));
    }

    public static UUID randomUUID() {
        // 与Random(弱伪随机数生成器)不一样，SecureRandom是强伪随机数生成器，结果不可预测
        // 使用SecureRandom生成随机数，替换version和variant就是 UUID
        SecureRandom ng = Holder.numberGenerator;

        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6]  &= 0x0f;  */
/* clear version        *//*

        randomBytes[6]  |= 0x40;  */
/* set to version 4     *//*

        randomBytes[8]  &= 0x3f;  */
/* clear variant        *//*

        randomBytes[8]  |= 0x80;  */
/* set to IETF variant  *//*

        return new UUID(randomBytes);
    }
    public static UUID nameUUIDFromBytes(byte[] name) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsae) {
            throw new InternalError("MD5 not supported", nsae);
        }
        byte[] md5Bytes = md.digest(name);
        md5Bytes[6]  &= 0x0f;  */
/* clear version        *//*

        md5Bytes[6]  |= 0x30;  */
/* set to version 3     *//*

        md5Bytes[8]  &= 0x3f;  */
/* clear variant        *//*

        md5Bytes[8]  |= 0x80;  */
/* set to IETF variant  *//*

        return new UUID(md5Bytes);
    }

}
*/
