package lanqiao;

import java.util.Scanner;

public class Drink1255 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int res=n;
            while(n>=3){
                int temp=n/3;
                n-=temp*3;
                res+=temp;
                n+=temp;
            }
            System.out.println(res);
        }
    }
}
