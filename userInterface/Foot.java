package userInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Foot extends JPanel {
	int width = 500;
	int height = 600;
	int menuHeight = 20;
	int panelWidth = 250;
	int panelHeight = height;
	int x = 20;
	int y = 30;
	int OWidth = 20;
	int OHeight = 20;
	
	public Foot(){
		
		// frame to hold all the stuff
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setResizable(true);
		Dimension d = new Dimension(width, height);
		
		// make a menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setSize(width, menuHeight);

		// panel to draw things and group objects
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout( panel, BoxLayout.Y_AXIS));
		panel.setVisible(true);
		panel.setSize(panelWidth, panelHeight);

		// change the frame's contentPane to the JPanel
		frame.setContentPane(panel);
		panel.setPreferredSize(d);
		
		// components to add to JFrame and JPanel
		JLabel optionMenu = new JLabel("Pressure Distribution Display");
		

		panel.add(optionMenu);
		/*panel.add(standing);
		panel.add(walking);
		panel.add(lateral);
		panel.add(lateral1);
		panel.add(lateral2);
		panel.add(lateral3);
		panel.add(lateral4);*/

		frame.pack();
		frame.setVisible(true);

	}
	
	// Override paintComponent(): 
	@Override
	  public void paint (Graphics g)
	  {
	    // Always call super.paintComponent (g): 
	    super.paint(g);
	    
	    // draw ovals to represent sensors
	    g.drawOval(x, y, OWidth, OHeight);
		g.setColor(Color.RED);
		g.fillOval(x, y, OWidth, OHeight);	    
	    /*g2d.drawOval(x, y, OWidth, OHeight);
	    g2d.drawOval(x, y, OWidth, OHeight);
	    g2d.drawOval(x, y, OWidth, OHeight);
	    g2d.drawOval(x, y, OWidth, OHeight);
	    g2d.drawOval(x, y, OWidth, OHeight);
	    g2d.drawOval(x, y, OWidth, OHeight);*/
	  }
	  
	  public static void main(String[] argv){
		  Foot foot = new Foot();
	  }
}
