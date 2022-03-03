package e_oop;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class AirCon {

	//전원
	//온도
	//바람세기
	
	boolean power = false;
	int temper = 23;
	int wind = 1;
	
	//전원을 키고 끄고
	
	void onOff() {
		power = !power;
		System.out.println( (power) ? "on" : "off");
		if(power) {
			status();
		}
	}
	
	//온도를 올리고 내리고
	void tempUp() {
		if(power && temper < 30) {
			temper++;
//		if(temper==30) {
//			System.out.println("최대 온도 입니다.");
//		}
			status();
		}
	}
	
	void tempDown() {
		if(power && temper > 18) {
			temper--;
			status();
		}
	}
	
	//바람세기
	void windpowerUp() {
		if(power && wind < 5) {
			wind++;
			status();
		}
	}
	
	void windpowerDown() {
		if(power && wind > 1) {
			wind--;
			status();
		}
	}
	
	
	void status() {
		System.out.print("현재온도 : " + temper +  "  바람세기 : ");
		for(int i = 1; i <= wind; i++ ) {
			System.out.print("●");		
		}
		System.out.println(" ");
//		if(temper == 30) {
//			System.out.println("최고 온도 입니다.");
//		}if(temper == 18) {
//			System.out.println("최저 온도 입니다.");
//		}if(wind == 5) {
//			System.out.println("최고 바람세기 입니다.");
//		}if(wind == 1) {
//			System.out.println("최저 바람세기 입니다.");
//		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		AirCon ac = new AirCon();
		while(true) {
			System.out.println("<동작입력>\n 0:전원  1:온도상승 2.온도하락 3.바람세기상승 4.바람세기하락");
			int input = ScanUtil.nextInt();
			switch(input) {
			
			case 0 : ac.onOff(); break;
			case 1 : ac.tempUp(); break;
			case 2 : ac.tempDown(); break;
			case 3 : ac.windpowerUp(); break;
			case 4 : ac.windpowerDown(); break;
			
			}
			
		}
		
		
		
		
		
	}
	
}
