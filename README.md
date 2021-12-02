# projetinfo-2019-stoneage-sak

## projetinfo-2019-stoneage-sak created by GitHub Classroom PROJET :

## Participant :
| *Nom et Prenom* | *Pseudo* |
| ------ | ------ |
| Baroudi Aymen | Jaguar 16 |
| Benabdelkrim Mohamed | Mohamed0002 |
| Belhassen Louay | mohamedlouay |
| Elarays Said | Elarays |
| Mazy Mohamed | Mohamed06000 |



---
___

### *Iteration 1*  : 
> Initialisation des données et création de deux joueurs.
>
> 1 seul ouvrier par joueur.
>
> Création d'une seule zone. (Qui nous donne une "ressource")
>
> Un Compteur de point par joueur.
>
> 1 ressource = 1 point.
>
> 1 Seul Tour, le joueur gagnant est celui qui possède un max de point (ie un max de ressource)
>
> 1 tour = 2 phase uniquement : Placement, Récupération (des ressources).
>
> Le jeu s'arrête au bout d'un tour. Le gagnant est celui qui a le plus de ressources.
>

---
___

### *Iteration 2* : 
> On ajoute la nourriture dans la réserve des joueurs, un multiplicateur d'obtention de nourriture.
>		
> On distingue 2 zones : 
>    - 1 zone ressource fait gagner une "ressource", 
>    - 1 zone village fait gagner un ouvrier,
>
> On ajoute la Phase Nourrir dans le tour, 1 Nourriture par ouvrier.
>
> Le jeu s'arrête quand il n'y a plus de ressource. Le gagnant est celui qui a le plus de ressources.
>

---
___
### *Iteration 3* :
> Spécifications des Zones : 
>  - Chasse; fait gagner X Nourriture,
>  - Fôret -----> X bois
>  - Champ ----> incrémente le multiplicateur de nourriture
>    
>  X est donnée par le(s) lancé de dé et les formule données par les règles du jeu.
>
>  Mise à jour du contenu de la réserve. (par l'ajout des différentes ressources)
>
> Le jeu s'arrête dès qu'un joueur arrive à au moins 30 points à la fin d'un tour.
>- Gagnant ---> max de points
>
> Mise en place d'une IA Basique.

---
___
### *Iteration 4* : 


> Refactorisation de code. ( la conception du projet change ! )
>
> Ajout de Carte, uniquement les civilisations. (10 même carte, +3 pts au compteur / 2 nbr nourriture)
>
> Mise à jour du système de comptage des points, élements de la réserve du joueur.
>
> Possibilité d'ajouter des joueurs.
>
>

---
___

### *Iteration 5* : 
> Refactory implementation des zones ressources. 
>
> Refactory implementation des zones villages. 
>
> Refactory implementation Zone Carte Ressource. 
>
> Gerer les contraintes de placements pour 4 joueurs. 
>
> Adapter nbOuvriers en fonction du choix de Zone et non plus l'inverse.
>
> A la fin de chaque tour, le firstPlayer change.
>
> Verifier la validité du choixZone.
>
> Amelioration IA.
>
> Modifier les calculs de points pour l’égalité.
>
> 

---
___
	
### *Iteration 6* : 

> Ajout des Cartes dans les Zones de placement disponible.
> 
> Ajout des Outils dans le systeme de comptage des points.
>
> Ajout du 2ème type de carte, carte Batiment (10 fois la même).
>
> Amélioration de l'IA.
>
> Le joueur peut avoir le choix de ne pas choisir de nourrir tous ses ouvriers.
>
> Le jeu s'arrête quand il n'y a plus de carte Civilisations (le tour s'arrête) ou Batiments.
> Spécifications des cartes Civilisations 
> - bon nbr de carte
> - Haut de carte : Différents bonus; Bas de carte : différents multiplicateur (selon les règles).
>
> Le jeu s'arrête quand il n'y a moins de 4 cartes civilisations ou l'une des piles batiments est vide

---
___

### *Iteration 7* :

>Spécifications des cartes Civilisations et Batiments. 
> - bon nbr de carte selon les règles, au moins 10 cartes différentes de chaques
>
> Améliorations de l'IA.
>
> Mise à jour du système de comptage des points.
>
> Simulation sur 10 parti.
>
> Le jeu s'arrête quand il n'y a plus de carte Civilisations (le tour s'arrête) ou Batiments.
>
> Compléter les cartes.
>
> Simulations 500 partie.
>
> Traitement des Statistiques.
---
___

	



