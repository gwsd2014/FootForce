package analysis;

public class Walking {
	public static int cutoff = 120;
	public static int arraySize = 1000;
	public int numSenors = 7;
	public static float[] rbigToe = new float[arraySize];
	public static float[] rToe2 = new float[arraySize];
	public static float[] rToe3 = new float[arraySize];
	public static float[] rToe4 = new float[arraySize];
	public static float[] rpinkyToe = new float[arraySize];
	public static float[] rheel = new float[arraySize];
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
	public float[] percentDiffs = new float[arraySize*5];
	public float[] maxP = new float[arraySize];
	
	
	public void walking(){
		float heelMax = 0;
		for(int i=0; i<arraySize; i++){
			if(rheel[i]<cutoff){
				compareToes();
			}
			if(heelStrike(i)){
				if(rheel[i] > heelMax){
					heelMax = rheel[i];
				}
			
			}
		}
	}
	
	public void compareToes(){
		float temp = 0;
		for (int i=0; i<rheel.length; i++){
			temp = rbigToe[i] - rToe2[i];
			temp = (temp/((rbigToe[i] + rToe2[i])/2)) * 100;
			percentDiffs[i] = temp;
			if(temp>10){
				System.out.println("walking imbalance detected");
			}
			
			temp = 0;
			temp = rbigToe[i] - rToe3[i];
			temp = (temp/((rbigToe[i] + rToe3[i])/2)) * 100;
			percentDiffs[i+1] = temp;
			if(temp>10){
				System.out.println("walking imbalance detected");
			}
			
			temp = 0;
			temp = rbigToe[i] - rToe4[i];
			temp = (temp/((rbigToe[i] + rToe4[i])/2)) * 100;
			percentDiffs[i+2] = temp;
			if(temp>10){
				System.out.println("walking imbalance detected");
			}
			
			temp = 0;
			temp = rbigToe[i] - rpinkyToe[i];
			temp = (temp/((rbigToe[i] + rpinkyToe[i])/2)) * 100;
			percentDiffs[i+3] = temp;
			if(temp>20){
				System.out.println("walking imbalance detected");
			}
			
			temp = 0;
			temp = rbigToe[i] - rheel[i];
			temp = (temp/((rbigToe[i] + rheel[i])/2)) * 100;
			percentDiffs[i+4] = temp;
			if(temp>10){
				System.out.println("walking imbalance detected");
			}
		}
	}
	
	public boolean heelStrike(int i){
		if(rheel[i]>cutoff && rbigToe[i]<cutoff && rpinkyToe[i]<cutoff){
			return true;
		}
		return false;
	}
	
	public void stairs(){
		for(int i=0; i<arraySize; i++){
			if(rbigToe[i]>cutoff || rpinkyToe[i]>cutoff){
				compareToes();
			}
		}
	}
}
