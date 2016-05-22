package com.my.test.useless;

public class Sub_5085C_old {

	private static int __ROR4__(int signed, int shift) {
		long unsigned = Integer.toUnsignedLong(signed);
		long right = unsigned >> shift;
		long left = unsigned << (32 - shift);
		long temp = left | right;
		return (int) temp;
	}

	private static int bytesToIn(char[] src, int offset) {
		return (int) ((src[offset] & 0xFF) | ((src[offset + 1] & 0xFF) << 8)
				| ((src[offset + 2] & 0xFF) << 16) | ((src[offset + 3] & 0xFF) << 24));
	}

	private static char[] intDataPutIntoByteArray(char[] src, int value,
			int offset) {
		char[] a = new char[4];
		a[3] = (char) ((value >> 24) & 0xff);
		a[2] = (char) ((value >> 16) & 0xff);
		a[1] = (char) ((value >> 8) & 0xff);
		a[0] = (char) ((value) & 0xff);
		for (int i = 0; i < 4; i++) {
			src[offset + i] = a[i];
		}
		return src;
	}
	
/**
 * reversedOrder: 作用 ：逆序输出数据
 * @param data
 * @return
 */
	private static int reversedOrder(int data) {
		int v1; 
		int v2; 
		int v3; 
		v2 = __ROR4__(data, 24);
		v1 = v2;
		v3 = __ROR4__(data, 8);
		return v1 & 0xFF00FF | v3 & 0xFF00FF00;
	}

	private static int resultOutPrint(char[] out, int length) {
		for (int i = 0, k = 0; i < length - 1; i = i + 4, k++) {
			Integer integer = new Integer(bytesToIn(out, 4 * k));
			System.out.format("0x%x\n", new Object[] { integer });
		}
		return 1;
	}

	public static char[] sub_5085C(char[] inputs) {
		char[] result = new char[20];
		char[] temp = new char[132];
		char[] resultTemp = new char[92];
		int v4 = bytesToIn(inputs, 20);
		int v13 = reversedOrder(v4);
		int v5 = reversedOrder(bytesToIn(inputs, 24));
		int v6 = (v4 >> 3) & 0x3F;
		int v7;
		if (v6 > 55)
			v7 = 120 - v6;
		else
			v7 = 56 - v6;
		temp[0] = (char) -128;
		sub_50764(temp, v7, inputs, 0);
		intDataPutIntoByteArray(temp, v5, 0);
		intDataPutIntoByteArray(temp, v13, 4);
		for (int i = 0; i < 92; i++) {
			temp[40 + i] = inputs[i];
		}
		sub_50764(temp, 8, temp, 40);
		for (int i = 0; i < 92; i++) {
			resultTemp[i] = temp[40 + i];
		}
		intDataPutIntoByteArray(result,
				reversedOrder(bytesToIn(resultTemp, 0)), 0);
		intDataPutIntoByteArray(result,
				reversedOrder(bytesToIn(resultTemp, 4)), 4);
		intDataPutIntoByteArray(result,
				reversedOrder(bytesToIn(resultTemp, 8)), 8);
		intDataPutIntoByteArray(result,
				reversedOrder(bytesToIn(resultTemp, 12)), 12);
		intDataPutIntoByteArray(result,
				reversedOrder(bytesToIn(resultTemp, 16)), 16);
		resultTemp = null;
		temp = null;
		return result;
	}

	private static int sub_50764(char[] a1, int a2, char[] a3, int k) {
		char[] v3; 
		int v4; 
		int v5; 
		int v6; 
		int v7; 
		boolean v8;
		int v9; 
		int v10; 
		int v11; 
		char[] v12; 
		int v13; 
		char[] v14; 
		int v15; 
		char v16; 
		char[] v17; 
		char[] v18; 
		char[] v19; 
		char[] v20; 
		char[] v21;
		int v22; 
		int v23; 
		char v24; 
		char[] v25; 

		v3 = a3;
		v4 = bytesToIn(a3, 20 + k);
		v5 = a2;
		v6 = 8 * a2;
		v7 = v6 + v4;
		v8 = v6 + v4 >= v6;
		intDataPutIntoByteArray(v3, v6 + v4, 20 + k);
		if (v6 + v4 < v6)
			v7 = bytesToIn(a3, 24 + k);
		v9 = v4 >> 3;
		if (!v8) {
			intDataPutIntoByteArray(v3, v7 + 1, 24 + k);
		}
		v10 = v9 & 0x3F;
		v11 = 64 - v10;
		int t = bytesToIn(a3, 24 + k) + (v5 >> 29);
		intDataPutIntoByteArray(v3, t, 24 + k);
		v12 = a1;
		if (v5 >= 64 - v10) {
			v14 = v3; // v14 = v3+v10; // v
			v15 = 0;
			while (true) {
				v17 = v14; // v17 = v14 + v15;
				if (v15 >= v11)
					break;
				v16 = v12[v15];
				v17[28 + v15 + k + v10] = v16; // *(v17 + 28) = v16;
				v15++;
			}
			v13 = v11;
			sub_4F1B0(v3, 28 + k, v3);
			v18 = v12; // v18 =v12 + v11;
			int i = 0;
			while (true) {
				v19 = v18;
				i += 64;
				if (v13 >= (v5 - 63))
					break;
				sub_4F1B0(v3, v11 + i, v19);
				v13 += 64;
			}
			v10 = 0;
		} else {
			v13 = 0;
		}
		v20 = v12; // + v13;
		v21 = v3; // + v10;
		v22 = v5 - v13;
		v23 = 0;
		while (true) {
			v25 = v21; // + v23; +v10
			if (v23 >= v22)
				break;
			v24 = v20[v13 + v23];
			v25[v23 + 28 + v10] = v24;
			v23++;
		}
		return 0;
	}

