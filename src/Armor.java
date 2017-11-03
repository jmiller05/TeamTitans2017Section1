public class Armor extends Item {

	private int armor;
	
	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * @param droppedBy
	 */
	public Armor(int itemID, String itemName, String itemDescription, Monster droppedBy, int armor)
	{
		super(itemID, itemName, itemDescription, droppedBy);
		this.armor = armor;
	}

}
