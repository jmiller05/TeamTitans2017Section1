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

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		View view = new View();
		primaryStage = view.getStage();
		
	}
	
	public static void main(String[] args)
	{
	    launch(args);
	}

}
