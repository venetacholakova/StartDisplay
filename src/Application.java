import javax.swing.JFrame;

public class Application {
	
	/** Width and height of the frame in pixels.*/
	public static int FRAME_WIDTH = 1000,
					  FRAME_HEIGHT = 1000;
	
	/**
	 * Create a JFrame that holds the .
	 * @param args input from user /not used/
	 **/
	public static void main( String[] args )
	{
		JFrame frame;
		
		// create a new JFrame to hold the game Panel
		frame = new JFrame( "Current time, remaining time and start list.");
		
		// set size
		frame.setSize( FRAME_WIDTH, FRAME_HEIGHT );

		// 
		frame.add( new Display() );
		
		// exit normally on closing the window
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// show frame
		frame.setVisible( true );
	}

}
