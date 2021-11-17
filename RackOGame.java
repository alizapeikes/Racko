package RackO;

import java.util.*;

public class RackOGame {
	private int numPlayers;
	private Player[] players;
	private CardStack<Card> stockPile;
	private CardStack<Card> discardPile;
	
	//Creates a constructor that accepts an array of player names.
	public RackOGame(String[] playersNames) {
		numPlayers = playersNames.length;
		this.players = new Player[numPlayers];
		for(int i = 0; i < numPlayers; i++) {
			players[i] = new Player(playersNames[i]);
		}
		
	}
	public void startGame() {
		//Creates a deck of cards.
		ArrayList<Card> deck = getDeckOfCards();
		
		//Fills the stock pile with the deck of cards.
		stockPile = new CardStack<Card>(deck.size());
		for(int i = 0; i < deck.size(); i++) {
			stockPile.push(deck.get(i));
		}
		discardPile = new CardStack<>(deck.size());
		
		//Gives each player 10 cards.
		dealOutCards(players, stockPile);
		
		//Starts the game with one card in the discard pile.
		discardPile.push(stockPile.top());
		stockPile.pop();
		
		int currPlayer = -1 ;
		
		//Allows the game to continue until one player's cards are in numerical progression from low to high
		do {
			currPlayer = (currPlayer + 1) % numPlayers;
			turn(players[currPlayer]);
		}while(!players[currPlayer].inOrder());
		
		System.out.println("Congratulations " + players[currPlayer].getName() + ", you are the winner!");
		System.out.println("Hope you enjoyed the game!");
		
	}
	
	/**
	 * Returns a deck of cards with the number of cards according to the number of players.
	 * @return A deck of cards.
	 */
	public ArrayList<Card> getDeckOfCards() {
		int totalCards = 0;
		switch(numPlayers){
			case 2:
				totalCards = 40;
				break;
			case 3:
				totalCards = 50;
				break;
			case 4:	
				totalCards = 60;
				break;
		}
		
		ArrayList<Card> deck = new ArrayList<Card>();
		for(int i = 0; i < totalCards; i++) {
			deck.add(new Card(i+1));
		}
		//Shuffles the deck of cards
		Collections.shuffle(deck);
		
		return deck;
	}
	
	/**
	 * Gives each player 10 cards and fills the rack starting from the back.
	 * @param players A list of all the players.
	 * @param stockPile A stack of cards. 
	 */
	public void dealOutCards(Player[] players, CardStack<Card> stockPile) {
		for(int i = 0; i < players.length; i++) {
			for(int j = 9; j >= 0; j--) {
				players[i].placeCards(stockPile.top(), j);
				stockPile.pop();
			}
		}
	}
	
	/**
	 * Allows the current player to take its turn
	 * @param currPlayer The player whose turn it is.
	 */
	public void turn(Player currPlayer) {
		System.out.println("\n" + currPlayer.getName() + "'s Turn:");
		displayBoard(currPlayer);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Discard pile: [" + discardPile.top().getNumber()  + "]");
		System.out.println("Enter 1 to pick from the discard pile.");
		System.out.println("Enter 2 to pick a new card.");
		int choice = input.nextInt();
		while(choice != 2 && choice != 1) {
			System.out.println("Invalid Choice. Please enter either 1 or 2");
			choice = input.nextInt();
		}
		
		//Switch statment reacts according the choice of the user.
		switch(choice) {
			case 1:
				swap(currPlayer, discardPile);
				break;
			case 2:
				//Checks to make sure there are still cards in the stock pile to be picked.
				if(stockPile.isEmpty()) {
					refillStack();
				}
				
				System.out.println("Picked card: [" + stockPile.top().getNumber() + "]");
				System.out.println("Enter 1 to make a swap.");
				System.out.println("Enter 2 to discard the picked card.");
				int swapDiscard = input.nextInt();
				while(swapDiscard != 1 && swapDiscard != 2 ) {
					System.out.println("Invalid Choice! Please enter either 1 or 2");
					swapDiscard = input.nextInt();
				}
				
				if(swapDiscard == 1 ) {
					swap(currPlayer, stockPile);
				}else {
					discardPile.push(stockPile.top());
					stockPile.pop();
				}
				break;
		}
	}
	
	/**
	 * Displays the Current players rack-board.
	 * @param player The player whose turn it is.
	 */
	public void displayBoard(Player player) {
		for(int i = 9; i >= 0; i--) {
			System.out.println("\t|" + player.getCardValue(i) + (player.getCardValue(i) < 10 ? " |":"|"));
		}
	}
	
	/**
	 * Swaps the chosen card with a number card on the rack
	 * @param currPlayer The player whose turn it is
	 * @param pile Either the stock or discard pile depending on the users choice.
	 */
	public void swap(Player currPlayer, CardStack<Card> pile) {
		Scanner input = new Scanner(System.in);
		System.out.println("What number card would you like to swap with card [" + pile.top().getNumber() + "]");
		int swap = input.nextInt() - 1;
		while(swap < 0 || swap > 9) {
			System.out.println("Choice is out of range. Number card must be between 1-10.");
			System.out.println("Please enter a valid choice: ");
			swap = input.nextInt() - 1;
		}	
		
		//Card gets swapped.
		Card swappedCard = currPlayer.swapCards(pile.top(), swap);
		pile.pop();
		discardPile.push(swappedCard);
	}
	
	/**
	 * Refills the stock pile with the cards in the discard pile.
	 */
	public void refillStack() {
		//Saves the top card of the discard pile.
		Card topCard = discardPile.top();
		discardPile.pop();
		while(!discardPile.isEmpty()) {
			stockPile.push(discardPile.top());
			discardPile.pop();
		}
		
		//Places the saved top card back on the discard pile.
		discardPile.push(topCard);
	}

}
