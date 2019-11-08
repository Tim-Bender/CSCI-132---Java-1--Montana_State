
public class Card {
	private int rank;
	private int ranknum;
	private int suit;
	private static int[] cardList;
	private static int cardPosition;
	
	Card(int x, int y){
		if (x == 1)
			ranknum = 11;
		else if (x != 1 && x < 11)
			ranknum = x;
		else if(x >= 11)
			ranknum = 10;
		this.rank = x;
		this.suit = y;
		cardList = new int[52];
		cardPosition = 0;
	}	
	public void cardToTotalList(int card) {
		cardList[cardPosition] = card;
	}
	public void resetTotalList() {
		for(int x = 0; x <= cardList.length;x++)
			cardList[0] = 0;
			cardPosition = 0;
	}
	public boolean inTheDeck(int card) { // used to test if a card has already been drawn
		boolean truth = false;
		for(int x = 0; x <= cardPosition;x++) {
			if (cardList[x] == card)
				truth = true;
		}
		return truth;	
	}
	public String toString() { // for printing cards out 
		String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
		String[] ranks = {null, "Ace", "2", "3", "4", "5", "6",
		           "7", "8", "9", "10", "Jack", "Queen", "King"};
		String s = ranks[this.rank] + " of " + suits[this.suit];
		return s;
	} 
	public int getrank() {
		if (rank == 1)
			return 11;
		else
			return ranknum;
	
	}
	public int getsuit() {return suit;}
}