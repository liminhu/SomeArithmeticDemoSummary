package com.my.generate.ssms.opt;


public class KeyToNewString_update0506 {
	public static String getNewStringByKey(String inputString){
		String key="xcJno2cBcwQDoOC5GiAHYjmZaZ8RyZRW";         
		if(key==null || inputString==null){
			return null;
		}
		StringBuilder stringBuilderKey = new StringBuilder();
		for(int i = 0 ; i<8 ; i++){
			stringBuilderKey.append(key);
		}
		String tempKeyStr = stringBuilderKey.toString();
		byte[] tempByte = new byte[1024];
		for(int i = 0; i < 1024 ; i=i+4){
			tempByte[i]=(byte)(i/4);
		}
		int byte_1, byte_2, result, keep=0, temp;
		//通过key的值来初始化1K的空间值 
		for(int i = 0 ; i < 0xFF ; i++){
			byte_1 = tempKeyStr.charAt(i);
			byte_2 = tempByte[i * 4];
			result = (byte_1 + keep + byte_2) & 0xff;
			keep = result;
			tempByte[4 * i] = tempByte[4 * result];
			tempByte[4 * result] = (byte)byte_2;
		}
		//StringUtil_update_0505.printByteArray(tempByte, 1024);
		
		int v107 = 0, v68, v71 , v86 = 0 , v87 = 0 , v26 ;
		boolean v27;
		byte[] output = new byte[inputString.length()];
		for(int i = 0 ; i < inputString.length() ; i++){
			v71 = (v86 + 1) & 0xFF;
			//System.out.println(v71 * 4);
			byte_1 = tempByte[v71 * 4];
			v86=(v86+1)&0xFF;
			v87 = (v87 + byte_1) & 0xff;
			v71 *= 4;
			tempByte[v71] = tempByte[v87 * 4];
			tempByte[v87 * 4] =(byte)byte_1;
			temp = (((byte_1 & 0xff) + tempByte[v71]) & 0xff) * 4;
			v107 = tempByte[temp];
			output[i]=(byte)(inputString.charAt(i) ^ v107);
			v68 = output[i];
			v26 = output[i];
			v27 = ((v26 - 32) & 0xFF) > 0x5E || Integer.toUnsignedLong((v26 - 96)) <= 0;
			if(v27){
				v68 = (v68 ^ v107) & 0xff;
				output[i] =(byte)v68;
			} 
		}
		return new String(output);
	}
	
	public static void main(String[] args) {
		String key="xcJno2cBcwQDoOC5GiAHYjmZaZ8RyZRW";              
		String inputString="urot7colN(m=s2&^eek*pe=28{9hkr4%py>xcy=5xS&DVer&iow=2<1N0&cJidBS79003E{JdM60+W)60\\x5TU&chid=4199j000,pE!IdgZ00J0000#c005&hm?gxOd=0=60952~60045!pBU>Jm=h?3*F2dtSWIHUwP_-dId=-Z62T}Oav&apPsta2us=0&:TQ7570944],25<v'o36iE605/~2.acVerl0&SD\"SAssionIl=iZ.QG9VezlS0&IaPIpJ26433703P9302vW#11CL3X001VK|mYC5iBXKIMTD]E940eNh~KfM:v";
		System.out.println(KeyToNewString_update0506.getNewStringByKey(inputString));
	}
	
}
