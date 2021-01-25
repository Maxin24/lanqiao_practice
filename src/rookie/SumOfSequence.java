package rookie;
import java.math.BigInteger;
import java.util.Scanner;


/**
 * @author liujx
 */
public class SumOfSequence {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        BigInteger n1=BigInteger.valueOf(n);
        BigInteger result;
        System.out.println(n1.add(BigInteger.valueOf(1)).multiply(n1).divide(BigInteger.valueOf(2)));
    }
}
