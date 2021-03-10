package lanqiao;

public class SortsOfCards1253 {
    private static int res=0;

    private static void dfs(int pos,int cnt){
        if(cnt==13){
            res++;
            return;
        }

        if(pos==14){
            return;
        }

        int temp=Math.min(13-cnt,4);

        for(int i=0;i<=temp;i++){
            dfs(pos+1,cnt+i);
        }
        return;
    }

    public static void main(String[] args){
        dfs(1,0);
        System.out.println(res);
    }
}
