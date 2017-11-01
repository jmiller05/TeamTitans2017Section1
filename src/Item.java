import java.util.ArrayList;

public class Item {

	private int itemID;
	private String itemName;
	private String itemDescription;
	private ArrayList<Room> locations = new ArrayList<Room>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private Monster droppedBy;

	public Item(int itemID, String itemName, String itemDescription, Monster droppedBy) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
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
