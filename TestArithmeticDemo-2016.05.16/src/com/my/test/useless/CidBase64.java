package com.my.test.useless;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class CidBase64 {

	/**
	 * 作用传入一个cid的字符串，通过一系列的循环右移操作得到一个新字符串，
	 * 最后将新得到的字符串进行base64加密输出
	 * @param cid
	 * @return
	 */
	public static String getBase64String(String cid) {
		int v1; // r6@1
		int v2; // r12@1
	//	String v3; // r3@1
		int v4; // r5@1
		int v5; // ST04_4@1
		int v6; // ST08_4@1
		int v7; // r4@1
		int v8; // r4@1
		int v9; // ST0C_4@1
		int v10; // r1@1
		int v11; // r1@1
		int v12; // ST10_4@1
		int v13; // r6@1
		int v14; // r2@1
		int v15; // ST14_4@1
		int v16; // r5@1
		int v17; // ST18_4@1
		int v18; // r5@1
		int v19; // r4@1
		int v20; // ST1C_4@1
		int v21; // r4@1
		int v22; // r1@1
		int v23; // ST20_4@1
		int v24; // r1@1
		int v25; // r2@1
		int v26; // ST24_4@1
		int v27; // r2@1
		int v28; // r5@1
		int v29; // ST28_4@1
		int v30; // r5@1
		int v31; // r4@1
		int v32; // ST2C_4@1
		int v33; // r4@1
		int v34; // r1@1
		int v35; // ST30_4@1
		int v36; // r1@1
		int v37; // r2@1
		int v38; // ST34_4@1
		int v39; // r2@1
		int v40; // r5@1
		int v41; // ST38_4@1
		int v42; // r5@1
		int v43; // r4@1
		int v44; // ST3C_4@1
		int v45; // r4@1
		int v46; // r1@1
		int v47; // ST40_4@1
		int v48; // r1@1
		int v49; // r3@1
		int v50; // ST44_4@1
		int v51; // r2@1
		int v52; // r2@1
		int v53; // r3@1
		int v54; // r3@1
		int v55; // r4@1
		int v56; // r4@1
		int v57; // r1@1
		int v58; // r1@1
		int v59; // r2@1
		int v60; // r2@1
		int v61; // r3@1
		int v62; // r3@1
		int v63; // r4@1
		int v64; // r4@1
		int v65; // r1@1
		int v66; // r1@1
		int v67; // r2@1
		int v68; // r2@1
		int v69; // r3@1
		int v70; // r3@1
		int v71; // r4@1
		int v72; // r4@1
		int v73; // r1@1
		int v74; // r1@1
		int v75; // r2@1
		int v76; // r2@1
		int v77; // r3@1
		int v78; // r3@1
		int v79; // r4@1
		int v80; // r5@1
		int v81; // r1@1
		int v82; // r1@1
		int v83; // r2@1
		int v84; // r2@1
		int v85; // r3@1
		int v86; // r3@1
		int v87; // r4@1
		int v88; // r4@1
		int v89; // r1@1
		int v90; // r1@1
		int v91; // r2@1
		int v92; // r2@1
		int v93; // r3@1
		int v94; // r3@1
		int v95; // r4@1
		int v96; // r4@1
		int v97; // r1@1
		int v98; // r1@1
		int v99; // r2@1
		int v100; // r2@1
		int v101; // r3@1
		int v102; // r3@1
		int v103; // r4@1
		int v104; // r4@1
		int v105; // r1@1
		int v106; // r1@1
		int v107; // r2@1
		int v108; // r2@1
		int v109; // r3@1
		int v110; // r3@1
		int v111; // r4@1
		int v112; // r4@1
		int v113; // r1@1
		int v114; // r1@1
		int v115; // r2@1
		int v116; // r2@1
		int v117; // r3@1
		int v118; // r3@1
		int v119; // r5@1
		int v120; // r5@1
		int v121; // r1@1
		int v122; // r1@1
		int v123; // r4@1
		int v124; // r4@1
		int v125; // r3@1
		int v126; // r3@1
		int v127; // r5@1
		int v128; // r5@1
		int v129; // r1@1
		int v130; // r1@1
		int v131; // r4@1
		int v132; // r4@1
		int v133; // r3@1
		int v134; // r3@1
		int v135; // r2@1
		int v136; // r2@1
		int v137; // r1@1
		int v138; // r1@1
		int v139; // r4@1
		int v140; // r4@1
		int v141; // r3@1
		int v142; // r3@1
		int v143; // r2@1
		int v144; // r2@1
		int v145; // r1@1
		int v146; // r1@1
		int v147; // r4@1
		int v148; // r4@1
		int v149; // r3@1

		v1 = 0x10325476;
		v2 = 0x98BADCFE;
		v4 = 0xEFCDAB89;
		v5 = 0x67452301;
		v6 = 0x31303534;
		if (cid == null || "".equals(cid))
			return null;
	//	v3 = cid;
		int[] intArray = getIntArrayFromString(cid);

		int t = (v5 + intArray[0] - 680876936 + ((v2 ^ v1) & v4 ^ v1));
		v7 = lrotr(t, 25);
		v8 = v7 + v4;
		v9 = intArray[1];
		t = v1 + v9 - 389564586 + ((v2 ^ v4) & v8 ^ v2);
		v10 = lrotr(t, 20);
		v11 = v10 + v8;
		v12 = intArray[2];
		v13 = lrotr(((v8 ^ v4) & v11 ^ v4) + v12 + v2 + 606105819, 15);
		v14 = v13 + v11;
		v15 = intArray[3];
		v16 = lrotr(((v11 ^ v8) & (v13 + v11) ^ v8) + v4 + v15 - 1044525330, 10);
		v17 = intArray[4];
		v18 = v16 + v13 + v11;
		v19 = lrotr((((v13 + v11) ^ v11) & v18 ^ v11) + v17 - 176418897 + v8,
				25);
		v20 = intArray[5];
		v21 = v19 + v18;
		v22 = lrotr(((v18 ^ v14) & v21 ^ v14) + v20 + 1200080426 + v11, 20);
		v23 = intArray[6];
		v24 = v22 + v21;
		v25 = lrotr(((v21 ^ v18) & v24 ^ v18) + v23 - 1473231341 + v14, 15);
		v26 = intArray[7];
		v27 = v25 + v24;
		v28 = lrotr(((v24 ^ v21) & v27 ^ v21) + v26 - 45705983 + v18, 10);

		v29 = 0x0000800A;
		v30 = v28 + v27;
		v31 = lrotr(((v27 ^ v24) & v30 ^ v24) + v29 + 1770035416 + v21, 25);

		v32 = 0x00000000;
		v33 = v31 + v30;
		v34 = lrotr(((v30 ^ v27) & v33 ^ v27) + v32 - 1958414417 + v24, 20);

		v35 = 0x00000000;
		v36 = v34 + v33;
		v37 = lrotr(((v33 ^ v30) & v36 ^ v30) + v35 - 42063 + v27, 15);

		v38 = 0x00000000;
		v39 = v37 + v36;
		v40 = lrotr(((v36 ^ v33) & v39 ^ v33) + v38 - 1990404162 + v30, 10);

		v41 = 0x00000000;
		v42 = v40 + v39;
		v43 = lrotr(((v39 ^ v36) & v42 ^ v36) + v41 + 1804603682 + v33, 25);

		v44 = 0x00000000;
		v45 = v43 + v42;
		v46 = lrotr(v36 + v44 - 40341101 + ((v42 ^ v39) & v45 ^ v39), 20);

		v47 = 0x00000108;
		v48 = v46 + v45;

		v49 = 0x00000000;
		v50 = v49;

		v51 = lrotr(v39 + v47 - 1502002290 + ((v45 ^ v42) & v48 ^ v42), 15);
		v52 = v51 + v48;
		v53 = lrotr(v49 + 1236535329 + v42 + ((v48 ^ v45) & v52 ^ v45), 10);
		v54 = v53 + v52;
		v55 = lrotr(v9 - 165796510 + v45 + ((v54 ^ v52) & v48 ^ v52), 27);
		v56 = v55 + v54;
		v57 = lrotr(v23 - 1069501632 + v48 + ((v56 ^ v54) & v52 ^ v54), 23);
		v58 = v57 + v56;
		v59 = lrotr(v38 + 643717713 + v52 + ((v58 ^ v56) & v54 ^ v56), 18);
		v60 = v59 + v58;

		v61 = lrotr(((v60 ^ v58) & v56 ^ v58) + v6 - 373897302 + v54, 12);
		v62 = v61 + v60;
		v63 = lrotr(((v62 ^ v60) & v58 ^ v60) + v20 - 701558691 + v56, 27);
		v64 = v63 + v62;
		v65 = lrotr(((v64 ^ v62) & v60 ^ v62) + v35 + 38016083 + v58, 23);
		v66 = v65 + v64;
		v67 = lrotr(((v66 ^ v64) & v62 ^ v64) + v50 - 660478335 + v60, 18);
		v68 = v67 + v66;
		v69 = lrotr(((v68 ^ v66) & v64 ^ v66) + v17 - 405537848 + v62, 12);
		v70 = v69 + v68;
		v71 = lrotr(((v70 ^ v68) & v66 ^ v68) + v32 + 568446438 + v64, 27);
		v72 = v71 + v70;
		v73 = lrotr(((v72 ^ v70) & v68 ^ v70) + v47 - 1019803690 + v66, 23);
		v74 = v73 + v72;
		v75 = lrotr(((v74 ^ v72) & v70 ^ v72) + v15 - 187363961 + v68, 18);
		v76 = v75 + v74;
		v77 = lrotr(((v76 ^ v74) & v72 ^ v74) + v29 + 1163531501 + v70, 12);
		v78 = v77 + v76;
		v79 = lrotr(((v78 ^ v76) & v74 ^ v76) + v44 - 1444681467 + v72, 27);
		v80 = v79 + v78;
		v81 = lrotr(v74 + v12 - 51403784 + (((v79 + v78) ^ v78) & v76 ^ v78),
				23);
		v82 = v81 + v79 + v78;
		v83 = lrotr(v76 + v26 + 1735328473
				+ ((v82 ^ (v79 + v78)) & v78 ^ (v79 + v78)), 18);
		v84 = v83 + v82;
		v85 = lrotr(v78 + v41 - 1926607734 + ((v79 + v78) & (v84 ^ v82) ^ v82),
				12);
		v86 = v85 + v84;
		v87 = lrotr(v80 + v20 - 378558 + (v84 ^ v82 ^ v86), 28);
		v88 = v87 + v86;
		v89 = lrotr(v29 - 2022574463 + v82 + (v86 ^ v84 ^ v88), 21);
		v90 = v89 + v88;
		v91 = lrotr(v38 + 1839030562 + v84 + (v88 ^ v86 ^ v90), 16);
		v92 = v91 + v90;
		v93 = lrotr((v90 ^ v88 ^ v92) + v47 - 35309556 + v86, 9);
		v94 = v93 + v92;
		v95 = lrotr((v92 ^ v90 ^ v94) + v9 - 1530992060 + v88, 28);
		v96 = v95 + v94;
		v97 = lrotr((v94 ^ v92 ^ v96) + v17 + 1272893353 + v90, 21);
		v98 = v97 + v96;
		v99 = lrotr((v96 ^ v94 ^ v98) + v26 - 155497632 + v92, 16);
		v100 = v99 + v98;
		v101 = lrotr((v98 ^ v96 ^ v100) + v35 - 1094730640 + v94, 9);
		v102 = v101 + v100;
		v103 = lrotr((v100 ^ v98 ^ v102) + v44 + 681279174 + v96, 28);
		v104 = v103 + v102;
		v105 = lrotr((v102 ^ v100 ^ v104) + v6 - 358537222 + v98, 21);
		v106 = v105 + v104;
		v107 = lrotr((v104 ^ v102 ^ v106) + v15 - 722521979 + v100, 16);
		v108 = v107 + v106;
		v109 = lrotr((v106 ^ v104 ^ v108) + v23 + 76029189 + v102, 9);
		v110 = v109 + v108;
		v111 = lrotr((v108 ^ v106 ^ v110) + v32 - 640364487 + v104, 28);
		v112 = v111 + v110;
		v113 = lrotr(v106 + v41 - 421815835 + (v110 ^ v108 ^ v112), 21);
		v114 = v113 + v112;
		v115 = lrotr(v108 + v50 + 530742520 + (v112 ^ v110 ^ v114), 16);
		v116 = v115 + v114;
		v117 = lrotr(v12 - 995338651 + v110 + (v114 ^ v112 ^ v116), 9);
		v118 = v117 + v116;
		v119 = lrotr(v6 - 198630844 + v112 + ((~v114 | v118) ^ v116), 26);
		v120 = v119 + v118;
		v121 = lrotr(v26 + 1126891415 + v114 + ((~v116 | v120) ^ v118), 22);
		v122 = v121 + v120;
		v123 = lrotr(v47 - 1416354905 + v116 + ((~v118 | v122) ^ v120), 17);
		v124 = v123 + v122;
		v125 = lrotr(v118 + v20 - 57434055 + ((~v120 | v124) ^ v122), 11);
		v126 = v125 + v124;
		v127 = lrotr(v41 + 1700485571 + v120 + ((~v122 | v126) ^ v124), 26);
		v128 = v127 + v126;
		v129 = lrotr(v15 - 1894986606 + v122 + ((~v124 | v128) ^ v126), 22);
		v130 = v129 + v128;
		v131 = lrotr(v35 - 1051523 + v124 + ((~v126 | v130) ^ v128), 17);
		v132 = v131 + v130;
		v133 = lrotr(v9 - 2054922799 + v126 + ((~v128 | v132) ^ v130), 11);
		v134 = v133 + v132;
		v135 = lrotr(v29 + 1873313359 + v128 + ((~v130 | v134) ^ v132), 26);
		v136 = v135 + v134;
		v137 = lrotr(v50 - 30611744 + v130 + ((~v132 | v136) ^ v134), 22);
		v138 = v137 + v136;
		v139 = lrotr(v23 - 1560198380 + v132 + ((~v134 | v138) ^ v136), 17);
		v140 = v139 + v138;
		v141 = lrotr(v44 + 1309151649 + v134 + ((~v136 | v140) ^ v138), 11);
		v142 = v141 + v140;
		v143 = lrotr(v17 - 145523070 + v136 + ((~v138 | v142) ^ v140), 26);
		v144 = v143 + v142;
		v145 = lrotr(v38 - 1120210379 + v138 + ((~v140 | v144) ^ v142), 22);
		v146 = v145 + v144;
		v147 = lrotr(v12 + 718787259 + v140 + ((~v142 | v146) ^ v144), 17);
		v148 = v147 + v146;

		v5 = v144 + v5;
		v149 = lrotr(v32 - 343485551 + v142 + ((~v144 | v148) ^ v146), 11);
		v4 += v148 + v149;
		v2 += v148;
		v1 += v146;
       
		
		byte[] result =byteMerger(intChangeToByteArray(v5),intChangeToByteArray(v4));
	    result =byteMerger(result,intChangeToByteArray(v2));
	    result =byteMerger(result,intChangeToByteArray(v1));
		//System.out.println("before Base64 result:" + result);
		return  new String(Base64.encode(result));
	}

	private static byte[] intChangeToByteArray(int value){
		//System.out.println("intChangeToByteArray in value:" + value);
		byte [] a = new byte[4];
		a[3] = (byte) ((value >> 24) & 0xff);
		//System.out.println("intChangeToByteArray out a[3]:" + a[3]);
		a[2] = (byte) ((value >> 16) & 0xff);
		//System.out.println("intChangeToByteArray out a[2]:" + a[2]);
		a[1] = (byte) ((value >> 8) & 0xff);
		//System.out.println("intChangeToByteArray out a[1]:" + a[1]);
		a[0] = (byte) ((value) & 0xff);
		//System.out.println("intChangeToByteArray out a[0]:" + a[0]);
		//System.out.println("intChangeToByteArray out result:" + a);
		return a;
	}
	
	
	private static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		//System.out.println("byteMerger in byte_1:" + byte_1.toString() + "byte_2:" + byte_2.toString());
		byte[] byte_3 = new byte[byte_1.length + byte_2.length];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
		//for(int i = 0; i < byte_3.length; i++)
		//{
			//System.out.println("byteMerger out byte_3[:" + i +"]" +  byte_3[i]);
		//}
		//System.out.println("byteMerger out byte_3:" + byte_3);
		return byte_3;
	}

	private static int lrotr(int signed, int shift) {
		long unsigned = ((long) signed) & 0xffffffffL;
		long right = unsigned >> shift;
		long left = unsigned << (32 - shift);
		long temp = left | right;
		return (int) temp;
	}
