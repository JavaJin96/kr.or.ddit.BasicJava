package a_variable; //클래스의 위치

import java.util.Scanner;
//Ctrl + Shift + o



public class Variable { //클래스

	public static void main(String[] args) { //메서드
		//main 메서드는 : 프로그램의 시작과 끝

//		한줄 주석 : ctrl + shift + c
		/*범위 주석 : ctrl + shift + /(해제 : \)*/
		
	/*	데이터
		- 기본형
		- 배열
		- 클래스
		
		조작
		- 산술연산
		- 비교연산
		- 논리연산
		- 조건문
		- 반복문
		*/
		
		/*변수란? Data 를 저장하는 공간
		변수를 만드는 법 : 변수를 뭐라고 부르는가 / 변수에 무엇을 넣는가
		;; 데이터의 형태(데이터 타입) + 이름 */

		
	 /* 기본형 타입
	  * -정수 : byte(1), short(2), *int(4), long(8) 
	  * -실수 : float(4), *double(8)
	  * -문자 : char(2)
	  * -논리 : boolean(1) 
	  */
		
		
		int a;
		//'변수를 선언하다'라고 표현함
		
		double b;
		//{}블럭 안에서는 변수가 중복될 수 없다. double a;(X)
		
		//대입 연산자 : = (오른쪽 값을 왼쪽에 저장/할당한다. ;python 과  동일)
		
		a = 10; //초기화 : 변수에 처음으로 값을 저장하는 것.
		b = 3.14; // 변수의 타입에 맞는 값을 저장해야한다.
		
		int xyz = 30; //일반적으로 선언과 초기화를 한번에 한다.
		long l = 40L; //접미사 L을 붙여야 long 타입이 된다.
		float f = 5.5f; //접미사 F를 붙여야 float 타입이 된다.
		//접미사는 소문자와 대문자 구분이 필요가 없다. (L은 혼동의 여지 때문에 대문자로 사용한다.)
		char g = '한'; //'' 안에 반드시 한글자를 넣어야 한다.
		boolean t = true; //true , false 두가지 값만 온다.
		
		//8가지 기본형 타입을 사용해서 8개의 변수를 선언 및 초기화 해주세요.
		
		byte j = 1;
		short i = 3;
		int p = 5;
		long h = 400L;
		float q = 0.45f;
		double w = 3.14;
		char r = '닝';
		boolean y = false;
		
		//값을 한번더 저장해주면, 기존값을 사라지고 새로운 값으로 대체된다.
		
		j = 3;
		f = 6.6F;
		
		//변수를 사용할 때는  type을 쓰지 않는다.
		
		//위에서 만든 8개의 변수에 새로운 값을 저장해주세요.
	
		j = 8;
		i = 15;
		p = 26;
		h = 900L;
		q = 3.14f;
		w = 9.14;
	    r = '박';
		y = true;
		
	    /*변수의 명명 규칙
	     * - 영문자 대소문자, 한글, 숫자 , 특수문자('','$') 를 사용할 수 있다.
	     * - 숫자로 시작할 수 없다.
	     * - 예약어는 사용할 수 없다. (Java 내에서 이미 사용하고 있는 단어, ex. byte, short, int...)
	     * - [낙타식 표기법을 사용한다.(mySampleVariable)]
	     * - [클래스의 첫글자는 대문자로 한다. (MySampleClass)]
	     */
		
		//형변환(데이터의 타입을 다른 타입으로 변경하는 것)
		int _int = 10; // _int 는 정수(4) 타입이고 그 값은 10이다.
		long _long = 45L; // _long 은 정수(8) 타입이고 그 값은 45이다.
		
		_int = (int)_long;  // _long 의 타입을 _int 의 타입으로 변환 
		_long = _int; //표현범위가 작은 타입에서 큰 타입으로의 형변환은 생략할 수 있다.(표현 범위와 byte의 크기는 다른 개념이다.)
		
		
		//변수 3개를 선언해 변수의 타입과 다른 타입의 값으로 초기화 해주세요.
		
		int p1 = 10;
		float p2 = 3.14F;
		char p3 = 'a';
		
		p1 = (char) p3;
		p2 = (int) p1;
		p3 = (char) p2;

		
		//출력(콘솔)
		System.out.print("출력");
		System.out.println("출력 후 줄바꿈");
		System.out.printf("출력 포멧 지정"); //뒤에 포멧에 들어갈 값을 정해서 사용한다.
		// ctrl + F11
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

		
		p1 = 8;
		p2 = 8;
		
	    String str = "문자열";
		System.out.println(str + p1 + p2);
		System.out.println(p1 + p2 + str);
		//문자열 뒤에 오는 수는 문자열로 변경 / 반대의 경우는 숫자의 연산뒤에, 문자열이 붙는다.
		
		//탈출 문자(Escape 문자)
		System.out.println("탭은\t4칸에 맞춰 띄워줍니다.");
		System.out.println("줄바꿈을\n해줍니다.");
		System.out.println("\"쌍따옴표를 넣어줍니다.\"");
		System.out.println("   \"a\"  ");
		System.out.println("\\역슬래시를 넣어줍니다.");
		// \ 뒤에 오는 글자의 역활을 다른 역활로 변경(\t4 탭 4번, \n 줄바꿈, \뒤에 표기 그냥 문자열을 출력)
		
		// 입력
		//Scanner s = new Scanner(System.in); 
		//동일 클래스 안에 없기 때문에 컨파일 에러가 발생 따라서 위치를 알려줘야함.
		//import java.util.Scanner; (package 와 public 사이에 존재해야 함.)
		
		//System.out.print("메세지를 입력해주세요>>>");
		//String str2 = s.nextLine();
		//입력을 받을수 있는 메서드를 호출
		//System.out.println("입력받은내용 :"+ str2);
		//Scanner 메소드는 String 으로 답을 출력하기 때문에 String 의 변수값을 지정해준뒤 출력한다.
		
		
		//System.out.print("숫자 입력>");
		//int num = s.nextInt();
		//System.out.println("입력 받은 숫자 :" + num);
		////버그 때문에 가급적 사용하지 말 것
		//System.out.print("문자열 입력>>");
		//String str3 = s.nextLine();
		//System.out.println("입력받은 문자열 :" + str3);
		//System.out.println("입력 끝!");
		
		//String으로 입력 받고 그것을 숫자로 형변환 하는 방법을 사용한다.!
		
		//System.out.print("숫자입력>>");
		
		//기본형들의 형변환이 아니라 기존의 ()으로 형변환 할 수 없기 때문에 메소드를 사용해준다.
		//int num2 = Integer.parseInt(s.nextLine()); //정수 입력 
		//Double num3 = Double.parseDouble(s.nextLine());//실수 입력
		//System.out.println(num);
		
		
		
		
	//아래는 생각해 볼 것 
		//double d_num = 10.101010;
		//float f_num = 10.1010F;

		//int i_num;
		//i_num = (int)d_num; //Double-> Int
		//i_num = (int)f_num; //Float -> Int
		
		//System.out.println(i_num); 
		

		
		
		//자신의 이름을 저장할 변수를 선언하고 Scanner를 사용해 이름을 저장해주세요.
		
		Scanner s = new Scanner(System.in); // java의 메소드로서, 입력값을 받을 수 있게 해주는 Scanner 메소드를 사용할 수 있게해준다.
		//물론 상단에 import java.util.Scanner; import를 사용해야 Scanner 메소드를 사용할 수 있다.
		System.out.print("이름을 입력해주세요>>>");  //질의 사출 단계
		String myName = s.nextLine(); //실질적인 입력과 그 입력값을 변수 myName에 저장 단계
		//System.out.println("입력하신 이름은 :" + myName);//입력값을 출력하는 단계

	
		//자신의 나이를 저장할 변수를 선언하고 Scanner를 사용해 나이를 저장해주세요.
        System.out.print("나이를 입력해주세요>>>");
        int myAge = Integer.parseInt(s.nextLine());
        //system.out.print("당신의 나이는 :" + myAge);
        
        System.out.println("이름 :" + myName + "/ 나이" + myAge);
        
        
        
        
        
       
		
		
	}

}
