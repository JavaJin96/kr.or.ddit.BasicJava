package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

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
			
			String sql = "select * from cart "
					+ "where cart_member = ?"
					+ " and cart_qty > ?";
			// ?로 where절의 비교 대상을 설정하고, 값을 동적으로 넣어줄 수 있다. 
			// ? 반드시 값만 대체할 수 있다. (컬러명, 테이블명, 키워드 ... 은 대체 불가능)
			ps = con.prepareStatement(sql);
			ps.setString(1, "a001"); // 첫번째 물음표에 a001을 넣겠다.
			ps.setInt(2, 5); // 두번째 물음표에 5를 넣겠다.
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData(); 
			//메타데이터 : 데이터에 대한 데이터 (컬럼의 길이를 알기 위해서 사용하는 부분)
			int columCount = metaData.getColumnCount();
			// columCount = 컬럼의 수(길이)
			
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
