package j_collection;

import java.util.ArrayList;

import e_oop.score.Score;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * 	collection Framework(다수의 데이터를 다루는 방법)
		 *  - 인터페이스(부모의 역활만 하는 객체)
		 * 	- List : 배열과 똑같은 구조로 생김(여러 데이터가 순서대로 저장, 배열의 상위호환)
		 *  - Map : 값을 key로 저장한다. (인덱스 저장이 아니라서, 순서라는 개념이 없다.)
		 *  - Set : 중복되는 값은 저장 불가능
		 *  
		 * 	ArrayList의 주요 메서드(List.ArrayList) : 읽는 속도가 빠르다.대신 쓰는 속도가 느리다.
		 *  boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다.
		 *  void add(int index, Object obj) : 지정된 위치에 객체를 추가한다.(기존 자료들은 뒤로 이동한다.)
		 *  Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다.
		 *  Object get(int index) : 지정된 위치의 객체를 반환한다.
		 *  int size() : 저장된 객체의 수를 반환한다.
		 *  Object remove(int index) : 저장된 위치의 객체를 제거한다.(인덱스를 지우면 뒤의 값들이 앞으로 온다.)
		 */
		
		ArrayList sample = new ArrayList();
		
		
		sample.add("abc");
		sample.add(100);
		//타입 상관없이 저장 가능
		//꺼낼때 타입을 알수가 없음
		
		//<>제네릭 : 타입을 정해주었음.
		// 기본형타입은 저장 불가능, 객체만 저장 가능하기 때문에 int 가 아닌 Integer로 저장함.
		ArrayList<Integer> list = new ArrayList<>();
		
		/*
		 *  WrapperClass
		 *  
		 *  byte : Byte
		 *  short : Short
		 *  int : Integer
		 *  long : Long
		 *  float : Float
		 *  double : Double
		 *  boolean : Boolean
		 *  char : Character
		 */
		
		//값 추가하기
		list.add(10);
//		list.add("add");
		list.add(new Integer(20));
		// WrapperClass 들 끼리는 자동 형변환 가능
		System.out.println(list.add(30));
		System.out.println(list);
		
		list.add(1, 40);
		System.out.println(list);
		
		//현재 리스트의 범위를 벗어나는 범위는 저장이 불가능 하다.
//		list.add(5,50);
		
		
		//수정
		Integer before = list.set(2, 50);
		System.out.println("before :" + before);
		System.out.println(list);
		
		
		//읽기
		int get = list.get(2);
		System.out.println(get);
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(i + " : " + list.remove(i));
//		}
//		System.out.println(list);
//		
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(i + " : " + list.remove(i));
		}
		System.out.println(list);
		
		// list에 1~100 사이의 랜덤값을 10개 저장해주세요.
		for(int i = 0; i < 10; i++) {
			list.add((int)(Math.random()*100)+1);			
		}
		System.out.println(list);
		 
		
		// list에 저장된 값의 합계와 평균을 구해주세요.
		int sum = 0;
		double avg = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		avg = (double)sum / list.size();
		System.out.println(sum);
		System.out.println(avg);
		
		
		// list 에서 최소값과 최대값을 구해주세요.
		
		int max = 0;
		int min = 100;
		
		for (int i = 0; i < list.size(); i++) {
			if(max < list.get(i)) {
				max = list.get(i);
			}
			if(min > list.get(i)) {
				min = list.get(i);
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		
		// list 를 오름차순으로 정렬해주세요.
		ArrayList <Integer> temp1 = new ArrayList();
		temp1.add(0);
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < list.size(); j++) {
//				if(list.get(i) > list.get(j)){
//					temp.add(0,list.get(j));
//					list.add(j,list.get(i));
//					list.add(i, temp.get(0));
//				}
//			}
//		}                add사용시 추가이기 때문에, 기존 값들이 뒤로 계속 밀린다. 
//		                    계속 밀리면서 size()가 늘어나기 때문에 무한루프가 된다.		
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(list.get(i) < list.get(j)){
					temp1.set(0, list.get(j));
					list.set(j, list.get(i));
					list.set(i, temp1.get(0));
				}
			}
		}
		System.out.println(list);
		
//		list.set(0, list.set(i, list.get(j)));
		
		
		
		// 2차원
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		
		list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		list2.add(list);
		
		list = new ArrayList<>();
		list.add(40);
		list.add(50);
		
		list2.add(list);
		
		System.out.println(list2);
		
		for (int i = 0; i < list2.size(); i++) {
			ArrayList<Integer> temp = list2.get(i);
			for (int j = 0; j < list2.size(); j++) {
				System.out.println(temp.get(j));
			}
		}
		
		
		list2.get(0).get(1);
		
		// 학생 3명의 5과목에 대한 점수를 0~100사이의 점수로 발생시켜서 2차원 ArrayList에 저장해주세요.
		
		ArrayList<ArrayList<Integer>> students = new ArrayList<>();
		
	
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> score = new ArrayList<>();
			for (int j = 0; j < 5; j++) {
				score.add((int)(Math.random()*101));
			}
			students.add(score);
			System.out.println(score);
		}

		System.out.println(students);
		
		// 각 학생별로 합계와 평균을 구하세요.
		
		ArrayList<Integer> sum2 = new ArrayList<>();
		ArrayList<Double> avg2 = new ArrayList<>();
		
		for (int i = 0; i < students.size(); i++) {
				int sum1 = 0;			
			for (int j = 0; j < students.get(i).size(); j++) {
				sum1 += students.get(i).get(j);
			}
			double avg1 = 0;
			avg1 = (double)sum1 / students.get(i).size();
			sum2.add(sum1);
			avg2.add(avg1);
			System.out.println("학생" + (i+1) + "합계 : " + sum1 + " 평균 : " + avg1);
		}
		System.out.println(sum2);
		System.out.println(avg2);
		
		
		

		
		
	}

}
