package RackO;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		//Creates an instance of the Scanner class to allow for input
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to RackO!");
		System.out.println("RackO can be played with 2-4 players");
		System.out.println("How many players would you like to play with?");
		int amount = input.nextInt();
		
		//Validates that the user only enters a number from 2-4
		while(amount < 2 || amount > 4) {
			System.out.println("Invalid amount. Only 2-4 players are allowed to play at a time");
			amount = input.nextInt();
		}
		
		//Creates an array to hold the list of players.
		String[] players = new String[amount];
		
		//Clears the input buffer.
		input.nextLine();
		for(int i = 0; i < players.length; i++) {
			System.out.println("Please list the name of player " + (i + 1) + ": ");
			players[i] = input.nextLine();
		}
		

		RackOGame game = new RackOGame(players);
		System.out.println("Press enter to start the game!");
		input.nextLine();
		//Starts the Racko game
		game.startGame();

	}

}
