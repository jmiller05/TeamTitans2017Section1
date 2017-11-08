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
		else if( event.getSource().equals(view.btEast))
		{
			//if in room 00, east button should take you to room 02
		}
		
		
	}
	
	public void addView(View v)
	{
		System.out.println("Controller: adding view");
		this.view = v;
	}
	
<<<<<<< HEAD
	public void addModel(Model m)
	{
		System.out.println("Controller: adding model");
		this.model = m;
	}
	
=======
	//initialize the monsters
>>>>>>> a68d1c3827e5cc1dac53edf118d2083bb016f04d
	public void addMonsters(Monster m)
	{
		m.populateMonsters();	
	}
	
	//set possible room locations for each monster
	//might have to change location arrayList in Monster class, each monster needs its own list.
	//	public void addMonsterRooms(Monster m)
	//	{
	//		m.getMonsterArray().get(0).addLocation(RM_4);
	//		m.getMonsterArray().get(0).addLocation(RM_5);
	//		
	//		m.getMonsterArray().get(1).addLocation(RM_17);
	//		m.getMonsterArray().get(1).addLocation(RM_13);
	//		m.getMonsterArray().get(1).addLocation(RM_11);
	//		
	//		m.getMonsterArray().get(2).addLocation(RM_16);
	//		m.getMonsterArray().get(2).addLocation(RM_14);
	//		m.getMonsterArray().get(2).addLocation(RM_12);
	//		
	//		m.getMonsterArray().get(3).addLocation(RM_22);
	//		m.getMonsterArray().get(3).addLocation(RM_23);
	//		
	//		m.getMonsterArray().get(4).addLocation(RM_18);
	//		
	//		m.getMonsterArray().get(5).addLocation(RM_25);
	//		m.getMonsterArray().get(5).addLocation(RM_26);
	//		m.getMonsterArray().get(5).addLocation(RM_26);
	//		m.getMonsterArray().get(5).addLocation(RM_28);
	//		
	//		m.getMonsterArray().get(6).addLocation(RM_20);
	//		
	//		m.getMonsterArray().get(7).addLocation(RM_29);
	//		
	//	}
	
	public void addRooms(Room r)
	{
		r.populateRooms();
	}
	
	public void setExits(Room r, Exit e, String d)
	{
		r.setExit(e, d);
	}
	
}



