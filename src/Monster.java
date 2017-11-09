import java.util.ArrayList;

public class Monster extends Entity 
{
	private String monsterID;
	private String monsterName;
	private String description;
	private ArrayList<Room> location = new ArrayList<Room>();
	private ArrayList<Item> itemDropped = new ArrayList<Item>();
	
	
	
	public Monster(String ID, String name, String desc, int health, int damage)
	{
		super(health, damage);
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
	
	
	public void attack(Entity e)
	{
		super.attack(e);
	}
	
	@Override
	public void receiveDamage()
	{
		super.receiveDamage();
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
}
