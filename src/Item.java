import java.util.ArrayList;

public class Item {

	private int itemID;
	private String itemName;
	private String itemDescription;
	protected String itemBonus;
	private ArrayList<Room> locations = new ArrayList<Room>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private Monster droppedBy;

	public Item(int itemID, String itemName, String itemDescription, String itemBonus, Monster droppedBy) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemBonus = itemBonus;
	}

	/**
	 * @return the itemID
	 */
	public int getItemID()
	{
		return itemID;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName()
	{
		return itemName;
	}

	/**
	 * @return the itemDescription
	 */
	public String getItemDescription()
	{
		return itemDescription;
	}
	
	/**
	 * @return the itemBonus
	 */
	public String getItemBonus()
		{
		return itemBonus;
	}
	
	/**
	 * @return the locations
	 */
	public ArrayList<Room> getLocations()
	{
		return locations;
	}

	/**
	 * @return the items
	 */
	public ArrayList<Item> getItems()
	{
		return items;
	}

	/**
	 * @return the droppedBy
	 */
	public Monster getDroppedBy()
	{
		return droppedBy;
	}
	
	
}
