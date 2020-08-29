import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
/**********************************************************
GUI for a critter simulation.  Impements Runnable to allow
a method to run in the background while the user continues
to click on buttons.

@author Scott Grissom
@version August 2016
 ***********************************************************/
public class CritterGUI extends JFrame implements ActionListener, Runnable{

    /** simulation speed */
    private final int DELAY = 50;

    /** is simulation currently runnning? */
    private boolean isRunning;  

    /** the simulation object that controls everything */
    private Simulation world; 

    /** displays updated statistics */
    JTextArea statsArea;

    // FIX ME: define buttons as neeeded
    JButton ants; 
    JButton birds;
    JButton hippos;
    JButton vultures;
    JButton lakers;
    JButton start;
    JButton stop;

    // FIX ME: define menu items as needed
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem clear;
    JMenuItem quit;

    /************************************************************
    Main method displays the simulation GUI
     ************************************************************/
    public static void main(String arg[]){
        CritterGUI gui = new CritterGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Critter Simulation");
        gui.setSize(600,600);
        gui.pack();
        gui.setVisible(true);
    }

    /************************************************************
    Create the GUI
     ************************************************************/
    public CritterGUI(){

        // simulation is turned off 
        isRunning = false;

        // create the lay out
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();

        // Place the simulation on the screen
        position.gridx = 0;
        position.gridy = 1;
        position.gridwidth = 6;           
        world = new Simulation();
        add(world, position);

        // Place a label
        position.gridx = 6;
        position.gridy = 0;  
        add(new JLabel("Live Stats"),position);

        // Place stats area below the label
        statsArea = new JTextArea(7,12);
        statsArea.setBackground(Color.YELLOW);
        position.gridx = 6;
        position.gridy = 1;    
        position.anchor = GridBagConstraints.PAGE_START;
        add(statsArea, position);  
        statsArea.setText(world.getStats());

        // FIX ME: place each button
        ants = new JButton( "Ants" );
        ants.setForeground(Color.RED);
        position.gridx = 0;
        position.gridy = 2;
        position.gridwidth = 1;
        add(ants, position);

        birds = new JButton( "Birds" );
        birds.setForeground(Color.BLUE);
        position.gridx = 1;
        position.gridy = 2;   
        position.gridwidth = 1;
        add(birds, position);

        vultures = new JButton( "Vultures" );
        vultures.setForeground(Color.BLACK);
        position.gridx = 2;
        position.gridy = 2;  
        position.gridwidth = 1;
        add(vultures, position);

        hippos = new JButton( "Hippos" );
        hippos.setForeground(Color.GRAY);
        position.gridx = 3;
        position.gridy = 2;   
        position.gridwidth = 1;
        add(hippos, position);

        lakers = new JButton( "Lakers" );
        lakers.setForeground(Color.GREEN);
        position.gridx = 4;
        position.gridy = 2;   
        position.gridwidth = 1;
        add(lakers, position);

        start = new JButton( "Start" );
        position.gridx = 1;
        position.gridy = 0;   
        position.gridwidth = 1;
        add(start, position);

        stop = new JButton( "Stop" );
        position.gridx = 2;
        position.gridy = 0;   
        position.gridwidth = 1;
        add(stop, position);

        // FIX ME: add action listeners for each button
        ants.addActionListener(this);
        birds.addActionListener(this);
        vultures.addActionListener(this);
        hippos.addActionListener(this);
        lakers.addActionListener(this);
        start.addActionListener(this);
        stop.addActionListener(this);

        setupMenus();

        // Advanced topic! this must be at the end of this method
        // start the simulation in separate thread
        new Thread(this).start();
    }

    /************************************************************
    Respond to button clicks
    @param e action even triggered by user
     ************************************************************/
    public void actionPerformed(ActionEvent e){

        // FIX ME: exit application if QUIT menu item
        // menu item - quit
        if (e.getSource() == quit){
            System.exit(1);
        }

        // FIX ME: set running variable to true if START button
        if (e.getSource() == start){
            isRunning = true;
        }

        // FIX ME: set running variable to false if STOP button
        if (e.getSource() == stop){
            isRunning = false;
        }

        // FIX ME: reset simulation if CLEAR menu item
        if (e.getSource() == clear){
            world.reset();
        }

        //inject 10 ants if ANTS button
        if(e.getSource() == ants){ 
            world.addAnts(10);
        }

        //FIX ME: inject 10 species for each button

        //inject 10 birds if bird button
        if(e.getSource() == birds){ 
            world.addBirds(10);
        }

        //inject 10 vultures if vulture button
        if(e.getSource() == vultures){ 
            world.addVultures(10);
        }

        //inject 10 hippos if hippo button
        if(e.getSource() == hippos){ 
            world.addHippos(10);
        }

        //inject 10 lakers if leker button
        if(e.getSource() == lakers){ 
            world.addLakers(10);
        }

        // Afterwards, update display and statistics
        world.repaint();
        statsArea.setText(world.getStats());
    }

    /************************************************************
    Once started, this method runs forever in a separate thread
    The simulation only advances and displays if the boolean
    variable is currently true
     ************************************************************/
    public void run(){
        try {

            // run forever
            while(true) {

                // only update simulation if it is running
                if (isRunning) {
                    world.oneStep();
                    statsArea.setText(world.getStats());
                }

                // pause between steps.  Otherwise, the simulation
                // would move too quickly to see
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException ex) {
        }
    }    

    /*********************************************************************
    Set up the menu items
     *********************************************************************/
    private void setupMenus()
    {
        // create menu components
        fileMenu = new JMenu("File");
        clear = new JMenuItem("Clear");
        quit = new JMenuItem("Quit");

        // assign action listeners
        quit.addActionListener(this);
        clear.addActionListener(this);

        // display menu components
        fileMenu.add(clear);
        fileMenu.add(quit);   
        menus = new JMenuBar();

        menus.add(fileMenu);
        setJMenuBar(menus);
    }         
}