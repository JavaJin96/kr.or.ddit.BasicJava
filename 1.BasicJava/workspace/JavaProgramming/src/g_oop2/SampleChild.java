package g_oop2;

public class SampleChild extends SampleParent {
	
	void childMethod() {
		//상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var); // 상속받은 변수	
		System.out.println(method(7, 13)); //상속받은 메서드
	}
	
	
	//오버라이딩 : 상속받은 메서드를 변경하는 것.
	//super, super() : this 와 유사하다. 부모클래스 맴버와 자식클래스의 맴버의 이름이 같을때 사용한다.
	//다형성 
	
	//오버라이딩 : 상속받은 메서드의 내용을 재정의 하는 것.
	@Override //어노테이션 : 클래스, 변수, 메서드 등에 표시해 놓는 것
	int method(int a, int b) {
		return a * b;
	}
	
	//super, super()
	int var;
	
	void test(double var) {
		System.out.println(var); //지역변수인 var가 출력
		System.out.println(this.var); //전역변수(인스턴스 변수) 
		System.out.println(super.var); //부모클래스의 전역변수(상속받은것)
		
		System.out.println(this.method(10, 20)); // 자식클래스의 메서드
		System.out.println(super.method(10, 20)); // 부모클래스의 매서드
	}
	
	SampleChild(){
		super(); //부모클래스의 생성자 호출, 생성자의 첫줄에서만 사용할 수 있다.
	}
	
	
	//다형성
	public static void main(String[] args) {
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleChild();
//		SampleParent sp = (SampleParent) new SampleChild();
		
//		SampleChild sc2 = new SampleParent(); //불가능
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
