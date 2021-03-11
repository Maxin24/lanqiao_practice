package lanqiao;

import java.util.Scanner;

public class _1206 {
    private static int[][] nums;
    private static boolean[][] isUsed;
    private static int result=Integer.MAX_VALUE;
    private static int m,n;
    private static int sum=0;
    private static int dx[]={0,0,1,-1},dy[]={1,-1,0,0};

    private static void dfs(int[][] map,boolean[][] isUsed,int currentNum,int x,int y,int cnt){
        if(currentNum==sum/2){
            result=Math.min(result,cnt);
            return;
        }else if(currentNum>sum/2){
            return;
        }

        for(int i=0;i<4;i++){
            int tempX=x+dx[i];
            int tempY=y+dy[i];
            if(!checkBound(tempX,tempY)){
                continue;
            }
            if(isUsed[tempX][tempY]){
                continue;
            }

            isUsed[tempX][tempY]=true;
            dfs(map,isUsed,currentNum+map[tempX][tempY],tempX,tempY,cnt+1);
            isUsed[tempX][tempY]=false;
        }



    }

    private static boolean checkBound(int i,int j){
        if(i>=1 && j>=1 && i<=m && j<=n){
            return true;
        }
        return false;
    }

    public static void main(String[] args){

        Scanner scanner= new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();

        nums=new int[m+1][n+1];
        isUsed=new boolean[m+1][n+1];


        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int temp=scanner.nextInt();
                nums[i][j]=temp;
                sum+=temp;
            }
        }
        isUsed[1][1]=true;
        dfs(nums,isUsed,nums[1][1],1,1,1);
        System.out.println(result);
    }
}
