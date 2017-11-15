import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import javafx.scene.image.Image;


/**
 * @author Evan, Brad, Jessie, Josh
 *
 */
public class Model extends Observable
{
	private ArrayList<Room> roomAL; //ArrayList of Rooms
	private ArrayList<String> roomNameAL; //ArrayList of Room Names
	private ArrayList<String> roomDescriptionAL; // Array List of room descriptions
	private ArrayList<Exit> exitAL; //Array List of exits
	private Room currentRoom;
	private ArrayList<Monster> monsterArray = new ArrayList<Monster>();
	private ArrayList<Artifact> artifactArray = new ArrayList<Artifact>();
	private ArrayList<Weapon> weaponArray = new ArrayList<Weapon>();
	private ArrayList<Armor> armorArray = new ArrayList<Armor>();
	private ArrayList<Puzzle> puzzleArray = new ArrayList<Puzzle>();
	private Random rand = new Random();

	private Weapon currentItem;
	@SuppressWarnings("rawtypes")
	//ArrayList<ArrayList> itemArray = new ArrayList<ArrayList> ( );
	private Monster currentMonster;
	private Puzzle currentPuzzle;
	
	public Model()
	{
		this.populateRooms();
		this.assignExits();
		this.assignRoomImages();
		this.populateMonsters();
		this.addMonsterRooms();
		//this.populateArmor();
		//this.populateArtifact();
		this.populateWeapon();
		//itemArray.add(weaponArray);
		//itemArray.add(armorArray);
		//itemArray.add(artifactArray);
	}
	
