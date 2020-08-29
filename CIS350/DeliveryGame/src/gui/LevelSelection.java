package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import main.Launcher;

/**
 * @author Joseph
 * @author Kyle
 */
public class LevelSelection extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**2D integer map representation for level 1.**/
	private int[][] level1 = {{0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 1, 4, 0, 4, 1, 4, 0, 1, 0, 0, 1, 0, 0, 1, 4, 0, 0, 1, 0},
			{0, 1, 0, 3, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 3, 0, 1, 4},
			{0, 1, 4, 0, 4, 1, 0, 0, 1, 0, 4, 1, 0, 0, 1, 0, 0, 4, 1, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 1, 4, 0, 0, 1, 4, 0, 0, 0, 0, 0, 0, 4, 1, 0, 0, 4, 1, 0},
			{0, 1, 0, 0, 0, 1, 0, 0, 3, 3, 3, 3, 0, 0, 1, 4, 0, 0, 1, 0},
			{4, 1, 4, 0, 0, 1, 0, 0, 3, 3, 3, 3, 0, 0, 1, 0, 0, 0, 1, 0},
			{0, 1, 2, 2, 2, 1, 0, 0, 3, 3, 3, 3, 0, 0, 1, 2, 2, 2, 1, 0},
			{0, 1, 0, 2, 0, 1, 0, 0, 3, 3, 3, 3, 0, 0, 1, 4, 2, 0, 1, 0},
			{0, 1, 0, 2, 0, 1, 0, 0, 3, 3, 3, 3, 0, 0, 1, 0, 2, 0, 1, 0},
			{0, 1, 4, 2, 0, 1, 4, 0, 4, 0, 0, 4, 0, 4, 1, 0, 2, 0, 1, 0},
			{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
			{0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0}, };
	
	/**2D integer map representation for level 2.**/
	private int[][] level2 = {{3, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4},
			{0, 1, 4, 0, 0, 1, 0, 0, 1, 0, 0, 1, 4, 0, 1, 0, 0, 0, 1, 0},
			{0, 1, 0, 3, 0, 1, 0, 4, 1, 0, 0, 1, 0, 0, 1, 0, 3, 0, 1, 3},
			{0, 1, 0, 0, 4, 1, 3, 0, 1, 4, 0, 1, 0, 4, 1, 0, 0, 0, 1, 3},
			{4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 1, 3, 1, 10, 1, 10, 4, 1, 10, 0, 0, 10, 0, 1, 4, 0, 4, 1, 0},
			{4, 1, 1, 1, 1, 1, 1, 0, 3, 3, 3, 3, 0, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 10, 1, 0, 1, 3, 4, 3, 3, 3, 3, 4, 3, 1, 0, 0, 0, 1, 0},
			{0, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 0},
			{0, 1, 0, 2, 10, 1, 4, 0, 3, 3, 3, 3, 0, 0, 1, 4, 2, 0, 1, 4},
			{4, 1, 10, 2, 0, 1, 10, 10, 3, 3, 3, 3, 0, 0, 1, 0, 2, 0, 1, 0},
			{0, 1, 0, 0, 0, 1, 0, 4, 3, 0, 0, 4, 0, 0, 1, 4, 2, 1, 1, 0},
			{0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
			{0, 0, 0, 4, 0, 10, 10, 0, 4, 0, 4, 0, 0, 0, 0, 0, 3, 0, 0, 0}, };
	
	/**2D integer map representation for level 3.**/
	private int[][] level3 = {{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3},
			{3, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 3, 3, 3},
			{3, 3, 3, 0, 1, 4, 4, 1, 4, 4, 4, 1, 0, 4, 4, 1, 0, 3, 3, 3},
			{3, 3, 3, 0, 1, 4, 4, 1, 4, 0, 0, 1, 4, 0, 4, 1, 0, 3, 3, 3},
			{3, 3, 3, 0, 1, 4, 4, 1, 4, 0, 4, 1, 4, 0, 4, 1, 0, 3, 3, 3},
			{3, 3, 3, 0, 1, 4, 4, 1, 4, 4, 4, 1, 4, 4, 4, 1, 0, 3, 3, 3},
			{3, 3, 3, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 3, 3, 3},
			{3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, };
	
	/**Play button.**/
	private JButton play;
	
	/**Window frame.**/
	private JFrame frame;
	
	/**Game launcher.**/
	private Launcher launcher = new Launcher();
	
	/**Levels label.**/
	private JLabel addLevels;
	
	/**Layout constraints.**/
	private GridBagConstraints layoutConst;

	/**Level list.**/
	private static String[] levelList = {"Map 1", "Map 2", "Map 3"};
	
	/**Level choose box.**/
	private JComboBox levels = new JComboBox(levelList);
	
	/**Constructor.**/
	public LevelSelection() {
		
		this.frame = new JFrame("Map Selection");
		this.frame.setLayout(new GridBagLayout());

		this.addLevels = new JLabel("Select a level: ");
		this.play = new JButton("Play");
		
	}

	/**Creates select level window.**/
	public void run() {

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		frame.add(addLevels, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		frame.add(levels, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		frame.add(play, layoutConst);

		frame.setVisible(true);
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		play.addActionListener(this);
		levels.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		
		if (event.getSource() == play) {
			
			String chosenLevel = (String) levels.getSelectedItem(); // stores user input

			// changes the level based on what the user chose
			switch (chosenLevel) {
			
				case "Map 1":
					
					launcher.run(level1);
					break;
					
				case "Map 2":
					
					launcher.run(level2);
					break;
					
				case "Map 3":
					
					launcher.run(level3);
					break;
					
				default:
					
			}
			
		}
		
	}
	
}

/**
 * BLANK INT MAP
 * int[][] map = {
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, }; 
 **/
