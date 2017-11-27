import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Game extends Application
{
	public Player		gamePlayer;
	public Controller	gameController;
	public Stage		inventoryStage;
	public Stage		encounterStage;
	public Stage		runeStage;
	public Stage		torchesPuzzleStage;
	public Stage		gameOverStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader();
		FXMLLoader inventoryLoader = new FXMLLoader();
		FXMLLoader monsterEncounterLoader = new FXMLLoader();
		FXMLLoader PuzzleLoader = new FXMLLoader();
		FXMLLoader runeStageLoader = new FXMLLoader();
		FXMLLoader torchesPuzzleLoader = new FXMLLoader();
		FXMLLoader gameOverStageLoader = new FXMLLoader();
		
		gamePlayer = new Player(10, 10, 1);
		
		
		Controller gameController = new Controller(gamePlayer, Room.readRooms("Rooms.dat"));
		
		
		loader.setController(gameController);
		inventoryLoader.setController(gameController);
		monsterEncounterLoader.setController(gameController);
		PuzzleLoader.setController(gameController);
		runeStageLoader.setController(gameController);
		gameOverStageLoader.setController(gameController);
		torchesPuzzleLoader.setController(gameController);
		
		loader.setLocation(getClass().getResource("View.fxml"));
		inventoryLoader.setLocation(getClass().getResource("Inventory.fxml"));
		monsterEncounterLoader.setLocation(getClass().getResource("CombatView.fxml"));
		PuzzleLoader.setLocation(getClass().getResource("Puzzle.fxml"));
		runeStageLoader.setLocation(getClass().getResource("RuneStage.fxml"));
		torchesPuzzleLoader.setLocation(getClass().getResource("TorchesPuzzle.fxml"));
		gameOverStageLoader.setLocation(getClass().getResource("GameOver.fxml"));
		
		Parent root = loader.load();
		Parent inventory = inventoryLoader.load();
		Parent encounter = monsterEncounterLoader.load();
		Parent runePuzzle = runeStageLoader.load();
		Parent torchesPuzzle = torchesPuzzleLoader.load();
		Parent gameOver = gameOverStageLoader.load();
		
		inventoryStage = new Stage();
		inventoryStage.setScene(new Scene(inventory, 600, 400));
		
		encounterStage = new Stage();
		encounterStage.initModality(Modality.APPLICATION_MODAL);
		encounterStage.setScene(new Scene(encounter, 600, 500));
		
		runeStage = new Stage();
		runeStage.setScene(new Scene(runePuzzle, 600, 300));
		
		torchesPuzzleStage = new Stage();
		torchesPuzzleStage.setScene(new Scene(torchesPuzzle, 700, 300));
		
		gameOverStage = new Stage();
		gameOverStage.setScene(new Scene(gameOver, 400, 300));
		
		gameController.setInventoryStage(inventoryStage);
		gameController.setEncounterStage(encounterStage);
		gameController.setRuneStage(runeStage);
		gameController.setTorchesPuzzleStage(torchesPuzzleStage);
		gameController.setGameOverStage(gameOverStage);
		gameController.setMonsterArray(Monster.readMonsters("Monsters.dat"));
		gameController.setMonsterStats();
		gameController.setImages();
		primaryStage.setScene(new Scene(root, 1100, 800));
		primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	
}