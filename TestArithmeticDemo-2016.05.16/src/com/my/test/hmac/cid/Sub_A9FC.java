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
     * ������ܷ�ʽ 
     * MAC�㷨��ѡ���¶����㷨 
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
     * ȫ������ 
     */  
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",  
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };  
  
  
    /** 
     * BASE64 ���� 
     * @param key ��Ҫ���ܵ��ֽ����� 
     * @return �ַ��� 
     * @throws Exception 
     */  
    public static String encryptBase64(byte[] key) throws Exception {  
        return (new BASE64Encoder()).encodeBuffer(key);  
    }  
  
    /** 
     * BASE64 ���� 
     * @param key ��Ҫ���ܵ��ַ��� 
     * @return �ֽ����� 
     * @throws Exception 
     */  
    public static byte[] decryptBase64(String key) throws Exception {  
        return (new BASE64Decoder()).decodeBuffer(key);  
    }  
  
    /** 
     * ��ʼ��HMAC��Կ 
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
     * HMAC���� 
     * @param data ��Ҫ���ܵ��ֽ����� 
     * @param key ��Կ 
     * @return �ֽ����� 
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
     * HMAC���� 
     * @param data ��Ҫ���ܵ��ַ��� 
     * @param key ��Կ 
     * @return �ַ��� 
     */  
    public static String encryptHMAC(String data, String key) {  
     //   if (Strings.isNullOrEmpty(data)) {  
     //       return null;  
     //   }  
        byte[] bytes = encryptHMAC(data.getBytes(), key);  
        return byteArrayToHexString(bytes);  
    }  
  
  
    /** 
     * ��һ���ֽ�ת����ʮ��������ʽ���ַ��� 
     * @param b �ֽ����� 
     * @return �ַ��� 
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
     * ת���ֽ�����Ϊʮ�������ַ��� 
     * @param bytes �ֽ����� 
     * @return ʮ�������ַ��� 
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
     * ���Է��� 
     * @param args 
     */  
    public static void main(String[] args) throws Exception {  
        String key = Sub_A9FC.init();  
        System.out.println("Mac��Կ:\n" + key);  
        String word = "110100303136473932001697ee135000";  
      //  System.out.println(encryptHMAC(word, "MOENRAKQTY"));  
        System.out.println(encryptHMAC(word, "MOENRAKQTY"));
        System.out.println("\n��Ҫ�����ݽ����");
        String testData="B3ECA27AE17B245A4ED260137899D9FF4A350F86";
        System.out.println(Base64.encode(StringUtil_update_0510.hexStringtoByteArray1(testData)));
        // StringUtil.printByteArray(StringUtil.hexStringtoByteArray1(testData), StringUtil.hexStringtoByteArray1(testData).length);
        
    }  

}
