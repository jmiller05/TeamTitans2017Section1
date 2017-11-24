	/**
	 * @author Brad
	 *
	 */

public class Weapon extends Item {

	
	protected int damage;

	public Weapon(int itemID, String itemName, String itemDescription)
	{
		super(itemID, itemName, itemDescription);
		damage = 1;
	}
	
	public Weapon(int itemID, String itemName, String itemDescription, int damage)
	{
		super(itemID, itemName, itemDescription);
		this.damage = damage;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	

}
