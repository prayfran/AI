
import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

public class Deck {
	private ArrayList<String> deck;
	private ArrayList<String> discard;
	public Deck(ArrayList<String> cards)
	{
		deck = cards;
		discard = new ArrayList<String>();
	}
	
	public String Draw()
	{
		if(deck.size() == 0)
			Reshuffle();
		if(deck.size() == 0)
			return null;
		String card = deck.get(deck.size()-1);
		deck.remove(deck.size()-1);
		return card;
	}
	public void Discard(String card)
	{
		discard.add(card);
	}
	
	public void Shuffle()
	{
		deck.sort(new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return UUID.randomUUID().toString().compareTo(UUID.randomUUID().toString());
			}
		});
	}
	public void Reshuffle()
	{
		discard.sort(new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return UUID.randomUUID().toString().compareTo(UUID.randomUUID().toString());
			}
		});
		deck.addAll(discard);
		discard.clear();
	}
	
	public void Print()
	{
		PrintDeck();
		System.out.println();
		PrintDiscard();
	}
	
	public void PrintDeck()
	{
		System.out.println("Deck:");
		for(String card : deck)
		{
			System.out.println(card);
		}
	}
	
	public void PrintDiscard()
	{
		System.out.println("Discard:");
		for(String card : discard)
		{
			System.out.println(card);
		}
	}
	
	public void removeType(String card)
	{
		for(int i = 0; i < deck.size(); i++)
		{
			if(deck.get(i).equals(card))
				deck.remove(i);
		}
		for(int i = 0; i < discard.size(); i++)
		{
			if(discard.get(i).equals(card))
				discard.remove(i);
		}
	}
	
	public static Deck getTreasureDeck()
	{
		ArrayList<String> cards = new ArrayList<String>();
		cards.add("Treasure(red)");
		cards.add("Treasure(blue)");
		cards.add("Treasure(black)");
		cards.add("Treasure(gold)");
		cards.add("Treasure(red)");
		cards.add("Treasure(blue)");
		cards.add("Treasure(black)");
		cards.add("Treasure(gold)");
		cards.add("Treasure(red)");
		cards.add("Treasure(blue)");
		cards.add("Treasure(black)");
		cards.add("Treasure(gold)");
		cards.add("Treasure(red)");
		cards.add("Treasure(blue)");
		cards.add("Treasure(black)");
		cards.add("Treasure(gold)");
		cards.add("Treasure(red)");
		cards.add("Treasure(blue)");
		cards.add("Treasure(black)");
		cards.add("Treasure(gold)");
		cards.add("Water Rises");
		cards.add("Water Rises");
		cards.add("Water Rises");
		Deck deck = new Deck(cards);
		deck.Shuffle();
		deck.Shuffle();
		return deck;
	}
	public static Deck getFloodDeck()
	{
		ArrayList<String> cards = new ArrayList<String>();
		cards.add("Breakers Bridge");
		cards.add("Cave of Shadows(red)");
		cards.add("Howling Garden(gold)");
		cards.add("Phantom Rock");
		cards.add("Temple of the Moon(black)");
		cards.add("Gold Gate");
		cards.add("Cliffs of Abandon");
		cards.add("Crimson Forest");
		cards.add("WatchTower");
		cards.add("Whispering Gardens(gold)");
		cards.add("Misty Marsh");
		cards.add("Lost Lagoon");
		cards.add("Coral Place(blue)");
		cards.add("Temple of the Sun(black)");
		cards.add("Copper Gate");
		cards.add("Iron Gate");
		cards.add("Cave of Embers(red)");
		cards.add("Observatory");
		cards.add("Twilight Hollow");
		cards.add("Tidal Palace(blue)");
		cards.add("Silver Gate");
		cards.add("Bronze Gate");
		cards.add("Desert of Deception");
		cards.add("Fools Landing");
		Deck deck = new Deck(cards);
		deck.Shuffle();
		deck.Shuffle();
		return deck;
	}
	
}
