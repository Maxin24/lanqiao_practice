package lanqiao;


import java.util.Scanner;

public class StackDice {
    private static int res=0;
    private static int n;
    private static final int MOD=1000000007;

    private static int[][] forbiddenNums=new int[7][7];
    private static int[] opposites={0,4,5,6,1,2,3};

    private static void dfs(int pos,int last){
        if(pos==n){
            res++;
            res%=MOD;
            return;
        }

        for(int i=1;i<=6;i++){
            if(forbiddenNums[i][last]!=1){
                dfs(pos+1,opposites[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNext()){
            n=scanner.nextInt();
            int m=scanner.nextInt();


            while(m--!=0){
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                forbiddenNums[a][b]=1;
                forbiddenNums[b][a]=1;
            }

            dfs(0,0);
            res*=Math.pow(4,n);
            res%=MOD;
            System.out.println(res);
        }
    }
}
