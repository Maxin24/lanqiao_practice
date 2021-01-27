package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujx
 * 1087:素数数目
 */
public class SumOfPrimes {
    private static final int MAX_N=(int)Math.sqrt(1e12)+10;
    private static final int MAX_RANGE=(int)1e7+10;

    private static boolean[] isPrimeFrom0=new boolean[MAX_N];
    private static boolean[] isPrimeFromA=new boolean[MAX_RANGE];

    private static void init(long l,long r){
        Arrays.fill(isPrimeFrom0,true);
        Arrays.fill(isPrimeFromA,true);
        isPrimeFrom0[0]=false;isPrimeFrom0[1]=false;
        for(int i = 2; (long) i *i<=r; i++){
            if(isPrimeFrom0[i]){
                for(long j = (long) i *i; j<=MAX_N-10; j+=i){
                    isPrimeFrom0[(int) j]=false;
                }

                for(long j=Math.max(2,(l+i-1)/i)*i;j<=r;j+=i){
                    isPrimeFromA[(int)(j-l)]=false;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        long l=scanner.nextLong();
        long r=scanner.nextLong();
        init(l,r);
        int cnt=0;
        for(int i=0;i<=r-l;i++){
            if(isPrimeFromA[i]){
                cnt++;
            }
        }

        if(l==1){
            cnt--;
        }
        System.out.println(cnt);
    }
}
