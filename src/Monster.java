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
	
	public void getMonsterName()
	{
		System.out.println(this.monsterName);
	}
	
	public void getMonsterID()
	{
		System.out.println(this.monsterID);
	}
	
	public void getMonsterDescription()
	{
		System.out.println(this.description);
	}
	
	
	public void addItem(Item item)
	{
		itemDropped.add(item);
	}
	
	public void addLocation(Room room)
	{
		location.add(room);
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
