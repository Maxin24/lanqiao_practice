package lanqiao;

import java.util.Scanner;

/**
 * @Author:LiuJX
 * @Date:2021/3/10
 * @Description:
 */
public class WrongTickit1204 {
    private static final int MAX=100000;

    public static void main(String[] args){
        int emptyNum = 0,repeatedNum=0;

        int[] nums =new int[MAX+1];

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        while(scanner.hasNextInt()){
            int currentNum=scanner.nextInt();
            nums[currentNum]++;
        }

        boolean flag=false;
        for(int i=0;i<=MAX;i++){
            if(nums[i]>0 && !flag){
                flag=true;
                continue;
            }

            if(flag){
                if(nums[i]==0){
                    emptyNum=i;
                }else if(nums[i]>1){
                    repeatedNum=i;
                }
            }
        }

        System.out.println(emptyNum+" "+repeatedNum);
    }
}
