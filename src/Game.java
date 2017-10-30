import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author Evan
 *
 */
public class Game extends Application
{
	View view;
	Controller controller;

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		view = new View();
		controller = new Controller();
		view.addController(controller);
		controller.addView(view);
		primaryStage = view.getStage();
	}
	
	public static void main(String[] args)
	{
		
		
		
		
		
		
		
		
		
		
		
	    launch(args);
	}

}