	public void populateRooms()
	{
		roomAL = new ArrayList<Room>();
		roomNameAL = new ArrayList<String>();
		roomDescriptionAL = new ArrayList<String>();
		
		roomNameAL.add(0, "Cave Entrance");
		roomNameAL.add(1, "Crumbling Room");
		roomNameAL.add(2, "Map Room");
		roomNameAL.add(3, "Cavern");
		roomNameAL.add(4, "Spider Room");
		roomNameAL.add(5, "Unknown Heroes Tomb");
		roomNameAL.add(6, "Cavern Pit");
		roomNameAL.add(7, "Breached Cavern");
		roomNameAL.add(8, "Corridor of Water");
		roomNameAL.add(9, "Cave Exit");
		roomNameAL.add(10, "Entrance to Lower Tombs");
		roomNameAL.add(11, "Sapphire Studies");
		roomNameAL.add(12, "Emerald Studies");
		roomNameAL.add(13, "Sapphire Storage Facility");
		roomNameAL.add(14, "Emerald Storage Facility");
		roomNameAL.add(15, "Ruby of Wonders");
		roomNameAL.add(16, "Emerald Mausoleum");
		roomNameAL.add(17, "Sapphire Mausoleum");
		roomNameAL.add(18, "Banquet Hall");
		roomNameAL.add(19, "Study Room");
		roomNameAL.add(20, "Alchemist's Lab");
		roomNameAL.add(21, "Entrance to Upper Tomb");
		roomNameAL.add(22, "Torture Chamber");
		roomNameAL.add(23, "Holding Cells");
		roomNameAL.add(24, "Grand Hall");
		roomNameAL.add(25, "Southwest Tomb");
		roomNameAL.add(26, "Southeast Tomb");
		roomNameAL.add(27, "Northwest Tomb");
		roomNameAL.add(28, "Northeast Tomb");
		roomNameAL.add(29, "Hall of Heroes");
		roomNameAL.add(30, "Tomb of Doom Exit");
		
		
		roomDescriptionAL.add(0, "After regaining consciousness, you begin to focus looking around the room to see where you have landed. The only light that emits into the cave is from the hole which was created from where you fell. The walls are covered in dead roots all extending towards the hole in the ceiling. There is a branch on the floor. You are able to see an opening to the North and another opening to the East.");
		roomDescriptionAL.add(1, "Upon squeezing into this room, you notice that this room has not been disturbed in many years. The walls have mostly caved in, leaving piles of stone leading up to the mostly dirt walls. There isn't much space to move around, except for a few feet ahead of you.");
		roomDescriptionAL.add(2, "As you enter this room, you barely make out a parchment that is laying on the ground, presumably a map that was dropped years ago from a possible adventurer. The room is dark and damp, but able to make out from what little light that shines through from the previous room you left. The walls are mostly compacted dirt with a few roots scattered across the room. The only doorway is to the West, from which you came from.");
		roomDescriptionAL.add(3, "After entering this cavern, the light from where you entered emits just enough glow throughout the room reflecting off the naturally formed rocks with stalagmites hanging about 20 feet in the air from the ceiling. The jagged rocks around the perimeter of the room look to have been shaped with pickaxes long ago. The entire room is damp from humidity, working in your favor as it is helping reflect enough light to make out the dim room. You noticed a small man size hole directly to the East that you can see a flickering of light. There is another small hole to the North East big enough to crawl through, and another man sized opening to the North West.");
		roomDescriptionAL.add(4, "Crawling through debris and into the room, you are able to see well in this room. There is a torch mounted on the wall, unknown as to how it is lit or how long it has been burning. The room contains many skeletal remains scattered throughout. Ranging through the walls of the room, there are large, thick silver webs that contain the skeletal remains of many different creatures, including humans. To the north there is a larger passage that is covered in more webs than you would like to push through and a small crawlable hole to the west. ");
		roomDescriptionAL.add(5, "Entering this room, you see half rotten corpses and skeletal remains of humans throughout the room. The sight of the legion of corpses send chills down your spine, hoping you will not encounter the same fate as the other men in this room. The walls of the room contain large, thick silver webs that also possess the skeletal remains of many different creatures, including humans. Three of the giant webs look as if they might carry something useful. There is a small crawlable hole to the West and a passage covered in webs to the South.");
		roomDescriptionAL.add(6, "Upon entering this room, you notice a large pit in the center of the room, unknown as to how far it goes down. You are unable to see the ceiling as the light is not emitting bright enough to see. The walls contain sources of precious metals as you can make out veins of copper and iron scattered along the perimeter. You can hear and feel a breeze of wind, believing that the draft could possibly be coming from the North. There is a naturally formed pathway around the pit to the North with a man-sized hole. There is also a formed pathway to the South with a hole barely large enough to squeeze through.");
		roomDescriptionAL.add(7, "Upon entering this room, you notice that the entire floor is made from smooth stones that have been hewed by someone. The walls are also made from hewed stones stacked on top of one another. You immediately notice a stone door to the North which looks as if it hasn't been opened in many years and you can see where a key could be used. There is a heavy draft that you can hear and feel coming from behind this door.");
		roomDescriptionAL.add(8, "Entering this room, you notice two pathways on each side of the room with a small ditch carved out into the ground in between the paths. The floor has hewed stones laid out on either sides of the ditch. The walls have hewed stones stacked laid perfectly by a mason. To the East is a metal bar door.");
		roomDescriptionAL.add(9, "Inside this room, you immediately notice a giant stone stairwell spiraling up wide enough for two men to walk comfortably in the North East section of the room. The room contains a corpse of a man at the bottom of the stairwell wearing leather armor whose fate is unknown to you. It seems that the man has not been dead for very long, as the rest of the room contains dust mixed with dirt thick enough to leave footprints. The only doorway is to the West.");
		roomDescriptionAL.add(10, "Entering into this room, you immediately notice that you are no longer in a damp cave. The walls, floor, and ceiling seen to be made out of dark marble that has been cut with precision. Beautiful stonework with mosaic of jewels are on each of the walls. There are sets of two unlit torches next to each door. You see a stone door to the East, containing sapphire gems above the door. To the North is a metal door with ruby gems above it. There is a door to the West containing emerald gemstones above it.");
		roomDescriptionAL.add(11, "There is an unlit fire pit in center of room. Blue stonework and mosaic sapphire gems are along the walls. There are cobwebs throughout the corners of the room with dust covering most of the floor. You can see a trail through the dust where something has been sliding across the floor. There is a metal door to the North with rubies above the door. To the East is a metal door. To the West you see a stone door.");
		roomDescriptionAL.add(12, "There is an unlit Fire Pit in center of the room. Emerald stonework and gemstone mosaics along the walls. There is a metal door to the West. To the North East corner of the room there is a metal door with rubies above the door. The East wall has a stone door with emerald gemstones above it. ");
		roomDescriptionAL.add(13, "Wall covered in shattered glass (mosaic) reflecting blue light into the room. Seems to have been created with great care to torture to the mind, seeming to bend reality as the door closes behind you. The floor has shimmering blue glass scattered throughout the room. There is a metal door to the North. There is a metal door to the South West with sapphire gemstones decorated above the door.");
		roomDescriptionAL.add(14, "Wall covered in shattered glass (mosaic) reflecting emerald light into the room. Black dust covers the walls and doors. Even the air is thick with dust. Bones are scattered across the room. There are broken urns in each corner of the room which have been covered in cobwebs. To the North is a metal door. To the South East is a metal door. ");
		roomDescriptionAL.add(15, "As you enter this room, the walls and floor being to reflect bright red stonework with engravings faintly glowing red. Over the floor you can see vines which have extended from each corner of the room towards the center, forming a near perfect circle in the center of the room. In the center of the vines, there is a stone hole which has been filled with a glowing red liquid, unknown of its composition. To the North is a metal door behind an additional barred door, where above the door you see a red rune in the middle, but two missing runes on each side of it. To the South is a metal door. To the South West is a metal door with emeralds decorated above the door. To the South East contains sapphire gemstones above a metal door.");
		roomDescriptionAL.add(16, "The walls and floor being to reflect bright red and stonework with engravings faintly glowing red. The room is mostly empty, except for a single large tomb made from stone with a plethora of carvings that have had almost been worn out, almost unable to see. The cover of the tomb seems to have been smashed, caving in onto of a resting corpse. To the East is a metal door behind an additional barred door. To the South, you see a metal door.");
		roomDescriptionAL.add(17, "This room is covered in eggs as large as a man's fist, most of them have been entirely smashed. Upon examining, you notice that the eggs belong to some type of serpent, hopefully not having to encounter such a creature. the walls and floor being to reflect bright blue and stonework with engravings faintly glowing blue.");
		roomDescriptionAL.add(18, "Upon entering this room, you see beautiful, ornate humanoid chameleon-like warrior statues lined throughout the east and west walls with unlit wall torches in between each of the statues. The walls and floor appear to be made out of limestone which have been decorated with silver engravings. Cobwebs are scattered throughout the room, prominently in the corners of the room. The ceiling contains three large metal chandeliers that are circular in shape with candles that have been lit, emitting a glow blue. There are many skeletal corpses with the skulls all missing laid out throughout the room. You can see 4 piles that are stacked perfectly 6 feet high of human skulls. There is a metal door to the South. To the North is a giant double metal door decorated in gold and silver. To the North West and North East are two wooden doors. To the South West and South East are two metal doors.");
		roomDescriptionAL.add(19, "Upon entering this room, you notice the floor is made from poorly crafted wood. There is a makeshift bed in corner of room with the remains of two skeletal human bodies. There are bookcases filled with tattered tomes along the entire northern wall. You can see a small wooden table in the center of the room big enough to sit 6 at the table, each with a chair in the spots. To the East there is a wooden door. To the North contains a metal door.");
		roomDescriptionAL.add(20, "The floor is weathered planks covered in dust and debris. In the corner of the room across from the door there is a massive alchemists desk littered with vials and parchment. There is a bookcase to the left of the desk with tomes and jars containing various organs in a murky liquid. There is a pallet bed of pillows and fur on the South wall with a lantern and a medicine bag on the floor next to it. To the West is a wooden door. To the North there is a metal door.");
		roomDescriptionAL.add(21, "Directly to the north you see a double wide staircase made out of onyx with a red velvet carpet in the center leading to the top of the staircase. The walls are also made from onyx with red tapestries lining each side of the walls. These tapestries have an emblem of a skull without a jaw and a serpent intertwined through the eyeholes raising above the skull. To the south is a giant double metal door decorated in gold and silver. To the West and the East are two caged metal doors, able to see through the bars only enough to know something evil has happened in each of these rooms.");
		roomDescriptionAL.add(22, "As you enter you note tables lining the wall to right they are covered in body parts and horrific tools for torture. Along the north wall there are mummified corpses shackled to the walls. In the center of the room there is a cage large enough to hold several men. The floor of this cage is covered in jagged pieces of slate angled to inflict pain on the caged. Spears are secured between every bar of the cage seemingly placed there to prod the inhabitants across the sharp rocks. The entire room is a muted gray that reinforces the utter despair of the room. In the back corner of the room is a pile of broken tables. One intact table still stands, black with aged blood and leather straps to secure the poor soul in place. There is a caged door to the East that you can see through.");
		roomDescriptionAL.add(23, "Cages barely large enough for a small man line the North and East walls, and the length of the South wall to the left of another door. To your right is a wooden bin that contains more human remains, as if preparation for disposal. The corpses in these cages were not clothed but collared and chained to the floor. To the left of the door are two large cabinets made of dark wood. The door to one has fallen to the floor and you can see collars, chains, and iron pokers. There are two floor lamps down the length of the room with iron pokers resting inside. There is a caged door to the West that you can see through.");
		roomDescriptionAL.add(24, "After climbing up the stairs, you see a vaulted ceiling made from pure white marble, staggering even higher to about 30 feet high. The floor seems to be one entire slab of the same marble, completely level and smooth throughout the entire room. Lined up perfectly to the ceiling on the west and east side of the room, right before the ceiling begins to stagger upwards are 8 large marble columns giving support to the ceiling. There are many fresh corpses of humans throughout the room for what seems like a legion of men recently deceased from a gruesome battle that had to have happened within the past year. The air is thick with the stench of decay. There are 4 arches with an opening wide enough for 3 man to walk through to the North East, North West, South West, and South East. There is a set of large double doors to the North with sliver and gold plating containing 3 unlit torches to the right side of the door. To the South is the large onyx stairwell leading to the Lower Tombs.");
		roomDescriptionAL.add(25, "Tombs are carved into the white marble walls. The dead can be seen covered in tattered linen, some with their worldly possessions. There is a large yet simple sarcophagus beautifully constructed of the darkest onyx. There are floor lanterns in each corner of the tomb, and a wall torch next to the arch. At the foot of the sarcophagus there is a small bench to mourn the revered fallen. There is a large archway to the North and to the East.");
		roomDescriptionAL.add(26, "Tombs are carved into the white marble walls. The dead can be seen covered in tattered linen, some with their worldly possessions (swords, books, etc). There is a large yet simple sarcophagus beautifully constructed of the darkest onyx. There are floor lanterns in each corner of the tomb, and a wall torch next to the arch. At the foot of the sarcophagus there is a small bench to mourn the revered fallen. There is a large archway to the North and to the West.");
		roomDescriptionAL.add(27, "Tombs are carved into the white marble walls. The dead can be seen covered in tattered linen, some with their worldly possessions. There is a large yet simple sarcophagus beautifully constructed of the darkest onyx. There are floor lanterns in each corner of the tomb, and a wall torch next to the arch. At the foot of the sarcophagus there is a small bench to mourn the revered fallen. There is a large archway to the South and to the East.");
		roomDescriptionAL.add(28, "Tombs are carved into the white marble walls. The dead can be seen covered in tattered linen, some with their worldly possessions. There is a large yet simple sarcophagus beautifully constructed of the darkest onyx. There are floor lanterns in each corner of the tomb, and a wall torch next to the arch. At the foot of the sarcophagus there is a small bench to mourn the revered fallen. There is a large archway to the South and to the East.");
		roomDescriptionAL.add(29, "Monstrous room with hulking paintings depicting battles of the past. Large banners portraying an emblem of a skull without a jaw and a serpent intertwined through the eyeholes raising above the skull drape the columns that support the ceiling which is 20 feet high. In each corner of the room the fire in each of the enormous pits is ablaze. You can see 3 empty pedestals in the center of the room, with a round cutout in the center of each. To the South is a set of large double doors to the North with silver and gold plating. To the North you can see a large marble double door with light protruding through the cracks.");
		roomDescriptionAL.add(30, "You beat the game and escaped the tomb! Welcome to the outside world!");
		
		for (int i = 0; i <= 30; i++)
		{
			roomAL.add(i, new Room(i,roomNameAL.get(i),roomDescriptionAL.get(i)));
		}
	}
	
