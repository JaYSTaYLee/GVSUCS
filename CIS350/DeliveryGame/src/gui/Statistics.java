package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Joseph
 * @author Kyle
 */
public class Statistics {
	
	/**Statistics window.**/
	private JFrame frame;
	
	/**Label for latest delivery.**/
    private JLabel latestDeliveryLabel; 
	
	/**Label for customer name.**/
    private JLabel customerNameLabel; 
    
    /**Text field that displays a customer name.**/
    private JTextField customerNameTextField;
    
    /**Label for customer packages.**/
    private JLabel customerPackagesLabel;
    
    /**Text field that displays customer packages.**/
    private JTextField customerPackagesTextField;
    
    /**Label to divide.**/
    private JLabel dividerLabel;
    
    /**Label for total packages delivered.**/
    private JLabel totalPackagesDeliveredLabel;
    
    /**Text field that displays total packages delivered.**/
    private JTextField totalPackagesDeliveredTextField;
    
    /**Label for delivery log.**/
    private JLabel deliveryLogLabel;
    
    /**Text area to display delivery logs.**/
    private JTextArea deliveryLogTextArea;
    
    /**Layout constraint.**/
	private GridBagConstraints layoutConst;

	/*****************************************************************
    Constructor.
    *****************************************************************/
	public Statistics() {
		
		this.frame = new JFrame("Statistics");
		this.frame.setLayout(new GridBagLayout());
		
		this.latestDeliveryLabel = new JLabel("Latest Delivery Information");
		
		this.customerNameLabel = new JLabel("Customer Name:");
		this.customerNameTextField = new JTextField();
		
	    this.customerPackagesLabel = new JLabel("Customer Packages:");
	    this.customerPackagesTextField = new JTextField();
	    
	    this.dividerLabel = new JLabel("---------------------");
	    
	  	this.totalPackagesDeliveredLabel = new JLabel("Total Packages Delivered:");
	    this.totalPackagesDeliveredTextField = new JTextField();
	    
	    this.deliveryLogLabel = new JLabel("Delivery Log");
	    this.deliveryLogTextArea = new JTextArea(10, 20);

	}
	
	/*****************************************************************
    Creates and runs the statistics window.
    *****************************************************************/
	public void run() {
		
		//Customer name Label
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
	    layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
	    frame.add(latestDeliveryLabel, layoutConst);
		
		//Customer name Label
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
	    layoutConst.gridy = 1;
	    layoutConst.insets = new Insets(10, 10, 10, 10);
		frame.add(customerNameLabel, layoutConst);

		//Customer name Text Field
		customerNameTextField.setEditable(false);
		layoutConst = new GridBagConstraints();
	    layoutConst.gridx = 1;
	    layoutConst.gridy = 1;
	    layoutConst.insets = new Insets(10, 10, 10, 10);
	    frame.add(customerNameTextField, layoutConst);
	    
	    //Customer packages Label
	  	layoutConst = new GridBagConstraints();
	  	layoutConst.gridx = 0;
	  	layoutConst.gridy = 2;
	  	layoutConst.insets = new Insets(10, 10, 10, 10);
	    frame.add(customerPackagesLabel, layoutConst);
	    
	    //Customer packages Text Field
	  	customerPackagesTextField.setEditable(false);
	  	layoutConst = new GridBagConstraints();
	  	layoutConst.gridx = 1;
	  	layoutConst.gridy = 2;
	  	layoutConst.insets = new Insets(10, 10, 10, 10);
	  	frame.add(customerPackagesTextField, layoutConst);
	  	
	    //Divider label
	  	layoutConst = new GridBagConstraints();
	  	layoutConst.gridx = 0;
	  	layoutConst.gridy = 3;
	  	layoutConst.insets = new Insets(10, 10, 10, 10);
	  	frame.add(dividerLabel, layoutConst);
	  	
	  	//Total packages delivered Label
	  	layoutConst = new GridBagConstraints();
	  	layoutConst.gridx = 0;
	  	layoutConst.gridy = 4;
	  	layoutConst.insets = new Insets(10, 10, 10, 10);
	    frame.add(totalPackagesDeliveredLabel, layoutConst);
	    
	    //Total packages delivered Text Field
	  	totalPackagesDeliveredTextField.setEditable(false);
	  	layoutConst = new GridBagConstraints();
	  	layoutConst.gridx = 1;
	  	layoutConst.gridy = 4;
	  	layoutConst.insets = new Insets(10, 10, 10, 10);
	  	frame.add(totalPackagesDeliveredTextField, layoutConst);
	  	
	  	layoutConst = new GridBagConstraints();
	  	layoutConst.gridx = 0;
	  	layoutConst.gridy = 5;
	  	layoutConst.insets = new Insets(10, 10, 10, 10);
	    frame.add(deliveryLogLabel, layoutConst);
	    
	    deliveryLogTextArea.setEditable(false);
	    layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 10, 1, 10);
	    layoutConst.fill = GridBagConstraints.HORIZONTAL;
	    layoutConst.gridx = 0;
	    layoutConst.gridy = 6;
	    frame.add(deliveryLogTextArea, layoutConst);
	  	
	  	customerNameTextField.setText("                         ");
	    customerPackagesTextField.setText("                         ");
	    totalPackagesDeliveredTextField.setText("                         ");
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
		
	}
	
	/*****************************************************************
    Updates the statistics.
    @param customerName - customer name
    @param customerPackages - customer packages
    @param totalPackagesDelivered - total packages delivered
    *****************************************************************/
	public void updateStatistics(final char customerName, final int customerPackages, final int totalPackagesDelivered) {
		
	    customerNameTextField.setText(Character.toString(customerName));
	    customerPackagesTextField.setText(Integer.toString(customerPackages));
	    totalPackagesDeliveredTextField.setText(Integer.toString(totalPackagesDelivered));
	    deliveryLogTextArea.append("Delivered " + customerPackages + " to customer " + customerName + "\n");
		
	}
	
}
