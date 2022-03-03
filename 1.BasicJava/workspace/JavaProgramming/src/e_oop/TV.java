package e_oop;

public class TV {

	int power;
	int Ch = 1;
	int vol = 5;
	
	//변수 : 대상이 가지는 속성
	//메서드 : 대상이 하는 행동
	
	
//	final int MIN_CHANNEL = 1;
//	final int MAX_CHANNEL = 100;
//	final int MIN_VOLUME = 0;
//	final int MAX_VOLUME = 10;
// 변수 앞에 final 이 붙으면 상수이며 final 이 붙으면 변수의 값이 변경될 수 없다. 
// 형식은 final 이 앞에 붙고 변수명은 모두 대문자로 기재.
	
	
//	void power() {
//	power = !power;
//	System.out.println("TV" + (power ? "on" : "off"));
//			}	
	

	
//	void changeChannel(int channel) {
//		if(power) {
//			if(MIN_CHANNEL <= channel && channel <= MAX_CHANNEL) {
//				this.channel = channel;							
//			}
//			System.out.println("채널." + this.channel);
//		}
//	}
	
	
//	void channelUp() {
//		int ch = 0;	
//		if(channel == MAX_CHANNEL) {
//			ch = MIN_CHANNEL;
//		}else {
//			ch = channel +1;
//		}
//		changeChannel(channel + 1);
//	}
//	
//	void channelDown() {
//		changeChannel(channel - 1);
//	}

	
	
//	void volumeUp() {
//		if(power) {
//			if(volume < MAX_VOLUME) {
//				volume++;				
//			}
//			showVolume();
//		}
//	}
//	
//	void volumeDown() {
//		if(power) {
//			if(MIN_VOLUME < volume) {
//				volume--;
//			}
//			showVolume();
//		}
//	}
//	
//	void showVolume() {
//		System.out.println("음량. ");
//		for(int i = MIN_VOLUME +1; i <= MAX_VOLUME; i++) {
//			if(i <= volume) {
//				System.out.print("●");
//			}else {
//				System.out.print("○");
//			}
//		}
//		System.out.println();
//	}
	
	
//	public static void main(String[] args) {
//		TV tv = new TV();
//		
//		while(true) {
//			System.out.println("1. 전원  2.채널변경 3.채널+ 4.채널-");
//			System.out.println("5. 볼륨+ 6. 볼륨- 0.종료>");
//			int input = ScanUtil.nextInt();
//			switch (input) {
//				case 1: tv.power();break;
//				case 2: 
//					System.out.println("변경할 채널(1~100)");
//					int ch = ScanUtil.nextInt();
//					tv.changeChannel(ch);
//					break;
//				case 3: tv.channelUp();break;
//				case 4: tv.channelDown();break;
//				case 5: tv.volumeUp();break;
//				case 6: tv.volumeDown();break;
//				case0:
//					System.out.println("프로그램이 종료되었습니다.");
//					System.exit(0);
//			}
//		}
//		
//	}
	
	
	
	
	
	//리모컨 사용법
	//전원버튼 : 0
	//채널변경 : 숫자입력 혹은 u & d
	//음량변경 : up & down
	
	// 전원을 키고 끄고
	void onoff (int x){
		if(x == 0) {
		power++;
		}
		
		if(power%2 == 1) {
	System.out.println("전원을 켭니다.");
		}
		if(power%2 == 0) {
	System.out.println("전원을 끕니다.");		
		}

	}
	
	

	
	
	// 채널을 변경
	int changeIn (int x) {
		if(x >= 101 || x <= 199 && power%2 == 1) {
			Ch = (x-100);
			System.out.println(Ch + "번");	
		}
		return  Ch;
		
	}
	
	void changeStr (int x) {
		if(x == 4 && Ch < 99 && power%2 == 1) {
			Ch++;
			System.out.println(Ch + "번 채널");
		}else if (x == 1 && Ch >= 1 && power%2 == 1) {
			Ch--;
			System.out.println(Ch + "번 채널");
		}
		
	}

	// 음량을 변경
	void changeVol (int x) {
		if(x == 6 && vol <= 100 && power%2 == 1) {
			vol++;
			System.out.println("현재 볼륨" + vol);
		}else if(x == 3 && vol >= 1 && power%2 == 1) {
			vol--;
			System.out.println("현재 볼륨" + vol);
		}
		
	
	}
	
	
	public static void main(String[] args) {
		
		
		TV tv = new TV();
		
		System.out.println("티비 동작 준비");
		System.out.println("리모컨을 동작해주세요.");
		System.out.println("리모컨 사용법 \n전원 : 0\n채널변경 : 해당채널+100 / 1,4 \n음량변경 : 3,6");
		//String input = ScanUtil.nextLine();
		
		do {
			
			int input = ScanUtil.nextInt();
			if(input == 0) {
				tv.onoff(input);
			}
			if(input <= 199 && input >= 101) {
				tv.changeIn(input);
			}
			if(input == 4 || input == 1) {
				tv.changeStr(input);
			}
			if(input == 3 || input == 6) {
				tv.changeVol(input);
			}
			
		}while(tv.power%2 == 1);
			
		
		
	}
	

	
}



//채널 범위 넘어갈시 (오버플로우 언더플로우)해결
//전원 껐다 켜도 기존 기록 남아있게 