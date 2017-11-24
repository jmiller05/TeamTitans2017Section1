import java.util.ArrayList;

public class Player extends Entity
{
	private Room currentRoom;
	private ArrayList<Item> inventory;
	

	public Player(int health, int damage)
	{
		super(health, damage);
		this.inventory = new ArrayList<Item>();	
	}
	
	public Player(int health, int maxHealth, int damage)
	{
		super(health, maxHealth, damage);
		inventory = new ArrayList<Item>();
	}
	
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	public void setCurrentRoom(Room newRoom)
	{
		currentRoom = newRoom;
	}
	
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	public void setInventory(ArrayList<Item> inventory)
	{
		this.inventory = inventory;
	}
	
	public void addItemToInventory(Item item)
	{
		inventory.add(item);
	}
	
	public void changeRoom(Exit exit)
	{
		this.setCurrentRoom(this.getCurrentRoom().getAdjacentRoom(exit));
	}	
	
	@Override
	public String winFight()
	{
		return "You have defeated the monster.";
	}
	
}
