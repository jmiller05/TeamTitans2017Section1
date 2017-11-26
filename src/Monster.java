import java.util.ArrayList;
import java.util.Random;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class Monster extends Entity implements Serializable
{	
	/**
	 * the serial ID for serialization
	 */
	private static final long serialVersionUID = 663865483373657824L;
	
	/**
	 * the monster's unique ID
	 */
	private String monsterID;
	
	/**
	 * the monster's name
	 */
	private String monsterName;
	
	/**
	 * the monster's description
	 */
	private String description;
	
	/**
	 * the monster's list of possible locations
	 */
	private ArrayList<Room> location = new ArrayList<Room>();
	//private ArrayList<Item> itemDropped = new ArrayList<Item>();
	
	Random rand;
	
	private int randomIndex;

	private Item itemDropped;
	
	public Monster(String ID, String name, String desc, int health, int damage, Item itemDropped)
	{
		super(health, damage);
		this.monsterID = ID;
		this.monsterName = name;
		this.description = desc;
		this.itemDropped = itemDropped;
	}
	
	/**
	 * @return the itemDropped
	 */
	public Item getItemDropped()
	{
		return itemDropped;
	}

	/**
	 * @param itemDropped the itemDropped to set
	 */
	public void setItemDropped(Item itemDropped)
	{
		this.itemDropped = itemDropped;
	}

	/**
	 * @return the monster's name
	 */
	public String getMonsterName()
	{
		return this.monsterName;
	}
	
	/**
	 * @return the mosnter's ID
	 */
	public String getMonsterID()
	{
		return this.monsterID;
	}
	
	/**
	 * @return the monster's description
	 */
	public String getMonsterDescription()
	{
		return this.description;
	}
	
	/**
	 * Chooses a random location to spawn in from the monster's list of locations
	 * 
	 * @return the monster's location
	 */
	public int getLocation()
	{
		return location.get(randomIndex).getRoomID();		
	}
	
	public void setRandomIndex()
	{
		rand = new Random();
		this.randomIndex = rand.nextInt(location.size());
	}
	
	
	/**
	 * adds a room to the monster's locations
	 * 
	 * @param room the room to add
	 */
	public void addLocation(Room room)
	{
		location.add(room);
	}
	
	//	public void addItem(Item item)
	//	{
	//		itemDropped.add(item);
	//	}
	
	/** 
	 * Displays that the user has died (the monster wins the fight)
	 * 
	 * @return the message
	 */
	@Override
	public String winFight()
	{
		return "You have died.";
	}
	
	/**
	 * @param filename the filename to read
	 * 
	 * @return an arrayList of monsters
	 */
	public static ArrayList<Monster> readMonsters(String filename)
	{
		ArrayList<Monster> mAL = null;
		
		try
		{
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			mAL =  (ArrayList<Monster>) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
		}
		
		for (int i = 0; i < mAL.size(); i ++)
		{
			mAL.get(i).setRandomIndex();
		}
		return mAL;
	}	
}