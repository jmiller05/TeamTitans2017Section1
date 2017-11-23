import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller
{
	
	private Player player;
	private ArrayList<Room> dungeonRooms;
	private Stage inventoryStage;
	private ObservableList<Item> inventoryList;
	private ArrayList<Monster> monsterArray;
	
	@FXML
	ProgressBar health;
	@FXML
	TextArea text;
	@FXML
	Button btnnorth;
	@FXML
	Button btsouth;
	@FXML
	Button bteast;
	@FXML
	Button btwest;
	@FXML
	Button btnnortheast;
	@FXML
	Button btnnorthwest;
	@FXML
	Button btsoutheast;
	@FXML
	Button btsouthwest;
	@FXML
	ImageView mapView;
	@FXML
	TableView<Item> inventoryView;
	
	public Controller(Player player, ArrayList<Room> dungeonRooms)
	{
		this.player = player;
		this.dungeonRooms = dungeonRooms;
	}
	
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	public void setDungeonRooms(ArrayList<Room> dungeonRooms)
	{
		this.dungeonRooms = dungeonRooms;
	}
	
	public void setInventoryStage(Stage stage)
	{
		this.inventoryStage = stage;
	}
	
	public void setMonsterArray(ArrayList<Monster> mAL)
	{
		this.monsterArray = mAL;
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
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
			
			//player.addItemToInventory(new Armor(1,"Leather Armor","Leather armor for better dexterity"));
			//player.addItemToInventory(new Armor(2,"Bronze Helment","A a strong helmet"));
			//player.addItemToInventory(new Weapon(3,"Sword","A strong sword for killing"));
		}
		
		inventoryList = FXCollections.<Item>observableArrayList();
		inventoryList.addAll(player.getInventory());
		
		health.progressProperty().bind(player.getHealth().divide(player.getMaxHealth()));
		
		
		
		//System.out.println(inventoryList);
	}
	
	@FXML
	private void moveNorth(ActionEvent event)
	{
		//System.out.println(player); 
		
		if(player.getCurrentRoom().getNorthExit().isLocked())
		{
			text.appendText("\n" + "\n" + player.getCurrentRoom().getNorthExit().getLockDescription());
		}
		else
		{
			//player.takeDamage(1);
			//System.out.println(player.getHealth());
			player.changeRoom(player.getCurrentRoom().getNorthExit());
			text.appendText("\n" + "\n" + player.getCurrentRoom().getRoomDescription());
			mapView.setImage(player.getCurrentRoom().getMapLocationImage());
			checkValidExits();
			//player.addItemToInventory(new Weapon(4,"Axe","And my axe"));
			//inventoryList.add(player.getInventory().get(3));
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
	
	@FXML
	private void showInventory(ActionEvent event)
	{
		inventoryView.setItems(inventoryList);
		inventoryStage.show();	
	}
	
	@FXML
	private void examineMonster(ActionEvent event)
	{
		for(int i = 0; i < monsterArray.size(); i++)
		{
			if( player.getCurrentRoom().equals(monsterArray.get(i).getLocation()) )
			{
				text.appendText("\n\n" + monsterArray.get(i).getMonsterDescription());
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
	
}
