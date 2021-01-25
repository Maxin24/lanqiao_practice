package rookie;

import java.util.Scanner;

/**
 * 1066 消消乐
 *
 * @author liujx
 */
public class XiaoXiaoHappy1066 {

    private static boolean check(StringBuilder str){
        for(int i=2;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1) && str.charAt(i)==str.charAt(i-2)){
                str.delete(i-2,i+1);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        StringBuilder str;
        Scanner scanner=new Scanner(System.in);
        String tempStr;
        tempStr=scanner.next();
        str=new StringBuilder(tempStr);
        while(check(str)){}
        System.out.println(str.length());
        System.out.println(str);

    }
}
