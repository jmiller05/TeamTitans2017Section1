public class Exit 
{

	private int exitID;
	private Room roomA;
	private Room roomB;
	
	public Exit(int exitID, Room roomA, Room roomB)
	{
		this.exitID = exitID;
		this.roomA = roomA;
		this.roomB = roomB;
	}
	
	public Room getRoomA()
	{
		return roomA;
	}
	
	public Room getRoomB()
	{
		return roomB;
	}
	

	
	
}
