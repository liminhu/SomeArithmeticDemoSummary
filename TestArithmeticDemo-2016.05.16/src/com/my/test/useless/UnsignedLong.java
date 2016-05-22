package com.my.test.useless;

public class UnsignedLong {
	
	private byte[] longToDword(long value) {
		byte[] data = new byte[4];
		for (int i = 0; i < data.length; i++) {
		   data[i] = (byte) (value >> (8 * i));
		}
		return data;
	}

	
}
