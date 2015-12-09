public class Tile{
	String name;
	int x;
	int y;
	String status;
	String[] Tiles = new String[]
			{
					"Breakers Bridge",
					"Cave of Shadows(red)",
					"Howling Garden(gold)",
					"Phantom Rock",
					"Temple of the Moon(black)",
					"Gold Gate",
					"Cliffs of Abandon",
					"Crimson Forest",
					"WatchTower",
					"Whispering Gardens(gold)",
					"Misty Marsh",
					"Lost Lagoon",
					"Coral Place(blue)",
					"Temple of the Sun(black)",
					"Copper Gate",
					"Iron Gate",
					"Cave of Embers(red)",
					"Observatory",
					"Twilight Hollow",
					"Tidal Palace(blue)",
					"Silver Gate",
					"Bronze Gate",
					"Desert of Deception",
			};


	public Tile(String name, int x, int y, String status){
		this.name = name;
		this.x = x;
		this.y = y;
		this.status = status;
	}
	@Override
	public String toString()
	{
		return this.status;
	}
}