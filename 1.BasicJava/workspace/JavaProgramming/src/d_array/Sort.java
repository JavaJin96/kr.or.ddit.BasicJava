package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * - 석차구하기 : 점수를 비교해 작은 점수의 등수를 증가시키는 방식
		 * - 선택정렬 : 가장 작은 숫자를 찾아서 앞으로 보내는 방식
		 * - 버블정렬 : 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		 * - 삽입정렬 : 두번재 숫자부터 앞의 숫자들과 비교해서 큰수는 뒤로 밀고 중간에 삽입하는 방식
		 */

		
		// 석차구하기
		int [] arr= new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		/*int[] rank = new int[arr.length];
		for(int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
		*/
		
		// 선택정렬
		
		/*for(int i = 0; i < arr.length; i++) {
		int min = i;
		for (int j = i; j < arr.length; j++) {
			if(arr[j] < arr[min]) {
				min = j;
			}
		}
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
		
		}
		
		System.out.println(Arrays.toString(arr));
		*/
	
		
		// 최소값 구하기
		/*int max = 0;
		int min = 100;
		int count = 0;
		int count1 = 0;
		int temp = 0;
		
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>max) {
				max = arr[i];
				count = i;	
			}
			else if (arr[i]<min) {
				min = arr[i];
				count1 = i;
			} 
				
		}
		
		for (int i = 0; i < arr.length; i++) {
			temp = arr[i];
			arr[i] = arr[count1];
			arr[count1] = temp;
			
		}
		
	
		
	
		System.out.println(Arrays.toString(arr));
		System.out.println(max);
		System.out.println(min);
		System.out.println(count);
		System.out.println(count1);
*/
		
		
		
		
		
		// 버블정렬
		
		
		for (int j = 0; j < arr.length; j++) 
		{
			//for (int i = 0; i < arr.length-1 - i; i++) : -i를 해주면 비교하는 숫자가 점점 줄어든다.
		for (int i = 0; i < arr.length-1; i++) {
			 if (arr[i] > arr[i+1]) {
				int temp = 0;
				temp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;	
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		
		// 삽입정렬
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
