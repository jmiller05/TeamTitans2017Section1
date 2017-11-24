import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class Room implements Serializable
{
	static final long serialVersionUID = 297;
	
	private int roomID;
	private String roomName;
	private String roomDescription;
	private transient Image mapLocation;
	private Exit northExit;
	private Exit southExit;
	private Exit eastExit;
	private Exit westExit;
	private Exit northEastExit;
	private Exit northWestExit;
	private Exit southEastExit;
	private Exit southWestExit;
	private ArrayList<Item> items;

	public Room(int roomID, String roomName, String roomDescription)
	{
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomDescription = roomDescription;
		northExit = null;
		southExit = null;
		eastExit = null;
		westExit = null;
		northEastExit = null;
		northWestExit = null;
		southEastExit = null;
		southWestExit = null;
	}
	
	public void setMapLocationImage(Image image)
	{
		mapLocation = image;
	}
	
	public Image getMapLocationImage()
	{
		return mapLocation;
	}
	
	public void setExit(Exit exit, String direction)
	{
		if(direction.equalsIgnoreCase("north")){this.setNorthExit(exit);};
		if(direction.equalsIgnoreCase("south")){this.setSouthExit(exit);};
		if(direction.equalsIgnoreCase("east")){this.setEastExit(exit);};
		if(direction.equalsIgnoreCase("west")){this.setWestExit(exit);};
		if(direction.equalsIgnoreCase("northeast")){this.setNorthEastExit(exit);};
		if(direction.equalsIgnoreCase("northwest")){this.setNorthWestExit(exit);};
		if(direction.equalsIgnoreCase("southeast")){this.setSouthEastExit(exit);};
		if(direction.equalsIgnoreCase("southwest")){this.setSouthWestExit(exit);};
	}
	
	public int getRoomID()
	{
		return roomID;
	}
	
	public String getRoomDescription()
	{
		return roomDescription;
	}
	
	public void setNorthExit(Exit northExit)
	{
		this.northExit = northExit;
	}
	
	public void setSouthExit(Exit southExit)
	{
		this.southExit = southExit;
	}
	
	public void setEastExit(Exit eastExit)
	{
		this.eastExit = eastExit;
	}
	
	public void setWestExit(Exit westExit)
	{
		this.westExit = westExit;
	}
	
	public void setNorthEastExit(Exit northEastExit)
	{
		this.northEastExit = northEastExit;
	}
	
	public void setNorthWestExit(Exit northWestExit)
	{
		this.northWestExit = northWestExit;
	}
	
	public void setSouthEastExit(Exit southEastExit)
	{
		this.southEastExit = southEastExit;
	}
	
	public void setSouthWestExit(Exit southWestExit)
	{
		this.southWestExit = southWestExit;
	}
	
	public Exit getNorthExit()
	{
		return northExit;
	}
	
	public Exit getSouthExit()
	{
		return southExit;
	}
	
	public Exit getEastExit()
	{
		return eastExit;
	}
	
	public Exit getWestExit()
	{
		return westExit;
	}
	
	public Exit getNorthEastExit()
	{
		return northEastExit;
	}
	
	public Exit getNorthWestExit()
	{
		return northWestExit;
	}
	
	public Exit getSouthEastExit()
	{
		return southEastExit;
	}
	
	public Exit getSouthWestExit()
	{
		return southWestExit;
	}
	
	public boolean hasItem()
	{
		if(items == null){return false;}
		else{return true;}
	}
	
	public Item getItem()
	{
		return items.get(0);
	}
	
	public ArrayList getItemList()
	{
		return items;
	}
	
	public void removeItem(int index)
	{
		items.remove(index);
	}
	
	public void addItem(Item item)
	{
		if(items == null){items = new ArrayList<Item>();}
		items.add(item);
	}
	
	public Room getAdjacentRoom(Exit exit)
	{
		if(this == exit.getRoomA())
		{
			return exit.getRoomB();
		}
		else
		{
			return exit.getRoomA();
		}
	}
	
	public boolean isValidExit(String direction)
	{
		boolean validExit = false;
		if(direction.equalsIgnoreCase("north") && northExit != null){validExit = true;};
		if(direction.equalsIgnoreCase("south") && southExit != null){validExit = true;};
		if(direction.equalsIgnoreCase("east") && eastExit != null){validExit = true;};
		if(direction.equalsIgnoreCase("west") && westExit != null){validExit = true;};
		if(direction.equalsIgnoreCase("northeast") && northEastExit != null){validExit = true;};
		if(direction.equalsIgnoreCase("northwest") && northWestExit != null){validExit = true;};
		if(direction.equalsIgnoreCase("southeast") && southEastExit != null){validExit = true;};
		if(direction.equalsIgnoreCase("southwest") && southWestExit != null){validExit = true;};
		return validExit;
	}
	
	public static void assignExits(Exit exit, Room roomA, String directionA, Room roomB, String directionB)
	{
		exit.setRoomA(roomA);
		exit.setRoomB(roomB);
		roomA.setExit(exit, directionA);
		roomB.setExit(exit, directionB);
	}
	
	public static ArrayList<Room> readRooms(String filename)
	{
		
		ArrayList<Room> rooms = null;
		
		try
		{
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			rooms = (ArrayList<Room>) ois.readObject();
			ois.close();
			fis.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
		}
		
		return rooms;
	}

}
