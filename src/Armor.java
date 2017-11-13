/**
 * @author Brad
 *
 */

public class Armor extends Item {
	
	private int armor;
	
	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * @param droppedBy
	 */
	public Armor(String itemID, String itemName, String itemDescription, int armor, Monster droppedBy, Room foundIn)
	{
		super(itemID, itemName, itemDescription, droppedBy, foundIn);
		// TODO Auto-generated constructor stub
		
		this.armor = armor;
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
}
