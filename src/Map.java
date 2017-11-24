import javafx.scene.image.ImageView;

public class Map extends Item implements ArtifactInterface {
	
	private ImageView map;
	
	public Map(int itemID, String itemName, String itemDescription)
	{
		super(itemID, itemName, itemDescription);
		this.map = null;
	}

	public Map(int itemID, String itemName, String itemDescription, ImageView map)
	{
		super(itemID, itemName, itemDescription);
		this.map = map;
	}
	
	public void setmap(ImageView map)
	{
		this.map = map;
	}
	
	public ImageView getMap()
	{
		return map;
	}

	@Override
	public void useItem()
	{
		map.setVisible(true);
	}
}
