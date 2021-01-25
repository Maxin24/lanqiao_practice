package rookie;

import java.util.*;

/**
 * 1059字符串排序
 */
public class StringSort {
    private static final int DIFFERENCE=97-65;
    private static String transition(String str){
        String tempStr="";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c>='a' && c<='z'){
                c-=DIFFERENCE;
            }else{
                c+=DIFFERENCE;
            }
            tempStr+=c;
        }
        return tempStr;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        List<String> strList=new ArrayList<>();
        while(n--!=0){
            String str=scanner.next();
            str=transition(str);
            strList.add(str);
        }
        strList.sort(Comparator.naturalOrder());
        for(int i=0;i<strList.size();i++){
            System.out.println(strList.get(i));
        }
    }
}
