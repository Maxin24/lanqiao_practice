package rookie;

import java.util.Scanner;

/**
 * @author liujx
 */
public class SquareOfCircle {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int r=scanner.nextInt();
        System.out.printf("%.7f",Math.PI*r*r);
    }
}
