/*****************************************************************
1024 Game GUI

@author Joseph
@version March 2017
*****************************************************************/

package game1024;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
  
public class GUI implements KeyEventDispatcher, ActionListener {
	
	/** current value of DEFAULT_SIZE */
    private final static int DEFAULT_SIZE = 4;
    
    /** JFrame object top */
    private JFrame top;
    
    /** JFrame object top2 */
    private JFrame top2;
    
    /** JPanel object gamePanel */
    private JPanel gamePanel;
    
    /** JPanel object gamePanel2 */
    private JPanel gamePanel2;
    
    /** JLabel 2D Array gameBoardUI */
    private JLabel[][] gameBoardUI;
    
    /** JMenuItem objects reset, quit, undo */
    private JMenuItem reset, quit, undo;
    
    /** current value of games played */
    private int gamesPlayed;
    
    /** current value of number of slides */
    private int numSlides;

    /** NumberGame object game1024 */
    NumberGame game1024;

    JLabel labelNumSlides;
    
    /*****************************************************************
	Default Constructor that initializes all field variables and sets up
	the game board.
	*****************************************************************/
    public GUI()
    {
        top = new JFrame ("1024 Game");
        
        top2 = new JFrame ("Game Statistics");
        
        game1024 = new NumberGame();

        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(DEFAULT_SIZE, DEFAULT_SIZE));
        top.add(gamePanel, BorderLayout.CENTER);
        KeyboardFocusManager kManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kManager.addKeyEventDispatcher(this);

        gameBoardUI = new JLabel[DEFAULT_SIZE][DEFAULT_SIZE];
        Font myTextFont = new Font(Font.SERIF, Font.BOLD, 40);
        for (int k = 0; k < gameBoardUI.length; k++)
            for (int m = 0; m < gameBoardUI[k].length; m++)
            {
                gameBoardUI[k][m] = new JLabel("X", JLabel.CENTER);
                gameBoardUI[k][m].setFont(myTextFont);
                gameBoardUI[k][m].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                gameBoardUI[k][m].setPreferredSize(new Dimension (100, 100));
                gamePanel.add(gameBoardUI[k][m]);
            }
    

        JMenuBar mb = new JMenuBar();
        top.setJMenuBar(mb);
        JMenu game = new JMenu("Game");
        mb.add(game);
        reset = new JMenuItem ("Reset");
        reset.addActionListener(this);
        quit = new JMenuItem("Quit");
        quit.addActionListener(this);
        undo = new JMenuItem("Undo");
        undo.addActionListener(this);
        game.add(reset);
        game.addSeparator();
        game.add(quit);
        game.addSeparator();
        game.add(undo);
        updateUI();
        top.pack();
        top.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        top.setVisible(true);
        
        //////////////////////////////////////////////////////////////////////////////
        gamesPlayed = 0;
        numSlides = 0;
        gamePanel2 = new JPanel();
        gamePanel2.setLayout(new GridLayout(5, 5));
        top2.add(gamePanel2, BorderLayout.CENTER);
        
        JLabel label1 = new JLabel("Statistics");
        gamePanel2.add(label1);
        
        JLabel labelGamesPlayed = new JLabel();
        labelGamesPlayed.setText("Games Played: " + this.gamesPlayed);
        gamePanel2.add(labelGamesPlayed);
        
        labelNumSlides = new JLabel();
        labelNumSlides.setText("Number Of Slides: " + this.numSlides);
        gamePanel2.add(labelNumSlides);
        
        top2.pack();
        top2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        top2.setVisible(true);
        

       
    }

    /*****************************************************************
	Main Method - creates GUI.
	@param args - String Array
	@return none
	*****************************************************************/
    public static void main (String[] args)
    {
        new GUI();
    }

    /*****************************************************************
	Updates the UI with correct gameboard values.
	@param none
	@return none
	*****************************************************************/
    private void updateUI()
    {
    	for(int r = 0; r < game1024.board.length; r++)
    	{
    		for(int c = 0; c < game1024.board[0].length; c++)
    		{
    			if(game1024.board[r][c]!=0)gameBoardUI[r][c].setText(String.valueOf(game1024.board[r][c]));
    			else gameBoardUI[r][c].setText(" ");
    		}
    	}
   }
    
    /*****************************************************************
	Moves tiles on gameboard using KeyEvents, checks if player has one or lost.
	@param e - KeyEvent
	@return boolean
	*****************************************************************/
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                	game1024.slide(SlideDirection.UP);
                	numSlides++;
                    break;
                case KeyEvent.VK_DOWN:
                	game1024.slide(SlideDirection.DOWN);
                	numSlides++;
                    break;
                case KeyEvent.VK_LEFT:
                	game1024.slide(SlideDirection.LEFT);
                	numSlides++;
                    break;
                case KeyEvent.VK_RIGHT:
                	game1024.slide(SlideDirection.RIGHT);
                	numSlides++;
                    break;
                    }

            updateUI();

            if(game1024.checkWin())
            {
            	JOptionPane.showMessageDialog(null, "You Won");
            }

            /* TODO: check if the player can't move further, and ask whether she
                wants to play again?
            */
            if(game1024.checkLoss() || game1024.checkWin())
            {
            	int choice = JOptionPane.YES_NO_OPTION;
            	choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Replay?", JOptionPane.YES_NO_OPTION);
            	if(choice == JOptionPane.YES_OPTION)
            	{
            		game1024.reset();
                	updateUI();
            	}
            	else
            	{
            		System.exit(0);
            	}
            }
        }
        return true;
    }

    /*****************************************************************
	Assigns actions to the menu items quit, reset, and undo.
	@param e - ActionEvent
	@return none
	*****************************************************************/
    @Override
    public void actionPerformed (ActionEvent e)
    {
        Object which = e.getSource();
        
        if(which == quit)	
        {
        	System.exit(0);
        }
        else if(which == reset)
        {
        	game1024.reset();
        	gamesPlayed++;
        	updateUI();
        }
        else if(which == undo)
        {
        	game1024.undo();
        	updateUI();
        }
      }
}
