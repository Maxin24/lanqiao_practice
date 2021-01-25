package rookie;

import java.util.Scanner;

public class StaticNums {
    private static final int ASCII_ZERO =48;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int l,r,x,count=0;
        l=scanner.nextInt();
        r=scanner.nextInt();
        x=scanner.nextInt();
        for(int i=l;i<=r;i++){
            String str=String.valueOf(i);
            for(int j=0;j<str.length();j++){
                char c=str.charAt(j);
                char x1=(char)(x+ASCII_ZERO);
                if(c==x1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
