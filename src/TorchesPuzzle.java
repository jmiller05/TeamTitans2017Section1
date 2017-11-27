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
	private boolean firstTorchLit;
	private boolean secondTorchLit;
	private boolean thirdTorchLit;
	
	


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
		if(firstTorchLit && !secondTorchLit && thirdTorchLit)
		{
			this.isSolved = true;
			torchesDoor.unlockExit();
		}
		
	}
	
}
