package latestLanqiaoCup;

/**
 * @author liujx
 */
public class NineNumberAlgorithm {
    static char[] arr=new char[]{'0','1','2','3','4','5','6','7','8','9'};
    static int maxSize=arr.length;
    static char[] result=new char[maxSize];
    static int[] tags=new int[maxSize];
    static int cnt=0;
    public static void main(String[] args){
        dfs(0);
        System.out.println(cnt/2);
    }

    static void dfs(int layer){
        if(layer>=maxSize){
            if(check(result)){
                cnt++;
            }
        }else{
            for(int i=0;i<maxSize;i++){
                if(tags[i]==0){
                    tags[i]=1;
                    result[layer]=arr[i];
                    dfs(layer+1);
                    tags[i]=0;
                }
            }
        }
    }

    static boolean check(char[] arr){
        String s=new String(arr);
        String[] strings=s.split("0");
        if(strings.length == 2 && !"".equals(strings[0]) && !"".equals(strings[1])){
            long a=Long.parseLong(strings[0]);
            long b=Long.parseLong(strings[1]);
            return check(a*b);
        }
        return false;
    }


    static boolean check(Long a){
        String s=a.toString();
        for(int i=1;i<maxSize;i++){
            if(!s.contains(Character.toString(arr[i]))){
                return false;
            }
        }
        return true;
    }
}
