package rookie;

/**
 *1071 谁做好事
 */
public class WhoDidIt {
     public static void main(String[] args){
         char people;
         int cnt=0;
         for(people='A';people<='D';people++){
             cnt=0;
             if(people!='A'){
                 cnt++;
             }
             if(people=='C'){
                 cnt++;
             }
             if(people=='D'){
                 cnt++;
             }
             if(people!='D'){
                 cnt++;
             }

             if(cnt==3){
                 System.out.println(people);
             }
         }
    }
}
