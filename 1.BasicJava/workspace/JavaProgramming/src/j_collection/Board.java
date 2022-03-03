package j_collection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board {

   public static void main(String[] args) {
      /*
       *  ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
       *  조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
       *  
       *  컬럼 : 번호, 제목, 내용, 작성자, 작성일
       *  
       *  첫화면 : 목록
       *  목록 : 조회, 등록, 종료
       *  조회 : 수정, 삭제, 목록
       *  
       * ================================
       * 번호     제목         작성자      작성일
       * --------------------------------
       * 3   안녕         홍길동      11/26
       * 2   안녕         홍길동      11/26
       * 1   안녕         홍길동      11/26
       * ================================
       * 1. 조회 2.등록 0.종료>    
       *  
       *  
       *  
       */
      
      ArrayList<HashMap<String, Object>> board = new ArrayList<>();
      HashMap<String, Object> contents = new HashMap<>();
      
      int count = 0;
      int boardCount = 0;
      Date today = new Date();
      SimpleDateFormat format1;
      format1 = new SimpleDateFormat("yyyy-MM-dd");
      
      int input = 0;
      menu : while(true) {
         System.out.println("게시판");
         System.out.println("===========================================");
         System.out.println("번호 \t 제목 \t\t 작성자 \t\t 작성일");
         System.out.println("-------------------------------------------");
         
         for(int  i = board.size()-1; i >= 0; i--) {
            System.out.print(board.get(i).get("번호") + "\t");
            System.out.print(board.get(i).get("제목")+ "\t\t");
            System.out.print(board.get(i).get("작성자")+ "\t\t");
            System.out.print(board.get(i).get("작성일")+ "\n");
         }
         System.out.println("===========================================");
         System.out.println("1.조회 \t 2.등록\t 0.종료 ");
         System.out.print("행동을 입력해주세요.");
         input = ScanUtil.nextInt();
         
         switch(input) {
         
         case 1 :    
                  System.out.print("몇번 게시글을 확인할까요? : ");
                  int input1 = ScanUtil.nextInt();
                  System.out.println("===========================================");
                  con1 : for(int i = 0 ; i < board.size(); i++) {
                     if(input1 == (int)board.get(i).get("번호")) {
                        System.out.println("번호 \t 제목 \t\t 작성자 \t\t 작성일");
                        System.out.println("-------------------------------------------"); 
                        System.out.print(board.get(i).get("번호") + "\t");
                          System.out.print(board.get(i).get("제목")+ "\t\t");
                          System.out.print(board.get(i).get("작성자")+ "\t\t");
                          System.out.print(board.get(i).get("작성일")+ "\n");
                          System.out.print(board.get(i).get("내용")+ "\t\n");
                          System.out.println("===========================================");
                          System.out.println("1.수정 \t 2.삭제\t 0.목록 ");
                          System.out.print("행동을 입력해주세요.");
                          int input2 = ScanUtil.nextInt();
                          if(input2 == 1) {
                        	  System.out.println("===========================================");
                              System.out.print("제목을 입력해주세요 : ");
                              String title = ScanUtil.nextLine();
                              System.out.print("내용을 입력해주세요 : ");
                              String content = ScanUtil.nextLine();
                              
                              board.get(i).put("제목", title);
                              board.get(i).put("내용", content);
                             
                             
                          }
                          else if(input2 == 2) {
                             System.out.print("정말 삭제하시겠습니까?(1.예  2.아니오)");
                             int input4 = ScanUtil.nextInt();
                             if(input4 == 1) {
                            	 for(int j = 0; j < board.size(); j++) {
                            		 if((int)board.get(i).get("번호") < (int)board.get(j).get("번호")) {
                            			 board.get(j).put("번호",j);
                            			 count = j;
                            		 }
                            	 }
                                board.remove(i);
                                System.out.println("삭제되었습니다.");
                             }
                             else if (input4 == 2){
                                break con1;
                             }
                          }
                          else if(input2 == 0) {
                             continue menu;                             
                          }
                        
                     }
                     
                  }
                  continue menu;
            
         case 2 :    
                  contents = new HashMap<>();
                  count++;
                  System.out.println("===========================================");
                  System.out.print("제목을 입력해주세요 : ");
                  String title = ScanUtil.nextLine();
                  System.out.print("작성자를 입력해주세요 : ");
                  String writer = ScanUtil.nextLine();
                  System.out.print("내용을 입력해주세요 : ");
                  String content = ScanUtil.nextLine();
                  
         
                  contents.put("번호", count);
                  contents.put("제목", title);
                  contents.put("내용", content);
                  contents.put("작성자", writer);
                  contents.put("작성일", format1.format(today));
                  board.add(contents);
                  boardCount++;
                  continue menu;
            
         case 0 : 
                  System.out.println("게시판을 종료합니다.");
                  break menu;

         }
   
      }

      
   }

}