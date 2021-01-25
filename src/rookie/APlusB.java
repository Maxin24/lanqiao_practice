package rookie;

import java.util.Scanner;

public class APlusB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a,b,c,d,result;
        while (scanner.hasNextDouble()) {
            a=scanner.nextDouble();
            b=scanner.nextDouble();
            c=scanner.nextDouble();
            d=scanner.nextDouble();
            result=Math.sqrt(Math.pow(c-a,2)+Math.pow(d-b,2));
            System.out.printf("%.2f\n",result);
        }
    }
}