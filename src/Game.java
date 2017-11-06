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
	Monster monster;
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		view = new View();
		controller = new Controller();
		
		//monster intialized in this class? not sure really
		monster = new Monster();
		
		view.addController(controller);
		controller.addView(view);
		primaryStage = view.getStage();
		
		
		//populating monster arraylist from Controller method addMonster
		controller.addMonsters(monster);
		
	}
	
	public static void main(String[] args)
	{
		
		
		
		
		
		
		
		
		
		
		
		launch(args);
	}
	
}
