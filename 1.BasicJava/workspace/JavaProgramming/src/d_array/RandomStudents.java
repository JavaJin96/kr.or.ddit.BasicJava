package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStudents {

	public static void main(String[] args) {
		/*
		 * 1~25 까지의 숫자 입력후 반친구들의 이름을 랜덤으로 뽑는 것.(숫자입력은 1~25)
		 * 한번 뽑힌사람은 또 뽑힐 수 없다 (중복 X)
		 * 
		 */
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("================" + "제비 뽑기 시작=================");
		System.out.print("1부터~24의 숫자를 입력하세요 >");
		int num = Integer.parseInt(s.nextLine());
		
		String [] students = new String [] {"민진홍" , "노현정" , "정지수" , "양동현" , "조화랑" , "박상진" , "이정수" , "양승혁" ,
											"강정윤" , "손효선" , "정석철" , "한영민" , "김민호" , "주창규" , "김재웅" , "고성식" ,
											"이유정" , "양아연" , "이용주" , "황선부" , "박세준" , "박상현" , "김은혜" , "김민경" };
		
		int random = 0;
		String temp = "a";
		for (int i = 0; i <= 400; i++) {
			random = (int)(Math.random()*students.length);
			temp = students[0];
			students[0] = students[random];
			students[random] = temp;	
		}

		for (int i = 0; i < num ; i++) {
			System.out.print(students[i]+", ");
			}
		
		/*
		 * <답>
		 * String[] students = {"민진홍" , "노현정" , "정지수" , "양동현" , "조화랑" , "박상진" , "이정수" , "양승혁" ,
								"강정윤" , "손효선" , "정석철" , "한영민" , "김민호" , "주창규" , "김재웅" , "고성식" ,
								"이유정" , "양아연" , "이용주" , "황선부" , "박세준" , "박상현" , "김은혜" , "김민경" };
		 * 
		 * Scanner s = new Scanner(System.in);
		 * System.out.print("1부터~24의 숫자를 입력하세요 >");
		 * int count = Integer.parseInt(s.nextLine());
		 * 
		 * String [] pick = new String[count];
		 * int pickCount = 0;
		 * 
		 * do {
		 * 		int random = (int)(Math.random() * students.length);
		 * 		
		 * 		boolean flag = true;
		 * 		for(int i = 0 ; i < pick.length; i++){
		 * 			if(students[random].equals(pick[i])){
		 * 				flag = false;}
		 * 				}
		 *  if(flag) {
		 *  	pick[pickCount++] = students[random];
		 *  }
		 *  
		 * }while(pickCount < count);
		 * 
		 * System.out.println(Arrays.toString(pick));
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		


	}

}
