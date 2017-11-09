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
	public Weapon(int itemID, String itemName, String itemDescription, Monster droppedBy, int damage)
	{
		super(itemID, itemName, itemDescription, droppedBy);
		this.damage = damage;
	}

	

}
