import java.util.ArrayList;

public class Player extends Entity
{
	/**
	 * the player's current room
	 */
	private Room currentRoom;
	
	/**
	 * the player's inventory
	 */
	private ArrayList<Item> inventory;
	
	
	/**
	 * Constructor for Player
	 * 
	 * @param health
	 * @param damage
	 */
	public Player(int health, int damage)
	{
		super(health, damage);
		this.inventory = new ArrayList<Item>();	
	}
	
	/**
	 * Constructor for Player
	 * 
	 * @param health
	 * @param maxHealth
	 * @param damage
	 */
	public Player(int health, int maxHealth, int damage)
	{
		super(health, maxHealth, damage);
		inventory = new ArrayList<Item>();
	}
	
	/**
	 * @return the player's current room
	 */
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	/**
	 * Sets the player's current room
	 * 
	 * @param newRoom the room to change to
	 */
	public void setCurrentRoom(Room newRoom)
	{
		currentRoom = newRoom;
	}
	
	/**
	 * @return the inventory
	 */
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	/**
	 * Sets the player's inventory
	 * 
	 * @param inventory the ArrayList to set
	 */
	public void setInventory(ArrayList<Item> inventory)
	{
		this.inventory = inventory;
	}
	
	/**
	 * Adds an item to the player's inventory
	 * 
	 * @param item the item to add
	 */
	public void addItemToInventory(Item item)
	{
		inventory.add(item);
	}
	
	/**
	 * changes the player's current room
	 * 
	 * @param exit the exit to use
	 */
	public void changeRoom(Exit exit)
	{
		this.setCurrentRoom(this.getCurrentRoom().getAdjacentRoom(exit));
	}	
	
	/**
	 * displays the message of defeating a monster
	 * 
	 * @return the message
	 */
	@Override
	public String winFight()
	{
		return "You have defeated the monster.";
	}
	
}
