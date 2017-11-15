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
		if (event.getSource()== view.btNorth)
		{
			model.changeRoom(model.getCurrentRoom().getNorthExit());
		}
		else if (event.getSource().equals(view.btSouth))
		{
			model.changeRoom(model.getCurrentRoom().getSouthExit());
		}
		else if (event.getSource().equals(view.btEast))
		{
			model.changeRoom(model.getCurrentRoom().getEastExit());
		}
		else if (event.getSource().equals(view.btWest))
		{
			model.changeRoom(model.getCurrentRoom().getWestExit());
		}
		else if (event.getSource().equals(view.btNortheast))
		{
			model.changeRoom(model.getCurrentRoom().getNorthEastExit());
		}
		else if (event.getSource().equals(view.btNorthwest))
		{
			model.changeRoom(model.getCurrentRoom().getNorthWestExit());
		}
		else if (event.getSource().equals(view.btSoutheast))
		{
			model.changeRoom(model.getCurrentRoom().getSouthEastExit());
		}
		else if (event.getSource().equals(view.btSouthwest))
		{
			model.changeRoom(model.getCurrentRoom().getSouthWestExit());
		}
		else if (event.getSource().equals(view.btExamineMonster))
		{
			if(model.roomHasMonster(model.getCurrentRoom()) == true)
			{
				model.getMonsterDesc();
			}
		}
		
		else if (event.getSource().equals(view.btSearch)) 
		{
			if(model.roomHasWeapon(model.getCurrentRoom())== true) 
			{
				model.getItemDesc();
			}
		}
		
		else if (event.getSource().equals(view.btExaminePuzzle))
		{
			if(model.roomHasPuzzle(model.getCurrentRoom()) == true)
			{
				model.getPuzzleDesc();
			}
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
	
}



