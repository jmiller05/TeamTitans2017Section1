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
	private Exit torchesDoor;
	public Stage torchesPuzzleStage;
	


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
		
		VBox anchor = new VBox();
		
		Scene scene = new Scene(anchor, 1300, 700);
		Stage torchesPuzzleStage = new Stage();
		torchesPuzzleStage.setTitle("TorchesPuzzle"); // Set the stage title
		torchesPuzzleStage.setScene(scene); // Place the scene in the stage
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

	/* (non-Javadoc)
	 * @see PuzzleInterface#triggerPuzzle()
	 */
	@Override
	public void triggerPuzzle()
	{
		torchesPuzzleStage.show();
	}

	/* (non-Javadoc)
	 * @see PuzzleInterface#solvePuzzle()
	 */
	@Override
	public void solvePuzzle()
	{
		// TODO Auto-generated method stub
		this.isSolved = true;
		torchesDoor.unlockExit();
		
	}
	
}
