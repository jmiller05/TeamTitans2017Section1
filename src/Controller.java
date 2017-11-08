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
	
	//initialize the monsters
	public void addMonsters(Monster m)
	{
		m.populateMonsters();	
	}
	
	//set possible room locations for each monster
	//might have to change location arrayList in Monster class, each monster needs its own list.
	public void addMonsterRooms(Monster m)
	{
		m.getMonsterArray().get(0).addLocation(RM_4);
		m.getMonsterArray().get(0).addLocation(RM_5);
		
		m.getMonsterArray().get(1).addLocation(RM_17);
		m.getMonsterArray().get(1).addLocation(RM_13);
		m.getMonsterArray().get(1).addLocation(RM_11);
		
		m.getMonsterArray().get(2).addLocation(RM_16);
		m.getMonsterArray().get(2).addLocation(RM_14);
		m.getMonsterArray().get(2).addLocation(RM_12);
		
		m.getMonsterArray().get(3).addLocation(RM_22);
		m.getMonsterArray().get(3).addLocation(RM_23);
		
		m.getMonsterArray().get(4).addLocation(RM_18);
		
		m.getMonsterArray().get(5).addLocation(RM_25);
		m.getMonsterArray().get(5).addLocation(RM_26);
		m.getMonsterArray().get(5).addLocation(RM_26);
		m.getMonsterArray().get(5).addLocation(RM_28);
		
		m.getMonsterArray().get(6).addLocation(RM_20);
		
		m.getMonsterArray().get(7).addLocation(RM_29);
		
	}
	
}



