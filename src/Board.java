public class Board{
	String[][] presets = new String[][]
	{
		new String[]
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
			"Fools Landing",
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
		}
	};
	
	
	
	private Game game;
	public Board(int preset, Game game){
		this.game = game;
		board = new Tile[5][5];
		
		if (preset == 0){
			int rowcount = 0;
			int columncount = 0;
			for(int g = 0; g < 24; g++)
			{
				Tile nextTile = new Tile(presets[preset][g], rowcount,columncount, "D");
				if (rowcount == 5){
						columncount++;
						rowcount = 0;
				}
				board[rowcount][columncount] = nextTile;
				rowcount++;
			}
		}
	}
	
	Tile[][] board;
	public void print(){
		for( int i = 0; i < board[0].length; i++)
		{
			for( int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public boolean Shoreup(int x, int y){
		if(board[x][y].status == "H"){
			board[x][y].status = "D";
			return true;
		}
		return false;
	}
	public void flood(String[] tiles)
	{
		for( int i = 0; i < board[0].length; i++)
		{
			for( int j = 0; j < board[0].length; j++){
				for(int d = 0; d < tiles.length; d++)
					if(board[i][j] != null && board[i][j].name.equals(tiles[d]))
					{
						if(board[i][j].status == "H")
						{
							System.out.println(tiles[d] + " Sunk!");
							board[i][j].status = "S";
							game.floodDeck.removeType(tiles[d]);
						}
						else
						{
							System.out.println(tiles[d] + " Flooded");
							board[i][j].status = "H";
						}
					}
			}
		}
	}
	
}