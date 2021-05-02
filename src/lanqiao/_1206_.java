package lanqiao;





import java.util.*;

public class _1206_ {
    private static final int N=20,P=131;
    private static int[] dx={0,0,1,-1},dy={1,-1,0,0};
    private static int sum=0;
    private static int ans=Integer.MAX_VALUE;
    private static int n,m;
    private static int[][] val=new int[N][N];
    /**
     * 搜索路径时候 判断格子是否使用
     */
    private static boolean[][] st=new boolean[N][N];
    /**
     * 判断剩余部分是否连通时 格子是否使用
     */
    private static boolean[][] ct=new boolean[N][N];
    /**
     * 哈希表查重
     */
    private static HashSet<Long> set=new HashSet<>();
    /**
     * 一维存储格子编号 如：二维坐标为(1,2)的点一位编号是2
     */
    private static List<Integer> loc=new ArrayList<>();
    /**
     * 一维存储格子编号
     */
    private static List<Integer> los=new ArrayList<>();
    /**
     * 剩余部分格子数
     */
    private static int cot;

    /**
     * 计算一维编号
     * @param x
     * @param y
     * @return
     */
    private static int turn(int x,int y){
        return (x-1)*n+y;
    }

    private static boolean checkBound(int x,int y){
        if(x<1||y<1||x>m||y>n){
            return true;
        }
        return false;
    }

    /**
     * 广度优先搜索
     * 从一个点开始搜索其联通的所有未使用点
     * 用于判断剩余部分是否联通
     * @param cnt 表示搜索部分包含的格子数
     * @return
     */
    private static boolean bfs(int cnt){
        while(!loc.isEmpty()){
            int size= loc.size()-1;
            //在末尾获得一维编号
            int id=loc.get(size);
            int x=(id-1)/n+1,y=(id-1)%n+1;
            loc.remove(size);
            for(int i=0;i<4;i++){
                int tempX=x+dx[i],tempY=y+dy[i];
                if(checkBound(tempX,tempY)){
                    continue;
                }
                if(ct[tempX][tempY]){
                    continue;
                }
                //计算当前格子数
                cot++;
                //将该节点编号插入头部，用于下次搜索
                loc.add(0,turn(tempX,tempY));
                ct[tempX][tempY]=true;
            }
        }
        if(cot+cnt==m*n){
            return true;
        }
        return false;
    }

    /**
     * HashSet查重
     * @param list
     * @return
     */
    private static boolean checkHashSet(List<Integer> list){
        list.sort(Comparator.naturalOrder());
        long x=0;
        for(int i=0;i<list.size();i++){
            x=x*P+(list.get(i)-1)/n+1;
            x=x*P+(list.get(i)-1)%n+1;
        }
        if(set.contains(x)){
            return true;
        }
        set.add(x);
        return false;
    }

    /**
     *
     * @param cnt 格子数
     * @param v 当前元素和
     * @param lo 当前包含格子编号集合
     */
    private  static void dfs(int cnt,int v,List<Integer> lo){
        if(v==sum/2){
            //初始化剩余部分格子数
            cot=0;
            ct=Arrays.copyOf(st,st.length);
            for(int i=1;i<=m;i++){
                if(loc.size()!=0){
                    break;
                }

                for(int j=i;j<=n;j++){
                    if(!ct[i][j]){
                        loc.add(turn(i,j));
                        cot++;
                        ct[i][j]=true;
                        break;
                    }
                }
            }
            if(bfs(cnt)){
                ans=Math.min(ans,cnt);
            }
            return;
        }

        if(v>sum/2){
            return;
        }
        //弱国搜索格子包括所有格子
        if(cnt==m*n){
            return;
        }
        //如果当前方案已经出现过
        if(checkHashSet(lo)){
            return;
        }

        //在当前搜索中避免重复搜素
        boolean[] fr=new boolean[200];
        int len=lo.size();
        //存储当前搜索到的格子的一维坐标
        List<Integer> bkt = new ArrayList<>();
        for (int p : lo) {
            //以所有当前已搜索格子为起点依次搜索
            int x = (p - 1) / n + 1, y = (p - 1) % n + 1;
            fr[turn(x, y)] = true;
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                int tempTurn = turn(a, b);
                if (checkBound(a, b)) {
                    continue;
                }

                if (st[a][b]) {
                    continue;
                }

                if (fr[tempTurn]) {
                    continue;
                }

                if (cnt + 1 >= ans) {
                    continue;
                }

                fr[tempTurn] = true;
                bkt.add(tempTurn);
            }
        }

        bkt.sort(Comparator.reverseOrder());
        for(int i=0;i<bkt.size();i++){
            int bktI=bkt.get(i);
            lo.add(bktI);
            int x=(bktI-1)/n+1,y=(bktI-1)%n+1;
            st[x][y]=true;
            dfs(cnt+1,v+val[x][y],lo);
            lo.remove(lo.size()-1);
            st[x][y]=false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();m= scanner.nextInt();

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                val[i][j]=scanner.nextInt();
                sum+=val[i][j];
            }
        }

        if(sum%2==0){
            st[1][1]=true;
            los.add(turn(1,1));
            dfs(1,val[1][1],los);
        }

        System.out.println(ans==Integer.MAX_VALUE?0:ans);
    }

}
