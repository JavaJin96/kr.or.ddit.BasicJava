package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.controller;
import Dao.PatientDao;
import Util.ScanUtil;
import Util.View;

public class PatientService {

	private PatientService() {}
	private static PatientService instance;
	public static PatientService getInstance() {
		if(instance == null) {
			instance = new PatientService();
		}
		return instance;
	}
	
	int chartL = 0;
	int boardI = 0;
	int boardN = 0;
	int boardT = 0;
	int boardR = 0;
	String Dele = null;
	
	private PatientDao pd = PatientDao.getInstance();
	
	public int join_pa() {
		System.out.println("┏대덕인재병원 환자등록을 시작합니다.┓");
		System.out.println("┏1. 나의 환자 번호를 아는경우┓");
		System.out.println("┏2. 나의 환자 번호를 모르는 경우┓");
		int input = ScanUtil.nextInt();
		switch(input) {
			case 1:
			System.out.println("┏환자 번호를 입력해주세요→");
			int panum = ScanUtil.nextInt();
			
			List<Map<String, Object>>list = pd.join_pa_dao();
			for(int i = 0; i < list.size(); i++) {
				if(panum == Integer.parseInt(String.valueOf(list.get(i).get("PAT_ID")))) {
					System.out.println("┏성함을 입력해주세요→");
					String paname = ScanUtil.nextLine();
					if(list.get(i).get("PAT_NAME").equals(paname)) {
						System.out.println("┏본인확인완료┓");
						System.out.println("┏사용하실 비밀번호를 입력해주세요┓");
						String pw = ScanUtil.nextLine();
						pd.join_pa_pwdao(pw, (String)list.get(i).get("PAT_ID"));
						System.out.println("┏가입 완료 되었습니다.┓");
						System.out.println("┏ID는 회원번호 입니다.┓");
						System.out.println("┏새롭게 로그인 해주세요.┓");
						return View.HOME;
						
					}
				}
			}
				System.out.println("※일치하는 환자 번호가 없습니다※");
				System.out.println("┏다시 한번 확인해주세요.┓");
				return View.HOME;
			
			
			case 2:
			System.out.println("┏환자 이름을 입력해주세요→");
			String paname = ScanUtil.nextLine();
			System.out.println("┏주민번호 앞자리를 입력해주세요→");
			int paregno1 = ScanUtil.nextInt();
			
			List<Map<String, Object>> list1 = pd.join_pa_numdao();
			for(int i = 0; i < list1.size(); i++) {
				if(list1.get(i).get("PAT_NAME").equals(paname) && Integer.parseInt(String.valueOf(list1.get(i).get("PAT_REG1"))) == paregno1) {
					System.out.println("┏본인확인완료!");
					System.out.println("┏사용하실 비밀번호를 입력해주세요→");
					String pw = ScanUtil.nextLine();
					pd.join_pa_pwdao(pw, (String)list1.get(i).get("PAT_ID"));
					System.out.println("┏가입 완료 되었습니다!┓");
					System.out.println("┏ID는 환자번호 이며," + list1.get(i).get("PAT_NAME") + "님의 환자번호는 " + list1.get(i).get("PAT_ID") + "입니다.┓");
					System.out.println("┏새롭게 로그인 해주세요.┓");
					return View.HOME;
				}
			}
			System.out.println("※일치하는 환자 번호가 없습니다※");
			System.out.println("┏다시 한번 확인해주세요┓");
			return View.HOME;
			
			
			
				
				
		}
		return View.HOME;
		
	}
	
	
	public int loginPa() {
		
		Map<String, Object> map = new HashMap<>();
		map = pd.loginpa_res();
		System.out.println("\n");
		
		System.out.println(controller.LoginMember.get("PAT_NAME") + "님 의 빠른 쾌유를 바랍니다.");	
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");	
		try {
	System.out.println(" 다음 예약일 → " + map.get("RES_DATE") );
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		}catch (Exception e) {
			
			System.out.println("다음 예약일 ●");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		}
	System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");	
	System.out.print("1.차트\t2.처방전 조회\t3.환자게시판\t4.진료예약\n5.의료진조회\t0.로그아웃");
	System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("┏원하는 내역을 선택해주세요 . →");
	int input = ScanUtil.nextInt();
	
	
	switch (input) {
	case 1 :
		return View.CHART_LIST; //1. 차트 들어가서 확인할수있는 내용 
	case 2:
		return View.PHARM_VIEW; //2. 처방전 조회 들어가서 확인할수 있는내용
	case 3:
		return View.RE_BOARD_LIST; //3. 환자 게시판 목록
	case 4:
		return View.RESERVATION;
	case 5:
		return View.VIEW_PER;
	case 0:
		System.out.println("\n┏감사합니다 . 다음에 또 방문해주세요 .┓");
		return View.HOME;
	
	  }
	return input;
	}
	
	
	public int chart() {
		
		List<Map<String , Object>> list = new ArrayList<>();
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("Chart List.");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("날짜\t\t진료번호\t");
	// 불러올 차트 채워넣어야 할곳
		list = pd.chart_con_dao();
		for(int i = 0; i < list.size(); i ++) {
			System.out.print(list.get(i).get("MED_DATE") + "\t");
			System.out.println(list.get(i).get("CHART_NO") + "\t");
		}
		System.out.print("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("\n┏1.조회\t0.뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			return View.CHART_VIEW;
		case 0:
			return View.MENU_PA;

		
		 }
		return 0;
	}
	
