/**
 * @author Brad
 *
 */

public class Armor extends Item
{
	
	protected int armor;

	public Armor(int itemID, String itemName, String itemDescription)
	{
		super(itemID, itemName, itemDescription);
		armor = 1;
	}
	
	public Armor(int itemID, String itemName, String itemDescription, int armor)
	{
		super(itemID, itemName, itemDescription);
		this.armor = armor;
	}

	public int getArmor()
	{
		return armor;
	}

	public void setArmor(int armor)
	{
		this.armor = armor;
	}
}
