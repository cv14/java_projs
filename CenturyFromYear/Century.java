import java.util.*;

public class Century {

  public static int centuryFromYear(int year) {
    int temp = year % 100;
    if(temp == 0){
      temp = year/100;
    }else{
      temp = (year/100) + 1;
    }
    return temp;
  }

  public static void main(String[] args) {
    System.out.println(centuryFromYear(1700));

  }


}
