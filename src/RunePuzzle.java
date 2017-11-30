import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3110401111110899444L;
	
	private boolean emeraldRuneInserted;
	private boolean sapphireRuneInserted;
	private Artifact emeraldRune;
	private Artifact sapphireRune;
	private Exit runeDoor;
	private Exit additionalExit1;
	private Exit additionalExit2;
	//private Parent runePuzzleRoot;
	private Scene runePuzzleScene;
	private Stage runeStage;
	
	FXMLLoader runeStageLoader;
	
	


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
	
	public Exit getAdditionalExit1()
	{
		return additionalExit1;
	}

	public void setAdditionalExit1(Exit additionalExit1)
	{
		this.additionalExit1 = additionalExit1;
		this.additionalExit1.lockExit();
	}

	public Exit getAdditionalExit2()
	{
		return additionalExit2;
	}

	public void setAdditionalExit2(Exit additionalExit2)
	{
		this.additionalExit2 = additionalExit2;
		this.additionalExit2.lockExit();
	}

	public void setEmeraldRune(Artifact emeraldRune)
	{
		this.emeraldRune = emeraldRune;
	}
	
	public Item getEmeraldRune()
	{
		return this.emeraldRune;
	}
	
	public void setSapphireRune(Artifact sapphireRune)
	{
		this.sapphireRune = sapphireRune;
	}
	
	public Item getSapphireRune()
	{
		return this.sapphireRune;
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
	
	public void setStage(Stage stage)
	{
		this.runeStage = stage;
	}
	
	public void setScene(Scene scene)
	{
		this.runePuzzleScene = scene;
	}
	
    public void initializeRunePuzzle(Object controller, String file)
	{
		if(runeStageLoader == null)
		{
			runeStageLoader = new FXMLLoader();
			
			if(runeStageLoader.getRoot() == null)
			{
				runeStageLoader.setLocation(getClass().getResource(file));
				runeStageLoader.setController(controller);
				Parent runePuzzle = null;
				try {
					runePuzzle = runeStageLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(runePuzzleScene == null)
				{
					runePuzzleScene = new Scene(runePuzzle,600,300);
				}
				else
				{
					runePuzzleScene.setRoot(runePuzzle);
				}
			}
		}	
	}

	/* (non-Javadoc)
	 * @see PuzzleInterface#triggerPuzzle()
	 */
	@Override
	public void triggerPuzzle()
	{
		runeStage.setScene(runePuzzleScene);
		runeStage.show();
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
		additionalExit1.unlockExit();
		additionalExit2.unlockExit();
		
		runeStage.close();
	}
}


