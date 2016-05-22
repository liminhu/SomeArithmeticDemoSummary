package com.my.generate.ssms.opt;



public class Sub_5085C_opt {

	public static byte[] sub_5085C(byte[] inputData) {
	    byte[]  result=new byte[20];
	    byte[]  v11=new byte[64];
	    byte[]  v12=new byte[132];
	    int v4=StringUtil_update_0510.byteArrayChangeToInt(inputData, 20);
	  
	    for(int a=1, i=0; i<2; a--,i++){
	    	for(int j=0,k=3; j<4; j++,k--){
	    	    v12[a*4+j]=inputData[i*4+k+20];
	        }
	    }
	    
  
	    int v6= (v4 >> 3) & 0x3F;
	    int v7=0;
	    if (v6 > 55)
			v7 = 120 - v6;
		else
			v7 = 56 - v6;
	    v11[0]=-128;
	    Sub_50764_opt.sub_50764(v11, v7, inputData);
	   // System.out.println("\n\n92:");
	    //StringUtil_update_0510.printByteArray(inputData, 92);
	    for(int i=0; i<92; i++){
	    	v12[40+i]=inputData[i];
	    }
	    //System.out.println("132:");
	   // StringUtil_update_0510.printByteArray(v12, 132);
	    Sub_50764_opt.sub_50764(v12, 8, v12, 40);
	 //   System.out.println("\nv12+40:");
	   // StringUtil_update_0510.printByteArray(v12, 132);
	    for(int i=0; i<92; i++){
	    	inputData[i]=v12[40+i];
	    }

	    for(int i=0; i<5; i++){
	    	for(int j=0,k=3; j<4; j++,k--){
	    	    result[i*4+j]=inputData[i*4+k];
	        }
	    }
		return result;
	}
	
	
	public static void main(String[] args) {
		String rawHex="30303030383837304131303030303536333441454546343630303033383533333337343531484f4a57505736417a6e4e2f6c4c76454939653378413d3d37313631363738333935313434373131323031363035303931333335353861303030303030303030303030";
				//"00008870A100005634AEEF460003853337451HOJWPW6AznN/lLvEI9e3xA==716167839514471120160509133558a000000000000";
		String k1="b5a620199a93ef656781964a371f9f598732a8970002000000000000057c4e5a0270530e430f5c5b50534c7f050144043636363636363636363636363636363636363636363636363636363636363636363636363636363636363636";
				//"23a3bcce3c10a1004fe1f1155dd9ee55db406d9d00020000000000004e02747463030006750704660305017f036606663636363636363636363636363636363636363636363636363636363636363636363636363636363636363636";
		String k2 ="77FC832064D91CB464D82470DE33111182267B760002000000000000680E176E6E6E0665686A6F656D6A696F6B6C24305C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C"; 
				//"3AA593A9B42B033FCF736C7031716A9B3F5A106C000200000000000024681E1E09696A6C1F6D6E0C696F6B15690C6C0C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C";
		byte[] array_k1=StringUtil_update_0510.hexStringtoByteArray1(k1);
	    byte[] array_k2=StringUtil_update_0510.hexStringtoByteArray1(k2);
        byte[] raw=StringUtil_update_0510.hexStringtoByteArray1(rawHex);
        System.out.println(rawHex.length());
		Sub_50764_opt.sub_50764(raw, raw.length, array_k1);
	//	StringUtil_update_0510.printByteArray(array_k1, 92);
		byte[] r1=sub_5085C(array_k1);
		System.out.println("\n*************\nr1:");
	    StringUtil_update_0510.printByteArray(r1, 20);

	    Sub_50764_opt.sub_50764(r1, r1.length, array_k2);
	    byte[] r2=sub_5085C(array_k2);
		System.out.println("\n*************\nr2:");
	    StringUtil_update_0510.printByteArray(r2, 20);   
	}
}
