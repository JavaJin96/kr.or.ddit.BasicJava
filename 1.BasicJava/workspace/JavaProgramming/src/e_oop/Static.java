package e_oop;

public class Static {

	/*
	 *  - static 을 붙이면 프로그램 실행 시 메모리에 올라간다.
	 *  - 객체생성을 하지 않아도 사용할 수 있다.
	 *  - static 을 붙인 변수는 객체간에 변수의 값을 공유한다.
	 *  - static 이 붙은 맴버의 명칭 : 클래스 변수, 클래스 메서드
	 *  - static 이 붙지 않은 맴버의 명칭 : 인스턴스 변수, 인스턴스 메서드
	 *  
	 *   JVM 메모리 구조
	 *  **(자바에서 사용하는 컴퓨터 속의 가상의 컴퓨터, 자바에서 프로그램을 사용할 때 사용한다.
	 *    주요 사용 목적은 프로그램 하나로 여러 운영체제에서 이용하기 용이하기 때문)
	 *    
	 *  - Method area(메서드 영역) : 클래스 맴버가 저장된다.(static 이 붙어 있는 곳이 Method area)
	 *  - Heap : 객체가 저장된다.
	 *  ** static 이 붙으면 Method area, 안 붙으면 Heap 에서 처리한다.
	 *  
	 *  - Call Stack(호출 스택) : 현재 호출되어 있는 메서드가 저장된다.
	 *  
	 */
	
	// 변수 : 값을 공유하기 위해 static을 붙인다.
	// 메서드 : 객체 생성을 하지 않고 사용하기 위해서.
	
	static int var;
	
	public static void main(String[] args) {
		Marine m1 = new Marine();
		Marine m2 = new Marine();
		
		System.out.println(m1.hp);
		System.out.println(m2.hp);
		
		m1.hp--;
		
		System.out.println(m1.hp);
		System.out.println(m2.hp);
		
		System.out.println(m1.att);
		System.out.println(m2.att);
		
		m1.att++;
		
		System.out.println(m1.att);
		System.out.println(m2.att);
		
		
		System.out.println("문자열 입력>");
		String nextLine = ScanUtil.nextLine();
		System.out.println("입력받은 문자열 : " + nextLine);
		
		System.out.println("숫자 입력>");
		int nextInt = ScanUtil.nextInt();
		System.out.println("입력받은 숫자 : " + nextInt);

		
	}

}



class Marine{
	int hp = 40;			//체력	
	static int att = 5; 	//공격력
	static int def = 0;		//방어력
	
}


