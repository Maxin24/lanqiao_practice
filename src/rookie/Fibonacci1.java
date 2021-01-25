package rookie;

import java.util.Scanner;

/**
 * @author liujx
 */
public class Fibonacci1 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        if(n==1 || n==2){
            System.out.println(1);
            return;
        }
        int n1,n2,n3=2;
        n1=1;n2=1;
        for(int i=3;i<=n;i++){
            n3=(n1+n2)%10007;
            n1=n2;n2=n3;
        }
        System.out.println(n3);
    }
}
