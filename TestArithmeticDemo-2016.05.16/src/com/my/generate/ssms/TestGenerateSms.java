package com.my.generate.ssms;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import com.my.test.key.KeyToNewString_update0506;
import com.my.test.sub_5085C.Sub_50764;
import com.my.test.sub_5085C.Sub_5085C;
import com.my.test.useless.CidBase64;
import com.my.test.useless.StringUtil_update_0510;



public class TestGenerateSms {
	   private static String imsi = "460003853337451";
	    private static String imei = "A100005634AEEF";
	    private static String irid = "00008870";
		private static String staus = "a";
		private static String sdcid = "110100303136473932008c52e5492158";	
		private static String random16 = "7161678395144711";	
		
		private static String verifyKey1 =
				  "I6O8zjwQoQBP4fEVXdnuVdtAbZ0AAgAAAAAAAE4CdHRjAwAGdQcEZgMFAX8DZgZmNjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY=";
				//"WvpLOhC0bBGpDdYFi18ZI7KERVAAAgAAAAAAAAIPAAUDDgZ4RFUEZAZ+bwFXAngHNjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY=";	
		private static String verifyKey2 = 
				"OqWTqbQrAz/Pc2xwMXFqmz9aEGwAAgAAAAAAACRoHh4JaWpsH21uDGlvaxVpDGwMXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFw=";
				//"XVgVa0Gevuc1sv4Ml3jGoIqeIpAAAgAAAAAAAGhlam9pZGwSLj9uDmwUBWs9aBJtXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFxcXFw=";
	    
		
		public static void main(String[] args) {
			generate_sms(imei,imsi,sdcid,random16,getTimeStamp());
		}
		
	    public static String generate_sms(String imei, String imsi,String sdcid,String random16,String time) {
			StringBuffer sb = new StringBuffer();
			sb.append(irid);
			StringBuffer sb2 = new StringBuffer();
			sb2.append(imei);
			sb2.append(imsi);
			sb2.append(CidBase64.getBase64String(sdcid));
			sb2.append(random16);
			sb2.append(time);
			sb2.append(staus);
			sb2.append("000000000000");
			sb2.append(getRawString(imei,imsi,sdcid,random16,time));
		
			
			System.out.println(getRawString(imei,imsi,sdcid,random16,time));
			System.out.println("\n*****************\ngenerateVerifyString: getRawString\n");
			System.err.println("\n\nresult:"+generateVerifyString(getRawString(imei,imsi,sdcid,random16,time)));
		
		    //aZ8RyZRWxcJno2cBcwQDAHYjmZoOC5Gi
		    //86T077/%85363514f00a1014ME3u73AB3VfgR2w8fiiH6ZL5VjI8==8j:[26z}6O0936o220)Qm=31d95628wM000|0H00000M!~QCe jkME!iB3Sm49jMCd07Ta>
		    //System.out.println(sb2.toString());
			String inputString = new String(sb2.toString());
		    sb.append(KeyToNewString_update0506.getNewStringByKey(inputString));
		    
		    System.out.println(sb.toString());
			
//			System.out.println("sms addresss: 1065842230\n sms content:\n" + sb.toString());
			
			System.out.println("am start -a android.intent.action.SENDTO -d sms:1065842230 --es sms_body " + "\""+sb.toString()+"\"");
			return sb.toString();
		}
	   
	    
	    public static String getRawString(String imei, String imsi,String sdcid,String random,String time){
			StringBuffer sb = new StringBuffer();
			sb.append(irid);
			sb.append(imei);
			sb.append(imsi);
			sb.append(CidBase64.getBase64String(sdcid));
			sb.append(random);
			sb.append(time);
			sb.append(staus);
			sb.append("000000000000");
			return sb.toString();
		}
	    
		public static char[] getCharsFromByteArray(byte[] bytes) {
			Charset cs = Charset.forName("UTF-8");
			ByteBuffer bb = ByteBuffer.allocate(bytes.length);
			bb.put(bytes);
			bb.flip();
			CharBuffer cb = cs.decode(bb);
			return cb.array();
		}
	    
