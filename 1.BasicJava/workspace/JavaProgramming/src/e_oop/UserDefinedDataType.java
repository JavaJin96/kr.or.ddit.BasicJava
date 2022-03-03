package e_oop;

public class UserDefinedDataType {

	public static void main(String[] args) {
		/*
		 * 사용자 정의 데이터 타입
		 *  - 데이터의 최종 진화 형태이다. (기본형 - 배열 - 클래스)
		 *  - 서로 다른 타입의 데이터를 묶어서 사용하는 것이다.
		 *  - 변수와 메서드로 구성할 수 있다.
		 */
		
		//각각 변수
		int kor;
		int eng;
		int math;
		int sum;
		double avg;
		
		//배열 변수
		int[] scores;
		int sum2;
		double avg2;
		
		//클래스
		Student student = new Student(); 
		// 객체 생성(인스턴스화) 초기화를 해준다고 볼 수 있다. / 실제로 사용할 수 있게 메모리에 올려놓는 단계.
		// 타입 , 변수명 = 객체 생성 
		
		student.kor = 80;
		student.eng = 90;
		student.math = 75;
		student.sum = student.eng + student.kor +student.math;
		student.avg = student.sum / 3.0;
		
		System.out.println("합계 :" + student.sum + " / 평균 :" + student.avg);
		
		System.out.println(student.random);
		
		
		Student [] students = new Student[5]; //참조형 타입의 기본값은 null; 이며 null; 이 들어가 있는 상태
		students[0] = new Student();
		students[1] = new Student();
		students[2] = new Student();
		students[3] = new Student();
		students[4] = new Student();
		
		students[0].kor = 99;
		
		
		
	
	}

}
	
class Student{
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	int random = (int)(Math.random()*100)+1;
	
}
















