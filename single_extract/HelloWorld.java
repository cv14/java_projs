import java.util.*;

public class HelloWorld{

  public static char firstNotRepeatingCharacter(String s) {
          LinkedHashMap<Character, Integer> hm = new LinkedHashMap();
          int count = 0;
          int i = 0;

          for(i = 0; i < s.length(); i++){
              if(hm.containsKey(s.charAt(i))){
                  hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
              }else{
                  hm.put(s.charAt(i), 1);
              }
          }

          Collection<Integer> vals = hm.values();
          Set<Character> keys = hm.keySet();

          for (Integer kk : vals) {
            if(kk == 1){
              break;
          }
          count++;
        }


        i = 0;
        Iterator<Character> itr = keys.iterator();
          while(itr.hasNext()){
            if( i == count){
              return itr.next();
            }
            itr.next();
            i++;
          }


          return '_';
}

     public static void main(String []args){
        System.out.println(firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"));
     }
}
