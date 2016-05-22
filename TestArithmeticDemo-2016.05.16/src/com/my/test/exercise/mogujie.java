package com.my.test.exercise;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class mogujie {
	public static void main(String[] args) {
		//97f9
		System.out.println(getrawrand("a68a")); // at中的key生成原始的随机数
		System.out.println(getrandomStr("0f2c"));//随机数生成at中的key
		
		String data = "mgjandroid722MAM360864572010196213531f2078-e288-4df5-a8a5-dbfa8850c209MAM3607224.2.22678e747307ff5c855d6814eeae344b7201772014430238887.2.2.15091500251270HUAWEI+HN3-U01012.5.201短靴";
		
		String a = generate_url_token("00c422a8d19627e941b5fb43fd6b80c0",data);//加密data成at
		System.out.println(a);
	}
	public static String generate_url_token(String secret,String data)
	{
		String key = secret + "a132a884faecc0f233b7aa5117bdf6b7";
		String result = "";		
		
		String rawrand = "7957";//随机数4个0-f的随机数
		String randomStr = "a68a";//通过rawrand计算得到  函数为getrandomStr
		
		Random random = new Random(System.currentTimeMillis());
		byte[] a = new byte[2];
		random.nextBytes(a);
//		rawrand = byte2hex(a);
//		randomStr = getrandomStr(rawrand);
		System.out.println(rawrand);
		System.out.println(randomStr);
		
		String md1 = md52String32((rawrand+key).getBytes());
		String md2 = md52String32(new StringBuilder(md1).reverse().toString().getBytes());
		String md3 = "";
//		try {
//			md3 = md52String32((md2+data).getBytes("utf-8"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		md3 = md52String32((md2+data).getBytes());
		
		System.out.println(md2);
		System.out.println(md3);
	
		
		result =
				md3.substring(0,1) +
				randomStr.substring(0, 1)+
				md3.substring(1,4) +
				randomStr.substring(1, 2)+
				md3.substring(4,6)+
				randomStr.substring(2, 3)+
				md3.substring(6,8)+
				randomStr.substring(3, 4)+
				md3.substring(8,12);
		
		return result;
	}
	
	public static String md52String32(byte[] bytes) {
		StringBuffer localStringBuffer;
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(bytes);
			byte[] arrayOfByte = localMessageDigest.digest();
			localStringBuffer = new StringBuffer("");
			for (int i2 = 0; i2 < arrayOfByte.length; i2++) {
				int i1 = arrayOfByte[i2];
				if (i1 < 0)
					i1 += 256;
				if (i1 < 16)
					localStringBuffer.append("0");
				localStringBuffer.append(Integer.toHexString(i1));
			}
			return localStringBuffer.toString();
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
			localNoSuchAlgorithmException.printStackTrace();
		}
		return "";
	}
	
	
	public static String getrawrand(String hex)
	{
        String digital = "93f518ea06c42b7d";
        char[] hex2char = hex.toCharArray();
        byte[] bytes = new byte[hex.length() / 2];
        int temp;
        for (int i = 0; i < bytes.length; i++) {
            temp = digital.indexOf(hex2char[2 * i]) * 16;
            temp += digital.indexOf(hex2char[2 * i + 1]);
            bytes[i] = (byte) (temp & 0xff);
        }
        return byte2hex(bytes);
	}
	
    public static String getrandomStr(String hex) {
        String digital = "0123456789abcdef";
        char[] hex2char = hex.toCharArray();
        String table = "93f518ea06c42b7d";
        String result  = "";
        int temp;
        for (int i = 0; i < hex.length(); i++) {
            temp = digital.indexOf(hex2char[i]);
            result += table.charAt(temp);
        }
        return result;
    }
	
	
	public static String byte2hex(byte[] b) {
        String hs = "";
        String tmp = "";
        for (int n = 0; n < b.length; n++) {
            tmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (tmp.length() == 1) {
                hs = hs + "0" + tmp;
            } else {
                hs = hs + tmp;
            }
        }
        tmp = null;
        return hs; 
    }
}
