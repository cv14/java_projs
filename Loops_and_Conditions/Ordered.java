/*
Boolean and integer variables and Conditionals.
Write a program Ordered.java that reads in three integer
command-line arguments, x, y, and z. Define a boolean variable
isOrdered whose value is true if the three values are either in
strictly ascending order (x < y < z) or in strictly descending order
(x > y > z), and false otherwise. Print out the variable isOrdered using
System.out.println(isOrdered).

*/
public class Ordered {

    public static void main(String[] args) {
        int x , y, z;
        boolean isOrdered = false;

        x = Integer.parseInt(args[0]); y = Integer.parseInt(args[1]);
        z = Integer.parseInt(args[2]);

        if((x < y && y < z) || (x > y && y > z)){
            isOrdered = true;
        }

        System.out.println(isOrdered);

    }
}
