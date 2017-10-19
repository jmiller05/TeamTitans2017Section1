import java.util.ArrayList;

public class Item {

	protected int itemID;
	protected String itemName;
	protected String itemDescription;
	protected ArrayList<Room> locations = new ArrayList<Room>();
	protected Monster droppedBy;

}
