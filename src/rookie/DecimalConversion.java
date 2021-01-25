package rookie;

import java.util.Scanner;

/**
 * @author liujx
 * 十进制转二进制 十进制转十六进制
 */
public class DecimalConversion {
    private static final String HEX_CHARACTERS ="0123456789abcdef";
    private static char[]  hex=new char[30];
    private static int[] octal=new int[30];
    private static int i1=0,i2=0;
    private static void decimalToHex(int num){
        i1=0;
        while(num>0){
            hex[i1++]=HEX_CHARACTERS.charAt(num%16);
            num/=16;
        }
    }

    private static void decimalToOctal(int num){
        i2=0;
        while(num>0){
            octal[i2++]=num%8;
            num/=8;
        }
    }

    private static void displayOctal(){
        for(int i=i2-1;i>=0;i--){
            System.out.print(octal[i]);
        }
    }

    private static void displayHex(){
        for(int i=i1-1;i>=0;i--){
            System.out.print(hex[i]);
        }
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int num;
        while(scanner.hasNext()){
            boolean isNegative=false;
            num=scanner.nextInt();
            if(num<0){
                isNegative=true;
                num=-1*num;
            }

            decimalToOctal(num);
            decimalToHex(num);
            if(isNegative){
                System.out.print("-");
            }
            System.out.print(num+" = ");
            if(isNegative){
                System.out.print("-");
            }
            displayOctal();
            System.out.print("(8) = ");
            if(isNegative){
                System.out.print("-");
            }
            displayHex();
            System.out.println("(16)");
        }
    }
}
