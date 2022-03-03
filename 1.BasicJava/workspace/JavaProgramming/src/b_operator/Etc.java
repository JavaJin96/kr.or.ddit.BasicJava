package b_operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		
		/*
		 * 비트 연산자
		 * - |, &, ^, ~, <<, >>
		 * - 비트단위로 연산한다.
		 * 
		 * 참조 연산자(.)
		 * -특정범위 내에 속해 있는 맴버를 지칭할 때 사용한다.
		 * 
		 * 삼항연산자(?:)
		 * -조건식? 조건식이 참이 경우 수행할 문장 : 조건식이 거짓일 경우 수행할 문장
		 * a?b c : a가 참일 경우 b 실행 / a가 거짓일 경우 c 실행
		 */
		
		
		
		//1byte : 01010101
		
		System.out.println(10 | 15); // | : 둘다 0인 경우 0 그외 1
		//10 : 00001010
		//15 : 00001111
		//결과값: 00001111
		
		
		int x = 10;
		int y = 20;
		int result = x < y ? x : y;
		System.out.println(result);
		
		
		//주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2면 여자
		int regNo =3;
		String gender = regNo == 1 ? "남자" : "여자";
		System.out.println(gender);
		
		gender = regNo == 1 ? "남자" : (regNo == 2 ? "여자" : "확인불가");
		System.out.println(gender);
		
		//2개의 숫자를 입력받고, 둘 중 더 큰 숫자를 출력해주세요.
		
		Scanner s = new Scanner(System.in);
	
		System.out.print("숫자를 입력해주세요");
		int num1 = Integer.parseInt(s.nextLine());
		
		System.out.print("두번째 숫자를 입력해주세요");
		int num2 = Integer.parseInt(s.nextLine());
		
		int result1 = num1 < num2 ? num2 : (result1 = num1 > num2 ? num1 : num1);
		System.out.println("더 큰 숫자는" + result1 + " 입니다.");
		
		
		//삼항 연산자 하나로 표현해보기
		//int result1 = num1 < num2 ? num2 : num1 ;

 		
		//숫자를 입력받고, 그숫자가 1이나 3이면 남자를 2나 4면 여자를 출력해주세요.
		//그 외의 숫자를 입력하면 화인불가를 출력해주세요.
		
		System.out.print("숫자를 입력해주세요 : ");
		int regNo1 = Integer.parseInt(s.nextLine());
		
		gender = regNo1 == 1 || regNo1 == 3 ? "남자" : 
			(regNo1 == 2 || regNo1 == 4 ? "여자" : "확인불가");
		System.out.print(gender);
		
		
		
		
		
		
		

	}

}
