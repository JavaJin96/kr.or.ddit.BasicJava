package h_exception;

import java.io.IOException;

public class ThrowException {

	public static void main(String[] args) {
		// 예외 발생시키기
		try {
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		throw new NullPointerException(); //RuntimeException 의 자식 클래스라서 예외처리가 강제되지 않는다.
		
//		String str = null;
//		
//		str.equals("");
//		//null 값을 참조했다.

		
//		throw new IndexOutOfBoundsException();
		
//		int [] arr = new int [5];
//		
//		System.out.println(arr[5]);
//		//인덱스의 범위를 넘어갔다.
		
		
		
	}

}
