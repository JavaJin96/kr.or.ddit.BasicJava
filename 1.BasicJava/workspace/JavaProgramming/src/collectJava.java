import java.util.Arrays;
import java.util.Scanner;

public class collectJava {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int call = Integer.parseInt(s.nextLine());
		String [] callArr = s.nextLine().split(" ");
		
		int [] answer = new int [23];
		
		for(int i = 0 ; i < callArr.length; i++) {
			for(int j = 0; j < answer.length; j++) {
				if(callArr[i].equals(j)) {
					answer[i]++;
				}
				
			}
			
		}
		
		
		
	
		
		System.out.println(Arrays.toString(callArr));
		System.out.println(Arrays.toString(answer));
		
		
		
	}

}
