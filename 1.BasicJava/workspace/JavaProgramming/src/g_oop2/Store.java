package g_oop2;

public class Store {

	public static void main(String[] args) {

		Desktop d = new Desktop();
		Product p = new Aircon();
		TV tv = new TV();
		
		Customer c = new Customer();
		
		c.buy(d);
		c.buy(p);
		c.buy(tv);
		System.out.println(c.money);

		
	}

}


class Product{
	String name;
	int price;
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	
	@Override    //Object 클래스의 toString 메서드를 호출하여 오버라이딩함.
	public String toString() {                //toString() 메서드를 만들어서 출력
		return name + "(" + price + "원)";
	}
}

class Desktop extends Product{
	Desktop(){
		super("삼성 컴퓨터", 1000000);
	}
	void programming() {
		System.out.println("프로그램을 만듭니다.");
	}
}

class Aircon extends Product{
	Aircon(){
		super("LG 에어컨", 200000);
	}
	void setTemperature() {
		System.out.println("온도를 설정합니다.");
	}
}

class TV extends Product{
	TV(){
		super("LG TV", 3000000);
	}
	void setChannel() {
		System.out.println("채널을 변경합니다.");
	}
}

class Customer{
	int money = 1000000000;
	
	Product[] item = new Product[10];
	//다형성의 예) 자식객체를 부모객체로 형변환하여 넣었음.
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔돈이 부족합니다.");
			return; //메서드를 종료시킨다.
		}
		
		money -= p.price;
		
		for(int i = 0; i < item.length; i++) {
			if(item[i] == null) {
				item[i] = p;
				break;
			}
		}
		System.out.println(p + "를 구매했습니다.");
		
		
	}
	
}












