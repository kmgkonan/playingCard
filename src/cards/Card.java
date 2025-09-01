package cards;

import java.util.List;

public class Card {
	String value;
	String color;
	
	public Card(String value, String color) {
		this.value = value;
		this.color = color;
	}
	
	public int getStrength() {
		// Ordre des valeurs du plus fort au moins fort : As > Roi > Dame > Valet > 10 ... > 2
		List<String> ordre = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As");
		return ordre.indexOf(value);
	}
	
	public String toString() {
		return this.value + " de " + this.color;
	}
	
	public String getValue() {
		return this.value;
	}
}
