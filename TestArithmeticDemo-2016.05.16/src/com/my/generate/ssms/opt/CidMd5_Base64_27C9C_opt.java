package com.my.generate.ssms.opt;

import com.sun.org.apache.xml.internal.security.utils.Base64;


public class CidMd5_Base64_27C9C_opt {
	/**
	 * 作用传入一个cid的字符串，通过非标准的md5算法操作得到一个新字符串，
	 * 最后将新得到的字符串进行base64加密输出
	 * @param cid
	 * @return
	 */
	
	public static byte[]  cidMd5Transform(byte[] data, int len){
		int a=0x67452301;
		int b=0xEFCDAB89;
		int c=0x98BADCFE;
		int d=0x10325476;
		
		int result0=a;
		int result1=b;
		int result2=c;
		int result3=d;
		
		int[] x=new int[16];
		for(int i=0; i<len/4; i++){
			x[i]=StringUtil_update_0510.byteArrayChangeToInt(data, i*4);
		}
		x[len/4]=0x0000800A;
		x[14]=0x00000100;
		
		a=FF(a, b, c, d, x[0], 7, 0xd76aa478); 
		d=FF(d, a, b, c, x[1], 12, 0xe8c7b756); 
		c=FF(c, d, a, b, x[2], 17, 0x242070db); 
		b=FF(b, c, d, a, x[3], 22, 0xc1bdceee);

		a=FF(a, b, c, d, x[4], 7, 0xf57c0faf); 
		d=FF(d, a, b, c, x[5], 12, 0x4787c62a); 
		c=FF(c, d, a, b, x[6], 17, 0xa8304613); 
		b=FF(b, c, d, a, x[7], 22, 0xfd469501); 
	
		a=FF(a, b, c, d, x[8], 7, 0x698098d8); 
		d=FF(d, a, b, c, x[9], 12, 0x8b44f7af);
		c=FF(c, d, a, b, x[10], 17, 0xffff5bb1); 
		b=FF(b, c, d, a, x[11], 22, 0x895cd7be); 
		a=FF(a, b, c, d, x[12], 7, 0x6b901122); 
		d=FF(d, a, b, c, x[13], 12, 0xfd987193); 

		x[14]= 0x00000108;
		c=FF(c, d, a, b, x[14], 17, 0xa679438e); 
		b=FF(b, c, d, a, x[15], 22, 0x49b40821); 

		/* Round 2 */
		a=GG(a, b, c, d, x[1], 5, 0xf61e2562); 
		d=GG(d, a, b, c, x[6], 9, 0xc040b340); 
		c=GG(c, d, a, b, x[11], 14, 0x265e5a51); 

	    x[0] = 0x31303534;
		b=GG(b, c, d, a, x[0], 20, 0xe9b6c7aa); 
		a=GG(a, b, c, d, x[5], 5, 0xd62f105d); 
		d=GG(d, a, b, c, x[10], 9, 0x2441453); 
		c=GG(c, d, a, b, x[15], 14, 0xd8a1e681); 
		b=GG(b, c, d, a, x[4], 20, 0xe7d3fbc8); 
		
		a=GG(a, b, c, d, x[9], 5, 0x21e1cde6); 
		d=GG(d, a, b, c, x[14], 9, 0xc33707d6); 
		c=GG(c, d, a, b, x[3], 14, 0xf4d50d87); 
		b=GG(b, c, d, a, x[8], 20, 0x455a14ed); 
		
		a=GG(a, b, c, d, x[13], 5, 0xa9e3e905); 
		d=GG(d, a, b, c, x[2], 9, 0xfcefa3f8);
		c=GG(c, d, a, b, x[7], 14, 0x676f02d9);
		b=GG(b, c, d, a, x[12], 20, 0x8d2a4c8a); 

		/* Round 3 */
		a=HH(a, b, c, d, x[5], 4, 0xfffa3942);
		d=HH(d, a, b, c, x[8], 11, 0x8771f681);
		c=HH(c, d, a, b, x[11], 16, 0x6d9d6122); 
		b=HH(b, c, d, a, x[14], 23, 0xfde5380c); 
		
		a=HH(a, b, c, d, x[1], 4, 0xa4beea44); 
		d=HH(d, a, b, c, x[4], 11, 0x4bdecfa9); 
		c=HH(c, d, a, b, x[7], 16, 0xf6bb4b60); 
		b=HH(b, c, d, a, x[10], 23, 0xbebfbc70);
		
		a=HH(a, b, c, d, x[13], 4, 0x289b7ec6); 
		d=HH(d, a, b, c, x[0], 11, 0xeaa127fa); 
		c=HH(c, d, a, b, x[3], 16, 0xd4ef3085); 
		b=HH(b, c, d, a, x[6], 23, 0x4881d05); 
		
		a=HH(a, b, c, d, x[9], 4, 0xd9d4d039); 
		d=HH(d, a, b, c, x[12], 11, 0xe6db99e5); 
		c=HH(c, d, a, b, x[15], 16, 0x1fa27cf8); 
		b=HH(b, c, d, a, x[2], 23, 0xc4ac5665); 

		/* Round 4 */
		a=II(a, b, c, d, x[0], 6, 0xf4292244); 
		d=II(d, a, b, c, x[7], 10, 0x432aff97); 
		c=II(c, d, a, b, x[14], 15, 0xab9423a7); 
		b=II(b, c, d, a, x[5], 21, 0xfc93a039); 
		
		a=II(a, b, c, d, x[12], 6, 0x655b59c3);
		d=II(d, a, b, c, x[3], 10, 0x8f0ccc92); 
		c=II(c, d, a, b, x[10], 15, 0xffeff47d); 
		b=II(b, c, d, a, x[1], 21, 0x85845dd1); 
		
		a=II(a, b, c, d, x[8], 6, 0x6fa87e4f);
		d=II(d, a, b, c, x[15], 10, 0xfe2ce6e0); 
		c=II(c, d, a, b, x[6], 15, 0xa3014314); 
		b=II(b, c, d, a, x[13], 21, 0x4e0811a1);
	
		a=II(a, b, c, d, x[4], 6, 0xf7537e82);
		d=II(d, a, b, c, x[11], 10, 0xbd3af235); 
		c=II(c, d, a, b, x[2], 15, 0x2ad7d2bb); 
		b=II(b, c, d, a, x[9], 21, 0xeb86d391); 
		
		result0+=a;
		result1+=b;
		result2+=c;
		result3+=d;
		
		byte[] lastResult=new byte[16];
		StringUtil_update_0510.intChangeToByteArray(result0, lastResult, 0);
		StringUtil_update_0510.intChangeToByteArray(result1, lastResult, 4);
		StringUtil_update_0510.intChangeToByteArray(result2, lastResult, 8);
		StringUtil_update_0510.intChangeToByteArray(result3, lastResult, 12);
		
		return lastResult;
	}
	
	
	
	
	
