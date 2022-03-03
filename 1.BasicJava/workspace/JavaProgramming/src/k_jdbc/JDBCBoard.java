package k_jdbc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.DefaultEditorKit.InsertContentAction;

import e_oop.ScanUtil;

public class JDBCBoard {
	
	static int	boardNO;
	static String title;
	static String content;
	static String memId;
	static Date regDate = new Date();
	static SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd");
	static int count = 0;
	
	static JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	
	public static void main(String[] args) {
			
		
		main : while(true) {
			System.out.println("=====================================");
			System.out.println("<게시판>");
			System.out.println("=====================================");
			
			showRobby();
			System.out.println("=====================================");
			System.out.println("1. 조회\t 2. 등록\t 0. 종료");
			int input = ScanUtil.nextInt();
			 if(input != 1 && input !=2 && input != 0){
				System.out.println("올바르지 않은 값을 입력하셨습니다. [1,2,0] 중에 하나를 입력해주세요.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			 	
			switch(input) {
			
				case 1:
					System.out.println("몇번자료를 열람할까요?");
					int input1 = ScanUtil.nextInt();
					showDetail(input1);
					break;
				
				case 2:
					insertContent();
					break;
					
				case 0:
					System.out.println("게시판을 종료합니다.");
					break main;
			
			}

		}
	
		
	}

	
	static void showRobby () {
		
		String sql = "select board_no, SUBSTR(title,1,4), SUBSTR(mem_id,1,4), SUBSTR(REG_DATE,1,10) from tb_jdbc_board order by 1 desc";
		List<Map<String, Object>> list = jdbc.selectList(sql);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).get("BOARD_NO")+"\t");
			System.out.print(list.get(i).get("SUBSTR(TITLE,1,4)")+"\t");
			System.out.print(list.get(i).get("SUBSTR(MEM_ID,1,4)")+"\t");
			System.out.print(list.get(i).get("SUBSTR(REG_DATE,1,10)")+ "\n");
		}
		
	}
	
	static void insertContent () {
		ArrayList<Object> param = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		count++;
		System.out.println("제목을 입력해주세요 : ");
		title = ScanUtil.nextLine();
		System.out.println("작성자를 입력해주세요 : ");
		memId = ScanUtil.nextLine();
		System.out.println("내용을 입력해주세요 : ");
		content = ScanUtil.nextLine();
		
		param.add(title);
		param.add(content);
		param.add(memId);
		

		String sql = "  INSERT INTO TB_JDBC_BOARD (BOARD_NO, TITLE, CONTENT, MEM_ID, REG_DATE) "
				+ "VALUES ( (SELECT MAX(BOARD_NO)+1 FROM TB_JDBC_BOARD),?,?,?,(SELECT SYSDATE FROM DUAL))";
		
		jdbc.update(sql, param);
		
		
	}

	static void showDetail(int i) {
		ArrayList<Object> param = new ArrayList<>();
		String sql = "select * from tb_jdbc_board where board_no = ?";
		
		param.add(i);
		
		List<Map<String, Object>> list = jdbc.selectList(sql,param);
		System.out.println("=====================================");
		detail : for(int j = 0; j < list.size(); j++) {
			System.out.print(list.get(j).get("BOARD_NO") + "\t");
			System.out.print(list.get(j).get("TITLE") + "\t");
			System.out.print(list.get(j).get("REG_DATE") + "\t" + "\n");
			System.out.println("-------------------------------------");
			System.out.print(list.get(j).get("CONTENT") + "\t");
			System.out.println();
		}
		System.out.println("=====================================");		
		System.out.println("1. 수정\t 2. 삭제\t 0. 뒤로가기");
		int input1 = ScanUtil.nextInt();
		if(input1 == 1) {
			updateContent(i);
		}
		else if(input1 == 2) {
			System.out.println("정말 삭제하시겠습니까?[Y/N]");
			String input2 = ScanUtil.nextLine();
			if(input2.equals("Y")){
				deleteContent(i);				
			}
			else {
				System.out.println("올바르지 않은 값을 입력하셨습니다.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("메인 화면으로 돌아갑니다.");
			}
		}
		else if(input1 == 0) {
			
		}
		else if(input1 != 1 && input1 !=2 && input1 != 0){
			System.out.println("올바르지 않은 값을 입력하셨습니다. [1,2,0] 중에 하나를 입력해주세요.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("메인 화면으로 돌아갑니다.");
		}
	}
	
	static void updateContent(int i) {
		System.out.println("=====================================");
		ArrayList<Object> param = new ArrayList<>();
		System.out.println("제목을 입력해주세요 : ");
		title = ScanUtil.nextLine();
		System.out.println("내용을 입력해주세요 : ");
		content = ScanUtil.nextLine();
		
		String sql = "update tb_jdbc_board set title = ? , content = ? where BOARD_NO = ?";
		
				
		param.add(title);
		param.add(content);
		param.add(i);
		
		jdbc.update(sql, param);
		
		System.out.println("수정되었습니다.");
		System.out.println("=====================================");
		
	}
	
	static void deleteContent(int i) {
		ArrayList<Object> param = new ArrayList<>();

		String sql = "delete from tb_jdbc_board where board_no = ?";
		
		param.add(i);
		
		jdbc.update(sql, param);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("삭제되었습니다.");
		
	}
	
	

}
