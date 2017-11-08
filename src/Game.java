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
	View		view;
	Controller	controller;
	Player		player;
	Monster		monsters;
	Room		rooms;
	Exit 		exit;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		view = new View();
		controller = new Controller();
		
		// monster intialized in this class? not sure really
		monsters = new Monster();
		
		// room initialized
		rooms = new Room();
		
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
