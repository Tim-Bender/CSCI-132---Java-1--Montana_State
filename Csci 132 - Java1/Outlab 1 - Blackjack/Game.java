import java.util.Scanner;
import java.util.Random;
public class Game {
	int num_Players;
	
	Game(int x){
		num_Players = x;
	}
		public void gameStart() {
		//create the player/s and the dealer
		
		//player creation block
		Player[] players = new Player[(num_Players+1)];
		
		for (int x = 0; x < (num_Players+1); x++)
			if (x == 0)
				players[x] = new Player("The Dealer",num_Players);
			else
			players[x] = new Player("Player " + x,num_Players);
		//end of block	
		
		//MASTER WHILE LOOP
	while((players[1]).getTotalPoints() > 0) {
		
		//create the deck as an array of Card objects	
		Card[] deck = new Card[52];
		int index = 0;
		for (int suit = 0; suit <=3;suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				deck[index] = new Card(rank,suit);
				index++;
			}
		}
		//if they have no points set their in game status to false
		for(int x = 1; x < players.length;x++) {
			if(players[x].getPoints() <= 0)
				players[x].setStillInGame(false);
		}
		//get the wager for the round for all players
		for(int x = 1; x <= (num_Players);x++) {
			boolean enoughPoints = false;
			if(players[x].getStillInGame() == true) {
			while(enoughPoints == false) {
				Scanner scannerobj = new Scanner(System.in);
				System.out.println(players[x].getname() + " please input how many points you wish to wager on the next hand");
				int wager = scannerobj.nextInt();
				
				if (wager <= players[x].getPoints()) {
					players[x].setStake(wager);
					enoughPoints = true;
				}
				else {
					System.out.println(players[x].getname() + " you do not have enough points for that bet");
					System.out.println("Your currents points are " + players[x].getPoints() + " please select a lower bet");
					System.out.println("");
				}
			}
		}
	}
		int numberToDeal = 3;//Change to however many cards you want to deal to each player. 
		
		//deal six cards
		for(int y = 0; y < (num_Players+1);y++) {
			for(int x = 0; x < numberToDeal;x++) {
				if(players[y].getStillInGame() == true && players[y].getStillIn() == true) {
					players[y].assignCard(dealCard(deck,players,y),deck);
					if((y == 0 && x == 2) != true) {
						System.out.println(players[y].getname() + " drew a " + deck[(players[y]).getCard(x)]);
					}
				}
			}
		}
		//if the player is already over 31,cut them out of the round.
		//if the player is over 31, and has aces. decrease their total until its below 31 or under
		
		for (int x = 0; x < (num_Players + 1);x++) {
			if (checkIfOver31(deck,players,x) == true){
				players[x].setStillIn(false);
				System.out.println((players[x]).getname() + " your cards have totaled to " + (players[x]).getCardTotal());
				players[x].reducePoints((players[x]).getStake());
				System.out.println((players[x]).getname() + " is out of the round!!!!");
				System.out.println((players[x]).getname()+ " your new point total is " + players[x].getPoints());
			}
		}
		//while loop for asking if the player wants another card.
		int player__number = 1;
		while(player__number < (num_Players+1)) {
			int playerStand = 0;
			while (playerStand != 1) {
				if(players[player__number].getStillIn() != false) {
					System.out.println(players[player__number].getname() + " your card total is " + players[player__number].getCardTotal());
					System.out.println("Do you want another card? (0,1)");
					Scanner scobj = new Scanner(System.in);
					int yesOrNo = scobj.nextInt();
					if (yesOrNo == 1) {
						int cardid = dealCard(deck,players,player__number);
						players[player__number].assignCard(cardid,deck);
						System.out.println(players[player__number].getname() + " was dealt a " + deck[cardid]);
						if (checkIfOver31(deck,players,player__number) == true) {
							players[player__number].setStillIn(false);
							System.out.println(players[player__number].getname() + " your points have totaled " + players[player__number].getCardTotal()+" and you are out of the round!");
							players[player__number].reducePoints(players[player__number].getStake());
							player__number ++;
							playerStand = 1;
				}
			}
				else {
					player__number ++;
					playerStand = 1;
				}
			}
				else {
				player__number ++;
				playerStand = 1;
				}
			}
		}
		//beginning of the dealer playing. dealer will continue drawing cards while he is under 26. If he goes over 31, the players
		//win the round
		if(players[0].getStillIn() == true) {
			while(players[0].getCardTotal() < 26) {
				players[0].assignCard(dealCard(deck,players,0),deck);
				System.out.println("The dealer was dealt a " + (deck[players[0].getCard(players[0].getCardCount())].toString()));
				if(checkIfOver31(deck,players,0) == true) {
					System.out.println("The dealer's cards have totaled to " + players[0].getCardTotal());
					System.out.println("The players have won the round!");
					for(int x = 1; x <= num_Players;x++) {
						if(players[x].getStillIn() == true && players[x].getStillInGame() == true) { 
							players[x].addPoints(players[x].getStake());
							System.out.println(players[x].getname() + " your new point total is " + players[x].getPoints());
					}	
				}
			}
		}
				
		//the round is now over, time to test who won and lost.
		if(players[0].getStillIn() == true) {
		for(int x = 1; x < num_Players + 1; x++) {
			if(players[x].getCardTotal() > players[0].getCardTotal() && players[x].getStillIn() == true && players[x].getStillInGame() == true) {
				players[x].addPoints(players[x].getStake());
				System.out.println(players[x].getname() + " your cards have totaled to " + players[x].getCardTotal() +" the Dealer's have totaled to " + players[0].getCardTotal());
				System.out.println(players[x].getname() + " you have won the round you have gained " + players[x].getStake() + " points." );
			}
			else if(players[x].getCardTotal() < players[0].getCardTotal() && players[x].getStillIn() == true && players[x].getStillInGame() == true) {
				players[x].reducePoints(players[x].getStake());
				System.out.println(players[x].getname() + " your cards have totaled to " + players[x].getCardTotal() +" the Dealer's have totaled to " + players[0].getCardTotal());
				System.out.println(players[x].getname() + " you have lost the round, you have lost " + players[x].getStake() + " points.");				
						}
					}
				}
			}//end of round while loop
		
		endRoundReset(deck,players); // reset everything for the next round
		
		} // end of Master while loop
	}	//end of gameStart method
		
	/*------------------------------------
	 *Beginning of methods
	 -----------------------------------*/
		
		
		//method for dealing random cards, checking if its an ace, and verifying the card has not been used before
		private static int dealCard(Card[] deck,Player[] players,int player_num) {
		Random rd = new Random();
		int cardToReturn = 0;
		boolean truth = false;
		int card1 = 0;
		//test if the card's already been drawn. And if so, pick a new one until you find a new one. 
		while(truth == false) {
			card1 = rd.nextInt(52);
			if (deck[0].inTheDeck(card1) != true) {
				truth = true;
				cardToReturn = card1;
				deck[0].cardToTotalList(cardToReturn);
				if(deck[cardToReturn].getrank() == 11) 
					players[player_num].addNumAces(1); // if it's an ace, add one to the player's number of aces
				// throw it in the master list of used cards
			}	
		}
		return cardToReturn;
	}
		//method for resetting necessary stuff at the end of the ground
		private static void endRoundReset(Card deck[],Player[] players) {
			for(int x = 0; x < players.length; x++) {
				players[x].reset();
		}	
			deck[0].resetTotalList();
			System.out.println("");
	}
		/*This method will check if the player is over 31
		 * if they are over 31, and they have aces, it will reduce their card total until its under 31, or they run out of aces*/
		private static boolean checkIfOver31(Card deck[],Player[] players, int y) {
			int counter = 0;
			if(players[y].getCardTotal() > 31 && players[y].getNumAces() > 0) {
				while(counter < players[y].getNumAces() && players[y].getCardTotal() > 31) {
					players[y].setCardTotal(players[y].getCardTotal() - 10);
					counter++;
				}
			}
			if(players[y].getCardTotal() > 31)
				return true;
			return false;
		}
}