package g_oop2;

public abstract class SampleAbstractParent {

	void method() {
		
	}
	
	//추상 메서드
	//추상 메서드를 하나라도 가지게 되면 추상 클래스가 된다.
	//추상 메서드는 객체 생성을 할 수 없다.
	//부모 클래스의 역할을 하기 위해 만든다.
	
	abstract void abstractMethod();
	
}


class SampleAbstractChild extends SampleAbstractParent{

	@Override
	void abstractMethod() {
		
	}
	
}
