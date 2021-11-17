package RackO;
import java.util.ArrayList;
public class RackORack {
	private Card[] cards;
	
	public RackORack() {
		cards = new Card[10];
	}
	
	public void placeInRack(Card card, int index) {
		cards[index] = card;
	}
	
	public Card swap(Card card, int index) {
		Card tempCard = cards[index];
		cards[index] = card;
		return tempCard;
		
	}
	
	public int getNumberOnCard(int index) {
		return cards[index].getNumber();
	}
	
	public Card getCardObj(int index) {
		return cards[index];
	}
	
	public Card[] getCardsRack() {
		Card[] temp = new Card[10];
		for(int i = 0; i < cards.length; i++) {
			temp[i] = cards[i];
		}
		return temp;
	}
}
