package rookie;

import java.util.Scanner;

/**
 * 1061 素数回文数的个数
 * @author liujx
 */
public class OnlineJudge1061 {
    private static boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromicNumber(String num){
        int len=num.length();
        for(int i=0;i<len;i++){
            if(num.charAt(i)!=num.charAt(len-i-1)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int l,r,cnt=0;
        l=scanner.nextInt();
        r=scanner.nextInt();

        for(int i=l;i<=r;i++){
            String temp=String.valueOf(i);
            if(isPrime(i) && isPalindromicNumber(temp)){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
