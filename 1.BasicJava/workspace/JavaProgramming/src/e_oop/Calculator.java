package e_oop;

public class Calculator {

	// +, -, *, /, % 다섯개의 연산을수행할 수 있는 계산기 클래스를 만들어주세요.
	
	double sum(double x, double y) {
		return  x + y;
	}
	double min(double x, double y) {
		return x - y;
	}
	double mul(double x, double y) {
		return x * y;
	}
	double div(double x, double y) {
		return x / y;
	}
	double divn(double x, double y) {
		return x % y;
	}
	
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		double a = c.sum(123456, 654321);
		double b = c.mul(a, 123456);
		double c1 = c.div(b, 123456);
		double d = c.min(c1, 654321);
		double e = c.divn(d, 123456);
		System.out.println(e);
		
		
		
	}
	
	
	
	
	
}
