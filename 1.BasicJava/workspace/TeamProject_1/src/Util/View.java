package Util;

public interface View {
	
	//로그인 및 회원가입
	int HOME = 10000;
	int LOGIN = 0;
	int JOIN_PA = 1;
	int JOIN_PER = 2;
	
	
	//환자
	int MENU_PA = 3;
	int CHART_LIST = 4;
	int CHART_VIEW = 41;
	int PHARM_VIEW = 5;
	int PHARM_DETAILVIEW = 51;
	int RE_BOARD_LIST = 6;
	int RE_BOARD_VIEW = 61;
	int RE_BOARD_INSERT = 62;
	int RE_BOARD_UPDATE = 63; // 3-1-1 등록 게시판 수정
	int RE_BOARD_DELETE = 64; // 3-1-2 등록 게시판 삭제
	int RESERVATION = 7;
	int REV_PRE = 71; //진료 일정
	int REV_REV = 72; //진료 예약
	int VIEW_PER = 80;
	
	//간호사
	int MENU_PER_N = 8;
	int RECEIPT_N = 9;
	int RECEIPT_SORT_N = 91;
	int RECEIPT_CRE_N = 92;
	int RECEIPT_VIEW_N = 93;
	int RECEIPT_NEWPAT_N = 95;
	int RECEIPT_PAY_N = 96;
	int RECEIPT_PAYING_N = 97;
	int PRINT_N = 10;
	int PRINT_PHARM_N = 101;
	int PRINT_MEDICAL_N = 102;
	int PRINT_DE_NAME_N = 103;
	int INPA_LIST_N = 11;
	int INPA_MED_N = 111;
	int DETAILVIEW_N = 12;
	int BOARD_LIST_N = 121;
	int BOARD_VIEW_N = 122;
	int BOARD_INSERT_N = 123;
	int BOARD_UPDATE_N = 124;
	int BOARD_DM_N = 125;
	int BOARD_DMVIEW_N = 126;
	int BOARD_DMS_N = 127;
	int MANAGE_N = 200;
	int MANAGE_CHANGEMYINF_N = 201;
	
	//의사
	int MENU_PER_D = 13;
	int RECEIPT_LIST_D = 14;
	int MED_MEDCON_D = 141;
	int MED_MEDCRE_D = 143;
	int MED_PHARM_D = 142;
	int MED_PHARM_D1 = 146;
	int DETAILVIEW_D = 15;
	int BOARD_LIST_D = 151;
	int BOARD_VIEW_D = 152;
	int BOARD_INSERT_D = 153;
	int BOARD_INSERT_NOTICE_D = 150;
	int BOARD_DELETE_D = 154;
	int BOARD_SUPER_D = 155;
	int BOARD_DM_D = 156;
	int BOARD_DMVIEW_D = 158;
	int BOARD_DMS_D = 159;
	int VIEW_FIN_D = 157;
	int MANAGE_D = 16;
	int MAN_WORK_D = 161;
	int MAN_SAL_D = 162;
	int MANAGE_MY_D = 163;
	int MANAGE_CHANGEMYINF_D = 164;
	int MANAGE_CHANGEMYTIME_D = 165;
	int MANAGE_CHANGEMYST_D = 166;
	
	
	
	
		
}