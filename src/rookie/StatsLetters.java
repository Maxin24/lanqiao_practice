package rookie;

import java.util.Scanner;

public class StatsLetters {
    public static void main(String[] args){
        String a;
        Scanner scanner=new Scanner(System.in);
        a=scanner.nextLine();
        int letterNum=0,digitNum=0,spaceNum=0;
        for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
            boolean flag=(c>='a' && c<='z')||(c>='A' && c<='Z');
            if(flag){
                letterNum++;
            }else if(c>='0' && c<='9'){
                digitNum++;
            }else if(c==' '){
                spaceNum++;
            }
        }
        System.out.println("letter="+letterNum);
        System.out.println("space="+spaceNum);
        System.out.println("digit="+digitNum);
    }
}
