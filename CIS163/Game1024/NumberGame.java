/*****************************************************************
1024 Game

@author Joseph + Alen
@version February 2017
*****************************************************************/

package game1024;
import java.util.ArrayList;
import java.util.Stack;

public class NumberGame implements NumberSlider
{
	 /** current value of height */
	int height;
	
	 /** current value of width */
	int width;
	
	 /** current value of winning game value */
	int winningValue;
	
	 /** 2D Array of Game Board */
	int[][] board;
	
	 /** Stack of GameState */
	Stack gameState;
	
	/*****************************************************************
	Default Constructor that sets all field variables to initial values and
    calls checkValid(); checks if the winning value of the game is legitimate.
	*****************************************************************/
	public NumberGame()
	{
		this.height = 4;
		this.width = 4;
		this.winningValue = 1024;
		this.gameState = new Stack();
		resizeBoard(this.height, this.width, this.winningValue);
		checkValid();
		reset();
	}
	
	/*****************************************************************
	Checks if the game winning value is legitimate.
	@return none
	*****************************************************************/
	public void checkValid()
	{
		if(this.winningValue < 0 )
		{
			throw new IllegalArgumentException("Winning value can't be negative");
		}
		int p = 1; 
		int v = 0;
		boolean passed = false;
		while(v < Integer.MAX_VALUE || p <20)
		{
			v = (int)(Math.pow(2, p));
			if(v == this.winningValue)
				{
				passed = true;
				}
			p++;
		}
		if (!passed)
			{
			throw new IllegalArgumentException("Winning value is not a power of 2");
			}
	}
	
	/*****************************************************************
	Resizes the game board and sets the game winning value.
	Also checks if the parameter value winningValue is valid.
	@param height - height of game board
	@param width - width of game board
	@param winningValue - winning value of game
	@return none
	*****************************************************************/
	public void resizeBoard (int height, int width, int winningValue)
	{
		this.height = height;
		this.width = width;
		this.winningValue = winningValue;
		this.board = new int[this.height][this.width];
		checkValid();
	}
	
	/*****************************************************************
	Sets all spaces on the board to a value of 0.
	Places 2 random values on the board.
	Gets the status of the game board.
	@param none
	@return none
	*****************************************************************/
	public void reset()
	{
		for(int r = 0; r < height; r++)
		{
			for(int c = 0; c < width; c++)
			{
				board[r][c] = 0;
			}
		}
		placeRandomValue();
		placeRandomValue();
		getStatus();
	}
	
	/*****************************************************************
	Checks the 2D Array Game Board if the board is currently full of values.
	@param none
	@return boolean
	*****************************************************************/
	public boolean isFull()
	{
		for(int r = 0; r < height; r++)
		{
			for(int c = 0; c < width; c++)
			{
				if(board[r][c] == 0)
					{
					return false;
					}
			}
		}
		return true;
	}

	/*****************************************************************
	Sets all spaces on the board to the elements corresponding to the ref 2D Array.
	@param  ref - 2D Array
	@return none
	*****************************************************************/
	public void setValues(final int[][] ref)
	{
		for(int r = 0; r < height; r++)
		{
			for(int c = 0; c < width; c++)
			{
				board[r][c] = ref[r][c];
			}
		}
	}
	
	/*****************************************************************
	Places random values on the game board if an empty location is found.
	@param none
	@return Cell
	*****************************************************************/
	public Cell placeRandomValue()
	{
		int randomValue = 0;
		int r = (int)(Math.random() * height);
		int c = (int)(Math.random() * width);
		if(isFull())
			{
			throw new IllegalStateException("Board is full. Can not add new Value");	
			}
		else
		{
			while(board[r][c] != 0)
			{
				 r = (int)(Math.random() * height);
				 c = (int)(Math.random() * width);
			}
			 randomValue = (int)(Math.pow(2, (int)(Math.random() *2 ) + 1));
			board[r][c] = randomValue;
		}
		return new Cell(r, c, randomValue);
	}
	 
