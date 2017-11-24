import java.util.ArrayList;
import java.util.Random;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller
{
	
	/**
	 * the Game instance
	 */
	private Game game;
	
	/**
	 * the Player attribute of the Controller
	 */
	private Player player;
	
	/**
	 *  the arraylist of Rooms
	 */
	private ArrayList<Room> dungeonRooms;
	
	/**
	 * the stage for the inventory window
	 */
	private Stage inventoryStage;
	
	/**
	 * the stage for the monster encounter window
	 */
	private Stage encounterStage;
	
	/**
	 * the list of inventory items
	 */
	private ObservableList<Item> inventoryList;
	
	/**
	 * the arraylist of monsters
	 */
	private ArrayList<Monster> monsterArray;
	
	/**
	 * random variable for generating monster damage
	 */
	private Random rand = new Random();
	
	
	/** 
	 * ProgressBar which displays the player's health
	 */
	@FXML
	ProgressBar health; 
	
	/**
	 * TextArea which displays most of the text descriptions in the game
	 */
	@FXML
	TextArea text; 
	
	/**
	 * ImageView which displays the map
	 */
	@FXML
	ImageView mapView; 
	
	/**
	 * Button to navigate North
	 */
	@FXML
	Button btnnorth; 
	
	/**
	 * Button to navigate South
	 */
	@FXML
	Button btsouth; 
	
	/**
	 * Button to navigate East
	 */
	@FXML
	Button bteast; 
	
	/**
	 * Button to navigate West
	 */
	@FXML
	Button btwest; 
	
	/**
	 * Button to navigate Northeast
	 */
	@FXML
	Button btnnortheast; 
	
	/**
	 * Button to navigate Northwest
	 */
	@FXML
	Button btnnorthwest;
	
	/**
	 * Button to navigate Southeast
	 */
	@FXML
	Button btsoutheast; 
	
	/**
	 * Button to navigate Southwest
	 */
	@FXML
	Button btsouthwest; 
	
	
	
	/**
	 * TableView which displays the players inventory
	 */
	@FXML
	TableView<Item> inventoryView; 
	
	/**
	 * ProgressIndicator which displays a monster's health when attacking the player
	 */
	@FXML
	TextArea combatText; 
	
	/**
	 * ProgressIndicator which displays the player's health when engaged in an encounter with a monster
	 */
	@FXML
	ProgressIndicator encounterPlayerHealth; 
	
	/**
	 * ProgressIndicator which displays a monster's health when attacking the player
	 */
	@FXML
	ProgressIndicator encounterMonsterHealth; 
	
	
	public Controller(Player player, ArrayList<Room> dungeonRooms)
	{
		this.player = player;
		this.dungeonRooms = dungeonRooms;
		game = new Game();
	}
	
	/**
	 * @author Evan Lamkie
	 * 
	 * Setter for the Controller's Player attribute
	 * 
	 */
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	/**
	 * @author Evan Lamkie
	 * 
	 * Setter for the Controller's Room ArrayList
	 * 
	 */
	public void setDungeonRooms(ArrayList<Room> dungeonRooms)
	{
		this.dungeonRooms = dungeonRooms;
	}
	
	/**
	 * @author Evan Lamkie
	 * 
	 * Setter for the Controller's inventory stage
	 * 
	 */
	public void setInventoryStage(Stage stage)
	{
		this.inventoryStage = stage;
	}
	
	/**
	 * @author Evan Lamkie
	 * 
	 * Setter for the Controller's encounter stage
	 * 
	 */
	public void setEncounterStage(Stage stage)
	{
		this.encounterStage = stage;
	}
	
	/**
	 * @author Jesse Miller
	 * 
	 * Setter for the Controller's Monster ArrayList
	 * 
	 */
	public void setMonsterArray(ArrayList<Monster> mAL)
	{
		this.monsterArray = mAL;
		
	}
	
	/**
	 * @author Jesse Miller
	 * 
	 * Setter statements for each Monster's Health, Damage, and Max Health.
	 * This is necessary because the Serializable interface removes inherited 
	 * attributes when invoked.
	 * 
	 */
	public void setMonsterStats()
	{
		monsterArray.get(0).setHealth(5);
		monsterArray.get(0).setMaxHealth(5);
		monsterArray.get(0).setDamage(rand.nextInt(2) + 1);
		
		monsterArray.get(1).setHealth(10);
		monsterArray.get(1).setMaxHealth(10);
		monsterArray.get(1).setDamage(rand.nextInt(3) + 1);
		
		monsterArray.get(2).setHealth(15);
		monsterArray.get(2).setMaxHealth(15);
		monsterArray.get(2).setDamage(rand.nextInt(3) + 1);
		
		monsterArray.get(3).setHealth(20);
		monsterArray.get(3).setMaxHealth(20);
		monsterArray.get(3).setDamage(rand.nextInt(4) + 1);
		
		monsterArray.get(4).setHealth(25);
		monsterArray.get(4).setMaxHealth(25);
		monsterArray.get(4).setDamage(rand.nextInt(4) + 1);
		
		monsterArray.get(5).setHealth(30);
		monsterArray.get(5).setMaxHealth(30);
		monsterArray.get(5).setDamage(rand.nextInt(4) + 1);
		
		monsterArray.get(6).setHealth(40);
		monsterArray.get(6).setMaxHealth(40);
		monsterArray.get(6).setDamage(rand.nextInt(5) + 1);
		
		monsterArray.get(7).setHealth(60);
		monsterArray.get(7).setMaxHealth(60);
		monsterArray.get(7).setDamage(rand.nextInt(5) + 2);
		
	}
	
	/**
	 * @return the player
	 */
	public Player getPlayer()
	{
		return player;
	}
	
	/**
	 * @return the ArrayList of rooms
	 */
	public ArrayList<Room> getDungeonRooms()
	{
		return dungeonRooms;
	}
	
	@FXML
	protected void initialize()
	{		

		if(player.getCurrentRoom() == null)
		{
			assignMapImages();
			player.setCurrentRoom(dungeonRooms.get(0));
			text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
		}
		
		inventoryList = FXCollections.<Item>observableArrayList();
		inventoryList.addAll(player.getInventory());
		
		health.setStyle("-fx-accent: rgba(13, 199, 4, 0.40); ");
		
		health.progressProperty().bind(player.getHealthPercentage());
		
		health.progressProperty().addListener(new ProgressBarStyler(health));	
	}
	
	/**
	 * 
	 */


	@FXML
	private void moveNorth(ActionEvent event)
	{
		if(player.getCurrentRoom().getNorthExit().isLocked())
		{
			text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthExit().getLockDescription());
		}
		else
		{
			player.changeRoom(player.getCurrentRoom().getNorthExit());
			text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
		}
	}
	
	@FXML
	private void moveSouth(ActionEvent event)
	{
		player.changeRoom(player.getCurrentRoom().getSouthExit());
		text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
		mapView.setImage(player.getCurrentRoom().getMapLocationImage());
		checkValidExits();
	}
	
	@FXML
	private void moveEast(ActionEvent event)
	{
		player.changeRoom(player.getCurrentRoom().getEastExit());
		text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
		mapView.setImage(player.getCurrentRoom().getMapLocationImage());
		checkValidExits();
	}
	
	@FXML
	private void moveWest(ActionEvent event)
	{
		player.changeRoom(player.getCurrentRoom().getWestExit());
		text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
		mapView.setImage(player.getCurrentRoom().getMapLocationImage());
		checkValidExits();
	}
	
	@FXML
	private void moveNorthEast(ActionEvent event)
	{
		player.changeRoom(player.getCurrentRoom().getNorthEastExit());
		text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
		mapView.setImage(player.getCurrentRoom().getMapLocationImage());
		checkValidExits();
	}
	
	@FXML
	private void moveSouthEast(ActionEvent event)
	{
		player.changeRoom(player.getCurrentRoom().getSouthEastExit());
		text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
		mapView.setImage(player.getCurrentRoom().getMapLocationImage());
		checkValidExits();
		triggerMonsterEncounter();
	}
	
	@FXML
	private void moveNorthWest(ActionEvent event)
	{
		player.changeRoom(player.getCurrentRoom().getNorthWestExit());
		text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
		mapView.setImage(player.getCurrentRoom().getMapLocationImage());
		checkValidExits();
	}
	
	@FXML
	private void moveSouthWest(ActionEvent event)
	{
		player.changeRoom(player.getCurrentRoom().getSouthWestExit());
		text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
		mapView.setImage(player.getCurrentRoom().getMapLocationImage());
		checkValidExits();
	}
	
	/**
	 * @author Evan Lamkie
	 * 
	 * Sets the player's current items to the window view, and then
	 * opens the stage.
	 * 
	 * @param event the pressing of Show Inventory button
	 */
	@FXML
	private void showInventory(ActionEvent event)
	{
		inventoryView.setItems(inventoryList);
		inventoryStage.show();	
	}
	
	
	/**
	 * 
	 * Checks if there is a monster in the player's current room, and 
	 * if there is, prints the monster's description.
	 * 
	 * @param event the pressing of Examine Monster button
	 * @author Jesse Miller
	 */
	@FXML
	private void examineMonster(ActionEvent event)
	{
		for(int i = 0; i < monsterArray.size(); i++)
		{
			if( player.getCurrentRoom().getRoomID() == (monsterArray.get(i).getLocation()) )
			{
				text.appendText("\n\n" + monsterArray.get(i).getMonsterDescription());			
			}		
		}
	}
	
	/**
	 * 
	 * Ends the monster encounter.
	 * 
	 * @param event the pressing of Flee Monster button
	 * @author Evan Lamkie
	 */
	@FXML
	private void fleeMonster(ActionEvent event)
	{
		encounterStage.close();
	}
	
	@FXML
	private void searchRoom(ActionEvent event)
	{
		int roomId = player.getCurrentRoom().getRoomID();
		Item item = game.getItemInRoom(roomId);
		if (item != null) {
			text.appendText("\n" + item.getItemDescription()); 
			player.addItemToInventory(item);
			game.removeItemFromRoom(roomId);
			game.saveItemsInRooms();
			
			//text.appendText(String.valueOf(player.getInventory().size()));
		}
		else {
			text.appendText(" \n There are no item's in this room");
		}
		
	}
	
	/**
	 * 
	 * Checks if there is a monster in the player's current room, and if there is,
	 * the player attacks the monster with their current damage. In return, the monster
	 * attacks the player.
	 * Checks to see if either Entity dies during the fight, and informs the player
	 * with a message depending on who died.
	 * 
	 * @param event the pressing of Attack Monster button
	 * @author Jesse Miller
	 */
	@FXML
	private void attackMonster(ActionEvent event)
	{
		for(int i = 0; i < monsterArray.size(); i++)
		{
			if( player.getCurrentRoom().getRoomID() == (monsterArray.get(i).getLocation()) )
			{
				text.appendText("\n Monster hp before attack: " + monsterArray.get(i).getHealth());
				combatText.appendText("\n Monster hp before attack: " + monsterArray.get(i).getHealth());
				player.attack(monsterArray.get(i), player.getDamage());
				
				text.appendText("\n player dmg: " + player.getDamage());
				combatText.appendText("\n player dmg: " + player.getDamage());
				text.appendText("\n Monster hp after attack: " + monsterArray.get(i).getHealth());
				combatText.appendText("\n Monster hp after attack: " + monsterArray.get(i).getHealth());
				
				if (player.getHealth() <= 0 )
				{
					text.appendText("\n" + monsterArray.get(i).winFight());
				}
				if (monsterArray.get(i).getHealth() <= 0)
				{
					text.appendText("\n" + player.winFight());
					monsterArray.remove(i);
				}
			}		
		}
	}
	
	/**
	 * 
	 * Opens a new stage for the combat session. Includes Attack, Examine, and Flee
	 * buttons. Also shows the player HP and monster HP. 
	 * 
	 * @author Evan Lamkie
	 */
	private void triggerMonsterEncounter()
	{
		for(int i = 0; i < monsterArray.size(); i++)
		{
			if( player.getCurrentRoom().getRoomID() == (monsterArray.get(i).getLocation()) )
			{
				encounterPlayerHealth.setStyle("-fx-accent: rgba(13, 199, 4, 0.40); ");
				encounterPlayerHealth.progressProperty().bind(player.getHealthPercentage());
				encounterPlayerHealth.progressProperty().addListener(new ProgressBarStyler(encounterPlayerHealth));
				encounterStage.show();
				combatText.appendText("\n\n" + monsterArray.get(i).getMonsterDescription());
			}		
		}
		
	}
	
	private void checkValidExits()
	{
		btnnorth.setDisable(!player.getCurrentRoom().isValidExit("north"));
		btsouth.setDisable(!player.getCurrentRoom().isValidExit("south"));
		bteast.setDisable(!player.getCurrentRoom().isValidExit("east"));
		btwest.setDisable(!player.getCurrentRoom().isValidExit("west"));
		btnnortheast.setDisable(!player.getCurrentRoom().isValidExit("northeast"));
		btnnorthwest.setDisable(!player.getCurrentRoom().isValidExit("northwest"));
		btsoutheast.setDisable(!player.getCurrentRoom().isValidExit("southeast"));
		btsouthwest.setDisable(!player.getCurrentRoom().isValidExit("southwest"));
	}
	
	private void assignMapImages()
	{
		dungeonRooms.get(0).setMapLocationImage(new Image("res/Room_00.jpg"));
		dungeonRooms.get(1).setMapLocationImage(new Image("res/Room_01.jpg"));
		dungeonRooms.get(2).setMapLocationImage(new Image("res/Room_02.jpg"));
		dungeonRooms.get(3).setMapLocationImage(new Image("res/Room_03.jpg"));
		dungeonRooms.get(4).setMapLocationImage(new Image("res/Room_04.jpg"));
		dungeonRooms.get(5).setMapLocationImage(new Image("res/Room_05.jpg"));
		dungeonRooms.get(6).setMapLocationImage(new Image("res/Room_06.jpg"));
		dungeonRooms.get(7).setMapLocationImage(new Image("res/Room_07.jpg"));
		dungeonRooms.get(8).setMapLocationImage(new Image("res/Room_08.jpg"));
		dungeonRooms.get(9).setMapLocationImage(new Image("res/Room_09.jpg"));
		dungeonRooms.get(10).setMapLocationImage(new Image("res/Room_10.jpg"));
		dungeonRooms.get(11).setMapLocationImage(new Image("res/Room_11.jpg"));
		dungeonRooms.get(12).setMapLocationImage(new Image("res/Room_12.jpg"));
		dungeonRooms.get(13).setMapLocationImage(new Image("res/Room_13.jpg"));
		dungeonRooms.get(14).setMapLocationImage(new Image("res/Room_14.jpg"));
		dungeonRooms.get(15).setMapLocationImage(new Image("res/Room_15.jpg"));
		dungeonRooms.get(16).setMapLocationImage(new Image("res/Room_16.jpg"));
		dungeonRooms.get(17).setMapLocationImage(new Image("res/Room_17.jpg"));
		dungeonRooms.get(18).setMapLocationImage(new Image("res/Room_18.jpg"));
		dungeonRooms.get(19).setMapLocationImage(new Image("res/Room_19.jpg"));
		dungeonRooms.get(20).setMapLocationImage(new Image("res/Room_20.jpg"));
		dungeonRooms.get(21).setMapLocationImage(new Image("res/Room_21.jpg"));
		dungeonRooms.get(22).setMapLocationImage(new Image("res/Room_22.jpg"));
		dungeonRooms.get(23).setMapLocationImage(new Image("res/Room_23.jpg"));
		dungeonRooms.get(24).setMapLocationImage(new Image("res/Room_24.jpg"));
		dungeonRooms.get(25).setMapLocationImage(new Image("res/Room_25.jpg"));
		dungeonRooms.get(26).setMapLocationImage(new Image("res/Room_26.jpg"));
		dungeonRooms.get(27).setMapLocationImage(new Image("res/Room_27.jpg"));
		dungeonRooms.get(28).setMapLocationImage(new Image("res/Room_28.jpg"));
		dungeonRooms.get(29).setMapLocationImage(new Image("res/Room_29.jpg"));
		dungeonRooms.get(30).setMapLocationImage(new Image("res/Room_30.jpg"));
	}
	
	private class ProgressBarStyler implements ChangeListener<Number>
	{
		private ProgressBar progressBar;
		private ProgressIndicator progressIndicator;
		
		public ProgressBarStyler(ProgressBar progressBar)
		{
			this.progressBar = progressBar;
		}
		
		public ProgressBarStyler(ProgressIndicator progressIndicator)
		{
			this.progressIndicator = progressIndicator;
		}
		
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
		{
			double progress = newValue == null ? 0 : newValue.doubleValue();
			if(progressBar != null)
			{
				if (progress < 0.2)
				{
					progressBar.setStyle("-fx-accent: rgba(224, 0, 0, 0.40); ");
				} 
				else if (progress < 0.4)
				{
					progressBar.setStyle("-fx-accent: rgba(241, 130, 3, 0.40); ");
				}
				else if (progress < 0.6)
				{
					progressBar.setStyle("-fx-accent: rgba(241, 237, 3, 0.40); ");
				}
				else
				{
					progressBar.setStyle("-fx-accent: rgba(13, 199, 4, 0.40); ");
				}
			}
			else if(progressIndicator != null)
			{
				if (progress < 0.2)
				{
					progressIndicator.setStyle("-fx-accent: rgba(224, 0, 0, 0.40); ");
				} 
				else if (progress < 0.4)
				{
					progressIndicator.setStyle("-fx-accent: rgba(241, 130, 3, 0.40); ");
				}
				else if (progress < 0.6)
				{
					progressIndicator.setStyle("-fx-accent: rgba(241, 237, 3, 0.40); ");
				}
				else
				{
					progressIndicator.setStyle("-fx-accent: rgba(13, 199, 4, 0.40); ");
				}
			}
		}
	}
	
}
