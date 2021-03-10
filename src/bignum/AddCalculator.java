package bignum;

import java.util.Scanner;

/**
 * 高精度计算 加法计算器
 * @author liujx
 */
public class AddCalculator {
    private static final int LEN=1010;
    private static Scanner scanner=new Scanner(System.in);

    private static void clear(int[] a){
        for(int i=0;i<LEN;i++){
            a[i]=0;
        }
    }

    private static void read(int[] a){
        String tempStr=scanner.next();

        clear(a);

        int len=tempStr.length();
        for(int i=0;i<len;i++){
            a[len-i-1]=tempStr.charAt(i)-'0';
        }
    }

    private static void add(int[] a,int[] b,int[] c){
        for(int i=0;i<LEN-5;i++){
            c[i]+=a[i]+b[i];
            if(c[i]>=10){
                c[i+1]++;
                c[i]-=10;
            }
        }
    }

    private static void print(int[] a){
        int i;
        for(i=LEN-5;i>=1;i--){
            if(a[i]!=0){
                break;
            }
        }

        for(;i>=0;i--){
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        int n;
        n=scanner.nextInt();
        while(n--!=0){
            int[] a=new int[LEN];
            int[] b=new int[LEN];
            int[] c=new int[LEN];
            read(a);read(b);add(a,b,c);
            print(c);
        }
    }
}
