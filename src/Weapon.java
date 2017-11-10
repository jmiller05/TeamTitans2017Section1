	/**
	 * @author Brad
	 *
	 */

public class Weapon extends Item {

	
	private int damage;
	
	
	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * @param droppedBy
	 */
	public Weapon(String itemID, String itemName, String itemDescription, int damage, Monster droppedBy, Room foundIn)
	{
		super(itemID, itemName, itemDescription, droppedBy, foundIn);
		this.damage = damage;
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
