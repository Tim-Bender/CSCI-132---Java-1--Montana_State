//Timothy Bender -02515767
//Outlab 2 - Nim game

import java.util.Scanner; 
import java.util.Random;

//game mode 0 will be hard difficulty, game mode 1 will be easy

public class Nim {
	private int gamemode;
	private int numMarbles;
	private int[] powersOfTwo;
	private int[] powersMinusOne;
	private String difficulty;
	
	Nim(int x) {
		gamemode = x;
		Random rd = new Random();
		numMarbles = rd.nextInt(90) + 10;
		powersOfTwo = new int[] {2,4,8,16,32,64};
		powersMinusOne = new int[] {1,3,7,15,31,63};
		if(gamemode == 0) {
			difficulty = "Hardmode";
		}
		else
			difficulty = "Easy Mode";
	}
	
	
	//Main method. Creates an instance of the Nim class and then calls gameSTart
	public static void main(String[] args) {
		System.out.println("Welcome to Nim by Tim!"); //i thought 
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		boolean playingGame = true;
		while(playingGame == true) { 
			Random rd = new Random();
			Nim nm = new Nim(rd.nextInt(2));
			nm.gameStart(nm);
			
			System.out.println("Would you like to play again? (0,1)");
			while(true) {
			int continuePlaying = sc.nextInt();
			if(continuePlaying > 1 || continuePlaying < 0) {
				System.out.println("Please select either 0 or 1");
				
			}
			else if(continuePlaying == 0)
				playingGame = false;
			break;
			}
		}
		System.out.println("Thank you playing Nim!");
	}
	
	
	//gameStart method. The game is managed and played here. Split into two sections depending on who plays first. 
	private void gameStart(Nim nm) {
		Random rd = new Random();
		int firstPlayer = rd.nextInt(2);
		//Block for when the computer is the first player
		if (firstPlayer == 1) {
			System.out.println("The computer will play first in " + difficulty);
			System.out.println("There are " + nm.getMarbles() + " marbles.");
			while(true) {
				boolean status = nm.computerPlay(nm);
				if (status == true) {
					System.out.println("You have won! The computer picked up the last marble!");
					break;
				}
				else {
				boolean statusComp = nm.userPlay(nm);
				if (statusComp == true) {
					System.out.println("You have picked up the last marble and lost!");
					break;
					}
				}
			}
		}
	//block for if the user will play first
		else if(firstPlayer == 0) {
			System.out.println("The user will play first.");
			System.out.println("The computer is playing in " + difficulty);
			System.out.println("There are " + nm.getMarbles() + " marbles.");
			while(true) {
				boolean status = nm.userPlay(nm);
				if (status == true) {
					System.out.println("You have picked up the last marble and lost!");
					break;
				}
				else {
					boolean statusComp = nm.computerPlay(nm);
					if (statusComp == true) {
						System.out.println("You have won! The computer picked up the last marble!");
						break;
				}
					}
				}
			}
		}
	
	//This method is called whenever the computer is going to take a turn 
	//it is split into two main sections depending on whether or not the gamemode is hard or easy
	//the method will return a boolean, this will determine whether or not someone has lost the game
	private boolean computerPlay(Nim nm) {
		//the entire method will only execute if there is more than one marble, otherwise it will return false and the computer will loose
		if(nm.getMarbles() > 1) {
		//hardmode block of the code
		if(gamemode == 0) {
			Random rd = new Random();
			int marblesTaken = 0;
			int powerToCompare = this.powersOfTwo[0];
			while (true) {
				//build hardmode calculator!
				if(nm.testIfOneLess(nm) == false ) {
				//test which power of two the number of marbles is closest to
				for (int x = 0; x < powersOfTwo.length - 1; x++) {
					//we will find the nearest power of two that is less than the number of marbles.
					//then take however many marbles necessary
					if(nm.getMarbles() - powersOfTwo[x+1] < nm.getMarbles() - powersOfTwo[x] && powersOfTwo[x+1] < nm.getMarbles()) {
						powerToCompare = powersOfTwo[x+1];
					}			
				}
				marblesTaken = (nm.getMarbles() - powerToCompare) + 1;
				if(marblesTaken > 0)
					break;
		}
				else {
					while(true) {
						marblesTaken = rd.nextInt(numMarbles/2) + 1;
						break;
			}
		}
				break;
	}
			nm.setMarbles(-1*marblesTaken);
			//grammar check in case the computer only took one marble
			if(marblesTaken > 1)
				System.out.println("The computer has taken " + marblesTaken + " marbles");
			else
				System.out.println("The computer has taken " + marblesTaken + " marble");
			
			System.out.println("There are " + numMarbles + " marbles left");
			System.out.println("");
		}
	
		
		//easymode block
		else if(gamemode == 1) {
			Random rd = new Random();
			int marblesTaken;
			while (true) {
				marblesTaken = rd.nextInt(numMarbles/2) + 1;
				if(marblesTaken > 0)
					break;
			}
			nm.setMarbles(-1*marblesTaken);
			if(marblesTaken > 1)
				System.out.println("The computer has taken " + marblesTaken + " marbles");
			else
				System.out.println("The computer has taken " + marblesTaken + " marble");
			
			System.out.println("There are " + numMarbles + " left");
			System.out.println("");
			}
		}
		
		else if (nm.getMarbles() == 1) {
			return true;
		}
		return false;
	}

	//--------------------------------------------
	
	//This method will be called whenever the user takes a turn
	//it will ask how many marbles they want, then check if their selection is an appropriate amount
	//if the number of marbles is 1, then it will return false and the user will lose.
	private boolean userPlay(Nim nm) {
		if(nm.getMarbles() > 1) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many marbles do you wish to take?");
		boolean status = false;
		while(status == false) {
			int marblesTaken = sc.nextInt();
			if(marblesTaken <= numMarbles/2 && marblesTaken > 0 ) {
				System.out.println("You have taken " + marblesTaken + " marbles.");
				nm.setMarbles(-1*marblesTaken);
				System.out.println("There are " + numMarbles + " marbles left.");
				System.out.println("");
				break;
			}
			else if(marblesTaken < 1) {
				System.out.println("That is too few, you must take at least one marble");
				System.out.println("How many marbles do you wish to take?");
			}
			else {
				System.out.println("That is too many marbles, please select a lower value");
				System.out.println("How many marbles do you wish to take?");
				}
			}
		}
		else if(nm.getMarbles() == 1) {
			return true;
		}
		return false;
	}
	//This method will test if the number of marbles is one less than a power of two, in which case the computerPlay method
	//will choose a random number of marbles instead of the hardmode default
	private boolean testIfOneLess(Nim nm) {
		for(int x = 0; x < powersMinusOne.length;x++) {
			if(powersMinusOne[x] == nm.getMarbles()) {
				return true;
			}
		}
		return false;
	}
	public int getMarbles() {
		return numMarbles;
	}
	//method for manipulating the number of marbles.
	public void setMarbles(int x) {
		numMarbles += x;
	}
	
}