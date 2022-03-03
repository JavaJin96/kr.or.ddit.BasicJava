package f_game.SoccerGame;

import java.util.Arrays;

public class Player {
	
	String name;
	//String team;
	
	int shot;
	int pass;
	int drib;
	int speed;
	int def;
	int tac;
	int pos;
	int gk;
	int avgStatus = (shot + pass + drib + speed + def + tac + pos + gk) / 8;
	
	int RealStat;
	boolean result;
	
	
	Player(){
		//this.name = name;
		shot = (int)(Math.random()*100)+1;
		pass = (int)(Math.random()*100)+1;
		drib = (int)(Math.random()*100)+1;
		speed = (int)(Math.random()*100)+1;
		def = (int)(Math.random()*100)+1;
		tac = (int)(Math.random()*100)+1;
		pos = (int)(Math.random()*100)+1;
		gk = (int)(Math.random()*100)+1;
		//this.avgStatus = (this.name + this.shot + this.pass + this.drib) /2;
	}
	
	
	
	
	void playersStatus () {
		System.out.println("평균능력치 : " + avgStatus);
		System.out.println("이름 : " + name);
		System.out.println("슈팅 : " + shot);
		System.out.println("패스 : " + pass);
		System.out.println("드리볼 : " + drib);
		System.out.println("속도 : " + speed);
		System.out.println("몸싸움 : " + def);
		System.out.println("태클 : " + tac);
		System.out.println("위치선정 : " + pos);
		System.out.println("골키퍼 : " + gk);
	}
	
	
	
	
	
	void creatPlayers() {
		Player players[] = new Player[6];
		for (int i = 0; i < players.length; i++) {
			players[0].name= "a";
			players[1].name = "b";
			players[2].name = "c";
			players[3].name = "d";
			players[4].name = "e";
			players[5].name = "f";
			shot = (int)(Math.random()*100)+1;
			pass = (int)(Math.random()*100)+1;
			drib = (int)(Math.random()*100)+1;
			speed = (int)(Math.random()*100)+1;
			def = (int)(Math.random()*100)+1;
			tac = (int)(Math.random()*100)+1;
			pos = (int)(Math.random()*100)+1;
			gk = (int)(Math.random()*100)+1;
		}	
	}
	
	
	void trainning(Player p, Team t) {
		t.money = -100;
		if(this.shot <= 100	) {
			this.shot += (int)(Math.random()*3);
			if(this.shot > 100) {
				this.shot = 100;
			}
		}
		if(this.pass <= 100	) {
			this.pass += (int)(Math.random()*3);
			if(this.pass > 100) {
				this.pass = 100;
			}
		}
		if(this.drib <= 100	) {
			this.drib += (int)(Math.random()*3);
			if(this.drib > 100) {
				this.drib = 100;
			}
		}
		if(this.speed <= 100	) {
			this.speed += (int)(Math.random()*3);
			if(this.speed > 100) {
				this.speed = 100;
			}
		}
		if(this.def <= 100	) {
			this.def += (int)(Math.random()*3);
			if(this.def > 100) {
				this.def = 100;
			}
		}
		if(this.tac <= 100	) {
			this.tac += (int)(Math.random()*3);
			if(this.tac > 100) {
				this.tac = 100;
			}
		}
		if(this.pos <= 100	) {
			this.pos += (int)(Math.random()*3);
			if(this.pos > 100) {
				this.pos = 100;
			}
		}
		if(this.gk <= 100	) {
			this.gk += (int)(Math.random()*3);
			if(this.gk > 100) {
				this.gk = 100;
			}
		}
		
	}
	
	//matching
	void inGameCompet() {
		RealStat -= 5;
		int Snum = (int)(Math.random()*100) + 1;
		if(Snum > RealStat) {
			result = false;
		}else {result = true;
		}
	}
	
	
	
	
	//player's method
	void inGamePass(Player p) {
		if(pass <= p.pos) {
			 RealStat = pass * 60/100;
		}else if(pass > p.pos) {
			 RealStat = pass;
		}
		inGameCompet();	
	}
	
	void inGameDri(Player p) {
		if(drib <= (p.tac + p.def)/2) {
			 RealStat = drib * 60/100;
		}else if(drib > (p.tac + p.def)/2) {
			 RealStat = drib;
		}
		inGameCompet();	
	}
	
	void inGameShoot(Player p) {
		if(shot <= p.gk) {
			 RealStat = shot * 60/100;
		}else if(shot > p.gk) {
			 RealStat = shot;
		}
		inGameCompet();	
	}
	
	void inGameDefence(Player p) {
		if((def+tac)/2 >= p.drib) {
			RealStat = (def + tac)/2;
		}else {RealStat = ((def + tac)/2) * 60/100;
		}
		inGameCompet();	
	}
	
	void inGamePassSteal(Player p) {
		if(pos > p.pass) {
			RealStat = pos;
		}else{RealStat = pos * 60 / 100;
		}
	}
	

	
}
