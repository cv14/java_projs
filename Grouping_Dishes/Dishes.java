/*
You have a list of dishes. Each dish is associated with a list of ingredients
used to prepare it. You want to group the dishes by ingredients, so that for
each ingredient you'll be able to find all the dishes that contain it (if there
are at least 2 such dishes).

Return an array where each element is a list with the first element equal to
the name of the ingredient and all of the other elements equal to the names of
dishes that contain this ingredient. The dishes inside each list should be
sorted lexicographically. The result array should be sorted lexicographically
by the names of the ingredients in its elements.

Example

For
  dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Salad", "Salad", "Sandwich"],
                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
                            ["Tomato", "Pizza", "Salad", "Sandwich"]]
For
  dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
            ["Chicken Curry", "Chicken", "Curry Sauce"],
            ["Fried Rice", "Rice", "Onions", "Nuts"],
            ["Salad", "Spinach", "Nuts"],
            ["Sandwich", "Cheese", "Bread"],
            ["Quesadilla", "Chicken", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Chicken", "Chicken Curry", "Quesadilla"],
                            ["Nuts", "Fried Rice", "Salad"],
                            ["Onions", "Fried Rice", "Pasta"]]
*/


import java.util.*;

public class Dishes {

   static TreeMap<String, TreeSet<String>> dishesHM = new TreeMap<String, TreeSet<String>>();
   static TreeSet<String> al = new TreeSet<String>();
   static ArrayList<ArrayList<String>> groupedDishes=new ArrayList<ArrayList<String>>();

public static String[][] groupingDishes(String[][] dishes) {



  for (int i = 0; i < dishes.length; i++) {
    al = new TreeSet<String>();
    for (Integer j = 1; j < dishes[i].length; j++) {
      if(dishesHM.containsKey(dishes[i][j])){
        al = dishesHM.get(dishes[i][j]);
        al.add(dishes[i][0]);
        dishesHM.put(dishes[i][j], al);
        al = new TreeSet<String>();
      }else{
        al.add(dishes[i][0]);
        dishesHM.put(dishes[i][j], al);
        al = new TreeSet<String>();
      }
    }
  }
  Set<String> keys = dishesHM.keySet();
    for(String key: keys){
      if(dishesHM.get(key).size() > 1){
        ArrayList<String> inLst = new ArrayList<String>();
        inLst.add(key);
        TreeSet<String> vals = dishesHM.get(key);
        for(String val: vals){
          inLst.add(val);
        }
        groupedDishes.add(inLst);
      }
    }


  String[][] groupedDishesARR = new String[groupedDishes.size()][];
    for (int i = 0; i < groupedDishes.size(); i++) {
        ArrayList<String> row = groupedDishes.get(i);
        groupedDishesARR[i] = row.toArray(new String[row.size()]);
    }

  return groupedDishesARR;
}


public static void main(String[] args) {

  String[][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
            {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
            {"Quesadilla", "Chicken", "Cheese", "Sauce"},
            {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};

  System.out.println(Arrays.deepToString(groupingDishes(dishes)));

  }
}