	public static void main(String[] args) {
	char a1[] = { 0x61, 0x38, 0x63, 0x35, 0x30, 9, 0x15, 0xCA, 0xFC, 0x6B,
				0x20, 0xB5, 0x3A, 0x1C, 0xA9, 0xC6, 0x23, 0xF, 0xC1, 0x27,
				0x90, 8, 0, 0, 0, 0, 0, 0, 0x33, 0x30, 0x33, 0x30, 0x33, 0x30,
				0x33, 0x30, 0x33, 0x30, 0x33, 0x30, 0x33, 0x30, 0x33, 0x30,
				0x33, 0x30, 0x33, 0x36, 0x33, 0x33, 0x33, 0x30, 0x33, 0x37,
				0x33, 0x37, 0x33, 0x30, 0x33, 0x32, 0x33, 0x38, 0x33, 0x35,
				0x33, 0x33, 0x33, 0x36, 0x33, 0x33, 0x33, 0x35, 0x33, 0x31,
				0x33, 0x34, 0x33, 0x36, 0x33, 0x30, 0x33, 0x30, 0x33, 0x30,
				0x33, 0x31, 0x33, 0x30, 0x33, 0x31, 0x33, 0x34 };
		char[] result = sub_5085C(a1);
		resultOutPrint(result, 20);	
		System.out.println("\n");
	}
	
	
	
	
	
	

