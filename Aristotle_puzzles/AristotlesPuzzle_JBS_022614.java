
import java.util.Scanner;
import java.util.Arrays;

public class AristotlesPuzzle_JBS_022614
{
public static void main(String[] args) throws Exception
{
	Tile[][] Board = new Tile[5][];
	Board[0] = new Tile[3];
	Board[1] = new Tile[4];
	Board[2] = new Tile[5];
	Board[3] = new Tile[4];
	Board[4] = new Tile[3];
	PopulateBoard(Board);//new
	//PrintArrayOfPlayedTiles(Board);//new
	Tile[] AvailableTiles = new Tile[19];
	PopulateArrayOfPlayingTiles(AvailableTiles);
	
	do//new
	{
		System.out.println("The tiles as placed so far:");
		PrintArrayOfPlayedTiles(Board);
		PlaceTile(Board, AvailableTiles);
	}while(!TestForWinner(Board));
}//end main

//method to populate the array of tiles with numbers 1 to array length + 1 inclusive
private static void PopulateArrayOfPlayingTiles(Tile[] arrayOfTilesPassed)
{
for(int i = 0; i < arrayOfTilesPassed.length; ++i)
	{
	 arrayOfTilesPassed[i] = new Tile(false, i + 1);
	}//end for loop	
}//end method PopulateArrayOfTiles

//method to place a tile

private static void PlaceTile(Tile[][] boardPassed, Tile[] tilesPassed)
{
	Scanner keyboard = new Scanner(System.in);
	int row, col, userInput;
	//selection of tile to play
	do
	{
	System.out.println("Select a tile to place. The available tiles are:");
	for(Tile x: tilesPassed)
	{
		if(x.getPlaced() == false)
			System.out.print(x.getValue() + " ");
	}//end for loop
	System.out.println();
	userInput = keyboard.nextInt();
	System.out.println("HERE");
	}while(userInput < tilesPassed[0].getValue() 
	|| userInput > tilesPassed[tilesPassed.length - 1].getValue() 
	|| tilesPassed[userInput].getPlaced() == true);
	
	
	do
	{
		PrintArrayOfPlayedTiles(boardPassed);
		System.out.println("Select a row must be >= 1 and <= " + boardPassed.length + ":");
		row = keyboard.nextInt();
			while(row < 0 || row > boardPassed.length)
			{
			System.out.println("Invalid selection.");
			System.out.println("Select a row must be >= 1 and <= " + boardPassed.length + ":");
			row = keyboard.nextInt();			}//end while
		
		System.out.println("Select a column must be >= 1 and <= " + 
		boardPassed[row - 1].length + ":");
		col = keyboard.nextInt();	
			while(col < 0 || col > boardPassed.length)
			{
			System.out.println("Invalid selection.");
			System.out.println("Select a column must be >=1  and <= " 
					+ boardPassed[row - 1].length + ":");
			col = keyboard.nextInt();			}//end while
	
	//adjust for index starting at 0
	row = row - 1;
	col = col - 1;
	
	//test if occupied
	if(boardPassed[row][col].getPlaced())
	{
	System.out.println("A tile is already placed in that space. Select again.");
	continue;
	}//end if


	}while(boardPassed[row][col].getPlaced());
	
	tilesPassed[userInput -1].setPlaced(true);
	boardPassed[row][col] = tilesPassed[userInput - 1];
	boardPassed[row][col].setValue(userInput);
	
}//end method PlaceTile



//method to populate the board
private static void PopulateBoard(Tile[][] arrayPassed)
{
for(int i = 0; i < arrayPassed.length; ++i)
{
for(int j = 0; j < arrayPassed[i].length; ++j)
	{
	arrayPassed[i][j] = new Tile();
	}//end inner for loop
}//end outer for loop
}//end method


//method to print the array of placed tiles
private static void PrintArrayOfPlayedTiles(Tile[][] arrayPassed)
{
for(int i = 0; i < arrayPassed.length; ++i)
{
	switch(i)
		{
		case 0:
		case 4:
			System.out.print("  ");
			break;
		case 1:
		case 3:
			System.out.print(" ");
			break;
		default:
			break;			
		}//end switch
for(int j = 0; j < arrayPassed[i].length; ++j)
	{
		
	if(j > 0 && j < arrayPassed[i].length)
		System.out.print('|');
	System.out.print(arrayPassed[i][j].getValue());
	}//end inner for loop
System.out.println();	
}//end outer for loop
}//end method PrintArrayOfTiles


//method to populate the array of tiles with numbers 1 to array length + 1 inclusive
private static void PopulateArrayOfAvailableTiles(Tile[] arrayOfTilesPassed)
{
for(int i = 0; i < arrayOfTilesPassed.length; ++i)
	{
	 arrayOfTilesPassed[i] = new Tile(false, i + 1);
	}//end for loop	
}//end method PopulateArrayOfTiles


//method to print the array of available tiles
private static void PrintArrayOfAvailablesTiles(Tile[] arrayPassed)
{
for(Tile x: arrayPassed)
{
	if(x.getPlaced() == false)
		System.out.print(x.getValue() + " ");
}//end for loop
System.out.println();
}//end method PrintArrayOfTiles


//method to test if puzzle has been solved
private static boolean TestForWinner(Tile[][] a)//changed || to &&
{
	return(
	(
	(a[0][0].getValue() + a[0][1].getValue() + a[0][2].getValue()) == 38
	&&
	(a[1][0].getValue() + a[1][1].getValue() + a[1][2].getValue() + a[1][3].getValue()) == 38
	&&
	(a[2][0].getValue() + a[2][1].getValue() + a[2][2].getValue() + a[2][3].getValue() + 
			a[2][4].getValue()) == 38
	&&
	(a[3][0].getValue() + a[3][1].getValue() + a[3][2].getValue() + a[3][3].getValue()) == 38
	&&
	(a[4][0].getValue() + a[4][1].getValue() + a[4][2].getValue()) == 38
	)
	&&
	(
	(a[2][0].getValue() + a[3][0].getValue() + a[4][0].getValue()) == 38
		&&
		(a[1][0].getValue() + a[2][1].getValue() + a[3][1].getValue() + a[4][1].getValue()) == 38
		&&
		(a[0][0].getValue() + a[1][1].getValue() + a[2][2].getValue() + a[3][2].getValue() + 
				a[4][2].getValue()) == 38
		&&
		(a[0][1].getValue() + a[1][2].getValue() + a[2][3].getValue() + a[3][3].getValue()) == 38
		&&
		(a[0][2].getValue() + a[1][3].getValue() + a[2][4].getValue()) == 38
		)
		&&
		(
		(a[2][0].getValue() + a[1][0].getValue() + a[0][0].getValue()) == 38
		&&
		(a[3][0].getValue() + a[2][1].getValue() + a[1][1].getValue() + a[0][1].getValue()) == 38
		&&
		(a[4][0].getValue() + a[3][1].getValue() + a[2][2].getValue() + a[1][2].getValue() + 
				a[0][2].getValue()) == 38
		&&
		(a[4][1].getValue() + a[3][2].getValue() + a[2][3].getValue() + a[1][3].getValue()) == 38
		&&
		(a[4][2].getValue() + a[3][3].getValue() + a[2][4].getValue()) == 38
		)
		);
}//end method TestForWinner



}//end class