

import java.util.Scanner;
public class Sudoku {
    static int board[][]=new int[9][9];
    static boolean result = false;
    		public static void main(String[] args) throws InterruptedException {
    			
    			Sudoku sudoku = new Sudoku(); 	
    			sudoku.enterBoard(); 
    			sudoku.fillBoard(0,0);
    			if(result==false) {
    				System.out.println("No Solution");
    			}
    		}
    		
    		public static void enterBoard() {
    			Scanner scanner=new Scanner(System.in);  			
    			for(int i=0;i<9;i++)
    			{
    				String line=scanner.nextLine();
    				for(int j=0;j<9;j++)
    				{
    					board[i][j]=line.charAt(j)-'0';
    				}
    			}
			}
    		
    		
    
    		// Fill in the number to row row line column
    		public static void fillBoard(int row,int line)
    		{
    			if(row==9) //Print out when the number fills up
    			{
    				result = true;
    				printBoard();
    				return ; //Print and exit the program
    			}
    				
    			if(board[row][line]==0)   //There are no Numbers in the current cell
    			{	
        			for(int value=1;value<10;value++)
        			{
        				if(checkg(row, line, value)!=0&&checkrl(row, line, value)!=0) //3*3 check ,  row check and column check
        				{
        					
        					board[row][line]=value;      //Through detection, the number I is filled into the cell
        
        	        		   //Enter the next space number
        	        		   if(line<8)  fillBoard(row, line+1);
        	        		   else if(row<9&&line==8)  fillBoard(row+1, 0);
        	        		   
        	        		 //back   The number error filled in at this point is reset and the next unrepeated number is attempted
        	        		   board[row][line]=0;  	
            			}
        				
        			}
        			
    			}else //There are Numbers in the current cell. Find the next cell
    			{
    				if(line<8)  fillBoard(row, line+1);
  	    		   else if(row<9&&line==8)  fillBoard(row+1, 0);
				}
				
    		}
    		
    		//3*3 check
    		public static int checkg(int row,int line,int value)
    		{
    			if(row>=0&&row<=2)  row=0;
    			if(row>=3&&row<=5)  row=3;
    			if(row>=6&&row<=8)  row=6;
    			if(line>=0&&line<=2) line=0;
    			if(line>=3&&line<=5) line=3;
    			if(line>=6&&line<=8) line=6;
    			
    			for(int i=row;i<row+3;i++)
    			{
    				for(int j=line;j<line+3;j++)
    				{
    				//	System.out.println(i+" "+j);
    					if(board[i][j]==value)    //There are repeated Numbers
    					{
    						return 0;
    					}	
    				}
    			}
    			
    			return 1;   //There are no-repeated Numbers
    		}
    		
    		//row check and column check
    		public static int checkrl(int row,int line,int value)
    		{
    			for(int i=0;i<9;i++)
    			{
    				if(board[row][i]==value||board[i][line]==value) //There are duplicate Numbers in a row or column
    					return 0;
    			}
    			return 1;
    		}
    
    		//print
    		public static void printBoard()
    		{
    			
    		
    			for(int i=0;i<9;i++)
    			{
    				
    				if(i%3==0) {
    					System.out.print(" -----------------------\n");
    				}
    				for(int j=0;j<9;j++)
    				{	
    					if(j%3==0) {
    						System.out.print("| ");
    					}
    					System.out.print(board[i][j]+" ");
    					if(j==8) {
    						System.out.print("|");
    					}
    				}
    				if(i<=7 ) {
    					System.out.println();
    				}
    				
    			}
    			System.out.println();
    			System.out.println(" -----------------------");
    		}
}
