package a_variable;

import java.util.Scanner;

public class Join {

	public static void main(String[] args) {
	
		/*			
		System.out.println("회원가입을 시작합니다.");		
				Scanner scan = new Scanner(System.in);
				
		System.out.print("아이디를 입력해주세요 :");
		String userId = scan.nextLine();

		System.out.print("비밀번호를 입력해주세요 :");
		int pW = Integer.parseInt(scan.nextLine());
			
		System.out.print("이름을 입력해주세요 :");
		String userName = scan.nextLine();

		System.out.print("나이를 입력해주세요 :");
		int userAge = Integer.parseInt(scan.nextLine());

		System.out.print("키를 입력해주세요 :");	
		Double length = Double.parseDouble(scan.nextLine());

				
		System.out.println("회원가입이 완료되었습니다.");
		System.out.println("나의 정보");

		System.out.println("아이디 :" + userId);		
		System.out.println("비밀번호 :" + pW);	
		System.out.println("이름 :" + userName);	
		System.out.println("나이 :" + userAge);
		System.out.println("키 :" + length);
	/*
		
/* 아래와 같은 프로그렘을 만들어 주세요.
 * 
 * ==========회원 가입=============
 * 아이디>admin
 * 비밀번호(4자리 숫자)>1234
 * 이름>홍길동
 * 나이>99
 * 키>185.5
 * =============================
 * 회원가입 완료
 * ==========내정보==============
 * 아이디 :admin
 * 비밀번호 : 1234
 * 이름 : 홍길동
 * 나이:99세
 * 키:185.5
 *-=============================
 */
		
		
		   //정답 및 풀이
		  Scanner s = new Scanner(System.in);
		  System.out.println("==========회원 가입=============");
		  System.out.print("아이디>");
		  String id = s.nextLine();
		  System.out.print("비밀번호>");
		  String passWord = s.nextLine();
		  System.out.print("이름>");
		  String userName = s.nextLine();
		  System.out.print("나이>");
		  int Age = Integer.parseInt(s.nextLine());
		  System.out.print("키>");
		  Double Lengtha = Double.parseDouble(s.nextLine());
		  
		  System.out.println("=============================");
		  System.out.println("회원가입 완료");
		  System.out.println("==========내정보==============");
		  System.out.println("아이디 :" + id);
		  System.out.println("비밀번호 :" + passWord);
		  System.out.println("이름 :" + userName);
		  System.out.println("나이 : " + Age + "세");
		  System.out.println("키 :" + Lengtha + "cm");
		  
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
