import java.util.ArrayList;

public class Player
{
	private Room currentRoom;
	private ArrayList<Item> inventory;
	
	public Player()
	{
		//System.out.println("I exist");
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
