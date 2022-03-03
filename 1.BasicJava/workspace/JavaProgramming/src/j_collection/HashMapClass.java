package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import e_oop.ScanUtil;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 *  Object put(Object key, Object value) : 지정된 키와 값을 지정한다.
		 *  Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 *  Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 *  Set keySet() : 지정된 모든 키를 Set으로 변환한다.
		 */
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "홍길동동이");
		map.put("age", 420);
		map.put("date", new Date());

		System.out.println(map);
		
		map.put("name", "이순신");
		System.out.println(map);
		
		Object value = map.get("name");
		System.out.println(value);
		System.out.println(map.get("name"));
		
		((String)value).substring(1,2);
		String val = (String)map.get("name");
		
		
		Set<String> keys = map.keySet();
		
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
		//for( x : y)
		// y : 여러 데이터들의 집합 구조 , x : 값을 꺼냈을 때 저장할 변수
		
		
		ArrayList<HashMap<String, Object>> lprodTable = new ArrayList<>();
		
		HashMap<String, Object> lprod = new HashMap<>();
		lprod.put("LPROD_ID", 1);
		lprod.put("LPROD_GU", "p101");
		lprod.put("LPROD_NM", "컴퓨터제품");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", 2);
		lprod.put("LPROD_GU", "p102");
		lprod.put("LPROD_NM", "전자제품");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", 3);
		lprod.put("LPROD_GU", "p201");
		lprod.put("LPROD_NM", "여성캐주얼");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", 4);
		lprod.put("LPROD_GU", "p202");
		lprod.put("LPROD_NM", "남성캐주얼");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", 5);
		lprod.put("LPROD_GU", "p301");
		lprod.put("LPROD_NM", "피혁잡화");
		lprodTable.add(lprod);
		
		System.out.println(lprodTable);
		
		
		System.out.println("열람하실 행의 번호를 입력해주세요.(1~5)");
//		int input = ScanUtil.nextInt();
//		for(int i = 0 ; i < lprodTable.size(); i++) {
//			if(input == (int)lprodTable.get(i).get("LPROD_ID")) {
//				System.out.println(lprodTable.get(i));
//			}
//		}
		
		int input = ScanUtil.nextInt();
		for(HashMap i : lprodTable) {
			if(input == (int)i.get("LPROD_ID")){
				System.out.println(i);	
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