	public void assignExits()
	{
		exitAL = new ArrayList<Exit>();
		//Creating the exits and pairing up rooms
		exitAL.add(0, new Exit(0,roomAL.get(0),roomAL.get(3)));
		exitAL.add(1, new Exit(0,roomAL.get(0),roomAL.get(2)));
		exitAL.add(2, new Exit(0,roomAL.get(3),roomAL.get(4)));
		exitAL.add(3, new Exit(0,roomAL.get(3),roomAL.get(5)));
		exitAL.add(4, new Exit(0,roomAL.get(4),roomAL.get(5)));//jkhghg
		exitAL.add(5, new Exit(0,roomAL.get(3),roomAL.get(6)));
		exitAL.add(6, new Exit(0,roomAL.get(6),roomAL.get(1)));
		exitAL.add(7, new Exit(0,roomAL.get(6),roomAL.get(7)));
		exitAL.add(8, new Exit(0,roomAL.get(7),roomAL.get(8)));
		exitAL.add(9, new Exit(0,roomAL.get(8),roomAL.get(9)));
		
		//Assigning the direction of the exits of room 0
		roomAL.get(0).setExit(exitAL.get(0),"north");
		roomAL.get(0).setExit(exitAL.get(1),"east");
		//Assigning the direction of the exits of room 1
		roomAL.get(1).setExit(exitAL.get(6),"north");
		//Assigning the direction of the exits of room 2
		roomAL.get(2).setExit(exitAL.get(1),"west");
		//Assigning the direction of the exits of room 3
		roomAL.get(3).setExit(exitAL.get(0),"south");
		roomAL.get(3).setExit(exitAL.get(2),"southeast");
		roomAL.get(3).setExit(exitAL.get(3),"northeast");
		roomAL.get(3).setExit(exitAL.get(5),"west");
		//Assigning the direction of the exits of room 4
		roomAL.get(4).setExit(exitAL.get(2),"west");
		roomAL.get(4).setExit(exitAL.get(4),"north");
		//Assigning the direction of the exits of room 5
		roomAL.get(5).setExit(exitAL.get(3),"west");
		roomAL.get(5).setExit(exitAL.get(4),"south");
		//Assigning the direction of the exits of room 6
		roomAL.get(6).setExit(exitAL.get(5),"east");
		roomAL.get(6).setExit(exitAL.get(6),"south");
		roomAL.get(6).setExit(exitAL.get(7),"north");
		//Assigning the direction of the exits of room 7
		roomAL.get(7).setExit(exitAL.get(7),"south");
		roomAL.get(7).setExit(exitAL.get(8),"north");
		//Assigning the direction of the exits of room 8
		roomAL.get(8).setExit(exitAL.get(8),"south");
		roomAL.get(8).setExit(exitAL.get(9),"east");
		//Assigning the direction of the exits of room 9
		roomAL.get(9).setExit(exitAL.get(9),"west");
		
	}
	
