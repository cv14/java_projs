/*

Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with
numbers in such a way that each column, each row, and each of the nine 3 × 3
sub-grids that compose the grid all contain all of the numbers from 1 to 9 one
time.

Implement an algorithm that will check whether the given grid of numbers
represents a valid Sudoku puzzle according to the layout rules described above.
Note that the puzzle represented by grid does not have to be solvable.

*/

import java.util.*;

public class Sudoku{

  public static boolean sudoku2(String[][] grid) {

    Set<Integer> horSet = new LinkedHashSet<Integer>();
    Set<Integer> verSet = new LinkedHashSet<Integer>();


        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            char h = grid[i][j].charAt(0);
            char v = grid[j][i].charAt(0);

             if(Character.isDigit(h)){
                 if(horSet.contains(Character.getNumericValue(h))){
                      return false;
                  }else{
                      horSet.add(Character.getNumericValue(h));
                  }
              }

             if(Character.isDigit(v)){
               if(verSet.contains(Character.getNumericValue(v))){
                 return false;
               }else{
                 verSet.add(Character.getNumericValue(v));
               }
             }
          }
          horSet = new LinkedHashSet<Integer>();
          verSet = new LinkedHashSet<Integer>();
        }

          return true;
  }

  public static boolean sudoku2(char[][] grid) {

        Set<Integer> horSet = new LinkedHashSet<Integer>();
        Set<Integer> verSet = new LinkedHashSet<Integer>();
        Set<Integer> gridSet = new LinkedHashSet<Integer>();

        for (int i = 0; i < 7; i = i + 3) {
          for (int j = 0; j < 7; j = j + 3) {

            if(Character.isDigit(grid[i][j])){
              if(gridSet.contains(Character.getNumericValue(grid[i][j]))){
                return false;
              }else{
                gridSet.add(Character.getNumericValue(grid[i][j]));
              }}

            if(Character.isDigit(grid[i][j+1])){
              if(gridSet.contains(Character.getNumericValue(grid[i][j+1]))){
                return false;
              }else{
                gridSet.add(Character.getNumericValue(grid[i][j+1]));
              }}

            if(Character.isDigit(grid[i][j+2])){
              if(gridSet.contains(Character.getNumericValue(grid[i][j+2]))){
                return false;
              }else{
                gridSet.add(Character.getNumericValue(grid[i][j+2]));
              }}

           if(Character.isDigit(grid[i+1][j])){
             if(gridSet.contains(Character.getNumericValue(grid[i+1][j]))){
               return false;
             }else{
               gridSet.add(Character.getNumericValue(grid[i+1][j]));
             }}

           if(Character.isDigit(grid[i+2][j])){
              if(gridSet.contains(Character.getNumericValue(grid[i+2][j]))){
                 return false;
              }else{
                gridSet.add(Character.getNumericValue(grid[i+2][j]));
              }}

          if(Character.isDigit(grid[i+1][j+1])){
             if(gridSet.contains(Character.getNumericValue(grid[i+1][j+1]))){
                return false;
              }else{
               gridSet.add(Character.getNumericValue(grid[i+1][j+1]));
             }}

         if(Character.isDigit(grid[i+1][j+2])){
           if(gridSet.contains(Character.getNumericValue(grid[i+1][j+2]))){
              return false;
            }else{
             gridSet.add(Character.getNumericValue(grid[i+1][j]+2));
           }}
        if(Character.isDigit(grid[i+2][j+1])){
           if(gridSet.contains(Character.getNumericValue(grid[i+2][j+1]))){
              return false;
            }else{
             gridSet.add(Character.getNumericValue(grid[i+2][j+1]));
           }}
        if(Character.isDigit(grid[i+2][j+2])){
           if(gridSet.contains(Character.getNumericValue(grid[i+2][j+2]))){
              return false;
            }else{
             gridSet.add(Character.getNumericValue(grid[i+2][j+2]));
           }}

           gridSet = new LinkedHashSet<Integer>();

            }
          }

            for (int i = 0; i < 9; i++) {
              for (int j = 0; j < 9; j++) {

                if(Character.isDigit(grid[i][j])){
                  if(horSet.contains(Character.getNumericValue(grid[i][j]))){
                    return false;
                  }else{
                    horSet.add(Character.getNumericValue(grid[i][j]));
                  }
                }

                if(Character.isDigit(grid[j][i])){
                  if(verSet.contains(Character.getNumericValue(grid[j][i]))){
                    return false;
                  }else{
                    verSet.add(Character.getNumericValue(grid[j][i]));
                  }
                }

              }
              horSet = new LinkedHashSet<Integer>();
              verSet = new LinkedHashSet<Integer>();


            }

              return true;

      }

  public static void main(String[] args) {
       char[][] grid1 = {
            {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
            {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
            {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
            {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};

       char[][] grid2 = {
                {'.', '.', '.', '.', '2', '.', '.', '9', '.'},
                {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                {'7', '1', '.', '.', '7', '5', '.', '.', '.'},
                {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
                {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '.', '3', '.', '.', '.', '.'}};

       String[][] grid3 = {
         {".","4",".",".",".",".",".",".","."},
         {".",".","4",".",".",".",".",".","."},
         {".",".",".","1",".",".","7",".","."},
         {".",".",".",".",".",".",".",".","."},
         {".",".",".","3",".",".",".","6","."},
         {".",".",".",".",".","6",".","9","."},
         {".",".",".",".","1",".",".",".","."},
         {".",".",".",".",".",".","2",".","."},
         {".",".",".","8",".",".",".",".","."}};

      System.out.println(sudoku2(grid1));
      System.out.println(sudoku2(grid2));
      System.out.println(sudoku2(grid3));


      }
}
