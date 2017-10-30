import java.util.*;

public class Dishes {

public static String[][] groupingDishes(String[][] dishes) {
  LinkedHashMap<String, TreeSet<String>> dishesHM = new LinkedHashMap<String, TreeSet<String>>();
   TreeSet<String> al = new TreeSet<String>();


  for (int i = 0; i < dishes.length; i++) {
    for (Integer j = 1; j < dishes[i].length; j++) {
      dishesHM.put(dishes[i][j], al )
    }
  }

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
