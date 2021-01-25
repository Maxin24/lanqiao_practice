package rookie;

import java.util.Scanner;

/**
 * 1076 再求f(x,n)
 */
public class FXN2 {
    private static double myFun(int x,int n,double tempRes){
        return x/(tempRes+n);
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int x,n;
        x=scanner.nextInt();
        n=scanner.nextInt();
        double tempRes=(double)x/(x+1);
        for(int i=2;i<=n;i++){
            tempRes=myFun(x,i,tempRes);
        }

        System.out.printf("%.2f",tempRes);
    }
}
