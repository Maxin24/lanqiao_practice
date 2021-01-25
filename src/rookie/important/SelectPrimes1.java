package rookie.important;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 使用线性筛法
 * @author liujx
 */
public class SelectPrimes1 {
    private static final int MAXN=10005;
    private static final int MAXL=104730;
    private static int[] primes=new int[MAXN];
    private static boolean[] isPrime=new boolean[MAXL];
    private static void init(){
        int cnt=0;
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i<MAXL;i++){
            if(isPrime[i]){
                primes[cnt++]=i;
            }

            for(int j=0;j<cnt;j++){
                if(primes[j]*i>=MAXL){
                    break;
                }

                isPrime[primes[j]*i]=false;
                if(i%primes[j]==0){
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int k;
        k=scanner.nextInt();
        init();
        System.out.println(primes[k-1]);
    }
}
