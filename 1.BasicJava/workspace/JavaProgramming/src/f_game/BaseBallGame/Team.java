package f_game.BaseBallGame;

public class Team {
	
	static String teamName;
	static int money = 1000;
	Players p [] = new Players[13];
	
	
	
	Team() {
		for(int i = 0; i < p.length; i++) {
			p[0] = new Players("민진홍", 1);
			p[1] = new Players("노현정", 2);
			p[2] = new Players("박상진", 3);
			p[3] = new Players("이정수", 4);
			p[4] = new Players("양승혁", 5);
			p[5] = new Players("강정윤", 6);
			p[6] = new Players("주창규", 7);
			p[7] = new Players("김재웅", 8);
			p[8] = new Players("고성식", 9);
			p[9] = new Players("이유정", 10);
			p[10] = new Players("박상현", 11);
			p[11] = new Players("김은혜", 12);
			p[12] = new Players("김민경", 13);
			
			p[i].con = (int)(Math.random()*101)+1;
			p[i].pow = (int)(Math.random()*101)+1;
			p[i].speed = (int)(Math.random()*101)+1;
			p[i].def = (int)(Math.random()*101)+1;
			p[i].bspeed = (int)(Math.random()*101)+1;
			p[i].bmove = (int)(Math.random()*101)+1;
			p[i].bcon = (int)(Math.random()*101)+1;
		}
	}

	
}

