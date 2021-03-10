package lanqiao;

import java.util.Scanner;

/**
 * @Author:LiuJX
 * @Date:2021/3/10
 * @Description: 这题的精华在输入部分
 */
public class WrongTickit1204 {
    private static final int MAX=100000;

    public static void main(String[] args){
        int emptyNum = 0,repeatedNum=0;

        int[] nums =new int[MAX+1];

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String s[]=new String[n];
        String ss[][]=new String[n][];

        scanner.nextLine();
        for(int i=0;i<n;i++){
            s[i]=scanner.nextLine();
            ss[i]=s[i].split(" ");
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<ss[i].length;j++){
                if(!ss[i][j].equals(" ")){
                    nums[Integer.valueOf(ss[i][j])]++;
                }

            }
        }

        for(int i=0;i<=MAX;i++){
            if(nums[i]>1){
                repeatedNum=i;
            }

            if(nums[i]==0 && i!=0 && i!=MAX){
                if(nums[i-1]>0 && nums[i+1]>0){
                    emptyNum=i;
                }
            }
        }

        System.out.println(emptyNum+" "+repeatedNum);
    }
}
