import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player extends Entity
{
	private Room currentRoom;
	private ArrayList<Item> inventory;
	private int maxHealth;
	private int health;
	private DoubleProperty healthPercentage;
	
	
	public Player()
	{
		super(10, 10);
		
		inventory = new ArrayList<Item>();
		maxHealth = 10;
		
		
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
		return this.maxHealth;
	}
	
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}
	
	public DoubleProperty getHealthPercentage()
	{
		healthPercentage = new SimpleDoubleProperty(health/maxHealth);
		
		return healthPercentage;
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
	
	public void adjustHealth(int amt)
	{
		health += amt;
		healthPercentage.set((double)health/maxHealth);
	}
	
	@Override
	public String toString()
	{
		return "Player";
	}
	
	
	
}
