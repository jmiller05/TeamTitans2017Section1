import java.util.ArrayList;

public class Monster extends Entity {
	
	private String monsterID;
	private String monsterName;
	private String description;
	private ArrayList<Room> location = new ArrayList<Room>();
	private ArrayList<Item> itemDropped = new ArrayList<Item>();
	private ArrayList<Monster> mAL = new ArrayList<Monster>();
	
	public Monster(String ID, String name, String desc, int health, int damage)
	{
		this.monsterID = ID;
		this.monsterName = name;
		this.description = desc;
		super.health = health;
		super.damage = damage;
	}
	
	public void addItem(Item item)
	{
		itemDropped.add(item);
	}
	
	public void populateMonsters()
	{
		Monster m0 = new Monster("Mon_00", "Toxic Wolfspider", "This spider creeps in the caves of tombs and scurries around to keep you from knowing when he is going to attack. He stands tall with 8 grey and furry legs and is as tall as a wolf. As soon as you are still he slowly creep towards you and stick you with his sharp pincers and release his toxic venom.", 5, 2);
		Monster m1 = new Monster("Mon_01", "Soul Serpent", "The soul stealing serpent will attack you to steal your soul with one of its bites.", 10, 3);
		Monster m2 = new Monster("Mon_02", "Terror Tiger", "This ferocious tiger will terrorize you with razor sharp teeth and vibrant green eyes.", 15, 3);		
		Monster m3 = new Monster("Mon_03", "Tomb Phantom", "This tomb phantom haunts the tomb with his loud screeches and screams. This monster can make you deaf until next fight.", 20, 4);		
		Monster m4 = new Monster("Mon_04", "Bloodthirsty Centaur", "The bloodthirsty centaur is on the run for your flesh but most of all your fresh blood. He is all so powerful his enormous strong arms, red glowing eyes, and 8-foot stature.", 25, 4);		
		Monster m5 = new Monster("Mon_05", "Disemboweled Mummy", "This mummy is stands at an 8 foot towering height, is covered in cobwebs, and smells of road kill. He will chase you down and reach for any limb he can get so he can take your organs and feel alive once again.", 30, 4);		
		Monster m6 = new Monster("Mon_06", "The Insane Witch", "This witch will cast a spell on you and put you in another room. Her skin is a wrinkly as balled up piece of paper, she has long white hair.", 40, 5);		
		Monster m7 = new Monster("Mon_07", "Ballistic Beast", "This beast you will face is 7 foot tall, muscular, and very hairy. He will fight till the death with his large hands and sharp claws. His favorite move is ripping your heart from your chest and hearing it beat before you fall to your death.", 60, 6);
		
		mAL.add(m0); mAL.add(m1); mAL.add(m2); mAL.add(m3); 
		mAL.add(m4); mAL.add(m5); mAL.add(m6); mAL.add(m7);
	}
	
	public void attack(Entity e)
	{
		super.attack(e);
	}
	
	@Override
	public void winFight()
	{
		super.winFight();
	}
	
	@Override
	public void loseFight()
	{
		super.loseFight();
	}
}