	/*****************************************************************
	Slides the values on the game board left, right, up, or down.
	Combines values that are the same.
	@param direction
	@return boolean
	*****************************************************************/
	public boolean slide (SlideDirection direction)
	{
		int[][] boardCopy = copy();
		gameState.add(boardCopy);
		
		if(direction == SlideDirection.UP)
		{
			for(int c = 0; c < board[0].length; c++)
				for(int r = 0; r < board.length; r++)
				{
					slideUp(board, r, c);
				}
			for(int c = 0; c < board[0].length; c++)
				for(int r = 0; r < board.length - 1; r++)
				{
					if(board[r][c] == board[r + 1][c] && board[r][c] != 0)
					{
						board[r][c] *= 2;
						board[r + 1][c] = 0;
						slideUp(board, r + 1, c);
					}
					else if(board[r][c] == 0 && board[r + 1][c] != 0)
					{
						board[r][c] = board[r + 1][c];
						board[r + 1][c] = 0;
					}
				}
			}
		
			else if(direction == SlideDirection.DOWN)
			{
				for(int c = 0; c < board[0].length; c++)
				{
					for(int r = board.length - 1; r >= 0; r--)
					{
						slideDown(board, r, c);
					}
				}
				for(int c = 0; c < board[0].length; c++)
				{
					for(int r = board.length - 1; r > 0; r--)
					{
						if(board[r][c] == board[r - 1][c] && board[r][c] != 0)
						{
							board[r][c] *= 2;
							board[r - 1][c] = 0;
							slideDown(board, r - 1, c);
						}
						else if(board[r][c] == 0 && board[r - 1][c] != 0)
						{
							board[r][c]=board[r - 1][c];
							board[r - 1][c] = 0;
						}
					}
				}
			}
		
			else if(direction == SlideDirection.LEFT)
				{
					for(int r = 0; r < board.length; r++)
					{
						for(int c = 0; c < board[0].length; c++)
						{
							slideLeft(board, r, c);
						}
					}
					for(int r = 0; r < board.length; r++)
					{
						for(int c = 0; c < board[0].length - 1; c++)
						{
							if(board[r][c] == board[r][c + 1] && board[r][c] != 0)
							{
								board[r][c] *= 2;
								board[r][c + 1] = 0;
								slideLeft(board, r, c - 1);
							}
							else if(board[r][c] == 0 && board[r][c + 1] != 0)
							{
								board[r][c] = board[r][c + 1];
								board[r][c + 1] = 0;
							}
						}
					}
				}
		
			else if(direction == SlideDirection.RIGHT)
			{
				for(int r = 0; r < board.length; r++)
				{
					for(int c = board[0].length - 1; c >= 0; c--)
					{
						slideRight(board, r, c);
					}
				}
				for(int r = 0; r < board.length; r++)
				{
					for(int c = board[0].length - 1; c > 0; c--)
					{
						if(board[r][c] == board[r][c - 1] && board[r][c] != 0)
						{
							board[r][c] *= 2;
							board[r][c - 1] = 0;
							slideRight(board, r, c - 1);
						}
						else if(board[r][c] == 0 && board[r][c - 1] != 0)
						{
							board[r][c] = board[r][c - 1];
							board[r][c - 1] = 0;
						}
					}
				}
			}	
		
		if(isDifferent(boardCopy))
			{
			placeRandomValue();
			}
		
		return false;
	}

