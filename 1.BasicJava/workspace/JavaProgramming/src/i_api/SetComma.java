package i_api;

import java.util.Arrays;

import e_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마를 붙여 출력해주세요.
		
		String input = ScanUtil.nextLine();
		String [] inputt = new String [input.length()];
		for(int i = 0; i < input.length(); i++) {
			inputt[i] = input.valueOf(input.charAt(i));
			System.out.println(inputt[i]);
		}
			System.out.println(Arrays.toString(inputt));
		for(int i = 0; i < inputt.length; i+=3) {
			inputt[i] = ","+ inputt[i];
			System.out.println(inputt[i]);
		}
		
		for(int i = 0; i < inputt.length; i++) {
			System.out.print(inputt[i]);
		}


	}

}
