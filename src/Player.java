import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player
{
	private Room currentRoom;
	private ArrayList<Item> inventory;
	private int maxHealth;
	private int health;
	
	public Player()
	{
		//System.out.println("I exist");
		inventory = new ArrayList<Item>();
		maxHealth = 10;
		health = 10;
		
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public int getMaxHealth()
	{
		return maxHealth;
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
	
	public void takeDamage(int damageAmount)
	{
		health = health - damageAmount;
	}

	public void attack(Entity e)
	{
		
	}
	
	@Override
	public String toString()
	{
		return "Player";
	}
	
	

}
