package f_game.BaseBallGame;

public class Team2 {
	
	 String teamName = "최강구단";
	static int money = 1000;
	Players p [] = new Players[13];
	
	
	
	
	Team2() {
		for(int i = 0; i < p.length; i++) {
			p[0] = new Players("정지수",1);
			p[1] = new Players("양동현",2);
			p[2] = new Players("조화랑",3);
			p[3] = new Players("손효선",4);
			p[4] = new Players("정석철",5);
			p[5] = new Players("한영민",6);
			p[6] = new Players("김민호",7);
			p[7] = new Players("양아연",8);
			p[8] = new Players("이응주",9);
			p[9] = new Players("황선부",10);
			p[10] = new Players("박세준",11);
			p[11] = new Players("이기석",12);
			p[12] = new Players("김승섭",13);
			
			
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

