package e_oop.score;

import java.util.Arrays;

public class Score {

	public static void main(String[] args) {
		
		// 성적 처리 프로그램 만들기
		String[] studentsNames = {"민진홍", "노현정", "박상진", "이정수"};
		Student[]  students = new Student[studentsNames.length];
		
		for(int i = 0; i < students.length; i++) {
			students[i] = new Student();
			students[i].name = studentsNames[i];
			students[i].kor = (int)(Math.random()*101);
			students[i].eng = (int)(Math.random()*101);
			students[i].math = (int)(Math.random()*101);
			students[i].rank = 1;
		}
		
		for(int i = 0; i <= 3; i++) {
			students[i].sum = students[i].kor + students[i].eng + students[i].math;
			students[i].avg = students[i].sum / 3.0;
			students[i].avg = Math.round((students[i].avg = students[i].sum / 3.0)*100)/100.0;
		}
			
		for(int i = 0; i < students.length; i++) {
			for(int j = 0; j < students.length; j++) {
				if (students[i].avg < students[j].avg) {
					students[i].rank++;
				}
			}
		}
		
		System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" +
							"합계" + "\t" + "평균" + "\t" +"석차");
		for(int i = 0; i < students.length ; i++) {
			System.out.print(students[i].name + "\t" + students[i].kor + "\t" + students[i].eng + "\t" 
						+ students[i].math + "\t" + students[i].sum + "\t" + students[i].avg + "\t" + students[i].rank);
			System.out.println( " " );
		}
		
		
		int sumKor = 0;
		int sumEng = 0;
		int sumMath = 0;
		double avgKor = 0;
		double avgEng = 0;
		double avgMath = 0;
		
		
		
		
		for(int i = 0; i < students.length; i++) {
			sumKor += students[i].kor;
			sumEng += students[i].eng;
			sumMath += students[i].math;
			
			avgKor = Math.round((sumKor / 4.0)*100)/100.0;
			avgEng = Math.round((sumEng / 4.0)*100)/100.0;
			avgMath = Math.round((sumMath / 4.0)*100)/100.0;
			
			
			
			
		}
		System.out.print("과목합계" + "\t");
		System.out.print(sumKor + "\t" + sumEng + "\t" + sumMath + "\t" + "\n");
		System.out.print("과목평균" + "\t");
		System.out.print(avgKor + "\t" + avgEng + "\t" + avgMath + "\t");
		System.out.println(" ");
		
		
		
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////석차순 정렬		
		
		System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" +
				"합계" + "\t" + "평균" + "\t" +"석차");
		
		for(int i = 0 ; i < students.length; i++) {
			Student [] students1 = new Student[students.length];
			for (int j = 0; j < students.length; j++) {
				if (students[i].rank < students[j].rank) {
					students1[i] = students[i];
					students[i] = students[j];
					students[j] = students1[i];
				}
			}
		}
		for(int i = 0; i < students.length ; i++) {
			System.out.print(students[i].name + "\t" + students[i].kor + "\t" + students[i].eng + "\t" 
						+ students[i].math + "\t" + students[i].sum + "\t" + students[i].avg + "\t" + students[i].rank);
			System.out.println( " " );
		}
		
		int sumKor1 = 0;
		int sumEng1 = 0;
		int sumMath1 = 0;
		double avgKor1 = 0;
		double avgEng1 = 0;
		double avgMath1 = 0;
		
		for(int i = 0; i < students.length; i++) {
			sumKor1 += students[i].kor;
			sumEng1 += students[i].eng;
			sumMath1 += students[i].math;
			
			avgKor1 = Math.round((sumKor1 / 4.0)*100)/100.0;
			avgEng1 = Math.round((sumEng1 / 4.0)*100)/100.0;
			avgMath1 = Math.round((sumMath1 / 4.0)*100)/100.0;
			
		}
		System.out.print("과목합계" + "\t");
		System.out.print(sumKor1 + "\t" + sumEng1 + "\t" + sumMath1 + "\t" + "\n");
		System.out.print("과목평균" + "\t");
		System.out.print(avgKor1 + "\t" + avgEng1 + "\t" + avgMath1 + "\t");
		System.out.println(" ");

		
	}

}
