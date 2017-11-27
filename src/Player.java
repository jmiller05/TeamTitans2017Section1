import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Player extends Entity implements Serializable
{
	/**
	 * the player's current room
	 */
	private Room currentRoom;
	
	private Weapon equippedWeapon;
	
	/**
	 * the player's inventory
	 */
	//private ArrayList<Item> inventory;
	
	transient ObservableList<Item> inventory;
	
	
	/**
	 * Constructor for Player
	 * 
	 * @param health
	 * @param damage
	 */
	public Player(int health, int damage)
	{
		super(health, damage);
		this.inventory = FXCollections.observableArrayList();	
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
		this.inventory = FXCollections.observableArrayList();
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
	public ObservableList<Item> getInventory()
	{
		return inventory;
	}
	
	/**
	 * Sets the player's inventory
	 * 
	 * @param inventory the ArrayList to set
	 */
	public void setInventory(ObservableList<Item> inventory)
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
		if(item.getClass().getName().equalsIgnoreCase("weapon"))
		{
			this.equipWeapon((Weapon)item);
		}
		//if(item.getClass().getName().equalsIgnoreCase("weapon") && ((Weapon)item).getDamage() < this.getDamage()){this.equipWeapon((Weapon)item);}
	}
	
	public void pickupItem(int index)
	{
		this.addItemToInventory(this.currentRoom.getItem(index));
		this.currentRoom.removeItem(this.currentRoom.getItemList().indexOf(this.currentRoom.getItem(index)));
		this.currentRoom.removeSearchResult(index);
		
	}
	
	public void equipWeapon(Weapon weapon)
	{
		if(equippedWeapon != null && weapon.getDamage() > equippedWeapon.getDamage())
		{
			this.equippedWeapon = weapon;
		}
		else if(equippedWeapon == null)
		{
			this.equippedWeapon = weapon;
		}	
		this.setDamage(equippedWeapon.getDamage());
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
