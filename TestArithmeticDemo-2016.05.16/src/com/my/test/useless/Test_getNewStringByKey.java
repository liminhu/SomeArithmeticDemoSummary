package com.my.test.useless;

import com.my.test.key.KeyToNewString_update0506;

public class Test_getNewStringByKey {

	public static String encodeSMS(String sms) {
		//System.out.println(sms);
		String key = "xcJno2cBcwQDoOC5GiAHYjmZaZ8RyZRW"; // ﬂ‰πæ”Œœ∑
		StringBuilder stringBuilderKey = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			stringBuilderKey.append(key);
		}
		String tempKeyStr = stringBuilderKey.toString();
		byte[] keyTable = new byte[1024];
		for (int i = 0; i < 1024; i = i + 4) {
			keyTable[i] = (byte) (i / 4);
		}
		int byte_1, byte_2, result, keep = 0, temp;
		for (int i = 0; i < 255; i++) {
			byte_1 = tempKeyStr.charAt(i);
			byte_2 = keyTable[i * 4];
			result = (byte_1 + keep + byte_2) & 0xff;
			keep = result;
			keyTable[4 * i] = keyTable[4 * result];
			keyTable[4 * result] = (byte) byte_2;
		}
		//StringUtil_update_0505.printByteArray(keyTable, 1024);
		
		int m = 0;
		byte[] output = new byte[sms.length()];
		for (int i = 0; i < sms.length(); i++) {
			int n = ((i + 1) & 0xFF) * 4;
			byte_1 = keyTable[n];
			m = (m + byte_1) & 0xff;
			keyTable[n] = keyTable[m * 4];
			keyTable[m * 4] = (byte) byte_1;
			temp = (((byte_1 & 0xff) + keyTable[n]) & 0xff) * 4;

			int byteN = (sms.charAt(i) ^ keyTable[temp]) & 0xff;
			if (((byteN - 32) & 0xFF) > 0x5E || ((byteN - 96) & 0xFF) <= 0) {
				output[i] = (byte) (sms.charAt(i));
			} else {
				output[i] = (byte) (byteN);
			}
		}
		String r = new String(output);
		System.out.println("*******************\n\n");
		System.out.println(r);
		return r;
	}
	
	public static void main(String[] args) {
		String inputString="urot7colN(m=s2&^eek*pe=28{9hkr4%py>xcy=5xS&DVer&iow=2<1N0&cJidBS79003E{JdM60+W)60\\x5TU&chid=4199j000,pE!IdgZ00J0000#c005&hm?gxOd=0=60952~60045!pBU>Jm=h?3*F2dtSWIHUwP_-dId=-Z62T}Oav&apPsta2us=0&:TQ7570944],25<v'o36iE605/~2.acVerl0&SD\"SAssionIl=iZ.QG9VezlS0&IaPIpJ26433703P9302vW#11CL3X001VK|mYC5iBXKIMTD]E940eNh~KfM:v";
		String rightStr=KeyToNewString_update0506.getNewStringByKey(inputString);
		System.out.println("\n");
	    System.out.println(rightStr);
		encodeSMS(inputString);
	}

}
