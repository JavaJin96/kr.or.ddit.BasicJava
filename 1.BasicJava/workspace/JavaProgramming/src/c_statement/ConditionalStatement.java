package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		
		/*
		 * 조건문
		 * - if문
		 * - switch문
		 * 
		 * if문
		 * -if(조건식){} : 조건식의 결과가 true 이면 블럭 안의 문장을 수행한다.
		 * -else if(조건식){} : 다수의 조건이 필요할 때 if 뒤에 추가한다.
		 * -else{} : 조건식 이외의 경우를 이해 추가한다.
		 * 
		 */
		
		int a = 2;
		if (a == 1) {System.out.println("조건식의 연산결과 true이면 수행된다.");}
		
		if (a==1) 
		     {System.out.println("a == 1");
		}else if (a==2) 
		     {System.out.println("a==2");
		}else if (a==3)
		     {System.out.println("a==3");
		}else {
			System.out.println("else");
		}
		
		
		if (a < 10) {System.out.println("a가 10보다 작다.");}
		else if (a < 20) {System.out.println("a가 20보다 작다.");}
		else {System.out.println("***");}
		
		
		//점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 70;
		
		if(60 < score) {System.out.println("합격");}
		else {System.out.println("불합격");}
		
		//점수에 등급을 부여
		Scanner s = new Scanner(System.in);
		score = 80;
		String grade = null; //null : 참조형 타입의 기본값
		//기본값 : 내가 저장하지 않았을때 자동으로 저장되는 값
		//기본형 타입은 기본값이 0
		//boolean : false
		
		if(90 <= score && score <= 100) {grade = "A";}
		else if (80 <= score && score <90) {grade = "B";}
		else if (70 <= score && score <80) {grade = "C";}
		else if (60 <= score && score <70) {grade = "D";}
		else {grade = "F";}
		System.out.println(score+"점" + ":" + "등급" + grade);
		
		System.out.print("점수를 입력하세요 : ");
		int score1 =Integer.parseInt(s.nextLine());
		grade = null;
		
		if(90 <= score1 && score1 <= 100) {grade = "A"; 
				if(97 <= score1) {grade += "+";}
				else if(score1 <= 93 ) {grade += "-";}
				}
		else if (80 <= score1 && score1 <90) {grade = "B";
				if(87 <= score1) {grade += "+";}
				else if (score1 <= 83) {grade +="-";}
				}
		else if (70 <= score1 && score1 <80) {grade = "C";
			if(77 <= score1) {grade += "+";}
				else if (score1 <= 73) {grade +="-";}
				}
		else if (60 <= score1 && score1 < 70) {grade = "D";
				if(67 <= score1) {grade += "+";}
				else if (score1 <= 63) {grade +="-";}
				}
		else {grade = "F";}
		System.out.println(score1 + "점" + "/" + grade);
		
		//줄 자동 정렬 cntl + shift + F
		
		
		
		/* * swich 문
		 * - swich(int/String){case1: break;}
		 * - 조건식의 결과는 정수와 문자열만 (JDK1.7 부터 문자열 허용) 허용한다.
		 * - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 * 
		 */
		
		a = 10;
		
		switch (a) {
		case 10:
			System.out.println("a==10");
			break;
		case 20:
			System.out.println("a==20");
			break;
		default:
			System.out.println("default");
		}
				
		//월에 해당하는 계절을 추력
		
		int month = 3;
		String season = null;

		switch (month) {
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		}
		switch (month) {
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		}
		switch (month) {
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		}
		switch (month) {
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		}
		System.out.println(season);
		
		
		//switch 문을 사용한 점수 등급
		
		score = 100;
		switch (score / 10) {
		case 10: 
		case 9:	
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;	
		default:
			System.out.println("F");
			
		}
		

		// 숫자를 입력받아 그 숫자가 0인지 0이 아닌지 출력해주세요.
		
		System.out.print("숫자>");
		int num1 = Integer.parseInt(s.nextLine());
		
		if (num1==0) {System.out.println("0이 맞습니다.");}
		else {System.out.println("0이 아닙니다.");}
		
		
		
		System.out.print("숫자>");
		int num2 = Integer.parseInt(s.nextLine());
		switch (num2) {
			case 0 : System.out.println("0이 맞습니다.");
			break;
			default: System.out.println("0이 아닙니다.");
			break;
			}
			
		
		// 숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
		
		System.out.print("숫자>");
		int num3 = Integer.parseInt(s.nextLine());
		
		if(num3 %2 == 0) {System.out.println("짝수입니다."); }
		else {System.out.println("홀수입니다."); }
		
		
		
		System.out.print("숫자>");
		int num4 = Integer.parseInt(s.nextLine());
		int res1 = num4 % 2 ; 
		switch (res1) {
			case 0: System.out.println("짝수입니다.");
			break;
			default: System.out.println("홀수입니다.");
			break;
		}
		
		
		// 점수 3개를 입력받아 합계, 평균, 등급을 출력해주세요.
		grade = null;
		System.out.print("점수1>");
		int num5 = Integer.parseInt(s.nextLine());
		
		System.out.print("점수2>");
		int num6 = Integer.parseInt(s.nextLine());
		
		System.out.print("점수3>");
		int num7 = Integer.parseInt(s.nextLine());
		
		int sum = num5 + num6 + num7;
		int avg = sum / 3;
		
		if (90 <= avg && avg <= 100) {grade = "A";}
		else if (80 <= avg && avg < 90) {grade = "B";}
		else if (70 <= avg && avg < 80) {grade = "C";}
		else if (60 <= avg && avg < 70) {grade = "D";}
		else {grade = "F";}
		
		System.out.println("합계:"+ sum + "\n" + "평균:"+ avg + "\n" + "등급:"+ grade  );
		
		
		//1~100 사이의 랜덤한 수를 3개 발생시키고 오름차순으로 출력해주세요.
		/*int random = (int)(Math.random() * 100) + 1;
		int random2 = (int)(Math.random() * 100) + 1;
		int random3 = (int)(Math.random() * 100) + 1;
		
		if (random >= random2 ) {if(random2 >= random3){
			System.out.println(random);
			System.out.println(random2);
			System.out.println(random3);}                              
		}
		
		else if (random >= random2) {if(random2 <= random3) {
			System.out.println(random);
			System.out.println(random3);
			System.out.println(random2);}                       
		}
		
		else if (random <= random2) {if(random >= random3) {
			System.out.println(random2);
			System.out.println(random);
			System.out.println(random3);}                       
		}
		
		else if (random <= random2) {if(random <= random3) {
			System.out.println(random2);
			System.out.println(random3);
			System.out.println(random);}                       
		}
		
		else if (random <= random3) {if(random2 <= random) {
			System.out.println(random3);
			System.out.println(random2);
			System.out.println(random);}                       
		}
		
		else if (random2 <= random3){if(random >= random2) {
			System.out.println(random3);
			System.out.println(random);
			System.out.println(random2);}                       
		}*/
	
		
		
		int random = (int)(Math.random() * 100) + 1;
		int random2 = (int)(Math.random() * 100) + 1;
		int random3 = (int)(Math.random() * 100) + 1;
		
		if (random >= random2 ) {
			if(random2 >= random3){
			System.out.println(random);
			System.out.println(random2);
			System.out.println(random3);} 
			else if (random3 >= random2) 
			{System.out.println(random);
			System.out.println(random3);
			System.out.println(random2);}                             
		}
			
		else if (random <= random2) {
			if(random >= random3) {
			System.out.println(random2);
			System.out.println(random);
			System.out.println(random3);}
			else if(random3 >= random) 
			{System.out.println(random2);
			System.out.println(random3);
			System.out.println(random);}	
		}
		
		else if (random <= random3) {
			if(random2 <= random) {
			System.out.println(random3);
			System.out.println(random2);
			System.out.println(random);}         
			else if (random <= random2) 
			{System.out.println(random3);
			System.out.println(random);
			System.out.println(random2);}	
		}
		
		else {
			System.out.println(random);
			System.out.println(random2);
			System.out.println(random3);                       
		}
		
		
		//정답
		/*
		 * if(random > random2) {
		 * int temp = random;
		 * random = random2;
		 * random2 = temp;
		 * }
		 * 
		 * if(random > radom3) {
		 * int temp = random;
		 * random = random3;
		 * random3 = temp;
		 * 
		 * if(random2 > random3 {
		 * int temp = random2;
		 * random2 = random3;
		 * random3 = temp;
		 * 
		 * System.out.println(random + " < " + random2 + " < " + random3);
		 * 
		 *
		 *
		 *
		 *=============================================================================
		 *
		 *int random = (int)(Math.random() * 100) + 1;
		int random2 = (int)(Math.random() * 100) + 1;
		int random3 = (int)(Math.random() * 100) + 1;
		
		
		
		
		  if(random > random2) {
			  int temp = random;
			  random = random2;
			  random2 = temp;
		  }
		  
		  if(random > random3) {
		  int temp = random;
		  random = random3;
		  random3 = temp;
		  }
		  
		  if(random2 > random3) {
			  int temp = random2;
			  random2 = random3;
		  random3 = temp;
		  }
		  
		  System.out.println(random + " < " + random2 + " < " + random3);
		  
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
