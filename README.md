# Projet: Playingcard
Un jeu console Java permettant de simuler un jeu de cartes entre plusieurs joueurs.

## Installation

1. Assurez-vous d’avoir Java 17 ou plus.
2. Ouvrez ce projet dans un IDE Java (IntelliJ, Eclipse, etc.).
3. Compilez et exécutez la classe `Main`.
4. Utilisez les menus pour interagir avec le jeu

## Fonctionnalités
- Création d’un jeu de 52 cartes (13 valeurs × 4 couleurs).
- Mélange des cartes.
- Distribution automatique entre les joueurs.
- Tour par tour avec score.

## Analyse du point C - Égalité

### Problèmes :
- Si deux cartes de même valeur sont jouées, il faut rejouer un duel.
- Il peut y avoir une boucle infinie si les égalités persistent.
- Les joueurs pourraient ne plus avoir de cartes.

### Solutions proposées :
1. Empiler les cartes en duel, tirer une nouvelle carte jusqu’à décision.
2. Gérer le cas où un joueur n’a plus de cartes.
3. Donner toutes les cartes jouées au gagnant du duel.

## Auteur
KONAN Kouakou Marc Gildas