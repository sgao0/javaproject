import java.util.Scanner;
public class Lab4 {
	public static void main(String[] args) {
		int x1 = 4 ;

		int y = x1;

		int z = x1 * y;

		x1++ ;
		System.out.println(z);
		
		Scanner s = new Scanner(System.in);
		int input = 0;
		int numRows;
		int numColumns;
		int num1 = 1;
		int num2 = 2;
		int num3 = 3;
		
		//part 1
		do {
			System.out.print("Enter a number: ");
			input = s.nextInt();
			if (input !=0) {
				System.out.println(Math.pow(input, 2));
			}	
		} while(input != 0);
		
		//part 2
		System.out.println("How many rows and column?");
		numRows = s.nextInt();
		numColumns = numRows;
		for (int i = 1; i <= numRows; ++i) {
			System.out.println();
			for (int j = 1; j <= numColumns; ++j) {
				System.out.print(i * j + " ");
			}
		}
		System.out.println();
		
		//part 3
		while (num1 != 0 && num2 != 0 && num3 != 0) {
			System.out.println("Enter a number:");
			num1 = s.nextInt();
			System.out.println("Enter a number again:");
			num2 = s.nextInt();
			System.out.println("Enter a number one more time:");
			num3 = s.nextInt();
			
			
			if (num1 == 0 && num2 == 0 && num3 == 0) {
				break;
			}
			
			int x = num1;
			while (x <= num2) {
				System.out.println(x);
				x = x + num3;
			}
		} 
		
		//part 4
		System.out.println("Enter a number:");
		int n = s.nextInt();
		int num = 1;
		double sum = 0.0;
		
		while (num <= n) {
			if (num % 2 != 0) {
				sum += (1.0 / num);
			}else {
				sum -= (1.0 / num);
			}
			num++;
		}
		System.out.println("output is: " + sum);
		System.out.println("Math.log(2) is: " + Math.log(2));
		
	}
}