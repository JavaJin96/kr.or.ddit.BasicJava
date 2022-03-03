package b_operator;

public class ComparingOperator {

	public static void main(String[] args) {
		
		/* 비교 연산자
		 * - <, >, <=, >=, ==, !=
		 * - 문자열 비교 : equals()
		 */
		
		
		int x = 10;
		int y = 20;
		
		boolean b = x < y;
		System.out.println(b);
		
		b = x <= y -15; //산술연산이 비교연산보다 우선순위가 높다.
		System.out.println(b);
		
		String str1 = "abc";
		String str2 = "ABC";
		b = str1 != str2; //문자를 비교하는 것이 아닌, 그 data의 주소를 비교하는 것
		System.out.println(b);
		
		//데이터
		//기본형, 참조형(배열, 클래스) (data의 저장 방법이 다르다.기본형 - 변수에 직접 저장 / 참조형  - 변수에 메모리 adress를 저장
		//따라서 참조형타입의 비교연산자 ==은 값의 비교가 아닌 adress의 비교다.)
		
		b = !str1.equals(str2); //("!"결과를 반대로 바궈줌) 
		System.out.println(b);
		
		//다음의 문장들을 코드로 작성해주세요.
		//x는 y보다 작거나 같다.
		b = x <= y;
		System.out.println(b);
		//x + 5와 y는 같다.
		b = x +5 ==y;
		System.out.println(b);
		//y는 홀수이다.
		b = y%2 ==1;
		System.out.println(b);
		//"기본형" 과 "참조형'은 다르다.
		b = !"기본형".equals("참조형");
		System.out.println(b);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
