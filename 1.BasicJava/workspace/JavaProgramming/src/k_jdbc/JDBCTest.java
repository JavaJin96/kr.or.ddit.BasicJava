package k_jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

	public static void main(String[] args) {
	      JDBCUtil jdbc = JDBCUtil.getInstance();
	      
	      String sql = "";
	      
	      ArrayList<Object> param = new ArrayList<>();
	      param.add("박상진");
	      param.add("5000");
	      
	      Map<String, Object> map = jdbc.selectOne(sql, param);
//	      Map<String, Object> map = jdbc.selectOne(sql);
	      List<Map<String, Object>> list = jdbc.selectList(sql, param);
//	      List<Map<String, Object>> list = jdbc.selectList(sql);
	      int i = jdbc.update(sql,param);
//	      int i = jdbc.update(sql);
	      
	      System.out.println(i);

	   }
}
