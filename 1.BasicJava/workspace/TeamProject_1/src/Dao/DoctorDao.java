package Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.controller;
import Util.JDBCUtil;
import Util.ScanUtil;

public class DoctorDao {

	private DoctorDao() {}
	private static DoctorDao instance;
	public static DoctorDao getInstance() {
		if(instance == null) {
			instance = new DoctorDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	public Map<String, Object> menu_per_n_dao(){
		String sql = "SELECT NVL(COUNT(BOARD_NO),0) AS BO FROM EMP_BOARD WHERE BOARD_NO>=1000 AND EB_FLAG LIKE '읽지%' AND TARGET like ? ";
		Map<String, Object> map = new HashMap<>();
		List<Object> param = new ArrayList<>();
		param.add(controller.LoginMember.get("PER_ID"));
		map = jdbc.selectOne(sql,param);
		return map;
	}
	
	public Map<String, Object> receipt_menushow_d_dao(){
		String sql = "SELECT COUNT(REC_NO) FROM RECEIPT ";
		return jdbc.selectOne(sql);
	}
	
	public List<Map<String, Object>> receipt_list_d_dao(){
		String sql = "SELECT A.REC_NO, B.PAT_NAME, B.PAT_ID FROM RECEIPT A, PATIENTS B WHERE A.PAT_ID = B.PAT_ID ORDER BY 1 ";
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
		
	}
	
	public int payment_cre_d_dao(int money) {
		String sql = "UPDATE PAYMENT SET MONEY = ? WHERE PAY_ID IN (SELECT MED_NO FROM MEDICAL WHERE PAT_ID = ? AND SUBSTR(SYSDATE,1,10) = SUBSTR(MED_DATE,1,10) ) ";
		List<Object> param = new ArrayList<>();
		param.add(money);
		param.add(controller.MedingPat.get("PAT_ID"));
		return jdbc.update(sql, param);
	}
	
	public List<Map<String, Object>> view_fin_d_dao() {
		String sql = "SELECT SUM(A.MONEY) AS MONEY, SUBSTR(B.MED_DATE,1,5) AS MED_DATE FROM PAYMENT A, MEDICAL B WHERE PAY_FLAG LIKE '수납완료' AND A.PAY_ID = B.MED_NO GROUP BY SUBSTR(B.MED_DATE,1,5) ";
		return jdbc.selectList(sql);
	}
	
	public Map<String, Object> med_medcon_d_dao(int i){
		String sql = "SELECT A.PAT_NAME , B.SYMPTOM , B.REC_NO, A.PAT_ID FROM PATIENTS A, RECEIPT B WHERE A.PAT_ID = B.PAT_ID AND B.REC_NO = ?" ;
		List<Object> param = new ArrayList<>();
		param.add(i);
		Map<String, Object> map = new HashMap<>();
		map = jdbc.selectOne(sql,param);
		return map;
	}
	
	public int medcre_d_dao(String con, String inout) {		
		String sql = "  INSERT INTO MEDICAL\r\n" + 
				"        VALUES('MED'||TO_CHAR(SYSDATE,'MMDD')||LPAD(TO_CHAR((SELECT NVL(MAX(SUBSTR(MED_NO,8,2)),0)\r\n" + 
				"                                                              FROM MEDICAL\r\n" + 
				"                                                             WHERE SUBSTR(MED_DATE,1,10) = SUBSTR(SYSDATE,1,10))+1),2,'0'), SYSDATE, ? , ? , ? , ?)  ";
		
		
		List<Object> param = new ArrayList<>();
		param.add(con);
		param.add(inout);
		param.add(controller.LoginMember.get("PER_ID"));
		param.add(controller.MedingPat.get("PAT_ID"));
		
		return jdbc.update(sql, param);
		
	}
	
	public int charcon_cre_d_dao (String cont) {
		String sql = "UPDATE CHART SET CHART_CON = ? WHERE CHART_NO = (SELECT MED_NO FROM MEDICAL WHERE PAT_ID = ? AND trunc(MED_DATE) = trunc(SYSDATE)) ";
		List<Object> param = new ArrayList<>();
		param.add(cont);
		param.add(controller.MedingPat.get("PAT_ID"));
		return jdbc.update(sql, param);
				
	}
	
	public int receipt_list_del_d_dao() {
		String sql = "DELETE FROM RECEIPT WHERE PAT_ID = ? ";
		List<Object> param = new ArrayList<>();
		param.add(controller.MedingPat.get("PAT_ID"));
		return jdbc.update(sql, param);
	}
	
	public List<Map<String, Object>> medpharm_d_dao (String keyword){
		String sql = "SELECT PHA_NAME, PHA_CORD, PHA_EXP FROM PHARM WHERE PHA_EXP LIKE ? ";
		List<Object> param = new ArrayList<>();
		param.add("%" + keyword + "%");
		List<Map<String, Object>> list = new ArrayList<>();
		
		list = jdbc.selectList(sql, param);
		return list;
		
	}
	
	public int medpharm_d1_dao (List<Object> list) {
		
		String sql = "    UPDATE PRESCRIPTION\r\n" + 
				"       SET PHA_CORD = (SELECT PHA_CORD FROM PHARM WHERE PHA_NAME = ?), \r\n" + 
				"           PRE_MANUAL = ?,\r\n" + 
				"           FLAG = '출력대기'\r\n" + 
				"      WHERE MED_NO IN (SELECT B.MED_NO\r\n" + 
				"                        FROM PATIENTS A, MEDICAL B \r\n" + 
				"                        WHERE A.PAT_ID = B.PAT_ID \r\n" + 
				"                         AND B.PAT_ID = ? \r\n" + 
				"                         AND SUBSTR(B.MED_DATE,1,10) = SUBSTR(SYSDATE,1,10))";
		
		List<Object> param = new ArrayList<>();
		param.add(list.get(0));
		param.add(list.get(1));
		param.add(controller.MedingPat.get("PAT_ID"));           
		return jdbc.update(sql, param);
		
		
	}
	
	public List<Map<String, Object>> board_dm_d_dao() {
		String sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, A.REG_DATE, A.PER_ID, A.TARGET, B.PER_NAME, A.EB_FLAG FROM EMP_BOARD A, PERSONNEL B WHERE NVL(A.TARGET,0) != 0 AND A.PER_ID = B.PER_ID ";
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
		
	}
	
	public Map<String, Object> board_dmview_d_dao (int i) {
		String sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, A.REG_DATE, A.PER_ID, A.TARGET, A.EB_FLAG, B.PER_NAME FROM EMP_BOARD A, PERSONNEL B WHERE A.BOARD_NO = ?";
		List<Object> param = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		param.add(i);
		map = jdbc.selectOne(sql, param);
		return map;
		
	}
	
	public int board_dmview_d_dao_1 (int i)	{
		String sql = "UPDATE EMP_BOARD SET EB_FLAG = '읽음' WHERE BOARD_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(i);
		return jdbc.update(sql, param);
	}
	
	public int board_dms_d_dao (String name, String title, String content) {
		String sql = "INSERT INTO EMP_BOARD (BOARD_NO, TITLE, CONTENT, REG_DATE, TARGET, PER_ID, EB_FLAG) "
				+ "VALUES((SELECT (NVL(MAX(SUBSTR(BOARD_NO,2)),0)+1000)+1 FROM EMP_BOARD), ?, ?, (SELECT SYSDATE FROM DUAL), ?, ?, '읽지 않음')";
		
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(name);
		param.add(controller.LoginMember.get("PER_ID"));
		return jdbc.update(sql, param);
			
	}
	
	public Map<String, Object> board_dms_d_dao1(String name){
		String sql = "SELECT PER_ID FROM PERSONNEL WHERE PER_NAME = ?";
		List<Object> param = new ArrayList<>();
		param.add(name);
		Map<String, Object> map = jdbc.selectOne(sql, param);
		return map;
	}
	
	public int board_dmdel_d_dao(Object i) {
		String sql = "DELETE FROM EMP_BOARD WHERE BOARD_NO = ? " ;
		List<Object> param = new ArrayList<>();
		param.add(i);
		return jdbc.update(sql, param);
	}
	
	public List<Map<String, Object>> board_list_d_dao() {
		String sql = "SELECT A.BOARD_NO, SUBSTR(A.TITLE,1,5) AS TITLE, A.CONTENT, TO_CHAR(A.REG_DATE,'YYYY/MM/DD/HH24') AS REG_DATE, A.PER_ID, B.PER_NAME FROM EMP_BOARD A, PERSONNEL B WHERE A.PER_ID = B.PER_ID AND A.NOTICE LIKE '일반글' ORDER BY 1 DESC ";
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
		
	}
	
	public List<Map<String, Object>> board_list_d_dao2() {
		String sql = "SELECT A.BOARD_NO, SUBSTR(A.TITLE,1,5) AS TITLE, A.CONTENT, TO_CHAR(A.REG_DATE,'YYYY/MM/DD/HH24')  AS REG_DATE, A.PER_ID, B.PER_NAME FROM EMP_BOARD A, PERSONNEL B WHERE A.PER_ID = B.PER_ID AND A.NOTICE LIKE '공지'  ORDER BY 1 DESC ";
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.selectList(sql);
		return list;
		
	}
	

	public List<Map<String, Object>> board_view_d_dao(int bn){
		String sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, TO_CHAR(A.REG_DATE,'YYYY/MM/DD/HH24')  AS REG_DATE, A.PER_ID, B.PER_NAME FROM EMP_BOARD A, PERSONNEL B WHERE BOARD_NO = ? AND A.PER_ID = B.PER_ID ";
		List<Map<String, Object>> list = new ArrayList<>();
		List<Object>param = new ArrayList<>();
		
		param.add(bn);
		list = jdbc.selectList(sql, param);
		return list;
		
	}
	
	public int board_view_del_d_dao (int i) {
		String sql = "DELETE FROM EMP_BOARD WHERE BOARD_NO = ? ";
				List<Object> param = new ArrayList<>();
				param.add(i);
				System.out.println("삭제 되었습니다.");
				return jdbc.update(sql, param);
	}
	
	public int board_view_update_d_dao(int i) {
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
	
	public int board_insert_d_dao(String title, String content) {
		String sql = "INSERT INTO EMP_BOARD(BOARD_NO, TITLE, CONTENT, REG_DATE, PER_ID, NOTICE) "
				+ " VALUES ( (SELECT (NVL(MAX(BOARD_NO),0))+1 FROM EMP_BOARD WHERE BOARD_NO < 1000), ?, ?, (SELECT SYSDATE FROM DUAL), ?, '일반글' )";
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(controller.LoginMember.get("PER_ID"));
	
		System.out.println("게시글이 등록 되었습니다.");	
		return jdbc.update(sql, param);
		
	}
	
	public int board_insert_notice_d_dao(String title, String content) {
		String sql = "INSERT INTO EMP_BOARD(BOARD_NO, TITLE, CONTENT, REG_DATE, PER_ID, NOTICE) "
				+ " VALUES ( (SELECT (NVL(MAX(BOARD_NO),0))+1 FROM EMP_BOARD WHERE BOARD_NO < 1000), ?, ?, (SELECT SYSDATE FROM DUAL), ? , '공지')";
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(controller.LoginMember.get("PER_ID"));
	
		System.out.println("게시글이 등록 되었습니다.");	
		return jdbc.update(sql, param);
		
	}
	
	public List<Map<String, Object>> manage_d_dao() {
		String sql = "SELECT PER_NAME, PER_ID, TEL, HIRE_DATE, SALARY FROM PERSONNEL";
		return jdbc.selectList(sql);
	}
	
	public Map<String, Object> man_work_d_dao(String name) {
		String sql = "SELECT B.JOB, A.PER_NAME, A.PER_ID, A.TEL, A.HIRE_DATE, A.SALARY FROM PERSONNEL A, NURSE B WHERE A.PER_NAME =? ";
		List<Object> param = new ArrayList<>();
		param.add(name);
		return jdbc.selectOne(sql, param);
	}
	
	public int man_word_d_dao2(String job, String name) {
		String sql = "UPDATE NURSE SET JOB = ? WHERE PER_ID = (SELECT PER_ID FROM PERSONNEL WHERE PER_NAME = ?) ";
		List<Object> param = new ArrayList<>();
		param.add(job);
		param.add(name);
		return jdbc.update(sql, param);
	}
	
	public int man_sal_d_dao(int salary, String name) {
		String sql = "UPDATE PERSONNEL SET SALARY = ? WHERE PER_NAME = ? ";
		List<Object> param = new ArrayList<>();
		param.add(salary);
		param.add(name);
		return jdbc.update(sql, param);
	}
	
	public int join_per_d_dao(int job, String name, String per_tel, String tel, String password, int salary) {
		String sql = " INSERT INTO PERSONNEL\r\n" + 
				"        VALUES(TO_CHAR(?)||TO_CHAR(SYSDATE,'YYYYMMDD')||LPAD(TO_CHAR((SELECT NVL(MAX(SUBSTR(PER_ID,10,1)),0)\r\n" + 
				"                                                                        FROM PERSONNEL\r\n" + 
				"                                                                       WHERE SUBSTR(PER_ID,1,9) = TO_CHAR(?)||TO_CHAR(SYSDATE,'YYYYMMDD'))+1),1,'0'),"
				+ "																		 ?, ?, ?, ?, SYSDATE, ? ) ";
		List<Object> param = new ArrayList<>();
		param.add(job);
		param.add(job);
		param.add(name);
		param.add(per_tel);
		param.add(tel);
		param.add(password);
		param.add(salary);
		return jdbc.update(sql, param);
	}
	
	
	public int manage_changemyinf_d_dao(String name, String tel, String password) {
		String sql = "UPDATE PERSONNEL SET PER_NAME = ?, TEL = ?, PASSWORD = ? WHERE PER_ID = ? ";
		List<Object> param = new ArrayList<>();
		param.add(name);
		param.add(tel);
		param.add(password);
		param.add(controller.LoginMember.get("PER_ID"));
		return jdbc.update(sql, param);
	}
	
	public int manage_changemytime_d_dao(String day, String time) {
		String sql = "UPDATE CALENDAR SET DAY = ?, TIME = ? WHERE PER_ID = ? ";
		List<Object> param = new ArrayList<>();
		param.add(day);
		param.add(time);
		param.add(controller.LoginMember.get("PER_ID"));
		return jdbc.update(sql, param);
	}
	
	public int manage_changemyst_d_dao(String dep, String office, String care) {
		String sql = "UPDATE DOCTOR SET DEPARTMENT = ?, OFFICE = ?, CAREER = ? WHERE PER_ID = ? ";
		List<Object> param = new ArrayList<>();
		param.add(dep);
		param.add(office);
		param.add(care);
		param.add(controller.LoginMember.get("PER_ID"));
		return jdbc.update(sql, param);
	}
	
	
	
	
	
	
	
	
	
}
