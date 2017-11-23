import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Entity {
	
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
		
		System.out.println("The max health input for the entity is: " + maxHealth);
		System.out.println("The health input for the entity is: " + health);
		System.out.println("The max health value for the entity is: " + this.maxHealth);
		System.out.println("The health value for the entity is: " + this.health);
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
	
	public void attack(Entity e) 
	{
		
	}
	
	public void restoreHealth(int amt)
	{
		this.health += amt;
		healthPercentage.set((double)health/maxHealth);
	}
	
	public void takeDamage(int damage)
	{
		health -= damage;
		healthPercentage.set((double)health/maxHealth);
	}
	
	public void winFight() 
	{
		
	}
	
	public void loseFight() 
	{
		
	}
	
}
