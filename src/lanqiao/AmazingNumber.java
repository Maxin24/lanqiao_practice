package lanqiao;

public class AmazingNumber {
    private static int[] isUsed;

    private static void myFun(int num){
        while(num!=0){
            isUsed[num%10]++;
            num/=10;
        }
    }

    public static void main(String[] args){
         for(int i=1;i<=1000;i++){
             boolean flag=true;
             isUsed=new int[10];
             int temp1=i*i;
             int temp2=temp1*i;
             myFun(temp1);
             myFun(temp2);

             for(int j=0;j<=9;j++){
                 if(isUsed[j]!=1){
                     flag=false;
                 }
             }

             if(flag){
                 System.out.println(i);
             }
         }

    }
}