	public void assignRoomImages()
	{
		roomAL.get(0).setMapLocationImage(new Image("res/Room_00.jpg"));
		roomAL.get(1).setMapLocationImage(new Image("res/Room_01.jpg"));
		roomAL.get(2).setMapLocationImage(new Image("res/Room_02.jpg"));
		roomAL.get(3).setMapLocationImage(new Image("res/Room_03.jpg"));
		roomAL.get(4).setMapLocationImage(new Image("res/Room_04.jpg"));
		roomAL.get(5).setMapLocationImage(new Image("res/Room_05.jpg"));
		roomAL.get(6).setMapLocationImage(new Image("res/Room_06.jpg"));
		roomAL.get(7).setMapLocationImage(new Image("res/Room_07.jpg"));
		roomAL.get(8).setMapLocationImage(new Image("res/Room_08.jpg"));
		roomAL.get(9).setMapLocationImage(new Image("res/Room_09.jpg"));
		
	}
	
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom)
	{
		this.currentRoom = currentRoom;
	}
	
	public void populateMonsters()
	{
		Monster m0 = new Monster("Mon_00", "Toxic Wolfspider", "This spider creeps in the caves of tombs and scurries around to keep you from knowing when he is going to attack. He stands tall with 8 grey and furry legs and is as tall as a wolf. As soon as you are still he slowly creep towards you and stick you with his sharp pincers and release his toxic venom.", 5, rand.nextInt(2) + 1);
		Monster m1 = new Monster("Mon_01", "Soul Serpent", "The soul stealing serpent will attack you to steal your soul with one of its bites.", 10, rand.nextInt(3) + 1);
		Monster m2 = new Monster("Mon_02", "Terror Tiger", "This ferocious tiger will terrorize you with razor sharp teeth and vibrant green eyes.", 15, rand.nextInt(3) + 1);		
		Monster m3 = new Monster("Mon_03", "Tomb Phantom", "This tomb phantom haunts the tomb with his loud screeches and screams. This monster can make you deaf until next fight.", 20, rand.nextInt(4) + 1);		
		Monster m4 = new Monster("Mon_04", "Bloodthirsty Centaur", "The bloodthirsty centaur is on the run for your flesh but most of all your fresh blood. He is all so powerful his enormous strong arms, red glowing eyes, and 8-foot stature.", 25, rand.nextInt(4) + 1);		
		Monster m5 = new Monster("Mon_05", "Disemboweled Mummy", "This mummy is stands at an 8 foot towering height, is covered in cobwebs, and smells of road kill. He will chase you down and reach for any limb he can get so he can take your organs and feel alive once again.", 30, rand.nextInt(4) + 1);		
		Monster m6 = new Monster("Mon_06", "The Insane Witch", "This witch will cast a spell on you and put you in another room. Her skin is a wrinkly as balled up piece of paper, she has long white hair.", 40, rand.nextInt(5) + 1);		
		Monster m7 = new Monster("Mon_07", "Ballistic Beast", "This beast you will face is 7 foot tall, muscular, and very hairy. He will fight till the death with his large hands and sharp claws. His favorite move is ripping your heart from your chest and hearing it beat before you fall to your death.", 60, rand.nextInt(5) + 2);
		
		monsterArray.add(m0); monsterArray.add(m1); monsterArray.add(m2); monsterArray.add(m3); 
		monsterArray.add(m4); monsterArray.add(m5); monsterArray.add(m6); monsterArray.add(m7);
	}
	
	public void addMonsterRooms()
	{
		monsterArray.get(0).addLocation(roomAL.get(4));
		monsterArray.get(0).addLocation(roomAL.get(5));
		
		monsterArray.get(1).addLocation(roomAL.get(11));
		monsterArray.get(1).addLocation(roomAL.get(13));
		monsterArray.get(1).addLocation(roomAL.get(17));
		
		monsterArray.get(2).addLocation(roomAL.get(12));
		monsterArray.get(2).addLocation(roomAL.get(14));
		monsterArray.get(2).addLocation(roomAL.get(16));
		
		monsterArray.get(3).addLocation(roomAL.get(22));
		monsterArray.get(3).addLocation(roomAL.get(23));
		
		monsterArray.get(4).addLocation(roomAL.get(18));
		
		monsterArray.get(5).addLocation(roomAL.get(25));
		monsterArray.get(5).addLocation(roomAL.get(26));
		monsterArray.get(5).addLocation(roomAL.get(27));
		monsterArray.get(5).addLocation(roomAL.get(28));
		
		monsterArray.get(6).addLocation(roomAL.get(20));
		
		monsterArray.get(7).addLocation(roomAL.get(29));
	}
	
	/**public void populateArtifact() 
	{
		
		Artifact art0 = new Artifact ("art_00", "Map", "Shows the map of the entire dungeon", null, roomAL.get(2));
		Artifact art1 = new Artifact ("art_01", "Potion Bottle", "Restores any lost HP", null, roomAL.get(20));
		Artifact art2 = new Artifact ("art_02", "Well of Life", "Restores any lost HP - Fills Potion Bottle", null, roomAL.get(15));
		Artifact art3 = new Artifact ("PZ00_00", "Torch", "Emits a light to see through the darkness", null, roomAL.get(4));	
		Artifact art4 = new Artifact ("PZ01_00", "Emerald Rune", "A glowing green stone", null, roomAL.get(16));
		Artifact art5 = new Artifact ("PZ01_01", "Sapphire Rune", "A glowing blue stone", null, roomAL.get(17));
		Artifact art6 = new Artifact ("PZ02_00", "Golden Skull #1", "A golden skull", null, roomAL.get(9));
		Artifact art7 = new Artifact ("PZ02_01", "Golden Skull #2", "A golden skull", null, roomAL.get(22));
		Artifact art8 = new Artifact ("PZ02_02", "Golden Skull #3", "A golden skull", null, roomAL.get(29));
		Artifact art9 = new Artifact ("PZ03_00", "Shiny Iron Key", "A key forged from iron that's shiny", null, roomAL.get(5));
		Artifact art10 = new Artifact ("PZ04_00", "Golden Key", "A key casted from gold", null, roomAL.get(18));
		Artifact art11 = new Artifact ("PZ05_00", "Dirty Key", "A dirty key", monsterArray.get(6), roomAL.get(20));
		
		artifactArray.add(art0); artifactArray.add(art4); artifactArray.add(art8);
		artifactArray.add(art1); artifactArray.add(art5); artifactArray.add(art9);
		artifactArray.add(art2); artifactArray.add(art6); artifactArray.add(art10);
		artifactArray.add(art3); artifactArray.add(art7); artifactArray.add(art11);
	}
	
*/
	public void populateWeapon() {
		
		Weapon wep0 = new Weapon ("Wep_00", "Branch", "A tree branch", 3, null);//starting
		Weapon wep1 = new Weapon ("Wep_01", "Iron Sword", "A sword forged from iron", 3, null);
		Weapon wep2 = new Weapon ("Wep_02", "Steel Sword", "A sword forged from steel", 3, null);
		Weapon wep3 = new Weapon ("Wep_03", "Tungsteel Sword", "A sword forged from tungsteel", 3, monsterArray.get(6));
		
		weaponArray.add(wep0);
		weaponArray.add(wep1);
		weaponArray.add(wep2);
		weaponArray.add(wep3);
	}
	
	public void addWeaponRoom() {
		weaponArray.get(0).addLocation(roomAL.get(4));
		
		weaponArray.get(1).addLocation(roomAL.get(5));
		
		weaponArray.get(2).addLocation(roomAL.get(12));
		
		weaponArray.get(3).addLocation(roomAL.get(6));
		weaponArray.get(3).addLocation(roomAL.get(20));
	}
	
	/**public void populateArmor() {
		
		Armor amr0 = new Armor ("Amr_00", "Cloth Armor", "Rugged clothes from your village", 10, null, null);//starting
		Armor amr1 = new Armor ("Amr_01", "Leather Armor", "Armor crafted from deer skin", 20, null, roomAL.get(1));
		Armor amr2 = new Armor ("Amr_02", "Chainmail Armor", "Armor with many iron links woven together", 40, null, roomAL.get(17));
		Armor amr3 = new Armor ("Amr_03", "Plate Armor", "Armor forged from steel", 80, monsterArray.get(5), roomAL.get(25));//needs to be found in rooms 25-28
		
		armorArray.add(amr0); 
		armorArray.add(amr1);
		armorArray.add(amr2);
		armorArray.add(amr3);
	}
	*/
	public void populatePuzzles()
	{
		Puzzle p0 = new Puzzle("PZ00", "Torch", "Pick the torch in room 4 in order to enter and navigate room 6", "Collect and equip torch in room 4 to illuminate room 6");
		Puzzle p1 = new Puzzle("PZ01", "Runes", "There will be two runes that is needed to be slotted into the door (Dr_18) in Room 15 in order to enter Room 18", "The Runes from room 16 and room 17 will unlock the door in Room 15 to enter Room 18");
		Puzzle p2 = new Puzzle("PZ02", "Skull Pedestal", "Find 3 golden skulls and assemble them in order to attract the final monster - One golden skull per floor", "Assemble all 3 skulls in room 29 from the skulls from Rooms 9, 22, 26");
		Puzzle p3 = new Puzzle("PZ03", "Spider Webs", "Destroy 3 spider webs - One room will be unlocked, one spider web will drop the key to room 8", "Destroy spider webs until the key to room 8 drops from one of the webs");
		Puzzle p4 = new Puzzle("PZ04", "Centaur", "Kill the centaur and collect the key in order to access Room 21", "Kill centaur and collect key");
		Puzzle p5 = new Puzzle("PZ05", "Witch craft", "Kill witch, drops the key to room 22", "Collect key from witchâ€™s decomposing body");
		Puzzle p6 = new Puzzle("PZ06", "Torch puzzle", "There should be 3 torches that have to be lit in order to unlock the door to room 29", "The three unlit torches in Room 24 need to be lit in order to enter room 29 1-0-1 1 = Lit 0 = Off");
		
		puzzleArray.add(p0); puzzleArray.add(p1); puzzleArray.add(p2); puzzleArray.add(p3); 
		puzzleArray.add(p4); puzzleArray.add(p5); puzzleArray.add(p6);
	}
	public void addPuzzleRooms()
	{
		puzzleArray.get(0).addLocation(roomAL.get(4));
		puzzleArray.get(1).addLocation(roomAL.get(15));
		puzzleArray.get(2).addLocation(roomAL.get(29));
		puzzleArray.get(3).addLocation(roomAL.get(5));
		puzzleArray.get(4).addLocation(roomAL.get(18));
		puzzleArray.get(5).addLocation(roomAL.get(20));
		puzzleArray.get(6).addLocation(roomAL.get(24));
		
	}	
	
	public boolean roomHasWeapon(Room r) 
	{
		for (int i = 0; i < weaponArray.size(); i++) 
		{
			if(weaponArray.get(i).getLocation() == r.getRoomID()) 
			{
				currentItem = weaponArray.get(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean roomHasMonster(Room r)
	{
		for(int i = 0; i < monsterArray.size(); i++)
		{
			if( monsterArray.get(i).getLocation() == r.getRoomID())
			{
				currentMonster = monsterArray.get(i);
				return true;
			}
		}
		return false;
	}
	
	public void getItemDesc() 
	{
		setChanged();
		notifyObservers(currentItem);
	}
	
	public void getMonsterDesc()
	{
		setChanged();
		notifyObservers(currentMonster);
	}
	
	public boolean roomHasPuzzle(Room o)
	{
		for(int i = 0; i < puzzleArray.size(); i++)
		{
			if( puzzleArray.get(i).getLocation() == o.getRoomID())
			{
				currentPuzzle = puzzleArray.get(i);
				return true;
			}
		}
		return false;
	}
	
	public void getPuzzleDesc()
	{
		setChanged();
		notifyObservers(currentPuzzle);
	}
	
	public void changeRoom(Exit exit)
	{
		setCurrentRoom(getCurrentRoom().getAdjacentRoom(exit));
		setChanged();
		notifyObservers(getCurrentRoom());
	}
	
	public void modelStart()
	{
		setCurrentRoom(roomAL.get(0));
		setChanged();
		notifyObservers(getCurrentRoom());
	}
	
}
