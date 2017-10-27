import java.util.ArrayList;

public class Room {
	
	private int roomID;
	private String roomName;
	private String roomDescription;	
	private ArrayList<Puzzle> puzzles = new ArrayList<Puzzle>();	
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private Exit[] exitArray = new Exit[8];
	
	public Room(int roomID, String roomName, String roomDescription)
	{
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomDescription = roomDescription;
		this.exitArray[0] = null; //North Exit
		this.exitArray[1] = null; //South Exit
		this.exitArray[2] = null; //East Exit
		this.exitArray[3] = null; //West Exit
		this.exitArray[4] = null; //Northeast Exit
		this.exitArray[5] = null; //Northwest Exit
		this.exitArray[6] = null; //Southeast Exit
		this.exitArray[7] = null; //Southwest Exit
		
	}
}
