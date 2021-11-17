package RackO;

public class Player {
	private String name;
	private RackORack rack;
	
	/**
	 * Assigns a name to the player and initialized the player's rack.
	 * @param name The name of the player
	 */
	public Player(String name) {
		this.name = name;
		rack = new RackORack();
	}	
	
	/**
	 * Gets the name of the player
	 * @return The name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Places a card at the specified index
	 * @param card An instance of a card object
	 * @param index Location that card should be placed at
	 */
	public void placeCards(Card card, int index) {
		rack.placeInRack(card, index);
	}
	
	/**
	 * Places a card at a specified index and returns the the original card at this index.
	 * @param card An instance of a card object
	 * @param index Location that the card should be placed at
	 * @return The card that was originally found at the speficied index.
	 */
	public Card swapCards(Card card, int index) {
		return rack.swap(card, index);
	}
	
	/**
	 * Gets the value of the card at the specified index
	 * @param index The location at which the card can be found
	 * @return The number on the card.
	 */
	public int getCardValue(int index) {
		return rack.getNumberOnCard(index);
	}
	
	/**
	 * Checks whether the players cards are in numerical progression from low to high
	 * @return true if cards are in the right order, false if they are not.
	 */
	public boolean inOrder() {
		Card[] cards = rack.getCardsRack();
		boolean endGame = true;
		for(int i = 0; i < cards.length - 1; i++) {
			if(!(cards[i].getNumber() < cards[i+1].getNumber())){
				endGame = false;
			}	
		}
		return endGame;
	}
}
