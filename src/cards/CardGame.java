package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGame {
	private final List<String> cardValues = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As");
	private final List<String> cardColors = List.of("Coeur", "Carreau", "Trèfle", "Pique");
	
	private List<Card> cards = new ArrayList<Card>();
	
	public CardGame() {
		initCards();
	}
	
	private void initCards() {
		for(String color: cardColors) {
			cardValues.forEach(value -> cards.add(new Card(value, color)));
		}
	}
	
	public void printCards() {
		cards.forEach(card -> System.out.println(card));
	}
	
	public void shuffleCards() {
		Collections.shuffle(cards);
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
}
