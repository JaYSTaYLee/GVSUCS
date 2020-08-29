import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class Drawing extends JPanel{
 public static void main(String[] a) {
 JFrame f = new JFrame();
 f.setContentPane(new Drawing());
 f.setSize(600, 400);
 f.setVisible(true);
 }
 public void paintComponent(Graphics g){
 // this statement required
 super.paintComponent(g);
 
 int x = 0;
 int y = 0;

 // Background Color
 setBackground(Color.WHITE);
 
 // Business Card Canvas
 g.setColor(Color.BLUE);
 g.fillRect(x + 25, y + 25, 500, 300);
 g.drawRect(x + 25, y + 25, 500, 300);
 
 // Company Information
 g.setColor(Color.black);
 // Change Font To Serif
 Font Font1 = new Font("serif", Font.BOLD, 30);
 g.setFont(Font1);
 g.drawString("Stahle Motor Company", x + 32, y + 50);
 // Change Font To Monospaced
 Font Font2 = new Font("monospaced", Font.PLAIN, 20);
 g.setFont(Font2);
 g.drawString("Phone: 616-123-4567", x + 31, y + 74);

 // Change Font To SanSerif
 Font Font3 = new Font("sansserif", Font.PLAIN, 20);
 g.setFont(Font3);
 g.drawString("Email: SMC@gmail.com", x + 31, y + 98);
 
 // Logo Background
 g.setColor(Color.CYAN);
 g.fillRect(x + 50, y + 150, 200, 160);

 // Red Circle
 g.setColor(Color.RED);
 g.fillOval(x + 50, y + 150, 100, 100);
 
 // Green Circle
 g.setColor(Color.GREEN);
 g.fillOval(x + 150, y + 150, 100, 100);
 
 // Yellow Oval
 g.setColor(Color.YELLOW);
 g.fillOval(x + 110, y + 210, 80, 100);
 
 g.setColor(Color.black);
 // Change Font To Serif
 g.drawString("S", x + 95, y + 205);
  
 g.setColor(Color.black);
 // Change Font To Serif
 g.drawString("M", x + 190, y + 205);
  
 g.setColor(Color.black);
 // Change Font To Serif
 g.drawString("C", x + 142, y + 265);
 
 // C Underline
 g.setColor(Color.BLACK);
 g.drawLine(x + 140, y + 270, x + 157, y + 270);
 
 // S Underline
 g.setColor(Color.BLACK);
 g.drawLine(x + 93, y + 210, x + 108, y + 210);

 // M Underline
 g.setColor(Color.BLACK);
 g.drawLine(x + 187, y + 210, x + 208, y + 210);
 
 // Company Liability Statement
 g.setColor(Color.black);
 // Change Font To Serif
 Font Font4 = new Font("sansserif", Font.BOLD, 20);
 g.setFont(Font4);
 g.drawString("WE ARE NOT", x + 280, y + 170);
 
 g.setColor(Color.black);
 // Change Font To Serif
 g.setFont(Font4);
 g.drawString("LIABLE", x + 330, y + 210);
 
 g.setColor(Color.black);
 // Change Font To Serif
 g.setFont(Font4);
 g.drawString("FOR ANY", x + 350, y + 250);
 
 g.setColor(Color.black);
 // Change Font To Serif
 g.setFont(Font4);
 g.drawString("ACCIDENTS!", x + 380, y + 290);
 
 // Business Photo
 BufferedImage photo = null;
try {
File file = new File("CobraJet.jpg");
photo = ImageIO.read(file);
} catch (IOException e){
g.drawString("Problem reading the file", 100, 100);
}
g.drawImage(photo, x + 350, y + 35, 165, 100, null);

}
}