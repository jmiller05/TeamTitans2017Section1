import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author Evan
 *
 */
public class TorchesPuzzle extends Puzzle implements PuzzleInterface
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Exit torchesDoor;
	private boolean firstTorchLit;
	private boolean secondTorchLit;
	private boolean thirdTorchLit;
	private Scene torchesPuzzleScene;
	private Stage torchesStage;
	
	FXMLLoader torchesStageLoader;
	
	


	/**
	 * @param ID
	 * @param name
	 * @param desc
	 * @param hi
	 */
	public TorchesPuzzle(String ID, String name, String desc, String hi)
	{
		super(ID, name, desc, hi);
		// TODO Auto-generated constructor stub
	}
	
	public void setTorchesDoor(Exit torchesDoor)
	{
		this.torchesDoor = torchesDoor;
		torchesDoor.lockExit();
	}
	
	public void setTorchesDoor(Exit torchesDoor, String lockDescription)
	{
		this.torchesDoor = torchesDoor;
		torchesDoor.lockExit();
		torchesDoor.setLockDescription(lockDescription);
	}
	
	public void lightFirstTorch()
	{
		firstTorchLit = true;
	}
	
	public void lightSecondTorch()
	{
		secondTorchLit = true;
	}
	
	public void lightThirdTorch()
	{
		thirdTorchLit = true;
	}
	
	public void unlightFirstTorch()
	{
		firstTorchLit = false;
	}
	
	public void unlightSecondTorch()
	{
		secondTorchLit = false;
	}
	
	public void unlightThirdTorch()
	{
		thirdTorchLit = false;
	}
	
	public boolean firstTorchIsLit()
	{
		return firstTorchLit;
	}
	
	public boolean secondTorchIsLit()
	{
		return secondTorchLit;
	}
	
	public boolean thirdTorchIsLit()
	{
		return thirdTorchLit;
	}
	
	public void setStage(Stage stage)
	{
		this.torchesStage = stage;
	}
	
	public void setScene(Scene scene)
	{
		this.torchesPuzzleScene = scene;
	}
	
    public void initializeTorchesPuzzle(Object controller, String file)
	{
		if(torchesStageLoader == null)
		{
			torchesStageLoader = new FXMLLoader();
			
			if(torchesStageLoader.getRoot() == null)
			{
				torchesStageLoader.setLocation(getClass().getResource(file));
				torchesStageLoader.setController(controller);
				Parent torchesPuzzle = null;
				try {
					torchesPuzzle = torchesStageLoader.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(torchesPuzzleScene == null)
				{
					torchesPuzzleScene = new Scene(torchesPuzzle,600,300);
				}
				else
				{
					torchesPuzzleScene.setRoot(torchesPuzzle);
				}
				//runeStage.setScene(runePuzzleScene);
			}
		}	
	}

	/* (non-Javadoc)
	 * @see PuzzleInterface#triggerPuzzle()
	 */
	@Override
	public void triggerPuzzle()
	{
		torchesStage.setScene(torchesPuzzleScene);
		torchesStage.show();
	}

	/* (non-Javadoc)
	 * @see PuzzleInterface#solvePuzzle()
	 */
	@Override
	public void solvePuzzle()
	{
		// TODO Auto-generated method stub
		if(firstTorchLit && !secondTorchLit && thirdTorchLit)
		{
			this.isSolved = true;
			torchesDoor.unlockExit();
		}
		
	}
	
}
