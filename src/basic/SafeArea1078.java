package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1078安全区
 * @author liujx
 */
public class SafeArea1078 {
    public static void main(String[] args){
        int m,n;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        int[] x=new int[10005];
        int[] y=new int[10005];
        int[] r=new int[10005];

        for(int i=0;i<m;i++){
            x[i]=scanner.nextInt();
            y[i]=scanner.nextInt();
            r[i]=scanner.nextInt();
        }
        int cnt=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=0;k<m;k++){
                    double distance=Math.sqrt(Math.pow(x[k]-i,2)+Math.pow(y[k]-j,2));
                    if(distance<=r[k]){
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(n*n-cnt);
    }
}
