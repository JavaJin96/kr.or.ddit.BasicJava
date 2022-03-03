package f_game.BaseBallGame;

import e_oop.ScanUtil;

public class BaseballGame {

	public static void main(String[] args) {
		
		Team t1 = new Team();
		t1.money = 2000;
		Team2 t2 = new Team2();
		
		
		
		
		int [] hScore = new int[10];
		int [] aScore = new int[10];
		
		for(int i = 0; i < hScore.length; i++) {
			hScore[i] = 0;
			aScore[i] = 0;
		}
				
		Players a = new Players("박",23);
		Players b = new Players("신",19);
		
		new Players("박", 23);
		new Players("신", 19);
		
		start : while(true) {
			System.out.println("=====\t  = \t======\t======\t\t=====\t  =\t==\t==");
			System.out.println("=    =\t = =\t=     \t=    \t\t=    =\t = =\t==\t==");
			System.out.println("======\t=====\t======\t======\t\t======\t=====\t==\t==");
			System.out.println("=    =\t=   =\t     =\t=   \t\t=    =\t=   =\t==\t==");
			System.out.println("=====\t=   =\t======\t======\t\t=====\t=   =\t=====\t=====");
			System.out.println("사용하실 구단명을 입력해주세요.================================================");
			t1.teamName = ScanUtil.nextLine();
		
			
		
			menu : while(true) {
			System.out.println("==============================");
			System.out.println("로비");
			System.out.println("1. 나의팀"+"\t" +"2. 경기시작" +"\t" + "3. 설명");
			int input = ScanUtil.nextInt();
		
			robby : while(true) {
			switch(input) {
			case 1 : System.out.println("==============================");
					 System.out.println("나의팀");
					 System.out.println("1. 로스터관리\t2. 선수 훈련\t3. 상점" + "\t" + "4. 뒤로가기");
					 int input12 = ScanUtil.nextInt();
					 if(input12 == 1) {	
						 System.out.println("==============================");
						 System.out.println("로스터관리");
						 System.out.println("1. 선수정보\t2.전체선수 정보\t3. 타순변경" + "\t" + "4.뒤로가기");
						 int input112 = ScanUtil.nextInt();
						 if(input112 == 1) {
							 System.out.println(t1.teamName +"===========");
							 System.out.println("구단보유자금 : " + t1.money);
							 for(int i = 0; i < t1.p.length; i++) {
								 System.out.println(i+1 + "." + t1.p[i].name);	
								 }
							 System.out.println("몇번 선수의 정보를 열람할까요?======================");
							 int input113 = ScanUtil.nextInt();
							 t1.p[input113-1].PlayersStatus();
						 }
					if(input112 == 2) {
						System.out.println("====================");
						System.out.println(t1.teamName);
						System.out.println("구단보유자금 : " + t1.money);
						for(int i = 0; i < t1.p.length; i++) {
							t1.p[i].PlayersStatus();				 
						}
					}
					
					if(input112 ==3) {
						System.out.println("변경할 선수의 번호를 입력하세요.======================");
						int input113 = ScanUtil.nextInt();
						Players mp;
						System.out.println("변경할 타순을 입력하세요.======================");
						int input114 = ScanUtil.nextInt();
						mp = t1.p[input114-1];
						t1.p[input114-1] = t1.p[input113-1];
						t1.p[input113-1] = mp;
						t1.p[input113-1].num = input113;
						t1.p[input114-1].num = input114;
						System.out.println("변경되었습니다.======================");
					}
					if(input112 ==4) {
						continue robby;
					}
					 
						 continue robby ;
					 }
					 if(input12 == 2) {
						 System.out.println("선수훈련======================");
						 System.out.println("어느 선수를 훈련하시겠습니까?(선수번호 입력)===========");
						 int input14 = ScanUtil.nextInt();
						 System.out.println("어느 능력치를 훈련하시겠습니까?===========");
						 System.out.println("0. 전부\t1. 컨트롤\t2. 파워\t3. 스피드\t4. 수비\t5. 구속\t6. 구질\t7. 컨트롤");
						 int input13 = ScanUtil.nextInt();
						 if(input13 == 0 && t1.money >= 500) {
							 t1.money -= 500;							 
						 }else if(t1.money >= 100){t1.money -= 100;}
						 System.out.println("잔여 구단자금 : "+ t1.money);
						 System.out.println("훈련 전 능력치>>>>>");
						 t1.p[input14-1].PlayersStatus();
						 if(input14 == 1) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 2) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 3) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 4) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 5) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 6) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 7) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 8) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 9) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 10) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 11) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 12) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 else if(input14 == 13) {
							 t1.p[input14-1].trainning(input13);		 
						 }
						 System.out.println("훈련 후 능력치>>>>>");
						 a.trainning(input13);
						 t1.p[input14-1].PlayersStatus();
						 
						 continue robby ;
					 }
					 if(input12 == 3) {
						 System.out.println("선수영입======================");
						 System.out.println("어느 선수를 영입하겠습니까?===========");
						 System.out.println("1. 일반선수(500)\t2. 스페셜선수(1000)");
						 int input15 = ScanUtil.nextInt();
						 if(input15 == 1 && t1.money >= 500) {
							 t1.money -= 500;
							 System.out.println("잔여 구단자금 : "+ t1.money);
							 //Players [] npa = new Players [1];
							 System.out.println("방출할 선수를 선택해주세요.======================");
							 int input16 = ScanUtil.nextInt();
							 System.out.println("영입할 선수명을 입력해주세요.======================");
							 String input17 = ScanUtil.nextLine();
							 Players np = new Players(input17,input16);
							 //npa[0] = t1.p[input16-1];
							 t1.p[input16-1] = np;
						 }
						 else if(input15 == 1 && t1.money < 500) {
							 System.out.println("구단자금이 부족합니다.");
						 }
						 if(input15 == 2 && t1.money >= 1000) {
							 t1.money -= 1000;
							 System.out.println("잔여 구단자금 : "+ t1.money);
							 System.out.println("방출할 선수를 선택해주세요.======================");
//							 for(int i = 0; i < t1.p.length;i++) {
//								 t1.p[i].PlayersStatus();
//							 }
							 int input18 = ScanUtil.nextInt();
							 System.out.println("영입할 선수명을 입력해주세요======================");
							 String input19 = ScanUtil.nextLine();
							 Players nrp = new Players("임의진",8);
							 nrp.NewRplayers(input19, input18);							 
							 t1.p[input18-1] = nrp;
							 System.out.println("===============영입이 완료되었습니다.=================");
						 }
						 else if(input15 == 2 && t1.money < 1000) {
							 System.out.println("구단자금이 부족합니다.");
						 }
						 continue robby;
					 }
					 if(input12 == 4) {
						 continue menu;
					 }
			
			case 2 : System.out.println("===================경기시작========================");
					 System.out.println(t1.teamName + "\t" + "VS " + "\t" + t2.teamName);
			
			
			int ing = 1;
			int out = 0;
			int strike = 0;
			int ball = 0;
			
			int base = 0;
			int acount = 0;
			int hcount = 0;
			
			int ascorecount = 0;
			int hscorecount = 0;
			
			
			ingame : do {//전체 경기
						
						while(out <= 2){//~회 초
								
								System.out.println("==================================================");
								System.out.println(" < " + ing + "회 초>");
								System.out.println(t1.p[acount].num + "번타자\t" + t1.p[acount].name);
								System.out.println("아웃 : " + out + "  스트라이크 : " + strike + "  볼 : " + ball);
								System.out.println("1. 스윙\t2. 번트\t3. 선수교체");
								int input21 = ScanUtil.nextInt();
								if(input21 == 1) {
									int comp = t1.p[acount].HitAndPit(t2.p[9], t1.p[acount]);
									if(comp == 1) {
										base++;
										acount++;
										if(acount == 9 ) {
											acount = 0;
										}
										strike = 0;
										ball = 0;
										System.out.println("안타!");
										if(base >= 4) {
											aScore[ing-1] ++;
											ascorecount++;
											base = 3;
											System.out.println("3루 주자 홈인!");
											System.out.println("현재스코어");
											System.out.println(hscorecount + ":" + ascorecount);
										}
										
										System.out.println(out + "아웃");
										acount++;
										System.out.println("주자");
										for(int i = 1; i <= base; i++) {
											System.out.print(i + "루,");
										}
										ScanUtil.nextLine();
									}
									else if(comp == 0) {
										aScore[ing-1] += base +1;
										acount++;
										ascorecount += base +1;
										if(acount == 9 ) {
											acount = 0;
										}
										strike = 0;
										ball = 0;
										base = 0;
										System.out.println("홈런!!!!");
										System.out.println("현재스코어");
										System.out.println(hscorecount + ":" + ascorecount);
										ScanUtil.nextLine();
									}
									else if(comp == 2){ 
										out++;
										acount++;
										if(acount == 9 ) {
											acount = 0;
										}
										strike = 0;
										ball = 0;
										System.out.println("플라이 아웃!");
										System.out.println(out +"아웃");
										ScanUtil.nextLine();
									}
									else if(comp == 3) {
										System.out.println("볼");
										ball++;
										System.out.println("스트라이크 : " + strike + "  볼 : " + ball);
										if(ball == 4) {
											System.out.println("볼 넷!");
											acount++;
											if(acount == 9 ) {
												acount = 0;
											}
											base++;
											strike = 0;
											ball = 0;
											if(base == 4) {
												System.out.println("밀어내기 볼넷!");
												base = 3;
												aScore[ing]++;
												ascorecount++;
												System.out.println("현재스코어");
												System.out.println(hscorecount + ":" + ascorecount);
											}
										}
										ScanUtil.nextLine();
											
									}
									else if(comp == 4) {
											strike++;
											System.out.println("스트라이크!");
											System.out.println("스트라이크 : " + strike + "  볼 : " + ball);
											if(strike ==3) {
											System.out.println("삼진 아웃!");
											acount++;
											if(acount == 9 ) {
												acount = 0;
											}
											out++;
											strike = 0;
											ball = 0;
										}
											ScanUtil.nextLine();
									}
									
								}
								else if(input21 == 2) {System.out.println("번트");
									
									if(50 > (int)(Math.random()*101)+1) {
										out++;
										strike = 0;
										ball = 0;
										System.out.println("번트실패..");
										acount++;
										if(acount == 9 ) {
											acount = 0;
										}
										System.out.println( out +"아웃");
									}
									else {
										acount++;
										if(acount == 9 ) {
											acount = 0;
										}
										base++;
										System.out.println("번트 성공!!");
										strike = 0;
										ball = 0;
										if(base == 4) {
											System.out.println("밀어내기 볼넷!");
											base = 3;
											aScore[ing]++;
											ascorecount++;
											System.out.println("현재스코어");
											System.out.println(hscorecount + ":" + ascorecount);
										}
										
									}
									ScanUtil.nextLine();
								
								}
								else if(input21 == 3) {
									
									Players cp = new Players("임의진",8);
									cp = t1.p[acount];
									System.out.println("누구와 교체하겠습니까?======================");
									System.out.println("1. " + t1.p[10].name);
									System.out.println("2. " + t1.p[11].name);
									System.out.println("3. 뒤로가기");
									int input25 = ScanUtil.nextInt();
									if(input25 == 1) {
										t1.p[acount] = t1.p[10];
										t1.p[10] = cp;
										t1.p[acount].num = t1.p[10].num;
										t1.p[10].num = t1.p[acount].num;
									}else if(input25 == 2) {
										t1.p[acount] = t1.p[11];
										t1.p[11] = cp;
										t1.p[acount].num = t1.p[11].num;
										t1.p[11].num = t1.p[acount].num;
									}else if(input25 ==3) {
										continue ingame;
										
									}
									continue ingame;
								}
							
								
						}
						
						 out = 0;
						 strike = 0;
						 ball = 0;
						
						 base = 0;
						System.out.println("==================================================");
						System.out.println("3아웃 체인지!");
						while(out <= 2) {//~회 말
								
								System.out.println("==================================================");
								System.out.println(" < " + ing + "회 말>");
								System.out.println(t2.p[hcount].num + "번타자\t" + t2.p[hcount].name);
								System.out.println("아웃 : " + out + "  스트라이크 : " + strike + "  볼 : " + ball);
								System.out.println("1. 투구\t2. 고의사구\t3. 선수교체");
								int input31 = ScanUtil.nextInt();
								if(input31 == 1) {
									int comp = t2.p[hcount].HitAndPit(t1.p[9], t2.p[hcount]);
									if(comp == 1) {
										base++;
										hcount++;
										if(hcount == 9 ) {
											hcount = 0;
										}
										strike = 0;
										ball = 0;
										System.out.println("안타!");
										if(base >= 4) {
											hScore[ing-1] ++;
											hscorecount++;
											base = 3;
											System.out.println("3루 주자 홈인!");
											System.out.println("현재스코어");
											System.out.println(hscorecount + ":" + ascorecount);
		
										}
										
										System.out.println(out + "아웃");
										hcount++;
										System.out.println("주자");
										for(int i = 1; i <= base; i++) {
											System.out.print(i + "루,");
										}
										ScanUtil.nextLine();
									}
									else if(comp == 0) {
										hScore[ing-1] += base +1;
										hscorecount+= base +1;
										hcount++;
										if(hcount == 9 ) {
											hcount = 0;
										}
										strike = 0;
										ball = 0;
										base = 0;
										System.out.println("홈런!!!!");
										System.out.println("현재스코어");
										System.out.println(hscorecount + ":" + ascorecount);
										ScanUtil.nextLine();
									}
									else if(comp == 2){ 
										out++;
										hcount++;
										if(hcount == 9 ) {
											hcount = 0;
										}
										strike = 0;
										ball = 0;
										System.out.println("플라이 아웃!");
										System.out.println(out +"아웃");
										ScanUtil.nextLine();
									}
									else if(comp == 3) {
										System.out.println("볼");
										ball++;
										System.out.println("스트라이크 : " + strike + "  볼 : " + ball);
										if(ball == 4) {
											System.out.println("볼 넷!");
											hcount++;
											if(hcount == 9 ) {
												hcount = 0;
											}
											base++;
											strike = 0;
											ball = 0;
											if(base == 4) {
												System.out.println("밀어내기 볼넷!");
												base = 3;
												hScore[ing]++;
												hscorecount++;
												System.out.println("현재스코어");
												System.out.println(hscorecount + ":" + ascorecount);
											}
										}
										ScanUtil.nextLine();	
									}
									else if(comp == 4) {
											strike++;
											System.out.println("스트라이크!");
											System.out.println("스트라이크 : " + strike + "  볼 : " + ball);
											if(strike ==3) {
											System.out.println("삼진 아웃!");
											hcount++;
											if(hcount == 9 ) {
												hcount = 0;
											}
											out++;
											strike = 0;
											ball = 0;
										}
											ScanUtil.nextLine();
									}
									
								}
								else if(input31 == 2) {
									ball = 0;
									System.out.println("볼 넷!");
									base++;
									hcount++;
									if(hcount == 9 ) {
										hcount = 0;
									}
									strike = 0;
									ball = 0;
									ScanUtil.nextLine();
								}
								else if(input31 == 3) {
									Players cp = new Players("임의진",8);
									cp = t1.p[acount];
									System.out.println("누구와 교체하겠습니까?======================");
									System.out.println("1. " + t1.p[12].name);
									System.out.println("2. 뒤로가기" );
									int input27 = ScanUtil.nextInt();
									if(input27 == 1) {
										t1.p[9] = t1.p[12];
										t1.p[12] = cp;
										t1.p[9].num = t1.p[12].num;
										t1.p[12].num = t1.p[9].num;
									}
									else if(input27 == 2) {
										continue;
									}
									continue;
								}
	
								
						}
						
						
						out = 0;
						strike = 0;
						ball = 0;
						base = 0;
						
						System.out.println(ing + "이닝 종료!!!");
						ing ++;
						System.out.println("팀명 " + "\t" + "1" + "\t" + "2" +"\t" + "3" + "\t" + "4" + "\t" + "5" + "\t" + "6" + "\t" + "7" + "\t" + "8" + "\t" + "9" + "\t" + "s");
						System.out.print(t1.teamName);
						aScore[9] = ascorecount;
						hScore[9] = hscorecount;
						for(int i = 0; i < hScore.length; i++) {
							System.out.print("\t" + aScore[i]);
						}System.out.println(" ");
						System.out.print(t2.teamName);
						for(int i = 0; i < hScore.length; i++) {
							System.out.print("\t" + hScore[i]);	
						}
						System.out.println(" ");
					
				}while(ing <= 9);
					System.out.println("==================경기종료=====================");
					t1.money += 5000;
					break robby;
			
			case 3 : System.out.println("=======================================");
					 System.out.println("설명");
					 System.out.println("1. 이 게임은 플레이어가 팀의 감독이 되어 라이벌팀 '최강구단' 의 경기에서 승리하는 것을 목표로 합니다.");
					 System.out.println("2. 플레이어는 구단자금을 활용해 새로운 선수 영입, 기존 선수 훈련을 할 수 있습니다.");
					 System.out.println("3. 팀에는 13명의 선수가 소속되어 있습니다.");
					 System.out.println("4. 각 선수번호는 다음과 같습니다.");
					 System.out.println("1~9번은 주전 타자.");
					 System.out.println("10번은 선발투수.");
					 System.out.println("11~12번은 교체타자.");
					 System.out.println("13번은 교체투수.");
					 continue menu;
			}
		}
			
			
			
			}
			
			
		}
		
		
		
		
	}

}
