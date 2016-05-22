package com.my.test.exercise;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class ExerciseDemo {
	
	/**
	 *基于位移的int转成byte[]
	 * @param number
	 * @return
	 */
	private static byte[] intToByte(long number){
		byte[] arrayByte=new byte[4];
		arrayByte[0]=(byte)(number & 0xff);
	    // ">>"右移位，若为正数则高位补0，若为负数则高位补1  
		arrayByte[1]= (byte)((0xff00 & number) >> 8);  
		arrayByte[2]= (byte)((0xff0000 & number) >> 16);  
		arrayByte[3]= (byte)((0xff000000 & number) >> 24);  
		return arrayByte;
	}

	/**
	 * MD5 加密
	 * @param str
	 * @return
	 */
	private  static String getEncryptionStringByMD5(String str){
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!!!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for(int i = 0 ; i < byteArray.length; i++){
			if(Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
	
	public static String  generate_uri_token(String a1, String a2){
	//	long srand=new Date().getTime();
		long time=System.currentTimeMillis();
		Random random = new Random(time);
		int k=(int)random.nextLong();
		byte[] arrayByte=intToByte(Integer.toUnsignedLong(k));
	    final String str="93f518ea06c42b7d"; 
//	   System.out.println(new String(arrayByte));
	    StringBuilder  strBuild = new StringBuilder();
	    for(int i=0; i<arrayByte.length; i++){
	        int s=arrayByte[i];
	    //	System.out.println(Math.abs(s % 16));
            strBuild.append(str.charAt(Math.abs(s % 16)));
	    }
	    String r="4bb5";
	    // String r=strBuild.toString(); 
        strBuild=new StringBuilder("bdd3");
	    strBuild.append(a1);
	    String temp=getEncryptionStringByMD5(strBuild.toString());
	    strBuild= new StringBuilder(temp);
	    temp=getEncryptionStringByMD5(strBuild.reverse().toString());
	    
	    strBuild=new StringBuilder(temp);
	    strBuild.append(a2);
	    temp=getEncryptionStringByMD5(strBuild.toString());
	    System.out.println(temp);
	    strBuild=new StringBuilder();
	    strBuild=new StringBuilder(temp.substring(0, 12));
	    strBuild.insert(1, r.charAt(0));
	    strBuild.insert(5, r.charAt(1));
	    strBuild.insert(8, r.charAt(2));
	    strBuild.insert(11, r.charAt(3));
	    System.out.println(strBuild.toString());
		return strBuild.toString();
	}
	
	
	public static void main(String[] args) {
		String a1="00c422a8d19627e941b5fb43fd6b80c0a132a884faecc0f233b7aa5117bdf6b7";
		String a2="mgjandroid722MAM360866499020343445911322e3-5c96-4d87-9765-e960b8337efaMAM3607224.4.21b2628cb31a4a4e0fe1f19afdedc7b91d11972014430120237.2.2.1509150022014501";
		generate_uri_token(a1, a2);
	}

}
