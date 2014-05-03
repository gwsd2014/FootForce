package analysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Analyze {
	public static int arraySize = 1000;
	public int numSenors = 7;
	public static float[] RAsens1 = new float[arraySize];
	public static float[] RAsens2 = new float[arraySize];
	public static float[] RAsens3 = new float[arraySize];
	public static float[] RAsens4 = new float[arraySize];
	public static float[] RAsens5 = new float[arraySize];
	public static float[] RAsens6 = new float[arraySize];
	public static float[] RAsens7 = new float[arraySize];
	public static float[] LAsens1 = new float[arraySize];
	public static float[] LAsens2 = new float[arraySize];
	public static float[] LAsens3 = new float[arraySize];
	public static float[] LAsens4 = new float[arraySize];
	public static float[] LAsens5 = new float[arraySize];
	public static float[] LAsens6 = new float[arraySize];
	public static float[] LAsens7 = new float[arraySize];
	public static float[] b;
	public float[] leftAvg = new float[numSenors];
	public float[] rightAvg = new float[numSenors];

	
	public static void main(String[] args){
		
		Analyze a = new Analyze();
		scanData scan = new scanData();
		LRComp comp = new LRComp();
		scan.createTestData();
		// Program gets Arduino data file
				File test=new File("testData.txt");
				
				// 1. put all values from the file in array b
				// 2. separate the values into arrays for each sensor
				// 3.
				try {
					b = scan.scanIn(test);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// separate data from the one large array into arrays for each sensor
				
				/*
					scan.sensor1 = a.separateSensVals(b, 1);
					scan.sensor1 = a.separateSensVals(b, 2);
					scan.sensor1 = a.separateSensVals(b, 3);
					scan.sensor1 = a.separateSensVals(b, 4);
					scan.sensor1 = a.separateSensVals(b, 5);
					scan.sensor1 = a.separateSensVals(b, 6);
					scan.sensor1 = a.separateSensVals(b, 7);

					System.out.println("checking sensor values");
					System.out.println(scan.sensor1[0]);
					System.out.println(scan.sensor2[0]);
					System.out.println(scan.sensor3[0]);
					System.out.println(scan.sensor4[0]);
					System.out.println(scan.sensor5[0]);
					System.out.println(scan.sensor6[0]);
					System.out.println(scan.sensor7[0]);

				*/
				
				int count = 0;
				
				count = 0;
				for(int i=0; i<b.length; i+=7){
					scan.sensor1[count]=b[i]%7;
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
		// look into whether or not this is a shallow or deep copy.
		// I do not want to be copy this much data if I don't have to.
		System.out.println("maxPressure: "+scan.maxPressure);
		RAsens1 = scan.retArray(1);
		RAsens2 = scan.retArray(2);
		RAsens3 = scan.retArray(3);
		RAsens4 = scan.retArray(4);
		RAsens5 = scan.retArray(5);
		RAsens6 = scan.retArray(6);
		RAsens7 = scan.retArray(7);
		
		LAsens1 = scan.retArray(1);
		LAsens2 = scan.retArray(2);
		LAsens3 = scan.retArray(3);
		LAsens4 = scan.retArray(4);
		LAsens5 = scan.retArray(5);
		LAsens6 = scan.retArray(6);
		LAsens7 = scan.retArray(7);
		
		RAsens1 = a.normalizePressure(RAsens1);
		RAsens2 = a.normalizePressure(RAsens2);
		RAsens3 = a.normalizePressure(RAsens3);
		RAsens4 = a.normalizePressure(RAsens4);
		RAsens5 = a.normalizePressure(RAsens5);
		RAsens6 = a.normalizePressure(RAsens6);
		RAsens7 = a.normalizePressure(RAsens7);

		LAsens1 = a.normalizePressure(LAsens1);
		LAsens2 = a.normalizePressure(LAsens2);
		LAsens3 = a.normalizePressure(LAsens3);
		LAsens4 = a.normalizePressure(LAsens4);
		LAsens5 = a.normalizePressure(LAsens5);
		LAsens6 = a.normalizePressure(LAsens6);
		LAsens7 = a.normalizePressure(LAsens7);

		//System.out.println("Shazam! I'm printin dat shit out out!");
		
		System.out.println("Right foot Asens values for arrays 1-7");
		System.out.println(Arrays.toString(RAsens1));
		System.out.println(Arrays.toString(RAsens2));
		System.out.println(Arrays.toString(RAsens3));
		System.out.println(Arrays.toString(RAsens4));
		System.out.println(Arrays.toString(RAsens5));
		System.out.println(Arrays.toString(RAsens6));
		System.out.println(Arrays.toString(RAsens7));
		
		a.rightAvg[0] = comp.average(RAsens1);
		a.rightAvg[1] = comp.average(RAsens2);
		a.rightAvg[2] = comp.average(RAsens3);
		a.rightAvg[3] = comp.average(RAsens4);
		a.rightAvg[4] = comp.average(RAsens5);
		a.rightAvg[5] = comp.average(RAsens6);
		a.rightAvg[6] = comp.average(RAsens7);
		System.out.println("right foot average sensor values "+Arrays.toString(a.rightAvg));
		
		a.leftAvg[0] = comp.average(LAsens1);
		a.leftAvg[1] = comp.average(LAsens2);
		a.leftAvg[2] = comp.average(LAsens3);
		a.leftAvg[3] = comp.average(LAsens4);
		a.leftAvg[4] = comp.average(LAsens5);
		a.leftAvg[5] = comp.average(LAsens6);
		a.leftAvg[6] = comp.average(LAsens7);
		System.out.println("left foot average sensor values "+Arrays.toString(a.leftAvg));
		
		float[] abc = comp.standingComp(a.rightAvg, a.leftAvg);
		System.out.println("Percent differences between pressure at corresponding nodes on the left and right feet " + Arrays.toString(abc));
		comp.LRFD(a.rightAvg, a.leftAvg);
		comp.abnormalStand(a.rightAvg, "right");
		comp.abnormalStand(a.leftAvg, "left");
		
		System.out.println("");


		/*for ( int i = 0; i<RAsens1.length; i++){
			if ( RAsens1[i] == 1 ){
				

			}

			if ( RAsens2[i] == 1 ){

			}
			if ( RAsens3[i] == 1 ){

			}
			if ( RAsens4[i] == 1 ){

			}
			if ( RAsens5[i] == 1 ){

			}
			if ( RAsens6[i] == 1 ){

			}
			if ( RAsens7[i] == 1 ){

			}

		}*/
		
	
	}
	
	public float[] separateSensVals(float[] sensVals, int start){
		float[] temp = new float[arraySize];
		int count = 0;
		for(int i=start; i<b.length; i+=7){
			temp[count]=b[i]%7;
			count++;

		}
		System.out.println(Arrays.toString(temp));
		return temp;
	}
	
	public float[] normalizePressure(float[] pVals){
		for ( int i = 0; i<RAsens1.length; i++ ){
			pVals[i] = pVals[i]/6;
		}
		return pVals;
	}
	
	public int[][] analysesResults( int[][] someData ){
		int[][] a = new int[0][0];
		
		// calculate to find highest and lowest pressure for the trial
		// calculate averages over desired time step for use with pressureMap
		// function
		return a;
	}
	
	
	
	public void pressureMap( int[] array ){
		// call class that generates windows for my application
		// create foot image and map pressures to corresponding locations
		// based on their pressure relative to established norms
		
		for ( int i = 0; i<array.length; i++ ){
		}
	}
}
