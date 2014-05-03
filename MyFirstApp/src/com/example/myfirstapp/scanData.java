package com.example.myfirstapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class scanData {
	
	public float [] sensor1 = new float[1000];
	public float [] sensor2 = new float[1000];
	public float [] sensor3 = new float[1000];
	public float [] sensor4 = new float[1000];
	public float [] sensor5 = new float[1000];
	public float [] sensor6 = new float[1000];
	public float [] sensor7 = new float[1000];

	public static float [] fullData;
	public float maxPressure = 0;
	
	/*----------------------------------------------------------------------------------------------------------------------------*/
	// Working
	public void createTestData(){
		try {
			// array that holds the data to be written to the file
			float[] array1 = new float[7000];
			
			// create the file we are writing to
			File file = new File("data/data/com.example.myfirstapp/testData.txt");
			
			
			
			// create the file if it doesn't already exist
			if ( !file.exists()){
				file.createNewFile();
			}
			
			// wrap a file writer in a buffered writer ( why do this? )
			FileWriter writer = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(writer);
			
			for ( int i = 0; i<array1.length; i++){
				array1[i] = i;
			}
			
			// write numbers in the array to the file
			for (int i = 0; i<array1.length; i++){
			bw.write(Float.toString(array1[i]));
			bw.newLine();
			}
			bw.flush();
			bw.close();
			
			System.out.println("wrote array to file");
			
			}catch (IOException e) {
				e.printStackTrace();
			}
	}
	/*-------------------------------------------------------------------------------------------------------------------------*/
	
	/*-------------------------------------------------------------------------------------------------------------------------*/
	// Working
	public static void main(String[] agrs) throws FileNotFoundException{
		
		// generate consistent data to test with for now
		scanData scan = new scanData();
		scan.createTestData();
		
		// Program gets Arduino data file
		File test=new File("testData.txt");
		
		// create a scanner, then call ScanIn to read in the file and store it in an array
		// create arrays to hold data from each sensor
		float[] b = scan.scanIn(test);
		
		// separate data from the one large array into arrays for each sensor
		int count = 0;
		for(int i=0; i<b.length; i+=7){
			scan.sensor1[count]=b[i]%7;
			//System.out.println(sensor1[count]);
			count++;

		}
		
		count = 0;
		for(int i=1; i<b.length; i+=7){
			scan.sensor2[count]=b[i]%7;
			count++;
		}
		
		count = 0;
		for(int i=2; i<b.length; i+=7){
			scan.sensor3[count]=b[i]%7;
			count++;
		}
		
		count = 0;
		for(int i=3; i<b.length; i+=7){
			scan.sensor4[count]=b[i]%7;
			count++;
		}
		
		count = 0;
		for(int i=4; i<b.length; i+=7){
			scan.sensor5[count]=b[i]%7;
			count++;
		}
		
		count = 0;
		for(int i=5; i<b.length; i+=7){
			scan.sensor6[count]=b[i]%7;
			count++;
		}
		
		count = 0;
		for(int i=6; i<b.length; i+=7){
			scan.sensor7[count]=b[i]%7;
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
		catch (IOException e) {
		e.printStackTrace();
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
		System.out.println("maxPressure: "+scan.maxPressure);
	}
	/*-------------------------------------------------------------------------------------------------------------------------*/

	/*-------------------------------------------------------------------------------------------------------------------------*/
	// Working
	public float[] scanIn(File file) throws FileNotFoundException{
		Scanner s  = new Scanner(file);
		fullData = new float[7000];
		for (int i=0; i<fullData.length-1; i++){
				fullData[i]=s.nextFloat();
				if ( fullData[i] > maxPressure){
					maxPressure = fullData[i];
				}
		}
		s.close();
		
		return fullData;
	}
	/*-------------------------------------------------------------------------------------------------------------------------*/

	/*-------------------------------------------------------------------------------------------------------------------------*/
	// Working
	public float[] retArray(int a){
		if ( a == 1){
			return sensor1;
		}
		else if ( a == 2 ){
			return sensor2;
		}
		else if ( a == 3 ){
			//System.out.println("I should be printing this: "+Arrays.toString(sensor3));
			return sensor3;
		}
		else if ( a == 4 ){
			return sensor4;
		}
		else if ( a == 5 ){
			return sensor5;
		}
		else if ( a == 6 ){
			return sensor6;
		}
		else if ( a == 7 ){
			return sensor7;
		}
		else {
			System.out.println("please enter a valid number between 1 and 7");
			return null;
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------*/

	/*-------------------------------------------------------------------------------------------------------------------------*/
	// Defunct for now
	/*public static int[] getter(){
		int[] sensArray = new int[sensor1.length];
		for ( int i = 0; i<sensor1.length; i++){
			sensor1[i] = i;
		}
		for ( int i = 0; i< sensor1.length; i++){
			sensArray[i]=sensor1[i];
		}
		//Arrays.toString(sensArray);
		return sensArray;
	}*/
	/*-------------------------------------------------------------------------------------------------------------------------*/

	
}
