import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener
{
	int numSecToNextPerson;
	int numAvgSecPerCashier;
	int numTotalTime;
	int numAvgSecPerEatery;
	int numSecBeforePersonLeaves;
	int numNumEateries;
	
	 /** the game that keeps track of everything */
	PersonProducer pp;

    /** JLabels */
    JLabel inputInformation;
    JLabel secToNextPerson;
    JLabel avgSecPerCashier;
    JLabel totalTime;
    JLabel avgSecPerEatery;
    JLabel secBeforePersonLeaves;
    JLabel numEateries;
    JLabel outputInformation;
    JLabel throughput;
    JLabel avgTimeStartFinish;
    JLabel numPeopleLeftInLine;
    JLabel maxQLengthCashierLine;


    /** Buttons */
    JButton startSimulation;
    JButton quitSimulation;
    
    /** JTextFields */
    JTextField inputInformationText;
    JTextField secToNextPersonText;
    JTextField avgSecPerCashierText;
    JTextField totalTimeText;
    JTextField avgSecPerEateryText;
    JTextField secBeforePersonLeavesText;
    JTextField numEateriesText;
    
    public GUI()
    {  
    	//Integers
    	numSecToNextPerson = 0;
    	numAvgSecPerCashier = 0;
    	numTotalTime = 0;
    	numAvgSecPerEatery = 0;
    	numSecBeforePersonLeaves = 0;
    	numNumEateries = 0;
   
        //pp = new PersonProducer(numNumEateries, numSecToNextPerson, numAvgSecPerEatery, numSecBeforePersonLeaves, numAvgSecPerCashier);
    	
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();

        //Labels
        inputInformation = new JLabel("Input Information");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 0;
        add(inputInformation, position);
        
        secToNextPerson = new JLabel("Seconds Until Next Person");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 1;
        add(secToNextPerson, position);
        
        avgSecPerCashier = new JLabel("Average Seconds Per Cashier");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 2;
        add(avgSecPerCashier, position);
        
        totalTime = new JLabel("Total Time In Seconds");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 3;
        add(totalTime, position);
        
        avgSecPerEatery = new JLabel("Average Seconds Per Eatery");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 4;
        add(avgSecPerEatery, position);
        
        secBeforePersonLeaves = new JLabel("Seconds Before Person Leaves");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 5;
        add(secBeforePersonLeaves, position);
        
        numEateries = new JLabel("Number Of Eateries");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 6;
        add(numEateries, position);
        
        outputInformation = new JLabel("Output Information");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 10;
        add(outputInformation, position);
        
        throughput = new JLabel("Throughput:");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 11;
        add(throughput, position);
        
        avgTimeStartFinish = new JLabel("Average Time For A Person From Start To Finish:");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 12;
        add(avgTimeStartFinish, position);
        
        numPeopleLeftInLine = new JLabel("Number Of People Left In Line:");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 13;
        add(numPeopleLeftInLine, position);
        
        maxQLengthCashierLine = new JLabel("Max Q Length Cashier Line:");
        position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 14;
        add(maxQLengthCashierLine, position);
        
        //Buttons
        startSimulation = new JButton("Start Simulation");
        position.gridx = 2;
        position.gridy = 8;
        add(startSimulation, position);
        startSimulation.addActionListener(this); 

        quitSimulation = new JButton("Quit Simulation");
        position.gridx = 4;
        position.gridy = 8;
        add(quitSimulation, position);
        quitSimulation.addActionListener(this);
        
        //Text Fields     
        secToNextPersonText = new JTextField(20);
        position = new GridBagConstraints();
        position.gridx = 2;
        position.gridy = 1;   
        add(secToNextPersonText, position);
        
        avgSecPerCashierText = new JTextField(20);
        position = new GridBagConstraints();
        position.gridx = 2;
        position.gridy = 2;   
        add(avgSecPerCashierText, position);
        
        totalTimeText = new JTextField(20);
        position = new GridBagConstraints();
        position.gridx = 2;
        position.gridy = 3;   
        add(totalTimeText, position);
        
        avgSecPerEateryText = new JTextField(20);
        position = new GridBagConstraints();
        position.gridx = 2;
        position.gridy = 4;   
        add(avgSecPerEateryText, position);
        
        secBeforePersonLeavesText = new JTextField(20);
        position = new GridBagConstraints();
        position.gridx = 2;
        position.gridy = 5;   
        add(secBeforePersonLeavesText, position);
        
        numEateriesText = new JTextField(20);
        position = new GridBagConstraints();
        position.gridx = 2;
        position.gridy = 6;   
        add(numEateriesText, position);
    }  

	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource() == startSimulation)
		{
			numSecToNextPerson = Integer.parseInt(secToNextPersonText.getText());
			numAvgSecPerCashier = Integer.parseInt(avgSecPerCashierText.getText());
			numTotalTime = Integer.parseInt(totalTimeText.getText());
			numAvgSecPerEatery = Integer.parseInt(avgSecPerEateryText.getText());
			numSecBeforePersonLeaves = Integer.parseInt(secBeforePersonLeavesText.getText());
			numNumEateries = Integer.parseInt(numEateriesText.getText());
			
			pp = new PersonProducer(numNumEateries, numSecToNextPerson, numAvgSecPerEatery, numSecBeforePersonLeaves, numAvgSecPerCashier);
			
			 Clock clk = new Clock();
			 clk.add(pp);
			 //add all of the Eateries, which are stored in the PersonProducer object, pp
			 for (int x = 0; x < pp.getEateries().size(); x++)
			 {
			   clk.add(pp.getEateries().get(x));
			 }
			 //now add the two cashiers to the clock
			 clk.add(Eatery.getCashier1());
			 clk.add(Eatery.getCashier2());
			 clk.run(numTotalTime);
			 
			 throughput.setText("Throughput:  " + Simulator.getThroughputTotals(pp));
			 avgTimeStartFinish.setText("Average Time For A Person From Start To Finish:  " + Eatery.getAverageCustomerTime());
			 numPeopleLeftInLine.setText("Number Of People Left In Line:  " + Simulator.getPeopleLeftInQueues(pp));
			 maxQLengthCashierLine.setText("Max Q Length Cashier Line:  " + Eatery.getMaxCashierQ());
		}
		
		if(e.getSource() == quitSimulation)
		{
			System.exit(0);
		}
		
	}
	
	public static void main(String [] args)
	{
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Food Court Simulation");
        gui.pack();
        gui.setVisible(true);
    }
}
