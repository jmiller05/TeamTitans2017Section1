import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class Monster extends Entity implements Serializable
{
	static final long serialVersionUID = 298;
	
	private String monsterID;
	private String monsterName;
	private String description;
	private int health;
	private int damage;
	private ArrayList<Room> location = new ArrayList<Room>();
	private ArrayList<Item> itemDropped = new ArrayList<Item>();
	
	public Monster(String ID, String name, String desc, int health, int damage)
	{
		//		super(health, damage);
		this.monsterID = ID;
		this.monsterName = name;
		this.description = desc;
		this.health = health;
		this.damage = damage;
	}
	
	public String getMonsterName()
	{
		return this.monsterName;
	}
	
	public String getMonsterID()
	{
		return this.monsterID;
	}
	
	public String getMonsterDescription()
	{
		return this.description;
	}
	
	public void addItem(Item item)
	{
		itemDropped.add(item);
	}
	
	public void addLocation(Room room)
	{
		location.add(room);
	}
	
	public int getLocation()
	{
		return location.get(0).getRoomID();		
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public void takeDamage(int damage) 
	{
		
		//		if(health - damage < 0) 
		//		{
		//			healthPercentage.set(0);
		//		}
		//		else
		//		{
		health -= damage;
		//healthPercentage.set((double)health/maxHealth);
		//		}
	}
	
	@Override
	public void winFight()
	{
		super.winFight();
	}
	
	@Override
	public void loseFight()
	{
		super.loseFight();
	}
	

	
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
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
		}
		
		return mAL;
	}
}
