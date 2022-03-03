package f_game.BaseBallGame;

public class Players {
	
	
	
	String name;
	int num;
	int con;
	int pow;
	int speed;
	int def;
	//투수능력치
	
	int bspeed;
	int bmove;
	
	int bcon;
	
	
	
	Players(String name, int num  ){
		
		this.num = num;
		this.name = name;
		con = (int)(Math.random()*101)+1;
		pow = (int)(Math.random()*101)+1;
		speed = (int)(Math.random()*101)+1;
		def = (int)(Math.random()*101)+1;
		bspeed = (int)(Math.random()*101)+1;
		bmove = (int)(Math.random()*101)+1;
		bcon = (int)(Math.random()*101)+1;
		
	}
	
	void NewRplayers(String name, int num) {
		this.num = num;
		this.name = name;
		con = (int)(Math.random()*51)+50;
		pow = (int)(Math.random()*51)+50;
		speed = (int)(Math.random()*51)+50;
		def = (int)(Math.random()*51)+50;
		bspeed = (int)(Math.random()*51)+50;
		bmove = (int)(Math.random()*51)+50;
		bcon = (int)(Math.random()*51)+50;
		
	}
	
	void PlayersStatus() {
		System.out.println("========선수정보=========");
		System.out.println(num);
		System.out.println(name);
		System.out.println("=====타=====");
		System.out.println("컨택트 : " + con );
		System.out.println("파워 : " + pow);
		System.out.println("주루스피드 : " + speed);
		System.out.println("수비 : " + def);
		System.out.println("=====투=====");
		System.out.println("구속 : " + bspeed);
		System.out.println("구질 : " + bmove);
		System.out.println("제구 : " + bcon);
		System.out.println("========================");
		
	}
	
	void trainning(int i) {
		if(con <= 100 && i == 1 || i ==0) {
			con += (int)(Math.random()*4)+1;
			if(con >= 100) {
				con = 100;
			}
		}
		if(pow <= 100 && i == 2 || i ==0) {
			pow += (int)(Math.random()*4)+1;
			if(pow >= 100) {
				pow = 100;
			}
		}
		if(speed <= 100 && i == 3 || i ==0) {
			speed += (int)(Math.random()*4)+1;
			if(speed >= 100) {
				speed = 100;
			}
		}
		if(def <= 100 && i == 4 || i ==0) {
			def += (int)(Math.random()*4)+1;
			if(def >= 100) {
				def = 100;
			}
		}
		if(bspeed <= 100 && i == 5 || i ==0) {
			bspeed += (int)(Math.random()*4)+1;
			if(bspeed >= 100) {
				bspeed = 100;
			}
		}
		if(bmove <= 100 && i == 6 || i ==0) {
			bmove += (int)(Math.random()*4)+1;
			if(bmove >= 100) {
				bmove = 100;
			}
		}
		if(bcon <= 100 && i == 7 || i ==0) {
			bcon += (int)(Math.random()*4)+1;
			if(bcon >= 100) {
				bcon = 100;
			}
		}

	}
	
	/*int Hitting (Players p, Players h) {
		int realHnum = 0;
		if( (p.bspeed+p.bmove/2 < h.con) ) {
			if( (h.pow - p.bspeed) >= 35 ) {
				realHnum = 100;
			}else if ( (h.pow - p.bspeed) + (h.speed - p.def) >= 30 ) {
				realHnum = 50;
			}else {
				realHnum = 0;
			}
		}
		return realHnum;
	}
	int a = 0;
	 int Pitching (Players p, Players h) {
		 int realNum = 0;
		if( (p.bspeed+p.bmove/2 > h.con) ) {
			realNum = (p.bspeed + p.bmove/2) + (p.bcon/10);
			 if( (int)(Math.random()*realNum+2)+1 >= a ) {
				 a = 1; //strike
			 }
			 else {
				 a = 11; //ball
			 }
		}else {
			 a = Hitting(h, p);
		}
		return a;
	}*/	
	
	int HitAndPit (Players other, Players me) {
		int result = 0;
		if (me.bspeed + me.bmove / 2 <= other.bcon ) {
			if(other.pow - me.bspeed >= 50) {
				result =  0;
			}
			else if ((other.pow - me.bspeed) - (other.speed - me.def) > 35) {
				result =  1;
			}
			else {result =  2;}
		}
		else if(me.bspeed + me.bmove / 2 > other.bcon) {
			if(me.bcon > (int)(Math.random()*101)+1) {
				 result =  3;
			}
			else {
				 result =  4;
			}
		}
	
		else {result = 4;}
		return result;
	}
	
	 
	 
	 
	
}