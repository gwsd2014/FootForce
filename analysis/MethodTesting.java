package analysis;

import java.util.Arrays;

public class MethodTesting {
	public static void main(String[] args){
		LRComp comp = new LRComp();
		float[] right = new float[7];
		float[] left = new float[7];
		for(int i=0; i<right.length; i++){
			right[i] = i;
			left[i] = i;
		}
		System.out.println(Arrays.toString(comp.standingComp(right, left)));
		int a = 1;
		String nums = "this number "+1+" and this one "+2;
		System.out.println(nums);
	}

}
