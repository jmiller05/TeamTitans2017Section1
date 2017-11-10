import java.util.ArrayList;

public class Puzzle {
	private String puzzleID;
	private String puzzleName;
	private String puzzleDescription;
  	private String hint;
  	private ArrayList<Item> artifact = new ArrayList<Item>();
  	private ArrayList<Room> location = new ArrayList<Room>();
  	private ArrayList<Puzzle> puzzleArray = new ArrayList<Puzzle>();
	
 	public Puzzle(String ID, String name, String desc, String hi)
 	{
 		this.puzzleID = ID;
	  	this.puzzleName = name;
		this.puzzleDescription = desc;
		this.hint = hi;
 	}
	
 	public void getPuzzleName()
 	{
 		System.out.println(this.puzzleName);
 	}
	
 	public void getPuzzleID()
 	{
 		System.out.println(this.puzzleID);
 	}
 	
 	public void gePuzzleDescription()
 	{
		System.out.println(this.puzzleDescription);
	}
	
 	public void getHint()
 	{
 		System.out.println(this.hint);	
 	}
	
 	public void addItem(Item item)
 	{		
 		artifact.add(item);
 	}
	
 	public void addLocation(Room room)
	{
 		location.add(room);
	}
	
 	
  }
