package com.my.test.sub_5085C;

public class Sub_5085C {
	/**
	 * reversedOrder: 作用 ：逆序输出数据
	 * 
	 * @param data
	 * @return
	 */
	private static int reversedOrder(int data) {
		int v1;
		int v2;
		int v3;
		v2 = Sub_50764.__ROR4__(data, 24);
		v1 = v2;
		v3 = Sub_50764.__ROR4__(data, 8);
		return v1 & 0xFF00FF | v3 & 0xFF00FF00;
	}

	private static int resultOutPrint(char[] out, int length) {
		for (int i = 0, k = 0; i < length - 1; i = i + 4, k++) {
			Integer integer = new Integer(Sub_50764.bytesToIn(out, 4 * k));
			System.out.format("0x%x\n", new Object[] { integer });
		}
		return 1;
	}
	

	public static char[] sub_5085C(char[] inputs) {
		char[] result = new char[20];
		char[] temp = new char[132];
		char[] resultTemp = new char[92];
		int v4 = Sub_50764.bytesToIn(inputs, 20);
		int v13 = reversedOrder(v4);
		int v5 = reversedOrder(Sub_50764.bytesToIn(inputs, 24));
		int v6 = (v4 >> 3) & 0x3F;
		int v7;
		if (v6 > 55)
			v7 = 120 - v6;
		else
			v7 = 56 - v6;
		temp[0] = (char) -128;
		Sub_50764.sub_50764(temp, v7, inputs);
		Sub_50764.intDataPutIntoByteArray(temp, v5, 0);
		Sub_50764.intDataPutIntoByteArray(temp, v13, 4);
	    Sub_50764.sub_50764(temp, 8, inputs);
	    resultTemp=inputs;
		Sub_50764.intDataPutIntoByteArray(result,
				reversedOrder(Sub_50764.bytesToIn(resultTemp, 0)), 0);
		Sub_50764.intDataPutIntoByteArray(result,
				reversedOrder(Sub_50764.bytesToIn(resultTemp, 4)), 4);
		Sub_50764.intDataPutIntoByteArray(result,
				reversedOrder(Sub_50764.bytesToIn(resultTemp, 8)), 8);
		Sub_50764.intDataPutIntoByteArray(result,
				reversedOrder(Sub_50764.bytesToIn(resultTemp, 12)), 12);
		Sub_50764.intDataPutIntoByteArray(result,
				reversedOrder(Sub_50764.bytesToIn(resultTemp, 16)), 16);
		resultTemp = null;
		temp = null;
		return result;
	}
	
	
	public static void main(String[] args) {
		char k1[] = { 0x8C, 0xC, 0xC8, 0xCB, 0xAC, 0xE2, 0x99, 0xF5, 0x32, 0xC8, 0xB8, 0xBD, 0xC3, 0xC1, 0x95, 0xDA, 0x25, 0x30, 0x68, 0xF8, 0x00, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 7, 4, 5, 2, 3, 0, 1, 0xE, 0xF, 6, 7, 4, 5, 2, 3, 0, 1, 0xE, 0xF, 6, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36, 0x36 };
		char k2[] = { 0xCD, 0xBD, 0xBD, 0x98, 0xFE, 0x7B, 0xE0, 0x58, 0xEA, 0xDD, 0x5C, 0xAD, 0x0B, 0x43, 0xC0, 0x3A, 0x25, 0x68, 0x10, 0xFE, 0x00, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x6D, 0x6E, 0x6F, 0x68, 0x69, 0x6A, 0x6B, 0x64, 0x65, 0x6C, 0x6D, 0x6E, 0x6F, 0x68, 0x69, 0x6A, 0x6B, 0x64, 0x65, 0x6C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C, 0x5C };
		char[] r1 = new char[20];
		char[] r2 = new char[20];
		String str = "3c3f786d6c2076657273696f6e3d27312e302720656e636f64696e673d275554462d3827207374616e64616c6f6e653d2779657327203f3e3c6368617267655f726571756573743e3c73646b76657273696f6e3e31323030313030303c2f73646b76657273696f6e3e3c747970653e353c2f747970653e3c72657175657374747970653e323c2f72657175657374747970653e3c637069643e3639393031383c2f637069643e3c6369643e31303135343836303c2f6369643e3c636869643e3330323330303234303030303030303c2f636869643e3c696d73693e3436303030313037333132313531363c2f696d73693e3c696d65693e3836333037373032383533363335313c2f696d65693e3c73646b73657373696f6e69643e486c56796c5a6e67576f4e447a4d37733c2f73646b73657373696f6e69643e3c61706b7374617475733e703c2f61706b7374617475733e3c7265717565737454696d653e323031352d30392d31312032303a30383a33303c2f7265717565737454696d653e3c6370706172616d3e3c2f6370706172616d3e3c2f6368617267655f726571756573743e30303030303030303836333037373032383533363335313436303030313037333132313531365042335656435232773866696943735a4535306a49413d3d30373533353534393536343230383638323031353039313131323038333070303030323030303030303031303030303030333130303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030";
		Sub_50764.sub_50764(str.toCharArray(), str.length(), k1);
		r1=sub_5085C(k1);
		System.out.println("\n1.  第一次输出：\n");

		resultOutPrint(r1, 20);
		Sub_50764.sub_50764(r1, 20, k2);
		r2=sub_5085C(k2);
		System.out.println("\n2.  第二次输出：\n");
		resultOutPrint(r2, 20);
		
	/*	char a1[] = {
				0x61, 0x38, 0x63, 0x35, 0x30, 9, 0x15, 0xCA, 0xFC, 0x6B, 
				0x20, 0xB5, 0x3A, 0x1C, 0xA9, 0xC6, 0x23, 0xF, 0xC1, 0x27, 
				0x90, 8, 0, 0, 0, 0, 0, 0, 0x33, 0x30,
				0x33, 0x30, 0x33, 0x30, 0x33, 0x30, 0x33, 0x30, 0x33, 0x30, 
				0x33, 0x30, 0x33, 0x30, 0x33, 0x30, 0x33, 0x36, 0x33, 0x33, 
				0x33, 0x30, 0x33, 0x37, 0x33, 0x37, 0x33, 0x30, 0x33, 0x32, 
				0x33, 0x38, 0x33, 0x35, 0x33, 0x33, 0x33, 0x36, 0x33, 0x33, 
				0x33, 0x35, 0x33, 0x31, 0x33, 0x34, 0x33, 0x36, 0x33, 0x30, 
				0x33, 0x30, 0x33, 0x30, 0x33, 0x31, 0x33, 0x30, 0x33, 0x31, 
				0x33, 0x34
			};
		resultOutPrint(sub_5085C(a1), 20);*/
	}

}
