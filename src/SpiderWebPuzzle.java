import javafx.scene.control.TextArea;

/**
 * 
 */

/**
 * @author Evan
 *
 */
public class SpiderWebPuzzle extends Puzzle implements PuzzleInterface
{
	private Exit lockedExit;
	private Item ironKey;
	private TextArea text;
	private String solvedMessage;
	private Player player;
	private boolean firstWebDestroyed;
	private boolean secondWebDestroyed;
	private boolean thirdWebDestroyed;
	
	/**
	 * @param ID
	 * @param name
	 * @param desc
	 * @param hi
	 */
	public SpiderWebPuzzle(String ID, String name, String desc, String hi)
	{
		super(ID, name, desc, hi);
		firstWebDestroyed = false;
		secondWebDestroyed = false;
		thirdWebDestroyed = false;
		// TODO Auto-generated constructor stub
	}
	
	public SpiderWebPuzzle(String ID, String name, String desc, String hi, Exit exit)
	{
		super(ID, name, desc, hi);
		this.lockedExit = exit;
		lockedExit.lockExit();
		firstWebDestroyed = false;
		secondWebDestroyed = false;
		thirdWebDestroyed = false;
		// TODO Auto-generated constructor stub
	}
	
	public Exit getLockedExit()
	{
		return lockedExit;
	}
	
	public void setLockedExit(Exit exit)
	{
		this.lockedExit = exit;
		lockedExit.lockExit();
	}
	
	public void setLockedDescription(String lockedDescrption)
	{
		lockedExit.setLockDescription(lockedDescrption);
	}

	public Item getIronKey()
	{
		return ironKey;
	}

	public void setIronKey(Item ironKey)
	{
		this.ironKey = ironKey;
	}

	public TextArea getText()
	{
		return text;
	}

	public void setText(TextArea text)
	{
		this.text = text;
	}

	public String getSolvedMessage()
	{
		return solvedMessage;
	}

	public void setSolvedMessage(String solvedMessage)
	{
		this.solvedMessage = solvedMessage;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	/* (non-Javadoc)
	 * @see PuzzleInterface#triggerPuzzle()
	 */
	@Override
	public void triggerPuzzle()
	{
		// TODO Auto-generated method stub
		//solvePuzzle();
		
		System.out.println("Spider Web Puzzle Triggered!");
		if(!firstWebDestroyed)
		{
			firstWebDestroyed = true;
			text.appendText("\n" + "\n" + "You start clearing some of the spiderwebs");
		}
		else if(!secondWebDestroyed)
		{
			secondWebDestroyed = true;
			text.appendText("\n" + "\n" + "You clear more of the spiderwebs");
		}
		else if(!thirdWebDestroyed)
		{
			thirdWebDestroyed = true;
			text.appendText("\n" + "\n" + "after destroying the spider webs an iron key falls out!");
			player.getInventory().add(ironKey);
			this.setTriggerType("navigation");
			this.setAutoNavigate(true);
		}
		else if(player.getInventory().contains(ironKey))
		{
			solvePuzzle();
		}
		
	}

	/* (non-Javadoc)
	 * @see PuzzleInterface#solvePuzzle()
	 */
	@Override
	public void solvePuzzle()
	{
		// TODO Auto-generated method stub
		if(player.getInventory().contains(ironKey))
		{
			lockedExit.unlockExit();
			text.appendText(solvedMessage);
			player.getInventory().remove(ironKey);
			this.isSolved=true;
		}
	}
	
}
