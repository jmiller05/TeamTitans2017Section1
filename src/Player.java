import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player extends Entity
{
	private Room currentRoom;
	private ArrayList<Item> inventory;
	private int maxHealth;
	
	public Player()
	{
		super(10, 10);
		//System.out.println("I exist");
		inventory = new ArrayList<Item>();
		maxHealth = 10;
	}
	
	//	public IntegerProperty getHealth()
	//	{
	//		return health;
	//	}
	
	
	public int getMaxHealth()
	{
		return this.maxHealth;
	}
	
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
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
	
	public void attack(Entity e, int dam)
	{
		e.adjustHealth(-dam);
	}
	
	@Override
	public String toString()
	{
		return "Player";
	}
	
	
	
}
