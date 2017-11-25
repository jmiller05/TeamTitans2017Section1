import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Entity 
{	
	/**
	 * the health of the entity
	 */
	protected int health;	
	
	/**
	 * the damage of the entity
	 */
	protected int damage;
	
	/**
	 * the max health of the entity
	 */
	protected int maxHealth;
	
	/**
	 * the entity's percentage of current health / max health
	 */
	protected DoubleProperty healthPercentage;
	
	public Entity()
	{
		this.healthPercentage = new SimpleDoubleProperty((double)this.health/this.maxHealth);
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
	
	
	/**
	 * @return the health of the entity
	 */
	public  int getHealth()
	{
		return this.health;
	}
	
	
	/**
	 * Sets the health of the entity
	 * 
	 * @param health the integer health
	 */
	public void setHealth(int health)
	{
		this.health = health;
		
		
	}
	
	
	/**
	 * @return the entity's max health
	 */
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	
	/**
	 * Sets the entity's max health
	 * 
	 * @param maxHealth the integer max heath
	 */
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}
	
	
	/**
	 * @return the health percentage of the entity
	 */
	public DoubleProperty getHealthPercentage()
	{
		return healthPercentage;
	}
	
	
	/**
	 * Sets the health percentage
	 * 
	 * @param healthPercentage
	 */
	public void setHealthPercentage(DoubleProperty healthPercentage)
	{
		this.healthPercentage = healthPercentage;
	}
	
	
	/**
	 * @return the damage
	 */
	public int getDamage()
	{
		return damage;
	}
	
	/**
	 * Sets an entity's damage
	 * 
	 * @param damage the int damage
	 */
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	
	/**
	 * Attacks another entity with a certain damage
	 * 
	 * @param e the entity to attack
	 * @param dam the damage to deal
	 */
	public void attack(Entity e, int dam) 
	{
		e.takeDamage(dam);
	}
	
	/**
	 * Adds health to the entity's current health. If the amount is greater than
	 * the entity's max health, it will throw an exception.
	 * 
	 * @param amt the int amount to heal
	 * @throws InvalidHealthException
	 */
	public void restoreHealth(int amt) throws InvalidHealthException
	{
		if(health + amt > maxHealth) throw new InvalidHealthException("You can't add that much health!");
		else
		{
			this.health += amt;
			healthPercentage.set((double)health/maxHealth);
		}
		
	}
	
	/**
	 * Removes health from an entity.
	 * 
	 * @param damage the int damage
	 */
	public void takeDamage(int damage) 
	{
		if(health - damage <= 0) 
		{
			health = 0;
			healthPercentage.set(0);
		}
		else
		{
			health -= damage;
			healthPercentage.set((double)health/maxHealth);
		}
	}
	
	/**
	 * @return The message of winning a fight
	 */
	public String winFight() 
	{
		return null;
	}
}
