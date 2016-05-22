package com.my.generate.ssms.opt;


public class Sub_sa1_4F1B0_opt {

	private static int bytesToIn(byte[] src, int offset) {
		return (int) ((src[offset] & 0xFF) | ((src[offset + 1] & 0xFF) << 8)
				| ((src[offset + 2] & 0xFF) << 16) | ((src[offset + 3] & 0xFF) << 24));
	}
	
    private static byte[] intDataPutIntoByteArray(byte[] src, int value,
			int offset) {
		byte[] a = new byte[4];
		a[3] = (byte) ((value >> 24) & 0xff);
		a[2] = (byte) ((value >> 16) & 0xff);
		a[1] = (byte) ((value >> 8) & 0xff);
		a[0] = (byte) ((value) & 0xff);
		for (int i = 0; i < 4; i++) {
			src[offset + i] = a[i];
		}
		return src;
	}
    
    
    private static int ROTL32(int dword, int n){
    	long unsigned = Integer.toUnsignedLong(dword);
    	return (int)((unsigned) << (n) ^ ((unsigned) >> (32 - (n))));
    }
    
    private static int[] sha1ProcessBlock(int[] hash, int[] block){
    	int[] wblock=new int[80];
    	int a,b,c,d,e,temp;
    	int t=0;
    	for(int i=0; i<16; i++){
    		wblock[i]=block[i];
      		//System.out.format("wblock["+i+"]:"+"0x%08x\n", new Object[]{wblock[i]});
    	}
    	for(t=16; t<80; t++){
    		int middleData=ROTL32(wblock[t - 3] ^ wblock[t - 8] ^ wblock[t - 14] ^ wblock[t - 16], 1);
    		wblock[t] =middleData;
    		//System.out.format("wblock["+t+"]:"+"0x%08x\n", new Object[]{wblock[t]});
    	}
    	
    	a = hash[0];
    	b = hash[1];
    	c = hash[2];
    	d = hash[3];
    	e = hash[4];

    	for (t = 0; t < 20; t++){
    		temp = ROTL32(a, 5) + (((c ^ d) & b) ^ d) + e + wblock[t] + 0x5A827999;
    		//System.out.format("temp["+t+"]:"+"0x%08x\n", new Object[]{temp});
    		e = d;
    		d = c;
    		c = ROTL32(b, 30);
    		b = a;
    		a = temp;
    	}

    	for (t = 20; t < 40; t++){
    		temp = ROTL32(a, 5) + (b ^ c ^ d) + e + wblock[t] + 0x6ED9EBA1;
    		e = d;
    		d = c;
    		c = ROTL32(b, 30);
    		b = a;
    		a = temp;
    	}

    	for (t = 40; t < 60; t++){
    		temp = ROTL32(a, 5) + ((b & c) | (b & d) | (c & d)) + e + wblock[t] + 0x8F1BBCDC;
    		e = d;
    		d = c;
    		c = ROTL32(b, 30);
    		b = a;
    		a = temp;
    	}

    	for (t = 60; t < 80; t++){
    		temp = ROTL32(a, 5) + (b ^ c ^ d) + e + wblock[t] + 0xCA62C1D6;
    		e = d;
    		d = c;
    		c = ROTL32(b, 30);
    		b = a;
    		a = temp;
    	}

    	hash[0] += a;
    	hash[1] += b;
    	hash[2] += c;
    	hash[3] += d;
    	hash[4] += e;
    	return hash;
    }
    
    /**
     * 参数为3个不然后面的较验算法会出现问题
     * @param result
     */
    public static byte[] getLastKeyResult_4F1B0_opt(byte[] result, byte[] a3, int a2){
    	byte[]  temp=new byte[64];
    	for (int i = 0; i < 16; i++){
    		for (int j = 0; j < 4; j++){
    			temp[4 * i + j] = a3[4 * i + (3 - j)+a2];
    		}
    	}
    	int[] hash=new int[5];
    	int[] block=new int[16];
    	for(int i=0; i<16; i++){
    		block[i]=bytesToIn(temp, 4*i);
    		//System.out.format("block["+i+"]:"+"0x%x\n", new Object[]{block[i]});
    	}
    
    	for(int i=0; i<5; i++){
    		hash[i]=bytesToIn(result, 4*i);
    		//System.out.format("result["+i+"]:"+"0x%x\n", new Object[]{hash[i]});
    	}
    	hash=sha1ProcessBlock(hash, block);
    	for(int i=0; i<5; i++){
    		intDataPutIntoByteArray(result, hash[i], 4*i);
    	}
    	return result;
    }	
    
    
    
    public static byte[] getLastKeyResult_4F1B0_opt(byte[] result,  int a2){
    	byte[]  temp=new byte[64];
    	for (int i = 0; i < 16; i++){
    		for (int j = 0; j < 4; j++){
    			temp[4 * i + j] = result[4 * i + (3 - j)+a2];
    		}
    	}
    	int[] hash=new int[5];
    	int[] block=new int[16];
    	for(int i=0; i<16; i++){
    		block[i]=bytesToIn(temp, 4*i);
    		//System.out.format("block["+i+"]:"+"0x%x\n", new Object[]{block[i]});
    	}
    
    	for(int i=0; i<5; i++){
    		hash[i]=bytesToIn(result, 4*i);
    		//System.out.format("result["+i+"]:"+"0x%x\n", new Object[]{hash[i]});
    	}
    	hash=sha1ProcessBlock(hash, block);
    	for(int i=0; i<5; i++){
    		intDataPutIntoByteArray(result, hash[i], 4*i);
    	}
    	return result;
    }	

   
    public static void main(String[] args) {
		String data_hex="b9f6cbb8380dddb531d8c304d43f0245601e87c8000600000000000031363738333935313434373131323031363035303931333335353861303030303030303030303030800000000000000000000000000000000000000000000540";
		
		byte[] array= StringUtil_update_0510.hexStringtoByteArray1(data_hex);
		getLastKeyResult_4F1B0_opt(array, 28);
		StringUtil_update_0510.printByteArray(array, 92);
	}
    
}
