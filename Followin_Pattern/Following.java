/*Given an array strings, determine whether it follows the sequence given in
the patterns array. In other words, there should be no i and j for which
strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which
strings[i] ≠ strings[j] and patterns[i] = patterns[j].

Example

For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output
should be areFollowingPatterns(strings, patterns) = true;
For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the output
should be areFollowingPatterns(strings, patterns) = false.
*/

import java.util.*;

public class Following {
  public static boolean areFollowingPatterns(String[] strings, String[] patterns){
    HashMap<String, String> mapa = new HashMap<String, String>();
    HashMap<String, String> mapaRev = new HashMap<String, String>();

    for(int i = 0; i < strings.length; i++){
      if(mapa.containsKey(strings[i])){
        if(mapa.get(strings[i]).equals(patterns[i]) == false){
          return false;
        }
      }else{
        mapa.put(strings[i],patterns[i]);
      }
      if(mapaRev.containsKey(patterns[i])){
        if(mapaRev.get(patterns[i]).equals(strings[i]) == false){
          return false;
        }
      }else{
        mapaRev.put(patterns[i],strings[i]);
      }
    }

  return true;
}


  public static void main(String[] args) {

    String[] str = {"cat", "dog", "doggy"};
    String[] patterns = {"a", "b", "b"};
    System.out.println(areFollowingPatterns(str, patterns));

  }

}
