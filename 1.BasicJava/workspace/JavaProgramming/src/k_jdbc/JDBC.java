package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) {
		/*
		 *  JDBC(Java Datebase Connectivity)
		 *   - 자바와 데이터베이스를 연결해주는 라이브러리
		 *   - ojdbc : 오라클 JDBC
		 *   
		 *  JDBC 작성 단계
		 *   1. Connection 생성(DB연결)
		 *   2. Statement 생성(쿼리 작성)
		 *   3. Query 실행
		 *   4. ResultSet 에서 결과 추출(select 인 경우)
		 *   5. ResultSet, Statement, Connection 닫기
		 */
		
		
		// 데이터베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//@왼쪽 : 드라이버       @오른쪽 : 주소(오라클 내계정 - 속성 - 에서 호스트이름, 포트 ,서비스이름으로 구성)
		String user = "psj96";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password); //오라클과 연결
			
			String sql = "select * from member";
			ps = con.prepareStatement(sql); //""안에 기술된 쿼리를 객체로 만들었음
			
			//실행
			//select인경우
			rs = ps.executeQuery();
			
			//insert, delete, update
//			int result = ps.executeUpdate();
			
			while(rs.next()) { // .next resultSet 은 테이블 형식으로 있다. next를 한번 호출해줘야 값을 추출할 수 있다. 
								//(결과의 첫번째 줄을 바라볼 수 있게 된다. 그래서 결과의 첫번재 줄 부터 추출을 할 수 있게 된다.)
				String memId = rs.getString(1); // 컬럼의 인덱스를 파라미터로 넣어줌
				String memPass = rs.getString("MEM_PASS"); // 컬럼명을 파라미터로 넣어줌
				System.out.println("MEM_ID : " + memId + "/ MEM_PASS : " + memPass);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//driver : 서로 다른 것들 간에 연결고리
		finally {
			if(rs != null)try { rs.close();} catch(Exception e) {}
			if(ps != null)try { ps.close();} catch(Exception e) {}
			if(con != null)try { con.close();} catch(Exception e) {}
		}
		
		
	}

}
