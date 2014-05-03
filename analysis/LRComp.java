package analysis;

import java.util.Arrays;

public class LRComp {
	
	int numSens = 7;
	
	// calculate the percent differences between analogous nodes on the left and right foot
	public float[] standingComp(float[] right, float[] left){
		
		float temp;
		float[] percentDiffs = new float[numSens];
		for (int i=0; i<percentDiffs.length; i++){
			temp = right[i] - left[numSens-i-1];
			temp = (temp/((right[i] + left[numSens-i-1])/2)) * 100;
			percentDiffs[i] = temp;
		}
		
		return percentDiffs;
		
	}
	
	// pressure percent differences between individual nodes
	public float pDiffs(float a, float b){
		float temp;
		float pDiffs = 0;
		temp = a - b;
		temp = (temp/((a + b)/2)) * 100;
		return temp;
	}
	
	// LRFD stands for Left-Right Force Distribution
	// it compares the total pressure on each foot to see if one side is bearing more weight than the other
	public void LRFD(float[] right, float[] left){
		
		System.out.println();
		float LRdiff = (float) 0;
		float[] totalPressures = new float[2];
		//System.out.println(Arrays.toString(right));
		for(int i=0; i<numSens; i++){
			//System.out.println(i);
			totalPressures[0] = totalPressures[0] + right[i];
			totalPressures[1] = totalPressures[1] + left[i];
		}
		totalPressures[0] = totalPressures[0] / numSens;
		totalPressures[1] = totalPressures[1] / numSens;
		LRdiff = totalPressures[0] - totalPressures[1];
		
		System.out.println("Pressure difference between the left and right foot: " + LRdiff);
		
	}
	
	// evaluate pressure differences between nodes on the same foot
	public void abnormalStand(float[] array, String foot){
		
		System.out.println();
		boolean probs = false;
		// float[][] compareNodes = new float[numSens][numSens];
		if(foot.equals("right")){
			for(int i=0; i<array.length; i++){
				for(int j=0; j<array.length; j++)
					if((i != 5 && j != 5) && pDiffs(array[i], array[j]) > 10){
						System.out.println("Abnormal pressure detected between nodes " + i + " " + j +" the difference detected is " + pDiffs(array[i], array[j]));
						probs = true;
					if((i == 5 || j == 5) && pDiffs(array[i], array[j]) > 20){
						System.out.println("Abnormal pressure detected between nodes " + i + " " + j +" the difference detected is " + pDiffs(array[i], array[j]));
						probs = true;
					}
					}

			}
		}
		
		else if (foot.equals("left")){
			for(int i=0; i<array.length; i++){
				for(int j=0; j<array.length; j++)
					if(pDiffs(array[i], array[j]) > 10){
						System.out.println("Abnormal pressure detected between nodes " + i + " " + j +" the difference detected is " + pDiffs(array[i], array[j]));
						probs = true;
						if((i == 5 || j == 5) && pDiffs(array[i], array[j]) > 20){
							System.out.println("Abnormal pressure detected between nodes " + i + " " + j +" the difference detected is " + pDiffs(array[i], array[j]));
							probs = true;
						}
					}

			}
		}
		
		
		
	}
	
	// pass in sensor arrays and average all of the values
	// right now mostly for use with standing analysis
	public float average(float[] a){
		
		float sum = 0;
		for(int i=0; i<a.length; i++){
			sum = sum + a[i];
		}
		
		sum = sum / a.length;
		return sum;
	}
}
