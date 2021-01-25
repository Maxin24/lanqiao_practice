package basic;

import java.util.Scanner;

/**
 * 1082:连续自然数和
 * @author liujx
 */
public class SumOfContinuousNaturalDigits {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n=scanner.nextInt(),cnt=0;

            for(int i=1;i<n;i++){
                int currentSum=i;

                for(int j=i+1;j<n;j++){
                    currentSum+=j;
                    if(currentSum==n){
                        cnt++;
                        break;
                    }else if(currentSum>n){
                        break;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
