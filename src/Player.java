import java.util.ArrayList;

public class Player extends Entity
{
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	
	public Player(int health, int damage)
	{
		super(health, damage);
	}
	
	public void setLocation(Room r)
	{
		this.location = r;
	}
	
	public void getLocation(Room r)
	{
		
	}
	
	public void fleeFight()
	{
		
	}
	
	public void enterRoom(Room r)
	{
		
	}
	
	public void examineMonster(Monster m)
	{
		
	}
	
	public void examinePuzzle(Puzzle p)
	{
		
	}
	
	public void solvePuzzle(Puzzle p)
	{
		
	}
	
	public void hintPuzzle(Puzzle p)
	{
		
	}
	
	public void examineRoom(Room r)
	{
		
	}
	
	public void searchRoom(Room r)
	{
		
	}
	
	public void examineItem(Item i)
	{
		
	}
	
	public void dropItem(Item i)
	{
		
	}
	
	public void useItem(Item i)
	{
		
	}
	
	public void equipItem(Item i)
	{
		
	}
	
	public void collectItem(Item i)
	{
		
	}
	
}
