import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

/**
 * 
 */

/**
 * @author Evan
 *
 */
public class PotionBottle extends Item implements ArtifactInterface
{
	private Player player;
	private boolean isFull;
	
	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 */
	public PotionBottle(int itemID, String itemName, String itemDescription)
	{
		super(itemID, itemName, itemDescription);
		player = null;
		isFull = true;
		// TODO Auto-generated constructor stub
	}
	
	public PotionBottle(int itemID, String itemName, String itemDescription, Player player)
	{
		super(itemID, itemName, itemDescription);
		this.player = player;
		isFull = true;
		// TODO Auto-generated constructor stub
	}
	
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public void emptyBottle()
	{
		isFull = false;
	}
	
	public void fillBottle()
	{
		isFull = true;
	}
	
	public boolean isFull()
	{
		return isFull;
	}
	
	@Override
	public void useItem()
	{
		//map.setVisible(true);
		try
		{
			System.out.println("****** " + player.getMaxHealth() +" " +  player.getHealth());
			player.restoreHealth(player.getMaxHealth()-player.getHealth());
			this.emptyBottle();
			
		} catch (InvalidHealthException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
