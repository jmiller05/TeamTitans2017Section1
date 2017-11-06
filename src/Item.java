import java.util.ArrayList;

public class Item {

	protected String itemID;
	protected String itemName;
	protected String itemDescription;
	protected int itemBonus;
	private ArrayList<Room> locations = new ArrayList<Room>();
	protected static Monster droppedBy;

	public Item(String itemID, String itemName, String itemDescription, int itemBonus, Monster droppedBy) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemBonus = itemBonus;
		this.droppedBy = droppedBy;
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
	public static Monster getDroppedBy()
	{
		return droppedBy;
	}


}
