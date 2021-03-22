
import java.util.Scanner;

public class Arrays {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//double total = 0.0;
		//double mean;
		System.out.print("How many numbers the process?\n> ");
		int len = s.nextInt();

		int[] userArray = new int[len];
		System.out.print("> ");
		
		for(int i=0; i<len; i++) {
			userArray[i] = s.nextInt();
		}
		
		printArray(userArray);
		arrayMean(userArray);
		/*for(int i =0; i<len; ++i) {
			total += userArray[i];
		}
		mean = total/len;
		System.out.println("Mean: " + mean);*/
		
	}
	public static void printArray(int[] inputs) {
		int size = inputs.length;
		System.out.print("You entered: ");
		for(int i=0; i<size; i++) {
			System.out.print(inputs[i] + " ");
		}
		System.out.println();
	}

	public static void arrayMean(int[] inputs) {
		int size = inputs.length;
		double total = 0.0;
		double mean;
		for(int i =0; i<size; ++i) {
			total += inputs[i];
		}
		mean = total/size;
		System.out.println("Mean: " + mean);
	}
}
