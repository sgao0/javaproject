/* Name:Shen Gao
 * Email:sgao16@u.rochester.edu
 * Date: Feb.8th
 * Lab 1
 */
import java.util.Scanner;

public class lab1 {
	public static void main(String[] args) {
		//Part 1
		System.out.println("Welcome to Shen Gao's Demonstration!");
		
		
		
		//Part 2
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a number: ");
		double numberOne = scnr.nextDouble();
		System.out.println("Enter another number: ");
		double numberTwo = scnr.nextDouble();
		
		System.out.println(numberOne + " + " + numberTwo + " = " + (numberOne + numberTwo));
		System.out.println(numberOne + " - " + numberTwo + " = " + (numberOne - numberTwo));
		System.out.println(numberOne + " * " + numberTwo + " = " + (numberOne * numberTwo));
		System.out.println(numberOne + " / " + numberTwo + " = " + (numberOne / numberTwo));
		
		
		//Part 3
		System.out.println("\n");
		System.out.print("Enter the time you spent writing Java programs: ");
		int codingJava = scnr.nextInt();
		int hoursSpent = codingJava / 3600;
		int minutesSpent = (codingJava % 3600) / 60;
		int secondsSpent = (codingJava % 3600) % 60;
		
		System.out.println(hoursSpent + ":" + minutesSpent + ":" + secondsSpent);
		
		
	}
}
