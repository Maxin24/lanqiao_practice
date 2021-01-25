package basic;

import java.util.Scanner;

/**
 * 1077:超级倍数
 */
public class Super1077 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            boolean flag=false;
            for(int i=10000;i<=99999;i++){
                int num1=i/100;
                int num2=(i/10)%1000;
                int num3=i%1000;

                if(num1%n==0 && num2%n==0 &&num3%n==0 &&i%n==0){
                    System.out.println(i);
                    flag=true;
                }
            }
            if(!flag){
                System.out.println("No");
            }
            System.out.println();
        }
    }
}
