package e_oop.score2;

public class Student {
	
	String name;
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	int rank;
	

	
int kor() {
	return (int)(Math.random()*101);
}
int eng() {
	return (int)(Math.random()*101);
}
int math() {
	return (int)(Math.random()*101);
}
	
int sum() {
	return  kor + eng + math;
}

double avg() {
	return Math.round((sum / 3.0)*100)/100.0;
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
