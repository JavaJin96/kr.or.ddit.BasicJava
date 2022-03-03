package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.controller;
import Dao.DoctorDao;
import Util.ScanUtil;
import Util.View;

public class DoctorService {
	
	private DoctorService() {}
	private static DoctorService instance;
	public static DoctorService getInstance() {
		if(instance == null) {
			instance = new DoctorService();
		}
		return instance;
	}
	
	private DoctorDao dd = DoctorDao.getInstance();
	
	
	
	public int menu_per_d () {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> map1 = new HashMap<>();
		map = dd.menu_per_n_dao();
		map1 = dd.receipt_menushow_d_dao();
		System.out.println(controller.LoginMember.get("PER_NAME") + "님 환영합니다.┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("읽지 않은 쪽지" + map.get("BO") + "개");
		System.out.println("진료 대기 환자" + map1.get("COUNT(REC_NO)") + "명");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("1. 진료업무 2. 조회업무 3. 관리업무 0. 로그아웃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏진행할 업무를 선택해주세요 . ┓");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1 : 
			return View.RECEIPT_LIST_D;
		case 2 :
			return View.DETAILVIEW_D;
		case 3 :
			return View.MANAGE_D;
		case 0 :
			return View.LOGIN; 
		}
		return View.MENU_PER_D;
		
	}
	
