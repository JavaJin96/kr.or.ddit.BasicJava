package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		
		//두개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그렘을 만들어주세요.
		
		Scanner s = new Scanner(System.in);
		
		/*System.out.print("숫자>");
		int num1 = Integer.parseInt(s.nextLine());
		System.out.print("숫자>");
		int num2 = Integer.parseInt(s.nextLine());
		System.out.print("연산자>");
		String x = s.nextLine();
	    
		int a = num1 + num2;
		int b = num1 - num2;
		int c = num1 * num2;
		int d = num1 / num2;
	    
		System.out.println(x.equals("+") ? a : (x.equals("-") ? b : (x.equals("*") ? c : 
		(x.equals("/")) ? d : "계산불가"))    );*/
			
		
		//원본 코드
		//int result1 = x.equals("+") ? a : (x.equals("-") ? b : (x.equals("*") ? c : d));
		//System.out.println(result1);
		
        //long a11 = s.nextLong();

		
		//업그레이드 버전
		System.out.print("숫자>");
		double num11 = Double.parseDouble(s.nextLine());
		System.out.print("숫자>");
		double num22 = Double.parseDouble(s.nextLine());
		System.out.print("연산자>");
		String x11 = s.nextLine();
	    
		double a11 = num11 + num22;
		double b11 = num11 - num22;
		double c11 = num11 * num22;
		double d11 = num11 / num22;
		double e11 = num11 % num22;
		double f11 = (num11 * 1/100 ) * num22;
		
		
        System.out.print(num11 + " " + x11 + " " + num22 + " = ");
		System.out.println(x11.equals("+") ? a11 : (x11.equals("-") ? b11 : (x11.equals("*") ? c11 : 
		(x11.equals("/")) ? d11 : (x11.equals("%") ? e11 : (x11.equals("%%")) ? f11 : "계산 불가"))) );
		
		
		
		//정답
		/* double result = x11.equals("+") ? num11 + num22
		 : x11.equals("-") ? num11 - num22
		 : x11.equals("*") ? num11 * num22
		 : x11.equals("/") ? num11 / num22
	     : num11 % num22 ;
		 
		 System.out.println(num11 + " " + x11 + " " + num22 + " = " + result);
		*/
		
		
		
	}

}
