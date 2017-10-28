import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends Application
{
	VBox anchor;
	HBox topContainer;
	ScrollPane textDisplay;
	Pane map;
	
	
	
	protected Text text = new Text(50, 50, "JavaFX Programming");
	
	protected BorderPane getPane()
	{
		Button btNorth = new Button("North");
		Button btSouth = new Button("South");
		Button btEast = new Button("East");
		Button btWest = new Button("West");
		Button btNortheast = new Button("Northeast");
		Button btSoutheast = new Button("Southeast");
		Button btNorthwest = new Button("Northwest");
		Button btSouthwest = new Button("Southwest");
		
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
		
		GridPane gridpane = new GridPane();
		
		gridpane.setAlignment(Pos.CENTER);
	    //gridpane.setStyle("-fx-border-color: green");
	    gridpane.setHgap(5);
	    gridpane.setVgap(5);
	    gridpane.setPadding(new Insets(10, 10, 10, 10)); 
	    
		
		gridpane.add(btNorth, 1, 0);
		gridpane.add(btSouth, 1, 2);
		gridpane.add(btEast, 2, 1);
		gridpane.add(btWest, 0, 1);
		gridpane.add(btNortheast, 2, 0);
		gridpane.add(btSoutheast, 2, 2);
		gridpane.add(btNorthwest, 0, 0);
		gridpane.add(btSouthwest, 0, 2);

		BorderPane pane = new BorderPane();
		pane.setBottom(gridpane);
		    
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);
		    
		//btLeft.setOnAction(e -> text.setX(text.getX() - 10));
		//btRight.setOnAction(e -> text.setX(text.getX() + 10));
		    
		return pane;
	}
	
	public void start(Stage primaryStage)
	{
	    // Create a scene and place it in the stage
	    Scene scene = new Scene(getPane(), 1000, 500);
	    primaryStage.setTitle("Tomb of Doom"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	 }
	
	public static void main(String[] args)
	{
	    launch(args);
	}
}
