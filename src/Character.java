
/**
 * @author Jesse Miller
 * @date 10/11/2017
 *
 */
public class Character
{
	public int		health;
	public int		armor;
	public int		damage;
	
	public Character(String s)
	{
		health = 100;
		armor = 2;
		damage = 10;
	}
	
	/**
	 * @return the health
	 */
	public int getHealth()
	{
		return health;
	}
	
	/**
	 * @param health the health to set
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	/**
	 * @return the armor
	 */
	public int getArmor()
	{
		return armor;
	}
	
	/**
	 * @param armor the armor to set
	 */
	public void setArmor(int armor)
	{
		this.armor = armor;
	}
	
	/**
	 * @return the damage
	 */
	public int getDamage()
	{
		return damage;
	}
	
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	
}
