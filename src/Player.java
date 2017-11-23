import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player extends Entity
{
	private Room currentRoom;
	private ArrayList<Item> inventory;
	//private int maxHealth;
	//private int health;
	//private DoubleProperty healthPercentage;
	
	
	public Player()
	{
		super();
		this.inventory = new ArrayList<Item>();
	}
	
	public Player(int health, int damage)
	{
		super(health, damage);
		this.inventory = new ArrayList<Item>();
		//System.out.println(this.health/this.maxHealth);
		
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
	public String toString()
	{
		return "Player";
	}
	
	
	
}
