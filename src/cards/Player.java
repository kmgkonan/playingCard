package cards;

import java.util.LinkedList;
import java.util.Queue;

public class Player {
	private String name;
	private Queue<Card> cards = new LinkedList<Card>();
	private int score = 0;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public void incrementScore() {
        score++;
    }
	
	public void printCards() {
		System.out.println("Les cartes de " + this.name + " : ");
		cards.forEach(card -> System.out.println(" - " + card));
	}
	
	public Card playCard() {
		return this.cards.poll();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getSore() {
		return this.score;
	}
}
