package j_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class BoardUtilOOP {
	
	ArrayList<HashMap<String, Object>> board = new ArrayList<>();
	HashMap<String, Object> contents = new HashMap<>();
	
	String title;
	String content;
	String writer;
	int num;
	Date today = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd");
	
	
	BoardUtilOOP(){
		contents.put("제목",title);
		contents.put("내용",content);
		contents.put("작성자",writer);
		contents.put("번호",num);
		contents.put("작성일",format.format(today));		
	}
	
	void input () {
		contents = new HashMap<>();
		System.out.println("제목을 입력해주세요 : ");
		title = ScanUtil.nextLine();
		System.out.println("작성자를 입력해주세요 : ");
		writer = ScanUtil.nextLine();
		System.out.println("내용을 입력해주세요 : ");
		content = ScanUtil.nextLine();
		
		num++;
		contents.put("제목", title);
		contents.put("번호", num);
		contents.put("내용", content);
		contents.put("작성자", writer);
		contents.put("작성일", format.format(today));
		board.add(contents);
		
	}
	
	void insert (int i) {
		System.out.println("제목을 입력해주세요 : ");
		title = ScanUtil.nextLine();
		System.out.println("내용을 입력해주세요 : ");
		content = ScanUtil.nextLine();
		
		board.get(i-1).put("제목", title);
		board.get(i-1).put("내용", content);
		
		System.out.println("수정되었습니다.");
	}
	
	void delete (int i) {
		for(int j = 0; j < board.size(); j++) {
			if((int)board.get(i-1).get("번호") < (int)board.get(j).get("번호")){
				board.get(j).put("번호", (int)board.get(j).get("번호")-1);
				num = j;
			}
		}
		board.remove(i-1);
		System.out.println("삭제되었습니다.");
	}
	
	void showRobby() {
		System.out.println("대덕인재개발원 게시판");
		System.out.println("번호\t 제목\t 작성자\t 작성일");
		System.out.println("=============================================");
		for(int j = board.size()-1; j >= 0; j--) {
			System.out.print(board.get(j).get("번호") + "\t");
			System.out.print(board.get(j).get("제목") + "\t");
			System.out.print(board.get(j).get("작성자") + "\t");
			System.out.println(board.get(j).get("작성일") + "\t");
		}
		System.out.println("=============================================");
		System.out.println("1. 조회\t 2. 등록\t 0. 종료");
	}
	
	void showDetail(int i) {
		System.out.println("=============================================");
		System.out.println("번호\t 제목\t 작성자\t 작성일");
		System.out.println("——————————————————————");
		System.out.print(board.get(i-1).get("번호") + "\t");
		System.out.print(board.get(i-1).get("제목") + "\t");
		System.out.print(board.get(i-1).get("작성자") + "\t");
		System.out.println(board.get(i-1).get("작성일") + "\t");
		System.out.println(board.get(i-1).get("내용"));
		System.out.println("=============================================");
		System.out.println("1. 수정\t 2. 삭제\t 0. 뒤로가기");
		
	}
	
	
	
	
}