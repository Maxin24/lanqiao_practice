package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujx
 * 1086 拼三角形
 */
public class Triangle {
    private static final long MOD=100000007;
    private static long myFun(long num){
        return num *(num-1)/2;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int a[]=new int[5001];
        Arrays.fill(a,0);
        while(n--!=0){
            int temp=scanner.nextInt();
            a[temp]++;
        }


        long cnt=0;
        for(int i=2;i<=5000;i++){
            if(a[i]>=2){
                long temp=myFun(a[i])%MOD;
                for(int j=1;j<=i/2;j++){
                    if(j!=i-j && a[j]>=1 && a[i-j]>=1){
                        cnt+=temp*a[j]*a[i-j]%MOD;
                    }

                    if(j==i-j && a[j]>=2){
                        cnt+=temp*myFun(a[j])%MOD;
                    }
                    cnt%=MOD;
                }
            }
        }
        System.out.println(cnt%MOD);
    }
}
