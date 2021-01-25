package rookie.important;

import java.util.*;

/**
 * 1067按纯度筛选
 * @author liujx
 */
public class AnChunDuShuaiXuan1067 {
    public static void main(String[] args){
        int n;
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            n=scanner.nextInt();
            if(n==0){
                break;
            }
            List<Stone> stoneList=new ArrayList<>();
            while(n!=0){
                String tempStr=scanner.next();
                stoneList.add(new Stone(tempStr));
                n--;
            }

            stoneList.sort(new Comparator<Stone>(){
                @Override
                public int compare(Stone o1, Stone o2) {
                    int pd1=o1.getPureDigit();
                    int pd2=o2.getPureDigit();
                    if(pd1==pd2){
                        String str1=o1.getStr();
                        String str2=o2.getStr();
                        if(str1.length()==str2.length()){
                            return str1.compareTo(str2);
                        }
                        return str2.length()-str1.length();
                    }
                    return pd1-pd2;
                }
            });

            for(Stone stone:stoneList){
                System.out.println(stone.getStr());
            }
            System.out.println();
        }


    }


}
class Stone{
    private String str;
    private int pureDigit;
    public Stone(String str){
        Map<Character, Integer> tempMap =new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            tempMap.putIfAbsent(c, 1);
        }

        this.str=str;
        this.pureDigit=tempMap.size();

    }

    public String getStr() {
        return str;
    }

    public int getPureDigit(){
        return pureDigit;
    }
}
