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
	
	public void populatePuzzles()
	{
		Puzzle p0 = new Puzzle("PZ00", "Torch", "Pick the torch in room 4 in order to enter and navigate room 6", "Collect and equip torch in room 4 to illuminate room 6");
		Puzzle p1 = new Puzzle("PZ01", "Runes", "There will be two runes that is needed to be slotted into the door (Dr_18) in Room 15 in order to enter Room 18", "The Runes from room 16 and room 17 will unlock the door in Room 15 to enter Room 18");
		Puzzle p2 = new Puzzle("PZ02", "Skull Pedestal", "Find 3 golden skulls and assemble them in order to attract the final monster - One golden skull per floor", "Assemble all 3 skulls in room 29 from the skulls from Rooms 9, 22, 26");
		Puzzle p3 = new Puzzle("PZ03", "Spider Webs", "Destroy 3 spider webs - One room will be unlocked, one spider web will drop the key to room 8", "Destroy spider webs until the key to room 8 drops from one of the webs");
		Puzzle p4 = new Puzzle("PZ04", "Centaur", "Kill the centaur and collect the key in order to access Room 21", "Kill centaur and collect key");
		Puzzle p5 = new Puzzle("PZ05", "Witch craft", "Kill witch, drops the key to room 22", "Collect key from witchâ€™s decomposing body");
		Puzzle p6 = new Puzzle("PZ06", "Torch puzzle", "There should be 3 torches that have to be lit in order to unlock the door to room 29", "The three unlit torches in Room 24 need to be lit in order to enter room 29 1-0-1 1 = Lit 0 = Off");
		puzzleArray.add(p0); puzzleArray.add(p1); puzzleArray.add(p2); puzzleArray.add(p3); 
		puzzleArray.add(p4); puzzleArray.add(p5); puzzleArray.add(p6);
	}
	
 	
  }
