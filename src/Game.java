import java.util.ArrayList;

public class Game {
	int[] floodLevel = new int[]
			{
					2,2,3,3,4,4,5,5
			};
	int floodCounter = 0;
	public Deck floodDeck;
	public Deck treasureDeck;
	public ArrayList<Player> players;
	public ArrayList<String> captured;
	public Board board;
	boolean loseCondition=false;
	public int red=2;
	public int blue=2;
	public int black=2;
	public int gold=2;
	
	public boolean running = true;
	
	public Game(int numbPlayers, int dif)
	{
		board = new Board(0, this);
		floodDeck = Deck.getFloodDeck();
		treasureDeck = Deck.getTreasureDeck();
		captured = new ArrayList<String>();
		players = new ArrayList<Player>();
		for(int i =0; i < numbPlayers; i++)
		{
			String goal;
			switch(i)
			{
				case 0:
					goal = "Treasure(red)";
					break;
				case 1:
					goal = "Treasure(blue)";
					break;
				case 2:
					goal = "Treasure(black)";
					break;
				case 3: 
					goal = "Treasure(gold)";
					break;
				default: 
					goal = "SH";
					break;
			}
			players.add(new Player(this,goal));
		}
		floodCounter = dif;
		treasureDeck.Reshuffle();
		treasureDeck.Shuffle();
		treasureDeck.Shuffle();
		treasureDeck.Shuffle();
	}
	

	public void prin(Object o){System.out.println(o);}
	public void waterRises()
	{
		floodDeck.Reshuffle();
		floodCounter++;
		if(floodCounter == floodLevel.length-1)
			running = false;
	}
	
	public void captureTreasure(String color)
	{
		captured.add(color);
	}
	
	public void flood()
	{
		String[] cards = new String[floodLevel[floodCounter]];
		for(int i = 0; i < floodLevel[floodCounter]; i ++)
		{
			String card = floodDeck.Draw();
			if(card == null)
			{
				running = false;
				break;
			}
			cards[i] = card;
		}
		for(String card : cards)
		{
			if(card == null)
				break;
			floodDeck.Discard(card);
		}
		
		board.flood(cards);
		if(loseTreasure()){loseCondition=true;}
	}
	public boolean loseTreasure()
	{
		return (blue==0 && !captured.contains("blue"))|| (red==0 && !captured.contains("red"))|| (black==0 && !captured.contains("black")) || (gold==0 && ! captured.contains("gold"));
	}
	public boolean drown(Player p)
	{
		if(p.moveUp()){p.moveDown();return false;}
		if(p.moveDown()){p.moveUp();return false;}
		if(p.moveLeft()){p.moveRight();return false;}
		if(p.moveRight()){p.moveLeft();return false;}
		prin("YOU DONE DROWNED BITCH");
		prin("");
		this.loseCondition=true;
		return true;
	}
	public void Run()
	{
		while(running)
		{
			for(Player p : players)
			{
				if(blue==0)
				{
					prin("LOST"); 
					if(!captured.contains("blue"))
					{
						prin("FUCK");
					}
				}
				if(this.loseCondition){prin("GAME OVER");running=false;break;}
				prin("NEXT TURN");
				prin("");
				p.actionPhase();
				p.drawPhase();
				p.discardPhase();
				flood();
				drown(p);
				board.print();
				if(running == false)
					break;
			}
		}
	}
}
