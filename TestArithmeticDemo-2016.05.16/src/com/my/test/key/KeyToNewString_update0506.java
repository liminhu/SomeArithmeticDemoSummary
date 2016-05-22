package com.my.test.key;


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
		   //"aZ8RyZRWxcJno2cBcwQDAHYjmZoOC5Gi";
		    //aZ8RyZRWxcJno2cBcwQDAHYjmZoOC5Gi
		                                 //86T077/%85363514f00a1014ME3u73AB3VfgR2w8fiiH6ZL5VjI8==8j:[26z}6O0936o220)Qm=31d95628wM000|0H00000M!~QCe jkME!iB3Sm49jMCd07Ta>
		//String inputString = new String("863077028536351460000640798962PB3VVCR2w8fiiCsZE50jIA==779497899514471120150826103350p0000000000002tDpNyvxuE/hYVk+jyt60/XCNRg=");
	    //String inputString="020KqU2fE6IuO0aHjI8A589w0000Ajrkf5A1AchvY00000000000000003wUVhvRPs@@000000000OqcP8RNnzgni001vmK15001b8eh2zI4Ns2NxfC3TS7b18FdNZb2xJ7oyS8=7";
	    String inputString="urot7colN(m=s2&^eek*pe=28{9hkr4%py>xcy=5xS&DVer&iow=2<1N0&cJidBS79003E{JdM60+W)60\\x5TU&chid=4199j000,pE!IdgZ00J0000#c005&hm?gxOd=0=60952~60045!pBU>Jm=h?3*F2dtSWIHUwP_-dId=-Z62T}Oav&apPsta2us=0&:TQ7570944],25<v'o36iE605/~2.acVerl0&SD\"SAssionIl=iZ.QG9VezlS0&IaPIpJ26433703P9302vW#11CL3X001VK|mYC5iBXKIMTD]E940eNh~KfM:v";
		System.out.println(KeyToNewString_update0506.getNewStringByKey(inputString));
	}
	//ProtocolNum=02&feeType=28&chargepolicy=5&SDKVersion=20150&cpid=779093&cid=609316048582&chid=41999000&pakId=000000000000&chargeid=006095246004&cpparam=UxwVF2dtSWRIUpP1&dId=3wq2fi8av&apkstatus=0&ms=15709448325&vcode=060593&packer=0&SDKSessionID=iZWQn9VmJlS0&IMSI=026433003698024WY11103A001VKAmLm2iBXKI+TD/E9Q0kNhWKfM=6
	
	//020K)U2fEkIuO0NpjI8A5E9w0mj0Kj!+f5A1\chvYB"000V0<000d00K'EFU*hFRPs@CA00#0|000OqcP8Rfnzgni0%1vmsI5201 8ezz~I4Ns2Nxfw3~S7c18FdN3b,x;ioTQ8=7
}
