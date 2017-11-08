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
	Model model;
	Controller controller;
	Monster monster;
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		
		view = new View();
		model = new Model();
		controller = new Controller();
		
		model.addObserver(view);
		
		//monster intialized in this class? not sure really
		monster = new Monster();
		
		
		controller.addModel(model);
		controller.addView(view);
		controller.initModel();
		view.addController(controller);
		primaryStage = view.getStage();
		
		
		//populating monster arraylist from Controller method addMonster
		controller.addMonsters(monster);
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
}