	private static char[] sub_4F1B0(char[] result, int a2, char[] a3) {
		char[] v2; 
		int v3; 
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
		int v150; 
		int v151; 
		int v152; 
		int v153; 
		int v154; 
		int v155; 
		int v156; 
		int v157; 
		int v158; 
		int v159; 
		int v160; 
		int v161; 
		int v162; 
		int v163; 
		int v164; 
		int v165; 
		int v166; 
		int v167; 
		int v168; 
		int v169; 
		int v170; 
		int v171; 
		int v172; 
		int v173; 
		int v174; 
		int v175; 
		int v176; 
		int v177; 
		int v178; 
		int v179; 
		int v180; 
		int v181; 
		int v182; 
		int v183; 
		int v184; 
		int v185; 
		int v186; 
		int v187; 
		int v188; 
		int v189; 
		int v190; 
		int v191; 
		int v192; 
		int v193; 
		int v194; 
		int v195; 
		int v196; 
		int v197; 
		int v198; 
		int v199; 
		int v200; 
		int v201; 
		int v202; 
		int v203; 
		int v204; 
		int v205; 
		int v206; 
		int v207; 
		int v208; 
		int v209; 
		int v210; 
		int v211; 
		int v212; 
		int v213; 
		int v214; 
		int v215; 
		int v216; 
		int v217; 
		int v218; 
		int v219; 
		int v220; 
		int v221; 
		int v222; 
		int v223; 
		int v224; 
		int v225; 
		int v226; 
		int v227; 
		int v228; 
		int v229; 
		int v230; 
		int v231; 
		int v232; 
		int v233; 
		int v234; 
		int v235; 
		int v236; 
		int v237; 
		int v238; 
		int v239; 
		int v240; 
		int v241; 
		int v242; 
		int v243; 
		int v244; 
		int v245; 
		int v246; 
		int v247; 
		int v248; 
		int v249; 
		int v250; 
		int v251; 
		int v252; 
		int v253; 
		int v254; 
		int v255; 
		int v256; 
		int v257; 
		int v258; 
		int v259; 
		int v260; 
		int v261; 
		int v262; 
		int v263; 
		int v264; 
		int v265; 
		int v266; 
		int v267; 
		int v268; 
		int v269; 
		int v270; 
		int v271; 
		int v272; 
		int v273; 
		int v274; 
		int v275; 
		int v276; 
		int v277; 
		int v278; 
		int v279; 
		int v280; 
		int v281; 
		int v282; 
		int v283; 
		int v284; 
		int v285; 
		int v286; 
		int v287; 
		int v288; 
		int v289; 
		int v290; 
		int v291; 
		int v292; 
		int v293; 
		int v294; 
		int v295; 
		int v296; 
		int v297; 
		int v298; 
		int v299; 
		int v300; 
		int v301; 
		int v302; 
		int v303; 
		int v304; 
		int v305; 
		int v306; 
		int v307; 
		int v308; 
		int v309; 
		int v310; 
		int v311; 
		int v312; 
		int v313; 
		int v314; 
		int v315; 
		int v316; 
		int v317; 
		int v318; 
		int v319; 
		int v320; 
		int v321; 
		int v322; 
		int v323; 
		int v324; 
		int v325; 
		int v326; 
		int v327; 
		int v328; 
		int v329; 
		int v330; 
		int v331; 
		int v332; 
		int v333; 
		int v334; 
		int v335; 
		int v336; 
		int v337; 
		int v338; 
		int v339; 
		int v340; 
		int v341; 
		int v342; 
		int v343; 
		int v344; 
		int v345; 
		int v346; 
		int v347; 
		int v348; 
		int v349; 
		int v350; 
		int v351; 
		int v352; 
		int v353; 
		int v354; 
		int v355; 
		int v356; 
		int v357; 
		int v358; 
		int v359; 
		int v360; 
		int v361; 
		int v362; 
		int v363; 
		int v364; 
		int v365; 
		int v366; 
		int v367; 
		int v368; 
		int v369; 
		int v370; 
		int v371; 
		int v372; 
		int v373; 
		int v374; 
		int v375; 
		int v376; 
		int v377; 
		int v378; 
		int v379; 
		int v380; 
		int v381; 
		int v382; 
		int v383; 
		int v384; 
		int v385; 
		int v386; 
		int v387; 
		int v388; 
		int v389; 
		int v390; 
		int v391; 
		int v392; 
		int v393; 
		int v394; 
		int v395; 
		int v396; 
		int v397; 
		int v398; 
		int v399; 
		int v400; 
		int v401; 
		int v402; 
		int v403; 
		int v404; 
		int v405; 
		int v406; 
		int v407; 
		int v408; 
		int v409; 
		int v410; 
		int v411; 
		int v412; 
		int v413; 
		int v414; 
		int v415; 
		int v416; 
		int v417; 
		int v418; 
		int v419; 
		int v420; 
		int v421; 
		int v422; 
		int v423; 
		int v424; 
		int v425; 
		int v426; 
		int v427; 
		int v428; 
		int v429; 
		int v430; 
		int v431; 
		int v432; 
		int v433; 
		int v434; 
		int v435; 
		int v436; 
		int v437; 
		int v438; 
		int v439; 
		int v440; 
		int v441; 
		int v442; 
		int v443; 
		int v444; 
		int v445; 
		int v446; 
		int v447; 
		int v448; 
		int v449; 
		int v450; 
		int v451; 
		int v452; 
		int v453; 
		int v454; 
		int v455; 
		int v456; 
		int v457; 
		int v458; 
		int v459; 
		int v460; 
		int v461; 
		int v462; 
		int v463; 
		int v464; 
		int v465; 
		int v466; 
		int v467; 
		int v468; 
		int v469; 
		int v470; 
		int v471; 
		int v472; 
		int v473; 
		int v474; 
		int v475; 
		int v476; 
		int v477; 
		int v478; 
		int v479; 
		int v480; 
		int v481; 
		int v482; 
		int v483; 
		int v484; 
		int v485; 
		int v486; 
		int v487; 
		int v488; 
		int v489; 
		int v490; 
		int v491; 
		int v492; 
		int v493; 
		int v494; 
		int v495; 
		int v496; 
		int v497; 
		int v498; 
		int v499; 
		int v500; 
		int v501; 
		int v502; 
		int v503; 
		int v504; 
		int v505; 
		int v506; 
		int v507; 
		int v508; 
		int v509; 
		int v510; 
		int v511; 
		int v512; 
		int v513; 
		int v514; 
		int v515; 
		int v516; 
		int v517; 
		int v518; 
		int v519; 
		int v520; 
		int v521; 
		int v522; 
		int v523; 
		int v524; 
		int v525; 
		int v526; 
		int v527; 
		int v528; 
		int v529; 
		int v530; 
		int v531; 
		int v532; 
		int v533; 
		int v534; 
		int v535; 
		int v536; 
		int v537; 
		int v538; 
		int v539; 
		int v540; 
		int v541; 
		int v542; 
		int v543; 
		int v544; 
		int v545; 
		int v546; 
		int v547; 
		int v548; 
		int v549; 
		int v550; 
		int v551; 
		int v552; 
		int v553; 
		int v554; 
		int v555; 
		int v556; 
		int v557; 
		int v558; 
		int v559; 
		int v560; 
		int v561; 
		int v562; 
		int v563; 
		int v564; 
		int v565; 
		int v566; 
		int v567; 
		int v568; 
		int v569; 
		int v570; 
		int v571; 
		int v572; 
		int v573; 
		int v574; 
		int v575; 
		int v576; 
		int v577; 
		int v578; 
		int v579; 
		int v580; 
		int v581; 
		int v582; 
		int v583; 
		int v584; 
		int v585; 
		int v587; 
		int v588; 
		int v589; 
		int v590; 
		int v591; 
		char v592[]; 
		int v593; 
		int v594;
		int v595; 
		int v596; 
		int v597; 
		int v598; 
		int v599; 
		int v600; 
		int v601;
		int v602; 
		int v603; 
		int v604; 
		int v605; 
		int v606; 
		int v607; 

		v2 = a3;
		v3 = 0;
		v592 = new char[64];
		int i = 0;
		do {
			v4 = (result[v3 + a2] & 0x000000FF) << 24;
			intDataPutIntoByteArray(v592, v4, v3);
			v5 = v4 | ((v2[1 + i + a2] & 0x000000FF) << 16);
			intDataPutIntoByteArray(v592, v5, v3);
			v6 = v5 | ((v2[2 + i + a2] & 0x000000FF) << 8);
			intDataPutIntoByteArray(v592, v6, v3);
			v7 = (v2[3 + i + a2] & 0x000000FF);
			i += 4;
			intDataPutIntoByteArray(v592, v6 | v7, v3);
			v3 += 4;
		} while (v3 != 64);
		v593 = bytesToIn(v592, 4);
		v594 = bytesToIn(v592, 8);
		v595 = bytesToIn(v592, 12);
		v596 = bytesToIn(v592, 16); // 0x33308000

		v597 = bytesToIn(v592, 20);
		v598 = bytesToIn(v592, 24);
		v599 = bytesToIn(v592, 28);
		v600 = bytesToIn(v592, 32);
		v601 = bytesToIn(v592, 36);
		v602 = bytesToIn(v592, 40);
		v603 = bytesToIn(v592, 44);
		v604 = bytesToIn(v592, 48);
		v605 = bytesToIn(v592, 52);
		v606 = bytesToIn(v592, 56);
		v607 = bytesToIn(v592, 60);

		v8 = bytesToIn(result, 8 + a2 - 28);
		v9 = bytesToIn(result, 12 + a2 - 28);
		v10 = bytesToIn(result, 4 + a2 - 28);

		v12 = __ROR4__(v10, 2);
		v11 = v12;
		v13 = v12 ^ v8;
		int temp_result = bytesToIn(result, 0 + a2 - 28);
		v15 = __ROR4__(temp_result, 2);
		v14 = v15;
		v16 = __ROR4__(temp_result, 27);
		v17 = bytesToIn(v592, 0) + 1518500249 + bytesToIn(result, 16 + a2 - 28)
				+ v16 + ((v9 ^ v8) & v10 ^ v9);
		v19 = __ROR4__(v17, 27);
		v18 = v593 + 1518500249 + v9
				+ (v13 & bytesToIn(result, 0 + a2 - 28) ^ v8) + v19;
		v21 = __ROR4__(v17, 2);
		v20 = v21;

		v22 = v17 & (v11 ^ v14) ^ v11;
		v23 = v21 ^ v14;
		v24 = v594 + 1518500249 + v8 + v22;
		v26 = __ROR4__(v18, 2);
		v25 = v26;
		v28 = __ROR4__(v18, 27);
		v27 = v24 + v28;
		v29 = v595 + 1518500249 + v11 + (v23 & v18 ^ v14);
		v31 = __ROR4__(v27, 2);
		v30 = v31;

		v33 = __ROR4__(v27, 27);
		v32 = v29 + v33;

		v34 = v596 + 1518500249 + v14 + ((v25 ^ v20) & v27 ^ v20);
		v36 = __ROR4__(v32, 2);
		v35 = v36;
		v38 = __ROR4__(v32, 27);
		v37 = v34 + v38; // 0x92900e7a
		v40 = __ROR4__(v37, 27);

		v39 = v597 + 1518500249 + v20 + ((v30 ^ v25) & v32 ^ v25) + v40;
		v42 = __ROR4__(v37, 2);
		v41 = v42;
		v43 = (v35 ^ v30) & v37 ^ v30;
		v44 = v42 ^ v35;
		v45 = v598 + 1518500249 + v25 + v43;
		v47 = __ROR4__(v39, 2);
		v46 = v47;
		v49 = __ROR4__(v39, 27);
		v48 = v45 + v49;
		v50 = (v46 ^ v41) & v48 ^ v41;
		v52 = __ROR4__(v48, 27);
		v51 = v599 + 1518500249 + v30 + (v44 & v39 ^ v35) + v52;
		v54 = __ROR4__(v48, 2);
		v53 = v54;
		v55 = v54 ^ v46;
		v56 = v600 + 1518500249 + v35 + v50;
		v58 = __ROR4__(v51, 2);
		v57 = v58;

		v60 = __ROR4__(v51, 27);
		v59 = v56 + v60;
		v61 = v601 + 1518500249 + v41 + (v55 & v51 ^ v46);
		v63 = __ROR4__(v59, 2);
		v62 = v63;
		v65 = __ROR4__(v59, 27);
		v64 = v61 + v65;
		v66 = v602 + 1518500249 + v46 + ((v57 ^ v53) & v59 ^ v53);
		v68 = __ROR4__(v64, 2);
		v67 = v68;
		v70 = __ROR4__(v64, 27);
		v69 = v66 + v70;
		v72 = __ROR4__(v69, 27);
		v71 = v603 + 1518500249 + v53 + ((v62 ^ v57) & v64 ^ v57) + v72;
		v74 = __ROR4__(v69, 2);
		v73 = v74;
		v75 = v74 ^ v67;
		v76 = v604 + 1518500249 + v57 + ((v67 ^ v62) & v69 ^ v62);
		v78 = __ROR4__(v71, 2);
		v77 = v78;
		v80 = __ROR4__(v71, 27);
		v79 = v76 + v80;
		v82 = __ROR4__(v79, 27);
		v81 = v605 + 1518500249 + v62 + (v75 & v71 ^ v67) + v82;
		v84 = __ROR4__(v79, 2);
		v83 = v84;
		v85 = v606 + 1518500249 + v67 + ((v77 ^ v73) & v79 ^ v73);
		v86 = (v84 ^ v77) & v81;
		v87 = __ROR4__(v594 ^ bytesToIn(v592, 0) ^ v600 ^ v605, 31);
		v88 = v87;
		v90 = __ROR4__(v81, 2);
		v89 = v90;
		v92 = __ROR4__(v81, 27);
		v91 = v85 + v92;
		v93 = __ROR4__(v595 ^ v593 ^ v601 ^ v606, 31);

		v94 = v93;
		v96 = __ROR4__(v91, 2);
		v95 = v96;
		v98 = __ROR4__(v91, 27);
		v97 = v607 + 1518500249 + v73 + (v86 ^ v77) + v98;
		v99 = __ROR4__(v596 ^ v594 ^ v602 ^ v607, 31);
		v100 = v99;
		v102 = __ROR4__(v97, 2);
		v101 = v102; // 0x8ad7b31f
		v103 = (v95 ^ v89) & v97 ^ v89;
		v105 = __ROR4__(v97, 27);
		v104 = v88 + 1518500249 + v77 + ((v89 ^ v83) & v91 ^ v83) + v105;
		v107 = __ROR4__(v104, 2);
		v106 = v107;
		v108 = (v101 ^ v95) & v104;
		v110 = __ROR4__(v104, 27);
		v109 = v94 + 1518500249 + v83 + v103 + v110;
		v111 = __ROR4__(v597 ^ v595 ^ v603 ^ v88, 31);
		v591 = v111;
		v112 = v100 + 1518500249 + v89 + (v108 ^ v95);
		v113 = v111 + 1518500249 + v95;
		v114 = __ROR4__(v598 ^ v596 ^ v604 ^ v94, 31);
		v115 = v114;
		v117 = __ROR4__(v109, 27);
		v116 = v112 + v117;
		v119 = __ROR4__(v109, 2);
		v118 = v119;
		v120 = __ROR4__(v599 ^ v597 ^ v605 ^ v100, 31);
		v121 = v120;
		v123 = __ROR4__(v116, 27);
		v122 = v113 + ((v106 ^ v101) & v109 ^ v101) + v123;
		v125 = __ROR4__(v116, 2);
		v124 = v125;
		v126 = v125 ^ v118;
		v128 = __ROR4__(v122, 27);
		v127 = v115 + 1859775393 + v101 + (v118 ^ v106 ^ v116) + v128;
		v129 = v121 + 1859775393 + v106;
		v131 = __ROR4__(v122, 2);
		v130 = v131;
		v133 = __ROR4__(v600 ^ v598 ^ v606 ^ v591, 31);
		v132 = v133;
		v134 = __ROR4__(v601 ^ v599 ^ v607 ^ v115, 31);
		v135 = v132;
		v136 = v134;
		v137 = v134;
		v139 = __ROR4__(v127, 27);
		v138 = v129 + (v126 ^ v122) + v139;
		v141 = __ROR4__(v127, 2);
		v140 = v141;
		v142 = __ROR4__(v602 ^ v600 ^ v88 ^ v121, 31);
		v143 = v142;
		v145 = __ROR4__(v138, 27);
		v144 = v132 + 1859775393 + v118 + (v130 ^ v124 ^ v127) + v145;
		v147 = __ROR4__(v138, 2);
		v146 = v147;
		v148 = v137 + 1859775393 + v124 + (v140 ^ v130 ^ v138);
		v149 = v147 ^ v140;
		v151 = __ROR4__(v144, 27);
		v150 = v148 + v151;
		v152 = v143 + 1859775393 + v130;
		v154 = __ROR4__(v144, 2);
		v153 = v154;
		v155 = __ROR4__(v603 ^ v601 ^ v94 ^ v135, 31);
		v156 = v155;
		v157 = v155 + 1859775393;
		v158 = v152 + (v149 ^ v144);
		v160 = __ROR4__(v150, 2);
		v159 = v160;
		v162 = __ROR4__(v150, 27);
		v161 = v158 + v162;
		v163 = __ROR4__(v604 ^ v602 ^ v100 ^ v136, 31);
		v164 = v163;
		v165 = v163 + 1859775393;
		v166 = __ROR4__(v605 ^ v603 ^ v591 ^ v143, 31);
		v167 = v166;
		v168 = v166;
		v170 = __ROR4__(v161, 27);
		v169 = v157 + v140 + (v153 ^ v146 ^ v150) + v170;
		v171 = v165 + v146;
		v173 = __ROR4__(v161, 2);
		v172 = v173;
		v174 = v171 + (v159 ^ v153 ^ v161);
		v175 = v168 + 1859775393 + v153;
		v176 = v173 ^ v159;
		v177 = __ROR4__(v606 ^ v604 ^ v115 ^ v156, 31);
		v178 = v177;
		v179 = __ROR4__(v607 ^ v605 ^ v121 ^ v164, 31);
		v180 = v179;
		v182 = __ROR4__(v169, 2);
		v181 = v182;
		v184 = __ROR4__(v169, 27);
		v183 = v174 + v184;
		v186 = __ROR4__(v183, 27);
		v185 = v175 + (v176 ^ v169) + v186;
		v188 = __ROR4__(v183, 2);
		v187 = v188;
		v189 = __ROR4__(v88 ^ v606 ^ v135 ^ v167, 31);
		v190 = v189;
		v192 = __ROR4__(v185, 27);
		v191 = v178 + 1859775393 + v159 + (v181 ^ v172 ^ v183) + v192;
		v194 = __ROR4__(v185, 2);
		v193 = v194;
		v195 = v180 + 1859775393 + v172 + (v187 ^ v181 ^ v185);
		v196 = v100 ^ v88 ^ v143;
		v198 = __ROR4__(v94 ^ v607 ^ v136 ^ v178, 31);
		v197 = v198;
		v200 = __ROR4__(v191, 27);
		v199 = v195 + v200;
		v201 = v197;
		v202 = v190 + 1859775393 + v181;
		v204 = __ROR4__(v191, 2);
		v203 = v204;
		v205 = __ROR4__(v196 ^ v180, 31);
		v206 = v591 ^ v94;
		v207 = v205;
		v208 = v205;
		v210 = __ROR4__(v199, 27);
		v209 = v202 + (v193 ^ v187 ^ v191) + v210;
		v212 = __ROR4__(v199, 2);
		v211 = v212;
		v213 = v100;
		v214 = v197 + 1859775393 + v187 + (v203 ^ v193 ^ v199);
		v215 = v115 ^ v213 ^ v164;
		v216 = v208 + 1859775393 + v193 + (v212 ^ v203 ^ v209);
		v218 = __ROR4__(v206 ^ v156 ^ v190, 31);
		v217 = v218;
		v220 = __ROR4__(v209, 2);
		v219 = v220;
		v222 = __ROR4__(v209, 27);
		v221 = v214 + v222;
		v224 = __ROR4__(v214 + v222, 27);
		v223 = v216 + v224;
		v225 = v217 + 1859775393 + v203;
		v227 = __ROR4__(v221, 2);
		v226 = v227;
		v229 = __ROR4__(v215 ^ v201, 31);
		v228 = v229;
		v230 = __ROR4__(v121 ^ v591 ^ v167 ^ v207, 31);
		v231 = v228;
		v591 = v230;
		v233 = __ROR4__(v223, 27);
		v232 = v225 + (v219 ^ v211 ^ v221) + v233;
		v235 = __ROR4__(v223, 2);
		v234 = v235;
		v236 = v235 ^ v226 ^ v232;
		v237 = __ROR4__(v135 ^ v115 ^ v178 ^ v217, 31);
		v238 = v237;
		v240 = __ROR4__(v232, 2);
		v239 = v240;
		v242 = __ROR4__(v232, 27);
		v241 = v228 + 1859775393 + v211 + (v226 ^ v219 ^ v223) + v242;
		v243 = __ROR4__(v136 ^ v121 ^ v180 ^ v228, 31);
		v244 = v243;
		v246 = __ROR4__(v143 ^ v135 ^ v190 ^ v591, 31);
		v245 = v246;
		v248 = __ROR4__(v241, 2);
		v247 = v248;
		v250 = __ROR4__(v241, 27);
		v249 = v591 + 1859775393 + v219 + v236 + v250;
		v251 = v245;
		v253 = __ROR4__(v249, 27);
		v252 = v238 + 1859775393 + v226 + (v239 ^ v234 ^ v241) + v253;
		v255 = __ROR4__(v249, 2);
		v254 = v255;
		v256 = v255 ^ v247;
		v257 = __ROR4__(v156 ^ v136 ^ v201 ^ v238, 31);
		v258 = v257;
		v260 = __ROR4__(v252, 2);
		v259 = v260;
		v262 = __ROR4__(v252, 27);
		v261 = v244 + 1859775393 + v234 + (v247 ^ v239 ^ v249) + v262;
		v263 = __ROR4__(v164 ^ v143 ^ v207 ^ v244, 31);
		v264 = v263;
		v266 = __ROR4__(v261, 27);
		v265 = v245 + 1859775393 + v239 + (v256 ^ v252) + v266;
		v267 = v258 + 1859775393 + v247;
		v269 = __ROR4__(v261, 2);
		v268 = v269;
		v270 = v267 + (v259 ^ v254 ^ v261);
		v271 = v265 | v269;
		v273 = __ROR4__(v265, 27);
		v272 = v270 + v273;
		v275 = __ROR4__(v265, 2);
		v274 = v275;
		v276 = __ROR4__(v167 ^ v156 ^ v217 ^ v245, 31);
		v277 = v276;
		v278 = v276 - 1894007588 + v259 + ((v272 | v274) & v268 | v272 & v274);
		v279 = __ROR4__(v178 ^ v164 ^ v231 ^ v258, 31);
		v280 = v279;
		v282 = __ROR4__(v272, 27);
		v281 = v264 - 1894007588 + v254 + (v271 & v259 | v265 & v268) + v282;
		v284 = __ROR4__(v272, 2);
		v283 = v284;
		v285 = __ROR4__(v180 ^ v167 ^ v591 ^ v264, 31);
		v286 = v285;
		v288 = __ROR4__(v281, 27);
		v287 = v278 + v288;
		v290 = __ROR4__(v281, 2);
		v289 = v290;
		v291 = (v281 | v283) & v274 | v281 & v283;
		v292 = (v287 | v290) & v283 | v287 & v290;
		v293 = __ROR4__(v190 ^ v178 ^ v238 ^ v277, 31);
		v294 = v293;
		v296 = __ROR4__(v287, 27);
		v295 = v280 - 1894007588 + v268 + v291 + v296;
		v298 = __ROR4__(v287, 2);
		v297 = v298;
		v299 = v286 - 1894007588 + v274 + v292;
		v300 = v295 | v298;
		v302 = __ROR4__(v295, 27);
		v301 = v299 + v302;
		v304 = __ROR4__(v295, 2);
		v303 = v304;
		v305 = __ROR4__(v201 ^ v180 ^ v244 ^ v280, 31);
		v306 = v305;
		v307 = v294 - 1894007588 + v283 + (v300 & v289 | v295 & v297);
		v308 = v305;
		v310 = __ROR4__(v301, 27);
		v309 = v307 + v310;
		v312 = __ROR4__(v301, 2);
		v311 = v312;
		v313 = __ROR4__(v207 ^ v190 ^ v251 ^ v286, 31);
		v314 = v313;
		v315 = v313;
		v317 = __ROR4__(v309, 2);
		v316 = v317;
		v319 = __ROR4__(v309, 27);
		v318 = v308 - 1894007588 + v289 + ((v301 | v303) & v297 | v301 & v303)
				+ v319;
		v320 = __ROR4__(v217 ^ v201 ^ v258 ^ v294, 31);
		v321 = v320;
		v322 = v320 - 1894007588 + v303 + ((v318 | v316) & v311 | v318 & v316);
		v324 = __ROR4__(v318, 27);
		v323 = v315 - 1894007588 + v297 + ((v309 | v311) & v303 | v309 & v311)
				+ v324;
		v326 = __ROR4__(v318, 2);
		v325 = v326;
		v328 = __ROR4__(v231 ^ v207 ^ v264 ^ v306, 31);
		v327 = v328;
		v330 = __ROR4__(v323, 27);
		v329 = v322 + v330;
		v332 = __ROR4__(v323, 2);
		v331 = v332;
		v333 = __ROR4__(v591 ^ v217 ^ v277 ^ v314, 31);
		v334 = v327 - 1894007588 + v311;
		v335 = v333;
		v336 = v333 - 1894007588 + v316 + ((v329 | v331) & v325 | v329 & v331);
		v338 = __ROR4__(v329, 27);
		v337 = v334 + ((v323 | v325) & v316 | v323 & v325) + v338;
		v340 = __ROR4__(v329, 2);
		v339 = v340;
		v342 = __ROR4__(v238 ^ v231 ^ v280 ^ v321, 31);
		v341 = v342;
		v344 = __ROR4__(v244 ^ v591 ^ v286 ^ v327, 31);
		v343 = v344;
		v346 = __ROR4__(v337, 27);
		v345 = v336 + v346;
		v348 = __ROR4__(v337, 2);
		v347 = v348;
		v591 = v343;
		v349 = v341;
		v350 = v341 - 1894007588 + v325;
		v351 = (v337 | v339) & v331 | v337 & v339;
		v352 = v343 - 1894007588 + v331;
		v353 = (v345 | v348) & v339 | v345 & v348;
		v355 = __ROR4__(v251 ^ v238 ^ v294 ^ v335, 31);
		v354 = v355;
		v357 = __ROR4__(v345, 27);
		v356 = v350 + v351 + v357;
		v358 = v354;
		v360 = __ROR4__(v345, 2);
		v359 = v360;
		v361 = v354 - 1894007588;
		v362 = v356 | v360;
		v364 = __ROR4__(v356, 27);
		v363 = v352 + v353 + v364;
		v366 = __ROR4__(v356, 2);
		v365 = v366;
		v367 = v362 & v347 | v356 & v359;
		v368 = __ROR4__(v258 ^ v244 ^ v306 ^ v349, 31);
		v369 = v368;
		v370 = v368 - 1894007588 + v347;
		v371 = __ROR4__(v264 ^ v251 ^ v314 ^ v591, 31);
		v372 = v371;
		v373 = (v363 | v365) & v359 | v363 & v365;
		v375 = __ROR4__(v363, 27);
		v374 = v361 + v339 + v367 + v375;
		v377 = __ROR4__(v363, 2);
		v376 = v377;
		v378 = v374 | v377;
		v380 = __ROR4__(v374, 27);
		v379 = v370 + v373 + v380;
		v382 = __ROR4__(v374, 2);
		v381 = v382;
		v383 = __ROR4__(v277 ^ v258 ^ v321 ^ v358, 31);
		v384 = v383;
		v385 = v372 - 1894007588 + v359 + (v378 & v365 | v374 & v376);
		v386 = v383 - 1894007588 + v365;
		v387 = (v379 | v381) & v376 | v379 & v381;
		v389 = __ROR4__(v379, 27);
		v388 = v385 + v389;
		v391 = __ROR4__(v280 ^ v264 ^ v327 ^ v369, 31);
		v390 = v391;
		v393 = __ROR4__(v379, 2);
		v392 = v393;
		v394 = v390;
		v395 = v388 | v393;
		v396 = v386 + v387;
		v398 = __ROR4__(v388, 2);
		v397 = v398;
		v400 = __ROR4__(v388, 27);
		v399 = v396 + v400;
		v401 = __ROR4__(v286 ^ v277 ^ v335 ^ v372, 31);
		v402 = v401;
		v403 = v390 - 1894007588 + v376 + (v395 & v381 | v388 & v392);
		v404 = v401 - 1894007588 + v381;
		v405 = __ROR4__(v294 ^ v280 ^ v349 ^ v384, 31);
		v406 = v405;
		v407 = v404 + ((v399 | v397) & v392 | v399 & v397);
		v408 = v405;
		v410 = __ROR4__(v399, 27);
		v409 = v403 + v410;
		v412 = __ROR4__(v399, 2);
		v411 = v412;
		v413 = __ROR4__(v306 ^ v286 ^ v591 ^ v390, 31);
		v414 = v413;
		v416 = __ROR4__(v409, 27);
		v415 = v407 + v416;
		v418 = __ROR4__(v409, 2);
		v417 = v418;
		v419 = __ROR4__(v314 ^ v294 ^ v358 ^ v402, 31);
		v420 = v419;
		v421 = v408 - 1894007588 + v392 + ((v409 | v411) & v397 | v409 & v411);
		v422 = v419;
		v424 = __ROR4__(v415, 2);
		v423 = v424;
		v426 = __ROR4__(v415, 27);
		v425 = v421 + v426;
		v427 = v422 - 899497514;
		v428 = v414 - 1894007588 + v397;
		v429 = v314;
		v430 = __ROR4__(v321 ^ v306 ^ v369 ^ v406, 31);
		v431 = v428 + ((v415 | v417) & v411 | v415 & v417);
		v432 = v430;
		v433 = v427 + v411 + (v423 ^ v417 ^ v425);
		v434 = v430;
		v436 = __ROR4__(v425, 2);
		v435 = v436;
		v438 = __ROR4__(v425, 27);
		v437 = v431 + v438;
		v439 = __ROR4__(v327 ^ v429 ^ v372 ^ v414, 31);
		v440 = v439;
		v441 = v434 - 899497514 + v417 + (v435 ^ v423 ^ v437);
		v442 = v439;
		v444 = __ROR4__(v437, 27);
		v443 = v433 + v444;
		v446 = __ROR4__(v437, 2);
		v445 = v446;
		v447 = __ROR4__(v335 ^ v321 ^ v384 ^ v420, 31);
		v448 = v447;
		v449 = v447;
		v451 = __ROR4__(v443, 2);
		v450 = v451;
		v453 = __ROR4__(v443, 27);
		v452 = v441 + v453;
		v454 = v591 ^ v335;
		v456 = __ROR4__(v349 ^ v327 ^ v394 ^ v432, 31);
		v455 = v456;
		v458 = __ROR4__(v452, 27);
		v457 = v442 - 899497514 + v423 + (v445 ^ v435 ^ v443) + v458;
		v459 = v455;
		v461 = __ROR4__(v452, 2);
		v460 = v461;
		v462 = v449 - 899497514 + v435 + (v450 ^ v445 ^ v452);
		v463 = v358 ^ v349;
		v464 = __ROR4__(v454 ^ v402 ^ v440, 31);
		v465 = v464;
		v466 = v463 ^ v406 ^ v448;
		v467 = v455 - 899497514 + v445 + (v460 ^ v450 ^ v457);
		v469 = __ROR4__(v457, 27);
		v468 = v462 + v469;
		v471 = __ROR4__(v457, 2);
		v470 = v471;
		v472 = __ROR4__(v466, 31);
		v473 = v369 ^ v591;
		v591 = v472;
		v475 = __ROR4__(v468, 2);
		v474 = v475;
		v477 = __ROR4__(v468, 27);
		v476 = v467 + v477;
		v478 = v465 - 899497514 + v450 + (v470 ^ v460 ^ v468);
		v479 = __ROR4__(v473 ^ v414 ^ v459, 31);
		v480 = v372 ^ v358 ^ v420;
		v481 = v479;
		v482 = v479;
		v483 = v591 - 899497514 + v460 + (v474 ^ v470 ^ v476);
		v485 = __ROR4__(v476, 2);
		v484 = v485;
		v487 = __ROR4__(v476, 27);
		v486 = v478 + v487;
		v488 = v384 ^ v369 ^ v432;
		v489 = __ROR4__(v480 ^ v465, 31);
		v490 = v489;
		v491 = v372;
		v493 = __ROR4__(v486, 2);
		v492 = v493;
		v495 = __ROR4__(v488 ^ v591, 31);
		v494 = v495;
		v497 = __ROR4__(v486, 27);
		v496 = v483 + v497;
		v498 = v494;
		v500 = __ROR4__(v496, 27);
		v499 = v482 - 899497514 + v470 + (v484 ^ v474 ^ v486) + v500;
		v502 = __ROR4__(v496, 2);
		v501 = v502;
		v504 = __ROR4__(v394 ^ v491 ^ v440 ^ v481, 31);
		v503 = v504;
		v505 = v402 ^ v384;
		v507 = __ROR4__(v499, 27);
		v506 = v490 - 899497514 + v474 + (v492 ^ v484 ^ v496) + v507;
		v508 = v503;
		v509 = v494 - 899497514 + v484;
		v511 = __ROR4__(v499, 2);
		v510 = v511;
		v512 = v406 ^ v394;
		v513 = __ROR4__(v505 ^ v448 ^ v490, 31);
		v514 = v513;
		v516 = __ROR4__(v506, 27);
		v515 = v509 + (v501 ^ v492 ^ v499) + v516;
		v517 = v503 - 899497514 + v492;
		v519 = __ROR4__(v506, 2);
		v518 = v519;
		v520 = v517 + (v510 ^ v501 ^ v506);
		v521 = v519 ^ v510;
		v523 = __ROR4__(v515, 2);
		v522 = v523;
		v525 = __ROR4__(v515, 27);
		v524 = v520 + v525;
		v527 = __ROR4__(v512 ^ v459 ^ v494, 31);
		v526 = v527;
		v528 = v527 - 899497514 + v510 + (v522 ^ v518 ^ v524);
		v530 = __ROR4__(v524, 2);
		v529 = v530;
		v532 = __ROR4__(v524, 27);
		v531 = v514 - 899497514 + v501 + (v521 ^ v515) + v532;
		v534 = __ROR4__(v414 ^ v402 ^ v465 ^ v508, 31);
		v533 = v534;
		v535 = v534 - 899497514;
		v537 = __ROR4__(v420 ^ v406 ^ v591 ^ v514, 31);
		v536 = v537;
		v539 = __ROR4__(v531, 27);
		v538 = v528 + v539;
		v540 = v535 + v518;
		v542 = __ROR4__(v531, 2);
		v541 = v542;
		v543 = __ROR4__(v432 ^ v414 ^ v481 ^ v526, 31);
		v544 = v420;
		v545 = v543;
		v547 = __ROR4__(v538, 2);
		v546 = v547;
		v549 = __ROR4__(v538, 27);
		v548 = v540 + (v529 ^ v522 ^ v531) + v549;
		v550 = v536 - 899497514 + v522 + (v541 ^ v529 ^ v538);
		v552 = __ROR4__(v440 ^ v544 ^ v490 ^ v533, 31);
		v551 = v552;
		v553 = v545 - 899497514 + v529 + (v546 ^ v541 ^ v548);
		v555 = __ROR4__(v548, 2);
		v554 = v555;
		v557 = __ROR4__(v548, 27);
		v556 = v550 + v557;
		v558 = v448 ^ v432 ^ v498 ^ v536;
		v560 = __ROR4__(v550 + v557, 27);
		v559 = v553 + v560;
		v562 = __ROR4__(v556, 2);
		v561 = v562;
		v563 = __ROR4__(v558, 31);
		v564 = v563 - 899497514;
		v566 = __ROR4__(v559, 27);
		v565 = v551 - 899497514 + v541 + (v554 ^ v546 ^ v556) + v566;
		v568 = __ROR4__(v559, 2);
		v567 = v568;
		v569 = __ROR4__(v459 ^ v440 ^ v508 ^ v545, 31);
		v570 = v564 + v546 + (v561 ^ v554 ^ v559);
		v571 = v569 - 899497514 + v554;
		v573 = __ROR4__(v565, 27);
		v572 = v570 + v573;
		v574 = v571 + (v567 ^ v561 ^ v565);
		v576 = __ROR4__(v565, 2);
		v575 = v576;
		v578 = __ROR4__(v572, 27);
		v577 = v574 + v578;
		v579 = v575 ^ v567 ^ v572;
		v581 = __ROR4__(v465 ^ v448 ^ v514 ^ v551, 31);
		v580 = v581;
		v583 = __ROR4__(v572, 2);
		v582 = v583;
		v585 = __ROR4__(v577, 27);
		v584 = v585; // 0xba0b5a21
		v592 = null;
		v587 = bytesToIn(result, 0 + a2 - 28) - 899497514 + v580 + v561 + v579
				+ v584;
		v588 = bytesToIn(result, 4 + a2 - 28) + v577;
		v589 = bytesToIn(result, 8 + a2 - 28) + v582;
		v590 = bytesToIn(result, 12 + a2 - 28) + v575;
		intDataPutIntoByteArray(result, bytesToIn(result, 16 + a2 - 28) + v567,
				16 + a2 - 28);
		intDataPutIntoByteArray(result, v587, 0 + a2 - 28);
		intDataPutIntoByteArray(result, v588, 4 + a2 - 28);
		intDataPutIntoByteArray(result, v589, 8 + a2 - 28);
		intDataPutIntoByteArray(result, v590, 12 + a2 - 28);
		return result;
	}

}
