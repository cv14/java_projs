import java.util.Scanner;

public class TTTMethods
{

public static void playerMove(String[][] board, String player)
{
Scanner keyboard = new Scanner(System.in);
//player make move
System.out.println("Please enter your row, 1, 2 or 3");
int userRow = keyboard.nextInt();
while(userRow < 1 || userRow > 3)
        {
        System.out.println("Please enter your row, MUST BE 1, 2 or 3");
        userRow = keyboard.nextInt();
        }
System.out.println("Please enter your column, 1, 2 or 3");
int userColumn = keyboard.nextInt();
while(userColumn < 1 || userColumn > 3)
        {
        System.out.println("Please enter your column, MUST BE 1, 2 or 3");
        userColumn = keyboard.nextInt();
        }

userRow = userRow - 1;
userColumn = userColumn - 1;

while(board[userRow][userColumn].equals("X")
 || board[userRow][userColumn].equals("O"))
 {
 System.out.println("That is an occupied space, please select again.");
System.out.println("Please enter your row, 1, 2 or 3");
userRow = keyboard.nextInt();
while(userRow < 1 || userRow > 3)
        {
        System.out.println("Please enter your row, MUST BE 1, 2 or 3");
        userRow = keyboard.nextInt();
        }
System.out.println("Please enter your column, 1, 2 or 3");
userColumn = keyboard.nextInt();
while(userColumn < 1 || userColumn > 3)
        {
        System.out.println("Please enter your column, MUST BE 1, 2 or 3");
        userColumn = keyboard.nextInt();
        }

userRow = userRow - 1;
userColumn = userColumn - 1;

 }//end body of while

board[userRow][userColumn] = player;
}//end method playerMove

////test if a winner
public static boolean testIfWinner(String[][] board, String player, int count)
{
///test 1
if(!board[0][0].equals("-") &&  board[0][0].equals(board[0][1]) &&
        board[0][1].equals(board[0][2]))
        {
        System.out.println(player + " wins");
        return true;
        }
///test2
if(!board[1][0].equals("-") &&  board[1][0].equals(board[1][1]) &&
        board[1][1].equals(board[1][2]))
        {
        System.out.println(player + " wins");
        return true;
        }
///test3
if(!board[2][0].equals("-") &&  board[2][0].equals(board[2][1]) &&
        board[2][1].equals(board[2][2]))
        {
        System.out.println(player + " wins");
        return true;
        }
///test4
if(!board[0][0].equals("-") &&  board[0][0].equals(board[1][0]) &&
        board[1][0].equals(board[2][0]))
        {
        System.out.println(player + " wins");
        return true;
        }

///test5
if(!board[0][1].equals("-") &&  board[0][1].equals(board[1][1]) &&
        board[1][1].equals(board[2][1]))
        {
        System.out.println(player + " wins");
        return true;
        }
///test6
if(!board[0][2].equals("-") &&  board[0][2].equals(board[1][2]) &&
        board[1][2].equals(board[2][2]))
        {
        System.out.println(player + " wins");
        return true;
        }
///test7
if(!board[0][0].equals("-") &&  board[0][0].equals(board[1][1]) &&
        board[1][1].equals(board[2][2]))
        {
        System.out.println(player + " wins");
        return true;
        }
///test8
if(!board[0][2].equals("-") &&  board[0][2].equals(board[1][1]) &&
        board[1][1].equals(board[2][0]))
        {
        System.out.println(player + " wins");
        return true;
        }

//determine if a tie
if(count >= 9)
        {
         System.out.println("Tie Game Goodbye");
         System.exit(0);
        }
return false;
}//end method testIfWinner

//alternate player
public static String alternatePlayer (String player)
{
  if(player.equals("X"))
        player = "O";
        else
        player = "X";
return player;
}//end method alternatePlayer

//print array
public static void printArray(String[][] boardPassed)
{
for(int r = 0; r < boardPassed.length; ++r)
{//outer loop
    for(int c = 0; c < boardPassed[r].length; ++c)
    {//inner loop
    System.out.print(boardPassed[r][c]);
    }//end column loop
    System.out.println();
}//end row loop
}//end method print array

public static String[][] populateArray(String[][] boardToBePopulated, String symbolToUse)
        {
        for(int r = 0; r < boardToBePopulated.length; ++r)
                {//outer loop
                for(int c = 0; c < boardToBePopulated[r].length; ++c)
                {//inner loop
                boardToBePopulated[r][c] = symbolToUse;
                }//end column loop
        }//end row loop
        return boardToBePopulated;
        }//end method pupulateArray

}//end class
