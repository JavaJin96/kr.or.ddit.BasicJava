package e_oop.score2;

import java.util.Arrays;

public class Score {

	public static void main(String[] args) {
		
		
		String [] studentNames = {"이단비","김노을","정현욱","박소현","김수진","이의현","강건","이민영",
								"하기재","이윤우","김미희","김혜윤","신승철","이광효","김진혁","마창수",
								"양기욱","이동근","석기현","류인성","이미정","임나리","송민섭","김지윤",
								"조명석"
								};
		Student [] students = new Student[studentNames.length]; 
		
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student();
			students[i].kor = students[i].kor();
			students[i].eng = students[i].eng();
			students[i].math = students[i].math();
			students[i].sum = students[i].sum();
			students[i].avg();
			students[i].rank = 1;
		}
		
		for (int i = 0; i < students.length; i++) {
			for(int j = 0; j < students.length; j++) {
				if(students[i].avg() < students[j].avg()) {
					students[i].rank++;
				}
			}
		}
		
		System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" +
				"합계" + "\t" + "평균" + "\t" +"석차");
		
		for (int i = 0; i < students.length; i++) {
			System.out.print(studentNames[i] + "\t" + students[i].kor + "\t" + students[i].eng + "\t" +
		students[i].math + "\t" + students[i].sum + "\t" + students[i].avg() + "\t" + students[i].rank + "\n");
		}
		
		
		
		
		
		
		
		
		///////////////////////////////////////맞음
		
		
		int sum [] = new int [3];
		for (int i = 0; i < students.length; i++) {
			sum[0] += students[i].kor;
			sum[1] += students[i].eng;
			sum[2] += students[i].math;
		}
		double avg [] = new double [3];
		for (int i = 0; i < avg.length; i++) {
			avg[i] = (double)sum[i] / students.length;
		}
		
		System.out.print("과목합계" + "\t");
		for (int i = 0; i < sum.length; i++) {
			System.out.print(sum[i] + "\t");
		}
		System.out.print("\n" +"과목 평균" + "\t");
		for (int i = 0; i < avg.length; i++) {
			System.out.print(avg[i] + "\t");
		}
		
		

		
	}

}
