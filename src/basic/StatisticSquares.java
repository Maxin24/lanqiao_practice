package basic;

import java.util.Scanner;

/**
 * 统计方形
 * @author liujx
 */
public class StatisticSquares {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,m;
        while(scanner.hasNextInt()){
            n=scanner.nextInt();
            m=scanner.nextInt();

            long cnt1=0,cnt2=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    long temp= (long) (n - i + 1) *(m-j+1);
                    if(i==j){
                        cnt1+=temp;
                    }else{
                        cnt2+=temp;
                    }
                }
            }

            System.out.println(cnt1+" "+cnt2);
        }
    }
}
