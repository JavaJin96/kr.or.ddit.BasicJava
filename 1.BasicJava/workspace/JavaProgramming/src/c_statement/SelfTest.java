package c_statement;

import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {
		
		//'탄수화물 중독' 자가 진단하기
		// 프로그렘 만들기
		
	Scanner s = new Scanner(System.in);
	int score = 0;
	
	System.out.println("탄수화물 중독 자가진단 테스트를 시작합니다.");
	
	System.out.print("아침을 배불리 먹은 후 점심시간 전에 배가 고픕니까?[Y/N]");
	String a1 = s.nextLine();
	if (a1.equals("Y")) {score+=1;}
	
	System.out.print("밥, 빵, 과자 등의 음식을 먹기 시작하면끝이 없습니까?[Y/N]");
	String a2 = s.nextLine();
	if (a2.equals("Y")) {score+=1;}
	
	System.out.print("음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹습니까?[Y/N]");
	String a3 = s.nextLine();
	if (a3.equals("Y")) {score+=1;}
	
	System.out.print("정말배가 고프지 않더라도 먹을 때가 있습니까?[Y/N]");
	String a4 = s.nextLine();
	if (a4.equals("Y")) {score+=1;}
	
	System.out.print("저녁을 먹고 간식을 먹지 않으면 잠이 오지 않습니까?[Y/N]");
	String a5 = s.nextLine();
	if (a5.equals("Y")) {score+=1;}
	
	System.out.print("스트레스를 받으면자구 먹고싶어지십니까?[Y/N]");
	String a6 = s.nextLine();
	if (a6.equals("Y")) {score+=1;}
	
	System.out.print("책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있습니까?[Y/N]");
	String a7 = s.nextLine();
	if (a7.equals("Y")) {score+=1;}
	
	System.out.print("오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힙니까?[Y/N]");
	String a8 = s.nextLine();
	if (a8.equals("Y")) {score+=1;}
	
	System.out.print("과자, 초콜릿 등의 단 음식은 상상만 해도 먹고 싶어 집니까?[Y/N]");
	String a9 = s.nextLine();
	if (a9.equals("Y")) {score+=1;}
	
	System.out.print("다이어트를 위해 식이조절을 하는데 3일도 못 갑니까?[Y/N]");
	String a10 = s.nextLine();
	if (a10.equals("Y")) {score+=1;}
	
	if (0 <= score && score <=3) {System.out.println("정상입니다.");
	}
	else if (score ==3)  {System.out.println("주의! 위험한 수준은 아니지만 관리가 필요함.");
	}
	else if (3 < score && score <=6) {System.out.println("위험!탄수화물 섭취를 줄이기 위한 식습관 개선이 필요함.");
	}
	else {System.out.println("중독! 전문의 상담이 필요함");
	}
		
		
		
		
		
		
		
		
		
		

	}

}
