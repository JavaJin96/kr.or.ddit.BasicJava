package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BoardDao;
import util.ScanUtil;
import util.View;

public class BoardService {
	//싱글톤 패턴
		private BoardService() {}
		private static BoardService instance;
		public static BoardService getInstance() {
			if(instance == null) {
				instance = new BoardService();
			}
			return instance;
		}
		
		
		int temp = 0;
		
		private BoardDao boardDao = BoardDao.getInstance();
		
		public int boardList() {
			List<Map<String, Object>> boardList = boardDao.selectBoardList();
			
			System.out.println("======================================");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("======================================");
			for (int i = 0; i < boardList.size(); i++) {
				Map<String, Object> board = boardList.get(i);
				System.out.print(board.get("BOARD_NO") + "\t");
				System.out.print(board.get("TITLE") + "\t");
				System.out.print(board.get("MEM_ID") + "\t");
				System.out.print(board.get("REG_DATE") + "\t");
				System.out.println();
			}
			System.out.println("==============================================");
			
			System.out.println("1. 조회 2. 등록 0. 로그아웃>");
			int input = ScanUtil.nextInt();
			
			switch(input) {
			case 1 : 
				
				return View.BOARD_VIEW;
			case 2 :
				
				return View.BOARD_INSERT;
			case 0 :
				Controller.LoginMember = null;
				return View.HOME;
			}
			
			return View.BOARD_LIST;
			
				
			
		}
		
		
		public int boardView() {
			BoardDao.getInstance();
			List<Map<String, Object>> boardList = boardDao.selectBoardList();
			
			System.out.println("몇번 자료를 열람하시겠습니까?");
			int i = ScanUtil.nextInt();
			boardList = boardDao.detailBoardView(i);
			temp = i;
			

			System.out.print(boardList.get(0).get("BOARD_NO") + "\t");
			System.out.print(boardList.get(0).get("TITLE") + "\t");	
			System.out.print(boardList.get(0).get("MEM_ID") + "\t");
			System.out.print(boardList.get(0).get("REG_DATE") + "\t" + "\n");
			System.out.println("========================================");
			System.out.print(boardList.get(0).get("CONTENT")+ "\n");
			
			
			System.out.println("========================================");
			System.out.println("1. 수정 2. 삭제 0. 글목록>");
			
			int input = ScanUtil.nextInt();
			switch(input) {
			case 1 :
				return View.BOARD_UPDATE;
			case 2 :
				boardDelete();
			case 0 :
				return View.BOARD_LIST;
			}
			return View.BOARD_VIEW;
			
		}
		
		public int boardUpdate () {
			
			BoardDao.getInstance();
			System.out.println("제목을 입력해주세요>");
			String title = ScanUtil.nextLine();
			System.out.println("내용을 입력해주세요>");
			String content = ScanUtil.nextLine();
			
			int result = boardDao.BoardUpdate(title, content, temp);
			System.out.println(result + "개의 정보가 수정되었습니다.");
			
			return View.BOARD_LIST;
			
			
		}
		
		public int boardDelete() {
			boardDao.getInstance();
			System.out.println("삭제하시겠습니까? Y/N");
			String input = ScanUtil.nextLine();
			if(input.equals("Y")) {
				boardDao.BoardDelete(temp);
			}else if(input.equals("N")) {
				System.out.println("잘못 입력하셨습니다.");
				return View.BOARD_LIST;
			}
			return View.BOARD_LIST;
			
		}
		
		public int boardInsert() {
			boardDao.getInstance();
			boardDao.BoardInsert();
			
			return View.BOARD_LIST;
			
		}

		
		
		
}
