package cards;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Player {
	private String name;
	private Queue<Card> cards = new LinkedList<Card>();
	
	public Player(String name) {
		this.name = name;
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public void addAllCards(Collection<Card> cards) {
		this.cards.addAll(cards);
	}
	
	public Queue<Card> getCards() {
		return this.cards;
	}
	
	
	public int getNbCards() {
		return this.cards.size();
	}

	public boolean hasCards() {
		return !getCards().isEmpty();
	}
	
	public void printCards() {
		System.out.println(this.name + " possède " + this.cards.size() + " cartes.");
		this.cards.forEach(card -> System.out.println(" - " + card));
	}
	
	public Card playCard() {
		return this.cards.poll();
	}
	
	public String getName() {
		return this.name;
	}
}
