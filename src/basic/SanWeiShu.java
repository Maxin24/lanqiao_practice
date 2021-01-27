package basic;

import java.util.Arrays;
import java.util.Scanner;

public class SanWeiShu {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int a,b,c;
        while(scanner.hasNextInt()){
            a=scanner.nextInt();
            b=scanner.nextInt();
            c=scanner.nextInt();

            int res=0;
            boolean[] isUsed=new boolean[10];
            for(int i=123;i<=987;i++){
                Arrays.fill(isUsed,false);
                int cnt=0;



                double test1=(double)i/a*b;
                double test2=(double)i/a*c;

                if(test1%1>0 || test2%1>0){
                    continue;
                }


                if(test1>999 || test2>999){
                    continue;
                }


                int temp1=(int)test1,temp2=(int)test2;
                int temp3=i;


                for(int j=1;j<=3;j++){
                    if(temp1%10==0 || temp2%10==0 || temp3%10==0){
                        break;
                    }
                    if(!isUsed[temp1%10]){
                        isUsed[temp1%10]=true;
                        temp1/=10;
                        cnt++;
                    }else{
                        break;
                    }

                    if(!isUsed[temp2 % 10]){
                        isUsed[temp2%10]=true;
                        temp2/=10;
                        cnt++;
                    }else{
                        break;
                    }

                    if(!isUsed[temp3%10]){
                        isUsed[temp3%10]=true;
                        temp3/=10;
                        cnt++;
                    }else{
                        break;
                    }
                }

                if(cnt==9){
                    res++;
                }
            }

            System.out.println(res);
        }



    }
}
