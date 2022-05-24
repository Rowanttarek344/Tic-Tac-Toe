package gamee;




import java.util.Scanner;

public class TicTacToe {
	//class instances
	private char [][]board;
    private char currentplayermark;
    public int row,column;
    
    
    
    //to access the player mark
    public char getCurrentPlayerMark()
    {
        return currentplayermark;
    }
    
    //board constructor 
    public TicTacToe()
    {
        board=new char[6][7];
        currentplayermark='X';
        
    }
    
    //set the board to empty values
    public void initializeBoard()
    {
        for (int i = 0; i < 6; i++) 
	{
	  for (int j = 0; j < 7; j++) 	
		board[i][j]='_';	
        }
    }
    
    //display the board
    public void printBoard()
    {
        for (int i = 0; i < 6; i++)
        {
	   for (int j = 0; j < 7; j++) 
			
	      System.out.print(board[i][j]+"\t");
			
		System.out.println();
		}
    }
    
    // Change player marks back and forth.
    public void changePlayer() {
        if (currentplayermark == 'X') {
            currentplayermark = 'O';
        }
        else {
            currentplayermark = 'X';
        }
    }
    
    public boolean validateInput(int row,int column)
    {
        while(row<0 || row>5 || column<0 || column>6)
        {
	    	System.out.println("row or column number is invalid!");
            return false;
        }
	     if(board[row][column]!='_')
	    {
	    	System.out.println("place is unavaliable!");
	    	return false;
	    }
            
        else
        {
           board[row][column] = currentplayermark;
           return true;
        }
           
    }
        
    public boolean checkForWin()
    {
    	return(checkRows() || checkCol() || checkDiag1() || checkDiag2());
    	
    }
    
    public boolean checkRows()
    {
        for(int i=0;i<6;i++)
        {
            if((board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][0]!='_') || (board[i][1]==board[i][2] && board[i][2]==board[i][3] && board[i][1]!='_') || (board[i][2]==board[i][3] && board[i][3]==board[i][4] && board[i][2]!='_') || (board[i][3]==board[i][4] && board[i][4]==board[i][5] && board[i][3]!='_')|| (board[i][4]==board[i][5]&& board[i][5]==board[i][6]&& board[i][4]!='_'))
                return true;
        }
        return false;
    }
    
    public boolean checkCol()
    {
        for(int j=0;j<7;j++)
        {
            if((board[0][j]==board[1][j] && board[1][j]==board[2][j] && board[0][j]!='_') || (board[1][j]==board[2][j] && board[2][j]==board[3][j] && board[1][j]!='_') || (board[2][j]==board[3][j] && board[3][j]==board[4][j] && board[2][j]!='_') || (board[3][j]==board[4][j] && board[4][j]==board[5][j] && board[3][j]!='_'))
                return true;
        }
        return false;
    }
    
    public boolean checkDiag1()
    {
    int i=row;
    	int j=column;
    	while(i!=0 && j!=0)
    	{

    		i--;
    		j--;
    	}
    	int countX=0;
    	int countO=0;
    	
    	while(i<=5 && j<=6)
    	{
    		if(board[i][j]=='X')
    		{
    			countX++;
    			if(countX == 3)
    				return true;
    		}else {
    			countX = 0;
    		}
    		
    		if(board[i][j]=='O')
    		{
    			countO++;
    			if(countO == 3)
    				return true;
    		}else {
    			countO = 0;
    		}
    		i++;
    		j++;
  
    	}
    	return false;
    	
    }
    
    public boolean checkDiag2()
    {
    		int i=row;
    	int j=column;
    	while(i!=5 && j!=0)
    	{

    		i++;
    		j--;
    	}
    	int countX=0;
    	int countO=0;
    
    	while(i>=0 && j<=6)
    	{
    		if(board[i][j]=='X')
    		{
    			countX++;
    			if(countX == 3)
    				return true;
    		}else {
    			countX = 0;
    		}
    		
    		if(board[i][j]=='O')
    		{
    			countO++;
    			if(countO == 3)
    				return true;
    		}else {
    			countO = 0;
    		}
    		i--;
    		j++;
  
    	}
    	return false;
    	
    }
    
    
    public void play()
    {
    	 boolean iswin=false;
    	for(int i=0;i<42;i++)
    	{
    		System.out.println("player "+currentplayermark+" turn");
    		System.out.println("enter a row from 1 to 6:");
    		Scanner s1=new Scanner(System.in);
    		
    	
   	        row=(s1.nextInt())-1;
   	        System.out.println("enter a column from 1 to 7:");
   	        column=(s1.nextInt())-1;
   	        
   	        boolean x=validateInput(row,column); 
   	        while(x==false)
   	        {
   	        	
   	        	System.out.println("enter a valid row number from 1 to 6:");
   	        	row=(s1.nextInt())-1;
   	        	System.out.println("enter a valid column number from 1 to 7:");
   	        	column=(s1.nextInt())-1;
   	        	
   	        	
   	        	
   	   	        
   	   	     x=validateInput(row,column); 

   	        }
   	        
   	        printBoard();
   	        
   	        
   	        
   	       iswin=checkForWin();
   	        if(iswin==true)
   	        {
   	        	System.out.println("player "+currentplayermark+" has won");
   	        	break;
   	        }
   	        changePlayer();	
   	        
   	        
    	}
    	if(!iswin)
    	System.out.println("No has won,try again!");
    	
        
               
                
        
       
        
        
        
        
    }
    
    
    
    

}