	public int chart_view() {
		System.out.println("┏조회하실 차트번호를 입력해주세요.→");
		String chartno = ScanUtil.nextLine();
		Map<String, Object> map = new HashMap<>();
		map = pd.chart_view_dao(chartno);
		System.out.println("┏차트내용조회┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(map.get("CHART_NO"));
		System.out.println(map.get("CHART_CON"));
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏0. 뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 0 : return View.MENU_PA;
		}
	    return View.MENU_PA;
	}
	
	
	
	public int pharm() {
		List<Map<String, Object>> list = new ArrayList<>();
		list = pd.pharm_con_dao();
		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("prescription.");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┏날짜\t\t처방전번호┓");
		//불러올 처방전 채워넣는곳
		for(int i = 0 ; i < list.size(); i++) {
			System.out.print(list.get(i).get("MED_DATE") + "\t");
			System.out.println(list.get(i).get("MED_NO"));
		}
		System.out.print("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("\n┏1.조회\t0.뒤로가기┓");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			return View.PHARM_DETAILVIEW;
		case 0:
			return View.MENU_PA;	
		
		
		}
		return 0;
	}
	
	public int pharm_view() {
		System.out.println("┏조회하실 처방전의 처방번호를 입력해주세요.┓→");
		String input = ScanUtil.nextLine();
		Map<String, Object> map = new HashMap<>();
		map = pd.pharm_view_dao(input);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(map.get("MED_NO") );
		System.out.println(map.get("PHA_NAME") + "\t" + map.get("PRE_MANUAL"));
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏0. 뒤로가기┓");
		int input1 = ScanUtil.nextInt();
		switch(input1) {
		case 0 : return View.MENU_PA;
		}
		return View.MENU_PA;
	}
	
		
	
	
	public int board() {
		
		List<Map<String, Object>> board = PatientDao.selectBoard(chartL); //환자 게시판 목록 
	System.out.println("┏게시판에 오신걸 환영 합니다.┓ ");
	System.out.println("※따듯한 말 한마디가 모두에게 힘이됩니다.");
	System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
	System.out.println("글번호\t제목\t회원번호\t\t날짜");
	System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	for(int i = 0 ; i < board.size(); i++) {
		Map<String, Object> board1 = board.get(i);
		System.out.print(board1.get("BOARD_NO")+"\t");
		System.out.print(board1.get("TITLE")+"\t");
		System.out.print(board1.get("PAT_NAME")+"\t");
		System.out.println(board1.get("REG_DATE")+ "\t");
	}
	System.out.print("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	System.out.println("\n┏환자 전용 게시판 ┓");
	System.out.println("\n┗1.조회\t2.등록\t0.뒤로가기━");
	
	int input = ScanUtil.nextInt();
	switch(input) {
	case 1:
		return View.RE_BOARD_VIEW;
	case 2:
		return View.RE_BOARD_INSERT;
	case 0:
		return View.MENU_PA;	
		
		
		
		}
	return 0;
	}
	
	
	
public int boardv() {
		
		System.out.println("┏조회할 게시물 번호를 입력해주세요.┓"); //환자 게시판 리스트
		System.out.println("┏조회 번호 :");
	     boardN = ScanUtil.nextInt();
		
		List<Map<String, Object>>boardv = PatientDao.selectView(boardN);
		for(int i = 0; i< boardv.size(); i++) {
				Map<String, Object> board = boardv.get(i);
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("번호 :\t"+ board.get("BOARD_NO"));
				System.out.println("작성자 :\t"+ board.get("PAT_NAME"));
				System.out.println("작성일 :\t"+ board.get("REG_DATE"));
				System.out.println("제목 :\t"+ board.get("TITLE"));
				System.out.println("내용 :\t"+ board.get("CONTENT"));
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				if(board.get("PAT_ID").equals(String.valueOf(controller.LoginMember.get("PAT_ID")))) {
					System.out.print("┏1. 수정 2. 삭제┓");
				}
				}
		

		System.out.println("┏3.목록 0.홈화면┓");
		int input = ScanUtil.nextInt();
		switch(input){
		case 1:
			return View.RE_BOARD_UPDATE;
		case 2:
			return View.RE_BOARD_DELETE;
			case 3:
		return View.RE_BOARD_LIST;
		
		case 0:
	    return View.MENU_PA;
	    
		}
		return (0);		
	}


public int boardi() { //환자 게시판 등록 부분
	System.out.println("┏게시글 등록┓");
	System.out.println("※게시판 작성시 따듯한 말한마디가 모두에게 큰 기쁨이 됩니다.\n");
    int result = pd.insertRe_board(); //이결과는 영향받은 행의갯수
	
	if(result == 0) {
		System.out.println("※게시글 등록 실패※");
		return View.RE_BOARD_LIST;
	}
	else{
		System.out.println("┏게시글 등록 성공┓");
		return View.RE_BOARD_LIST;
	}
}


public int update() {  //환자 게시판 글수정
System.out.println("┏게시글 수정]┓");
System.out.println("※비속어 및 욕설 사용금지※");
System.out.println("┏수정할 제목을 입력해주세요 → ");
String title = ScanUtil.nextLine();
System.out.println("┏수정할 내용을 입력해주세요→  ");
String content = ScanUtil.nextLine();

Map<String, Object>  param = new HashMap<>();
param.put("TITLE", title);
param.put("CONTENT", content);
param.put("BOARD_NO", boardN);

int result = pd.update(param);

if(result == 1) {
	
	System.out.println("┏수정되었습니다.┓");
	return View.RE_BOARD_LIST;
  }
  else {
	System.out.println("※수정에 실패하였습니다※");
	return View.RE_BOARD_LIST;
	
  }
 }

public int delete(){ //환자게시판 삭제부분
System.out.println("┏게시판을 정말 삭제 하시겠습니까 ?┓");
System.out.println("┏삭제를 원할시 (Y) 입력.┓");
System.out.println("┏원하지 않을시 (N) 입력.┓");
Dele = ScanUtil.nextLine();

if( Dele.equalsIgnoreCase("Y")) {
	Map<String, Object> param = new HashMap<>();	
	param.put("BOARD_NO", boardN);
	int result = pd.delete(param);
	if(result == 1) {
		System.out.println("┏게시글이 삭제되었습니다.┓");
		return View.RE_BOARD_LIST;
	}
}else {
	System.out.println("※게시글 삭제를 취소하였습니다※\n");
	return View.RE_BOARD_LIST;
}
return(0);
}


public int Reservation(){
	//환자 예약 리스트 부분

System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
System.out.println("번호\t예약날짜\t\t환자번호");
System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

List<Map<String, Object>>boardr = PatientDao.revview(boardR);
for(int i = 0; i< boardr.size(); i++) {
		Map<String, Object> board = boardr.get(i);
		
System.out.println("예약번호 :\t"+ board.get("RES_NO"));
System.out.println("예약날짜 :\t"+ board.get("RES_DATE"));
System.out.println("예약환자 :\t"+ board.get("PAT_NAME"));
System.out.println("---------------------------------------");
}
System.out.println("┏1.예약 등록하기 0.돌아가기┓");
System.out.println("┗빠른 진료를 도와드리겠습니다┛");
int i = ScanUtil.nextInt();
switch(i) {
case 1:
	return View.REV_REV;
	
case 0 :
	return View.MENU_PA;
}

return View.MENU_PA;

}
	

public int rev() {
  System.out.println("┏환자 예약┓"); //예약부분
  System.out.println("┏예약을 환영합니다┓");
  System.out.println("※예약 가능날짜 확인 ex) 0000/00/00/00");
  System.out.println("┏예약 등록할  날짜를 입력해주세요.┓");
  String res = ScanUtil.nextLine();
  
  String res1 [] = res.split("/");
  if(Integer.parseInt(res1[3]) > 9 && Integer.parseInt(res1[3]) < 18 ) {
	  pd.rev(res);
	  System.out.println("┏예약되었습니다.┓");
	  return View.MENU_PA;
  }
  else {
	  System.out.println("※예약시간을 다시 확인해주세요※");
	  return View.MENU_PA;
  }
  
  
}



	public int view_per() {
		System.out.println("┏대덕인재병원 의료진 현황┓");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		List<Map<String, Object>> list = new ArrayList<>();
		list = pd.view_per_d_dao();
		System.out.println("┏의사 현황┓");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).get("PER_NAME") + "\t");
			System.out.print(list.get(i).get("PER_TEL") + "\t");
			System.out.print(list.get(i).get("DEPARTMENT") + "\t");
			System.out.print(list.get(i).get("CAREER") + "\t");
			System.out.println(list.get(i).get("OFFICE") + "\t");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		}
		List<Map<String, Object>> list1 = new ArrayList<>();
		list1 = pd.view_per_n_dao();
		System.out.println("간호사 현황");
		for(int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i).get("PER_NAME") + "\t");
			System.out.print(list1.get(i).get("PER_TEL") + "\t");
			System.out.println(list1.get(i).get("JOB") + "\t");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		}
		return View.MENU_PA;
		
		
	}






}  

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

