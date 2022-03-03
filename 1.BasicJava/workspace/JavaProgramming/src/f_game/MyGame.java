package f_game;

import java.util.Scanner;

import e_oop.ScanUtil;

public class MyGame {

	Character c;
	Item[] items;
	
	MyGame(){
		c = new Character("가렌", 100, 50, 20, 10);
		
		items = new Item[10];
		items[0] = new Item("무한의대검",0 ,0 ,10 ,0);
		items[1] = new Item("가시갑옷", 0, 0, 0, 10);
	}
	
	
	public static void main(String[] args) {
		new MyGame().start();
		
	}
	
	void start() {
		while(true) {
			System.out.println("1. 내정보  2. 사냥  0. 종료>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1 :
				c.showStatus();
				break;
			case 2 :
				hunt();
				break;
			case 0 :
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0); //자바 프로그램을 강제로 종료시키는 프로그램
			}
		}
	}
	
	void hunt() {
		Monster m = new Monster("고블린", 20, 10, 15, 10, 1, 150, new Item[] {items[0], items[1]});
		System.out.println(m.name + "을 만났습니다. 전투를 시작합니다. ");
		
		int input = 0;
		battle : while(true) {
			System.out.println("1. 공격  2. 도망");
			input = ScanUtil.nextInt();
			switch(input) {
			case 1:
				c.attack(m);
				if(m.hp <= 0) {
					System.out.println(m.name + "을처치하였습니다.");
					c.getExp(m.exp);
					c.getItem(m.dropItem());
					break battle;
				}
				m.attack(c);
				break;
			case 2:
				System.out.println(m.name + "으로부토 도망쳤습니다.");
				break battle;
			}
		}
	}
	
	
	
}
