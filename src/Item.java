import java.util.ArrayList;

public class Item {

	protected static String itemID;
	protected static String itemName;
	protected static String itemDescription;
	protected static int itemBonus;
	private ArrayList<Room> locations = new ArrayList<Room>();
	protected static Monster droppedBy;

	public Item(String itemID, String itemName, String itemDescription, Monster droppedBy) {
		Item.itemID = itemID;
		Item.itemName = itemName;
		Item.itemDescription = itemDescription;
		Item.droppedBy = droppedBy;
	}


	
	
	/**
	 * @return the itemID
	 */
	public String getItemID()
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
	public int getItemBonus()
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
	 * @return the droppedBy
	 */
	public Monster getDroppedBy()
	{
		return droppedBy;
	}
	
	
}
