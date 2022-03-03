package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {

		/*
		 * 산술 연산자
		 * - 사칙 연산자 : +, -, *, /, %(나머지)
		 * - 복합 연산자 : +=, -=, *=, /=, %= (연산과 대입을 동시에 사용함.)
		 * - 증감 연산자 : ++, --
		 */

		
		int result = 10 + 20 - 30 * 40 / 50 % 60;
		System.out.println(result);
		
		//나머지 연산자 활용
		result = 10 / 3 ;
		System.out.println(result);
		result = 10 % 3 ;
		System.out.println(result);
		
		//5개의 산술연산자를 사용해 5개의 연산을 수행 후 결과를 출력해주세요.
		
		int result1 = 200 * 200 / 20 + 45 - 30 % 2 ;
		System.out.println(result1);
		
		int result2 = 2000 + 1500 % 20 + 90 - 45;
		System.out.println(result2);
	
		int result3 = 4 + 5 - 5 * 30 % 2;
		System.out.println(result3);
		
		Double result4 = 3.14 * 3.14 - 25 + 2500 % 10 ;
		System.out.println(result4);
		
		int result5 = 250000 * 3 + 1 - 1000 / 10 % 5 ;
		System.out.println(result5);

		
		//복합 연산자
		result = result + 3;
		result += 3;
		
		result =result - 5;
		result -= 5;
		
		result *= 2;
		
		//아래의 문장을 복합연산자를 사용한 문장으로 만들어주세요.
		result += 10;
		result %= 5;
		result -= 2*3;
		
		//증감 연산자
		//증가연산자 (++) : 변수의 값을 1 증가시킨다.
		//감소연산자 (--) : 변수의 값을 1 감소시킨다.
		int i = 0;
		
		++i; //전위형 : 변수의 값을 읽어오기 전에 1 증가된다.
		i++; //후위형 : 변수의 값을 읽어온 후에 1증가된다.
		--i; 
		i--; 
		
		i = 0;
		System.out.println("++i = "+ ++i);
		i = 0;
		System.out.println("i++ = " + i++ );
		System.out.println(i);
		
		//피연산자의 타입이 서로 같아야만 연산이 가능하다. (2항 연산자와 피연산자)
		int _int = 10;
		double _double = 3.14;
		double result10 = _int + _double;   //표현범위가 더 큰 타입으로 형변환된다. _int 앞에 (double)_int가 생략되어 형변환 된 것임.
		//System.out.println(result10);
		
		int result11 = _int + (int)_double;   //int값으로 연산하고 싶으면 (int)double 로 형변환 한다.
		
		byte _byte =5;
		short _short = 10;
		_int = _byte + _short; // int보다 작은 타입은 int로 형변환된다.
		
		
		char _char = 'a';
		char _char2 = 'b';
		_int = _char + _char2;
		System.out.println(_int);
		
		//오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		
		byte b = 127;
		b++;
		System.out.println(b);
		b--;
		System.out.println(b);
		
	
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		// 1. 123456 + 654321
		// 2. 1번의 결과값 *  123456
		// 3. 2번의 결과값 / 123456
		// 4. 3번의 결과값 - 654321
		// 5. 4번의 결과값 % 123456
		
		int result12 = 123456 + 654321;
		long result13 = (long)result12 * 123456;
		long result14 = result13 / 123456;
		int result15 = (int)result14 - 654321;
		int result16 = result15 % 123456;
		
		System.out.println(result12);
		System.out.println(result13);
		System.out.println(result14);
		System.out.println(result15);
		System.out.println(result16);
		
		
		//변수를 통일해서 사용해도 가능하다.
		//long res = 123456 + 654321;
		//res = res * 123456;
		//res /= 123456;
		//res -= 654321;
		//res %= 123456;
		//System.out.println(res);
		
	
		//3개의 int타입 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		int a1 = 20;
		int a2 = 3000;
		int a3 = 100;
		
		int r1 = a1 + a2 + a3;
		int r2 = r1 / 3;
		
		System.out.println("합:" + r1);
		System.out.println("평균:" + r2);
		
		
		//복합연산자 활용
		/*int a1 = 20;
		int a2 = 3000;
		int a3 = 100;
		int r1 = a1 + a2 + a3;
		r1 /= 3;
		System.out.println(r1);*/
		
		//정답
		int num1 = 15;
		int num2 = 34;
		int num3 = 49;
		int sum = num1 + num2 + num3;
		double avg = sum / 3.0;
		System.out.println("sum :" + sum  +  " / avg : " + avg);
		
		//반올림
		avg = Math.round(avg * 10) / 10.0; //소수점 첫재자리에서 반올림해준다. long타입의 값으로 반환됨
		System.out.println(avg);
		
		//랜덤 발생
		//Math.random() : 0.0 ~ 1.0 미만
		int random = (int)(Math.random() * 100) +1; //1부터 100사이 랜덤의 숫자
		System.out.println(random);
		
		
		
		
	}

}
