package j_collection;

import java.util.ArrayList;

public class score {

   public static void main(String[] args) {
         /*
          * 우리반 모두의 국어 영어, 수학 ,사회 ,과학, Oracle, Java, 점수를
          * 0~100 까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.
          * 
          * 이름          국어      영어      수학      사회     과학       Oracle   Java    합계           평균         석차
          * 박상진        90    90    90    90   90      90      90      630     90.00    1
          * 이정수        90    90    90    90   90      90      90      630     90.00    1
          * 노현정        90    90    90    90   90      90      90      630     90.00    1
          * 정지수        90    90    90    90   90      90      90      630     90.00    1
          * 양동현        90    90    90    90   90      90      90      630     90.00    1
          * 과목합계    450   450   450   450  450     450     450   
          * 과목평균  90.00 90.00 90.00 90.00 90.00   90.00  90.00
          */
      ArrayList<ArrayList<Integer>> students = new ArrayList<>();
      ArrayList<Integer> scores = new ArrayList<>();
      ArrayList<String> names = new ArrayList<>();
      names.add("민진홍");
      names.add("노현정");
      names.add("박상진");
      names.add("이정수");
      names.add("양승혁");
      names.add("강정윤");
      names.add("주창규");
      names.add("김재웅");
      names.add("고성식");
      names.add("이유정");
      names.add("박상현");
      names.add("김은혜");
      names.add("김민경");
      names.add("정지수");
      names.add("양동현");
      names.add("조화랑");
      names.add("이기석");
      names.add("손효선");
      names.add("정석철");
      names.add("한영민");
      names.add("김민호");
      names.add("양아연");
      names.add("이응주");
      names.add("황선부");
      names.add("박세준");
      
      for (int i = 0; i < 25; i++) {
         scores = new ArrayList<>();
         for (int j = 0; j < 7; j++) {
            scores.add((int)(Math.random()*101));
         }
         students.add(scores);
      }
      ArrayList<Integer>sum = new ArrayList<>();
      ArrayList<Double>avg = new ArrayList<>();
      
      for (int i = 0; i < 25; i++) {
         int sum1 = 0;
         for(int j = 0; j < 7; j++) {
            sum1 += students.get(i).get(j);
         }
         sum.add(sum1);
         double avg1 = 0;
         avg1 = Math.round((double)sum1 / scores.size()*100)/100.0;
         avg.add(avg1);
      }
      ArrayList<Integer>rank = new ArrayList<>();
      for(int i = 0 ; i < 25; i++) {
         rank.add(i,1);
      }
      for(int i = 0 ; i < students.size(); i++) {
            int count = 1;
         for(int j = 0; j < students.size(); j++) {
            if(sum.get(i) < sum.get(j)) {
               count++;
               rank.set(i, count);
               //rank .set(i, rank.get(i) +1); 가능함
            }
         }
      }
      ArrayList<Integer>subSum = new ArrayList<>();
      ArrayList<Double>subAvg = new ArrayList<>();
      
      for (int i = 0; i < scores.size(); i++) {
         int sum1 = 0;
         for(int j = 0; j < students.size(); j++) {
            sum1 += students.get(j).get(i);
         }
         double avg1 = 0;
         avg1 = Math.round((double)sum1 / students.size()*100)/100.0;
         subSum.add(sum1);
         subAvg.add(avg1);
      }
//      System.out.println("이름\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균\t석차");
//      for(int i = 0; i < students.size(); i++) {
//         System.out.print(names.get(i));
//         for(int j = 0; j < scores.size(); j++) {
//            System.out.print("\t" + students.get(i).get(j));
//         }
//         System.out.print("\t" + sum.get(i));
//         System.out.print("\t" + avg.get(i));
//         System.out.print("\t" + rank.get(i));
//         System.out.println(" ");
//      }
//      System.out.print("과목 합계");
//      for (int i = 0; i < subSum.size(); i++) {
//         System.out.print("\t" + subSum.get(i));         
//      }
//      System.out.print("\n과목 평균");
//      for (int i = 0; i < subSum.size(); i++) {
//         System.out.print("\t" + subAvg.get(i));         
//      }
//      System.out.println(" ");
      
      ////////////////////////////////////////////////////////////////////////////////////////////석차순정렬
      
      for (int i = 0; i < students.size(); i++) {
		for (int j = 0; j < students.size(); j++) {
			if(rank.get(i) < rank.get(j)) {
				int temp = 0;
				int temp1 = 0;
				double temp2 = 0;
				ArrayList <Integer> temp3 = new ArrayList<>();
				String temp4 = null;
				
				temp = rank.get(j);
				rank.set(j,rank.get(i));
				rank.set(i, temp);
				
				temp1 = sum.get(j);
				sum.set(j,sum.get(i));
				sum.set(i, temp1);
				
				temp2 = avg.get(j);
				avg.set(j, avg.get(i));
				avg.set(i, temp2);
				
				temp3 = students.get(j);
				students.set(j, students.get(i));
				students.set(i, temp3);
				
				temp4 = names.get(j);
				names.set(j, names.get(i));
				names.set(i, temp4);
			}
		}
	}
      
//      	교수님 석차구하기 (선택 정렬)
//      for(int i = 0; i < ranks.size(); i++) {
//    	  int min = i;
//    	  for(int j = 0l j < ranks.size(); j++) {
//    		  if(ranks.get(j) < ranks.get(min)) {
//    			  min = j;
//    		  }
//    	  }
//      }
//      students.set(i, students.set(min, students.get(i)));
      
      
      System.out.println("이름\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균\t석차");
      for(int i = 0; i < students.size(); i++) {
         System.out.print(names.get(i));
         for(int j = 0; j < scores.size(); j++) {
            System.out.print("\t" + students.get(i).get(j));
         }
         System.out.print("\t" + sum.get(i));
         System.out.print("\t" + avg.get(i));
         System.out.print("\t" + rank.get(i));
         System.out.println(" ");
      }
      System.out.print("과목 합계");
      for (int i = 0; i < subSum.size(); i++) {
         System.out.print("\t" + subSum.get(i));         
      }
      System.out.print("\n과목 평균");
      for (int i = 0; i < subSum.size(); i++) {
         System.out.print("\t" + subAvg.get(i));         
      }
      

      
      

      
   }

}