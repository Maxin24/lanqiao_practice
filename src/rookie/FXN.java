package rookie;

import java.util.Scanner;

/**
 * 求f(x,n) 1075
 */
public class FXN {
    private static double myFun(double x,int n){
        return Math.sqrt(x+n);
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double x;
        int n;
        x=scanner.nextDouble();
        n=scanner.nextInt();
        for(int i=1;i<=n;i++){
            x=myFun(x,i);
        }
        System.out.printf("%.2f",x);
    }
}
