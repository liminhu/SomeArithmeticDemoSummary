package com.my.test.hmac.cid;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.my.test.useless.StringUtil_update_0510;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Sub_A9FC {
	 /** 
     * 定义加密方式 
     * MAC算法可选以下多种算法 
     * <pre> 
     * HmacMD5 
     * HmacSHA1 
     * HmacSHA256 
     * HmacSHA384 
     * HmacSHA512 
     * </pre> 
     */  
    private final static String KEY_MAC = "HmacSHA256"; //"HmacMD5";  
  
    /** 
     * 全局数组 
     */  
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",  
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };  
  
  
    /** 
     * BASE64 加密 
     * @param key 需要加密的字节数组 
     * @return 字符串 
     * @throws Exception 
     */  
    public static String encryptBase64(byte[] key) throws Exception {  
        return (new BASE64Encoder()).encodeBuffer(key);  
    }  
  
    /** 
     * BASE64 解密 
     * @param key 需要解密的字符串 
     * @return 字节数组 
     * @throws Exception 
     */  
    public static byte[] decryptBase64(String key) throws Exception {  
        return (new BASE64Decoder()).decodeBuffer(key);  
    }  
  
    /** 
     * 初始化HMAC密钥 
     * @return 
     */  
    public static String init() {  
        SecretKey key;  
        String str = "";  
        try {  
            KeyGenerator generator = KeyGenerator.getInstance(KEY_MAC);  
            key = generator.generateKey();  
            str = encryptBase64(key.getEncoded());  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return str;  
    }  
  
    /** 
     * HMAC加密 
     * @param data 需要加密的字节数组 
     * @param key 密钥 
     * @return 字节数组 
     */  
    public static byte[] encryptHMAC(byte[] data, String key) {  
        SecretKey secretKey;  
        byte[] bytes = null;  
        try {  
            secretKey = new SecretKeySpec(decryptBase64(key), KEY_MAC);  
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());  
            mac.init(secretKey);  
            bytes = mac.doFinal(data);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return bytes;  
    }  
  
    /** 
     * HMAC加密 
     * @param data 需要加密的字符串 
     * @param key 密钥 
     * @return 字符串 
     */  
    public static String encryptHMAC(String data, String key) {  
     //   if (Strings.isNullOrEmpty(data)) {  
     //       return null;  
     //   }  
        byte[] bytes = encryptHMAC(data.getBytes(), key);  
        return byteArrayToHexString(bytes);  
    }  
  
  
    /** 
     * 将一个字节转化成十六进制形式的字符串 
     * @param b 字节数组 
     * @return 字符串 
     */  
    private static String byteToHexString(byte b) {  
        int ret = b;  
        //System.out.println("ret = " + ret);  
        if (ret < 0) {  
            ret += 256;  
        }  
        int m = ret / 16;  
        int n = ret % 16;  
        return hexDigits[m] + hexDigits[n];  
    }  
  
    /** 
     * 转换字节数组为十六进制字符串 
     * @param bytes 字节数组 
     * @return 十六进制字符串 
     */  
    private static String byteArrayToHexString(byte[] bytes) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < bytes.length; i++) {  
            sb.append(byteToHexString(bytes[i]));  
        }  
        return sb.toString();  
    }  
    
    //"E8B5756084AC08406E616C446174612E49"
  
    /** 
     * 测试方法 
     * @param args 
     */  
    public static void main(String[] args) throws Exception {  
        String key = Sub_A9FC.init();  
        System.out.println("Mac密钥:\n" + key);  
        String word = "110100303136473932001697ee135000";  
      //  System.out.println(encryptHMAC(word, "MOENRAKQTY"));  
        System.out.println(encryptHMAC(word, "MOENRAKQTY"));
        System.out.println("\n需要的数据结果：");
        String testData="B3ECA27AE17B245A4ED260137899D9FF4A350F86";
        System.out.println(Base64.encode(StringUtil_update_0510.hexStringtoByteArray1(testData)));
        // StringUtil.printByteArray(StringUtil.hexStringtoByteArray1(testData), StringUtil.hexStringtoByteArray1(testData).length);
        
    }  

}
