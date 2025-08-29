package cards;

public class Card {
	String value;
	String color;
	
	public Card(String value, String color) {
		this.value = value;
		this.color = color;
	}
	
	public String toString() {
		return this.value + " de " + this.color;
	}
	
	public String getValue() {
		return this.value;
	}
}
