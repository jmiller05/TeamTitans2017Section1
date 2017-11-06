import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller implements EventHandler<ActionEvent>
{
	View view;
	
	/* (non-Javadoc)
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(ActionEvent event)
	{
		// TODO Auto-generated method stub
		if (event.getSource()== view.btNorth)
		{
			view.text.appendText("\n" + "North");
		}
		else if (event.getSource().equals(view.btSouth))
		{
			view.text.appendText("\n" + "South");
		}
		
	}
	
	public void addView(View v)
	{
		System.out.println("Controller: adding view");
		this.view = v;
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



