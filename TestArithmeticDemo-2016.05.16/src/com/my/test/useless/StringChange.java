package com.my.test.useless;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class StringChange {
	/**
	 * 作用传入一个cid的字符串，通过一系列的循环右移操作得到一个新字符串， 最后将新得到的字符串进行base64加密输出
	 * 
	 * @param cid
	 * @return
	 */
	public static String getBase64String(String cid) {
		int v1;
		int v2;
		int v4;
		int v5;
		int v6;
		int v7;
		int v8;
		int v9;
		int v10;
		int v11;
		int v12;
		int v13;
		int v14;
		int v15;
		int v16;
		int v17;
		int v18;
		int v19;
		int v20;
		int v21;
		int v22;
		int v23;
		int v24;
		int v25;
		int v26;
		int v27;
		int v28;
		int v29;
		int v30;
		int v31;
		int v32;
		int v33;
		int v34;
		int v35;
		int v36;
		int v37;
		int v38;
		int v39;
		int v40;
		int v41;
		int v42;
		int v43;
		int v44;
		int v45;
		int v46;
		int v47;
		int v48;
		int v49;
		int v50;
		int v51;
		int v52;
		int v53;
		int v54;
		int v55;
		int v56;
		int v57;
		int v58;
		int v59;
		int v60;
		int v61;
		int v62;
		int v63;
		int v64;
		int v65;
		int v66;
		int v67;
		int v68;
		int v69;
		int v70;
		int v71;
		int v72;
		int v73;
		int v74;
		int v75;
		int v76;
		int v77;
		int v78;
		int v79;
		int v80;
		int v81;
		int v82;
		int v83;
		int v84;
		int v85;
		int v86;
		int v87;
		int v88;
		int v89;
		int v90;
		int v91;
		int v92;
		int v93;
		int v94;
		int v95;
		int v96;
		int v97;
		int v98;
		int v99;
		int v100;
		int v101;
		int v102;
		int v103;
		int v104;
		int v105;
		int v106;
		int v107;
		int v108;
		int v109;
		int v110;
		int v111;
		int v112;
		int v113;
		int v114;
		int v115;
		int v116;
		int v117;
		int v118;
		int v119;
		int v120;
		int v121;
		int v122;
		int v123;
		int v124;
		int v125;
		int v126;
		int v127;
		int v128;
		int v129;
		int v130;
		int v131;
		int v132;
		int v133;
		int v134;
		int v135;
		int v136;
		int v137;
		int v138;
		int v139;
		int v140;
		int v141;
		int v142;
		int v143;
		int v144;
		int v145;
		int v146;
		int v147;
		int v148;
		int v149;

		v1 = 0x10325476;
		v2 = 0x98BADCFE;
		v4 = 0xEFCDAB89;
		v5 = 0x67452301;
		v6 = 0x31303534;
		if (cid == null || "".equals(cid))
			return null;
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

		byte[] result = byteMerger(intChangeToByteArray(v5),
				intChangeToByteArray(v4));
		result = byteMerger(result, intChangeToByteArray(v2));
		result = byteMerger(result, intChangeToByteArray(v1));
		return new String(Base64.encode(result));
	}

	private static byte[] intChangeToByteArray(int value) {
		byte[] a = new byte[4];
		a[3] = (byte) ((value >> 24) & 0xff);
		a[2] = (byte) ((value >> 16) & 0xff);
		a[1] = (byte) ((value >> 8) & 0xff);
		a[0] = (byte) ((value) & 0xff);
		return a;
	}

	private static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		byte[] byte_3 = new byte[byte_1.length + byte_2.length];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
		return byte_3;
	}

	private static int lrotr(int signed, int shift) {
		long unsigned = Integer.toUnsignedLong(signed);
		long right = unsigned >> shift;
		long left = unsigned << (32 - shift);
		long temp = left | right;
		return (int) temp;
	}

	private static int[] getIntArrayFromString(String value) {
		int intArray[] = new int[value.length() / 4];
		int begin = 0;
		int end = 4;
		for (int i = 0; i < value.length(); i = i + 4) {
			Integer temp = Integer.valueOf(
					stringToFourByteHexString(value.substring(begin, end)), 16);
			intArray[i / 4] = temp.intValue();
			end += 4;
			begin += 4;
		}
		return intArray;
	}

	private static String stringToFourByteHexString(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			int ch = (int) str.charAt(i);
			String s4 = Integer.toHexString(ch);
			stringBuilder.append(s4);
		}
		return stringBuilder.toString();
	}

	/**
	 * 传入两个参数，其中一个为Key，从1024空间中查找数据作运算
	 * 
	 * @param key
	 * @param inputString
	 * @return
	 */
	public static String getNewStringByKey(String key, String inputString) {
		if (key == null || inputString == null) {
			return null;
		}
		StringBuilder stringBuilderKey = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			stringBuilderKey.append(key);
		}
		String tempKeyStr = stringBuilderKey.toString();
		byte[] tempByte = new byte[1024];
		for (int i = 0; i < 1024; i = i + 4) {
			tempByte[i] = (byte) (i / 4);
		}
		int byte_1, byte_2, result, keep = 0, temp;
		// 通过key的值来初始化1K的空间值
		for (int i = 0; i < 256; i++) {
			byte_1 = tempKeyStr.charAt(i);
			byte_2 = tempByte[i * 4];
			result = (byte_1 + keep + byte_2) & 0xff;
			keep = result;
			tempByte[4 * i] = tempByte[4 * result];
			tempByte[4 * result] = (byte) byte_2;
		}
		int v107 = 0, v68, v71, v86 = 0, v87 = 0, v26;
		boolean v27;
		byte[] output = new byte[125];
		for (int i = 0; i < 125; i++) {
			v71 = v86 + 1;
			byte_1 = tempByte[v71 * 4];
			v86++;
			v87 = (v87 + byte_1) & 0xff;
			v71 *= 4;
			tempByte[v71] = tempByte[v87 * 4];
			tempByte[v87 * 4] = (byte) byte_1;
			temp = (((byte_1 & 0xff) + tempByte[v71]) & 0xff) * 4;
			v107 = tempByte[temp];
			output[i] = (byte) (inputString.charAt(i) ^ v107);
			v68 = output[i];
			v26 = output[i];
			v27 = ((v26 - 32) & 0xFF) > 0x5E
					|| Integer.toUnsignedLong((v26 - 96)) <= 0;
			if (v27) {
				v68 = (v68 ^ v107) & 0xff;
				output[i] = (byte) v68;
			}
		}
		return new String(output);
	}

	public static void main(String[] args) {
		String key = "aZ8RyZRWxcJno2cBcwQDAHYjmZoOC5Gi";
		String inputString = new String(
				"863077028536351460000640798962PB3VVCR2w8fiiCsZE50jIA==779497899514471120150826103350p0000000000002tDpNyvxuE/hYVk+jyt60/XCNRg=");
		System.out.println(StringChange.getNewStringByKey(key, inputString));
        System.out.println("\n\n\n");
		String cid = "45010053454d3038471c05efa8e1b191"; //     /dNsps01ui7/awS3mYXcqQ==
		// String cid= "45010053454d31364790252660b8b0d2"; //   PB3VVCR2w8fiiCsZE50jIA==
		System.out.println(getBase64String(cid));
	}

}
