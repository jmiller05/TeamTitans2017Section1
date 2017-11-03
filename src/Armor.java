import java.util.ArrayList;

public class Armor extends Item {
	
	private ArrayList<Armor> ArmorArray = new ArrayList<Armor>();

	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * @param itemBonus 
	 */
	public Armor(String ID, String Name, String Description, int Bonus)//need room location of item
	{
		super(itemID,itemName,itemDescription,droppedBy);
		Item.itemID = ID;
		Item.itemName = Name;
		Item.itemDescription = Description;
		Item.itemBonus = Bonus;
		
	}

	
	public void populateItems() {
		
		Armor amr1 = new Armor ("Amr01", "Cloth Armor", "Rugged clothes from your village", 10);
		Armor amr2 = new Armor ("Amr02", "Leather Armor", "Armor crafted from deer skin", 10);
		Armor amr3 = new Armor ("Amr03", "Chainmail Armor", "Armor with many iron links woven together", 10);
		Armor amr4 = new Armor ("Amr04", "Plate Armor", "Armor forged from steel", 10);
		
		ArmorArray.add(amr1); 
		ArmorArray.add(amr2);
		ArmorArray.add(amr3);
		ArmorArray.add(amr4);
	}
	
	/**
	 * @return the armorRating
	 */
	public int getArmorRating()
	{
		return getArmorRating();
	}

	/**
	 * @param armorRating the armorRating to set
	 */
	public void setArmorRating(int armorRating)
	{
	}

}
