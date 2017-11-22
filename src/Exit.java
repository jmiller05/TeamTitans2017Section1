import java.io.Serializable;

public class Exit implements Serializable
{
	static final long serialVersionUID = 286;
	
	private int exitID;
	private Room roomA;
	private Room roomB;
	private boolean isLocked;
	private String lockDescription;
	
	public Exit(int exitID)
	{
		this.exitID = exitID;
		this.isLocked = false;
	}
	
	public Exit(int exitID, Room roomA, Room roomB)
	{
		this.exitID = exitID;
		this.roomA = roomA;
		this.roomB = roomB;
		this.isLocked = false;
	}
	
	public Room getRoomA()
	{
		return roomA;
	}
	
	public Room getRoomB()
	{
		return roomB;
	}
	
	public String getLockDescription()
	{
		return this.lockDescription;
	}
	
	public void setRoomA(Room roomA)
	{
		this.roomA = roomA;
	}
	
	public void setRoomB(Room roomB)
	{
		this.roomB = roomB;
	}
	
	public void setLockDescription(String desc)
	{
		this.lockDescription = desc;
	}
	
	public void lockExit()
	{
		this.isLocked = true;
	}
	
	public boolean isLocked()
	{
		return this.isLocked;
	}

}
