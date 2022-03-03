package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dao.DoctorDao;
import Dao.NurseDao;
import Dao.PatientDao;
import Service.DoctorService;
import Service.NurseService;
import Service.PatientService;
import Util.JDBCUtil;
import Util.ScanUtil;
import Util.View;

public class controller {

	public static void main(String[] args) {
		
		
		new controller().start();
	}

	private JDBCUtil jdbc = JDBCUtil.getInstance();
	public static Map<String, Object> LoginMember;
	public static Map<String, Object> MedingPat;
	private PatientService ps = PatientService.getInstance();
	private NurseService ns = NurseService.getInstance();
	private NurseDao nd = NurseDao.getInstance();
	private PatientDao pd = PatientDao.getInstance();
	private DoctorService ds = DoctorService.getInstance();
	private DoctorDao dd = DoctorDao.getInstance();
	
	private void start() {
		int view = View.HOME;
		
		while(true) {
			
			switch(view) {
			case View.HOME:
				view = home();
				break;
			case View.LOGIN:
				view = login();
				break;
			case View.JOIN_PA:
				view = ps.join_pa();
				break;
			case View.JOIN_PER :
				view = ds.join_per();
				break;
			case View.MENU_PA:
				view = ps.loginPa();
				break;
			case View.CHART_LIST:
				view =ps.chart();
				break;
			case View.CHART_VIEW:
				view = ps.chart_view();
				break;
			case View.PHARM_VIEW:
				view =ps.pharm();
				break;
			case View.PHARM_DETAILVIEW :
				view = ps.pharm_view();
				break;
			case View.RE_BOARD_LIST:
				view =ps.board();
				break;
			case View.RE_BOARD_VIEW:
				view = ps.boardv();
				break;
			case View.RE_BOARD_INSERT:
				view = ps.boardi();
				break;
			case View.RE_BOARD_UPDATE:
				view =ps.update();
				break;
			case View.RE_BOARD_DELETE:
				view = ps.delete();
				break;
			case View.RESERVATION:
				view = ps.Reservation();
				break;
			case View.REV_REV:  //환자 부분
				view = ps.rev();
				break;
			case View.VIEW_PER:
				view = ps.view_per();
				break;
			case View.MENU_PER_N:
				view = ns.menu_per_n();
				break;
			case View.RECEIPT_N:
				view = ns.receipt_n();
				break;
			case View.RECEIPT_SORT_N:
				view = ns.receipt_sort_n();
				break;
			case View.RECEIPT_CRE_N:
				view = ns.receipt_cre_n();
				break;
			case View.RECEIPT_VIEW_N:
				view = ns.receipt_view_n();
				break;
			case View.RECEIPT_NEWPAT_N :
				view = ns.receipt_newpat_n();
				break;
			case View.PRINT_N:
				view = ns.print_n();
				break;
			case View.RECEIPT_PAY_N :
				view = ns.receipt_pay_n();
				break;
			case View.RECEIPT_PAYING_N :
				view = ns.receipt_paying_n();
				break;
			case View.INPA_LIST_N:
				view = ns.inpa_list_n();
				break;
			case View.DETAILVIEW_N:
				view = ns.detailview_n();
				break;
			case View.BOARD_LIST_N:
				view = ns.board_list_n();
				break;
			case View.BOARD_VIEW_N:
				view = ns.board_view_n();
				break;
			case View.BOARD_INSERT_N:
				view = ns.board_insert_n();
				break;
			case View.BOARD_DM_N:
				view = ns.board_dm_n_();
				break;
			case View.BOARD_DMVIEW_N:
				view = ns.board_dmview_n();
				break;
			case View.BOARD_DMS_N:
				view = ns.board_dms_n();
				break;
			case View.MANAGE_N:
				view = ns.manage_n();
				break;
			case View.MANAGE_CHANGEMYINF_N:
				view = ns.manage_changemyinf_n();
				break;
			case View.MENU_PER_D:
				view = ds.menu_per_d();
				break;
			case View.RECEIPT_LIST_D:
				view = ds.receipt_list_d();
				break;
			case View.MED_MEDCON_D:
				view = ds.med_medcon_d();
				break;
			case View.MED_MEDCRE_D:
				view = ds.medcre_d();
				break;
			case View.MED_PHARM_D:
				view = ds.medpharm_d();
				break;
			case View.MED_PHARM_D1:
				view = ds.medpharm_d1();
				break;
			case View.DETAILVIEW_D:
				view = ds.detailview_d();
				break;
			case View.BOARD_LIST_D:
				view = ds.board_list_d();
				break;
			case View.BOARD_VIEW_D:
				view = ds.board_view_d();
				break;
			case View.BOARD_INSERT_D:
				view = ds.board_insert_d();
				break;
			case View.BOARD_INSERT_NOTICE_D :
				view = ds.board_insert_notice_d();
				break;
			case View.BOARD_SUPER_D:
				break;
			case View.BOARD_DM_D:
				view = ds.board_dm_d();
				break;
			case View.BOARD_DMS_D:
				view = ds.board_dms_d();
				break;
			case View.BOARD_DMVIEW_D:
				view = ds.board_dmview_d();
				break;
			case View.VIEW_FIN_D:
				view = ds.view_fin_d();
				break;
			case View.MANAGE_D:
				view = ds.manage_d();
				break;
			case View.MAN_WORK_D:
				view = ds.man_work_d();
				break;
			case View.MAN_SAL_D:
				view = ds.man_sal_d();
				break;
			case View.MANAGE_MY_D:
				view = ds.manage_my_d();
				break;
			case View.MANAGE_CHANGEMYINF_D:
				view = ds.manage_changemyinf_d();
				break;
			case View.MANAGE_CHANGEMYTIME_D:
				view = ds.manage_changemytime_d();
				break;
			case View.MANAGE_CHANGEMYST_D:
				view = ds.manage_changemyst_d();
				break;
			
			
			}
			
		}

		
	}
	