//	System.out.println("lrotr signed:" + signed);
//	System.out.println("lrotr shift:" + shift);
//	System.out.println("lrotr long signed:" + (long)signed);
//	System.out.println("lrotr long unsigned:" + unsigned);
//	System.out.println("lrotr long right:" + right);
//	System.out.println("lrotr long left:" + left);
//	System.out.println("lrotr long result:" + temp);
//	System.out.println("lrotr result:" + (int)temp);

	private static int[] getIntArrayFromString(String value) {
		int intArray[] = new int[value.length() / 4];
		int begin = 0;
		int end = 4;
		for (int i = 0; i < value.length(); i = i + 4) {
			Integer temp = Integer.valueOf(
					stringToFourByteHexString(value.substring(begin, end)), 16);
			intArray[i / 4] = temp.intValue();
			//System.out.println("getIntArrayFromString intArray[" + (i / 4) + "]:" + intArray[i / 4]);
			end += 4;
			begin += 4;
		}
		return intArray;
	}

	private static String stringToFourByteHexString(String str) {
		//System.out.println("stringToFourByteHexString str:" + str);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			int ch = (int) str.charAt(i);
			String s4 = Integer.toHexString(ch);
		//	System.out.println("stringToFourByteHexString s4:" + s4);
			stringBuilder.append(s4);
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
//		String cid = "45010053454d3038471c05efa8e1b191";  // /dNsps01ui7/awS3mYXcqQ==
//		String cid= "45010053454d31364790252660b8b0d2";  //  PB3VVCR2w8fiiCsZE50jIA==
		String cid = "11d2735b04c94a0fa24a4267c31fc1d8"; 
		System.out.println(getBase64String(cid));
	}
}
