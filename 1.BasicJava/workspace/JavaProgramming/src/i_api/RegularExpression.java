package i_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import e_oop.ScanUtil;

public class RegularExpression {

	public static void main(String[] args) {
		/*
		 *  정규표현식 : 문자열의 패턴을 검사하는 표현식
		 *  
		 *  ^  뒷 문자로 시작
		 *  $  앞 문자로 종료
		 *  .  임의의 문자(줄바꿈 제외)
		 *  *  앞 문자가 0개 이상
		 *  +  앞 문자가 1개 이상
		 *  ?  앞 문자가 없거나 1개
		 *  []  문자의 집합이나 범위([a-z: a부터 z까지)
		 *  {}  앞 문자의 개수({2}:2개 , {2,4}:2개 이상 4개 이하)
		 *  ()  그룹화(1개의 문자처럼 인식)
		 *  |  or연산
		 *  \s  공백, 탭, 줄바꿈
		 *  \S  공백, 탭, 줄바꿈이 아닌 문자
		 *  \w  알파벳이나 숫자
		 *  \W  알파벳이나 숫자가 아닌 문자
		 *  \d  숫자
		 *  \D  숫자가 아닌문자
		 *  (?i)  뒷 문자의 대소문자 구분 안함
		 *  \  정규표현식에서 사용되는 특수문자 표현
		 */
		
		String str = "abc123";
		String str1 = "01033099771";
		String str2 = "dico3655@naver.com";
//		String regex = "abc123";
//		String regex = "[a-z]{3}[0-9]{1,3}"; 알파벳 뒤에 숫자만 가능
//		String regex = "[a-z0-9]+";  // 알파벳 숫자가 섞여도 가능
		String regex = "\\w*";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
		
		//아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규표현식을 만들어주세요.
		
		String id = "[a-z0-9]{5,20}";
		String pNumber = "\\d[0-9]{11}";
		String mAdress = "[a-z0-9]{5,20}.@[a-z0-9][a-z]";
		
		Pattern p1 = Pattern.compile(mAdress);
		Matcher m1 = p1.matcher(str);
		System.out.println(m1.matches());
		
		//아이디 : [a-z0-9_-]{5,20}
		//전화번호 : ^0\\d{1,2}-\\d{3,4}-\\d{4}
		//이메일주소 : [a-z0-9_-]{5,20}@[a-zA-Z]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))$
		
		
//		
//		String name = ScanUtil.nextLine();
//		String id2 = "[a-z0-9_-]{5,20}";
//		
//		
//		Pattern p2 = Pattern.compile(name);
//		Matcher m2 = p2.matcher(name);
//		System.out.println(m2.matches());
//		
		
		
	}

}