	public int receipt_list_d() {
		List<Map<String, Object>> list = new ArrayList<>();
		System.out.println("┏진료업무┓");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("☞진료 대기 환자 리스트☜");
		list = dd.receipt_list_d_dao();
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).get("REC_NO") + "\t");
			System.out.println(list.get(i).get("PAT_NAME") + "\t");
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏1. 진료 및 환자호출 2. 뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 :	
				return View.MED_MEDCON_D;
			case 2 :
				return View.MENU_PER_D;
		}

		return View.MENU_PER_D;
	}
	
	public int med_medcon_d() {
		System.out.println("☞진료하실 환자를 선택해주세요 .☜ ");
		int input1 = ScanUtil.nextInt();
		Map<String, Object> map = new HashMap();
		map = dd.med_medcon_d_dao(input1);
		controller.MedingPat = map;
		System.out.println(controller.MedingPat.get("PAT_ID"));
		System.out.println("※진료환자정보※");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(map.get("PAT_NAME") + "\t" + map.get("SYMPTOM"));
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏1. 진료내용 작성 0.뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 :
				return View.MED_MEDCRE_D;
			case 2 :
				return View.MED_PHARM_D;
			case 0 :
				return View.RECEIPT_LIST_D;
		}
		return View.RECEIPT_LIST_D;
	}
	
	public int medcre_d() {
		System.out.println(controller.MedingPat.get("PAT_NAME") + "님의 진료중");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┏진료내용입력→");
		String con = ScanUtil.nextLine();
		System.out.println("┏입원여부→");
		String inout = ScanUtil.nextLine();
		dd.medcre_d_dao(con, inout);
		int money = 0;
		if(Math.random()*101 < 10) {
			money = 12000;
		}
		else if(Math.random()*101 < 20 && Math.random()*101 >= 10) {
			money = 8000;
		}
		else if(Math.random()*101 < 50 && Math.random()*101 >= 20) {
			money = 30000;
		}
		else if(Math.random()*101 < 80 && Math.random()*101 >= 50) {
			money = 50000;
		}
		else {
			money = 20000;
		}
		
		dd.payment_cre_d_dao(money);
		System.out.println("차트내용입력 → ┏ 환자열람용 ┓");
		String cont = ScanUtil.nextLine();
		dd.charcon_cre_d_dao(cont);
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		dd.receipt_list_del_d_dao();
		System.out.println("┏1. 처방전 작성 0. 진료종료┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1:
				return View.MED_PHARM_D;
			case 0:
				return View.RECEIPT_LIST_D;
		}
		return View.RECEIPT_LIST_D;
	}
	
	
	List<Object> pharms = new ArrayList<>();
	public int medpharm_d() {
		System.out.println("┏환자의 증상 및 처방약 기재 ※  ┓	→");
		String keyword = ScanUtil.nextLine();
		List<Map<String, Object>> list = new ArrayList<>();
		list = dd.medpharm_d_dao(keyword);
		System.out.println("┏처방 가능 약 목록┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("PHA_NAME") + "\t" + list.get(i).get("PHA_CORD"));
			System.out.println(list.get(i).get("PHA_EXP"));
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏1. 약선택 2. 약검색 3. 처방종료┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 :
				return View.MED_PHARM_D1;
				
			case 2 :
				return View.MED_PHARM_D;
				
			case 3 :
				return View.RECEIPT_LIST_D;
		}
		return View.RECEIPT_LIST_D;
		
	}
	
	public int medpharm_d1() {
		System.out.println("┏처방하실 약이름을 입력해주세요┓	→");
		String name = ScanUtil.nextLine();
		System.out.println("┏복용법 및 복용양을 입력해주세요┓	→");
		String manual = ScanUtil.nextLine();
		pharms.add(name);
		pharms.add(manual);
		dd.medpharm_d1_dao(pharms);
		System.out.println("┏처방이 완료되었습니다.┓");
		return View.RECEIPT_LIST_D;
	}
	
	public int detailview_d() {
		System.out.println(controller.LoginMember.get("PER_NAME") +"님");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("1. 쪽지 2. 사내게시판 3. 매출조회 0.메인 ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏행동을 입력해주세요┓ →");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 :
				return View.BOARD_DM_D;
			case 2 :
				return View.BOARD_LIST_D;
			case 3 :
				return View.VIEW_FIN_D;
			case 0 : 
				return View.MENU_PER_D;
		}
		return View.DETAILVIEW_D;
	}
	
	public int view_fin_d() {
		List<Map<String, Object>> list = new ArrayList<>();
		list = dd.view_fin_d_dao();
		System.out.println("┏월 매출 현황┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).get("MED_DATE") + " : " + list.get(i).get("MONEY") + "₩");
		}
		System.out.println("\n┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("0. ┏뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 0 :  
			return View.DETAILVIEW_D;
		}
		return View.DETAILVIEW_D;
	}
	
	
	public int board_dm_d() {
		List<Map<String, Object>> list = new ArrayList<>();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("쪽지함");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		list = dd.board_dm_d_dao();
		for(int i = list.size()-1; i >= 0;  i--) {
			if(controller.LoginMember.get("PER_ID").equals(list.get(i).get("TARGET"))) {
				System.out.print(Integer.parseInt(String.valueOf(list.get(i).get("BOARD_NO")))-1000 + ".\t");
				System.out.print(list.get(i).get("TITLE") + "\t");
				System.out.print(list.get(i).get("CONTENT") + "\t");
				System.out.print(list.get(i).get("PER_NAME") + "\t");
				System.out.println(list.get(i).get("EB_FLAG"));
			}
			
		}
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("1. 상세 조회 2. 쪽지 보내기 0. 뒤로가기");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1:
				return View.BOARD_DMVIEW_D;
			case 2:
				return View.BOARD_DMS_D;
			case 0:
				return View.DETAILVIEW_D;
		}
		return View.BOARD_DM_D;
	}
	
	
	public int board_dmview_d() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("몇번 쪽지를 열람할까요?");
		int input = ScanUtil.nextInt() + 1000;
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		Map<String, Object> map = new HashMap<>();
		map = dd.board_dmview_d_dao(input);
		dd.board_dmview_d_dao_1(input);
		if(Integer.parseInt(String.valueOf(map.get("BOARD_NO"))) == input) {
			System.out.print(map.get("TITLE") + "\t");
			System.out.println(map.get("PER_NAME") + "\t");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println(map.get("CONTENT") + "\t");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("┏1. 답장하기 2. 삭제 0. 뒤로가기┓");
			int input1 = ScanUtil.nextInt();
			switch(input1) {
			case 1 :
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("제목을 입력해주세요>");
				String title = 	ScanUtil.nextLine();
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("내용을 입력해주세요>");
				String content = ScanUtil.nextLine();
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				dd.board_dms_d_dao((String)map.get("PER_ID"), title, content);
				System.out.println("전송 되었습니다.");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				return View.BOARD_DM_D;
			case 2 :
				dd.board_dmdel_d_dao(map.get("BOARD_NO"));
				return View.BOARD_DM_D;
			case 0 :
				return View.BOARD_DM_D;
			}
		}
		return View.BOARD_DM_D;
		
	}
	
	public int board_list_d() {
		System.out.println("┏사내 게시판┓");
		System.out.println("사내 게시판에 오신걸 환영 합니다.");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("번호 \t 제목 \t 작성자 \t 게시일");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		List<Map<String, Object>> list = dd.board_list_d_dao();
		List<Map<String, Object>> list1 = dd.board_list_d_dao2();
		for(int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i).get("BOARD_NO") + "\t");
			System.out.print(list1.get(i).get("TITLE") + "\t");
			System.out.print(list1.get(i).get("PER_NAME") + "\t");
			System.out.println(list1.get(i).get("REG_DATE") + "\t");
			
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

		
		for(int i = 0; i < list.size(); i++) {
			if(Integer.parseInt(String.valueOf(list.get(i).get("BOARD_NO"))) < 1000) {
				System.out.print(list.get(i).get("BOARD_NO") + "\t");
				System.out.print(list.get(i).get("TITLE") + "\t");
				System.out.print(list.get(i).get("PER_NAME") + "\t");
				System.out.println(list.get(i).get("REG_DATE") + "\t");
				
			}
		}
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("1. 조회 2. 등록 3. 공지글 등록 0. 뒤로가기");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1:
				return View.BOARD_VIEW_D;
			case 2:
				return View.BOARD_INSERT_D;
			case 3:
				return View.BOARD_INSERT_NOTICE_D;
			case 0:
				return View.DETAILVIEW_D;
		}
		return View.BOARD_INSERT_D;
	}
	
	public int board_dms_d() {
		System.out.println("누구에게 쪽지를 보낼까요?");
		String name = ScanUtil.nextLine();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("제목을 입력해주세요 >");
		String title = ScanUtil.nextLine();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("내용을 입력해주세요 >");
		String content = ScanUtil.nextLine();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		Map<String, Object> map = new HashMap<>();
		map = dd.board_dms_d_dao1(name);
		
		dd.board_dms_d_dao((String) map.get("PER_ID"), title, content);
		return View.BOARD_DM_D;
	}
	
	
	int temp1 = 0;
	public int board_view_d() {
		System.out.println("몇번 게시글을 조회할까요?");
		int input = ScanUtil.nextInt();
		List<Map<String, Object>> list = new ArrayList<>();
		list = dd.board_view_d_dao(input);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).get("BOARD_NO") +"\t");
			System.out.print(list.get(i).get("TITLE") +"\t");
			System.out.print(list.get(i).get("PER_NAME") +"\t");
			System.out.println(list.get(i).get("REG_DATE") +"\t");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println(list.get(i).get("CONTENT"));
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			if(list.get(i).get("PER_ID").equals(controller.LoginMember.get("PER_ID"))) {
				System.out.print("┏1. 수정 2. 삭제┓");
				temp1 = Integer.parseInt(String.valueOf(list.get(i).get("BOARD_NO")));
			}
			
		}
		
		System.out.println("┏0. 뒤로가기┓");
		int input1 = ScanUtil.nextInt();
		switch(input1) {
		case 1:
			dd.board_view_update_d_dao(temp1);
			return View.BOARD_LIST_D;
		case 2:
			dd.board_view_del_d_dao(temp1);
			return View.BOARD_LIST_D;
		case 0:
			return View.BOARD_LIST_D;
		}
		return View.BOARD_LIST_D;
		
	}
	
	public int board_insert_d() {
		System.out.println("게시글 등록");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("제목을 입력해주세요 →");
		String title = ScanUtil.nextLine();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("내용을 입력해주세요 →");
		String content = ScanUtil.nextLine();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		dd.board_insert_d_dao(title, content);
		return View.BOARD_LIST_D;
		
	}
	
	public int board_insert_notice_d() {
		System.out.println("게시글 등록");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("제목을 입력해주세요 →");
		String title = ScanUtil.nextLine();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("내용을 입력해주세요 →");
		String content = ScanUtil.nextLine();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		dd.board_insert_notice_d_dao(title, content);
		return View.BOARD_LIST_D;
		
	}
	
	public int manage_d() {
		System.out.println("관리 페이지");
		System.out.println("┏관리 페이지에 오신걸 환영합니다.┓"); 
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("전 직원 목록");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		List<Map<String, Object>> list = new ArrayList<>();
		list = dd.manage_d_dao();
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).get("PER_NAME") + "\t");
			System.out.print(list.get(i).get("PER_ID") + "\t");
			System.out.print(list.get(i).get("TEL") + "\t");
			System.out.print(list.get(i).get("HIRE_DATE") + "\t");
			System.out.println(list.get(i).get("SALARY") + "\t");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		}
		System.out.println("┏1. 직원관리 2. 급여관리 3. 직원등록  4. 내정보 0. 뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1:
				return View.MAN_WORK_D;
			case 2:
				return View.MAN_SAL_D;
			case 3:
				return View.JOIN_PER;
			case 4:
				return View.MANAGE_MY_D;
			case 0:
				return View.MENU_PER_D;
		}
		return View.MENU_PER_D;
	}
	
	public int man_work_d() {
		System.out.println("직원관리");
		System.out.println("직원관리 페이지에 오신걸 환영합니다.");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("변경하실 직원의 이름을 입력해주세요.→");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		String name = ScanUtil.nextLine();
		
		Map<String, Object> map = new HashMap<>();
		map = dd.man_work_d_dao(name);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(map.get("PER_NAME") + "님의 인적사항" );
		System.out.println("");
		System.out.println("사원번호 : " + map.get("PER_ID"));
		System.out.println("전화번호 : " + map.get("TEL"));
		System.out.println("입사일 : " + map.get("HIRE_DATE"));
		System.out.println("급여 : " + map.get("SALARY"));
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏1. 직급변경 0. 뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 :
				System.out.println("┏변경할 직급을 입력해주세요.→");
				String input2 = ScanUtil.nextLine();
				dd.man_word_d_dao2(input2, name);
				System.out.println("●변경되었습니다.");
				return View.MANAGE_D;
			case 0 :
				return View.MANAGE_D;
		}
		return View.MANAGE_D;
	}
	
	public int man_sal_d() {
		System.out.println("┏급여관리┓");
		System.out.println("급여관리 페이지에 오신걸 환영합니다.");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("급여를 변경할 사원의 이름을 입력해주세요.>");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		String input = ScanUtil.nextLine();
		System.out.println("변경할 급여를 입력해주세요.?");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		int salary = ScanUtil.nextInt();
		dd.man_sal_d_dao(salary, input);
		System.out.println("┏변경되었습니다. 변경내역은 직원조회에서 확인해주세요.┓");
		return View.MANAGE_D;
		
	}
	
	public int join_per() {
		System.out.println("┏직원등록┓");
		System.out.println("입사를 환영합니다 ♥");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("직무를 선택해주세요. <1. 의사  ↔ 2. 간호사>");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		int job = ScanUtil.nextInt();
		System.out.println("이름을 입력해주세요.→");
		String name = ScanUtil.nextLine();
		System.out.println("내선번호를 입력해주세요.→");
		String per_tel = ScanUtil.nextLine();
		System.out.println("개인번호를 입력해주세요.→");
		String tel = ScanUtil.nextLine();
		System.out.println("HR계정 비밀번호를 입력해주세요.→");
		String password = ScanUtil.nextLine();
		System.out.println("급여를 입력해주세요.→");
		int salary = ScanUtil.nextInt();
		dd.join_per_d_dao(job, name, per_tel, tel, password, salary);
		System.out.println("가입이 완료되었습니다.");
		return View.MANAGE_D;
	}
	

	public int manage_my_d() {
		System.out.println("┏내정보┓");
		System.out.println("※개인정보 도용에 주의 해주세요 ※");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("1. 내정보수정 2. 진료 및 상담시간 변경 3. 내 약력 변경 및 등록 0. 뒤로가기");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("무엇을 하시겠습니까 ?");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1:
				return View.MANAGE_CHANGEMYINF_D;
			case 2:
				return View.MANAGE_CHANGEMYTIME_D;
			case 3:
				return View.MANAGE_CHANGEMYST_D;
			case 4:
				return View.MANAGE_D;
		}
		return View.MANAGE_D;
	}
	
	public int manage_changemyinf_d() {
		System.out.println("내정보수정");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("변경하실 이름을 입력해주세요.>");
		String name =  ScanUtil.nextLine();
		System.out.println("변경하실 전화번호를 입력해주세요.>");
		String tel =  ScanUtil.nextLine();
		System.out.println("변경하실 비밀번호를 입력해주세요.>");
		String password =  ScanUtil.nextLine();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		dd.manage_changemyinf_d_dao(name, tel, password);
		System.out.println("변경이 완료되었습니다 ! ");
		return View.MANAGE_MY_D;
		
	}
	
	public int manage_changemytime_d() {
		System.out.println("┏내 스케줄 변경┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("근무하시는 요일을 입력해주세요.>");
		String day = ScanUtil.nextLine();
		System.out.println("근무하시는 시간을 입력해주세요.>오전/오후/오전,오후");
		String time = ScanUtil.nextLine();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		dd.manage_changemytime_d_dao(day, time);
		System.out.println("수정이 완료되었습니다.");
		return View.MANAGE_MY_D;
	}
	
	
	public int manage_changemyst_d() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("진료과를 입력해주세요.");
		String dep = ScanUtil.nextLine();
		System.out.println("진료실를 입력해주세요.");
		String office = ScanUtil.nextLine();
		System.out.println("경력을 입력해주세요.");
		String care = ScanUtil.nextLine();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		dd.manage_changemyst_d_dao(dep, office, care);
		System.out.println("수정이 완료되었습니다.");
		return View.MANAGE_MY_D;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
