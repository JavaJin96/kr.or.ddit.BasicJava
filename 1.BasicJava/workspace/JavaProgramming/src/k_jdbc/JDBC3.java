package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC3 {

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
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "select mem_name,mem_mileage from member where mem_mileage > 6000";
				ps = con.prepareStatement(sql);
				
				rs = ps.executeQuery();
				ResultSetMetaData metaData = rs.getMetaData();
				int columCount = metaData.getColumnCount();
				while(rs.next()) {
					for( int i = 1; i <= columCount; i++) {
						Object value = rs.getObject(i);
						System.out.println(value + "\t");
					}
					System.out.println();
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
