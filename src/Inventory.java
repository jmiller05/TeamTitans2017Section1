
/**
 * 
 */

/**
 * @author Brad
 *
 */
public class Inventory extends Item
{
	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * @param droppedBy
	 * @param foundIn
	 */
	public Inventory(String itemID, String itemName, String itemDescription, Monster droppedBy, Room foundIn)
	{
		super(itemID, itemName, itemDescription, droppedBy, foundIn);
		// TODO Auto-generated constructor stub
	}

	private static final int MAX_INVENTORY_SIZE = 50;
	private Item[] items = new Item[MAX_INVENTORY_SIZE];
	
	  
	  public boolean addItem(Item item) {
          int slot = findFreeSlot();
          if (slot >= 0) {
              items[slot] = item;
          }
		return false;
    }

	     public Item removeItem(Item item) {
	           for (int i=0;i<items.length;i++) {
	                if (items[i].equals(item)) {
	                      Item temp = items[i];
	                      items[i] = null;
	                      return temp;
	                      
	                }
	            }

	            return null;
	     }


	     public int getInventorySize() {
	             return MAX_INVENTORY_SIZE;
	             
	             
	     }

	     private int findFreeSlot() {
	          for (int i=0;i<items.length;i++) {
	               if (items[i] == null) {
	                    return i;
	               }
	          }

	          return -1;
	     }
	}
