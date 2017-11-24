import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author Brad
 *
 */

public class Item implements Serializable{
	
	protected String itemID;
	protected String itemName;
	protected String itemDescription;
	private ArrayList<Room> location = new ArrayList<Room>();
	protected Monster droppedBy;
	protected Room foundIn;
	
	public Item(String itemID, String itemName, String itemDescription, Monster droppedBy) {//need to add room location where item found
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.droppedBy = droppedBy;
	}
	
	
	
	/**
	 * @return the foundIn
	 */
	/**public Room getFoundIn()
	{
		return foundIn;
	}
	 */
	/**
	 * @param foundIn the foundIn to set
	 */
	/**public void setFoundIn(Room foundIn)
	{
		this.foundIn = foundIn;
	}*/
	
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
	
	public void addLocation(Room room)
	{
		location.add(room);
	}
	
	/**
	 * @return the locations
	 */
	public int getLocation()
	{
		return location.get(0).getRoomID();		
	}
	
	
	/**
	 * @return the droppedBy
	 */
	public  Monster getDroppedBy()
	{
		return droppedBy;
	}
	
	public static HashMap<Integer, Item> loadItemsInRooms(String filename)
	{
		HashMap<Integer, Item> itemAL = null;
		
		try
		{
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			itemAL = (HashMap<Integer, Item>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (IOException ioe)
		{
			ioe.printStackTrace();
		} catch (ClassNotFoundException c)
		{
			System.out.println("Class not found");
			c.printStackTrace();
		}
		
		return itemAL;
	}
	
	
}