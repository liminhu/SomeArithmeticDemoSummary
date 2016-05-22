package com.my.generate.ssms.opt;


public class Sub_50764_opt {

	public static int sub_50764(byte[] rawStr, int rawLen, byte[] k) {
		int v4 = StringUtil_update_0510.byteArrayChangeToInt(k, 20);
		int v6 = 8 * rawLen;
		int temp = v6 + v4;
		StringUtil_update_0510.intChangeToByteArray(temp, k, 20);
		if (temp < v6) {
			int v7 = StringUtil_update_0510.byteArrayChangeToInt(k, 24) + 1;
			StringUtil_update_0510.intChangeToByteArray(v7, k, 24);
		}
		int v9 = v4 >> 3;
		int v10 = v9 & 0x3F;
		int t = StringUtil_update_0510.byteArrayChangeToInt(k, 24)
				+ (rawLen >> 29);
		StringUtil_update_0510.intChangeToByteArray(t, k, 24);
		int time = 0;
		if (rawLen >= 64 - v10) {
			for (int i = 0; i < (64 - v10); i++) {
				k[28 + i+ v10] = rawStr[i];
			}
		//	System.out.println("\nbefore k:\n");
		//	StringUtil_update_0510.printByteArray(k, 92);
			Sub_sa1_4F1B0_opt.getLastKeyResult_4F1B0_opt(k, 28);
		//	System.out.println("*************\n");
		//	StringUtil_update_0510.printByteArray(k, 92);
		//	System.out.println("\n\n**************************\n");
			time=64 - v10 ;
			if (time < rawLen - 63) {
				for (time = 0; time + 64 - v10 < rawLen - 63; time += 64) {
					Sub_sa1_4F1B0_opt.getLastKeyResult_4F1B0_opt(k, rawStr,
							time);
				}
			}
			for (int j = 0; j < (rawLen - time); j++) {
				k[j + 28] = rawStr[j + time];
			}
		} else {
			for (int j = 0; j < (rawLen - time); j++) {
				k[j + 28 + v10] = rawStr[j];
			}
		}
		return 0;
	}

	public static int sub_50764(byte[] rawStr, int rawLen, byte[] inputData,
			int index) {
		byte[] k = new byte[92];
		StringUtil_update_0510.byteCopy(k, 92, index, inputData);
	//	System.out.println("key before:\n");
	//	StringUtil_update_0510.printByteArray(k, 92);
		sub_50764(rawStr,rawLen, k);
		StringUtil_update_0510.byteCopy(inputData,k,92,index);
	//	System.out.println("result key:\n");
	//	StringUtil_update_0510.printByteArray(k, 92);
	//	System.out.println("\n\n*********************");
		return 0;
	}

	public static void main(String[] args) {
		String raw = "00008870A100005634AEEF460003853337451HOJWPW6AznN/lLvEI9e3xA==716167839514471120160509133558a000000000000";
		String k1 = "23a3bcce3c10a1004fe1f1155dd9ee55db406d9d00020000000000004e02747463030006750704660305017f036606663636363636363636363636363636363636363636363636363636363636363636363636363636363636363636";
		byte[] array_k1 = StringUtil_update_0510.hexStringtoByteArray1(k1);

		//sub_50764(raw.getBytes(), raw.getBytes().length, array_k1);
		//StringUtil_update_0510.printByteArray(array_k1, 92);
		
		String v12="00000000000005400000000000000000000000000000000000000000000000000000000000000000b9f6cbb8380dddb531d8c304d43f0245601e87c8c00500000000000031363738333935313434373131323031363035303931333335353861303030303030303030303030800000000000000000000000000000003378413d3d373136";
		
		byte[] array_v12= StringUtil_update_0510.hexStringtoByteArray1(v12);
		sub_50764(array_v12, 8, array_v12, 40);
		StringUtil_update_0510.printByteArray(array_v12, 132);

	}

}
