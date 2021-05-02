package latestLanqiaoCup;

import java.util.Arrays;

/**
 * @author liujx
 */
public class LazyMenGoThroughMaze {
    static char[][] map =new char[10][10];
    static Integer[][] tag=new Integer[10][10];
    static int cnt=0;
    static{
        String tempStr="UDDLUULRULUURLLLRRRURRUURLDLRDRUDDDDUUUUURUDLLRRUUDURLRLDLRLULLURLLRDURDLULLRDDDUUDDUDUDLLULRDLUURRR";
        char[] tempChars=tempStr.toCharArray();
        for(int i=0;i<10;i++){
            System.arraycopy(tempChars, i * 10, map[i], 0, 10);
        }
    }

    public static void main(String[] args){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                cleanTag();
                run(i,j);
            }
        }
        System.out.println(cnt);
    }


    static void cleanTag(){
        for(int i=0;i<10;i++){
            Arrays.fill(tag[i],0);
        }
    }

    static void run(int i,int j){
        if(i<0||i>9||j<0||j>9){
            cnt++;
        }else{
            if(tag[i][j]==1){
                return;
            }else{
                tag[i][j]=1;
            }
            int nextX=getNextX(i,j);
            int nextY=getNextY(i,j);
            run(nextX,nextY);
        }
    }


    static int getNextX(int i,int j){
        char c=map[i][j];
        switch(c){
            case 'U':return i+1;
            case 'D':return i-1;
            default:return i;
        }
    }

    static int getNextY(int i,int j){
        char c=map[i][j];
        switch(c){
            case'L':return j-1;
            case'R':return j+1;
            default:return j;
        }
    }
}
