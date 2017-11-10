import java.util.ArrayList;


/**
 * @author Brad
 *
 */

public class Item {
	
	protected String itemID;
	protected String itemName;
	protected String itemDescription;
	private ArrayList<Room> locations = new ArrayList<Room>();
	protected Monster droppedBy;
	protected Room foundIn;
	
	public Item(String itemID, String itemName, String itemDescription, Monster droppedBy, Room foundIn) {//need to add room location where item found
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.droppedBy = droppedBy;
		this.foundIn = foundIn;
	}
	
	/**
	 * @return the foundIn
	 */
	public Room getFoundIn()
	{
		return foundIn;
	}

	/**
	 * @param foundIn the foundIn to set
	 */
	public void setFoundIn(Room foundIn)
	{
		this.foundIn = foundIn;
	}

	public void dropItem()
	{
		
	}
	
	public void collectItem()
	{
		
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
	 * @return the locations
	 */
	public ArrayList<Room> getLocations()
	{
		return locations;
	}
	
	/**
	 * @return the droppedBy
	 */
	public  Monster getDroppedBy()
	{
		return droppedBy;
	}
	
	
}
