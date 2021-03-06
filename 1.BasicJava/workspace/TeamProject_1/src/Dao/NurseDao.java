package Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.controller;
import Service.NurseService;
import Util.JDBCUtil;
import Util.ScanUtil;

public class NurseDao {

	private NurseDao() {}
	private static NurseDao instance;
	public static NurseDao getInstance() {
		if(instance == null) {
			instance = new NurseDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public Map<String, Object> join_per(){

		
		String sql = "SELECT PER_ID, PASSWORD FROM PERSONNEL WHERE PER_ID LIKE '0%' ";
		Map<String, Object> map = new HashMap<>();
		map = jdbc.selectOne(sql);
		return map;
	}
	
	
	public Map<String, Object> menu_per_n_dao(){
		String sql = "SELECT NVL(COUNT(BOARD_NO),0) AS BO FROM EMP_BOARD WHERE BOARD_NO>=1000 AND EB_FLAG LIKE '읽지%' AND TARGET like ? ";
		Map<String, Object> map = new HashMap<>();
		List<Object> param = new ArrayList<>();
		param.add(controller.LoginMember.get("PER_ID"));
		map = jdbc.selectOne(sql,param);
		return map;
	}
	
	public List<Map<String, Object>> receipt_n_dao(){
		String sql = "SELECT A.REC_NO, B.PAT_NAME FROM RECEIPT A, PATIENTS B WHERE A.PAT_ID = B.PAT_ID ORDER BY 1 ";
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
	}
	
	public List<Map<String, Object>> receipt_n_dao_2(){
		String sql = " SELECT A.RES_DATE, B.PAT_NAME FROM RESERVATION A, PATIENTS B WHERE A.PAT_ID = B.PAT_ID AND SUBSTR(A.RES_DATE,9,2) = to_char(SYSDATE,'dd') ORDER BY 1 ";
		
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
	}
	
	// 예약시간 되면 접수 테이블로 이동하는 쿼리 작성하기
	
	public List<Map<String, Object>> receipt_sort_n(String name){
		String sql = "SELECT * FROM PATIENTS WHERE PAT_NAME = ? ";
		List<Map<String, Object>>list = new ArrayList<>();
		List<Object> param = new ArrayList<>();
		param.add(name);
		list = jdbc.selectList(sql, param);
		return list;
	}
	
	public List<Map<String, Object>> receipt_view_n_dao(String patid) {
		String sql = "SELECT PAT_NAME, PAT_ID, PAT_REG1, PAT_REG2, PAT_ADDR, PAT_TEL, PASSWORD FROM PATIENTS WHERE PAT_ID = ? " ; 
		List<Object> param = new ArrayList<>();
		param.add(patid);
		return jdbc.selectList(sql, param);
	}
	
	public Map<String, Object> menu_per_print_n_dao() {
		String sql = "SELECT COUNT(MED_NO) FROM PRESCRIPTION WHERE FLAG LIKE '출력대기' ";
		return jdbc.selectOne(sql);
	}
	
	public int receipt_cre_n_dao(List<Map<String,Object>> list) {
		String sql = "INSERT INTO RECEIPT VALUES ((SELECT NVL(MAX(REC_NO),0)+1 FROM RECEIPT),?,(SELECT SYSDATE FROM DUAL),?)";
		List<Object>param = new ArrayList<>();
		System.out.println("증상을 입력해주세요 >");
		param.add(ScanUtil.nextLine());
		param.add(list.get(0).get("PAT_ID"));
		int result = jdbc.update(sql, param);
		System.out.println("등록 되었습니다.");
		return result;
	}
	
	public int receipt_res_cre_n_dao () {
		System.out.println("등록할 예약 환자의 이름을 입력해주세요.>");
		String name = ScanUtil.nextLine();
		System.out.println("환자의 증상을 입력해주세요.>");
		String sym = ScanUtil.nextLine();
		
		String sql = "    SELECT A.RES_DATE,\r\n" + 
				"           B.PAT_NAME,\r\n"
				+ "			B.PAT_ID " + 
				"      FROM RESERVATION A, PATIENTS B\r\n" + 
				"     WHERE A.PAT_ID = B.PAT_ID\r\n" + 
				"       AND SUBSTR(A.RES_DATE,9,2) = TO_CHAR(SYSDATE,'DD')"
				+ "     AND B.PAT_NAME = ? " ;
		List<Object> param1 = new ArrayList<>();
		param1.add(name);
		List<Map<String , Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql, param1);
		
		String sql2 = "INSERT INTO RECEIPT VALUES ((SELECT NVL(MAX(REC_NO),0)+1 FROM RECEIPT), ?, SYSDATE, ? )" ;
		List<Object> param = new ArrayList<>();
		param.add(sym);
		param.add(list.get(0).get("PAT_ID"));
		
		String sql3 = "DELETE FROM RESERVATION WHERE SUBSTR(RES_DATE,9,2) = TO_CHAR(SYSDATE,'DD') AND PAT_ID = ?  " ;
		List <Object>param3 = new ArrayList<>();
		param3.add(list.get(0).get("PAT_ID"));
		jdbc.update(sql3, param3);
		
		return jdbc.update(sql2, param);
		
		
	}
	
	public List<Map<String, Object>> print_n_dao() {
		String sql = "SELECT A.PAT_ID, B.MED_NO, B.FLAG FROM MEDICAL A, PRESCRIPTION B WHERE A.MED_NO = B.MED_NO AND B.FLAG LIKE '출력대기'";
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
		
	}
	
	public int print_n_dao1() {
		String sql = "UPDATE PRESCRIPTION SET FLAG = '출력됨'";
		int result = jdbc.update(sql);
		return result;
	}
	
	public List<Map<String, Object>> board_list_n_dao() {
		String sql = "SELECT A.BOARD_NO, SUBSTR(A.TITLE,1,5) AS TITLE, A.CONTENT, TO_CHAR(A.REG_DATE,'YYYY/MM/DD/HH24')  AS REG_DATE, A.PER_ID, B.PER_NAME FROM EMP_BOARD A, PERSONNEL B WHERE A.PER_ID = B.PER_ID AND A.NOTICE LIKE '일반글' ORDER BY 1 DESC ";
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
		
	}
	
	public List<Map<String, Object>> board_list_n_dao2() {
		String sql = "SELECT A.BOARD_NO, SUBSTR(A.TITLE,1,5) AS TITLE, A.CONTENT, TO_CHAR(A.REG_DATE,'YYYY/MM/DD/HH24')  AS REG_DATE, A.PER_ID, B.PER_NAME FROM EMP_BOARD A, PERSONNEL B WHERE A.PER_ID = B.PER_ID AND A.NOTICE LIKE '공지'  ORDER BY 1 DESC ";
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
		
	}
	
	public List<Map<String, Object>> board_view_n_dao(int bn){
		String sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, TO_CHAR(A.REG_DATE,'YYYY/MM/DD/HH24')  AS REG_DATE, A.PER_ID, B.PER_NAME FROM EMP_BOARD A, PERSONNEL B WHERE BOARD_NO = ? AND A.PER_ID = B.PER_ID ";
		List<Map<String, Object>> list = new ArrayList<>();
		List<Object>param = new ArrayList<>();
		
		param.add(bn);
		list = jdbc.selectList(sql, param);
		return list;
		
	}
	
	public int board_view_del_n_dao (int i) {
		String sql = "DELETE FROM EMP_BOARD WHERE BOARD_NO = ? ";
				List<Object> param = new ArrayList<>();
				param.add(i);
				System.out.println("삭제 되었습니다.");
				return jdbc.update(sql, param);
	}
	
	public int board_view_update_n_dao(int i) {
		String sql = "UPDATE EMP_BOARD SET TITLE = ? , CONTENT = ?, (SELECT SYSDATE FROM DUAL) WHERE BOARD_NO = ? ";
		List<Object> param = new ArrayList<>();
		System.out.println("변경할 제목을 입력해주세요 >");
		String title = ScanUtil.nextLine();
		System.out.println("변경할 내용을 입력해주세요 >");
		String content = ScanUtil.nextLine();
		
		param.add(title);
		param.add(content);
		param.add(i);
		
		System.out.println("수정되었습니다.");
		return jdbc.update(sql, param);
	}
	
	public int board_insert_n_dao(String title, String content) {
		String sql = "INSERT INTO EMP_BOARD(BOARD_NO, TITLE, CONTENT, REG_DATE, PER_ID, NOTICE) "
				+ " VALUES ( (SELECT (NVL(MAX(BOARD_NO),0))+1 FROM EMP_BOARD WHERE BOARD_NO < 1000), ?, ?, (SELECT SYSDATE FROM DUAL), ?, '일반글' )";
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(controller.LoginMember.get("PER_ID"));
	
		System.out.println("게시글이 등록 되었습니다.");	
		return jdbc.update(sql, param);
	}
	
	public int receipt_newpat_n_dat(String name, String[] regno, String addr, String tel) {
		String sql = "  INSERT INTO PATIENTS " + 
				"        VALUES(TO_CHAR(SYSDATE,'YYYYMMDD')||LPAD(TO_CHAR((SELECT NVL(MAX(SUBSTR(PAT_ID,9,2)),0) " + 
				"                                                            FROM PATIENTS " + 
				"                                                           WHERE SUBSTR(PAT_ID,1,8) = TO_CHAR(SYSDATE,'YYYYMMDD'))+1),2,'0'), ?, ?, ?, ?, ?, '') ";
		
		List<Object> param = new ArrayList<>();
		param.add(name);
		param.add(regno[0]);
		param.add(regno[1]);
		param.add(addr);
		param.add(tel);
		
		return jdbc.update(sql, param);
		
		
	}
	
	public List<Map<String, Object>> receipt_pay_n_dao() {
		String sql = " SELECT C.PAT_NAME,\r\n" + 
				"           A.MONEY,\r\n"
				+ "         A.PAY_ID" +
				"      FROM PAYMENT A, MEDICAL B, PATIENTS C\r\n" + 
				"     WHERE A.PAY_ID = B.MED_NO\r\n" + 
				"       AND B.PAT_ID = C.PAT_ID\r\n" + 
				"       AND A.PAY_FLAG LIKE '수납대기%' ";
		return jdbc.selectList(sql);
	}
	
	public Map<String, Object> receipt_paying_n_dao (String name) {
		String sql = " SELECT B.MED_NO, C.PAT_NAME,\r\n" + 
				"           A.MONEY, \r\n"
				+ "         A.PAY_ID " + 
				"      FROM PAYMENT A, MEDICAL B, PATIENTS C\r\n" + 
				"     WHERE A.PAY_ID = B.MED_NO\r\n" + 
				"       AND B.PAT_ID = C.PAT_ID\r\n" + 
				"       AND A.PAY_FLAG LIKE '수납대기' "
				+ "     AND C.PAT_NAME LIKE ? ";
		List<Object> param = new ArrayList<>();
		param.add(name);
		return jdbc.selectOne(sql, param);
	}
	
	public int receipt_paying_n_dao1(Object payid) {
		String sql = "UPDATE PAYMENT SET PAY_FLAG = '수납완료' WHERE PAY_ID = ? " ;
		List<Object> param = new ArrayList<>();
		param.add(payid);
		return jdbc.update(sql, param);
	}
	
	public Map<String, Object> receipt_menushow_n_dao () {
		String sql = "SELECT COUNT(PAY_ID) FROM PAYMENT WHERE PAY_FLAG LIKE '수납대기' " ;
		return jdbc.selectOne(sql);
	}
	
	public List<Map<String, Object>> board_dm_n_dao() {
		String sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, A.REG_DATE, A.PER_ID, A.TARGET, B.PER_NAME, A.EB_FLAG FROM EMP_BOARD A, PERSONNEL B WHERE NVL(A.TARGET,0) != 0 AND A.PER_ID = B.PER_ID ";
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
		
	}
	
	public Map<String, Object> board_dmview_n_dao (int i) {
		String sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, A.REG_DATE, A.PER_ID, A.TARGET, A.EB_FLAG, B.PER_NAME FROM EMP_BOARD A, PERSONNEL B WHERE A.BOARD_NO = ?";
		List<Object> param = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		param.add(i);
		map = jdbc.selectOne(sql, param);
		return map;
		
	}
	
	public int board_dmview_n_dao_1 (int i)	{
		String sql = "UPDATE EMP_BOARD SET EB_FLAG = '읽음' WHERE BOARD_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(i);
		return jdbc.update(sql, param);
	}
	
	public int board_dms_n_dao (String name, String title, String content) {
		String sql = "INSERT INTO EMP_BOARD (BOARD_NO, TITLE, CONTENT, REG_DATE, TARGET, PER_ID, EB_FLAG) "
				+ "VALUES((SELECT (NVL(MAX(SUBSTR(BOARD_NO,2)),0)+1000)+1 FROM EMP_BOARD WHERE BOARD_NO > 1000 ), ?, ?, (SELECT SYSDATE FROM DUAL), ?, ?, '읽지 않음')";
		
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(name);
		param.add(controller.LoginMember.get("PER_ID"));
		return jdbc.update(sql, param);
			
	}
	
	public Map<String, Object> board_dms_n_dao1(String name){
		String sql = "SELECT PER_ID FROM PERSONNEL WHERE PER_NAME = ?";
		List<Object> param = new ArrayList<>();
		param.add(name);
		Map<String, Object> map = jdbc.selectOne(sql, param);
		return map;
	}
	
	public int board_dmdel_n_dao(Object i) {
		String sql = "DELETE FROM EMP_BOARD WHERE BOARD_NO = ? " ;
		List<Object> param = new ArrayList<>();
		param.add(i);
		return jdbc.update(sql, param);
	}

	
	public List<Map<String, Object>> inpa_list_n_dao() {
		String sql = "  SELECT C.PAT_NAME,\r\n" + 
				"           A.MED_NO,\r\n"
				+ "         B.INOUT" + 
				"      FROM INPATIENT A, MEDICAL B, PATIENTS C\r\n" + 
				"     WHERE A.MED_NO = B.MED_NO\r\n" + 
				"       AND B.PAT_ID = C.PAT_ID\r\n" + 
				"       AND NVL(A.ROOM,0) = 0 ";
		return jdbc.selectList(sql);
	}
	
	public int inpa_list_n_dao1(int room, String med_no) {
		String sql = " UPDATE INPATIENT SET ROOM = ? WHERE MED_NO = ?  ";
		List<Object> param = new ArrayList<>();
		param.add(room);
		param.add(med_no);
		return jdbc.update(sql, param);
	}
	
	
	
	public Map<String, Object> manage_n_dao() {
		String sql = "SELECT * FROM PERSONNEL WHERE PER_ID = ? ";
		List<Object> param = new ArrayList<>();
		param.add(controller.LoginMember.get("PER_ID"));
		return jdbc.selectOne(sql, param);
	}
	
	public int manage_changemyinf_n_dao(String name, String tel, String password) {
		String sql = "UPDATE PERSONNEL SET PER_NAME = ?, TEL = ?, PASSWORD = ? WHERE PER_ID = ? ";
		List<Object> param = new ArrayList<>();
		param.add(name);
		param.add(tel);
		param.add(password);
		param.add(controller.LoginMember.get("PER_ID"));
		return jdbc.update(sql, param);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
