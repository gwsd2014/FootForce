package userInterface;

import javax.swing.JFrame;  
import java.awt.Graphics;  
import java.awt.Color;  

public class Circles extends JFrame {
	int width = 500;
	int height = 600;
	int menuHeight = 20;
	int panelWidth = 250;
	int panelHeight = height;
	int x = 20;
	int y = 30;
	int OWidth = 20;
	int OHeight = 20;
	int topRow = 60;
	  
  
	public Circles()  
	{  
	 //Set JFrame title  
	 super("Draw A Circle In JFrame");  
	  
	 //Set default close operation for JFrame  
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	 //Set JFrame size  
	 setSize(width+100,height);
	 
	 // set background color
	 this.getContentPane().setBackground(Color.BLUE);
	  
	 //Make JFrame visible   
	 setVisible(true);  
	}  
	  
	public void paint(Graphics g)  
	{  
	 super.paint(g);  
	 
	 
	 g.setColor(Color.RED); 
	 //draw circle outline
	 g.drawOval( (width/5)*1, topRow+20, 30, 30);
	 g.fillOval( (width/5)*1, topRow+20, 30, 30);
	 
	 g.drawOval( (width/5)*2, topRow+10, 30, 30);
	 g.fillOval( (width/5)*2, topRow+10, 30, 30);  

	 g.drawOval( (width/5)*3, topRow, 30, 30);
	 g.fillOval( (width/5)*3, topRow, 30, 30);  

	 g.drawOval( (width/5)*4, topRow+10, 30, 30);
	 g.fillOval( (width/5)*4, topRow+10, 30, 30);

	 g.drawOval( (width/5)*5, topRow+20, 30, 30);
	 g.fillOval( (width/5)*5, topRow+20, 30, 30);
	 
	 g.drawOval( 400, height/2, 30, 30);
	 g.fillOval( 400, height/2, 30, 30);
	 
	 g.drawOval( (width/5)*3, (height/6)*5, 30, 30);
	 g.fillOval( (width/5)*3, (height/6)*5, 30, 30);

	 //set color to RED  
	 //So after this, if you draw anything, all of it's result will be RED  
	  
	  
	 //fill circle with RED  

	}  
	
	public static void main(String[]args)  
	{  
	 Circles circles=new Circles();  
	}  
	} 

