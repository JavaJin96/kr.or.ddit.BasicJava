package j_collection;

import e_oop.ScanUtil;

public class BoardOOP {

	public static void main(String[] args) {
		
		BoardUtilOOP bu = new BoardUtilOOP();
		
		board : while(true) {
			bu.showRobby();
			int input = ScanUtil.nextInt();
			
			switch(input) {
			case 1 : 	System.out.println("몇번 자료를 열람하시겠습니까?");
						input = ScanUtil.nextInt();
						bu.showDetail(input);
						int input1 = ScanUtil.nextInt();
						if(input1 == 1) {
							bu.insert(input);
							continue;
						}
						else if(input1 == 2) {
							bu.delete(input);
							continue;
						}

			
			case 2 :	bu.input();
						continue;
						
						
			case 0 :   	System.out.println("프로그램을 종료합니다.");
						break board;
			}

		}
		
	}

}

//주소를 넘겨 받는 과정이라서, 변경되었다. 
//글번호 부여 = 최댓값을 찾아서 거기에 +1해서 사용