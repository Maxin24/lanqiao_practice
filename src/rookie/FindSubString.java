package rookie;

import java.util.Scanner;

/**
 * @author liujx
 */
public class FindSubString {
    public static void main(String[] args){
        String a,b;
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            a=scanner.nextLine();
            b=scanner.nextLine();
            System.out.println(a.indexOf(b));
        }
    }
}
