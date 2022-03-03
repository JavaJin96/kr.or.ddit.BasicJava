package f_game.BaseBallGame;

public class inGame {
	
	int [] aScore = new int [10];
	int [] hScore = new int [10];

	
	int innings;
	int out;
	int strike;
	int ball;
	int base;
	
	
	void score() {
		
	}
	
	
	
	void GameRuel () {
		if(out == 3) {
			innings++;
			System.out.println("3아웃 공수 교대!");
		}
		if(strike == 3) {
			out++;
		}
		if(base == 4) {
			base = 3;
			System.out.println("3루 주자 홈인!");
		}
		
	}
	
	void GameBoard () {
		
	}

	
	
	
	
	
	
}
