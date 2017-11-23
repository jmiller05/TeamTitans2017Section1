import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Entity 
{
	
	protected int health;
	protected int maxHealth;
	protected DoubleProperty healthPercentage;
	protected int damage;
	protected Room location;
	
	public Entity()
	{
	}
	
	public Entity(int health, int damage)
	{
		this.health = health;
		this.damage = damage;
		this.healthPercentage = new SimpleDoubleProperty((double)this.health/this.maxHealth);
		
	}
	
	public Entity(int health, int maxHealth, int damage)
	{
		this.health = health;
		this.maxHealth = maxHealth;
		this.damage = damage;
		this.healthPercentage = new SimpleDoubleProperty((double)this.health/this.maxHealth);
	}
	
	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public int getMaxHealth()
	{
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}

	public DoubleProperty getHealthPercentage()
	{
		return healthPercentage;
	}

	public void setHealthPercentage(DoubleProperty healthPercentage)
	{
		this.healthPercentage = healthPercentage;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	
	public void attack(Entity e, int dam) 
	{
		e.takeDamage(dam);
	}
	
	public void restoreHealth(int amt) throws InvalidHealthException
	{
		if(health + amt > maxHealth) throw new InvalidHealthException("You can't add that much health!");
		else
		{
			this.health += amt;
			healthPercentage.set((double)health/maxHealth);
		}
		
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
	
	public void winFight() 
	{
		
	}
	
	public void loseFight() 
	{
		
	}
	
}
