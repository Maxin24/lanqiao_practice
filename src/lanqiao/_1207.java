package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class _1207 {
    private static int N;
    private static int[][] map;
    private static int[] dis;
    private static boolean[] visit;
    private static int n;
    static{
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        N=n+5;
        map=new int[N][N];
        dis=new int[N];
        visit=new boolean[N];
        for(int i=0;i<N;i++){
            Arrays.fill(map[i],Integer.MAX_VALUE);
        }
        for(int i=1;i<n;i++){
            int p,q,d;
            p=scanner.nextInt();
            q=scanner.nextInt();
            d=scanner.nextInt();
            map[p][q]=d;
            map[i][i]=0;
        }
    }

    private static void dijstra(){
        int i,j,pos=1,min,sum=0;
        Arrays.fill(visit,false);

        for(i=1;i<=n;i++){
            dis[i]=map[1][i];
        }

        visit[1]=true;
        dis[1]=0;
        for(i=1;i<n;i++){
            min=Integer.MAX_VALUE;
            for(j=i;j<=n;j++){
                if(!visit[j] && min>dis[j]){
                    min=dis[j];
                    pos=j;
                }
            }
            visit[pos]=true;
            for(j=1;j<=n;j++){
                if(!visit[j] && dis[j]>dis[pos]+map[pos][j]){
                    dis[j]=dis[pos]+map[pos][j];
                }
            }

        }
    }

    public static void main(String[] args){
        dijstra();
        int max1=dis[1], max2=dis[2];
        for(int i=3;i<=n;i++){
            if(dis[i]>max1){
                max1=dis[1];
            }else if(dis[i]>max2){
                max2=dis[i];
            }
        }

        System.out.println(max1+max2);
    }
}
