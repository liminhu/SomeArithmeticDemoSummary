package com.my.test.sub_F128;

public class Sub_F128 {
	private static int resultOutPrint(char[] out, int length) {
		for (int i = 0; i < length ; i ++) {
			if(i % 16 == 0 && i!=0)
				System.out.println("");
			System.out.format("%02x ", new Object[] { new Integer(out[i]) });
		}
		return 1;
	}
	
	public static String sub_F128(String initTableString, char[] inputData, int inputDatalength){
		StringBuilder resultBuilder=new StringBuilder();
		char[] tableData=new char[0x100];
		for(int i=0; i<0x100; i++){
			tableData[i]=(char)(i & 0xFF); 
		}
		System.out.println("\n\n第一次初始化0xFF空间：\n");
		resultOutPrint(tableData, 0x100);
		char input_value, table_value, change_value;
		int  temp = 0;
		for (int i = 0; i < 0x100; i++)
		{
			temp = (temp + tableData[i]) & 0xFF;
			table_value = tableData[i];
			input_value = initTableString.charAt(i % initTableString.length());
			temp = (input_value + temp) & 0xFF;
			change_value = tableData[temp];
			tableData[i] = change_value;
			tableData[temp] = table_value;
			tableData[i] = (char)(((int)(change_value & 0xFF) + 0x69) % 0xFF); 
		}
		System.out.println("\n\n初始化表后结果为：\n");
		resultOutPrint(tableData, 0x100);
		temp = 0;
		int var_238 = 0 , var_234=0;
		for (int i = 0; i < inputDatalength; i++)
		{
			var_238 = (var_238 + 1) & 0xFF;
			table_value = tableData[var_238];
			var_234 = (var_234 + table_value) & 0xFF;
			change_value = tableData[var_234];
			tableData[var_238] = change_value;
			tableData[var_234] = table_value;
			temp = (change_value + table_value) & 0xFF;
			resultBuilder.append((char)(tableData[temp] ^ inputData[i]));
		}
		System.out.format("\n\n最终的结果为：\n%s\n\n", new Object[]{resultBuilder.toString()}); //new Integer(inputDatalength),
		resultOutPrint(resultBuilder.toString().toCharArray(), inputDatalength);
		return resultBuilder.toString();
	}
	
	
	
	public static void main(String[] args) {
	      String initTableString="0753554956420868";
	      char inputData[] = { 0x27, 0xb7, 0x0c, 0x56, 0x2c, 0x28, 0xbb, 0x5e, 0x8c, 0x59, 0xfc, 0x30, 0x49, 0x63, 0xcc, 0x09, 0x86, 0x9d, 0xed, 0x97, 0x38, 0x1c, 0xaf, 0x8d, 0xc8, 0x69, 0xed, 0x66, 0x33, 0xa7, 0x94, 0x31, 0x2b, 0xdb, 0x31, 0x30, 0x98, 0xe2, 0x70, 0x62, 0x7d, 0x8c, 0x2f, 0x85, 0xcb, 0x6b, 0xb2, 0xf5, 0xcc, 0xcb, 0xe4, 0xe6, 0x48, 0x2d, 0xcd, 0x42, 0x52, 0x7e, 0xb0, 0x51, 0xaf, 0x45, 0x4e, 0xe0, 0x4d, 0x4d, 0x87, 0x63, 0x17, 0xc4, 0x02, 0xa1, 0x33, 0xe2, 0x1c, 0xce, 0x4f, 0x0d, 0x8f, 0x34, 0xc8, 0x0c, 0xfe, 0x38, 0xb0, 0x6e, 0xb9, 0xf8, 0x5a, 0x08, 0x53, 0x1a, 0x9c, 0xa6, 0xe0, 0xb7, 0x30, 0xb4, 0xd8, 0xc8, 0x67, 0x1e, 0x62, 0x83, 0xd9, 0x81, 0x55, 0xc0, 0xed, 0xfb, 0xd2, 0xf4 };
	      int inputDataLength=112;
	    /* 
	      String initTableString="aZ8RyZRWxcJno2cBcwQDAHYjmZoOC5Gi";
	      String inputData="3c3f786d6c2076657273696f6e3d27312e302720656e636f64696e673d275554462d3827207374616e64616c6f6e653d2779657327203f3e3c6368617267655f726571756573743e3c73646b76657273696f6e3e31323030313030303c2f73646b76657273696f6e3e3c747970653e353c2f747970653e3c72657175657374747970653e313c2f72657175657374747970653e3c637069643e3639393031383c2f637069643e3c6369643e31303135343836303c2f6369643e3c636869643e3330323330303234303030303030303c2f636869643e3c696d73693e3436303030313031343134333537333c2f696d73693e3c696d65693e3836333037373032383533363335313c2f696d65693e3c73646b73657373696f6e69643e6b4e655837784b534a686957366962313c2f73646b73657373696f6e69643e3c61706b7374617475733e703c2f61706b7374617475733e3c7265717565737454696d653e323031352d31312d31322031373a34303a32383c2f7265717565737454696d653e3c6370706172616d3e3c2f6370706172616d3e3c2f6368617267655f726571756573743e30303030303030303836333037373032383533363335313436303030313031343134333537335042335656435232773866696943735a4535306a49413d3d343634333834373238363433313034383230313531313132303934303238703030303130303030303030313030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030303030304c4843444c4747634239316854726f31633559376b4c65444e706f3d";
	      int inputDataLength=0x5FC;
	     */
	      String resultString=sub_F128(initTableString, inputData, inputDataLength);
	      System.out.println("\n\n结果："+resultString);
	}
}
