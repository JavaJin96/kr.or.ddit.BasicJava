package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
	//  중복되지 않는 랜덤 변수 설정 과정
		/*int answer1 =(int)(Math.random()*10-1)+1;
		int answer2 =(int)(Math.random()*10-1)+1;
		while (answer1 == answer2) {
			answer2 =(int)(Math.random()*10-1)+1;
			}
		int answer3 =(int)(Math.random()*10-1)+1;
		while (answer1 == answer3) {
			answer3 =(int)(Math.random()*10-1)+1;
			}
		
	// 각 자리를 분리 표시 (테스트용 정답표시)
		//System.out.println(answer3);
		String answer33 = Integer.toString(answer3);
		//System.out.println(answer2);
		String answer22 = Integer.toString(answer2);
		//System.out.println(answer1);
		String answer11 = Integer.toString(answer1);
		
		
	//정답	System.out.println(answer33+answer22+answer11);
		
		
		
	
	// 함수에서 사용할 변수 설정
		int strike = 0;
		int ball = 0;
		int out = 0;
		
		
		int count00 = 0;
		System.out.println("===========" + "<숫자 야구를 시작합니다>============");
		
		
	// do - while 문을 이용한 전체 반복문 작성	
		do {
			
			count00 ++;
			
		// 중첩되는 S,B,O를 초기화 해주는 과정	
		if (strike > 0) {strike =0;} 
		if (ball > 0) {ball =0;} 
		if (out > 0) {out =0;} 
		
	// 숫자 입력 과정
		System.out.print("세자리 숫자를 입력하세요>");	
		int userAnswer = Integer.parseInt(s.nextLine());
	
	// 입력받은 숫자 각각 분리 과정
		int userAnswer1 = (userAnswer % 10)/1;
		int userAnswer10 = (userAnswer % 100)/10;
		int userAnswer100 = (userAnswer * 1/100);
		
		
		//1의 자리 비교
		if (answer1 == userAnswer1) {
			strike++;
		}
		else if (answer1 == userAnswer10 || answer1 == userAnswer100) {
			ball++;	
		}
		else {out++;}
		
		//10의 자리 비교
		if (answer2 == userAnswer10) {
			strike++;
		}
		else if (answer2 == userAnswer100 || answer2 == userAnswer1) {
			ball++;	
		}
		else {out++;}
		
		//100의 자리 비교
		if (answer3 == userAnswer100) {
			strike++;
		}
		else if (answer3 == userAnswer10 || answer3 == userAnswer1 ) {
			ball++;	
		}
		else {out++;}
		
		System.out.println(strike + "S " + ball + "B " + out + "O ");
		
		}while(strike != 3); //do - while 문의 끝 
		
		System.out.println("정답입니다.");
		System.out.println(count00 + "번 시도하셨습니다.");
		System.out.println("==========="+"종료===========");
		*/
		
		
		
		
		
		
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		
		do {
			a1 = (int)(Math.random() *9) + 1;
			a2 = (int)(Math.random() *9) + 1;
			a3 = (int)(Math.random() *9) + 1;	
		}while(a1 == a2 || a1 == a3 || a2 == a3 );
		
		int count1 = 0;
		while(true) {
			System.out.println("3자리의 숫자>");
			int input = Integer.parseInt(s.nextLine());
			int i3 = input % 10;
			input /= 10;
			int i2 = input % 10;
			input /= 10;
			int i1 = input % 10;
			
			
			int s1 = 0;
			int b1 = 0;
			int o1 = 0;
			
			if(a1 == i1 ) s1++;
			if(a2 == i2 ) s1++;
			if(a3 == i3 ) s1++;
			
			if(a1 == i2 || a1 == i3) b1++;
			if(a2 == i1 || a2 == i3) b1++;
			if(a3 == i1 || a3 == i2) b1++;
			
			o1 = 3 - s1 - b1;
			System.out.println(++count1 + "차 시도(" + i1 + i2 + i3 + ") : " + s1 + " S " + b1 + " B " + o1 + " O ");
			System.out.println("====================================");
			if(s1 == 3) {
				System.out.println("정답입니다.");
				break;		
				
			}	
			
		}
			
		
		
		
//		int from = 123;
//		String to = Integer.toString(from);
		
		

		
		

	}

}
