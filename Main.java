//Ashley Grafner
//CSC 1060680, Computer Science 1 (Java)
//10/5/2022
//This program will read multiple sets of 16 numbers from Lab8Data.txt (these numbers fill a 4x4 square) and determine if each set of 16 numbers is a magic square.*/
import java.io.*;
import java.io.IOException;
import java.io.File;

import java.util.Scanner;
class Main{
  public static void main(String[] args) throws IOException{
    
    File file = new File("Lab8Data.txt"); //open file named Lab8Data.txt
    Scanner sc = new Scanner(file); 
    int[][] magicSquare = {{0,0,0,0},
                           {0,0,0,0},
                           {0,0,0,0},
                           {0,0,0,0}}; //Array

    for(int y=0; y<4; y++)
      magicSquare[0][y]= sc.nextInt();
    
    while(magicSquare[0][0] != -999){ //The sentinel value is -999

        for(int x=1; x<4; x++) //x axis
          for(int y=0; y<4 ;y++) //y axis
            magicSquare[x][y] = sc.nextInt(); //sets the full array from .txt

        for(int x=0; x<4;x++)
        {
          for (int y=0; y<4; y++)
            System.out.print(magicSquare[x][y]+" "); //prints array + space between each
            System.out.println();
        }

      
      //CHECKS:
      int[] rowTotal = {0,0,0,0}; //row totals 4x4
      for(int x=0; x<4; x++)
        for (int y=0; y<4 ;y++)
          rowTotal[x] += magicSquare[x][y];

     int[] columnTotal = {0,0,0,0}; //row totals 4x4
      for(int y=0; y<4; y++)
        for (int x=0; x<4 ;x++)
          columnTotal[x] += magicSquare[x][y];

      int oneDiagonal = 0; //CHECKS first diagonal top left to bottom right
      for(int x=0; x<4;x++)
        oneDiagonal += magicSquare[x][x];

      int twoDiagonal = 0; //Checks second diagonal top right to bottom left
      int y=3;
      for(int x=0;x<4;x++)
      {
        twoDiagonal += magicSquare[x][y];
        y -=1;
     }

      //Each way CHECKS: 
      int row = rowTotal[0]; //checks rows to see if same
      boolean checkRow = true;
      for(int x=0;x<4;x++) 
        if(rowTotal[x]!= row)
          checkRow = false;

      int col = columnTotal[0]; //checks columns to see if same
      boolean checkCol = true;
      for(int x=0;x<4;x++) 
        if(rowTotal[x]!= row)
          checkCol = false;

      int diag = oneDiagonal; //Checks diagonal to see if same (both ways)
      boolean checkDiag = true;
      if(twoDiagonal != diag)
        checkDiag = false;

     for(int close=0;close<4;close++)
        magicSquare[0][close] = sc.nextInt();//Didn't use y again here because variable is already defined. 
      
      boolean thisSquareIsMagic = false; //auto-false until proven true
      if (checkRow && checkCol && checkDiag) //if all are same
        if(row == col && col == diag) //if all are same
          thisSquareIsMagic = true; //then true

  
      if(thisSquareIsMagic) //if true ^
        System.out.println("IS a magic square");
      else //else it is false
         System.out.println("NOT a magic square");

     
    }
  }
}
  