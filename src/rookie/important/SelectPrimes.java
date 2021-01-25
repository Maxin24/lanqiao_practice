package rookie.important;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：筛选出第k个素数
 * 使用埃氏筛法 时间复杂度O(n log n)
 */
public class SelectPrimes {
    private static final int MAX_N=(int)2e6;
    private static boolean[] prime=new boolean[MAX_N];
    private static void init(){
        //初始化数组 好比memset
        Arrays.fill(prime,true);
        prime[0]=false;prime[1]=false;
        for (int i=2;i<MAX_N;i++){
            if(prime[i]){
                //这里j的初始值不能是i*i，因为int存不下，会导致j越界变成一个负数
                //j是负数时<MAX_N 能进for循环 导致prime[一个负数]->下标越界
                for(int j=i*2;j<MAX_N;j+=i){
                    prime[j]=false;
                }
            }
        }
    }
    public static void main(String[] args){
        init();
        int k;
        Scanner scanner=new Scanner(System.in);
        k=scanner.nextInt();
        int i=2;
        while(k!=0){
            if(prime[i]){
                k--;
            }
            i++;
        }
        System.out.println(i-1);
    }
}
