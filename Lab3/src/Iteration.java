//lab 3
import java.util.Scanner;
public class Iteration {
	public static void main(String[] agrs) {
		System.out.println("Please enter an integer");
		Scanner s = new Scanner(System.in);
		int userNum = s.nextInt();
		
		//part 1.1
		int i = 1;
		while (i <= 10) {
			System.out.printf("%d * %d = %d %n", i, userNum, i*userNum);
			++i;
		}
		
		//part 1.2
		System.out.println("Please enter an integer again");
		int userInt = s.nextInt();
		for (i = 0; i < 10; ++i) {
			userInt = (int) Math.pow(userInt, 2);
			System.out.println(userInt);
		}
		
		System.out.println("Enter a positive number");
		int newNum = s.nextInt();
		int flag = 0;
		if (newNum > 1) {
			for(i = 2; i <= newNum/2; ++i) {
				if(newNum % i == 0) {
					System.out.println(newNum + " is composite number.");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println(newNum + " is prime number.");
			}	
		}	
		
		
	}
}	
	