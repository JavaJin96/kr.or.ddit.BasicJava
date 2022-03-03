package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	
	// 싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴
	
	private JDBCUtil(){
		
	}
	
	private static JDBCUtil instance;
	
	public static JDBCUtil getInstance() {
		if(instance == null) {
			instance = new JDBCUtil();
		}
		return instance;
	}
	
	String url = "jdbc:oracle:thin:@192.168.32.65:1521:xe";
	String user = "teamProject";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/*
	 *  select 절의 결과가 한줄 밖에 없을 경우에 사용하는 메서드
	 *  Map<String, Object> selectOne(String sql)
	 *  Map<String, Object> selectOne(String sql, List<Object> param)
	 *  
	 *  List<Object> param : 커리의 ?가 있을때 ?의 값을 list에 담아서 보낸다.
	 *  
	 *  select 절의 결과가 여러줄 일때,
	 *  List<Map<String, Object>> selectList(String sql)
	 *  List<Map<String, Object>> selectList(String sql, List<Object> param)
	 *  
	 *  select를 제외한 나머지 경우에서 사용하는 메서드
	 *  int update(String sql)
	 *  int update(String sql, List<Object> param)
	 */
	
	
	
	public Map<String, Object> selectOne(String sql){
		HashMap<String, Object> map = null;
	try {
		con = DriverManager.getConnection(url, user, password);
		
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		if(rs.next()) {
				map = new HashMap<>();
			for(int i = 1; i <= columnCount; i++) {
				map.put(metaData.getColumnName(i), rs.getObject(i));
			}
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
	return map;
}

	public Map<String, Object> selectOne(String sql, List<Object> param){
			
			HashMap<String, Object> map = null;
			
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			for( int i = 0 ; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));
			}
			
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			if(rs.next()) {
				 map = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null)try { rs.close();} catch(Exception e) {}
			if(ps != null)try { ps.close();} catch(Exception e) {}
			if(con != null)try { con.close();} catch(Exception e) {}
		}
		return map;
	}
	
	public List<Map<String, Object>> selectList(String sql){
		
		ArrayList<Map<String, Object>> list = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null)try { rs.close();} catch(Exception e) {}
			if(ps != null)try { ps.close();} catch(Exception e) {}
			if(con != null)try { con.close();} catch(Exception e) {}
		}	
		return list;
		
	}
	
	public List<Map<String, Object>> selectList(String sql, List <Object>param){
		
		
		
		ArrayList<Map<String , Object>> list = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size() ; i++) {
				ps.setObject(i + 1, param.get(i));
			}
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null)try { rs.close();} catch(Exception e) {}
			if(ps != null)try { ps.close();} catch(Exception e) {}
			if(con != null)try { con.close();} catch(Exception e) {}
		}	
		return list;
	}
	
	public int update(String sql) {
			   int result = 0;
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			 result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null)try { rs.close();} catch(Exception e) {}
			if(ps != null)try { ps.close();} catch(Exception e) {}
			if(con != null)try { con.close();} catch(Exception e) {}
		} return result;
				
				
	}
	
	public int update(String sql, List<Object> param) {
			int result = 0;
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));
			}
			 result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null)try { rs.close();} catch(Exception e) {}
			if(ps != null)try { ps.close();} catch(Exception e) {}
			if(con != null)try { con.close();} catch(Exception e) {}
		} return result;
		
		
	}
	
	
	
}