		public static byte[] getBytesFromCharArray(char[] chars) {
			Charset cs = Charset.forName("UTF-8");
			CharBuffer cb = CharBuffer.allocate(chars.length);
			cb.put(chars);
			cb.flip();
			ByteBuffer bb = cs.encode(cb);
			return bb.array();
		}
		
		
		public static int printByteArray(byte[] needOutputData, int length) {
			for (int i = 0; i < length; i++) {
				if (i % 16 == 0 && i != 0)
					System.out.println("");
				System.err.format("%02x ",new Object[] { new Integer(needOutputData[i] & 0xFF)});
			}
			return 1;
		}
		
	    public static String generateVerifyString(String raw){
//			byte k1[] = { (byte)0x8C, (byte)0xC, (byte)0xC8, (byte)0xCB, (byte)0xAC, (byte)0xE2, (byte)0x99, (byte)0xF5, (byte)0x32, (byte)0xC8, (byte)0xB8, (byte)0xBD, (byte)0xC3, (byte)0xC1, (byte)0x95, (byte)0xDA, (byte)0x25, (byte)0x30, (byte)0x68, (byte)0xF8, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, 7, 4, 5, 2, 3, 0, 1, (byte)0xE, (byte)0xF, 6, 7, 4, 5, 2, 3, 0, 1, (byte)0xE, (byte)0xF, 6, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36, (byte)0x36 };
//			byte k2[] = { (byte)0xCD, (byte)0xBD, (byte)0xBD, (byte)0x98, (byte)0xFE, (byte)0x7B, (byte)0xE0, (byte)0x58, (byte)0xEA, (byte)0xDD, (byte)0x5C, (byte)0xAD, (byte)0x0B, (byte)0x43, (byte)0xC0, (byte)0x3A, (byte)0x25, (byte)0x68, (byte)0x10, (byte)0xFE, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x6D, (byte)0x6E, (byte)0x6F, (byte)0x68, (byte)0x69, (byte)0x6A, (byte)0x6B, (byte)0x64, (byte)0x65, (byte)0x6C, (byte)0x6D, (byte)0x6E, (byte)0x6F, (byte)0x68, (byte)0x69, (byte)0x6A, (byte)0x6B, (byte)0x64, (byte)0x65, (byte)0x6C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C, (byte)0x5C };
//			System.out.println(new String(Base64.encode(k1, Base64.DEFAULT | Base64.NO_WRAP)));
//			System.out.println(new String(Base64.encode(k2, Base64.DEFAULT | Base64.NO_WRAP)));
			byte k1 [] = Base64.decode(verifyKey1, Base64.DEFAULT | Base64.NO_WRAP);
			byte k2 [] = Base64.decode(verifyKey2, Base64.DEFAULT | Base64.NO_WRAP);
			byte[] r1 = new byte[20];
			byte[] r2 = new byte[20];
			System.out.print("\nkey1:");
			StringUtil_update_0510.printByteArray(k1,92);
			StringUtil_update_0510.printByteArray(raw.getBytes(),raw.length());
			System.out.println("\n\n");
			String str = HexStringUtil.toHexString(raw.getBytes()).toLowerCase();
	        System.out.println("raw.getBytes:\t"+str.length()+"\t"+str);
	        System.out.println(raw+"\n");
	        
	        char[] array_str=getCharsFromByteArray(str.getBytes());
	        char[] array_k1=getCharsFromByteArray(k1);
	        char[] array_k2=getCharsFromByteArray(k2);
	        
			Sub_50764.sub_50764(array_str, str.length(), array_k1);
			
			StringUtil_update_0510.printByteArray(getBytesFromCharArray(array_k1), array_k1.length);
			System.out.println("\n\nk1:\n");
			char[] array_r1 = Sub_5085C.sub_5085C(array_k1);
			
		    StringUtil_update_0510.printByteArray(getBytesFromCharArray(array_r1), 20);
		    
			Sub_50764.sub_50764(array_r1, 20, array_k2);
			char[] array_r2 = Sub_5085C.sub_5085C(array_k2);
			System.out.println("\n\nk2:\n");
		    StringUtil_update_0510.printByteArray(getBytesFromCharArray(array_r2), 20);
			//System.out.println(new String(Base64.encode(getBytesFromCharArray(array_r2), Base64.DEFAULT
					//| Base64.NO_WRAP)));
			return new String(Base64.encode(getBytesFromCharArray(array_r2), Base64.DEFAULT | Base64.NO_WRAP));
		}

	    
	    public static String getTimeStamp(){
	    	return "20160509133558";
			//return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		}
}
