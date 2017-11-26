import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author Evan
 *
 */
public class RunePuzzle extends Puzzle implements PuzzleInterface
{
	private boolean emeraldRuneInserted;
	private boolean sapphireRuneInserted;
	private Artifact emeraldRune;
	private Artifact sapphireRune;
	private Exit runeDoor;
	


	/**
	 * @param ID
	 * @param name
	 * @param desc
	 * @param hi
	 */
	public RunePuzzle(String ID, String name, String desc, String hi)
	{
		super(ID, name, desc, hi);
		// TODO Auto-generated constructor stub
	}
	
	public void setRuneDoor(Exit runeDoor)
	{
		this.runeDoor = runeDoor;
		runeDoor.lockExit();
	}
	
	public void setRuneDoor(Exit runeDoor, String lockDescription)
	{
		this.runeDoor = runeDoor;
		runeDoor.lockExit();
		runeDoor.setLockDescription(lockDescription);
	}
	
	public void setEmeraldRune(Artifact emeraldRune)
	{
		this.emeraldRune = emeraldRune;
	}
	
	public void setSapphireRune(Artifact sapphireRune)
	{
		this.sapphireRune = sapphireRune;
	}
	
	public boolean isEmeraldRuneInserted()
	{
		return emeraldRuneInserted;
	}
	
	public boolean isSapphireRuneInserted()
	{
		return sapphireRuneInserted;
	}
	
	public void insertEmeraldRune()
	{
		emeraldRuneInserted = true;
	}
	
	public void insertSapphireRune()
	{
		sapphireRuneInserted = true;
	}

	public void setEmeraldRuneInserted(boolean emeraldRuneInserted)
	{
		this.emeraldRuneInserted = emeraldRuneInserted;
	}

	public void setSapphireRuneInserted(boolean sapphireRuneInserted)
	{
		this.sapphireRuneInserted = sapphireRuneInserted;
	}
	
	public boolean playerHasEmeraldRune(Player player)
	{
		
		if(player.getInventory().indexOf(emeraldRune) != -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean playerHasSapphireRune(Player player)
	{
		if(player.getInventory().indexOf(sapphireRune) != -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

	/* (non-Javadoc)
	 * @see PuzzleInterface#triggerPuzzle()
	 */
	@Override
	public void triggerPuzzle()
	{

	}

	/* (non-Javadoc)
	 * @see PuzzleInterface#solvePuzzle()
	 */
	@Override
	public void solvePuzzle()
	{
		// TODO Auto-generated method stub
		this.isSolved = true;
		runeDoor.unlockExit();
		
	}
	
}
