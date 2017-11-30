import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	
	PotionBottle potion;
	Game game = new Game();
	Timer timer;
	
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
	 * the arraylist of monsters
	 */
	private ArrayList<Monster> monsterArray;
	
	/**
	 * random variable for generating monster damage
	 */
	private Random rand = new Random();
	
	/**
	 * stage variable to show the stage for the rune puzzle
	 */
	//private Stage runeStage;
	
	/**
	 * stage variable to show the stage for the torches puzzle
	 */
	private Stage torchesPuzzleStage;
	
	private Stage puzzleStage;
	
	private Stage gameOverStage;
	
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
	
	@FXML
	Button btusePotion;
	
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
	
	@FXML
	TextArea hintText;
	
	@FXML
	ImageView greenRuneImage;
	
	@FXML
	ImageView blueRuneImage;
	
	@FXML
	ImageView firstTorchImage;
	
	@FXML
	ImageView secondTorchImage;
	
	@FXML
	ImageView thirdTorchImage;
	
	public Controller(Player player, ArrayList<Room> dungeonRooms)
	{
		this.player = player;
		this.dungeonRooms = dungeonRooms;
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
	
	public void setPuzzleStage(Stage stage)
	{
		this.puzzleStage = stage;
	}
	
	public Stage getTorchesPuzzleStage()
	{
		return torchesPuzzleStage;
	}
	
	public void setTorchesPuzzleStage(Stage torchesPuzzleStage)
	{
		this.torchesPuzzleStage = torchesPuzzleStage;
	}
	
	public void setGameOverStage(Stage stage)
	{
		this.gameOverStage = stage;
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
		monsterArray.get(0).setHealthPercentage(new SimpleDoubleProperty(1));
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
		((CentaurPuzzle)dungeonRooms.get(18).getPuzzle()).setGoldKey(monsterArray.get(4).getItemDropped());
		
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
		
		btusePotion.setDisable(true);
		((Map)dungeonRooms.get(2).getItem(0)).setMap(mapView);
		mapView.setVisible(false);
		((TorchPuzzle)dungeonRooms.get(3).getPuzzle()).setText(text);
		((TorchPuzzle)dungeonRooms.get(3).getPuzzle()).setPlayer(player);
		((SpiderWebPuzzle)dungeonRooms.get(5).getPuzzle()).setText(text);
		((SpiderWebPuzzle)dungeonRooms.get(5).getPuzzle()).setPlayer(player);
		((CentaurPuzzle)dungeonRooms.get(18).getPuzzle()).setText(text);
		((CentaurPuzzle)dungeonRooms.get(18).getPuzzle()).setPlayer(player);
		//((RunePuzzle)dungeonRooms.get(15).getPuzzle()).setRuneStage(runeStage);
		if(puzzleStage == null)
		{
			puzzleStage = new Stage();
		}
		
		
		((RunePuzzle)dungeonRooms.get(15).getPuzzle()).setStage(puzzleStage);
		((RunePuzzle)dungeonRooms.get(15).getPuzzle()).initializeRunePuzzle(this,"RuneStage.fxml");
		
		((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).setStage(puzzleStage);
		((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).initializeRunePuzzle(this,"TorchesPuzzle.fxml");
		
		
		
		if(player.getCurrentRoom() == null)
		{
			player.setCurrentRoom(dungeonRooms.get(0));
			text.setText(player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
		}
		
		health.setStyle("-fx-accent: rgba(13, 199, 4, 0.40); ");
		health.progressProperty().bind(player.getHealthPercentage());
		health.progressProperty().addListener(new ProgressBarStyler(health));	
	}
	
	@FXML
	private void moveNorth(ActionEvent event)
	{
		if(player.getCurrentRoom().getNorthExit().isLocked())
		{
			if(player.getCurrentRoom().hasPuzzle())
			{
				if(player.getCurrentRoom().getPuzzle().getTriggerType().equalsIgnoreCase("navigation") && !player.getCurrentRoom().getPuzzle().isSolved)
				{
					System.out.println("Puzzle Triggered!");
					((PuzzleInterface)player.getCurrentRoom().getPuzzle()).triggerPuzzle();
					if(!player.getCurrentRoom().getPuzzle().isSolved)
					{
						text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthExit().getLockDescription());
					}
					else if(player.getCurrentRoom().getPuzzle().isAutoNavigate())
					{
						((Button)event.getSource()).setDisable(true);
						timer = new Timer();
						timer.schedule(new TimerTask()
						{
							@Override
							public void run()
							{
								player.changeRoom(player.getCurrentRoom().getNorthExit());
								text.setText(player.getCurrentRoom().getRoomDescription());
								mapView.setImage(player.getCurrentRoom().getMapLocationImage());
								checkValidExits();
								triggerMonsterEncounter();
								timer.cancel();
								timer.purge();
							}
						}, 1500);
					}
				}
				else
				{
					text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthExit().getLockDescription());
				}
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthExit().getLockDescription());
			}
		}
		else if(player.getCurrentRoom().getNorthExit().isStairCase())
		{
			if(player.getCurrentRoom().getNorthExit().getRoomA() == player.getCurrentRoom())
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthExit().getStairDescription("a"));
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthExit().getStairDescription("b"));
			}
			
			((Button)event.getSource()).setDisable(true);
			timer = new Timer();
			timer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					player.changeRoom(player.getCurrentRoom().getNorthExit());
					text.setText(player.getCurrentRoom().getRoomDescription());
					mapView.setImage(player.getCurrentRoom().getMapLocationImage());
					checkValidExits();
					triggerMonsterEncounter();
					timer.cancel();
					timer.purge();
				}
			}, 1500);
		}
		else
		{
			player.changeRoom(player.getCurrentRoom().getNorthExit());
			text.setText(player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
			triggerMonsterEncounter();
		}
	}
	
	@FXML
	private void moveSouth(ActionEvent event)
	{		
		if(player.getCurrentRoom().getSouthExit().isLocked())
		{	
			if(player.getCurrentRoom().hasPuzzle())
			{
				if(player.getCurrentRoom().getPuzzle().getTriggerType().equalsIgnoreCase("navigation") && !player.getCurrentRoom().getPuzzle().isSolved)
				{
					System.out.println("Puzzle Triggered!");
					((PuzzleInterface)player.getCurrentRoom().getPuzzle()).triggerPuzzle();
					if(!player.getCurrentRoom().getPuzzle().isSolved)
					{
						text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthExit().getLockDescription());
					}
					else if(player.getCurrentRoom().getPuzzle().isAutoNavigate())
					{
						((Button)event.getSource()).setDisable(true);
						timer = new Timer();
						timer.schedule(new TimerTask()
						{
							@Override
							public void run()
							{
								player.changeRoom(player.getCurrentRoom().getSouthExit());
								text.setText(player.getCurrentRoom().getRoomDescription());
								mapView.setImage(player.getCurrentRoom().getMapLocationImage());
								checkValidExits();
								triggerMonsterEncounter();
								timer.cancel();
								timer.purge();
							}
						}, 1500);
					}
				}
				else
				{
					text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthExit().getLockDescription());
				}
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthExit().getLockDescription());
			}
		}
		else if(player.getCurrentRoom().getSouthExit().isStairCase())
		{
			if(player.getCurrentRoom().getSouthExit().getRoomA() == player.getCurrentRoom())
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthExit().getStairDescription("a"));
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthExit().getStairDescription("b"));
			}
			
			((Button)event.getSource()).setDisable(true);
			timer = new Timer();
			timer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					player.changeRoom(player.getCurrentRoom().getSouthExit());
					text.setText(player.getCurrentRoom().getRoomDescription());
					mapView.setImage(player.getCurrentRoom().getMapLocationImage());
					checkValidExits();
					triggerMonsterEncounter();
					timer.cancel();
					timer.purge();
				}
			}, 1500);
		}
		else
		{
			player.changeRoom(player.getCurrentRoom().getSouthExit());
			text.setText(player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
			triggerMonsterEncounter();
		}
	}
	
	@FXML
	private void moveEast(ActionEvent event)
	{
		if(player.getCurrentRoom().getEastExit().isLocked())
		{
			if(player.getCurrentRoom().hasPuzzle())
			{
				if(player.getCurrentRoom().getPuzzle().getTriggerType().equalsIgnoreCase("navigation") && !player.getCurrentRoom().getPuzzle().isSolved)
				{
					System.out.println("Puzzle Triggered!");
					((PuzzleInterface)player.getCurrentRoom().getPuzzle()).triggerPuzzle();
					if(!player.getCurrentRoom().getPuzzle().isSolved)
					{
						text.appendText("\n" + "\n" + player.getCurrentRoom().getEastExit().getLockDescription());
					}
					else if(player.getCurrentRoom().getPuzzle().isAutoNavigate())
					{
						((Button)event.getSource()).setDisable(true);
						timer = new Timer();
						timer.schedule(new TimerTask()
						{
							@Override
							public void run()
							{
								player.changeRoom(player.getCurrentRoom().getEastExit());
								text.setText(player.getCurrentRoom().getRoomDescription());
								mapView.setImage(player.getCurrentRoom().getMapLocationImage());
								checkValidExits();
								triggerMonsterEncounter();
								timer.cancel();
								timer.purge();
							}
						}, 1500);
					}
				}
				else
				{
					text.appendText("\n" + "\n" + player.getCurrentRoom().getEastExit().getLockDescription());
				}
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getEastExit().getLockDescription());
			}
		}
		else if(player.getCurrentRoom().getEastExit().isStairCase())
		{
			if(player.getCurrentRoom().getEastExit().getRoomA() == player.getCurrentRoom())
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getEastExit().getStairDescription("a"));
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getEastExit().getStairDescription("b"));
			}
			
			((Button)event.getSource()).setDisable(true);
			timer = new Timer();
			timer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					player.changeRoom(player.getCurrentRoom().getEastExit());
					text.setText(player.getCurrentRoom().getRoomDescription());
					mapView.setImage(player.getCurrentRoom().getMapLocationImage());
					checkValidExits();
					triggerMonsterEncounter();
					timer.cancel();
					timer.purge();
				}
			}, 1500);
		}
		else
		{
			player.changeRoom(player.getCurrentRoom().getEastExit());
			text.setText(player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
			triggerMonsterEncounter();
		}
	}
	
	@FXML
	private void moveWest(ActionEvent event)
	{
		if(player.getCurrentRoom().getWestExit().isLocked())
		{
			if(player.getCurrentRoom().hasPuzzle())
			{
				if(player.getCurrentRoom().getPuzzle().getTriggerType().equalsIgnoreCase("navigation") && !player.getCurrentRoom().getPuzzle().isSolved)
				{
					System.out.println("Puzzle Triggered!");
					((PuzzleInterface)player.getCurrentRoom().getPuzzle()).triggerPuzzle();
					if(!player.getCurrentRoom().getPuzzle().isSolved)
					{
						text.appendText("\n" + "\n" + player.getCurrentRoom().getWestExit().getLockDescription());
					}
					else if(player.getCurrentRoom().getPuzzle().isAutoNavigate())
					{
						((Button)event.getSource()).setDisable(true);
						timer = new Timer();
						timer.schedule(new TimerTask()
						{
							@Override
							public void run()
							{
								player.changeRoom(player.getCurrentRoom().getWestExit());
								text.setText(player.getCurrentRoom().getRoomDescription());
								mapView.setImage(player.getCurrentRoom().getMapLocationImage());
								checkValidExits();
								triggerMonsterEncounter();
								timer.cancel();
								timer.purge();
							}
						}, 1500);
					}
				}
				else
				{
					text.appendText("\n" + "\n" + player.getCurrentRoom().getWestExit().getLockDescription());
				}
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getWestExit().getLockDescription());
			}
		}
		else if(player.getCurrentRoom().getWestExit().isStairCase())
		{
			if(player.getCurrentRoom().getWestExit().getRoomA() == player.getCurrentRoom())
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getWestExit().getStairDescription("a"));
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getWestExit().getStairDescription("b"));
			}
			
			((Button)event.getSource()).setDisable(true);
			timer = new Timer();
			timer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					player.changeRoom(player.getCurrentRoom().getWestExit());
					text.setText(player.getCurrentRoom().getRoomDescription());
					mapView.setImage(player.getCurrentRoom().getMapLocationImage());
					checkValidExits();
					triggerMonsterEncounter();
					timer.cancel();
					timer.purge();
				}
			}, 1500);
		}
		else
		{
			player.changeRoom(player.getCurrentRoom().getWestExit());
			text.setText(player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
			triggerMonsterEncounter();
		}
	}
	
	@FXML
	private void moveNorthEast(ActionEvent event)
	{
		if(player.getCurrentRoom().getNorthEastExit().isLocked())
		{
			if(player.getCurrentRoom().hasPuzzle())
			{
				if(player.getCurrentRoom().getPuzzle().getTriggerType().equalsIgnoreCase("navigation") && !player.getCurrentRoom().getPuzzle().isSolved)
				{
					System.out.println("Puzzle Triggered!");
					((PuzzleInterface)player.getCurrentRoom().getPuzzle()).triggerPuzzle();
					if(!player.getCurrentRoom().getPuzzle().isSolved)
					{
						text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthEastExit().getLockDescription());
					}
					else if(player.getCurrentRoom().getPuzzle().isAutoNavigate())
					{
						((Button)event.getSource()).setDisable(true);
						timer = new Timer();
						timer.schedule(new TimerTask()
						{
							@Override
							public void run()
							{
								player.changeRoom(player.getCurrentRoom().getNorthEastExit());
								text.setText(player.getCurrentRoom().getRoomDescription());
								mapView.setImage(player.getCurrentRoom().getMapLocationImage());
								checkValidExits();
								triggerMonsterEncounter();
								timer.cancel();
								timer.purge();
							}
						}, 1500);
					}
				}
				else
				{
					text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthEastExit().getLockDescription());
				}
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthEastExit().getLockDescription());
			}
			
		}
		else if(player.getCurrentRoom().getNorthEastExit().isStairCase())
		{
			if(player.getCurrentRoom().getNorthEastExit().getRoomA() == player.getCurrentRoom())
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthEastExit().getStairDescription("a"));
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthEastExit().getStairDescription("b"));
			}
			
			((Button)event.getSource()).setDisable(true);
			timer = new Timer();
			timer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					player.changeRoom(player.getCurrentRoom().getNorthEastExit());
					text.setText(player.getCurrentRoom().getRoomDescription());
					mapView.setImage(player.getCurrentRoom().getMapLocationImage());
					checkValidExits();
					triggerMonsterEncounter();
					timer.cancel();
					timer.purge();
				}
			}, 1500);
		}
		else
		{
			player.changeRoom(player.getCurrentRoom().getNorthEastExit());
			text.setText(player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
			triggerMonsterEncounter();
		}
	}
	
	@FXML
	private void moveSouthEast(ActionEvent event)
	{
		if(player.getCurrentRoom().getSouthEastExit().isLocked())
		{
			if(player.getCurrentRoom().hasPuzzle())
			{
				if(player.getCurrentRoom().getPuzzle().getTriggerType().equalsIgnoreCase("navigation") && !player.getCurrentRoom().getPuzzle().isSolved)
				{
					((PuzzleInterface)player.getCurrentRoom().getPuzzle()).triggerPuzzle();
					System.out.println("Puzzle Triggered!");
					if(!player.getCurrentRoom().getPuzzle().isSolved)
					{
						text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthEastExit().getLockDescription());
					}
					else if(player.getCurrentRoom().getPuzzle().isAutoNavigate())
					{
						((Button)event.getSource()).setDisable(true);
						timer = new Timer();
						timer.schedule(new TimerTask()
						{
							@Override
							public void run()
							{
								player.changeRoom(player.getCurrentRoom().getSouthEastExit());
								text.setText(player.getCurrentRoom().getRoomDescription());
								mapView.setImage(player.getCurrentRoom().getMapLocationImage());
								checkValidExits();
								triggerMonsterEncounter();
								timer.cancel();
								timer.purge();
							}
						}, 1500);
					}
				}
				else
				{
					text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthEastExit().getLockDescription());
				}
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthEastExit().getLockDescription());
			}
			
		}
		else if(player.getCurrentRoom().getSouthEastExit().isStairCase())
		{
			if(player.getCurrentRoom().getSouthEastExit().getRoomA() == player.getCurrentRoom())
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthEastExit().getStairDescription("a"));
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthEastExit().getStairDescription("b"));
			}
			
			((Button)event.getSource()).setDisable(true);
			timer = new Timer();
			timer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					player.changeRoom(player.getCurrentRoom().getSouthEastExit());
					text.setText(player.getCurrentRoom().getRoomDescription());
					mapView.setImage(player.getCurrentRoom().getMapLocationImage());
					checkValidExits();
					triggerMonsterEncounter();
					timer.cancel();
					timer.purge();
				}
			}, 1500);
		}
		else
		{
			player.changeRoom(player.getCurrentRoom().getSouthEastExit());
			text.setText(player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
			triggerMonsterEncounter();
		}
	}
	
	@FXML
	private void moveNorthWest(ActionEvent event)
	{
		if(player.getCurrentRoom().getNorthWestExit().isLocked())
		{
			if(player.getCurrentRoom().hasPuzzle())
			{
				if(player.getCurrentRoom().getPuzzle().getTriggerType().equalsIgnoreCase("navigation") && !player.getCurrentRoom().getPuzzle().isSolved)
				{
					((PuzzleInterface)player.getCurrentRoom().getPuzzle()).triggerPuzzle();
					System.out.println("Puzzle Triggered!");
					if(!player.getCurrentRoom().getPuzzle().isSolved)
					{
						text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthWestExit().getLockDescription());
					}
					else if(player.getCurrentRoom().getPuzzle().isAutoNavigate())
					{
						((Button)event.getSource()).setDisable(true);
						timer = new Timer();
						timer.schedule(new TimerTask()
						{
							@Override
							public void run()
							{
								player.changeRoom(player.getCurrentRoom().getNorthWestExit());
								text.setText(player.getCurrentRoom().getRoomDescription());
								mapView.setImage(player.getCurrentRoom().getMapLocationImage());
								checkValidExits();
								triggerMonsterEncounter();
								timer.cancel();
								timer.purge();
							}
						}, 1500);
					}
				}
				else
				{
					text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthWestExit().getLockDescription());
				}
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthWestExit().getLockDescription());
			}
		}
		else if(player.getCurrentRoom().getNorthWestExit().isStairCase())
		{
			if(player.getCurrentRoom().getNorthWestExit().getRoomA() == player.getCurrentRoom())
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthWestExit().getStairDescription("a"));
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthWestExit().getStairDescription("b"));
			}
			
			((Button)event.getSource()).setDisable(true);
			timer = new Timer();
			timer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					player.changeRoom(player.getCurrentRoom().getNorthWestExit());
					text.setText(player.getCurrentRoom().getRoomDescription());
					mapView.setImage(player.getCurrentRoom().getMapLocationImage());
					checkValidExits();
					triggerMonsterEncounter();
					timer.cancel();
					timer.purge();
				}
			}, 1500);
		}
		else
		{
			player.changeRoom(player.getCurrentRoom().getNorthWestExit());
			text.setText(player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
			triggerMonsterEncounter();
		}
	}
	
	@FXML
	private void moveSouthWest(ActionEvent event)
	{
		if(player.getCurrentRoom().getSouthWestExit().isLocked())
		{
			if(player.getCurrentRoom().hasPuzzle())
			{
				if(player.getCurrentRoom().getPuzzle().getTriggerType().equalsIgnoreCase("navigation") && !player.getCurrentRoom().getPuzzle().isSolved)
				{
					((PuzzleInterface)player.getCurrentRoom().getPuzzle()).triggerPuzzle();
					System.out.println("Puzzle Triggered!");
					if(!player.getCurrentRoom().getPuzzle().isSolved)
					{
						text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthWestExit().getLockDescription());
					}
					else if(player.getCurrentRoom().getPuzzle().isAutoNavigate())
					{
						((Button)event.getSource()).setDisable(true);
						timer = new Timer();
						timer.schedule(new TimerTask()
						{
							@Override
							public void run()
							{
								player.changeRoom(player.getCurrentRoom().getSouthWestExit());
								text.setText(player.getCurrentRoom().getRoomDescription());
								mapView.setImage(player.getCurrentRoom().getMapLocationImage());
								checkValidExits();
								triggerMonsterEncounter();
								timer.cancel();
								timer.purge();
							}
						}, 1500);
					}
				}
				else
				{
					text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthWestExit().getLockDescription());
				}
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthWestExit().getLockDescription());
			}
		}
		else if(player.getCurrentRoom().getSouthWestExit().isStairCase())
		{
			if(player.getCurrentRoom().getSouthWestExit().getRoomA() == player.getCurrentRoom())
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthWestExit().getStairDescription("a"));
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSouthWestExit().getStairDescription("b"));
			}
			
			((Button)event.getSource()).setDisable(true);
			timer = new Timer();
			timer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					player.changeRoom(player.getCurrentRoom().getSouthWestExit());
					text.setText(player.getCurrentRoom().getRoomDescription());
					mapView.setImage(player.getCurrentRoom().getMapLocationImage());
					checkValidExits();
					triggerMonsterEncounter();
					timer.cancel();
					timer.purge();
				}
			}, 1500);
		}
		else
		{
			player.changeRoom(player.getCurrentRoom().getSouthWestExit());
			text.setText(player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
			triggerMonsterEncounter();
		}
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
		inventoryView.setItems(player.getInventory());
		inventoryStage.show();	
	}
	
	@FXML
	private void usePotion(ActionEvent event)
	{
		if(player.getInventory().contains(potion))
		{
			if(potion.isFull())
			{
				potion.useItem();
				text.appendText("\n" + "\n" + "You feel rejuvinated!" + "\n");
				btusePotion.setDisable(true);
				
			}
			if(!potion.isFull())
			{
				text.appendText("\n" + "\n" + "This bottle is empty!");
			}
		}
	}
	
	/**
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
		int index;
		boolean wellOfLife = false;
		index = player.getCurrentRoom().getSearchResultIndex();
		
		if(player.getCurrentRoom().hasItem() && index < player.getCurrentRoom().getItemList().size() && player.getCurrentRoom().getItem(index).getItemName().equalsIgnoreCase("well of life"))		
		{
			wellOfLife = true;
		}
		else if(player.getCurrentRoom().hasPuzzle())
		{
			if(player.getCurrentRoom().getPuzzle().getTriggerType().equalsIgnoreCase("search") && player.getCurrentRoom().getSearchResults() != null)
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSearchResult(index));
			}
			
		}
		else
		{
			text.appendText("\n" + "\n" + player.getCurrentRoom().getSearchResult(index));
		}
		
		if(player.getCurrentRoom().hasItem() && index < player.getCurrentRoom().getItemList().size())
		{
			if(wellOfLife)
			{
				if(potion != null && !((PotionBottle)potion).isFull())
				{
					((PotionBottle)player.getInventory().get(player.getInventory().indexOf(potion))).fillBottle();
					btusePotion.setDisable(false);
					try
					{
						player.restoreHealth(player.getMaxHealth()-player.getHealth());
					} catch (InvalidHealthException e)
					{
						e.printStackTrace();
					}
					text.appendText("\n" + "\n" + "You lean down and take a drink of the glowing liquid and you can feel yourself become reinvigorated, even your wounds heal instantly. You decide it would be a good idea to take some of this liquid in your bottle and you fill up the bottle");
				}
				else
				{
					try
					{
						player.restoreHealth(player.getMaxHealth()-player.getHealth());
					} catch (InvalidHealthException e)
					{
						e.printStackTrace();
					}
					text.appendText("\n" + "\n" + "You lean down and take a drink of the glowing liquid and you can feel yourself become reinvigorated, even your wounds heal instantly.");
				}
			}
			else
			{
				
				if(player.getCurrentRoom().getItem(index).getItemName().equalsIgnoreCase("map")){((Map)player.getCurrentRoom().getItem(index)).useItem();}
				if(player.getCurrentRoom().getItem(index).getItemName().equalsIgnoreCase("potion bottle"))
				{
					potion=(PotionBottle)player.getCurrentRoom().getItem(index);
					potion.setPlayer(player);
					btusePotion.setDisable(false);
				}
				player.pickupItem(index);
			}
		}
		else if(player.getCurrentRoom().hasPuzzle() && player.getCurrentRoom().getSearchResults() == null)
		{
			if(player.getCurrentRoom().getPuzzle().getTriggerType().equalsIgnoreCase("search") && !player.getCurrentRoom().getPuzzle().isSolved() )
			{
				((PuzzleInterface)player.getCurrentRoom().getPuzzle()).triggerPuzzle();
				System.out.println("Puzzle Triggered!");
			}
			else
			{
				text.appendText("\n" + "\n" + player.getCurrentRoom().getSearchResult(index));
			}
		}
		else if(player.getCurrentRoom().getSearchResults() != null)
		{
			player.getCurrentRoom().removeSearchResult(index);
		}
		
	}
	
	/**
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
				text.appendText("\n Monster hp after attack: " + monsterArray.get(i).getHealth());
				combatText.appendText("\n Monster hp after attack: " + monsterArray.get(i).getHealth());
				
				text.appendText("\n Player hp before attack: " + player.getHealth());
				combatText.appendText("\n Player hp before attack: " + player.getHealth());
				monsterArray.get(i).attack(player, monsterArray.get(i).getDamage());
				text.appendText("\n Player hp after attack: " + player.getHealth());
				combatText.appendText("\n Player hp after attack: " + player.getHealth());
				
				if (player.getHealth() <= 0 )
				{
					text.appendText("\n" + monsterArray.get(i).winFight());
					encounterStage.close();
					gameOverStage.show();
				}
				if (monsterArray.get(i).getHealth() <= 0)
				{
					text.appendText("\n" + player.winFight());
					Item itemDropped = monsterArray.get(i).getItemDropped();
					if (itemDropped != null) {
						text.appendText("\n" + "Monster has dropped" + itemDropped.getItemDescription());
						player.getInventory().add(itemDropped);
					} else {
						text.appendText("\n" + "Nothing can be found on monster");
					}
					monsterArray.remove(i);
					encounterStage.close();
				}
			}		
		}
	}
	
	/*public void setImages()
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
	}*/
	
	@FXML
	private void insertGreenRune(ActionEvent event)
	{
		if(dungeonRooms.get(15).hasPuzzle())
		{
			if(((RunePuzzle)dungeonRooms.get(15).getPuzzle()).playerHasEmeraldRune(player))
			{
				greenRuneImage.setOpacity(1);
				((RunePuzzle)dungeonRooms.get(15).getPuzzle()).insertEmeraldRune();
				player.getInventory().remove(((RunePuzzle)dungeonRooms.get(15).getPuzzle()).getEmeraldRune());
				
				if(((RunePuzzle)dungeonRooms.get(15).getPuzzle()).isSapphireRuneInserted())
				{
					((RunePuzzle)dungeonRooms.get(15).getPuzzle()).solvePuzzle();
					
				}
			}
			else
			{
				text.appendText("\n" + "\n" + "It looks like you might need to put something here");
			}
		}
		
	}
	
	@FXML
	private void insertBlueRune(ActionEvent event)
	{
		if(dungeonRooms.get(15).hasPuzzle())
		{
			if(((RunePuzzle)dungeonRooms.get(15).getPuzzle()).playerHasSapphireRune(player))
			{
				blueRuneImage.setOpacity(1);
				((RunePuzzle)dungeonRooms.get(15).getPuzzle()).insertSapphireRune();
				player.getInventory().remove(((RunePuzzle)dungeonRooms.get(15).getPuzzle()).getSapphireRune());
				
				if(((RunePuzzle)dungeonRooms.get(15).getPuzzle()).isEmeraldRuneInserted())
				{
					((RunePuzzle)dungeonRooms.get(15).getPuzzle()).solvePuzzle();
				}
			}
			else
			{
				text.appendText("\n" + "\n" + "It looks like you might need to put something here");
			}
		}
	}
	
	@FXML
	private void lightFirstTorch(ActionEvent event)
	{
		if(((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).firstTorchIsLit())
		{
			firstTorchImage.setOpacity(0.5);
			((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).unlightFirstTorch();
		}
		else
		{
			firstTorchImage.setOpacity(1);
			((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).lightFirstTorch();
		}
	}
	
	@FXML
	private void lightSecondTorch(ActionEvent event)
	{
		
		if(((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).secondTorchIsLit())
		{
			secondTorchImage.setOpacity(0.5);
			((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).unlightSecondTorch();
		}
		else
		{
			secondTorchImage.setOpacity(1);
			((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).lightSecondTorch();
		}
		
		
	}
	
	@FXML
	private void lightThirdTorch(ActionEvent event)
	{
		
		if(((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).thirdTorchIsLit())
		{
			thirdTorchImage.setOpacity(0.5);
			((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).unlightThirdTorch();
		}
		else
		{
			thirdTorchImage.setOpacity(1);
			((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).lightThirdTorch();
		}
	}
	
	@FXML
	private void solveTorchesPuzzle(ActionEvent event)
	{
		((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).solvePuzzle();
		System.out.println(((TorchesPuzzle)dungeonRooms.get(24).getPuzzle()).isSolved());
	}
	
	/**
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
				
				encounterMonsterHealth.setStyle("-fx-accent: rgba(13, 199, 4, 0.40); ");
				encounterMonsterHealth.progressProperty().bind(monsterArray.get(i).getHealthPercentage());
				encounterMonsterHealth.progressProperty().addListener(new ProgressBarStyler(encounterMonsterHealth));
				
				encounterStage.show();
				combatText.appendText("\n\n" + monsterArray.get(i).getMonsterDescription());
			}		
		}
		
	}
	
	
	private void triggerPuzzle()
	{
		
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
	
	private void solveTorchPuzzle()
	{
		((TorchPuzzle)player.getCurrentRoom().getAdjacentRoom(player.getCurrentRoom().getWestExit()).getPuzzle()).solvePuzzle();
		
		if(((TorchPuzzle)player.getCurrentRoom().getAdjacentRoom(player.getCurrentRoom().getWestExit()).getPuzzle()).isSolved())
		{
			btwest.setDisable(true);
			
			Timer timer = new Timer();
			timer.schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					player.changeRoom(player.getCurrentRoom().getWestExit());
					text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
					mapView.setImage(player.getCurrentRoom().getMapLocationImage());
					checkValidExits();
					triggerMonsterEncounter();
					timer.cancel();
					timer.purge();
				}
			}, 1500);
		}
	}
	
	/*public void setRuneStage(Stage stage)
	{
		runeStage = stage;
	}*/
	
	public void restartGame()
	{
		//somehow restart the game here
		
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
