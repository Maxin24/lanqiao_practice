package lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:LiuJX
 * @Date:2021/3/10
 * @Description:
 */
public class RebuildAfterDisaster1257 {
    /**
     * 通过Prim算法 获取输入图的最小生成树
     * @param param
     * @return
     */
    public int[][] getPrim(int[][] param){
        /**
         * 用来存放最小生成树
         */
        int[][] result=new int[param.length][param[0].length];
        /**
         * 用来记录点是否被遍历过
         */
        boolean[] isUsed=new boolean[param.length];
        Arrays.fill(isUsed,false);
        isUsed[1]=true;

        int cnt=1;
        int len=param.length;
        while(cnt<len){
            int tempMax=Integer.MAX_VALUE;
            int tempI=0,tempJ=0;
            /**
             * 遍历已构造的节点
             */
            for(int i=1;i<len;i++){
                if(!isUsed[i]){
                    continue;
                }
                /**
                 * 遍历未构造的节点
                 */
                for(int j=1;j<len;j++){
                    if(!isUsed[j]){
                        if(param[i][j]!=0 && tempMax>param[i][j]){
                            tempMax=param[i][j];
                            tempI=i;
                            tempJ=j;
                        }
                    }
                }
            }
            result[tempI][tempJ]=tempMax;
            result[tempJ][tempI]=tempMax;
            isUsed[tempJ]=true;
            cnt++;

        }
        return result;
    }

    public void floyd(int[][] primTree,int[][] path){
        int len=primTree.length;
        int[][] tree=new int[len][len];
        for(int i=1;i<len;i++){
            for(int j=1;j<primTree[0].length;j++){
                tree[i][j]=primTree[i][j];
            }
        }

        for(int k=1;k<len;k++){
            for(int i=1;i<len;i++){
                for(int j=1;j<primTree[0].length;j++){
                    if(tree[i][k]!=0 && tree[k][j]!=0){
                        int temp=tree[i][k]+tree[k][j];
                        if(tree[i][j]<temp){
                            tree[i][j]=temp;
                            path[i][j]=k;
                        }
                    }
                }
            }
        }
    }

    /**
     * 根据最短路径，返回顶点start-end之间的最大权值边
     * @param primTree
     * @param path
     * @param start
     * @param end
     * @return
     */
    public int dfsMax(int[][] primTree,int[][] path,int start,int end){
        if(path[start][end]==0){
            return primTree[start][end];
        }

        int mid=path[start][end];
        return Math.max(dfsMax(primTree,path,start,mid),dfsMax(primTree,path,mid,end));
    }

    /**
     * 根据最小生成树，返回各个顶点到其他顶点行走过程中，权值最大的一条边
     * @param primTree
     * @return
     */
    public int[][] getMaxValue(int[][] primTree){
        int[][] path=new int[primTree.length][primTree[0].length];
        floyd(primTree,path);
        int[][] result=new int[primTree.length][primTree[0].length];

        for(int i=1;i<primTree.length;i++){
            for(int j=1;j<primTree.length;j++){
                if(j==i){
                    continue;
                }

                int max=dfsMax(primTree,path,i,j);
                result[i][j]=max;
            }
        }

        return result;
    }

    public void printResult(int[][] value,int[][] result){
        int[][] primTree=getPrim(value);
        int[][] maxResult=getMaxValue(primTree);
        for(int i=0;i<result.length;i++){
            int L=result[i][0];
            int R=result[i][1];
            int K=result[i][2];
            int C=result[i][3];
            ArrayList<Integer> list=new ArrayList<>();

            for(int j=L;j<=R;j++){
                if(j%K==C){
                    list.add(j);
                }
            }

            int max=0;
            for(int j=0;j<list.size();j++){
                for(int k=j+1;k<list.size();k++){
                    if(max<maxResult[list.get(j)][list.get(k)]){
                        max=maxResult[list.get(j)][list.get(k)];
                    }
                }
            }
            System.out.println(max);
        }
        return;
    }


    public static void main(String[] args){
        RebuildAfterDisaster1257 main=new RebuildAfterDisaster1257();
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int q=scanner.nextInt();
        int[][] value=new int[n+1][n+1];

        for(int i=1;i<=m;i++){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int tempV=scanner.nextInt();
            value[a][b]=tempV;
            value[b][a]=tempV;
        }

        int[][] result=new int[q][4];
        for(int i=0;i<q;i++){
            result[i][0]=scanner.nextInt();
            result[i][1]=scanner.nextInt();
            result[i][2]=scanner.nextInt();
            result[i][3]=scanner.nextInt();
        }
        main.printResult(value,result);


    }
}
