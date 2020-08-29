/**
 * 
 */
package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Joseph
 * @author Kyle
 */
public class MainMenu extends JFrame implements ActionListener {
	
	/****/
	private static final long serialVersionUID = 1L;
	
	/**Level selection.**/
	private LevelSelection levelSelection;
	
	/**Main Menu window.**/
	private JFrame frame;
	
	/**Button to play game.**/
    private JButton playGameButton;
    
    /**Button to exit main menu.**/
    private JButton exitButton;
    
    /**Layout constraints.**/
	private GridBagConstraints layoutConst;

	/*****************************************************************
    Constructor.
    *****************************************************************/
	public MainMenu() {
		
		this.levelSelection = new LevelSelection();
		
		//Window frame
		this.frame = new JFrame("Main Menu");
		this.frame.setLayout(new GridBagLayout());
		
		//JButtons
		this.playGameButton = new JButton("Play Game");
		this.exitButton = new JButton("Exit");
	    
	}
	
	@Override
	public void actionPerformed(final ActionEvent event) {
		
		if (event.getSource() == playGameButton) {
			
			levelSelection.run(); 
			frame.setVisible(false);
			frame.dispose();
			
		} else if (event.getSource() == exitButton) {
			
			frame.setVisible(false);
			frame.dispose();
			
		}
				
	}
	
	/*****************************************************************
    Creates and runs main menu.
    *****************************************************************/
	public void run() {
		
		playGameButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		setLayout(new GridBagLayout());
		layoutConst = new GridBagConstraints();
		
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		
		layoutConst.insets = new Insets(10, 10, 10, 10);
		
		layoutConst.gridx = 5;
		layoutConst.gridy = 2;
		layoutConst.insets = new Insets(10, 10, 10, 10);
	    frame.add(playGameButton, layoutConst);
	    
	    layoutConst.gridx = 5;
		layoutConst.gridy = 6;
		layoutConst.insets = new Insets(10, 10, 10, 10);
	    frame.add(exitButton, layoutConst);
	    
	    frame.setSize(300, 300);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
		
	}

}
