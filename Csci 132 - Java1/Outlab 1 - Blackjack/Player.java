
public class Player {
	private int points;
	private static int totalPlayerPoints; //total points throughout players
	private String name;
	private int card_total;// total of the ranks
	private int[] playerCardListPersonal; //players person list of cards
	private int numberOfAces;
	private int wager; // amount they wager'ed on the round
	private int deckPosition; // counts the position in the deck, used for assigning new cards
	private boolean stillInRound; //whether or not they are still in the round
	private boolean stillInGame;
	
	Player(String x,int y){
		name = x;
		if(x != "The Dealer") {
			points = 500;
		}
		card_total = 0;
		playerCardListPersonal = new int[10];
		totalPlayerPoints = y*500;
		wager = 0;
		deckPosition = 0;
		stillInRound = true;
		stillInGame = true;
		numberOfAces = 0;
	}
	public int getPoints() {return points;}
	public void reducePoints(int x) {
		this.points -= x;
		if(points <= 0) {
			stillInGame = false;
			stillInRound = false;
		}
	}
	public void addPoints(int x) {
		this.points += x;
		totalPlayerPoints += x;
	}
	
	public String getname() {return name;}
	public int getCardCount() {return deckPosition;}
	
	//wagers
	public int getStake() {return wager;}
	public void setStake(int x) {wager = x;}
	//cards
	public int getCardTotal() {return card_total;}
	public void setCardTotal(int x) {card_total = x;}
	public int getCard(int x) {return playerCardListPersonal[x];}
	public void assignCard(int y,Card[] deck) {
		playerCardListPersonal[deckPosition] = y;
		deckPosition ++;
		card_total = card_total + (deck[y].getrank());
	}
	
	public int getNumAces() {return numberOfAces;}
	public void addNumAces(int x) {numberOfAces += x;}
	
	public boolean getStillIn() {return stillInRound;}
	public void setStillIn(boolean x) {stillInRound = x;}
	
	public boolean getStillInGame() {return stillInGame;}
	public void setStillInGame(boolean x) {stillInGame = x;}
	
	public int getTotalPoints() {return totalPlayerPoints;}
	
	public void reset() {
		card_total = 0;
		wager = 0;
		stillInRound = true;
		deckPosition = 0;
		numberOfAces = 0;
	}
}
