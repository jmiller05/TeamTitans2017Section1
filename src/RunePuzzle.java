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
	Stage runeStage;
	
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
	
	public RunePuzzle(String ID, String name, String desc, String hi, Stage stage)
	{
		super(ID, name, desc, hi);
		// TODO Auto-generated constructor stub
		
		// TODO Auto-generated method stub
		this.runeStage = stage;
		
	}
	
	public void setStage(Stage stage)
	{
		this.runeStage = stage;
	}
	
	

	/* (non-Javadoc)
	 * @see PuzzleInterface#triggerPuzzle()
	 */
	@Override
	public void triggerPuzzle()
	{
		runeStage.show();
	}

	/* (non-Javadoc)
	 * @see PuzzleInterface#solvePuzzle()
	 */
	@Override
	public void solvePuzzle()
	{
		// TODO Auto-generated method stub
		
	}
	
}
