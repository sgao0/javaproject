import java.awt.event.*;
import javax.swing.*;

public class GameOfLife extends JFrame implements ActionListener{
	
	JFrame f = new JFrame(); // set the frame called f
	GameCanvas canvas = new GameCanvas();//add GameCanvas method to GameOfLife
	
	public GameOfLife() {
		
		f.add(canvas);//add the canvas
		f.setTitle("Game of Life");//set the title for the frame
		f.setSize(400,900);//set the frame size
		f.setVisible(true);//make it visible
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the frame and stop the program
	
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		new GameOfLife();// make it work
	}

	
	
}
