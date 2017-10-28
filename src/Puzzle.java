 	import java.util.ArrayList;

public class Puzzle {
	private String puzzleID;
	private String puzzleName;
	private String puzzleDescription;
	private String artifactID;
	private String solution;
    	private Room location;
  	private String hint;
  	private ArrayList<Item> requiredItems = new ArrayList<Item>();
 	
 	public Puzzle(String ID, String name, String desc,String art, String solu)
 	{
 		this.puzzleID = ID;
	this.puzzleName = name;
	this.puzzleDescription = desc;
 	this.artifactID = art;
 		this.solution = solu;
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
 	public void getArtifactID()
 	{ 
 		System.out.println(this.artifactID);
 	}
 	public void getSolution()
 	{
 		System.out.println(this.solution);
 	}
 	public void addItem(Item item)
 	{		
 		requiredItems.add(item);
 	}
 	public void requestHint()
 	{
 		
 	}
	
 	
  }
