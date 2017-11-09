import java.util.ArrayList;


/**
 * @author Brad
 *
 */

public class Armor extends Item {
	
	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * @param droppedBy
	 */
	public Armor(String itemID, String itemName, String itemDescription, int itemBonus, Monster droppedBy)
	{
		super(itemID, itemName, itemDescription, itemBonus, droppedBy);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Armor> ArmorArray = new ArrayList<Armor>();

	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * @param itemBonus 
	 */
	

	
	public void populateArmor() {
		
		Armor amr1 = new Armor ("Amr01", "Cloth Armor", "Rugged clothes from your village", 10, null);
		Armor amr2 = new Armor ("Amr02", "Leather Armor", "Armor crafted from deer skin", 10, null);
		Armor amr3 = new Armor ("Amr03", "Chainmail Armor", "Armor with many iron links woven together", 10, null);
		Armor amr4 = new Armor ("Amr04", "Plate Armor", "Armor forged from steel", 10, null);
		
		ArmorArray.add(amr1); 
		ArmorArray.add(amr2);
		ArmorArray.add(amr3);
		ArmorArray.add(amr4);
	}

	/**
	 * @return the armorArray
	 */
	public ArrayList<Armor> getArmorArray()
	{
		return ArmorArray;
	}
	
}
