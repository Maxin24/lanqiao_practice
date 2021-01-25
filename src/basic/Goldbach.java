package basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 1081:哥德巴赫猜想
 * @author liujx
 */
public class Goldbach {
    private static int[] primes=new int[2300];
    private static int sizeOfPrimes=0;
    private static boolean[] isPrime=new boolean[20005];
    static{
        Arrays.fill(isPrime,true);
        isPrime[0]=false;isPrime[1]=false;
        for(int i=2;i<=20000;i++){
            if(isPrime[i]){
                primes[sizeOfPrimes++]=i;
            }

            for(int prime:primes){
                if(prime*i>20000){
                    break;
                }

                isPrime[i*prime]=false;

                if(i%prime==0){
                    break;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            boolean flag=false;
            int n=scanner.nextInt();
            for(int i=0;i<sizeOfPrimes;i++){
                int num1=primes[i];
                if(flag){
                    break;
                }


                for(int j=i;j<sizeOfPrimes;j++){
                    int num2=primes[j],num3=n-num1-num2;
                    if(num3>20000){
                        continue;
                    }else if(num3<num2){
                        break;
                    }else if(isPrime[num3]){
                        if(num2<=num3){
                            System.out.println(num1+" "+num2+" "+num3);
                        }
                        flag=true;
                        break;
                    }
                }
            }
        }
    }
}
