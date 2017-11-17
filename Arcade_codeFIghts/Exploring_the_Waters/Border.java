/*
Given a rectangular matrix of characters, add a border of asterisks(*) to it.

Example

For

picture = ["abc",
           "ded"]
the output should be

addBorder(picture) = ["*****",
                      "*abc*",
                      "*ded*",
                      "*****"]


*/

import java.util.*;

public class Border {

   static String stringMultiply(String s, int n){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
        sb.append(s);
    }
    return sb.toString();
  }

  static String[] addBorder(String[] picture) {
    ArrayList<String> frontera = new ArrayList<String>(picture.length + 2);
    String temporal = stringMultiply("*", picture[0].length() + 2);
    frontera.add(temporal);

    for (int i = 0; i < picture.length; i++) {
      frontera.add("*" + picture[i] + "*");
    }
    frontera.add(stringMultiply("*", picture[0].length() + 2));

    return frontera.toArray(new String[frontera.size()]);
  }

  public static void main(String[] args) {
    String[] pic = {"abc", "ded"} ;
    System.out.println(Arrays.toString(addBorder(pic)));
  }
}
