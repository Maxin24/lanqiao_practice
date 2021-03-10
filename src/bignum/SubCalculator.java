package bignum;

import java.util.Scanner;

/**
 * 高精度计算 加法计算器
 * @author liujx
 */
public class SubCalculator {
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
        clear(c);
        for(int i=0;i<LEN-5;i++){
            c[i]+=a[i]+b[i];
            if(c[i]>=10){
                c[i+1]++;
                c[i]-=10;
            }
        }
    }

    private static void sub(int[] a,int[] b,int[] c){
        clear(c);
        for(int i=0;i<LEN-5;i++){
            c[i]+=a[i]-b[i];
            if(c[i]<0){
                c[i]+=10;
                c[i+1]--;
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

    private static int compare(int[] a,int[] b){
        for(int i=LEN-1;i>=0;i--){
            if(a[i]>b[i]){
                return 1;
            }else if(a[i]<b[i]){
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args){
        int[] a=new int[LEN];
        int[] b=new int[LEN];
        int[] c=new int[LEN];
        read(a);read(b);
        if(compare(a,b)>=0){
            sub(a,b,c);
        }else{
            sub(b,a,c);
            System.out.print("-");
        }
        print(c);
    }
}
