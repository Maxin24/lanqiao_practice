package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujx
 * 1083:因子数之和
 */
public class SumOfSons {
    private static int[] sons=new int[1000005];
    static{
        Arrays.fill(sons,1);
        for(int i=2;i<=1000000;i++){
            for(int j=i;j<=1000000;j+=i){
                sons[j]++;
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int cnt = 0;

            for(int i=l;i<=r;i++){
                cnt+=sons[i];
            }
            System.out.println(cnt);
        }
    }
}
