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
	
	static final long serialVersionUID = 300;
	
	protected int itemID;
	protected String itemName;
	protected String itemDescription;
	
	public Item(int itemID, String itemName, String itemDescription)
	{
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}

	public int getItemID()
	{
		return itemID;
	}

	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public String getItemDescription()
	{
		return itemDescription;
	}

	public void setItemDescription(String itemDescription)
	{
		this.itemDescription = itemDescription;
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