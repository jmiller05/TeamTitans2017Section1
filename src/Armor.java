/**
 * @author Brad
 * @author Evan
 * This class describes an Armor item and extends the abstract item class
 */

public class Armor extends Item
{
	
	/**
	 * This int attribute describes the amount of armor an armor object provides
	 */
	protected int armor;

	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * Armor constructor which also calls the item constructor and this constructor lacks an armor parameter but initializes the armor attribute to 1
	 */
	public Armor(int itemID, String itemName, String itemDescription)
	{
		super(itemID, itemName, itemDescription);
		armor = 1;
	}
	
	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * @param armor
	 * Armor constructor which includes the armor parameter to set the armor attribute and also calls the item super constructor
	 */
	public Armor(int itemID, String itemName, String itemDescription, int armor)
	{
		super(itemID, itemName, itemDescription);
		this.armor = armor;
	}

	/**
	 * @return the value of the int armor attribute
	 */
	public int getArmor()
	{
		return armor;
	}

	/**
	 * @param armor
	 * allows the setting of the int armor attribute outside of the constructor
	 */
	public void setArmor(int armor)
	{
		this.armor = armor;
	}
}
