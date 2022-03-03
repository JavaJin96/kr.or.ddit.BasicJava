package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.event.TreeWillExpandListener;
import javax.swing.plaf.synth.SynthSeparatorUI;

import Controller.controller;
import Dao.NurseDao;
import Util.ScanUtil;
import Util.View;

public class NurseService {
	
	private NurseService() {}
	private static NurseService instance;
	public static NurseService getInstance() {
		if(instance == null) {
			instance = new NurseService();
		}
		return instance;
	}
	
	private NurseDao nd = NurseDao.getInstance();
	

	public int menu_per_n() {
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> map1 = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		map = nd.menu_per_n_dao();
		map1 = nd.receipt_menushow_n_dao();
		map2 = nd.menu_per_print_n_dao();
		
		System.out.println(controller.LoginMember.get("PER_NAME") + "님 환영합니다♥");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("읽지 않은 쪽지 : " + map.get("BO") + "개");
		System.out.println("수납 대기 환자 : " + map1.get("COUNT(PAY_ID)") + "명");
		System.out.println("출력 대기 처방전 : " + map2.get("COUNT(MED_NO)") + "장");		
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏ 1.접수업무  2.출력업무  3.입원관리  4.조회업무  5.관리업무  0.로그아웃┓");
		System.out.println("진행할 업무를 선택해주세요.");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 : 
				return View.RECEIPT_N;
			case 2 :
				return View.PRINT_N;
			case 3 :
				return View.INPA_LIST_N;
			case 4 :
				return View.DETAILVIEW_N;
			case 5 :
				return View.MANAGE_N;
			case 0 :
				return View.LOGIN;
		}
		return View.MENU_PER_N;
	}
	
	
	public int inpa_list_n() {
		System.out.println("┏입원 대기환자 리스트┓");
		System.out.println("입원환자 에게 우리는 가족입니다 ♥");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		List<Map<String, Object>> list = new ArrayList<>();
		list = nd.inpa_list_n_dao();
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).get("PAT_NAME")+ "\t");
			System.out.print(list.get(i).get("MED_NO")+ "\t");
			System.out.println(list.get(i).get("INOUT")+ "\t");
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏1. 입원실 배정 0. 뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 :
				System.out.println("┏입원실을 배정할 환자번호를 입력해주세요→");
				String med_no = ScanUtil.nextLine();
				System.out.println("┏배정할 입원실 번호를 입력해주세요→");
				int room = ScanUtil.nextInt();
				nd.inpa_list_n_dao1(room, med_no);
				System.out.println("┏배정되었습니다.┓");
				return View.MENU_PER_N;
				
			case 0 :
				return View.MENU_PER_N;
		}
		return View.MENU_PER_N;
	}
	
	
	public int receipt_n() {
		List<Map<String, Object>> list = new ArrayList<>();
		List<Map<String, Object>> list1 = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		
		
		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("※환자 접수 리스트※");
		list = nd.receipt_n_dao();
		for(int i = 0; i < list.size(); i++	) {
			System.out.print(list.get(i).get("REC_NO") + "\t");
			System.out.print(list.get(i).get("PAT_NAME") + "\t\n");
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏예약 접수 리스트┓");
		list1 = nd.receipt_n_dao_2();

		for(int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i).get("RES_DATE") + "\t");
			System.out.println(list1.get(i).get("PAT_NAME") + "\t");
		}
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┏1. 환자 조회 2. 수납 3. 예약환자등록 0. 메인┓");
		System.out.println("조회하고 싶은 내역을 선택해주세요 →");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 : 
				return View.RECEIPT_SORT_N;
			case 2 :
				return View.RECEIPT_PAY_N;
			case 3 :
				nd.receipt_res_cre_n_dao();
				return View.RECEIPT_N;
			case 0 :
				return View.MENU_PER_N;
		}
		return View.RECEIPT_N;
		
	}
	
	public int receipt_pay_n() {
		List<Map<String, Object>> list = new ArrayList<>();
		list = nd.receipt_pay_n_dao();
		System.out.println("┏수납 대기 리스트┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).get("PAT_NAME") + "\t");
			System.out.println(list.get(i).get("MONEY") + "\t");
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏1. 수납처리 0. 뒤로가기 ┓");
		int input  = ScanUtil.nextInt();
		switch (input) {
			case 1 :
				return View.RECEIPT_PAYING_N;
			case 0 : 
				return View.RECEIPT_N;
		}
		return View.RECEIPT_N;
	}
	
	public int receipt_paying_n() {
		System.out.println("┏수납 진행┓");
		System.out.println("※수납시 카드 결제 및 현금 유무 파악※");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("수납할 환자의 성함을 입력해주세요→");
		String name = ScanUtil.nextLine();
		Map<String, Object> map = new HashMap<>();
		map = nd.receipt_paying_n_dao(name);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(map.get("PAT_NAME") + "님의 진료비는 ");
		System.out.println(map.get("MONEY") + "원 입니다. 감사합니다 .");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┏1. 수납처리┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 : 
				nd.receipt_paying_n_dao1(map.get("PAY_ID"));
				System.out.println("┏수납처리가 완료되었습니다.┓");
				System.out.println("감사합니다 다음에 또 방문해주세요 ♥");
				return View.RECEIPT_PAY_N;
		}
		return View.MENU_PER_N;
	}
	
	
	List<Map<String, Object>> temp = new ArrayList<>();// 특정환자의 모든번호
	public int receipt_sort_n() {
		System.out.println("┏조회할 환자이름을 입력해주세요 ┓→");
		String name = ScanUtil.nextLine();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" 번호\t  환자번호 \t\t 환자이름 \t전화번호 ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		List<Map<String, Object>> list = new ArrayList<>();
		list = nd.receipt_sort_n(name);
		temp = nd.receipt_sort_n(name);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(i+1 + ". \t" );
			System.out.print(list.get(i).get("PAT_ID") + "\t");
			System.out.print(list.get(i).get("PAT_NAME")+ "\t");
			System.out.print(list.get(i).get("PAT_TEL")+ "\t");
			System.out.println();
		}
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("1. 접수 대기열 등록 2. 상세 조회 3. 새로운 환자 등록 0. 뒤로가기");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		int input = ScanUtil.nextInt();
		switch (input) {
			case 1 :
				return View.RECEIPT_CRE_N;
			case 2 :
				return View.RECEIPT_VIEW_N;
			case 3 :
				return View.RECEIPT_NEWPAT_N;
			case 0 :
				return View.RECEIPT_N;
		}
		return View.RECEIPT_SORT_N;
	}
	
	public int receipt_cre_n() {
		nd.receipt_cre_n_dao(temp);
		return View.RECEIPT_N;
	}
	
	
	public int receipt_view_n() {
		System.out.println("┏상세조회할 환자의 환자번호를 입력해주세요.┓→");
		String patid = ScanUtil.nextLine();
		List<Map<String, Object>> list = new ArrayList();
		list = nd.receipt_view_n_dao(patid);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.print(list.get(0).get("PAT_NAME") + "\t");
			System.out.print(list.get(0).get("PAT_ID") + "\t\n");
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("주민번호 : " + list.get(0).get("PAT_REG1") + "-" + list.get(0).get("PAT_REG2") +"\t");
			System.out.print("주소 : " + list.get(0).get("PAT_ADDR") + "\t");
			System.out.print("전화번호 : " + list.get(0).get("PAT_TEL") + "\t");
			System.out.println("비밀번호 : " + list.get(0).get("PASSWORD") + "\t");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏1. 대기열 등록 0. 뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch(input) {
		
		case 1 :
			nd.receipt_cre_n_dao(list);
			return View.RECEIPT_N;
		case 0 : 
			return View.RECEIPT_N;
		}
		return View.RECEIPT_SORT_N;

	}
	
	public int detailview_n() {
		System.out.println(controller.LoginMember.get("PER_NAME") +"님");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("1. 쪽지 2. 사내게시판  0.메인 ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏행동을 입력해주세요┓→");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 :
				return View.BOARD_DM_N;
			case 2 :
				return View.BOARD_LIST_N;
			case 0 : 
				return View.MENU_PER_N;
		}
		return View.DETAILVIEW_N;

	}
	
	public int receipt_newpat_n() {
		System.out.println("┏새로운 환자 등록을 시작합니다.→");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┏환자의 성함을 입력해주세요.→");
		String name = ScanUtil.nextLine();
		System.out.println("┏환자의 주민번호을 입력해주세요.→");
		String regno [] = ScanUtil.nextLine().split("-");
		System.out.println("┏환자의 주소를 입력해주세요.→");
		String addr = ScanUtil.nextLine();
		System.out.println("┏환자의 전화번호를 입력해주세요.→");
		String tel = ScanUtil.nextLine();
		nd.receipt_newpat_n_dat(name, regno, addr, tel);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("┏환자등록이 완료되었습니다.→");
		return View.RECEIPT_SORT_N;
		
	}
	
	public int print_n() {
		System.out.println("┏처방전 출력 대기 리스트┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		List<Map<String, Object>> list = new ArrayList<>();
		list = nd.print_n_dao();
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).get("B.FLAG") == null) {
				System.out.print(i+1 + ".\t" );
				System.out.print(list.get(i).get("PAT_ID") + "\t");
				System.out.println(list.get(i).get("MED_NO") + "\t");				
			}
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏1. 출력  0. 뒤로가기┓");
		System.out.println("┏행동을 입력해주세요→");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1 : 
				System.out.println("┏━━━━━━━━━━━━━━━━┏인쇄중┛━━━━━━━━━━━━━━━━┓");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				System.out.println("인쇄가 완료되었습니다 ☞");
				nd.print_n_dao1();
				return View.PRINT_N;
			case 0 :
				return View.MENU_PER_N;
		}
		
		return View.PRINT_N;
	}

	
	public int board_list_n() {
		System.out.println("┏사내 게시판┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("번호 \t 제목 \t 작성자 \t 게시일");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		List<Map<String, Object>> list = nd.board_list_n_dao();
		List<Map<String, Object>> list1 = nd.board_list_n_dao2();
		for(int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i).get("BOARD_NO") + "\t");
			System.out.print(list1.get(i).get("TITLE") + "\t");
			System.out.print(list1.get(i).get("PER_NAME") + "\t");
			System.out.println(list1.get(i).get("REG_DATE") + "\t");
			
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(Integer.parseInt(String.valueOf(list.get(i).get("BOARD_NO"))) < 1000) {
				System.out.print(list.get(i).get("BOARD_NO") + "\t");
				System.out.print(list.get(i).get("TITLE") + "\t");
				System.out.print(list.get(i).get("PER_NAME") + "\t");
				System.out.println(list.get(i).get("REG_DATE") + "\t");
				
			}
		}
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("1. 조회 2. 등록 0. 뒤로가기");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1:
				return View.BOARD_VIEW_N;
			case 2:
				return View.BOARD_INSERT_N;
			case 0:
				return View.DETAILVIEW_N;
		}
		return View.BOARD_INSERT_N;
	}
	
	int temp1 = 0;
	public int board_view_n() {
		System.out.println("┏조회할 게시물을 선택해주세요 ┓.");
		int input = ScanUtil.nextInt();
		List<Map<String, Object>> list = new ArrayList<>();
		list = nd.board_view_n_dao(input);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).get("BOARD_NO") +"\t");
			System.out.print(list.get(i).get("TITLE") +"\t");
			System.out.print(list.get(i).get("PER_NAME") +"\t");
			System.out.println(list.get(i).get("REG_DATE") +"\t");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println(list.get(i).get("CONTENT"));
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			if(list.get(i).get("PER_ID").equals(controller.LoginMember.get("PER_ID"))) {
				System.out.print("┏1. 수정 2. 삭제┓");
				temp1 = Integer.parseInt(String.valueOf(list.get(i).get("BOARD_NO")));
			}
			
		}
		
		System.out.println("┏0. 뒤로가기┓");
		int input1 = ScanUtil.nextInt();
		switch(input1) {
		case 1:
			nd.board_view_update_n_dao(temp1);
			return View.BOARD_LIST_N;
		case 2:
			nd.board_view_del_n_dao(temp1);
			return View.BOARD_LIST_N;
		case 0:
			return View.BOARD_LIST_N;
		}
		return View.BOARD_LIST_N;
		
	}
	
	public int board_insert_n() {
		System.out.println("┏게시글 등록┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┏제목을 입력해주세요 →");
		String title = ScanUtil.nextLine();
		System.out.println("┏내용을 입력해주세요 →");
		String content = ScanUtil.nextLine();
		
		nd.board_insert_n_dao(title, content);
		return View.BOARD_LIST_N;
		
	}
	
		
	
	public int board_dm_n_() {
		List<Map<String, Object>> list = new ArrayList<>();
		System.out.println("┏쪽지함┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		list = nd.board_dm_n_dao();
		for(int i = list.size()-1; i >= 0;  i--) {
			if(controller.LoginMember.get("PER_ID").equals(list.get(i).get("TARGET"))) {
				System.out.print(Integer.parseInt(String.valueOf(list.get(i).get("BOARD_NO")))-1000 + ".\t");
				System.out.print(list.get(i).get("TITLE") + "\t");
				System.out.print(list.get(i).get("CONTENT") + "\t");
				System.out.print(list.get(i).get("PER_NAME") + "\t");
				System.out.println(list.get(i).get("EB_FLAG"));
			}
			
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏1. 상세 조회 2. 쪽지 보내기 0. 뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1:
				return View.BOARD_DMVIEW_N;
			case 2:
				return View.BOARD_DMS_N;
			case 0:
				return View.DETAILVIEW_N;
		}
		return View.BOARD_DM_N;
	}
	
	public int board_dmview_n() {
		System.out.println("┏확인하실 쪽지를 선택해주세요┓→ ");
		int input = ScanUtil.nextInt() + 1000;
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		Map<String, Object> map = new HashMap<>();
		map = nd.board_dmview_n_dao(input);
		nd.board_dmview_n_dao_1(input);
		if(Integer.parseInt(String.valueOf(map.get("BOARD_NO"))) == input) {
			System.out.print(map.get("TITLE") + "\t");
			System.out.println(map.get("PER_NAME") + "\t");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println(map.get("CONTENT") + "\t");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("┏1. 답장하기 2. 삭제 0. 뒤로가기┓");
			int input1 = ScanUtil.nextInt();
			switch(input1) {
			case 1 :
				System.out.println("┏제목을 입력해주세요→");
				String title = 	ScanUtil.nextLine();
				System.out.println("┏내용을 입력해주세요→");
				String content = ScanUtil.nextLine();
				nd.board_dms_n_dao((String)map.get("PER_ID"), title, content);
				System.out.println("┏전송이 완료 되었습니다.┓");
				return View.BOARD_DM_N;
			case 2 :
				nd.board_dmdel_n_dao(map.get("BOARD_NO"));
				return View.BOARD_DM_N;
			case 0 :
				return View.BOARD_DM_N;
			}
		}
		return View.BOARD_DM_N;
		
	}
	
	public int board_dms_n() {
		System.out.println("┏받는사람을 선택해주세요.┓");
		String name = ScanUtil.nextLine();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┏제목을 입력해주세요 →");
		String title = ScanUtil.nextLine();
		System.out.println("┏내용을 입력해주세요 →");
		String content = ScanUtil.nextLine();
		
		Map<String, Object> map = new HashMap<>();
		map = nd.board_dms_n_dao1(name);
		
		nd.board_dms_n_dao((String) map.get("PER_ID"), title, content);
		return View.BOARD_DM_N;
	}
	
	
	
	public int manage_n() {
		Map<String, Object> map = new HashMap<>();
		map = nd.manage_n_dao();
		System.out.println("┏관리업무┓");
		System.out.println("┏관리업무에 오신걸 환영합니다 .┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("☞내정보☜");
		System.out.println("이름 : " + map.get("PER_NAME") );
		System.out.println("직원번호 : " + map.get("PER_ID") );
		System.out.println("내선번호 : " + map.get("PER_TEL") );
		System.out.println("개인번호 : " + map.get("TEL") );
		System.out.println("입사일 : " + map.get("HIRE_DATE") );
		System.out.println("급여 : " + map.get("SALARY") );
		System.out.println("HR계정 비밀번호 : " + map.get("PASSWORD") );
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏1. 내정보수정 0. 메인┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1:
				return View.MANAGE_CHANGEMYINF_N;
			case 0:
				return View.MENU_PER_N;
		}
		return View.MENU_PER_N;
	}
	
	public int manage_changemyinf_n() {
		System.out.println("┏내정보수정┓");
		System.out.println("※개인정보 도용을 주의해주세요※");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┏변경하실 이름을 입력해주세요.→");
		String name =  ScanUtil.nextLine();
		System.out.println("┏변경하실 전화번호를 입력해주세요.→");
		String tel =  ScanUtil.nextLine();
		System.out.println("┏변경하실 비밀번호를 입력해주세요.→");
		String password =  ScanUtil.nextLine();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		nd.manage_changemyinf_n_dao(name, tel, password);
		System.out.println("┏수정이 완료 되었습니다┓");
		return View.MANAGE_N;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
