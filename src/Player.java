import java.util.ArrayList;


public class Player extends Entity
{
	
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	/**
	 * Add item to inventory
	 * @param item
	 */
    public void addItem(Item item)
    {
        inventory.add(item);
    }
    
    /**
     * Remove item from inventory
     * @param item
     */
    public void removeItem(int item)
    {
        inventory.remove(item);
    }
    
    /**
     * Return inventory item
     * @param int
     */
    public Item getInventoryItem(int item)
    {
        return inventory.get(item);
    }
    
    /**
     * Return the size of the item inventory
     * @return int
     */
    public int getInventorySize()
    {
        return inventory.size();
    }
    
    /**
     * Return the full inventory list
     * @return ArrayList
     */
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
    
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
