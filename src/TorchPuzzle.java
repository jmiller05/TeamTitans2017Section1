import javafx.scene.control.TextArea;

/**
 * 
 */

/**
 * @author Evan
 *
 */
public class TorchPuzzle extends Puzzle implements PuzzleInterface
{
	private Exit lockedExit;
	private Item torch;
	private TextArea text;
	private String solvedMessage;
	private Player player;
	
	/**
	 * @param ID
	 * @param name
	 * @param desc
	 * @param hi
	 */
	public TorchPuzzle(String ID, String name, String desc, String hi)
	{
		super(ID, name, desc, hi);
		// TODO Auto-generated constructor stub
	}
	
	public TorchPuzzle(String ID, String name, String desc, String hi, Exit exit)
	{
		super(ID, name, desc, hi);
		this.lockedExit = exit;
		lockedExit.lockExit();
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

	public Item getTorch()
	{
		return torch;
	}

	public void setTorch(Item torch)
	{
		this.torch = torch;
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
		solvePuzzle();
		
	}

	/* (non-Javadoc)
	 * @see PuzzleInterface#solvePuzzle()
	 */
	@Override
	public void solvePuzzle()
	{
		// TODO Auto-generated method stub
		if(player.getInventory().indexOf(torch) != -1)
		{
			lockedExit.unlockExit();
			text.appendText(solvedMessage);
			this.isSolved=true;
		}
		
		System.out.println(player.getInventory().indexOf(torch));
		
		
		
	}
	
}
