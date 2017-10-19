import java.util.ArrayList;

public class Room {
	
	private int roomID;
	private String roomName;
	private String roomDescription;	
	private ArrayList<Exit> exit = new ArrayList<Exit>();
	private ArrayList<Puzzle> puzzles = new ArrayList<Puzzle>();	
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
}
