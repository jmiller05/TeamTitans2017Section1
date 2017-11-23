import javafx.beans.property.IntegerProperty;

public class Entity {
	
	protected int health;
	protected int damage;
	protected Room location;
	
	public Entity()
	{
		//super();
	}
	
	public Entity(int health, int damage)
	{
		super();
		this.health = health;
		this.damage = damage;
	}
	
	public int getDamage()
	{
		return this.damage;
	}
	
	public int getHealth()
	{
		return this.health;
	}
	
	public void attack(Entity e) 
	{
		
	}
	
	public void adjustHealth(int amt)
	{
		this.health += amt;
	}
	
	public void winFight() 
	{
		
	}
	
	public void loseFight() 
	{
		
	}
	
}
