package lanqiao;

import java.util.Scanner;

/**
 * 2015初赛 星系炸弹
 * @author liujx
 */
public class StellaBomb1251 {
    private static boolean myFun(int y){
        if(y%400==0 || (y%4==0 && y%100!=0)){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        int y,m,d,t;
        int[] daysOfMonths= {0,31,28,31,30,31,30,31,31,30,31,30,31};

        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            y=scanner.nextInt();
            m=scanner.nextInt();
            d=scanner.nextInt();
            t=scanner.nextInt();
            while(t>0){
                int temp=daysOfMonths[m]-d;
                if(m==2){
                    if(myFun(y)){
                        temp++;
                    }
                }
                if(t<=temp){
                    d+=t;
                    t=0;
                }else{
                    if(m<12){
                        m++;
                    }else{
                        y++;
                        m=1;
                    }
                    d=0;
                    t-=temp;
                }
            }
            System.out.print(y+"-");
            if(m<10){
                System.out.print("0");
            }
            System.out.print(m+"-");
            if(d<10){
                System.out.print("0");
            }
            System.out.println(d);
        }
    }
}
