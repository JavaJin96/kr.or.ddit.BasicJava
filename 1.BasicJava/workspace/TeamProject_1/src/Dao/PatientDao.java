package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Controller.controller;
import Util.JDBCUtil;
import Util.ScanUtil;

public class PatientDao {
	
	private PatientDao() {}
	private static PatientDao instance;
	public static PatientDao getInstance() {
		if(instance == null) {
			instance = new PatientDao();
		}
		return instance;
	}
	
	
	private static JDBCUtil jdbc = JDBCUtil.getInstance();

	
	public List<Map<String, Object>> join_pa_dao () {
		String sql = " SELECT PAT_ID, PAT_NAME FROM PATIENTS ";
		List<Map<String, Object>> list = jdbc.selectList(sql);
		return list;
		
	}
	
	public void join_pa_pwdao(String i, String j) {
		String sql = " UPDATE PATIENTS SET PASSWORD = ? WHERE PAT_ID = ? ";
		List<Object> param = new ArrayList<>();
		param.add(i);
		param.add(j);
		jdbc.update(sql, param);
				
	}
	
	public List<Map<String, Object>> join_pa_numdao(){
		String sql = "SELECT PAT_ID, PAT_NAME, PAT_REG1 FROM PATIENTS ";
		List<Map<String,Object>>list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
		
	}
	
	public int insertRe_board() {
		// 환자 게시글 등록 부분
String sql = "INSERT INTO RE_BOARD VALUES((SELECT NVL(MAX(BOARD_NO),0)+1 FROM RE_BOARD ),"
		+ " ?, ?, (SELECT SYSDATE FROM DUAL), ?)";

System.out.print("게시글 제목 :");
String title = ScanUtil.nextLine();
System.out.print("게시글 내용 :");
String content = ScanUtil.nextLine();
List<Object>param1 = new ArrayList<>();
param1.add(title);
param1.add(content);
param1.add(controller.LoginMember.get("PAT_ID"));
return jdbc.update(sql, param1);

}







public static List<Map<String,Object>> selectBoard(int boardL){ //환자가 조회 할 게시글 리스트 목록
String sql= "    SELECT A.BOARD_NO,\r\n" + 
		"           A.TITLE,\r\n" + 
		"           B.PAT_NAME,\r\n" + 
		"           TO_CHAR(A.REG_DATE,'YY/MM/DD') AS REG_DATE \r\n" + 
		"      FROM RE_BOARD A, PATIENTS B\r\n" + 
		"     WHERE A.PAT_ID = B.PAT_ID\r\n" + 
		"     ORDER BY 1 DESC ";

List<Object> param = new ArrayList<>();
param.add(boardL);
return jdbc.selectList(sql);


		
}


public static List<Map<String, Object>>selectView(int boardI){ //환자 게시판 상세조회 내용
String sql = "    SELECT A.BOARD_NO,\r\n" + 
		"           A.TITLE,\r\n" + 
		"           B.PAT_NAME,\r\n" + 
		"           A.CONTENT, \r\n"
		+ "			A.PAT_ID,	" + 
		"           TO_CHAR(A.REG_DATE,'YY/MM/DD') AS REG_DATE\r\n" + 
		"      FROM RE_BOARD A, PATIENTS B\r\n" + 
		"     WHERE A.PAT_ID = B.PAT_ID\r\n" + 
		"       AND A.BOARD_NO = ? ";

List<Object> paran = new ArrayList<>();
paran.add(boardI);

return jdbc.selectList(sql,paran);
}

public int update(Map<String, Object> param) { //환자 게시판 수정부분.

String sql = "UPDATE RE_BOARD " + 
		"   SET TITLE = ?," + 
		"       CONTENT = ?" + 
		"  WHERE BOARD_NO = ?";

List<Object> p = new ArrayList<>();
p.add(param.get("TITLE"));
p.add(param.get("CONTENT"));
p.add(param.get("BOARD_NO"));


return jdbc.update(sql, p);

}	



public int delete(Map<String, Object> param) { //환자 게시판 삭제부분
	String sql = "DELETE"
			+ " FROM RE_BOARD "
			+ " WHERE BOARD_NO = ?";
	List<Object> p = new ArrayList<>();
	p.add(param.get("BOARD_NO"));
	
	return jdbc.update(sql, p);
	
}





public int rev(String resday) { //환자 예약 등록부분
String sql = "INSERT INTO RESERVATION" //테이블명
        + " VALUES((SELECT NVL(MAX(RES_NO),0)+1"// 날짜부분
                 + " FROM RESERVATION), ?, ?)";// 


List<Object>p = new ArrayList<>();

p.add(resday);
p.add(controller.LoginMember.get("PAT_ID"));

return jdbc.update(sql,p);
}



public static java.util.List<Map<String, Object>> revview(int boardR) { //환자 예약 리스트 부분
String sql = "SELECT A.RES_NO "
		+ "		, A.RES_DATE "
		+ "		, B.PAT_NAME "
		+ " FROM RESERVATION A, PATIENTS B"
		+ " WHERE A.PAT_ID = B.PAT_ID AND A.PAT_ID = ?"
		+ " ORDER BY 1 DESC ";
 

List<Object> param = new ArrayList<>();
param.add(boardR);

List<Object> param1 = new ArrayList<>();
param1.add(controller.LoginMember.get("PAT_ID"));

return jdbc.selectList(sql,param1);

}





