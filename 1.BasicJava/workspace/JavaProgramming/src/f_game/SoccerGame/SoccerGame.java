package f_game.SoccerGame;

import e_oop.ScanUtil;

public class SoccerGame {
	
	public static void main(String[] args) {
	
		Player [] p;
		p = new Player[6]; 
		Team [] t;
		t = new Team[2];
	
			
	while(true) {
		System.out.println("1.시작하기");
		int input = ScanUtil.nextInt();
		switch(input) {
		
		case 1 : 
			System.out.println("팀명을 입력해주세요>");
			t[0].name = ScanUtil.nextLine();
			for(int i = 0; i < p.length; i++) {
				p[i] = new Player();
			}
			
			System.out.println(p.length + "명의 선수가 추가되었습니다.");
			break;

		
		case 2 :	
			
			
		}
	page1 : while(true) {
		
		System.out.println("1.나의팀   2.선수관리  3.경기시작");
		int input1 = ScanUtil.nextInt();
		switch(input1) {
		
		case 1 : p[0].playersStatus();
			     p[1].playersStatus();
		         p[2].playersStatus();
		         break;
		
		case 2 :  
				 page2 : while(true) {
					 
					System.out.println("1.포지션 수정   2. 훈련  3.선수 영입  4.뒤로가기");
					int input2 = ScanUtil.nextInt();
					switch(input2) {
					
					case 1 :System.out.println("1.GK." + p[0].name + " 2.CB." + p[1].name + " 3.ST." + p[2].name); 
							System.out.println("변경할 선수 선택");
							int input21 = ScanUtil.nextInt();
							System.out.println("1.GK  2.CB  3.ST");
							System.out.println("변결할 포지션 선택");
							int input22 = ScanUtil.nextInt();
							if(input21 == 1 && input22 == 2) {
								Player temp[] = new Player[3];
								temp[0] = p[0];
								p[0] = p[1];
								p[1] = temp[0];
								System.out.println("1.GK." + p[0].name + " 2.CB." + p[1].name + " 3.ST." + p[2].name);
							}else if(input21 == 1 && input22 ==3) {
								Player temp[] = new Player[3];
								temp[0] = p[0];
								p[0] = p[2];
								p[2] = temp[0];
								System.out.println("1.GK." + p[0].name + " 2.CB." + p[1].name + " 3.ST." + p[2].name);
							}else if(input21 == 2 && input22 ==1) {
								Player temp[] = new Player[3];
								temp[0] = p[1];
								p[1] = p[0];
								p[0] = temp[0];
								System.out.println("1.GK." + p[0].name + " 2.CB." + p[1].name + " 3.ST." + p[2].name);
							}else if(input21 == 2 && input22 ==3) {
								Player temp[] = new Player[3];
								temp[0] = p[1];
								p[1] = p[2];
								p[2] = temp[0];
								System.out.println("1.GK." + p[0].name + " 2.CB." + p[1].name + " 3.ST." + p[2].name);
							}else if(input21 == 3 && input22 ==1) {
								Player temp[] = new Player[3];
								temp[0] = p[2];
								p[2] = p[0];
								p[0] = temp[0];
								System.out.println("1.GK." + p[0].name + " 2.CB." + p[1].name + " 3.ST." + p[2].name);
							}else if(input21 == 3 && input22 ==2) {
								Player temp[] = new Player[3];
								temp[0] = p[2];
								p[2] = p[1];
								p[1] = temp[0];
								System.out.println("1.GK." + p[0].name + " 2.CB." + p[1].name + " 3.ST." + p[2].name);
							}
							
						
					case 2 : System.out.println("1.GK." + p[0].name + " 2.CB." + p[1].name + " 3.ST." + p[2].name);
							 System.out.println("훈련선수선택 >");
							 int input23 = ScanUtil.nextInt();
							 
						
					case 3 : 
						
					case 4 : continue page1;
					
					}
				 }
		
		case 3 : System.out.println("경기시작");
		}
	}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
		
		
		
		
		
		

		
		
	}

}
