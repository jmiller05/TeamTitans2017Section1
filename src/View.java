import java.awt.event.ActionListener;
import java.util.Observer;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View implements Observer
{
	//These are the containers
	BorderPane anchor; //This is the primary pane that will be added to the scene and contains the other nodes
	HBox topContainer; //This will contain two more containers which will hold content
	AnchorPane textDisplayContainer; //will contain another container that contains text, to help with formatting
	ScrollPane textDisplay; //This will contain the node which displays the text
	FlowPane map; //This will contain the node which displays the map
	VBox bottomContainer; //This will contain two other containers that will go in the bottom portion of the anchor borderpane
	HBox buttonBar; //This is an HBox which will contain the action buttons
	GridPane gridpane; //This will contain the navigational buttons
	
	
	//These are the nodes which display content or that the player will directly interact with
	Button btNorth; //Button to move North
	Button btSouth; //Button to move South
	Button btEast; //Button to move East
	Button btWest; //Button to move West
	Button btNortheast; //Button to move Northeast
	Button btSoutheast; //Button to move Southeast
	Button btNorthwest; //Button to move Northwest
	Button btSouthwest; //Button to move SOuthwest
	Button btExamine; //Button to examine a room
	Button btSearch; //Button to search a room
	Button btInventory; //Button to display inventory
	TextArea text; //TextArea to display text descriptions
	ImageView mapView;
	
	
	public View()
	{
		//Initializing the containers
		anchor = new BorderPane();
		topContainer = new HBox();
		textDisplayContainer = new AnchorPane();
		textDisplay = new ScrollPane();
		map = new FlowPane();
		bottomContainer = new VBox();
		buttonBar = new HBox();
		gridpane = new GridPane();
		
		//Initializing and labeling the buttons
		btNorth = new Button("North");
		btSouth = new Button("South");
		btEast = new Button("East");
		btWest = new Button("West");
		btNortheast = new Button("Northeast");
		btSoutheast = new Button("Southeast");
		btNorthwest = new Button("Northwest");
		btSouthwest = new Button("Southwest");
		btExamine = new Button("Examine Room");
		btSearch = new Button("Search Room");
		btInventory = new Button("Show Inventory");
		
		//Some button styling
		btNorth.setStyle("-fx-font-size: 16;");
		btSouth.setStyle("-fx-font-size: 16;");
		btEast.setStyle("-fx-font-size: 16;");
		btWest.setStyle("-fx-font-size: 16;");
		btNortheast.setStyle("-fx-font-size: 16;");
		btSoutheast.setStyle("-fx-font-size: 16;");
		btNorthwest.setStyle("-fx-font-size: 16;");
		btSouthwest.setStyle("-fx-font-size: 16;");
		btExamine.setStyle("-fx-font-size: 18;");
		btSearch.setStyle("-fx-font-size: 18; ");
		btInventory.setStyle("-fx-font-size: 18; ");
		
		//Initializing and setting the content of the text area
		text = new TextArea();
		text.setWrapText(true);
		text.setText("After climbing up the stairs, you see a vaulted ceiling made from pure white marble, staggering even higher to about 30 feet high. The floor seems to be one entire slab of the same marble, completely level and smooth throughout the entire room. Lined up perfectly to the ceiling on the west and east side of the room, right before the ceiling begins to stagger upwards are 8 large marble columns giving support to the ceiling. There are many fresh corpses of humans throughout the room for what seems like a legion of men recently deceased from a gruesome battle that had to have happened within the past year. The air is thick with the stench of decay. There are 4 arches with an opening wide enough for 3 man to walk through to the North East, North West, South West, and South East. There is a set of large double doors to the North with sliver and gold plating containing 3 unlit torches to the right side of the door. To the South is the large onyx stairwell leading to the Lower Tombs.");
		
		//initializing the imageview and passing the image resource to the imageview
		mapView = new ImageView("res/mapLevel1.jpg");
		
		//Adjusting the properties of the textDisplay container and setting the content
		textDisplayContainer.setPrefHeight(1000);
		textDisplayContainer.setPrefWidth(1000);
		textDisplayContainer.setStyle("-fx-border-color: green");
		textDisplayContainer.getChildren().add(textDisplay);
		AnchorPane.setTopAnchor(textDisplay, 0.0);
		AnchorPane.setBottomAnchor(textDisplay, 0.0);
		AnchorPane.setLeftAnchor(textDisplay, 0.0);
		AnchorPane.setRightAnchor(textDisplay, 0.0);
		textDisplay.setStyle("-fx-border-color: green");
		textDisplay.setContent(text);
		textDisplay.setFitToHeight(true);
		textDisplay.setFitToWidth(true);
		
		
		//Adjusting spacing and alignment on the HBox that holds the action buttons
		buttonBar.setAlignment(Pos.CENTER);
		buttonBar.setSpacing(10);
		buttonBar.setPadding(new Insets(10, 10, 10, 10)); 
		
		//Adjusting spacing and alignment of the gridpane that holds the buttons
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		gridpane.setPadding(new Insets(10, 10, 10, 10)); 
		
		//Adjusting the sizing of the buttons
		btNorth.setMinWidth(100.0);
		btNorth.setPrefWidth(100.0);
		btNorth.setMaxWidth(100.0);
		
		btSouth.setMinWidth(100.0);
		btSouth.setPrefWidth(100.0);
		btSouth.setMaxWidth(100.0);
		
		btEast.setMinWidth(100.0);
		btEast.setPrefWidth(100.0);
		btEast.setMaxWidth(100.0);
		
		btWest.setMinWidth(100.0);
		btWest.setPrefWidth(100.0);
		btWest.setMaxWidth(100.0);
		
		btNortheast.setMinWidth(100.0);
		btNortheast.setPrefWidth(100.0);
		btNortheast.setMaxWidth(100.0);
		
		btSoutheast.setMinWidth(100.0);
		btSoutheast.setPrefWidth(100.0);
		btSoutheast.setMaxWidth(100.0);
		
		btNorthwest.setMinWidth(100.0);
		btNorthwest.setPrefWidth(100.0);
		btNorthwest.setMaxWidth(100.0);
		
		btSouthwest.setMinWidth(100.0);
		btSouthwest.setPrefWidth(100.0);
		btSouthwest.setMaxWidth(100.0);
		
		//Adding the text and map containers to the larger container
		map.setStyle("-fx-border-color: green");
		map.setPrefWidth(400);
		map.setPrefHeight(400);
		map.setMaxHeight(400);
		map.setMaxWidth(400);
		mapView.setFitHeight(450);
		mapView.setFitWidth(450);
		map.getChildren().add(mapView);
		
		//Adding the bottom two button containers to the the larger bottom container
		bottomContainer.getChildren().addAll(buttonBar,gridpane);
		bottomContainer.setPadding(new Insets(25,0,25,0));
		buttonBar.getChildren().addAll(btExamine, btSearch, btInventory);
		
		//Adding the buttons to the button container
		gridpane.add(btNorth, 1, 0);
		gridpane.add(btSouth, 1, 2);
		gridpane.add(btEast, 2, 1);
		gridpane.add(btWest, 0, 1);
		gridpane.add(btNortheast, 2, 0);
		gridpane.add(btSoutheast, 2, 2);
		gridpane.add(btNorthwest, 0, 0);
		gridpane.add(btSouthwest, 0, 2);
		
		//Adding the main two larger container to the main anchor pain
		anchor.setBottom(bottomContainer);
		anchor.setCenter(textDisplayContainer);
		anchor.setRight(map);
		
	}
	
	public Stage getStage()
	{
		Scene scene = new Scene(anchor, 1300, 700);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Tomb of Doom"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		return primaryStage;
	}
	
	
	public void addController(Controller controller)
	{
		System.out.println("View    : adding controller");
		btNorth.setOnAction(controller);
		btSouth.setOnAction(controller);
		btEast.setOnAction(controller);
<<<<<<< HEAD
		btWest.setOnAction(controller);
		btNortheast.setOnAction(controller);
		btSoutheast.setOnAction(controller);
		btNorthwest.setOnAction(controller);
		btSouthwest.setOnAction(controller);
=======
>>>>>>> a68d1c3827e5cc1dac53edf118d2083bb016f04d
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(java.util.Observable arg0, Object arg1)
	{
		// TODO Auto-generated method stub
		//System.out.println(arg1.getClass().getName());
		if(arg1.getClass().getName().equals("Room"))
		{
			btNorth.setDisable(!((Room)arg1).isValidExit("north"));
			btSouth.setDisable(!((Room)arg1).isValidExit("south"));
			btEast.setDisable(!((Room)arg1).isValidExit("east"));
			btWest.setDisable(!((Room)arg1).isValidExit("west"));
			btNortheast.setDisable(!((Room)arg1).isValidExit("northeast"));
			btSoutheast.setDisable(!((Room)arg1).isValidExit("southeast"));
			btNorthwest.setDisable(!((Room)arg1).isValidExit("northwest"));
			btSouthwest.setDisable(!((Room)arg1).isValidExit("southwest"));
			text.appendText("\n" + ((Room) arg1).getRoomDescription());
		}
		
	}
	
}
