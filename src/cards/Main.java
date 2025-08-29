package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static CardGame cardGame = new CardGame();
	private static List<Player> players = new ArrayList<Player>();
	private static int main = 0;

	public static void main(String[] args) {
		menu();
	}
	
	private static void menu() {
		while(true) {
			System.out.println("************* Menu principal *************");
			System.out.println("1- Afficher les cartes");
	        System.out.println("2- Mélanger les cartes");
	        System.out.println("3- Commencer la partie");
	        System.out.println("*********************************************");
	        
	        System.out.print("Veillez choisir un menu: ");
	        String menuChoisi = scanner.nextLine();
	        
	        switch(menuChoisi) {
		        case "1":
		        	cardGame.printCards();
		        	break;
		        case "2":
		        	cardGame.shuffleCards();
		        	break;
		        case "3":
		        	startGame();
		        	return;
	        	default:
	        		System.err.println("Votre choix n'est pas valide");
	        }
		}
	}
	
	private static void startGame() {
		 System.out.print("Entrez le nombre de joueurs : ");
		 
		 try {
			int nbPlayers = scanner.nextInt();
			for (int i = 0; i < nbPlayers; i++) {
				players.add(new Player("Joueur " + (i + 1)));
			}
			
			distributeCartes();
			menuJeu();
		} catch (Exception e) {
			System.err.println("Attention, le nombre de joueur doit être un chiffre");
			startGame();
		}
	}
	
	private static void distributeCartes() {
        List<Card> cards = cardGame.getCards();
        int index = 0;
        for (Card card : cards) {
            players.get(index % players.size()).addCard(card);
            index++;
        }
    }
	
	private static void menuJeu() {
		while(true) {
			System.out.println("**************** Menu jeu ****************");
	        System.out.println("1- Main suivante");
	        System.out.println("2- Afficher la distribution des cartes par joueur");
	        System.out.println("3- Automatiser les mains jusqu’à la fin de la partie");
	        System.out.println("******************************************");
	        System.out.print("Veillez choisir un menu : ");
	        String menuChoisi = scanner.nextLine();
	        
	        switch (menuChoisi) {
		        case "1":
		            playMain();
		            break;
		        case "2":
		            printPlayerCards();
		            break;
		        case "3":
		        	automateMains();
		            printWinner();
		            return;
		        default:
		        	System.err.println("Votre choix n'est pas valide");
	        }
		}
	}
	
	private static void playMain() {
		main++;
		System.out.println("Main " + main);
		
		Card maxCard = null;
		Player winner = null;
		boolean equality = false;
		

        for (Player player : players) {
            Card card = player.playCard();
            System.out.println(player.getName() + " joue : " + card);
            if (card == null) continue;
            if (maxCard == null || card.getValue().compareTo(maxCard.getValue()) > 0) {
                maxCard = card;
                winner = player;
                equality = false;
            } else if (card.getValue().compareTo(maxCard.getValue()) == 0) {
                equality = true;
            }
        }
        
        if (equality) {
            System.out.println("Égalité détectée - duel à implémenter.");
        } else if (winner != null) {
            winner.incrementScore();
            System.out.println(winner.getName() + " remporte la manche.");
        }
	}
	
	public static void printPlayerCards() {
		players.forEach(player -> player.printCards());
	}
	
	private static void automateMains() {
		while (!isFinish()) {
            playMain();
        }
	}
	
	private static boolean isFinish() {
		return main >= 13;
	}

	private static void printWinner() {
		Player winner = null;
        int maxScore = -1;
        for (Player player : players) {
            if (player.getSore() > maxScore) {
                winner = player;
                maxScore = player.getSore();
            }
        }
        System.out.println("Le vainqueur est " + winner.getName() + " avec " + winner.getSore() + " points.");
	}
}
