import java.util.*;

public class Dishes {

public static String[][] groupingDishes(String[][] dishes) {
  LinkedHashMap<String, TreeSet<String>> dishesHM = new LinkedHashMap<String, TreeSet<String>>();
   TreeSet<String> al = new TreeSet<String>();


  for (int i = 0; i < dishes.length; i++) {
    for (Integer j = 1; j < dishes[i].length; j++) {
      if(dishesHM.containsKey(dishes[i][j])){
        System.out.println("lado");
        al = dishesHM.get(dishes[i][j]);
        al.add(dishes[i][0]);
        System.out.println(al);
        dishesHM.put(dishes[i][j], al);
        System.out.println(dishesHM);
      }else{
        al.add(dishes[i][0]);
        System.out.println(al);
        dishesHM.put(dishes[i][j], al);
        System.out.println(dishesHM);
      }
    }
  }

  //System.out.println(dishesHM);
  System.out.println();
  System.out.println();

  return dishes;
}


public static void main(String[] args) {

  String[][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
            {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
            {"Quesadilla", "Chicken", "Cheese", "Sauce"},
            {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};

  System.out.println(Arrays.deepToString(groupingDishes(dishes)));

  }
}
