package lanqiao;

import java.util.Scanner;

/**
 * 定理：px+py不能表示的最大数为pq-p-q
 */
public class _1205 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        System.out.println(m*n-m-n);
    }
}
