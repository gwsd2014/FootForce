package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.*;

import analysis.Analyze;
import analysis.scanData;

public class startScreen implements ActionListener {
	int width = 300;
	int height = 300;
	int menuHeight = 20;
	int panelWidth = 250;
	int panelHeight = height;
	Color color = Color.YELLOW;
	public startScreen(){
		
		// display start screen with basic instructions, fields to enter preferences,
		// and buttons to begin/ end data collection
		
		// frame to hold all the stuff
		JFrame frame = new JFrame("start screen");
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
		JLabel optionMenu = new JLabel("Select Movement Pattern for Analysis");
		JCheckBox standing = new JCheckBox("standing");
		standing.setBackground(color);

		JCheckBox walking = new JCheckBox("walking");
		walking.setBackground(color);

		JCheckBox lateral = new JCheckBox("lateral");
		lateral.setBackground(color);
		
		JCheckBox lateral1 = new JCheckBox("lateral1");
		lateral1.setBackground(color);

		JCheckBox lateral2 = new JCheckBox("lateral2");
		lateral2.setBackground(color);

		JCheckBox lateral3 = new JCheckBox("lateral3");
		lateral3.setBackground(color);

		JCheckBox lateral4 = new JCheckBox("lateral4");
		lateral4.setBackground(color);

		JButton b1 = new JButton("Start");
		b1.addActionListener(this);
		
		panel.setBackground(color);
		// add things to the panel
		panel.add(optionMenu);
		panel.add(standing);
		panel.add(walking);
		panel.add(lateral);
		panel.add(lateral1);
		panel.add(lateral2);
		panel.add(lateral3);
		panel.add(lateral4);
		panel.add(b1);
		
		frame.pack();
		frame.setVisible(true);

	}
	
	public static void main(String[] argv){
		startScreen a = new startScreen();
		
		while( true ){
			if( true ){
		}
	}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 Circles circles=new Circles();
		 Analyze a = new Analyze();
			scanData scan = new scanData();
			scan.createTestData();
			// Program gets Arduino data file
					File test=new File("testData.txt");
					
					// create a scanner, then call ScanIn to read in the file and store it in an array
					// create arrays to hold data from each sensor
					try {
						a.b = scan.scanIn(test);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					// separate data from the one large array into arrays for each sensor
					int count = 0;
					for(int i=0; i<a.b.length; i+=7){
						scan.sensor1[count]=a.b[i]%7;
						//System.out.println(sensor1[count]);
						count++;

					}
					
					count = 0;
					for(int i=1; i<a.b.length; i+=7){
						scan.sensor2[count]=a.b[i]%7;
						count++;
					}
					
					count = 0;
					for(int i=2; i<a.b.length; i+=7){
						scan.sensor3[count]=a.b[i]%7;
						count++;
					}
					
					count = 0;
					for(int i=3; i<a.b.length; i+=7){
						scan.sensor4[count]=a.b[i]%7;
						count++;
					}
					
					count = 0;
					for(int i=4; i<a.b.length; i+=7){
						scan.sensor5[count]=a.b[i]%7;
						count++;
					}
					
					count = 0;
					for(int i=5; i<a.b.length; i+=7){
						scan.sensor6[count]=a.b[i]%7;
						count++;
					}
					
					count = 0;
					for(int i=6; i<a.b.length; i+=7){
						scan.sensor7[count]=a.b[i]%7;
						count++;
					}
					
					try{
					// create the file we are writing to
					File file = new File("/Users/scarrick/Workspaces/Eclipse IDE for Java Developers 431/Senior Design/checkData.txt");


					// create the file if it doesn't already exist
					if ( !file.exists()){
						file.createNewFile();
					}

					// wrap a file writer in a buffered writer ( why do this? )
					FileWriter writer = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(writer);

					// write numbers in the array to the file
					for (int i = 0; i<scan.sensor1.length; i++){
						bw.write(Float.toString(scan.sensor1[i]));
						bw.newLine();
						bw.write(Float.toString(scan.sensor2[i]));
						bw.newLine();
						bw.write(Float.toString(scan.sensor3[i]));
						bw.newLine();
						bw.write(Float.toString(scan.sensor4[i]));
						bw.newLine();
						bw.write(Float.toString(scan.sensor5[i]));
						bw.newLine();
						bw.write(Float.toString(scan.sensor6[i]));
						bw.newLine();
						bw.write(Float.toString(scan.sensor7[i]));
						bw.newLine();
					}
					bw.flush();
					bw.close();

					System.out.println("wrote array to file");

				}
					catch (IOException e2) {
					e2.printStackTrace();
				}
					
					/*// print sensor 1 and sensor 2 values
					System.out.println("sensor 1 values");
					for(int i=0; i<sensor1.length; i++){
						System.out.println(sensor1[i]);

					}
					System.out.println("sensor 2 values");
					for(int i=0; i<sensor2.length; i++){
						System.out.println(sensor2[i]);

					}
					
					
					*/
			// look into whether or not this is a shallow or deep copy.
			// I do not want to be copy this much data if I don't have to.
			System.out.println("maxPressure: "+scan.maxPressure);
			a.Asens1 = scan.retArray(1);
			a.Asens2 = scan.retArray(2);
			a.Asens3 = scan.retArray(3);
			a.Asens4 = scan.retArray(4);
			a.Asens5 = scan.retArray(5);
			a.Asens6 = scan.retArray(6);
			a.Asens7 = scan.retArray(7);
			
			a.Asens1 = a.normalizePressure(a.Asens1);
			a.Asens2 = a.normalizePressure(a.Asens2);
			a.Asens3 = a.normalizePressure(a.Asens3);
			a.Asens4 = a.normalizePressure(a.Asens4);
			a.Asens5 = a.normalizePressure(a.Asens5);
			a.Asens6 = a.normalizePressure(a.Asens6);
			a.Asens7 = a.normalizePressure(a.Asens7);


			//System.out.println("Shazam! I'm printin dat shit out out!");
			System.out.println(Arrays.toString(a.Asens1));
			System.out.println(Arrays.toString(a.Asens2));
			System.out.println(Arrays.toString(a.Asens3));
			System.out.println(Arrays.toString(a.Asens4));
			System.out.println(Arrays.toString(a.Asens5));
			System.out.println(Arrays.toString(a.Asens6));
			System.out.println(Arrays.toString(a.Asens7));
		
	}

}
