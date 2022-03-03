
import java.util.Arrays;

public class scorepre{
    public static void main(String[]args){

        int[][]score = new int [25][7];
        for(int i = 0; i < score.length; i++){
            for(int j = 0; j < score[i].length; j ++){
                score[i][j] = (int)(Math.random()*101);
            }
            System.out.println(Arrays.toString(score[i]));  //점수 값을 랜덤으로 배열에 집어 넣어주는 과정
        }
       
        int sum [] = new int [25];
        double avg [] = new double [25];

        for(int i = 0; i < score.length; i++){
            for(int j = 0 ; j < score[i].length; j++){
                sum [i] += score[i][j];
            }
           avg[i] = (double)sum[i] / score[i].length;
           avg[i] = Math.round(avg[i]*100)/100.0;
        }


        // System.out.println(Arrays.toString(sum));
        // System.out.println(Arrays.toString(avg));

        //score
        //avg
        //sum
        //rank
        //subSum
        //subAvg
        //name


        int [] rank = new int [25];
            for (int i = 0 ; i < rank.length; i++){
                rank[i] = 1;
            }


            for (int i = 0; i < rank.length; i++){
                for (int j = 0; j < score.length;j++){
                    if(avg[i] < avg[j]){
                        rank[i]++;
                    }
                }
            }

       // System.out.println(Arrays.toString(rank));


        int [] subSum = new int[7];
        double [] subAvg = new double[7];
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 25; j++){
                subSum[i] += score[j][i];
            }
            subAvg[i] = (double)subSum[i] / score.length;
            subAvg[i] = Math.round(subAvg[i]*100)/100.0;
        }

        // score[0][0]
        // score[1][0]
        // score[2][0]
        // System.out.println(Arrays.toString(subSum));
        // System.out.println(Arrays.toString(subAvg));
        System.out.println("이름" + "\t" + "국어"+ "\t" + "수학 "+ "\t" +  "과학"+ "\t" +  "영어"+ "\t" + "사회"+ "\t" +  
        "Oracle"+ "\t" +  "Java"+ "\t" +  "총점" + "\t" +"평균"+ "\t" + "석차");

        String [] name = new String[25];
        for (int i = 0; i < name.length; i++){
            name[i] = i+1 + "번";
        }
       // System.out.println(Arrays.toString(name));



        for (int i = 0; i < score.length; i++){
            System.out.print(name[i] + "\t");
            for (int j = 0; j < score[i].length; j++){
                System.out.print(score[i][j] + "\t");
            }
            System.out.print(sum[i] + "\t");
            System.out.print(avg[i] + "\t");
            System.out.print(rank[i] + "\t");
            System.out.println(" ");
       }  
       System.out.print("합계" + "\t");
       for (int i = 0; i < subSum.length; i++){
           System.out.print(subSum[i] + "\t");
       }
       System.out.println(" ");
       System.out.print("평균" + "\t");
       for (int i = 0; i < subSum.length; i++){
        System.out.print(subAvg[i] + "\t");
    }



     

    }

}