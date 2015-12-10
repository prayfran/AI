import java.util.ArrayList;
import java.util.Comparator;

public class Player{
	String currentGoal;
	int currRow;
	int currCol;
	ArrayList<String> hand = new ArrayList<String>();
	Game game;
	
	public Player(Game game, String goal){
		currentGoal = goal;
		this.game = game;
		for(int i = 0; i < 4; i++){
			String card = game.treasureDeck.Draw();
			if(card.equals("Water Rises"))
			{
				game.treasureDeck.Discard(card);
			}
			else
			{
				hand.add(card);
			}
		}
		currRow = 3;
		currCol = 4;
		game.board.board[currRow][currCol].playerEnter();
	}
	
	//This is the turn method for the player. this is where you'll put your heuristic
	public void actionPhase()
	{
		shoreUpUp();
		shoreUpDown();
		shoreUpLeft();
		shoreUpRight();
	}

	public void drawPhase()
	{
		for(int i = 0; i < 2; i++)
		{
			String card = game.treasureDeck.Draw();
			if(card.equals("Water Rises"))
			{
//				System.out.println("Water Rises!");
				game.waterRises();
				game.treasureDeck.Discard(card);
			}
			else
			{
				hand.add(card);
			}
		}
	}
	
	//This implements an algorithm that makes the player discard 
	//any cards that do not belong to it's current goal.
	public void discardPhase()
	{
		ArrayList<String> removed = new ArrayList<String>();
		int i = 0;
		while(hand.size() > 4)
		{
			if( i >= 4 || !hand.get(i).equals(currentGoal))
			{
				removed.add(hand.get(i));
				hand.remove(i);
				continue;
			}
			i++;
		}
		for(String card : removed)
		{
			game.treasureDeck.Discard(card);
		}
	}
	
	public boolean moveUp()
	{
		if(this.currRow==0){return false;}
		if(this.game.board.board[this.currRow-1][this.currCol].status=="S"){return false;}
		this.game.board.board[this.currRow][this.currCol].PlayerLeave();
		this.game.board.board[this.currRow-1][this.currCol].playerEnter();
		this.currRow--;
		return true;
	}
	public boolean moveDown()
	{
		if(this.currRow==3 && this.currCol==4){return false;}
		if(this.currRow==this.game.board.board.length-1){return false;}
		if(this.game.board.board[this.currRow+1][this.currCol].status=="S"){return false;}
		this.game.board.board[this.currRow][this.currCol].PlayerLeave();
		this.game.board.board[this.currRow+1][this.currCol].playerEnter();
		this.currRow++;
		return true;
	}
	public boolean moveLeft()
	{
		if(this.currCol==0){return false;}
		if(this.game.board.board[this.currRow][this.currCol-1].status=="S"){return false;}
		this.game.board.board[this.currRow][this.currCol].PlayerLeave();
		this.game.board.board[this.currRow][this.currCol-1].playerEnter();
		this.currCol--;
		return true;
	}
	public boolean moveRight()
	{
		if(this.currRow==4 && this.currCol==3){return false;}
		if(this.currCol==this.game.board.board[0].length-1){return false;}
		if(this.game.board.board[this.currRow][this.currCol+1].status=="S"){return false;}
		this.game.board.board[this.currRow][this.currCol].PlayerLeave();
		this.game.board.board[this.currRow][this.currCol+1].playerEnter();
		this.currCol++;
		return true;
	}
	public boolean shoreUp(int row, int col)
	{
		if(this.game.board.board[row][col].status=="H"){this.game.board.board[row][col].status="D"; return true;}
		return false;
	}
	public boolean shoreUpCurrent()
	{
		return shoreUp(this.currRow,this.currCol);
	}
	public boolean shoreUpUp()
	{
		if(this.currRow==0){return false;}
		return shoreUp(this.currRow-1,this.currCol);
	}
	public boolean shoreUpDown()
	{
		if(this.currRow==3 && this.currCol==4){return false;}
		if(this.currRow==this.game.board.board.length-1){return false;}
		return shoreUp(this.currRow+1,this.currCol);
	}
	public boolean shoreUpLeft()
	{
		if(this.currCol==0){return false;}
		return shoreUp(this.currRow,this.currCol-1);
	}
	public boolean shoreUpRight()
	{
		if(this.currRow==4 && this.currCol==3){return false;}
		if(this.currCol==this.game.board.board[0].length-1){return false;}
		return shoreUp(this.currRow,this.currCol+1);
	}
	
	public boolean CaptureTreasure(int x, int y, String Color){
		String Check = "Treasure(" + Color.toLowerCase() + ")";
		int cardcount = 0;
		for( int i =0; i < hand.size(); i ++){
			if(hand.get(i).equals(Check)){
					cardcount++;
			}
		}
		
		if(cardcount == 4){
			game.captureTreasure(Color);
			return true;
		}
		return false;
	}

//	public boolean GiveTreasure(Player player1, Player player2, Player givingplayer, Card card){
//	if (givingplayer == player1){
//		if(player1.Hand.contains(card)== True){
//				if (player2.Hand.size() <= 4){
//					player1.Hand.remove(card)
//					player2.Hand.add(card)
//					return True;
//				}
//			 }
//		}
//	}
//	if (givingplayer = player2){
//		if(player2.Hand.contains(card) == True){
//				if(player1.Hand.size() <= 4){
//					player2.Hand.remove(card);
//					player1.Hand.add(card);
//					return True;
//				}
//		}
//	}
//	return False;
//}
}