package rookie;

import java.util.Scanner;

public class PellArray {
    private static final int MAX_N=(int)1e7+5;
    private static final int MOD=32767;
    public static void main(String[] args){
        int[] pell=new int[MAX_N];
        pell[1]=1;
        pell[2]=2;
        for(int i=3;i<=MAX_N-5;i++){
            pell[i]=(2*pell[i-1]+pell[i-2])%MOD;
        }

        int k;
        Scanner scanner=new Scanner(System.in);
        k=scanner.nextInt();
        while(k!=0){
            int temp=scanner.nextInt();
            System.out.println(pell[temp]);
            k--;
        }
    }
}