	/*****************************************************************
	Checks if the 2D Array is different then the current 2D Array game board.
	@param different - 2D Array
	@return boolean
	*****************************************************************/
	public boolean isDifferent(int[][] different)
	{
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board[0].length; c++)
			{
				if (different[r][c] != board[r][c])
					{
					return true;
					}
			}	
		}
		return false;
	}
	
	/*****************************************************************
	Creates a copy of the Game Board.
	@param none
	@return 2D Array
	*****************************************************************/
	public int[][] copy()
	{
		int[][]gameCopy = new int[board.length][board[0].length];
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board[0].length; c++)
			{
				gameCopy[r][c] = board[r][c];
			}	
		}
		return gameCopy;
	}
	
	/*****************************************************************
	Checks to see if the index above in the 2D Array is 0 and the current index is 0 then slide up.
	@param board
	@param r
	@param c
	@return none
	*****************************************************************/
	public static void slideUp(int[][] board, int r, int c)
	{
		while(r > 0 && board[r - 1][c] == 0 && board[r][c] != 0)
		{
			board[r - 1][c] = board[r][c];
			board[r][c] = 0;
			r--;
		}
	}

	/*****************************************************************
	Checks to see if the index to the left in the 2D Array is 0 and the current index is 0 then slide left.
	@param board
	@param r
	@param c
	@return none
	*****************************************************************/
	public static void slideLeft(int[][] board, int r, int c)
	{
		while(c > 0 && board[r][c - 1] ==0 && board[r][c] != 0)
		{
			board[r][c - 1]=board[r][c];
			board[r][c] = 0;
			c--;
		}
	}

	/*****************************************************************
	Checks to see if the index right in the 2D Array is 0 and the current index is 0 then slide right.
	@param board
	@param r
	@param c
	@return none
	*****************************************************************/
	public static void slideRight(int[][] board, int r, int c)
	{
		while(c < board[0].length - 1 && board[r][c + 1] == 0 && board[r][c] != 0)
		{
			board[r][c + 1] = board[r][c];
			board[r][c] = 0;
			c++;
		}
	}

	/*****************************************************************
	Checks to see if the index below in the 2D Array is 0 and the current index is 0 then slide down.
	@param board
	@param r
	@param c
	@return none
	*****************************************************************/
	public static void slideDown(int[][] board, int r, int c)
	{
		while(r < board.length - 1 && board[r + 1][c] == 0 && board[r][c] != 0)
		{
			board[r + 1][c] = board[r][c];
			board[r][c] = 0;
			r++;
		}
	}

	/*****************************************************************
	Checks to see if the index's adjacent to each other have the same values or not
	@param none
	@return boolean
	*****************************************************************/
	public boolean hasAdjacentIdentical()
	{
		//check vertical
		for(int c = 0; c < width; c++)
		{
			for(int r = 0; r < height - 1; r++)
			{
				if(board[r][c] == board[r + 1][c])
					{
					return true;
					}
			}
		}
		//check horizontal
		for(int c = 0; c < width - 1; c++)
		{
			for(int r = 0; r < height; r++)
			{
				if(board[r][c] == board[r][c + 1])
					{
					return true;
					}
			}
		}
		return false;
	}

	/*****************************************************************
	If there is an empty index in the 2D Array it is added to a new ArrayList.
	@param none
	@return ArrayList
	*****************************************************************/
	public ArrayList<Cell> getNonEmptyTiles()
	{
		 ArrayList<Cell> nonEmptyTiles = new ArrayList<Cell>();
		 for(int r = 0; r < height; r++)
			{
				for(int c = 0; c < width; c++)
				{
					if(board[r][c] != 0)
					{
						nonEmptyTiles.add(new Cell(r, c, board[r][c]));
					}
					
				}
			}
		 return nonEmptyTiles;
	}
	
	/*****************************************************************
	Gets the current status of the game.
	@param none
	@return GameStatus
	*****************************************************************/
	public GameStatus getStatus()
	{
		if(checkWin())
			{
			return GameStatus.USER_WON;
			}
		else if(checkLoss())
			{
			return GameStatus.USER_LOST;
			}
		else
		{
			return GameStatus.IN_PROGRESS;
		}
	}
	
	/*****************************************************************
	Checks if the game can not be won therefore a loss.
	@param none
	@return boolean
	*****************************************************************/
	public boolean checkLoss()
	{
		if(!checkWin() && isFull() && !hasAdjacentIdentical())
			{
			return true;
			}
		else
			{
			return false;
			}
	}
	
	/*****************************************************************
	Checks the 2D Array if the winning value has been achieved.
	@param none
	@return boolean
	*****************************************************************/
	public boolean checkWin()
	{
		 for(int r = 0; r < height; r++)
			{
				for(int c = 0; c < width; c++)
				{
					if(board[r][c] >= winningValue)
						{
						return true;
						}
				}
			}
		 return false;
	}
	
	/*****************************************************************
	Undo most recent move in the game.
	@param none
	@return none
	*****************************************************************/
	public void undo()
	{
		if (!gameState.empty())
			board = (int[][]) gameState.pop();
		getStatus();
	}
}