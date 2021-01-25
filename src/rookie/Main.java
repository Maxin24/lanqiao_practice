package rookie;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int m,n;
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        n=scanner.nextInt();
        int[][] bitMap=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                bitMap[i][j]=scanner.nextInt();
            }
        }

        for(int j=0;j<n;j++){
            for(int i=m-1;i>=0;i--){
                System.out.print(bitMap[i][j]);
                if(i==0){
                    System.out.println();
                }else{
                    System.out.print(" ");
                }
            }
        }
    }
}