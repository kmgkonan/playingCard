package cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Party {
	private List<Player> players;
	private CardGame cardGame;
	private Scanner scanner;
	private int main;


	public Party() {
		this.players = new ArrayList<>();
		this.cardGame = new CardGame();
		this.scanner = new Scanner(System.in);
		this.main = 0;
	}
	
	public List<Player> playersWithCards() {
		List<Player> p = this.players.stream().filter(player -> !player.getCards().isEmpty()).toList();
		return p;
	}
	
	public void menuPrincipal() {
		while (true) {
			System.out.println("************* Menu principal *************");
			System.out.println("1- Afficher les cartes");
	        System.out.println("2- Mélanger les cartes");
	        System.out.println("3- Commencer la partie");
	        System.out.println("*********************************************");
	        System.out.print("Veillez choisir un menu : ");
			
			int menuChoisi = scanner.nextInt();
			
			switch (menuChoisi) {
				case 1 -> printCards();
				case 2 -> shuffleCards();
				case 3 -> startParty();
				default -> System.err.println("Votre choix n'est pas valide, veillez reprendre");
			}
		}
		
	}
	
	private boolean isPartyFinished() {
		return players.stream().anyMatch(player -> player.getNbCards() == 52);
	}
	
	private void printCards() {
		this.cardGame.getCards().forEach(card -> System.out.println(card));
	}
	
	private void shuffleCards() {
		this.cardGame.shuffleCards();
		System.out.println("Les cartes ont été mélangées.");
	}
	
	private void startParty() {
		System.out.print("Nombre de joueurs : ");
		int nbPlayers = scanner.nextInt();
		this.players.clear();
		
		for (int i = 1; i <= nbPlayers; i++) {
			this.players.add(new Player("Joueur " + i));
		}


		// Distribution de cartes
		List<Card> cards = this.cardGame.getCards();
		int index = 0;
		for (Card card : cards) {
			this.players.get(index % nbPlayers).addCard(card);
			index++;
		}


		menuJeu();
	}
	
	private void menuJeu() {
		while (true) {
			System.out.println("\n**************** Menu jeu ****************");
			System.out.println("1- Main suivante");
			System.out.println("2- Afficher la distribution");
			System.out.println("3- Automatiser jusqu'à la fin");
			System.out.println("*****************************************");
			System.out.print("Veillez choisir un menu : ");
			int menuChoisi = scanner.nextInt();
			switch (menuChoisi) {
				case 1 -> nextMain();
				case 2 -> printPlayerCards();
				case 3 -> automateMains();
				default -> System.err.println("Votre choix n'est pas valide, veillez reprendre");
			}
		}
	}
	
	private void nextMain() {
		this.main ++;
		
		Map<Player, Card> mapPlayerCard = new HashMap<Player, Card>();
		for (Player player : playersWithCards()) {
			if (player.hasCards()) {
				Card card = player.playCard();
				mapPlayerCard.put(player, card);
				
				System.out.println(player.getName() + " joue " + card);
			}
		}


		Player winner = null;
		int maxCard = Integer.MIN_VALUE;
		boolean equality = false;


		for (Map.Entry<Player, Card> entry : mapPlayerCard.entrySet()) {
			int strength = entry.getValue().getStrength();
			
			if (strength > maxCard) {
				maxCard = strength;
				winner = entry.getKey();
				equality = false;
			} 
			else if (strength == maxCard) {
				equality = true;
			}
		}


		if (equality) {
			System.out.println("Égalité ! Duel à gérer (cf README).\n");
		} 
		else if (winner != null) {
			System.out.println(winner.getName() + " remporte la manche " + this.main + "!");
			winner.addAllCards(mapPlayerCard.values());
		}


		// Vérifier si un joueur a gagné toutes les cartes
		for (Player player : playersWithCards()) {
			if (player.getNbCards() == 52) {
				System.out.println(player.getName() + " a gagné la partie à la manche " + this.main + "!");
				return;
			}
		}
	}
	
	private void printPlayerCards() {
		this.players.forEach(player -> player.printCards());
	}
	
	private void automateMains() {
		while (!isPartyFinished()) {
			nextMain();
		}
	}
}
