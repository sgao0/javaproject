/* Name: Shen Gao
 * Email: sgao16@u.rochester.edu
 * 03/31/21
 */
import java.util.Scanner;

public class Skyscraper {
	private int DIM; // set the dimension for the puzzle
	private boolean validity = true; // set the original validity to be true, and then check the validity in verifyPlacement
	private int[][] puzzle; // set a array called puzzle

	
	public void loadPuzzle() {
		Scanner s = new Scanner(System.in);
		System.out.println("What is the dimension of the puzzle?");
		DIM = s.nextInt(); // user sets the dimension for the puzzle
		puzzle = new int[DIM][DIM]; // puzzle is a square array
		
		for (int i = 0; i < DIM; ++i) { 
			System.out.println("Enter the numbers for row " + (i+1) + ".");
			for (int j = 0; j < DIM; ++j) {
				puzzle[i][j] = s.nextInt(); // set the number at each position in the array
			}
		}
	}
	
	
	
	public boolean verifyPlacement() {
		for (int i = 0; i < DIM; ++i) {
			for (int j = 0; j < DIM; ++j) {
				for(int k = j+1; k < DIM; ++k) { // set 3 for loops to check the validity, k = j + 1 with a for loop means k could be the next few numbers in the same row or column.
					if ((puzzle[i][j] == puzzle[i][k]) || (puzzle[j][i] == puzzle[k][i])) { //this is the number at puzzle[i][j], 
									//for example the dimension is 4, at puzzle[1][1] the number is 1. Then k could be 2, 3, 4, so we will check the value at puzzle[1][2],
									//puzzle[1][3] and puzzle[1][4] or [2][1], [3][1], [4][1]to make sure if the have the same value at puzzle[1][1]. If it does, then the validity will be false 
									//we only contains each number exactly once at every row and every column.
						validity = false;
						break; //and if it does, we will break the for loop and validity should be false, even though the rest row or column might be correct.
					}
				}	
			}
		}
		return validity;
	}
	
	public void print() {
		System.out.println(DIM);// print the dimension for the puzzle
		for (int i = 0; i < DIM; ++i) {
			for (int j = 0; j < DIM; ++j) {
				System.out.print(puzzle[i][j] + " "); // print each number in the puzzle
			}
			System.out.println();
		}
	}
	
	
	
	private int countRowForward(int row) {
		int max = 0; // set the original value for max to be 0, so we can compare it with the value in the puzzle, the minimum value in puzzle is greater than 0
		int count = 0;// count how many greater number are in the row
		for (int i = 0; i < DIM; ++i) {
			if(puzzle[row][i] > max) { //if the number is larger than our initial max value
				max = puzzle[row][i];// make the max value equals to the puzzle number
				count += 1; // and add 1 when we find a greater number
							// for example the dimension is 4, at row 1, the numbers are 1 2 4 3, since 4 > 2 > 1, 
							// the count should add 1 for 3 times and ignore the last 3 because 3 < 4
			}
		}
		return count;
	}
	
	private int countRowBackward(int row) {
		int max = 0;
		int count = 0;
		for (int i = DIM - 1; i >= 0; --i) { // similar to the last method, but this time we count the row from back to front, so we set i to be DIM - 1, which is the last number
			if(puzzle[row][i] > max) {
				max = puzzle[row][i];
				count += 1;
			}
		}
		return count;
	}
	
	private int countColumnForward(int column) { // share similar logical thought above
		int max = 0;
		int count = 0;
		for (int i = 0; i < DIM; ++i) {
			if(puzzle[i][column] > max) {
				max = puzzle[i][column];
				count += 1;
			}
		}
		return count;
	}
	
	private int countColumnBackward(int column) { // share similar logical thought above
		int max = 0;
		int count = 0;
		for (int i = DIM - 1; i >= 0; --i) {
			if(puzzle[i][column] > max) {
				max = puzzle[i][column];
				count += 1;
			}
		}
		return count;
	}
	
	public void printWithVisibility() {
		System.out.print("  "); // type 2 space first since there is a row count number and a "|"
		for (int i = 0; i < DIM; ++i) { // first set the count column forward numbers, followed by a space each
			System.out.print(this.countColumnForward(i) + " ");
		}
		System.out.println(); // next line
		System.out.print("  "); 
		for (int j = 0; j < DIM + (DIM - 1); ++j) { // it iterates DIM + (DIM - 1) times, because there is space between each count column forward numbers. 
													// For example, if the dimension is 4, there is going to be 3 space, therefore the total number is 4+3=7
			System.out.print("-");
		}
		System.out.println();
		for (int k = 0; k < DIM; ++k) {
			System.out.print(this.countRowForward(k) + "|");
			for (int l = 0; l < DIM - 1; ++l) { // since there is no space behind the last index, we set DIM - 1
				System.out.print(puzzle[k][l] + " ");
			}
			System.out.println(puzzle[k][DIM-1] + "|" + this.countRowBackward(k));
		}
		System.out.print("  ");
		for (int m = 0; m < DIM + (DIM - 1); ++m) { // share similar logical thought above
			System.out.print("-");
		}
		System.out.println();
		System.out.print("  ");
		for (int n = 0; n < DIM; ++n) {
			System.out.print(this.countColumnBackward(n) + " ");
		}
			
	}	
			
	
	

	public static void main(String[] args) {
		Skyscraper game = new Skyscraper();
		game.loadPuzzle(); // user sets numbers for the puzzle
		game.print(); // print out the puzzle
		if (game.verifyPlacement()) { // check the validity
			System.out.println(game.verifyPlacement());
			System.out.println();
			game.printWithVisibility(); // show the visibility

		} else {
			System.out.println(game.verifyPlacement());
		}
		
	}

}
