package stoneage.partie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stoneage.plateaudejeu.Plateau;

import static org.junit.jupiter.api.Assertions.*;

class PartieTest {

    Partie partie;
    Plateau plateau;
    int [] tab;

    @BeforeEach
    void setUp() {

        tab= new int []{2,4,6,8,10,1,3,5,7,9};
        partie = new Partie(3,false);
        plateau= new Plateau(3);
        partie.jouer();

    }

    @Test
    void resultat() {
        partie.resultat(plateau.getListeInventaire());
        assertTrue(partie.getScore().length>0);
        assertTrue(partie.getScore().length==plateau.getListeInventaire().size());
    }

    @Test
    void egalite() {
        int nbEgalite=partie.egalite(tab,partie.indexGagnant(tab));
        assertEquals(0,nbEgalite);

    }


    @Test
    void indexGagnant() {
        int gagnant=partie.indexGagnant(tab);
        assertEquals(5,gagnant+1);
    }
}