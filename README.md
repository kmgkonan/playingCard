# Projet: Playingcard
Un jeu console Java permettant de simuler un jeu de cartes entre plusieurs joueurs.

## 1. Installation
### Prérequis
- Java JDK 17 (ou version ultérieure)

- Un IDE Java (IntelliJ, Eclipse, VS Code) ou simplement la ligne de commande

### Étapes d'installation et d'exécution
 1. Compilez et exécutez la classe Main.
 2. Le menu principal s’affiche et vous pouvez interagir avec l’application.

## 2. Fonctionnalités
### Menu principal
- Afficher les cartes : montre les 52 cartes dans l’ordre initial.
- Mélanger les cartes : mélange aléatoirement les cartes.
- Commencer la partie : demande le nombre de joueurs et distribue les cartes équitablement.
 
### Menu jeu
- Main suivante : chaque joueur tire une carte, la plus forte remporte les cartes du tour.
- Afficher la distribution : affiche combien de cartes chaque joueur possède.
- Automatiser les mains jusqu’à la fin : fait jouer automatiquement toutes les manches jusqu’à la victoire d’un joueur.
 
### Condition de victoire
Le jeu s’arrête lorsqu’un joueur détient les 52 cartes. Le vainqueur est affiché.


## 3. Gestion des égalités (point C du test)
### Problème
Lorsqu’une égalité survient (par ex. Joueur 1 et Joueur 2 posent tous deux un Roi), la règle de la bataille impose un duel :
 - Chaque joueur impliqué doit rejouer une carte face
 - Le gagnant de ce duel prend toutes les cartes posées.

### Difficultés possibles
 1. Un joueur n’a plus assez de cartes pour continuer le duel
 2. Égalités successives : le duel peut générer un nouvel ex aequo, ce qui prolonge la bataille.
 
### Solutions proposées
 1. Solution 1 (implémentation simplifiée) : déclarer match nul dans ce cas, et les cartes sont retirées du jeu.
 2. Solution 2 (fidèle aux règles classiques) :
    - Si un joueur n’a pas assez de cartes, il est automatiquement éliminé et perd toutes ses cartes.
    - En cas d’égalités successives, répéter le duel jusqu’à ce qu’il y ait un vainqueur ou que tous sauf un soient éliminés.

## Auteur
KONAN Kouakou Marc Gildas