	public List<Map<String , Object>> chart_con_dao() {
		String sql = "SELECT TO_CHAR(A.MED_DATE,'YYYY/MM/DD') AS MED_DATE , B.CHART_CON, B.CHART_NO FROM MEDICAL A, CHART B WHERE A.MED_NO = B.CHART_NO AND A.PAT_ID = ? ";
		List<Object> param = new ArrayList<>();
		param.add(controller.LoginMember.get("PAT_ID"));
		return jdbc.selectList(sql,param);
		
	}
	
	
	public Map<String, Object> chart_view_dao (String chartno) {
		String sql = "SELECT TO_CHAR(A.MED_DATE,'YYYY/MM/DD')  AS MED_DATE, B.CHART_CON, B.CHART_NO FROM MEDICAL A, CHART B WHERE A.MED_NO = B.CHART_NO AND B.CHART_NO = ? ";
		List<Object> param = new ArrayList<>();
		param.add(chartno);
		return jdbc.selectOne(sql, param);
	}
	
	public List<Map<String, Object>> pharm_con_dao() {
		String sql = "    SELECT A.MED_NO,\r\n" + 
				"           TO_CHAR(C.MED_DATE,'YYYY/MM/DD') AS MED_DATE ,\r\n" + 
				"           B.PHA_NAME,\r\n" + 
				"           A.PRE_MANUAL\r\n" + 
				"      FROM PRESCRIPTION A, PHARM B, MEDICAL C\r\n" + 
				"     WHERE A.PHA_CORD = B.PHA_CORD\r\n" + 
				"       AND A.MED_NO = C.MED_NO\r\n" + 
				"       AND C.PAT_ID = ?\r\n" + 
				"       AND TRUNC(C.MED_DATE) = TRUNC(SYSDATE) ";
		List<Object> param = new ArrayList<>();
		
		param.add(controller.LoginMember.get("PAT_ID"));
		return jdbc.selectList(sql,param);
	}


	public Map<String, Object> pharm_view_dao(String input){
		String sql = "SELECT A.MED_NO, B.PHA_NAME, A.PRE_MANUAL FROM PRESCRIPTION A, PHARM B WHERE A.PHA_CORD = B.PHA_CORD AND A.MED_NO = ? ";
		List<Object> param = new ArrayList<>();
		param.add(input);
		return jdbc.selectOne(sql, param);
	}



	public Map<String, Object> loginpa_res(){
		String sql = "   SELECT RES_NO, RES_DATE, PAT_ID\r\n" + 
				"      FROM\r\n" + 
				"      (SELECT RES_NO, RES_DATE, PAT_ID FROM RESERVATION WHERE PAT_ID = ? ORDER BY 1)\r\n" + 
				"      WHERE \r\n" + 
				"      ROWNUM = 1 " ;
		
		List<Object> param = new ArrayList<>();
		param.add(controller.LoginMember.get("PAT_ID"));
		return jdbc.selectOne(sql, param);
	}



	public List<Map<String, Object>> view_per_d_dao(){
		String sql = "SELECT A.PER_NAME, B.DEPARTMENT, B.CAREER, B.OFFICE, A.PER_TEL FROM PERSONNEL A, DOCTOR B WHERE A.PER_ID = B.PER_ID ";
		return jdbc.selectList(sql);
	}
	
	public List<Map<String , Object>> view_per_n_dao(){
		String sql = "SELECT A.PER_NAME, A.PER_TEL, B.JOB FROM PERSONNEL A, NURSE B WHERE A.PER_ID = B.PER_ID ";
		return jdbc.selectList(sql);
	}






}

	

	
	
	
	
	
	
	
	

