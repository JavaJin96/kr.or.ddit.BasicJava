package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		int money = (int)(Math.random()*500) *10;
		int[] coin = {500, 100, 50, 10 };
		
		System.out.println("거스름돈 : " + money);

		
		/*
		 * 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요.
		 * 
		 * 거스름돈 : 2860원
		 * 500원 : 5개
		 * 100원 : 3개
		 * 50원 : 1개
		 * 10원 : 1개
		 * 
		 * 500원짜리의 필요한 개수를 구한다.
		 * 500원짜리를 거스른 나머지를 구한다.
		 */
		
	

		/*for ( int i = 0; i < coin.length; i++) {
			int count = money / coin[i];
			money = money % coin[i];
			System.out.println(coin[i] + " " + count);
		}
		
		int exc500 = money / coin[0];
		int exc100 = (money % coin[0]) / coin[1];
		int exc50 = ((money % coin[0]) % coin[1]) / coin[2];
		int exc10 = (((money % coin[0]) % coin[1]) % coin[2]) / coin[3];
		
		System.out.println("500원 : " + exc500);
		System.out.println("100원 : " + exc100);
		System.out.println("50원 : " + exc50);
		System.out.println("10원 : " + exc10);*/
		
		
		int[] arr = new int [20];
		for( int i = 0; i < arr.length; i++ ) {
			arr[i] = (int)(Math.random()*5) +1;
		}
		//System.out.println(Arrays.toString(arr));
		/*
		 * 1~5의 숫자가 발생된 횟수 만큼 *을 사용해 그래프를 그려주세요.
		 * 
		 * 1 : ***3
		 * 2 : ****4
		 * 3 : **2
		 * 4 : *****5
		 * 5 : ******6
		 */
	
		
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i] == 1) {
//				count[0]++;}
//			else if(arr[i] == 2) {
//				count[1]++;
//			}
//			else if(arr[i] == 3) {
//				count[2]++;
//			}
//			else if(arr[i] == 4) {
//				count[3]++;
//			}
//			else if(arr[i] == 5) {
//				count[4]++;
		
//			}
//			
//		}
		
		int [] count = new int [5];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= 5; j++) {
				if (arr[i] == j+1) {
					count[j]++;
				}	
			}	
		}
		
		/* int [] count = new int [5];
		 * for (int i = 0; i < arr.length; i++){
		 * counts[arr[i]-1]++;   //값이 1이면 -1 한      0번 인덱스에 넣는다.의 원리
		 * }
		 * 
		 * 
		 * arr 인덱스가 1이면 카운트 인덱스는 0 카운트 인덱스0 의 값을 1증가시킴;
		 * 
		 * arr { 1,5,2,2,2,3,4,5,5,2,3,2}
		 * counts {0,0,0,0,0}
		 * 
		 * 
		 */
		
		
		
		for (int i = 0; i < count.length; i++) {
			System.out.print(i+1 + " : ");
			for (int j = 0; j < count[i]; j++) {
				System.out.print("*" );
			}
			System.out.println(" " + count[i] + " ");
		}
		
		//System.out.println(Arrays.toString(count));
		
		
		arr = new int [10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() *5) +1;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr));
		
		/*
		 * 1~5의 랜덤한 값이 1개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
		 * [2, 2, 2, 4, 1, 1, 4, 2, 1, 2]
		 * [2,4,1]
		 */
		
		
		/*do {
			 * 		int random = (int)(Math.random() * students.length);
			 * 		
			 * 		boolean flag = true;
			 * 		for(int i = 0 ; i < pick.length; i++){
			 * 			if(students[random].equals(pick[i])){
			 * 				flag = false;}
			 * 				}
			 *  if(flag) {
			 *  	pick[pickCount++] = students[random];
			 *  }
			 *  
			 * }while(pickCount < count);*/
		
		
		int count1 [] = new int [10];
		
		for ( int i = 0; i < arr.length; i++);
		
		
		
		
		/*
		 * int temp [] = new int [5];
		 * int count = 0;
		 * for ( int i = 0; i < arr.length; i++) {
		 * 		boolean flag = true;
		 * 		for (int j = 0 ; j < temp.length; j++){
		 * 			if(arr[i] == temp[j]){
		 * 					flag = false;}
		 * 						}
		 * 		if(flag) {temp [count++] = arr[i];}
		 * }
		 * int temp2 [] = new int[count];
		 * for(int i = 0; i < temp2.length; i++){
		 * 	temp2[i] = temp[i];
		 * }
		 * System.out.println(Arrays.toString(temp2));
		 * 
		 * 
		 * 
		 */
		
		
		
	}

}
