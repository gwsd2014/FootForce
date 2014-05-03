package analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class RandomNumScanData {
	
	public static int [] sensor1;
	public static int [] sensor2;
	public static int [] fullData;
	
	public static void main(String[] agrs) throws FileNotFoundException{
		RandomNumbGenerator.generate();
		// Program gets Arduino data file
		File test=new File("randomNumbers.txt");
		
		
		/*Scanner scan= new Scanner(test);
		 while(scan.hasNextInt()){
			int a=scan.nextInt();
			//System.out.println(a);
		}
		scan.close();*/
		
		
		// create a scanner, then call ScanIn to read in the file and store it in an array
		// create arrays to hold data from each sensor
		scanData scanny=new scanData();
		int[] b=scanny.scanIn(test);
		int[] sensor1=new int[(b.length)/2];
		int[] sensor2=new int[(b.length)/2];
		System.out.println("sensor1 length is: "+ sensor1.length);
		System.out.println("sensor2 length is: "+ sensor2.length);
		//System.out.println(b.length-1);
		
		// separate data from the one large array into arrays for each sensor
		int count1=0;
		int count2=0;
		for(int i=0; i<b.length-1; i++){
			if(i%2==0){	
			sensor2[count2]=b[i];
			count2++;
			}
			else{
				sensor1[count1]=b[i];
				count1++;
			}
			
		}
		/*for(int i=1; i<sensor2.length-2; i++){
			sensor2[i]=b[i];
		}*/
		
		// print sensor 1 and sensor 2 values
		System.out.println("sensor 1 values");
		for(int i=0; i<sensor1.length; i++){
			System.out.println(sensor1[i]);

		}
		System.out.println("sensor 2 values");
		for(int i=0; i<sensor2.length; i++){
			System.out.println(sensor2[i]);

		}
	}
	
	public int[] scanIn(File file) throws FileNotFoundException{
		Scanner s=new Scanner(file);
		int[] fullData=new int[100];
		for (int i=0; i<fullData.length-1; i++){
				fullData[i]=s.nextInt();
				//System.out.println("i am now printing "+a[i][j]);
		}
		s.close();
		/*for(int i=0; i<a.length; i++){
		System.out.println(a[i][0]+" "+a[i][1]);
		}*/
		return fullData;
	}

	public static int[] getter(){
		int[] sensArray = new int[sensor1.length];
		for ( int i = 0; i< sensor1.length; i++){
			sensArray[i]=sensor1[i];
		}
		Arrays.toString(sensArray);
		return sensArray;
	}
	
}
