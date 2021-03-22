
public class Methods {
	public static void main(String[] args) {
		roof(8);
		walls(8,3);
		foundation(8);
	}
	
	public static void foundation(int width){
		for (int i=0; i<width; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public static void walls(int width, int height) {
		int numSpace = width-2;
		if (width >= 2) {
			for (int j=0; j<height; j++) {
				System.out.print("|");
				for (int i=0; i<numSpace; i++) {
					System.out.print(" ");
				}
				System.out.println("|");
			}
		}	
	}
	
	public static void roof(int width) {
		int height = width/2;
		for (int i=0; i<width; i+=2) {
			for(int j= height; j>1; j--) {
				System.out.print(" ");
			}
			height--;
			System.out.print("/");
			if (i== width-2) {
				for (int k=i; k > 0; k--) {
					System.out.print("-");
				}
			}	
			else{
				for (int k=i; k > 0; k--) {
					System.out.print(" ");
				} 	
			}
			System.out.println("\\");
		}
	}
}
	

