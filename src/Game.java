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
<<<<<<< HEAD
	View view;
	Model model;
	Controller controller;
	Monster monster;
=======
	View		view;
	Controller	controller;
	Player		player;
	Monster		monsters;
	Room		rooms;
	Exit 		exit;
>>>>>>> a68d1c3827e5cc1dac53edf118d2083bb016f04d
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		view = new View();
		model = new Model();
		controller = new Controller();
		
<<<<<<< HEAD
		model.addObserver(view);
		
		//monster intialized in this class? not sure really
		monster = new Monster();
		
		
		controller.addModel(model);
		controller.addView(view);
		view.addController(controller);
		primaryStage = view.getStage();
		
		
		//populating monster arraylist from Controller method addMonster
		controller.addMonsters(monster);
		
	}
	
	public static void main(String[] args)
	{
=======
		// monster intialized in this class? not sure really
		monsters = new Monster();
		
		// room initialized
		rooms = new Room();
>>>>>>> a68d1c3827e5cc1dac53edf118d2083bb016f04d
		
		// created player with arbitrary beginning stats for testing
		player = new Player(100, 10);
		
		exit = new Exit();
		
		view.addController(controller);
		controller.addView(view);
		primaryStage = view.getStage();
		
		// populating monster arraylist from Controller method addMonsters
		controller.addMonsters(monsters);
		// controller.addMonsterRooms(monsters);
		
		// populate the room info using Controller method addRooms
		controller.addRooms(rooms);
		
		//set player location to room 0 i.e. first room
		player.setLocation(rooms.getRoomAL().get(0));
		
		//set exit for toom 00 to east
		controller.setExits(rooms.getRoomAL().get(0), exit, "East");
		
		
		
	}
	
	public static void main(String[] args)
	{
		
		launch(args);
	}
	
}
