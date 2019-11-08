import java.util.Scanner;
public class Driver {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Blackjack!");
		System.out.println("How many players?");
		int num_Players = sc.nextInt();
		Game gm = new Game(num_Players);
		gm.gameStart();
	}
}
