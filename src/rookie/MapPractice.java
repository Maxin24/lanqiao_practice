package rookie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1058:同学分组
 * @author liujx
 */
public class MapPractice {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,q;
        n=scanner.nextInt();
        q=scanner.nextInt();

        Map<String,String> stuMap=new HashMap<>();
        while(n--!=0){
            String tempStr1=scanner.next();
            String tempStr2=scanner.next();
            stuMap.put(tempStr1,tempStr2);
            stuMap.put(tempStr2,tempStr1);
        }

        while(q--!=0){
            System.out.println(stuMap.get(scanner.next()));
        }
    }
}
