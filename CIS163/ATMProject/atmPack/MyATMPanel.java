package atmPack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyATMPanel extends JPanel 
{
	 private ATM ATM1;
	 private ATM ATM2;
	 private ATM ATM3;
	 private JButton addATM1;
	 private JButton addATM2;
	 private JButton addATM3;
	 private JButton subATM1;
	 private JButton subATM2;
	 private JButton subATM3;
	 private JButton suspendATM;
	 private JLabel amtHundredsATM1;
	 private JLabel amtFiftiesATM1;
	 private JLabel amtTwentiesATM1;
	 private JLabel amtHundredsATM2;
	 private JLabel amtFiftiesATM2;
	 private JLabel amtTwentiesATM2;
	 private JLabel amtHundredsATM3;
	 private JLabel amtFiftiesATM3;
	 private JLabel amtTwentiesATM3;
	 
	 public MyATMPanel()
	 {
		 addATM1 = new JButton("Add ATM 1");
		 addATM2 = new JButton("Add ATM 2");
		 addATM3 = new JButton("Add ATM 3");
		 subATM1 = new JButton("Add ATM 1");
		 subATM2 = new JButton("Add ATM 2");
		 subATM3 = new JButton("Add ATM 3");
		 suspendATM = new JButton("Suspend ATM's");
		 amtHundredsATM1 = new JLabel("ATM 1 Hundreds: " + ATM1.getHundreds());
		 amtFiftiesATM1 = new JLabel("ATM 1 Fifties: " + ATM1.getFifties());
		 amtTwentiesATM1 = new JLabel("ATM 1 Twenties: " + ATM1.getTwenties());
		 amtHundredsATM2 = new JLabel("ATM 2 Hundreds: " + ATM2.getHundreds());
		 amtFiftiesATM2 = new JLabel("ATM 2 Fifties: " + ATM2.getFifties());
		 amtTwentiesATM2 = new JLabel("ATM 2 Twenties: " + ATM2.getTwenties());
		 amtHundredsATM3 = new JLabel("ATM 3 Hundreds: " + ATM3.getHundreds());
		 amtFiftiesATM3 = new JLabel("ATM 3 Fifties: " + ATM3.getFifties());
		 amtTwentiesATM3 = new JLabel("ATM 3 Twenties: " + ATM3.getTwenties());
		 add(addATM1);
		 add(addATM2);
		 add(addATM3);
		 add(subATM1);
		 add(subATM2);
		 add(subATM3);
		 add(suspendATM);
		 add(amtHundredsATM1);
		 add(amtFiftiesATM1);
		 add(amtTwentiesATM1);
		 add(amtHundredsATM2);
		 add(amtFiftiesATM2);
		 add(amtTwentiesATM2);
		 add(amtHundredsATM3);
		 add(amtFiftiesATM3);
		 add(amtTwentiesATM3);
		 
		 setBackground(Color.cyan);
		 setPreferredSize(new Dimension(300,300));
	 }

	 public MyTimerPanel()
	 {
		 ATM1 = new ATM(1,2,3);
		 ATM2 = new ATM(4,5,6);
		 ATM3 = new ATM(7,8,9);
		 return null;
	 }
	 private class TimerListener implements ActionListener()
	 {
	 }
		 public void actionPerformed(ActionEvent e)
		 {
			 
		 }
	 
}