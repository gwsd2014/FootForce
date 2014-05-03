package analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class RandomNumbGenerator{
	public static void generate(){
		try {
			File file = new File("c://users//scarrick//");
			PrintWriter writer = new PrintWriter("randomNumbers.txt");
			for (int i=0; i<100; i++){
				writer.println(Math.floor(Math.random()*1023));
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		}
			
			
	}
}