	private int home() {
		System.out.println("♥환영 합니다♥");
		System.out.println("┏최고로 모시겠습니다. 대덕인재병원 입니다┓");
		System.out.println("1. 로그인 2. 회원가입 0. 프로그램 종료");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1 :
			return View.LOGIN;
		case 2 :
			System.out.println("┏1. 환자 회원 가입 0. 초기화면 ┓");
			int input1 = ScanUtil.nextInt();
			if(input1 == 1) {
				return View.JOIN_PA;				
			}
//			if(input1 == 2) {
//				return View.JOIN_PER;
//			}
			if(input1 == 0) {
				return View.HOME;
			}
		case 0 : 
			System.out.println("※프로그램을 종료합니다※");
			System.exit(0);
		}
		return View.HOME;
	}
	
	private int login()	{
		System.out.println("┏대덕인재병원 로그인┓");
		System.out.println("1. 환자 로그인  2. 직원 로그인 0.초기화면");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		int input2 = ScanUtil.nextInt();
		
		switch(input2) {
		
		case 1 : 	System.out.println("┏아이디를 입력해주세요 →");
					System.out.println("┏환자 ID를 ID로 사용해주세요→");
					String input = ScanUtil.nextLine();
					System.out.println("┏비밀번호를 입력해주세요 →");
					String input1 = ScanUtil.nextLine();
					
					String sql = " SELECT PAT_ID, PASSWORD, PAT_NAME FROM PATIENTS ";
					List<Map<String, Object>> list = new ArrayList<>();
					list = jdbc.selectList(sql);
					
					for(int i = 0; i < list.size(); i++) {
						if(list.get(i).get("PAT_ID").equals(input) 
								&& list.get(i).get("PASSWORD").equals(input1)) {
							System.out.println("┏로그인 성공!");
							LoginMember = list.get(i);
							return View.MENU_PA;
						}
						
					}
					System.out.println("※아이디 혹은 비밀번호가 일치하지 않습니다※");
					return View.LOGIN;
					
		case 2 : 	System.out.println("┏아이디를 입력해주세요 →");
					String input3 = ScanUtil.nextLine();
					System.out.println("┏비밀번호를 입력해주세요 →");
					String input4 = ScanUtil.nextLine();
					
					String sql1 = "SELECT PER_NAME, PER_ID, PASSWORD, SUBSTR(PER_ID,1,1) FROM PERSONNEL ";
					List<Map<String, Object>>list1 = new ArrayList<>();
					list1 = jdbc.selectList(sql1);
					
						
					for(int i = 0; i < list1.size(); i++) {
						if(list1.get(i).get("PER_ID").equals(input3)
								&& list1.get(i).get("PASSWORD").equals(input4)) {
							System.out.println("┏로그인 성공!┓");
							LoginMember = list1.get(i);
							if(list1.get(i).get("SUBSTR(PER_ID,1,1)").equals("1")) {
								return View.MENU_PER_D;
							}else if(list1.get(i).get("SUBSTR(PER_ID,1,1)").equals("2")) {
								return View.MENU_PER_N;
							}
							
						}
					}
					System.out.println("┏아이디 혹은 비밀번호가 일치하지 않습니다.┓");
					return View.LOGIN;
						
		case 0 : 
			return View.HOME;
					
					
		}

			return View.LOGIN;
	}
	
//	private int join_per() {
//		System.out.println("직원 가입을 시작합니다.");
//		System.out.println("1. 병원 DB에 신상기록이 있는 경우");
//		System.out.println("2. 병원 DB에 신상기록이 없는 경우");
//		int input = ScanUtil.nextInt();
//		switch(input) {
//			case 1 : 
//				System.out.println("관리자 권한이 필요합니다. 관리자 ID로 로그인해주세요>");
//				System.out.println("아이디를 입력해주세요>");
//				String id = ScanUtil.nextLine();
//				System.out.println("비밀번호를 입력해주세요>");
//				String pw = ScanUtil.nextLine();
//				
//				Map<String, Object> map = new HashMap<>();
//				map = nd.join_per();
//				if(id.equals(map.get("PER_ID")) && pw.equals(map.get("PASSWORD"))) {
//					System.out.println("인증되었습니다.");
//					System.out.println("직원ID를 입력해주세요>");
//					String per_id = ScanUtil.nextLine();
//					System.out.println("사욯하실 비밀번호를 입력해주세요>");
//					String password = ScanUtil.nextLine();
//					
//					pd.join_pa_pwdao(per_id, password);
//					System.out.println("가입되었습니다.");
//					System.out.println("다시 로그인해주세요.");
//					return View.HOME;
//				}
//				
//			case 2 :
//				System.out.println("관리자에게 문의해 병원DB에 신상기록을 등록해주세요.");
//				return View.HOME;
//		}
//		return View.HOME;
//	}
	
	
	
}
