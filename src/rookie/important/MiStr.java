package rookie.important;

import java.util.Scanner;

/**
 * 1057幂字符串
 * @author liujx
 */
public class MiStr {
    public static void main(String[] args){
        String str;
        Scanner scanner=new Scanner(System.in);
        str=scanner.next();
        int length=str.length();
        for(int i=0;i<str.length();i++){
            int currentLen=i+1;
            int cnt=1;
            if(length%currentLen==0){
                String subStr=str.substring(0,currentLen);
                for(int j=currentLen;j<length;j+=currentLen){
                    String tempString=str.substring(j,j+currentLen);
                    if(tempString.equals(subStr)){
                        cnt++;
                    }else{
                        break;
                    }
                }


                if(cnt*currentLen==length){
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }
}
