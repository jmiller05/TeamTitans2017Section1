import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller implements EventHandler<ActionEvent>
{
	View view;
	Model model;
	
	/* (non-Javadoc)
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(ActionEvent event)
	{
		// TODO Auto-generated method stub
		if (event.getSource()== view.btNorth)
		{
			model.changeRoom(model.currentRoom.getNorthExit());
		}
		else if (event.getSource().equals(view.btSouth))
		{
			model.changeRoom(model.currentRoom.getSouthExit());
		}
		else if (event.getSource().equals(view.btEast))
		{
			model.changeRoom(model.currentRoom.getEastExit());
		}
		else if (event.getSource().equals(view.btWest))
		{
			model.changeRoom(model.currentRoom.getWestExit());
		}
		else if (event.getSource().equals(view.btNortheast))
		{
			model.changeRoom(model.currentRoom.getNorthEastExit());
		}
		else if (event.getSource().equals(view.btNorthwest))
		{
			model.changeRoom(model.currentRoom.getNorthWestExit());
		}
		else if (event.getSource().equals(view.btSoutheast))
		{
			model.changeRoom(model.currentRoom.getSouthEastExit());
		}
		else if (event.getSource().equals(view.btSouthwest))
		{
			model.changeRoom(model.currentRoom.getSouthWestExit());
		}
		
		
	}
	
	public void addView(View v)
	{
		System.out.println("Controller: adding view");
		this.view = v;
	}
	
	public void addModel(Model m)
	{
		System.out.println("Controller: adding model");
		this.model = m;
	}
	
	public void initModel()
	{
		model.modelStart();
	}
	
	public void addMonsters(Monster m)
	{
		try{
			m.populateMonsters();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}



