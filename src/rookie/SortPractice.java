package rookie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SortPractice {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int a,b,c;
        while(scanner.hasNext()){
            a=scanner.nextInt();
            b=scanner.nextInt();
            c=scanner.nextInt();
            ArrayList<Integer> integerList=new ArrayList<>();
            integerList.add(a);
            integerList.add(b);
            integerList.add(c);
            integerList.sort(Comparator.naturalOrder());

            for(int i=0;i<integerList.size();i++){
                System.out.print(integerList.get(i)+" ");
            }
            System.out.println();
        }
    }
}
