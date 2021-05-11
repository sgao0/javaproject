import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class GameCanvas extends JPanel implements ActionListener, MouseListener, 
																MouseMotionListener, ChangeListener {
	//set initial
	int xCanvas = 400; //canvas'length in x-axis
	int yCanvas = 400; //canvas'length in y-axis
	int size = 20; //grid's size
	int xLength = xCanvas/size; //set x value for array
	int yLength = yCanvas/size; //set y value for array
	int[][] life = new int[xLength][yLength]; // put the grids into array
	int[][] lifeSub = new int[xLength][yLength];// make an substitution for life array
	
	// initialize the buttons & spinner
	private JButton pauseButton; 
	private JButton clearButton;
	private JButton startButton;
	private JButton randomizeButton;
	private JSpinner timeSpinner;
	GridBagConstraints positionConst = null;//set the GridBagConstraints so I can position the buttons
	SpinnerNumberModel spinnerModel = new SpinnerNumberModel(10,1,10,1);//make a spinnerModel 
																		//so I can use spinner properly
	
	boolean start = true; //set start boolean to be true to start the loop
	int initial = -1; // set the initial to be -1,
	Timer timer; // initialize the timer
	


	
	public GameCanvas() {
		
		setSize(xCanvas,yCanvas); //set size for the canvas
		setLayout(null);
		setBackground(Color.pink);//set the canvas background color to be pink
		
		addMouseListener(this); //allows the mouse to receive order 
		addMouseMotionListener(this);
		
		//default timer
		timer = new Timer(1000, this);// initialize the timer to restart actions 
									 // after each 1000 milliseconds, which is 1 second
		
	}
	
	
	
	
	public void paintComponent(Graphics g) {	
		super.paintComponent(g);
		grid(g); // put grid on canvas
		display(g); // show the cells
		
		
	    spinnerModel = new SpinnerNumberModel(10,1,10,1); //set a spinner model which has 
	    												  // (max, min, default number, step)
	    timeSpinner = new JSpinner(spinnerModel); //put the model to timeSpinner
	    timeSpinner.setBounds(150,yCanvas+200,250,35); // the the position
	    timeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSpinner timeSpinner = (JSpinner) e.getSource(); //get the number that user customized	
		        int speed = (int) timeSpinner.getValue()*100; //since it is milliseconds, 
		        											  //let the value * 100 to transfer from 
		        											  //seconds to milliseconds
		        timer.setDelay(speed);	//set timer's speed to user's customization
		    } 
		});
	    add(timeSpinner,positionConst); //make it visible
		
	    
	    
		pauseButton = new JButton("Pause"); //set a button for user to pause the game
		pauseButton.setBounds(0,yCanvas+100,100,50); // set the position
		pauseButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
	    		timer.stop(); // function
	    	}
	    });	
	    add(pauseButton, positionConst); //let it become visible on the right position
	    
	    
	    
	    startButton = new JButton("Start"); // set a button for user to start the game after pausing
		startButton.setBounds(150,yCanvas+100,100,50); // set the position
		startButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
	    		timer.start(); // function
	    	}
	    });	
	    add(startButton, positionConst);
	    
	    
	    
	    clearButton = new JButton("Clear"); // set a button for user to clear all cells and restart the game
	    clearButton.setBounds(xCanvas-100,yCanvas+100,100,50); // set the position
	    clearButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
	    		clear(); // function
	    	}
	    });	
	    add(clearButton, positionConst);
	    
	    
	    
	    randomizeButton = new JButton("Randomize"); // set a button for user to randomize the cells
	    randomizeButton.setBounds(0,yCanvas+200,100,50); // set the position
	    randomizeButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
	    		random(g); // function
	    		repaint();
	    	}
	    });	
	    add(randomizeButton, positionConst);
	    
	}
	
	
	
	//set grid
	private void grid(Graphics g) {
		g.setColor(Color.gray);//set the grids' color to be gray
		
		for (int i=0; i < xLength; i++) { //draw the grid
			g.drawLine(0, i*size, xCanvas, i*size); // draw lines for rows
			g.drawLine(i*size, 0, i*size, yCanvas); // draw lines for columns
		}
	}
	
	// method that make an substitution for life array
	private void substitutionArray() { 
		for (int x=0; x<xLength; x++) {
			for(int y=0; y<yLength; y++) {
				life[x][y] = lifeSub[x][y]  ;					
			}
		}
	}
	
	
	private void display(Graphics g) {
		g.setColor(Color.cyan); // set live cell's color to be cyan
		substitutionArray();
		for (int x=0; x<xLength; x++) {
			for(int y=0; y<yLength; y++) {
				if (life[x][y] == 1) { // if it is alive (1 means live, 0 means death)
					g.fillRect(x*size, y*size, size, size); //fill the rectangle, which is the live cell
				}	
			}
		}	
	}
	
	
	private void random(Graphics g) { //set a method to randomize the cells on the canvas
		if (start) { // if it is true
			for (int x=0; x<xLength; x++) { //check every elements in array
				for(int y=0; y<yLength; y++) {
					if((int)(Math.random()* 5) == 0) {//if in 5 numbers, the random =0 (as the number get 
													  //larger, there will be less live cells)
						lifeSub[x][y] = 1;//then set the cell to be alive
					}
				}
			}
			start = false;
		}	
	}
	
	public boolean coordinateValidity(int x, int y){ // check whether coordination exceeds the edge
	    return !((x < 0 || x >= xLength) || (y < 0 || y >= yLength) );
	}


	public int check(int x, int y){ //method that check whether the cell is alive 
									//associate with surroundings
	    int alive = 0;      //initialize the surrounding live cell to be 0
	    if(coordinateValidity(x - 1, y - 1)) { // check the cell on upper left
	    	if (life[x - 1][y - 1] == 1){
	    		alive++;
	       }
	    }
	    if(coordinateValidity(x, y - 1)) { // check the cell right above
	    	if (life[x][y - 1] == 1) {
	    		alive++;
	        }
	    }
	    if(coordinateValidity(x + 1, y - 1)) { // check the cell on upper right
	    	if (life[x + 1][y - 1] == 1){
	    		alive++;
	        }
	    }
	    if(coordinateValidity(x - 1, y)) { //check the cell on the left
	    	if (life[x - 1][y] == 1){
	    		alive++;
	    	}
	    }
	    if(coordinateValidity(x + 1, y)) { //check the cell on the right
	    	if (life[x + 1][y] == 1){
	    		alive++;
	    	}
	    }
	    if(coordinateValidity(x - 1, y + 1)) { // check the cell on bottom left
	    	if (life[x - 1][y + 1] == 1){
	    		alive++;
	    	}
	    }
	    if(coordinateValidity(x, y + 1)) { // check the cell right below
	    	if (life[x][y + 1] == 1){
	    		alive++;
	    	}
	    }
	    if(coordinateValidity(x + 1, y + 1)) { // check the cell on bottom right
	    	if (life[x + 1][y + 1] == 1){
	    		alive++;
	    	}
	    }
	    return alive;
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e) { //status change of cells: dead or live
		int liveCells;	
		for (int x=0; x<xLength; x++) {
			for(int y=0; y<yLength; y++) {
				liveCells = check(x,y);//set the live cells number equals to alive number in check method
				
				if (liveCells == 3) { // if the live cells around the cell is 3
					lifeSub[x][y] = 1; // then stays alive or comes to live
				}
				else if (liveCells == 2 && life[x][y] == 1) { // if the live cells around the cell is 2
															//and original cell is alive
					lifeSub[x][y] = 1; // then stays alive
				}
				else { // if it's fewer than 2 or more than 3
					lifeSub[x][y] = 0; // then dies anyway 
				}
			}
		}
		repaint(); // repaint the canvas
	}

	
	
	
	//method that clear everything from the canvas
	private void clear() {
		for (int x=0; x<xLength; x++) {
			for(int y=0; y<yLength; y++) {
				lifeSub[x][y] = 0;
			}	
		}
	}
	
	
	
	
	public void mousePressed(MouseEvent e) {
		timer.stop();//let the timer stop when press the mouse
		int x = e.getX() / size;//the x-position that user dragged the mouse
		int y = e.getY() / size;//the y-position that user dragged the mouse
		
		if(life[x][y] == 0) { // if original life is dead
			initial = 0; // set the initial to be 0, which represents dead
		}
		else { //else, the original life is alive
			initial = 1; // set the initial to be 1, which represents alive 
		}
		repaint(); // repaint the canvas
	}
	
	
	
	
	public void mouseDragged(MouseEvent e) {
		int x = e.getX() / size; //the x-position that user dragged the mouse
		int y = e.getY() / size; //the y-position that user dragged the mouse
		
		if(life[x][y] == 0 && initial == 0) { //if original life is dead and initial shows it's dead
			lifeSub[x][y] =1; // then lifeSub array become alive
		}
		else if(life[x][y] == 1 && initial == 1) {//if original life is alive and initial shows it's alive
			lifeSub[x][y] = 0; // then lifeSub array change status to be dead
		}	
		repaint(); // repaint the canvas
	}


	
	
	public void mouseReleased(MouseEvent e) {
		timer.start(); //let the timer start again when release the mouse
		initial = -1; // set the initial back to -1 when release the mouse, which is the default value
		
	}
	
	public void mouseMoved(MouseEvent e) {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}


	public void stateChanged(ChangeEvent e) {
		
	}


	
}


