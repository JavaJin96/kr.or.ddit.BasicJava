package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import oracle.sql.ARRAY;
import service.UserService;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class BoardDao {
	//싱글톤 패턴
		private BoardDao() {}
		private static BoardDao instance;
		public static BoardDao getInstance() {
			if(instance == null) {
				instance = new BoardDao();
			}
			return instance;
		}
		
		
		private JDBCUtil jdbc = JDBCUtil.getInstance();
		
		public List<Map<String, Object>> selectBoardList(){
			String sql = "SELECT A.BOARD_NO, A.TITLE, A.MEM_ID, TO_CHAR(A.REG_DATE, 'MM-DD') AS REG_DATE"
					+ " FROM TB_JDBC_BOARD A"
					+ " LEFT OUTER JOIN TB_JDBC_MEMBER B ON A.MEM_ID = B.MEM_ID"
					+ " ORDER BY 1 DESC ";
			
			return jdbc.selectList(sql);
		}
		
		public List<Map<String, Object>> detailBoardView(int i){
			String sql = "SELECT BOARD_NO, TITLE, MEM_ID, TO_CHAR(REG_DATE), CONTENT "
					+ " FROM TB_JDBC_BOARD "
					+ " WHERE BOARD_NO = ? ";
			
			List<Object> param = new ArrayList<Object>();
			param.add(i);
			return jdbc.selectList(sql, param);
				
		}
		
		public int BoardUpdate(String title, String content, int i){
			String sql = "UPDATE TB_JDBC_BOARD SET TITLE = ?, CONTENT = ? "
					+ " WHERE BOARD_NO = ? ";

			
			List<Object> param = new ArrayList<>();
			param.add(title);
			param.add(content);
			param.add(i);
			
			return jdbc.update(sql, param);
			
			
		}
		
		public int BoardDelete(int i) {
			String sql = " DELETE FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";
			
			List<Object> param = new ArrayList<>();
			param.add(i);
			jdbc.update(sql, param);
			System.out.println("삭제되었습니다.");
			
			return View.BOARD_LIST;
			
			
		}
		
		public int BoardInsert() {
			String sql = " INSERT INTO TB_JDBC_BOARD (BOARD_NO, TITLE, CONTENT, MEM_ID, REG_DATE ) VALUES ( (SELECT MAX(BOARD_NO)+1 FROM TB_JDBC_BOARD),?,?,?,(SELECT SYSDATE FROM DUAL )) ";
			
			System.out.println("제목을 입력해주세요>");
			String title = ScanUtil.nextLine();
			
			System.out.println("내용을 입력해주세요>");
			String content = ScanUtil.nextLine();
			
			List<Object> param = new ArrayList<>();
			param.add(title);
			param.add(content);
			param.add(Controller.LoginMember.get("MEM_ID"));
			
			jdbc.update(sql, param);
			System.out.println("글이 등록되었습니다.");
			
			return View.BOARD_LIST;
			
		}
		
		
		
		
		
		
		
		
		
		
		
}
