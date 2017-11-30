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
public class GoldSkullPuzzle extends Puzzle implements PuzzleInterface
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3110401111110899444L;
	
	private boolean firstSkullPlaced;
	private boolean secondSkullPlaced;
	private boolean thirdSkullPlaced;
	private Artifact firstGoldSkull;
	private Artifact secondGoldSkull;
	private Artifact thirdGoldSkull;
	private Scene goldSkullPuzzleScene;
	private Stage goldSkullStage;
	
	FXMLLoader skullStageLoader;
	
	


	/**
	 * @param ID
	 * @param name
	 * @param desc
	 * @param hi
	 */
	public GoldSkullPuzzle(String ID, String name, String desc, String hi)
	{
		super(ID, name, desc, hi);
		// TODO Auto-generated constructor stub
	}
	
	public Artifact getFirstGoldSkull()
	{
		return firstGoldSkull;
	}

	public void setFirstGoldSkull(Artifact firstGoldSkull)
	{
		this.firstGoldSkull = firstGoldSkull;
	}

	public Artifact getSecondGoldSkull()
	{
		return secondGoldSkull;
	}

	public void setSecondGoldSkull(Artifact secondGoldSkull)
	{
		this.secondGoldSkull = secondGoldSkull;
	}

	public Artifact getThirdGoldSkull()
	{
		return thirdGoldSkull;
	}

	public void setThirdGoldSkull(Artifact thirdGoldSkull)
	{
		this.thirdGoldSkull = thirdGoldSkull;
	}

	public boolean isFirstSkullPlaced()
	{
		return firstSkullPlaced;
	}
	
	public boolean isSecondSkullPlaced()
	{
		return secondSkullPlaced;
	}
	
	public boolean isThirdSkullPlaced()
	{
		return thirdSkullPlaced;
	}
	
	public void placeFirstSkull()
	{
		firstSkullPlaced = true;
	}
	
	public void placeSecondSkull()
	{
		secondSkullPlaced = true;
	}
	
	public void placeThirdSkull()
	{
		thirdSkullPlaced = true;
	}

	public void setFirstSkullPlaced(boolean firstSkullPlaced)
	{
		this.firstSkullPlaced = firstSkullPlaced;
	}
	
	public void setSecondSkullPlaced(boolean secondSkullPlaced)
	{
		this.secondSkullPlaced = secondSkullPlaced;
	}
	
	public void setThirdSkullPlaced(boolean thirdSkullPlaced)
	{
		this.thirdSkullPlaced = thirdSkullPlaced;
	}
	
	public boolean playerHasFirstSkull(Player player)
	{
		
		if(player.getInventory().indexOf(firstGoldSkull) != -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean playerHasSecondSkull(Player player)
	{
		
		if(player.getInventory().indexOf(secondGoldSkull) != -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean playerHasThirdSkull(Player player)
	{
		
		if(player.getInventory().indexOf(thirdGoldSkull) != -1)
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
		this.goldSkullStage = stage;
	}
	
	public void setScene(Scene scene)
	{
		this.goldSkullPuzzleScene = scene;
	}
	
    public void initializeGoldSkullPuzzle(Object controller, String file)
	{
		if(skullStageLoader == null)
		{
			skullStageLoader = new FXMLLoader();
			
			if(skullStageLoader.getRoot() == null)
			{
				skullStageLoader.setLocation(getClass().getResource(file));
				skullStageLoader.setController(controller);
				Parent skullPuzzle = null;
				try {
					skullPuzzle = skullStageLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(goldSkullPuzzleScene == null)
				{
					goldSkullPuzzleScene = new Scene(skullPuzzle,600,300);
				}
				else
				{
					goldSkullPuzzleScene.setRoot(skullPuzzle);
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
		//runeStage.setScene(new Scene(runePuzzleRoot,600,300));
		goldSkullStage.setScene(goldSkullPuzzleScene);
		goldSkullStage.show();
	}

	/* (non-Javadoc)
	 * @see PuzzleInterface#solvePuzzle()
	 */
	@Override
	public void solvePuzzle()
	{
		// TODO Auto-generated method stub
		this.isSolved = true;
		
		goldSkullStage.close();
		
		
		
	}
}


