package rookie;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author liujx
 * 1062数根
 */
public class NumRoot {
    public static void main(String[] args){
        String num;
        Scanner scanner=new Scanner(System.in);
        num=scanner.next();
        while(num.length()>=2){
            long temp = 0;
            for(int i=0;i<num.length();i++){
                temp+=num.charAt(i)-48;
            }
            num=String.valueOf(temp);
        }
        System.out.println(num);
    }
}
