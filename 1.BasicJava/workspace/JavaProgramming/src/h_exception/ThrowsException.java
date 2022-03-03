package h_exception;

import java.io.IOException;

public class ThrowsException {

	public static void main(String[] args) {
		//메서드에 예외 선언하기
		
		try {
			method();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	

		
	}

	private static void method() throws IOException {
		throw new IOException();
	}//메서드를 호출한 애가 예외처리를 한다.


}
