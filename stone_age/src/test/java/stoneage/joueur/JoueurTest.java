package stoneage.joueur;

import org.junit.jupiter.api.Test;
import stoneage.joueur.Joueur;
import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Ressource;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void nourrir() {
        Inventaire inventaire = new Inventaire();
        Joueur joueur = new Joueur();
        int nbRessourceInitial;
        int nbOuvrierANourrir = inventaire.getNbOuvrierTotal();
        int nbRessourceRestant;


        /* On recupere le nombre initial de nourriture dans l'inventaire*/
        nbRessourceInitial = inventaire.getNbNourriture();

        /* On execute la méthode nourrir qui nourrit les ouvriers avec la ressource passée en paramètre ici la nourriture*/
        joueur.nourrir(inventaire, Ressource.NOURRITURE);

        /* Le nombre de nourriture restant qu'on est censé obtenir*/
        nbRessourceRestant = nbRessourceInitial -nbOuvrierANourrir;
        /* Le test*/
        assertEquals(nbRessourceRestant, inventaire.getNbNourriture());


        /* Test 2*/
        inventaire.setNbPierre(10);
        /* On recupere le nombre initial de pierre dans l'inventaire*/
        nbRessourceInitial = inventaire.getNbPierre();

        /* On execute la méthode nourrir qui nourrit les ouvriers avec la ressource passée en paramètre*/
        joueur.nourrir(inventaire, Ressource.PIERRE);

        /* Le nombre de pierre restant qu'on est censé obtenir*/
        nbRessourceRestant = nbRessourceInitial - nbOuvrierANourrir;

        /* Le test*/
        assertEquals(nbRessourceRestant, inventaire.getNbPierre());

        /* Test 3*/
        inventaire.setNbPierre(0);
        /* On recupere le nombre initial de pierre dans l'inventaire*/
        nbRessourceInitial = inventaire.getNbPierre();

        /* On execute la méthode nourrir qui nourrit les ouvriers avec la ressource passée en paramètre*/
        joueur.nourrir(inventaire, Ressource.PIERRE);

        /* Le nombre de pierre restant qu'on est censé obtenir*/
        nbRessourceRestant = nbRessourceInitial - nbOuvrierANourrir;

        /* Le test*/
        assertEquals(nbRessourceRestant, inventaire.getNbPierre());
    }
}