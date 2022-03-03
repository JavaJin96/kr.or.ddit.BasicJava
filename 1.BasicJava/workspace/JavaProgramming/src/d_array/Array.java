package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열
		 *  - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 *  - 참조형 타입이다.
		 *  - 인덱스로 값을 구분한다.
		 *  - 길이를 변경 할 수 없다.
		 * 
		 */
		
		int[] array; //int array[]; 도 가능
		array = new int[5];  //5개의 값을 저장할 배열을 만들었다.
		System.out.println(array);
		/*
		 * array(변수) = 100번지(주소)
		 * 
		 * 100번지(첫번째 값의 주소가 기준)
		 * {0,0,0,0,0}
		 * 
		 */
		
		array = new int [] {1,2,3,4,5};
		System.out.println(array);
		
//		array = {1, 2, 3, 4, 5}; 반드시 변수의 선언과 같이 해야한다.
		int[] array2 = {1, 2, 3, 4, 5};
		
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);

		
		// 배열이름.length 배열의 길이
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (i + 1) * 10;
		}
		

		// 10개의 정수를 저장할 수 있는 배열을 선언 및 초기화
		int [] a = new int [10];
		
		// 배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장해주세요.
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 100)+1;
		}
		
		// 배열에 저장된 모든 값의 합계와 평균을 출력해주세요.
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		double avg = (double)sum / a.length;
		System.out.println("합계 : " + sum + " 평균 : " + avg );
		
		
		// 배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.
		int max = 0;
		int min = 100;
		for (int i = 0; i < a.length; i++ ) {
			if (a[i] >= max) {max = a[i];}	
			if (a[i] <= min) {min = a[i];}
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		
		int[] shuffle = new int[10];
		for(int i = 0; i < shuffle.length; i++) {
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));
		//배열의 값을 섞어 주세요.
		
		//랜덤한 인덱스를 만들고, 가장 앞의 숫자랑 섞는 과정을 반복한다.
		
		int temp = 0;
		int temp1 = 0;
		for (int i = 0; i <= 200; i++) {
			temp = shuffle[0];
			temp1 = (int)(Math.random()*9)+1;
			shuffle[0] = shuffle[temp1];
			shuffle[temp1] = temp;
			
		}
		System.out.println(Arrays.toString(shuffle));
		
		
		// 1~10 사이의 랜던값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		
	/*	
	 *  int [] num = new int [500];
		int [] score1 = new int [10];
		
		for (int i = 0; i < 500; i++) {
			num[i] = (int)(Math.random()*10)+1; 
			if (num[i] == 1) {score1[0]++;}
			else if (num[i]==2) {score1[1]++;}
			else if (num[i]==3) {score1[2]++;}
			else if (num[i]==4) {score1[3]++;}
			else if (num[i]==5) {score1[4]++;}
			else if (num[i]==6) {score1[5]++;}
			else if (num[i]==7) {score1[6]++;}
			else if (num[i]==8) {score1[7]++;}
			else if (num[i]==9) {score1[8]++;}
			else if (num[i]==10) {score1[9]++;}
		}
			
		System.out.println(Arrays.toString(score1));
		
		*
		*/
		

		int[] counts = new int[10];
		
		for(int i = 0; i < 500; i++) {
			int random = (int)(Math.random()*10) +1;
			counts[random -1]++;
		}
		System.out.println(Arrays.toString(counts));
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