	private static  int F(int x, int y, int z){
		long unsigned_x = Integer.toUnsignedLong(x);
		long unsigned_y = Integer.toUnsignedLong(y);
		long unsigned_z = Integer.toUnsignedLong(z);
		return (int)((unsigned_x & unsigned_y) | (~unsigned_x & unsigned_z));
	}
	
	private  static int G(int x, int y, int z){
		long unsigned_x = Integer.toUnsignedLong(x);
		long unsigned_y = Integer.toUnsignedLong(y);
		long unsigned_z = Integer.toUnsignedLong(z);
		return (int)((unsigned_x & unsigned_z) | (unsigned_y & ~unsigned_z));
	}
	
	private static int H(int x, int y, int z){
		long unsigned_x = Integer.toUnsignedLong(x);
		long unsigned_y = Integer.toUnsignedLong(y);
		long unsigned_z = Integer.toUnsignedLong(z);
		return (int)(unsigned_x^unsigned_y^unsigned_z);
	}
	
	
	private static int I(int x, int y, int z){
		long unsigned_x = Integer.toUnsignedLong(x);
		long unsigned_y = Integer.toUnsignedLong(y);
		long unsigned_z = Integer.toUnsignedLong(z);
		return (int)(unsigned_y ^ (unsigned_x | ~unsigned_z));
	}
	
	private  static int ROTATE_LEFT(int x, int n) {
		long unsigned_x = Integer.toUnsignedLong(x);
		return (int)((unsigned_x << n) | (unsigned_x >> (32-n)));  
	}
	
	
	private  static int FF(int a, int b, int c, int d, int x, int s, int ac) { 
		a += F(b, c, d) + x + ac; 
		a = ROTATE_LEFT(a, s); 
		a += b; 
		return a;
	}
	
	private static int GG(int a, int b, int c, int d, int x, int s, int ac) { 
		a += G(b, c, d) + x + ac; 
		a = ROTATE_LEFT(a, s); 
		a += b; 
		return a;
	}
	
	
	private static int HH(int a, int b, int c, int d, int x, int s, int ac) { 
		a += H(b, c, d) + x + ac; 
		a = ROTATE_LEFT(a, s); 
		a += b;  
		return a;
	}
	
	private  static int II(int a, int b, int c, int d, int x, int s, int ac) { 
		a += I(b, c, d) + x + ac; 
		a = ROTATE_LEFT(a, s); 
		a += b; 
		return a;
	}
	
	
	
	public static String getMd5ToBase64String(String cid) {
		byte[]  result=cidMd5Transform(cid.getBytes(), cid.length());
		return Base64.encode(result);
	}

	

	public static void main(String[] args) {
		String cid = "110100303136473932008c52e5492158"; //1c e2 56 3d 6e 80 ce 73 7f 94 bb c4 23 d7 b7 c4
		System.out.println(getMd5ToBase64String(cid));
	}

}
